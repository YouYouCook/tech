/*     */ package cn.krt.zbcg.system.web.action;
/*     */ 
/*     */ import cn.krt.zbcg.commons.bo.system.CustomerBO;
/*     */ import cn.krt.zbcg.commons.bo.system.CustomerVipBO;
/*     */ import cn.krt.zbcg.commons.bo.system.MedicineBO;
/*     */ import cn.krt.zbcg.system.services.ICustomerServices;
/*     */ import cn.krt.zbcg.system.services.ICustomerVipServices;
/*     */ import cn.krt.zbcg.system.services.IMedicineServices;
/*     */ import cn.krt.zbcg.system.web.form.CustomerVipForm;
/*     */ import java.io.PrintWriter;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ import org.apache.commons.lang.exception.ExceptionUtils;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.struts.action.ActionForm;
/*     */ import org.apache.struts.action.ActionForward;
/*     */ import org.apache.struts.action.ActionMapping;
/*     */ import org.ssi.common.Operate;
/*     */ import org.ssi.common.PageInfo;
/*     */ import org.ssi.struts.action.SSIDispatchAction;
/*     */ 
/*     */ public class CustomerVipAction extends SSIDispatchAction
/*     */ {
/*     */   private ICustomerVipServices customerVipServices;
/*     */   private IMedicineServices medicineServices;
/*     */   private ICustomerServices customerServices;
/*     */ 
/*     */   private ICustomerVipServices getOmerVipServices()
/*     */   {
/*  42 */     if (this.customerVipServices == null) {
/*  43 */       this.customerVipServices = ((ICustomerVipServices)getBean("customerVipServices"));
/*     */     }
/*  45 */     return this.customerVipServices;
/*     */   }
/*     */ 
/*     */   private IMedicineServices getMedicineServices()
/*     */   {
/*  58 */     if (this.medicineServices == null) {
/*  59 */       this.medicineServices = ((IMedicineServices)getBean("medicineServices"));
/*     */     }
/*  61 */     return this.medicineServices;
/*     */   }
/*     */ 
/*     */   private ICustomerServices getCustomerServices()
/*     */   {
/*  74 */     if (this.customerServices == null) {
/*  75 */       this.customerServices = ((ICustomerServices)getBean("customerServices"));
/*     */     }
/*  77 */     return this.customerServices;
/*     */   }
/*     */ 
/*     */   public ActionForward list(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */     throws Exception
/*     */   {
/*  88 */     CustomerVipForm customerVipForm = (CustomerVipForm)form;
/*     */ 
/*  91 */     PageInfo pageInfo = new PageInfo();
/*     */ 
/*  93 */     getOmerVipServices().setRequest(request);
/*     */ 
/*  95 */     Map map = Operate.describe(customerVipForm);
/*     */ 
/*  97 */     List customerVipList = getOmerVipServices().findAll(pageInfo, map);
/*  98 */     if (customerVipList != null) {
/*  99 */       for (int i = 0; i < customerVipList.size(); i++) {
/* 100 */         CustomerVipBO customerVipBO = (CustomerVipBO)customerVipList.get(i);
/* 101 */         if (customerVipBO != null)
/*     */         {
/* 105 */           MedicineBO cineBO = getMedicineServices().findById(customerVipBO.getMedicineId());
/* 106 */           if (cineBO != null)
/*     */           {
/* 108 */             customerVipBO.setMedicineName(cineBO.getMedicineName());
/*     */           }
/*     */ 
/* 112 */           CustomerBO customerBO = getCustomerServices().findById(customerVipBO.getCustomerId());
/* 113 */           if (customerBO != null)
/*     */           {
/* 115 */             customerVipBO.setCustomerAccount(customerBO.getCustomerAccount());
/*     */ 
/* 117 */             customerVipBO.setCustomerName(customerBO.getName());
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/* 122 */     request.setAttribute("list", customerVipList);
/* 123 */     request.setAttribute("pageInfo", pageInfo);
/* 124 */     return mapping.findForward("list");
/*     */   }
/*     */ 
/*     */   public ActionForward toAdd(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */     throws Exception
/*     */   {
/* 134 */     return mapping.findForward("toAdd");
/*     */   }
/*     */ 
/*     */   public ActionForward add(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */     throws Exception
/*     */   {
/* 144 */     CustomerVipForm omerVipForm = (CustomerVipForm)form;
/* 145 */     CustomerVipBO customerVipBO = omerVipForm.getCustomerVipBO();
/* 146 */     customerVipBO.setCustomerId(omerVipForm.getCustomerId());
/* 147 */     customerVipBO.setMedicineId(omerVipForm.getMedicineId());
/* 148 */     customerVipBO.setCgDate(omerVipForm.getCgDate());
/*     */     try {
/* 150 */       getOmerVipServices().insert(customerVipBO);
/* 151 */       request.setAttribute("exception.message", "增加信息成功！");
/*     */     } catch (Exception e) {
/* 153 */       ExceptionUtils.getFullStackTrace(e);
/*     */     }
/* 155 */     return list(mapping, form, request, response);
/*     */   }
/*     */ 
/*     */   public ActionForward toUpdate(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */     throws Exception
/*     */   {
/* 165 */     if (log.isDebugEnabled()) log.debug("get actionForm object.");
/* 166 */     CustomerVipForm omerVipForm = (CustomerVipForm)form;
/* 167 */     String id = omerVipForm.getSelectNos()[0];
/* 168 */     if (log.isDebugEnabled()) log.debug("get data detail by id=" + id + ".");
/* 169 */     CustomerVipBO omerVipBO = getOmerVipServices().findById(Integer.valueOf(id));
/* 170 */     if (log.isDebugEnabled()) log.debug("set business object.");
/* 171 */     omerVipForm.setCustomerVipBO(omerVipBO);
/* 172 */     return mapping.findForward("toUpdate");
/*     */   }
/*     */ 
/*     */   public ActionForward update(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */     throws Exception
/*     */   {
/* 182 */     if (log.isDebugEnabled()) log.debug("get actionForm object.");
/* 183 */     CustomerVipForm omerVipForm = (CustomerVipForm)form;
/* 184 */     if (log.isDebugEnabled()) log.debug("get business object.");
/* 185 */     CustomerVipBO omerVipBO = omerVipForm.getCustomerVipBO();
/*     */     try {
/* 187 */       if (log.isDebugEnabled()) log.debug("update data.");
/* 188 */       getOmerVipServices().update(omerVipBO);
/*     */     } catch (Exception e) {
/* 190 */       ExceptionUtils.getFullStackTrace(e);
/*     */     }
/* 192 */     return list(mapping, form, request, response);
/*     */   }
/*     */ 
/*     */   public ActionForward toDelete(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */     throws Exception
/*     */   {
/* 202 */     CustomerVipForm omerVipForm = (CustomerVipForm)form;
/* 203 */     String[] ids = omerVipForm.getSelectNos();
/*     */     try {
/* 205 */       getOmerVipServices().delete(ids);
/* 206 */       request.setAttribute("exception.message", "删除信息成功！");
/*     */     } catch (Exception localException) {
/*     */     }
/* 209 */     return list(mapping, form, request, response);
/*     */   }
/*     */ 
/*     */   public ActionForward toDetail(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */     throws Exception
/*     */   {
/* 219 */     if (log.isDebugEnabled()) log.debug("get actionForm object.");
/* 220 */     CustomerVipForm omerVipForm = (CustomerVipForm)form;
/* 221 */     String id = omerVipForm.getSelectNos()[0];
/* 222 */     if (log.isDebugEnabled()) log.debug("get data detail by id=" + id + ".");
/* 223 */     CustomerVipBO omerVipBO = getOmerVipServices().findById(Integer.valueOf(id));
/* 224 */     if (log.isDebugEnabled()) log.debug("set business object.");
/* 225 */     omerVipForm.setCustomerVipBO(omerVipBO);
/* 226 */     return mapping.findForward("toDetail");
/*     */   }
/*     */   public ActionForward checkResult(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
/* 229 */     CustomerVipForm omerVipForm = (CustomerVipForm)form;
/* 230 */     String customerId = request.getParameter("customerId");
/* 231 */     String medicineId = request.getParameter("medicineId");
/* 232 */     String cgDate = request.getParameter("cgDate");
/* 233 */     CustomerVipBO vipBO = new CustomerVipBO();
/* 234 */     vipBO.setMedicineId(Integer.valueOf(medicineId));
/* 235 */     vipBO.setCustomerId(Integer.valueOf(customerId));
/* 236 */     vipBO.setCgDate(cgDate);
/* 237 */     CustomerVipBO omerVipBO = getOmerVipServices().checkResult(vipBO);
/* 238 */     if (omerVipBO != null) {
/* 239 */       response.getWriter().println(1);
/* 240 */       return null;
/*     */     }
/* 242 */     response.getWriter().println(0);
/* 243 */     return null;
/*     */   }
/*     */ }

/* Location:           D:\李慧医药项目\tcmages\krt\WEB-INF\classes\
 * Qualified Name:     cn.krt.zbcg.system.web.action.CustomerVipAction
 * JD-Core Version:    0.6.2
 */