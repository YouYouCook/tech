/*    */ package org.ssi.struts.action;
/*    */ 
/*    */ import cn.id5.idreal_hr.commons.log.IOperLog;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.apache.commons.logging.LogFactory;
/*    */ import org.apache.struts.action.ActionForm;
/*    */ import org.apache.struts.action.ActionForward;
/*    */ import org.apache.struts.action.ActionMapping;
/*    */ import org.springframework.web.context.WebApplicationContext;
/*    */ import org.springframework.web.struts.DispatchActionSupport;
/*    */ import org.ssi.services.IService;
/*    */ 
/*    */ public abstract class SSIDispatchAction extends DispatchActionSupport
/*    */ {
/* 23 */   protected Log logger = LogFactory.getLog(getClass());
/*    */ 
/* 26 */   private IService service = null;
/*    */ 
/* 29 */   private IOperLog operLog = null;
/*    */ 
/*    */   protected void log(HttpServletRequest request, String resCode, String logContent)
/*    */   {
/*    */   }
/*    */ 
/*    */   protected Object getBean(String beanId)
/*    */   {
/* 49 */     Object o = getWebApplicationContext().getBean(beanId);
/* 50 */     log.debug("获取对象[" + beanId + "] 的实例");
/* 51 */     return o;
/*    */   }
/*    */ 
/*    */   public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/*    */     throws Exception
/*    */   {
/* 58 */     return super.execute(actionMapping, actionForm, request, response);
/*    */   }
/*    */ 
/*    */   protected IService getService()
/*    */   {
/* 65 */     if (this.service == null)
/*    */     {
/* 67 */       this.service = ((IService)getBean("service"));
/*    */     }
/* 69 */     return this.service;
/*    */   }
/*    */ 
/*    */   public IOperLog getOperLog()
/*    */   {
/* 76 */     if (this.operLog == null)
/*    */     {
/* 78 */       this.operLog = ((IOperLog)getBean("operLog"));
/*    */     }
/* 80 */     return this.operLog;
/*    */   }
/*    */ }

/* Location:           D:\李慧医药项目\tcmages\krt\WEB-INF\classes\
 * Qualified Name:     org.ssi.struts.action.SSIDispatchAction
 * JD-Core Version:    0.6.2
 */