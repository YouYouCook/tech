package cn.krt.zbcg.system.web.action;

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
import cn.krt.zbcg.commons.bo.system.ShqdBO;
import cn.krt.zbcg.commons.bo.system.ShqdheadBO;
import cn.krt.zbcg.commons.bo.system.ZhaobiaojinduBO;
import cn.krt.zbcg.system.services.IMedicineServices;
import cn.krt.zbcg.system.services.IShqdHeadServices;
import cn.krt.zbcg.system.services.IShqdServices;
import cn.krt.zbcg.system.web.form.ShqdForm;
import cn.krt.zbcg.system.web.form.ShqdHeadForm;

public class ShqdHeadAction  extends SSIDispatchAction{

	private IShqdHeadServices iShqheadService;
	
	public IShqdHeadServices getiShqheadService() {
		
		if (this.iShqheadService == null) {
			this.iShqheadService = ((IShqdHeadServices) getBean("iShqHeadService"));
		}
		return this.iShqheadService;
	}

	public void setiShqheadService(IShqdHeadServices iShqheadService) {
		this.iShqheadService = iShqheadService;
	}

	private  IShqdServices iShqService;
	public IShqdServices getiShqService() {
		if (this.iShqService == null) {
			this.iShqService = ((IShqdServices) getBean("iShqService"));
		}
		return this.iShqService;
	}

