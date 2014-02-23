/*    */ package cn.krt.zbcg.system.web.form;
/*    */ 
/*    */ import cn.krt.zbcg.commons.bo.system.NoticeBO;
/*    */ import org.ssi.struts.actionform.BaseForm;
/*    */ 
/*    */ public class NoticeForm extends BaseForm
/*    */ {
/* 13 */   private NoticeBO noticeBO = new NoticeBO();
/*    */   private Integer id;
/*    */   private String notic;
/*    */   private String message;
/*    */ 
/*    */   public String getMessage()
/*    */   {
/* 35 */     return this.message;
/*    */   }
/*    */ 
/*    */   public void setMessage(String message) {
/* 39 */     this.message = message;
/*    */   }
/*    */ 
/*    */   public NoticeBO getNoticeBO() {
/* 43 */     return this.noticeBO;
/*    */   }
/*    */ 
/*    */   public void setNoticeBO(NoticeBO noticeBO) {
/* 47 */     this.noticeBO = noticeBO;
/*    */   }
/*    */ 
/*    */   public Integer getId()
/*    */   {
/* 59 */     return this.id;
/*    */   }
/*    */ 
/*    */   public void setId(Integer id)
/*    */   {
/* 71 */     this.id = id;
/*    */   }
/*    */ 
/*    */   public String getNotic()
/*    */   {
/* 83 */     return this.notic;
/*    */   }
/*    */ 
/*    */   public void setNotic(String notic)
/*    */   {
/* 95 */     this.notic = notic;
/*    */   }
/*    */ }

/* Location:           D:\李慧医药项目\tcmages\krt\WEB-INF\classes\
 * Qualified Name:     cn.krt.zbcg.system.web.form.NoticeForm
 * JD-Core Version:    0.6.2
 */