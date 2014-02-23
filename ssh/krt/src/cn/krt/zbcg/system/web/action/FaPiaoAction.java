package cn.krt.zbcg.system.web.action;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.ssi.common.Operate;
import org.ssi.common.PageInfo;
import org.ssi.struts.action.SSIDispatchAction;

import cn.id5.util.ExcelReportUtil;
import cn.krt.zbcg.commons.bo.system.FapiaoinfoBO;
import cn.krt.zbcg.commons.bo.system.ShqdBO;
import cn.krt.zbcg.commons.bo.system.ShqdheadBO;
import cn.krt.zbcg.system.services.IFaPiaoServices;
import cn.krt.zbcg.system.web.form.FapiaoForm;
import cn.krt.zbcg.system.web.form.FukuanForm;
import cn.krt.zbcg.system.web.form.ShqdHeadForm;

public class FaPiaoAction extends SSIDispatchAction{
	
	IFaPiaoServices fapiaoServices;
	public IFaPiaoServices getFapiaoServices() {
		if (this.fapiaoServices == null) {
			this.fapiaoServices = ((IFaPiaoServices) getBean("fapiaoServices"));
		}
		return this.fapiaoServices;
	}
	public void setFapiaoServices(IFaPiaoServices fapiaoServices) {
		this.fapiaoServices = fapiaoServices;
	}
	public ActionForward toAdd(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return mapping.findForward("toAdd");
	}
	
	public ActionForward add(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		FapiaoForm fapiaoForm = (FapiaoForm) form;
		FapiaoinfoBO fapiaoInfoBo = fapiaoForm.getFapiaoInfoBo();
		try {
			getFapiaoServices().insert(fapiaoInfoBo);
			request.setAttribute("exception.message", "增加成功！");
		} catch (Exception e) {
			request.setAttribute("exception.message", "添加失败");
			ExceptionUtils.getFullStackTrace(e);
			   e.printStackTrace();
		}
		return list(mapping, form, request, response);
	}
	
