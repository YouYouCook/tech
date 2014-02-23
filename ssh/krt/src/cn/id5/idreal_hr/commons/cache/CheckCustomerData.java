/*    */ package cn.id5.idreal_hr.commons.cache;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import java.math.BigDecimal;
/*    */ 
/*    */ public class CheckCustomerData
/*    */   implements Serializable
/*    */ {
/*    */   private String customerCode;
/*    */   private String customerType;
/*    */   private BigDecimal isPayInTest;
/*    */   private boolean isAmountCheck;
/*    */   private String dataQuality;
/*    */   private String ServiceState;
/*    */   private long cpId;
/*    */ 
/*    */   public String getCustomerCode()
/*    */   {
/* 14 */     return this.customerCode;
/*    */   }
/*    */   public void setCustomerCode(String customerCode) {
/* 17 */     this.customerCode = customerCode;
/*    */   }
/*    */   public String getCustomerType() {
/* 20 */     return this.customerType;
/*    */   }
/*    */   public void setCustomerType(String customerType) {
/* 23 */     this.customerType = customerType;
/*    */   }
/*    */   public BigDecimal isPayInTest() {
/* 26 */     return this.isPayInTest;
/*    */   }
/*    */   public void setPayInTest(BigDecimal isPayInTest) {
/* 29 */     this.isPayInTest = isPayInTest;
/*    */   }
/*    */   public boolean isAmountCheck() {
/* 32 */     return this.isAmountCheck;
/*    */   }
/*    */   public void setAmountCheck(boolean isAmountCheck) {
/* 35 */     this.isAmountCheck = isAmountCheck;
/*    */   }
/*    */   public String getDataQuality() {
/* 38 */     return this.dataQuality;
/*    */   }
/*    */   public void setDataQuality(String dataQuality) {
/* 41 */     this.dataQuality = dataQuality;
/*    */   }
/*    */   public String getServiceState() {
/* 44 */     return this.ServiceState;
/*    */   }
/*    */   public void setServiceState(String serviceState) {
/* 47 */     this.ServiceState = serviceState;
/*    */   }
/*    */   public long getCpId() {
/* 50 */     return this.cpId;
/*    */   }
/*    */   public void setCpId(long cpId) {
/* 53 */     this.cpId = cpId;
/*    */   }
/*    */ }

/* Location:           D:\李慧医药项目\tcmages\krt\WEB-INF\classes\
 * Qualified Name:     cn.id5.idreal_hr.commons.cache.CheckCustomerData
 * JD-Core Version:    0.6.2
 */