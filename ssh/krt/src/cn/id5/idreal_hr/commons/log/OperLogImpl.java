/*    */ package cn.id5.idreal_hr.commons.log;
/*    */ 
/*    */ import cn.id5.idreal_hr.commons.bo.log.LogBO;
/*    */ import cn.id5.idreal_hr.commons.exceptions.ID5Exception;
/*    */ import cn.id5.idreal_hr.commons.log.exceptions.ID5LogValidateException;
/*    */ import cn.id5.idreal_hr.commons.log.services.ILogServices;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.apache.commons.logging.LogFactory;
/*    */ 
/*    */ public class OperLogImpl
/*    */   implements IOperLog
/*    */ {
/* 17 */   protected Log logger = LogFactory.getLog(getClass());
/*    */   private ILogServices logService;
/*    */ 
/*    */   public void write(LogBO logBO)
/*    */     throws ID5Exception
/*    */   {
/* 20 */     String result = logBO.isNull();
/* 21 */     if (result != null)
/* 22 */       throw new ID5LogValidateException(result);
/* 23 */     this.logService.insert(logBO);
/*    */   }
/*    */ 
/*    */   public void setLogService(ILogServices logService)
/*    */   {
/* 30 */     this.logService = logService;
/*    */   }
/*    */ }

/* Location:           D:\李慧医药项目\tcmages\krt\WEB-INF\classes\
 * Qualified Name:     cn.id5.idreal_hr.commons.log.OperLogImpl
 * JD-Core Version:    0.6.2
 */