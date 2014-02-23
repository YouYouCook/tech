/*     */ package cn.krt.zbcg.system.web.action;
/*     */ 
/*     */ import cn.krt.zbcg.commons.bo.system.NoticeBO;
/*     */ import cn.krt.zbcg.system.services.INoticeServices;
/*     */ import cn.krt.zbcg.system.web.form.NoticeForm;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ import org.apache.commons.lang.exception.ExceptionUtils;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.struts.action.ActionForm;
/*     */ import org.apache.struts.action.ActionForward;
/*     */ import org.apache.struts.action.ActionMapping;
/*     */ import org.ssi.struts.action.SSIDispatchAction;
/*     */ 
/*     */ public class NoticeAction extends SSIDispatchAction
/*     */ {
/*     */   private INoticeServices noticeServices;
/*     */ 
/*     */   private INoticeServices getCeServices()
/*     */   {
/*  38 */     if (this.noticeServices == null) {
/*  39 */       this.noticeServices = ((INoticeServices)getBean("noticeServices"));
/*     */     }
/*  41 */     return this.noticeServices;
/*     */   }
/*     */ 
/*     */   public ActionForward list(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */     throws Exception
/*     */   {
/*  52 */     NoticeForm ceForm = (NoticeForm)form;
/*  53 */     getCeServices().setRequest(request);
/*  54 */     NoticeBO noticeBO = getCeServices().findNotice();
/*  55 */     ceForm.setNoticeBO(noticeBO);
/*  56 */     request.setAttribute("noticeBO", noticeBO);
/*     */ 
/*  58 */     return mapping.findForward("list");
/*     */   }
/*     */ 
/*     */   public ActionForward toAdd(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */     throws Exception
/*     */   {
/*  68 */     if (log.isDebugEnabled()) log.debug("forward to add page.");
/*  69 */     return mapping.findForward("toAdd");
/*     */   }
/*     */ 
/*     */   public ActionForward add(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */     throws Exception
/*     */   {
/*  79 */     if (log.isDebugEnabled()) log.debug("get actionForm object.");
/*  80 */     NoticeForm ceForm = (NoticeForm)form;
/*  81 */     if (log.isDebugEnabled()) log.debug("get business object.");
/*  82 */     NoticeBO ceBO = ceForm.getNoticeBO();
/*     */     try {
/*  84 */       if (log.isDebugEnabled()) log.debug("insert data.");
/*  85 */       getCeServices().insert(ceBO);
/*     */     } catch (Exception e) {
/*  87 */       ExceptionUtils.getFullStackTrace(e);
/*     */     }
/*  89 */     return list(mapping, form, request, response);
/*     */   }
/*     */ 
/*     */   public ActionForward toUpdate(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */     throws Exception
/*     */   {
/*  99 */     if (log.isDebugEnabled()) log.debug("get actionForm object.");
/* 100 */     NoticeForm ceForm = (NoticeForm)form;
/* 101 */     String id = ceForm.getSelectNos()[0];
/* 102 */     if (log.isDebugEnabled()) log.debug("get data detail by id=" + id + ".");
/* 103 */     NoticeBO ceBO = getCeServices().findById(Integer.valueOf(id));
/* 104 */     if (log.isDebugEnabled()) log.debug("set business object.");
/* 105 */     ceForm.setNoticeBO(ceBO);
/* 106 */     return mapping.findForward("toUpdate");
/*     */   }
/*     */ 
/*     */   public ActionForward update(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */     throws Exception
/*     */   {
/* 117 */     NoticeForm ceForm = (NoticeForm)form;
/* 118 */     NoticeBO ceBO = ceForm.getNoticeBO();
/* 119 */     ceBO.setId(ceForm.getId());
/*     */     try {
/* 121 */       getCeServices().update(ceBO);
/* 122 */       request.setAttribute("exception.message", "更新招标公告成功！");
/*     */     } catch (Exception e) {
/* 124 */       ExceptionUtils.getFullStackTrace(e);
/*     */     }
/* 126 */     return list(mapping, form, request, response);
/*     */   }
/*     */ 
/*     */   public ActionForward toDelete(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */     throws Exception
/*     */   {
/* 136 */     if (log.isDebugEnabled()) log.debug("get actionForm object.");
/* 137 */     NoticeForm ceForm = (NoticeForm)form;
/* 138 */     String[] ids = ceForm.getSelectNos();
/*     */     try {
/* 140 */       if (log.isDebugEnabled()) log.debug("delete data or change data's status to delete.");
/* 141 */       getCeServices().delete(ids);
/*     */     } catch (Exception localException) {
/*     */     }
/* 144 */     return list(mapping, form, request, response);
/*     */   }
/*     */ 
/*     */   public ActionForward toDetail(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */     throws Exception
/*     */   {
/* 154 */     if (log.isDebugEnabled()) log.debug("get actionForm object.");
/* 155 */     NoticeForm ceForm = (NoticeForm)form;
/* 156 */     String id = ceForm.getSelectNos()[0];
/* 157 */     if (log.isDebugEnabled()) log.debug("get data detail by id=" + id + ".");
/* 158 */     NoticeBO ceBO = getCeServices().findById(Integer.valueOf(id));
/* 159 */     if (log.isDebugEnabled()) log.debug("set business object.");
/* 160 */     ceForm.setNoticeBO(ceBO);
/* 161 */     return mapping.findForward("toDetail");
/*     */   }
/*     */ }

/* Location:           D:\李慧医药项目\tcmages\krt\WEB-INF\classes\
 * Qualified Name:     cn.krt.zbcg.system.web.action.NoticeAction
 * JD-Core Version:    0.6.2
 */