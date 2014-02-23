/*    */ package org.ssi.tag;
/*    */ 
/*    */ public class EqualTag extends SSITag
/*    */ {
/*    */   private static final long serialVersionUID = -5690637185210464785L;
/* 19 */   private String value1 = null;
/*    */ 
/* 21 */   private String value2 = null;
/*    */ 
/*    */   public String getValue1()
/*    */   {
/* 28 */     return this.value1;
/*    */   }
/*    */ 
/*    */   public void setValue1(String value1)
/*    */   {
/* 35 */     this.value1 = value1;
/*    */   }
/*    */ 
/*    */   public String getValue2()
/*    */   {
/* 42 */     return this.value2;
/*    */   }
/*    */ 
/*    */   public void setValue2(String value2)
/*    */   {
/* 49 */     this.value2 = value2;
/*    */   }
/*    */ 
/*    */   protected int doEndEntity()
/*    */   {
/* 55 */     return 6;
/*    */   }
/*    */ 
/*    */   protected int doStartEntity()
/*    */   {
/* 61 */     boolean hasValue = false;
/* 62 */     if ((this.value1 != null) && (!"".equals(this.value1)) && (this.value2 != null) && (!"".equals(this.value2)))
/*    */     {
/* 64 */       if (this.value1.equals(this.value2))
/*    */       {
/* 66 */         hasValue = true;
/*    */       }
/*    */ 
/*    */     }
/*    */ 
/* 71 */     if (hasValue)
/*    */     {
/* 73 */       return 1;
/*    */     }
/* 75 */     return 0;
/*    */   }
/*    */ }

/* Location:           D:\李慧医药项目\tcmages\krt\WEB-INF\classes\
 * Qualified Name:     org.ssi.tag.EqualTag
 * JD-Core Version:    0.6.2
 */