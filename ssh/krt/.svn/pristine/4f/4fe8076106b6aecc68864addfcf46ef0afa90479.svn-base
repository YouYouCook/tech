/*    */ package org.ssi.tag;
/*    */ 
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.jsp.JspException;
/*    */ import javax.servlet.jsp.JspWriter;
/*    */ import javax.servlet.jsp.PageContext;
/*    */ import javax.servlet.jsp.tagext.BodyTagSupport;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.apache.commons.logging.LogFactory;
/*    */ import org.springframework.web.context.WebApplicationContext;
/*    */ import org.springframework.web.context.support.WebApplicationContextUtils;
/*    */ 
/*    */ public abstract class SSITag extends BodyTagSupport
/*    */ {
/* 19 */   protected HttpServletRequest request = null;
/*    */ 
/* 21 */   protected String path = null;
/*    */ 
/* 23 */   protected JspWriter out = null;
/*    */ 
/* 25 */   protected Log log = LogFactory.getLog(getClass());
/* 26 */   private WebApplicationContext wac = null;
/*    */ 
/*    */   public int doEndTag() throws JspException {
/* 29 */     return doEndEntity();
/*    */   }
/*    */ 
/*    */   public int doStartTag()
/*    */     throws JspException
/*    */   {
/* 35 */     this.request = ((HttpServletRequest)this.pageContext.getRequest());
/* 36 */     setContextPath(this.request);
/*    */ 
/* 38 */     this.out = this.pageContext.getOut();
/* 39 */     return doStartEntity();
/*    */   }
/*    */ 
/*    */   protected abstract int doStartEntity();
/*    */ 
/*    */   protected abstract int doEndEntity();
/*    */ 
/*    */   public void setContextPath(HttpServletRequest request)
/*    */   {
/* 49 */     String pathTemp = "";
/* 50 */     pathTemp = request.getContextPath();
/* 51 */     this.path = pathTemp;
/*    */   }
/*    */ 
/*    */   protected Object getBean(String strBeanName)
/*    */   {
/* 60 */     if (this.wac == null)
/*    */     {
/* 62 */       this.log.debug("初始化spring对象");
/* 63 */       this.wac = WebApplicationContextUtils.getRequiredWebApplicationContext(this.pageContext.getServletContext());
/*    */     }
/* 65 */     this.log.debug("获得在Spring对象注册的bean：" + strBeanName);
/* 66 */     return this.wac.getBean(strBeanName);
/*    */   }
/*    */ }

/* Location:           D:\李慧医药项目\tcmages\krt\WEB-INF\classes\
 * Qualified Name:     org.ssi.tag.SSITag
 * JD-Core Version:    0.6.2
 */