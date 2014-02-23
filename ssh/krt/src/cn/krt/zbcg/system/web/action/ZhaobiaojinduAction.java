package cn.krt.zbcg.system.web.action;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import javax.mail.Session;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.ssi.common.Operate;
import org.ssi.common.PageInfo;
import org.ssi.struts.action.SSIDispatchAction;

import cn.krt.zbcg.commons.bo.system.MedicineZbBO;
import cn.krt.zbcg.commons.bo.system.ZhaobiaojinduBO;
import cn.krt.zbcg.system.services.IMedicineZbServices;
import cn.krt.zbcg.system.services.IZhaobiaojinduServices;
import cn.krt.zbcg.system.web.form.ZhaobiaojinduForm;

public class ZhaobiaojinduAction extends SSIDispatchAction {


	   private IMedicineZbServices getCineZbServices() {
		     if (this.cineZbServices == null) {
		       this.cineZbServices = ((IMedicineZbServices)getBean("cineZbServices"));
		     }
		     return this.cineZbServices;
		   }
	public void setZhaobiaojinduServices(
			IZhaobiaojinduServices zhaobiaojinduServices) {
		this.zhaobiaojinduServices = zhaobiaojinduServices;
	}
	public IZhaobiaojinduServices getZhaobiaojinduServices() {
		if (this.zhaobiaojinduServices == null) {
			this.zhaobiaojinduServices = ((IZhaobiaojinduServices) getBean("zhaobiaojinduServices"));
		}
		return this.zhaobiaojinduServices;
	}
	private IMedicineZbServices cineZbServices;
	IZhaobiaojinduServices zhaobiaojinduServices;

	public ActionForward toAdd(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ZhaobiaojinduForm zhaobiaoForm = (ZhaobiaojinduForm) form;
		if(zhaobiaoForm.getMedicineZbid()!=null && !zhaobiaoForm.getMedicineZbid().equals("")){
			
			MedicineZbBO medicindezbBO = getCineZbServices().findById(Integer.parseInt(zhaobiaoForm.getMedicineZbid()));
			double summarymoney = medicindezbBO.getMedicineJbBO().getMedicineCgBO().getCgQty()*medicindezbBO.getMedicineJbBO().getPrice();
			String zhibaojin = "";
			if(summarymoney>=300000){
				zhibaojin = "30000";
			}else{
				 java.text.DecimalFormat   df=new   java.text.DecimalFormat("#.##");   
				zhibaojin = df.format(summarymoney*0.06);
			}
			request.setAttribute("zhibaojin", zhibaojin);
			request.setAttribute("medicindezbBO", medicindezbBO);
		}
		return mapping.findForward("toAdd");
	}

	public ActionForward add(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ZhaobiaojinduForm zhaobiaoForm = (ZhaobiaojinduForm) form;
		ZhaobiaojinduBO zhabiaobo = zhaobiaoForm.getZhaobiaojinduBo();
		zhabiaobo.setYingtuizhibaojin(zhabiaobo.getZhibaojin());
		try {
			getZhaobiaojinduServices().insert(zhabiaobo);
			request.setAttribute("exception.message", "增加成功！");
		} catch (Exception e) {
			request.setAttribute("exception.message", "添加失败");
			ExceptionUtils.getFullStackTrace(e);
			e.printStackTrace();
		}
		return list(mapping, form, request, response);
	}
	
	public ActionForward toUpdateZBJ(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ZhaobiaojinduForm zhaobiaoForm = (ZhaobiaojinduForm) form;
		String ids = zhaobiaoForm.getSelectNos()[0];
		String[] a = ids.split(",");
		String id = a[0].trim();
		ZhaobiaojinduBO zhaobiaojindubo = getZhaobiaojinduServices().findById(
				Integer.valueOf(Integer.parseInt(id)));
		request.setAttribute("zhaobiaojinduBo" , zhaobiaojindubo);
		return mapping.findForward("toUpdateZBJ");
	}
	