	public void setiShqService(IShqdServices iShqService) {
		this.iShqService = iShqService;
	}
	
	
	private void writeShqd(HSSFWorkbook wb,ShqdheadBO shqdhead , List list){
		if(list==null ||list.size()==0){
			return ;
		}
		
		HSSFSheet sheet = wb.getSheet("sheet1");
		if(shqdhead!=null){
			if(shqdhead.getCustomerBO()!=null)
			ExcelReportUtil.setSheetCellValue(sheet,3,0,"供货单位："+shqdhead.getCustomerBO().getName(),Cell.CELL_TYPE_STRING);
			if(shqdhead.getFhrq()!=null)
			ExcelReportUtil.setSheetCellValue(sheet,3,5,"发货日期："+shqdhead.getFhrq(),Cell.CELL_TYPE_STRING);
			ExcelReportUtil.setSheetCellValue(sheet,4,0,"运输方式:"+shqdhead.getYsfs()+"     联系电话："+ shqdhead.getLxdh(),Cell.CELL_TYPE_STRING);
			if(shqdhead.getShr()!=null)
			ExcelReportUtil.setSheetCellValue(sheet,4,5,"送货人:"+shqdhead.getShr(),Cell.CELL_TYPE_STRING);
			if(shqdhead.getShdw()!=null)
			ExcelReportUtil.setSheetCellValue(sheet,5,0,"收货单位:"+shqdhead.getShdw(),Cell.CELL_TYPE_STRING);
			if(shqdhead.getChepaihao()!=null)
			ExcelReportUtil.setSheetCellValue(sheet,5,5,"车牌号:"+shqdhead.getChepaihao(),Cell.CELL_TYPE_STRING);
		}
		
		int starRow = 7;
		ExcelReportUtil.insertToRow(sheet,7,list.size()-4);
	     for(int i=0;i<list.size();i++){
	    	 ShqdBO  bo = (ShqdBO) list.get(i);
	    	 if(bo==null) continue;
	    	 if(bo.getMedicineBO()!=null)
	    	 ExcelReportUtil.setSheetCellValue(sheet,starRow,0,bo.getMedicineBO().getMedicineName(),Cell.CELL_TYPE_STRING);
	    	 ExcelReportUtil.setSheetCellValue(sheet,starRow,1,bo.getGuige(),Cell.CELL_TYPE_STRING);
	    	 ExcelReportUtil.setSheetCellValue(sheet,starRow,2,bo.getJianshu(),Cell.CELL_TYPE_STRING);
	    	 ExcelReportUtil.setSheetCellValue(sheet,starRow,3,bo.getLaihuoshuliang(),Cell.CELL_TYPE_STRING);
	    	 ExcelReportUtil.setSheetCellValue(sheet,starRow,4,bo.getShishoushuliang(),Cell.CELL_TYPE_STRING);
	    	 ExcelReportUtil.setSheetCellValue(sheet,starRow,5,bo.getChandi(),Cell.CELL_TYPE_STRING);
	    	 ExcelReportUtil.setSheetCellValue(sheet,starRow,6,bo.getBeizhu(),Cell.CELL_TYPE_STRING);
	    	 starRow++;
	     }

	}
	public ActionForward excelReport(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ShqdHeadForm shqdHeadForm = (ShqdHeadForm) form;
		PageInfo pageInfo = new PageInfo();
		PageInfo pageInfo2 = new PageInfo();
		getiShqheadService().setRequest(request);
		Map map = Operate.describe(shqdHeadForm);
		if(shqdHeadForm.getSelectNos_shqdHead()!=null &&shqdHeadForm.getSelectNos_shqdHead().length>0){
			
			String headId = shqdHeadForm.getSelectNos_shqdHead()[0];
			Map map2 = new HashMap();
			map2.put("shqdheadid", headId);
			ShqdheadBO shqheadbo = getiShqheadService().findById(Integer.parseInt(headId));
			List shqdlist = getiShqService().findAll(pageInfo2, map2);
			request.setAttribute("shqdlist", shqdlist);
			response.setContentType(ExcelReportUtil.CONTENT_TYPE);
			response.reset();
			String template = "shqd2.xls";
			String outPutname = "送货清单.xls";
			ExcelReportUtil.setResponseHeader(response, outPutname);
			String filePath = request.getSession().getServletContext()
					.getRealPath("")
					+ "/uploadfiles/reports/" + template;
			try {
				HSSFWorkbook wb = ExcelReportUtil.getWb(filePath);
				writeShqd(wb,shqheadbo,shqdlist);
				ExcelReportUtil.writeToResponse(wb,response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	
	public ActionForward list(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ShqdHeadForm shqdHeadForm = (ShqdHeadForm) form;
		PageInfo pageInfo = new PageInfo();
		PageInfo pageInfo2 = new PageInfo();
		getiShqheadService().setRequest(request);
		Map map = Operate.describe(shqdHeadForm);
		if(shqdHeadForm.getSelectNos_shqdHead()!=null &&shqdHeadForm.getSelectNos_shqdHead().length>0){
			
			String headId = shqdHeadForm.getSelectNos_shqdHead()[0];
			request.setAttribute("selectid", headId);
			Map map2 = new HashMap();
			map2.put("shqdheadid", headId);
			//map.put("id", headId);
			List shqdlist = getiShqService().findAll(pageInfo2, map2);
			request.setAttribute("shqdlist", shqdlist);
		}
		List ishqList = getiShqheadService().findAll(pageInfo, map);
		
		request.setAttribute("shqdheadlist", ishqList);
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("pageInfo2", pageInfo2);
		return mapping.findForward("shqdheadlist");
	}
	
	
	public ActionForward toDelete(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ShqdHeadForm shqdHeadForm = (ShqdHeadForm) form;
		String[] ids = shqdHeadForm.getSelectNos_shqdHead();
		try {
			getiShqheadService().delete(ids);
		} catch (Exception localException) {
		}
		return list(mapping, form, request, response);
	}
	
	public ActionForward toDeleteShqd(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ShqdHeadForm shqdHeadForm = (ShqdHeadForm) form;
		String[] ids = shqdHeadForm.getSelectNos();
		try {
			getiShqService().delete(ids);
		} catch (Exception localException) {
		}
		return list(mapping, form, request, response);
	}
	
	public ActionForward addShqd(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ShqdHeadForm shqdHeadForm = (ShqdHeadForm) form;
		ShqdBO ShqdBO = new ShqdBO();
		ShqdBO.setPinzhongid(shqdHeadForm.getPinzhongid());
		ShqdBO.setBeizhu(shqdHeadForm.getBeizhu());
		ShqdBO.setChandi(shqdHeadForm.getChandi());
		ShqdBO.setGuige(shqdHeadForm.getGuige());
		ShqdBO.setJianshu(shqdHeadForm.getJianshu());
		ShqdBO.setLaihuoshuliang(shqdHeadForm.getLaihuoshuliang());
		ShqdBO.setShishoushuliang(shqdHeadForm.getShishoushuliang());
		ShqdBO.setShqdheadid(shqdHeadForm.getSelectNos_shqdHead()[0]);
		try {
			getiShqService().insert(ShqdBO);
			request.setAttribute("exception.message", "增加成功！");
		} catch (Exception e) {
			request.setAttribute("exception.message", "添加失败");
			ExceptionUtils.getFullStackTrace(e);
			   e.printStackTrace();
		}
		return list(mapping,form,request,response);
	}
	public ActionForward add(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ShqdHeadForm shqdHeadForm = (ShqdHeadForm) form;
		ShqdheadBO ShqdBO = new ShqdheadBO();
		ShqdBO.setChepaihao(shqdHeadForm.getChepaihao());
		ShqdBO.setFhrq(shqdHeadForm.getFhrq());
		ShqdBO.setLxdh(shqdHeadForm.getLxdh());
		ShqdBO.setShdw(shqdHeadForm.getShdw());
		ShqdBO.setShr(shqdHeadForm.getShr());
		ShqdBO.setSupplyid(shqdHeadForm.getSupplyid());
		ShqdBO.setYsfs(shqdHeadForm.getYsfs());
		
		PageInfo pageInfo = new PageInfo();
		try {
			getiShqheadService().insert(ShqdBO);
			List ishqList = getiShqheadService().findAll(pageInfo);
			request.setAttribute("shqdheadlist", ishqList);
			request.setAttribute("pageInfo", pageInfo);
			request.setAttribute("exception.message", "增加成功！");
		} catch (Exception e) {
			request.setAttribute("exception.message", "添加失败");
			ExceptionUtils.getFullStackTrace(e);
			   e.printStackTrace();
		}
		return 		mapping.findForward("shqdheadlist");
	}
}