	public ActionForward toUpdate(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
		    throws Exception
		  {
			FapiaoForm fapiaoForm = (FapiaoForm) form;
		    String ids = fapiaoForm.getSelectNos()[0];
		    String[] a = ids.split(",");
		    String id = a[0].trim();
			FapiaoinfoBO fapiaoInfoBo = getFapiaoServices().findById(Integer.valueOf(Integer.parseInt(id)));
		    request.setAttribute("fapiaoInfoBo", fapiaoInfoBo);
		    return mapping.findForward("toUpdate");
	}
	
	public ActionForward update(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		FapiaoForm fapiaoForm = (FapiaoForm) form;
		FapiaoinfoBO fapiaoInfoBo = fapiaoForm.getFapiaoInfoBo();
		try {
			getFapiaoServices().update(fapiaoInfoBo);
		} catch (Exception e) {
			ExceptionUtils.getFullStackTrace(e);
			e.printStackTrace();
		}
		request.setAttribute("exception.message", "修改信息成功！");
		return list(mapping, form, request, response);
	}
	private void writeShqd(HSSFWorkbook wb, List list){
		if(list==null ||list.size()==0){
			return ;
		}
		HSSFSheet sheet = wb.getSheet("sheet1");
		//ExcelReportUtil.insertToRow(sheet,0,list.size()+1);
		ExcelReportUtil.setSheetCellValue(sheet,0,0,"接收日期",Cell.CELL_TYPE_STRING);
		ExcelReportUtil.setSheetCellValue(sheet,0,1,"供货商",Cell.CELL_TYPE_STRING);
		ExcelReportUtil.setSheetCellValue(sheet,0,2,"发票号",Cell.CELL_TYPE_STRING);
		ExcelReportUtil.setSheetCellValue(sheet,0,3,"开票价格",Cell.CELL_TYPE_STRING);
		ExcelReportUtil.setSheetCellValue(sheet,0,4,"开票日期",Cell.CELL_TYPE_STRING);
		ExcelReportUtil.setSheetCellValue(sheet,0,5,"票面信息",Cell.CELL_TYPE_STRING);
		ExcelReportUtil.setSheetCellValue(sheet,0,6,"备注",Cell.CELL_TYPE_STRING);
		int starRow = 1;
	     for(int i=0;i<list.size();i++){
	    	 FapiaoinfoBO  bo = (FapiaoinfoBO) list.get(i);
	    	 if(bo==null) continue;
	    	 ExcelReportUtil.setSheetCellValue(sheet,starRow,0,bo.getJieshouriqi(),Cell.CELL_TYPE_STRING);
	    	 ExcelReportUtil.setSheetCellValue(sheet,starRow,1,bo.getGongyingshang(),Cell.CELL_TYPE_STRING);
	    	 ExcelReportUtil.setSheetCellValue(sheet,starRow,2,bo.getFapiaohao(),Cell.CELL_TYPE_STRING);
	    	 ExcelReportUtil.setSheetCellValue(sheet,starRow,3,bo.getKaipiaojiage(),Cell.CELL_TYPE_STRING);
	    	 ExcelReportUtil.setSheetCellValue(sheet,starRow,4,bo.getKaipiaoriqi(),Cell.CELL_TYPE_STRING);
	    	 ExcelReportUtil.setSheetCellValue(sheet,starRow,5,bo.getPiaomianxinxi(),Cell.CELL_TYPE_STRING);
	    	 ExcelReportUtil.setSheetCellValue(sheet,starRow,6,bo.getBeizhu(),Cell.CELL_TYPE_STRING);
	    	 starRow++;
	     }
	}
	public ActionForward excelreport(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		FapiaoForm fapiaoForm = (FapiaoForm) form;
		PageInfo pageInfo = new PageInfo();
		list(mapping,form,request,response);
		Map map = Operate.describe(fapiaoForm);
			
			List list = (List) request.getAttribute("fapiaoList");
			response.setContentType(ExcelReportUtil.CONTENT_TYPE);
			response.reset();
			String template = "blank.xls";
			String outPutname = "发票导出.xls";
			ExcelReportUtil.setResponseHeader(response, outPutname);
			String filePath = request.getSession().getServletContext()
					.getRealPath("")
					+ "/uploadfiles/reports/" + template;
			try {
				HSSFWorkbook wb = ExcelReportUtil.getWb(filePath);
				writeShqd(wb,list);
				ExcelReportUtil.writeToResponse(wb,response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		return null;
	}
	public ActionForward toDelete(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		FapiaoForm fapiaoForm = (FapiaoForm) form;
		String[] ids = fapiaoForm.getSelectNos();
		try {
			getFapiaoServices().delete(ids);
		} catch (Exception localException) {
		}
		return list(mapping, form, request, response);
	}
	public ActionForward list(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		FapiaoForm fapiaoForm = (FapiaoForm) form;
		PageInfo pageInfo = new PageInfo();
		FapiaoinfoBO fapiaoInfoBo = fapiaoForm.getFapiaoInfoBo();
		getFapiaoServices().setRequest(request);
		Map map = Operate.describe(fapiaoForm);
		String gongyingshang = fapiaoInfoBo.getGongyingshang();
		String fapiaohao = fapiaoInfoBo.getFapiaohao();
		String piaomianxinxi =  fapiaoInfoBo.getPiaomianxinxi();
		Date kaipiaoriqi = fapiaoInfoBo.getKaipiaoriqi();
		map.put("gongyingshang", gongyingshang);
		map.put("fapiaohao", fapiaohao);
		map.put("piaomianxinxi", piaomianxinxi);
		map.put("kaipiaoriqi", kaipiaoriqi);
		
		request.setAttribute("gongyingshang", gongyingshang);
		request.setAttribute("fapiaohao", fapiaohao);
		request.setAttribute("piaomianxinxi", piaomianxinxi);
		request.setAttribute("kaipiaoriqi", kaipiaoriqi);
		
		
		List fapiaoList = getFapiaoServices().findAll(pageInfo, map);
		request.setAttribute("fapiaoList", fapiaoList);
		request.setAttribute("pageInfo", pageInfo);
		return mapping.findForward("fapiaoList");
	}
	
	 public ActionForward windowlist(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
		     throws Exception	   {
	
			FapiaoForm fapiaoForm = (FapiaoForm) form;
			PageInfo pageInfo = new PageInfo();
			getFapiaoServices().setRequest(request);
			Map map = Operate.describe(fapiaoForm);
			List fapiaoList = getFapiaoServices().findAll(pageInfo, map);
			request.setAttribute("fapiaoList", fapiaoList);
			request.setAttribute("pageInfo", pageInfo);
			return mapping.findForward("fapiaoWindowList");
}
}