	public ActionForward toUpdate(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ZhaobiaojinduForm zhaobiaoForm = (ZhaobiaojinduForm) form;
		String ids = zhaobiaoForm.getSelectNos()[0];
		String[] a = ids.split(",");
		String id = a[0].trim();
		ZhaobiaojinduBO zhaobiaojindubo = getZhaobiaojinduServices().findById(
				Integer.valueOf(Integer.parseInt(id)));
		request.setAttribute("zhaobiaojinduBo" , zhaobiaojindubo);
		return mapping.findForward("toUpdate");
	}
	public ActionForward ZBJupdate(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ZhaobiaojinduForm zhaobiaoForm = (ZhaobiaojinduForm) form;
		ZhaobiaojinduBO zhabiaobo = zhaobiaoForm.getZhaobiaojinduBo();
		try {
			getZhaobiaojinduServices().update(zhabiaobo);
		} catch (Exception e) {
			ExceptionUtils.getFullStackTrace(e);
			e.printStackTrace();
		}
		request.setAttribute("exception.message", "修改信息成功！");
		return zhibaolist(mapping, form, request, response);
	}
	public ActionForward update(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ZhaobiaojinduForm zhaobiaoForm = (ZhaobiaojinduForm) form;
		ZhaobiaojinduBO zhabiaobo = zhaobiaoForm.getZhaobiaojinduBo();
		try {
			getZhaobiaojinduServices().update(zhabiaobo);
		} catch (Exception e) {
			ExceptionUtils.getFullStackTrace(e);
			e.printStackTrace();
		}
		request.setAttribute("exception.message", "修改信息成功！");
		return list(mapping, form, request, response);
	}

	public ActionForward toDelete(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ZhaobiaojinduForm zhaobiaoForm = (ZhaobiaojinduForm) form;
		String[] ids = zhaobiaoForm.getSelectNos();
		try {
			getZhaobiaojinduServices().delete(ids);
		} catch (Exception localException) {
		}
		return list(mapping, form, request, response);
	}

	public ActionForward list(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ZhaobiaojinduForm zhaobiaoForm = (ZhaobiaojinduForm) form;
		ZhaobiaojinduBO zhabiaobo = zhaobiaoForm.getZhaobiaojinduBo();
		PageInfo pageInfo = new PageInfo();
		getZhaobiaojinduServices().setRequest(request);
		Map map = Operate.describe(zhaobiaoForm);
		Date kaibiaoriqi  = zhabiaobo.getKaibiaoriqi();
		String gongyingshang = 	zhabiaobo.getGonghuoshang();
		Date zcjdhrq = zhabiaobo.getZcjdhrq();
		map.put("kaibiaoriqi", kaibiaoriqi);
	    map.put("gonghuoshang", gongyingshang);
	    map.put("zcjdhrq", zcjdhrq);
	    
		request.setAttribute("kaibiaoriqi", kaibiaoriqi);
		request.setAttribute("gonghuoshang", gongyingshang);
		request.setAttribute("zcjdhrq", zcjdhrq);
	    
		List zhaobiaoList = getZhaobiaojinduServices().findAll(pageInfo, map);
		request.getSession().setAttribute("zhaobiaoList", zhaobiaoList);
		request.setAttribute("zhaobiaoList", zhaobiaoList);
		request.setAttribute("pageInfo", pageInfo);
		return mapping.findForward("zhaobiaoList");
	}
	public ActionForward zhibaolist(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ZhaobiaojinduForm zhaobiaoForm = (ZhaobiaojinduForm) form;
		ZhaobiaojinduBO zhabiaobo = zhaobiaoForm.getZhaobiaojinduBo();
		PageInfo pageInfo = new PageInfo();
		getZhaobiaojinduServices().setRequest(request);
		Map map = Operate.describe(zhaobiaoForm);
		String pinzhongshuxing  = zhabiaobo.getPinzhongshuxing();
		String gongyingshang = 	zhabiaobo.getGonghuoshang();
		String pinming = zhabiaobo.getPinming();
		map.put("pinzhongshuxing", pinzhongshuxing);
	    map.put("gonghuoshang", gongyingshang);
	    map.put("pinming", pinming);
		request.setAttribute("pinzhongshuxing", pinzhongshuxing);
		request.setAttribute("gonghuoshang", gongyingshang);
		request.setAttribute("pinming", pinming);
		List zhaobiaoList = getZhaobiaojinduServices().findAll(pageInfo, map);
		request.setAttribute("zhaobiaoList", zhaobiaoList);
		request.setAttribute("pageInfo", pageInfo);
		return mapping.findForward("zhibaolist");
	}
	
	
	public ActionForward nofinishlist(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ZhaobiaojinduForm zhaobiaoForm = (ZhaobiaojinduForm) form;
		PageInfo pageInfo = new PageInfo();
		getZhaobiaojinduServices().setRequest(request);
		Map map = Operate.describe(zhaobiaoForm);
		List nofinishList = getZhaobiaojinduServices().findNoFininshDD(pageInfo);
		request.setAttribute("nofinishlist", nofinishList);
		request.setAttribute("pageInfo", pageInfo);
		return mapping.findForward("nofinishlist");
	}
}
