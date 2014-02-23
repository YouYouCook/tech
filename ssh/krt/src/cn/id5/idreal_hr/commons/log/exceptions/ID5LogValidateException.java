/*    */ package cn.id5.idreal_hr.commons.log.exceptions;
/*    */ 
/*    */ import cn.id5.idreal_hr.commons.exceptions.ID5Exception;
/*    */ 
/*    */ public class ID5LogValidateException extends ID5Exception
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */ 
/*    */   public ID5LogValidateException(String msg)
/*    */   {
/* 13 */     super(msg);
/*    */   }
/*    */ 
/*    */   public ID5LogValidateException(String msg, Throwable e) {
/* 17 */     super(msg, e);
/*    */   }
/*    */ }

/* Location:           D:\李慧医药项目\tcmages\krt\WEB-INF\classes\
 * Qualified Name:     cn.id5.idreal_hr.commons.log.exceptions.ID5LogValidateException
 * JD-Core Version:    0.6.2
 */