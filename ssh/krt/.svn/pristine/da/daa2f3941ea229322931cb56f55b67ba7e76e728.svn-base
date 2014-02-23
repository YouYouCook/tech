package cn.krt.zbcg.system.web.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.ssi.common.Operate;
import org.ssi.common.PageInfo;
import org.ssi.struts.action.SSIDispatchAction;

import cn.krt.zbcg.commons.bo.system.CustomerBO;
import cn.krt.zbcg.commons.bo.system.MedicineBO;
import cn.krt.zbcg.commons.bo.system.ShqdBO;
import cn.krt.zbcg.commons.bo.system.UserBO;
import cn.krt.zbcg.system.services.ICustomerServices;
import cn.krt.zbcg.system.services.IMedicineServices;
import cn.krt.zbcg.system.services.IShqdServices;
import cn.krt.zbcg.system.web.form.ShqdForm;
import cn.krt.zbcg.system.web.form.UserForm;

public class ShqdAction  extends SSIDispatchAction{
	IShqdServices iShqService;
	private ICustomerServices customerServices;
	private ICustomerServices getCustomerServices() {
		if (this.customerServices == null) {
			this.customerServices = ((ICustomerServices) getBean("customerServices"));
		}
		return this.customerServices;
	}
	public void setCustomerServices(ICustomerServices customerServices) {
		this.customerServices = customerServices;
	}
	public IShqdServices getiShqService() {
		if (this.iShqService == null) {
			this.iShqService = ((IShqdServices) getBean("iShqService"));
		}
		return this.iShqService;
	}
	private IMedicineServices medicineServices;
	private IMedicineServices getMedicineServices() {
		if (this.medicineServices == null) {
			this.medicineServices = ((IMedicineServices) getBean("medicineServices"));
		}
		return this.medicineServices;
	}
	public void setiShqService(IShqdServices iShqService) {
		this.iShqService = iShqService;
	}

	public void setMedicineServices(IMedicineServices medicineServices) {
		this.medicineServices = medicineServices;
	}
	public ActionForward list(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ShqdForm shqdForm = (ShqdForm) form;
		PageInfo pageInfo = new PageInfo();
		getiShqService().setRequest(request);
		Map map = Operate.describe(shqdForm);
		List ishqList = getiShqService().findAll(pageInfo, map);
		request.setAttribute("shqdlist", ishqList);
		request.setAttribute("pageInfo", pageInfo);
		return mapping.findForward("shqdlist");
	}

	public ActionForward toDelete(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ShqdForm shqdForm = (ShqdForm) form;
		String[] ids = shqdForm.getSelectNos();
		try {
			getiShqService().delete(ids);
		} catch (Exception localException) {
		}
		return list(mapping, form, request, response);
	}
	
	public ActionForward toUpdate(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
		    throws Exception
		  {
			ShqdForm shqdForm = (ShqdForm) form;
		    String ids = shqdForm.getSelectNos()[0];
		    String[] a = ids.split(",");
		    String id = a[0].trim();
		    ShqdBO ShqdBO = getiShqService().findById(Integer.valueOf(Integer.parseInt(id)));
			CustomerBO custom = null;
			MedicineBO medicine = null;
//			if (ShqdBO.getSupplyid() == null) {
//					custom = new CustomerBO();
//			} else {
//				int supplyid = ShqdBO.getSupplyid();
//				custom = getCustomerServices().findById(supplyid);
//		   }
		   if(ShqdBO.getPinzhongid()==null){
			   medicine  = new MedicineBO();
		   }else{
			    int pinzhongid =  ShqdBO.getPinzhongid();
			     medicine =  getMedicineServices().findById(pinzhongid);
		   }
		    request.setAttribute("custom", custom);
		    request.setAttribute("medicine", medicine);
		    request.setAttribute("ShqdBO", ShqdBO);
		    return mapping.findForward("toUpdate");
		  }

		  public ActionForward update(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
		    throws Exception
		  {
			ShqdForm shqdForm = (ShqdForm) form;
			ShqdBO ShqdBO = shqdForm.getShqdBO();
		    try {
		    	 getiShqService().update(ShqdBO);
		    } catch (Exception e) {
		      ExceptionUtils.getFullStackTrace(e);
		      e.printStackTrace();
		    }
		    request.setAttribute("exception.message", "修改信息成功！");
		    return list(mapping, form, request, response);
		  }
	
	public ActionForward toAdd(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return mapping.findForward("toAdd");
	}

	public ActionForward add(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ShqdForm shqdForm = (ShqdForm) form;
		ShqdBO ShqdBO = shqdForm.getShqdBO();
		try {
			getiShqService().insert(ShqdBO);
			request.setAttribute("exception.message", "增加成功！");
		} catch (Exception e) {
			request.setAttribute("exception.message", "添加失败");
			ExceptionUtils.getFullStackTrace(e);
			   e.printStackTrace();
		}
		return list(mapping, form, request, response);
	}
	

}
