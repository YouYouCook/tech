/*     */ package cn.krt.zbcg.system.web.action;
/*     */ 
/*     */ import cn.krt.zbcg.commons.bo.system.CustomerBO;
/*     */ import cn.krt.zbcg.system.services.ICustomerServices;
/*     */ import cn.krt.zbcg.system.web.form.CustomerForm;
import cn.krt.zbcg.system.web.form.StorageForm;

/*     */ import java.io.PrintWriter;
/*     */ import java.util.List;
/*     */ import java.util.Map;

/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;

/*     */ import org.apache.commons.lang.exception.ExceptionUtils;
/*     */ import org.apache.struts.action.ActionForm;
/*     */ import org.apache.struts.action.ActionForward;
/*     */ import org.apache.struts.action.ActionMapping;
/*     */ import org.ssi.common.MD5;
/*     */ import org.ssi.common.Operate;
/*     */ import org.ssi.common.PageInfo;
/*     */ import org.ssi.struts.action.SSIDispatchAction;
/*     */ 
/*     */ public class CustomerAction extends SSIDispatchAction
/*     */ {
/*     */   private ICustomerServices customerServices;
/*     */ 
/*     */   private ICustomerServices getCustomerServices()
/*     */   {
/*  41 */     if (this.customerServices == null) {
/*  42 */       this.customerServices = ((ICustomerServices)getBean("customerServices"));
/*     */     }
/*  44 */     return this.customerServices;
/*     */   }
/*     */ 
/*     */   public ActionForward list(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */     throws Exception
/*     */   {
/*  54 */     CustomerForm omerForm = (CustomerForm)form;
/*  55 */     omerForm.setVip("");
/*  56 */     PageInfo pageInfo = new PageInfo();
/*  57 */     getCustomerServices().setRequest(request);
/*  58 */     Map map = Operate.describe(omerForm);
/*  59 */     List list = getCustomerServices().findAll(pageInfo, map);
/*  60 */     for (int i = 0; i < list.size(); i++) {
/*  61 */       CustomerBO customerBO = (CustomerBO)list.get(i);
/*  62 */       if ("1".equals(customerBO.getVip()))
/*  63 */         customerBO.setVip("是");
/*     */       else {
/*  65 */         customerBO.setVip("否");
/*     */       }
/*     */     }
/*  68 */     request.setAttribute("list", list);
/*  69 */     request.setAttribute("pageInfo", pageInfo);
/*  70 */     return mapping.findForward("list");
/*     */   }
/*     */   public ActionForward yylist(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */     throws Exception
/*     */   {
/*  54 */     CustomerForm omerForm = (CustomerForm)form;
/*  55 */     omerForm.setVip("");
/*  56 */     PageInfo pageInfo = new PageInfo();
/*  57 */     getCustomerServices().setRequest(request);
/*  58 */     Map map = Operate.describe(omerForm);
/*  59 */     List list = getCustomerServices().findAll(pageInfo, map);
/*  60 */     for (int i = 0; i < list.size(); i++) {
/*  61 */       CustomerBO customerBO = (CustomerBO)list.get(i);
/*  62 */       if ("1".equals(customerBO.getVip()))
/*  63 */         customerBO.setVip("是");
/*     */       else {
/*  65 */         customerBO.setVip("否");
/*     */       }
/*     */     }
/*  68 */     request.setAttribute("list", list);
/*  69 */     request.setAttribute("pageInfo", pageInfo);
/*  70 */     return mapping.findForward("yylist");
/*     */   }


/*     */   public ActionForward toAdd(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */     throws Exception
/*     */   {
/*  80 */     return mapping.findForward("toAdd");
/*     */   }
/*     */ 
/*     */   public ActionForward add(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */     throws Exception
/*     */   {
/*  90 */     CustomerForm customerForm = (CustomerForm)form;
/*  91 */     CustomerBO customerBO = customerForm.getCustomerBO();
/*  92 */     customerBO.setVip(customerForm.getVip());
			  if(customerBO.getPassword()==null ||customerBO.getPassword().equals("")){
				  customerBO.setPassword(new MD5().getMD5ofStr("888888"));
			  }else{
				  
				  customerBO.setPassword(new MD5().getMD5ofStr(customerForm.getPassword()));
			  }
/*     */     try {
/*  95 */       getCustomerServices().insert(customerBO);
/*  96 */       request.setAttribute("exception.message", "增加成功！");
/*     */     } catch (Exception e) {
					request.setAttribute("exception.message", "添加失败");
/*  98 */       ExceptionUtils.getFullStackTrace(e);
/*     */     }
/* 100 */     return list(mapping, form, request, response);
/*     */   }
/*     */ 
/*     */   public ActionForward checkCustomerId(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */     throws Exception
/*     */   {
/* 110 */     String customerAccount = request.getParameter("customerAccount");
/* 111 */     CustomerBO customerBO = getCustomerServices().checkCustomerId(customerAccount);
/* 112 */     if (customerBO == null) {
/* 113 */       response.getWriter().println(0);
/* 114 */       return null;
/*     */     }
/* 116 */     response.getWriter().println(1);
/* 117 */     return null;
/*     */   }
/*     */ 
/*     */   public ActionForward toUpdate(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */     throws Exception
/*     */   {
/* 127 */     CustomerForm omerForm = (CustomerForm)form;
/* 128 */     String id = omerForm.getSelectNos()[0];
/* 129 */     String[] a = id.split(",");
/* 130 */     CustomerBO customerBO = getCustomerServices().findById(Integer.valueOf(a[0]));
/*     */ 
/* 136 */     omerForm.setCustomerBO(customerBO);
/* 137 */     request.setAttribute("customerBO", customerBO);
/* 138 */     return mapping.findForward("toUpdate");
/*     */   }
/*     */ 
/*     */   public ActionForward update(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */     throws Exception
/*     */   {
/* 149 */     CustomerForm omerForm = (CustomerForm)form;
/*     */ 
/* 151 */     CustomerBO omerBO = omerForm.getCustomerBO();
/*     */     try {
/* 153 */       getCustomerServices().update(omerBO);
/* 154 */       request.setAttribute("exception.message", "修改信息成功！");
/*     */     } catch (Exception e) {
/* 156 */       ExceptionUtils.getFullStackTrace(e);
/*     */     }
/* 158 */     return list(mapping, form, request, response);
/*     */   }
/*     */ 
				public ActionForward oodlist(ActionMapping mapping, ActionForm form,
						HttpServletRequest request, HttpServletResponse response)
						throws Exception {
		
					PageInfo pageInfo = new PageInfo();
					 getCustomerServices().setRequest(request);
					List list = getCustomerServices().getOutofDate(pageInfo);
					 request.setAttribute("list", list);
					request.setAttribute("pageInfo", pageInfo);
					return mapping.findForward("oodlist");
				}


/*     */   public ActionForward resetPassword(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */     throws Exception
/*     */   {
/* 170 */     CustomerForm omerForm = (CustomerForm)form;
/* 171 */     String str = omerForm.getSelectNos()[0];
/* 172 */     String[] a = str.split(",");
/* 173 */     String customerAccount = a[1].trim();
/*     */ 
/* 176 */     String RESET_PASSWORD = "888888";
/* 177 */     String password = new MD5().getMD5ofStr(RESET_PASSWORD);
/* 178 */     CustomerBO customerBO = new CustomerBO();
/* 179 */     customerBO.setPassword(password);
/* 180 */     customerBO.setCustomerAccount(customerAccount);
/* 181 */     getCustomerServices().updatePassword(customerBO);
/* 182 */     request.setAttribute("exception.message", "重置密码成功！");
/* 183 */     return list(mapping, form, request, response);
/*     */   }
/*     */ 
/*     */   public ActionForward windowlist(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
/* 187 */     CustomerForm omerForm = (CustomerForm)form;
/* 188 */     PageInfo pageInfo = new PageInfo();
/* 189 */     getCustomerServices().setRequest(request);
/* 190 */     Map map = Operate.describe(omerForm);
/* 191 */    // map.put("vip", "1");
/* 192 */     List list = getCustomerServices().findAll(pageInfo, map);
/* 193 */     for (int i = 0; i < list.size(); i++) {
/* 194 */       CustomerBO customerBO = (CustomerBO)list.get(i);
/* 195 */       if ("1".equals(customerBO.getVip()))
/* 196 */         customerBO.setVip("是");
/*     */       else {
/* 198 */         customerBO.setVip("否");
/*     */       }
/*     */     }
/* 201 */     request.setAttribute("list", list);
/* 202 */     request.setAttribute("pageInfo", pageInfo);
/* 203 */     return mapping.findForward("windowlist");
/*     */   }

	public ActionForward toDelete(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		 CustomerForm omerForm = (CustomerForm)form;
		String[] ids = omerForm.getSelectNos();
		try {
			getCustomerServices().delete(ids);
		} catch (Exception localException) {
		}
		return list(mapping, form, request, response);
	}


/*     */ }

/* Location:           D:\李慧医药项目\tcmages\krt\WEB-INF\classes\
 * Qualified Name:     cn.krt.zbcg.system.web.action.CustomerAction
 * JD-Core Version:    0.6.2
 */