/*     */ package cn.krt.zbcg.system.web.action;
/*     */ 
/*     */ import cn.krt.zbcg.commons.bo.system.VipzbBO;
/*     */ import cn.krt.zbcg.system.services.IVipzbServices;
/*     */ import cn.krt.zbcg.system.web.form.VipzbForm;
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
/*     */ public class VipzbAction extends SSIDispatchAction
/*     */ {
/*     */   private IVipzbServices vipzbServices;
/*     */ 
/*     */   private IVipzbServices getZbServices()
/*     */   {
/*  36 */     if (this.vipzbServices == null) {
/*  37 */       this.vipzbServices = ((IVipzbServices)getBean("vipzbServices"));
/*     */     }
/*  39 */     return this.vipzbServices;
/*     */   }
/*     */ 
/*     */   public ActionForward list(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */     throws Exception
/*     */   {
/*  49 */     if (log.isDebugEnabled()) log.debug("get actionForm object.");
/*  50 */     VipzbForm zbForm = (VipzbForm)form;
/*  51 */     if (log.isDebugEnabled()) log.debug("init page object.");
/*  52 */     PageInfo pageInfo = new PageInfo();
/*  53 */     if (log.isDebugEnabled()) log.debug(" set request objecct by pagination and public parameter.");
/*  54 */     getZbServices().setRequest(request);
/*  55 */     if (log.isDebugEnabled()) log.debug("parse ActionForm properties to Map.");
/*  56 */     Map map = Operate.describe(zbForm);
/*  57 */     if (log.isDebugEnabled()) log.debug("get data list by pagination.");
/*  58 */     List zbList = getZbServices().findAll(pageInfo, map);
/*  59 */     if (log.isDebugEnabled()) log.debug("set data list for request object,use jsp page.");
/*  60 */     request.setAttribute("zbList", zbList);
/*  61 */     if (log.isDebugEnabled()) log.debug("set page object for request object,use jsp page.");
/*  62 */     request.setAttribute("pageInfo", pageInfo);
/*  63 */     if (map != null) { map.clear(); map = null; }
/*  64 */     if (log.isDebugEnabled()) log.debug("forward to data list page.");
/*  65 */     return mapping.findForward("zbList");
/*     */   }
/*     */ 
/*     */   public ActionForward toAdd(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */     throws Exception
/*     */   {
/*  75 */     if (log.isDebugEnabled()) log.debug("forward to add page.");
/*  76 */     return mapping.findForward("toAdd");
/*     */   }
/*     */ 
/*     */   public ActionForward add(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */     throws Exception
/*     */   {
/*  86 */     if (log.isDebugEnabled()) log.debug("get actionForm object.");
/*  87 */     VipzbForm zbForm = (VipzbForm)form;
/*  88 */     if (log.isDebugEnabled()) log.debug("get business object.");
/*  89 */     VipzbBO zbBO = zbForm.getZbBO();
/*     */     try {
/*  91 */       if (log.isDebugEnabled()) log.debug("insert data.");
/*  92 */       getZbServices().insert(zbBO);
/*     */     } catch (Exception e) {
/*  94 */       ExceptionUtils.getFullStackTrace(e);
/*     */     }
/*  96 */     return list(mapping, form, request, response);
/*     */   }
/*     */ 
/*     */   public ActionForward toUpdate(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */     throws Exception
/*     */   {
/* 106 */     if (log.isDebugEnabled()) log.debug("get actionForm object.");
/* 107 */     VipzbForm zbForm = (VipzbForm)form;
/* 108 */     String id = zbForm.getSelectNos()[0];
/* 109 */     if (log.isDebugEnabled()) log.debug("get data detail by id=" + id + ".");
/* 110 */     VipzbBO zbBO = getZbServices().findById(Integer.valueOf(id));
/* 111 */     if (log.isDebugEnabled()) log.debug("set business object.");
/* 112 */     zbForm.setZbBO(zbBO);
/* 113 */     return mapping.findForward("toUpdate");
/*     */   }
/*     */ 
/*     */   public ActionForward update(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */     throws Exception
/*     */   {
/* 123 */     if (log.isDebugEnabled()) log.debug("get actionForm object.");
/* 124 */     VipzbForm zbForm = (VipzbForm)form;
/* 125 */     if (log.isDebugEnabled()) log.debug("get business object.");
/* 126 */     VipzbBO zbBO = zbForm.getZbBO();
/*     */     try {
/* 128 */       if (log.isDebugEnabled()) log.debug("update data.");
/* 129 */       getZbServices().update(zbBO);
/*     */     } catch (Exception e) {
/* 131 */       ExceptionUtils.getFullStackTrace(e);
/*     */     }
/* 133 */     return list(mapping, form, request, response);
/*     */   }
/*     */ 
/*     */   public ActionForward toDelete(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */     throws Exception
/*     */   {
/* 143 */     if (log.isDebugEnabled()) log.debug("get actionForm object.");
/* 144 */     VipzbForm zbForm = (VipzbForm)form;
/* 145 */     String[] ids = zbForm.getSelectNos();
/*     */     try {
/* 147 */       if (log.isDebugEnabled()) log.debug("delete data or change data's status to delete.");
/* 148 */       getZbServices().delete(ids);
/*     */     } catch (Exception localException) {
/*     */     }
/* 151 */     return list(mapping, form, request, response);
/*     */   }
/*     */ 
/*     */   public ActionForward toDetail(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */     throws Exception
/*     */   {
/* 161 */     if (log.isDebugEnabled()) log.debug("get actionForm object.");
/* 162 */     VipzbForm zbForm = (VipzbForm)form;
/* 163 */     String id = zbForm.getSelectNos()[0];
/* 164 */     if (log.isDebugEnabled()) log.debug("get data detail by id=" + id + ".");
/* 165 */     VipzbBO zbBO = getZbServices().findById(Integer.valueOf(id));
/* 166 */     if (log.isDebugEnabled()) log.debug("set business object.");
/* 167 */     zbForm.setZbBO(zbBO);
/* 168 */     return mapping.findForward("toDetail");
/*     */   }
/*     */ }

/* Location:           D:\李慧医药项目\tcmages\krt\WEB-INF\classes\
 * Qualified Name:     cn.krt.zbcg.system.web.action.VipzbAction
 * JD-Core Version:    0.6.2
 */