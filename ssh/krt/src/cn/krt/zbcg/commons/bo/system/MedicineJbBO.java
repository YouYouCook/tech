/*     */ package cn.krt.zbcg.commons.bo.system;
/*     */ 
/*     */ public class MedicineJbBO
/*     */ {
/*     */   private Integer jbId;
/*     */   private Integer cgId;
/*     */   private String customerAccount;
/*     */   private String medicineCode;
/*     */   private String ylcd;
/*     */   private Double price;
/*     */   private String remark;
/*     */   private String jbState;
/*     */   private String beginDate;
/*     */   private String endDate;
/*     */   private MedicineCgBO medicineCgBO;
/*     */   private CustomerBO customerBO;
/*     */   private String hgState;
/*     */   private String view;
/*     */ 
/*     */   public String getHgState()
/*     */   {
/*  86 */     return this.hgState;
/*     */   }
/*     */ 
/*     */   public void setHgState(String hgState) {
/*  90 */     this.hgState = hgState;
/*     */   }
/*     */ 
/*     */   public String getView() {
/*  94 */     return this.view;
/*     */   }
/*     */ 
/*     */   public void setView(String view) {
/*  98 */     this.view = view;
/*     */   }
/*     */ 
/*     */   public CustomerBO getCustomerBO() {
/* 102 */     return this.customerBO;
/*     */   }
/*     */ 
/*     */   public void setCustomerBO(CustomerBO customerBO) {
/* 106 */     this.customerBO = customerBO;
/*     */   }
/*     */ 
/*     */   public MedicineCgBO getMedicineCgBO() {
/* 110 */     return this.medicineCgBO;
/*     */   }
/*     */ 
/*     */   public void setMedicineCgBO(MedicineCgBO medicineCgBO) {
/* 114 */     this.medicineCgBO = medicineCgBO;
/*     */   }
/*     */ 
/*     */   public Integer getJbId()
/*     */   {
/* 126 */     return this.jbId;
/*     */   }
/*     */ 
/*     */   public void setJbId(Integer jbId)
/*     */   {
/* 138 */     this.jbId = jbId;
/*     */   }
/*     */ 
/*     */   public Integer getCgId()
/*     */   {
/* 150 */     return this.cgId;
/*     */   }
/*     */ 
/*     */   public void setCgId(Integer cgId)
/*     */   {
/* 162 */     this.cgId = cgId;
/*     */   }
/*     */ 
/*     */   public String getCustomerAccount()
/*     */   {
/* 174 */     return this.customerAccount;
/*     */   }
/*     */ 
/*     */   public void setCustomerAccount(String customerAccount)
/*     */   {
/* 186 */     this.customerAccount = customerAccount;
/*     */   }
/*     */ 
/*     */   public String getMedicineCode()
/*     */   {
/* 198 */     return this.medicineCode;
/*     */   }
/*     */ 
/*     */   public void setMedicineCode(String medicineCode)
/*     */   {
/* 210 */     this.medicineCode = medicineCode;
/*     */   }
/*     */ 
/*     */   public String getYlcd()
/*     */   {
/* 222 */     return this.ylcd;
/*     */   }
/*     */ 
/*     */   public void setYlcd(String ylcd)
/*     */   {
/* 234 */     this.ylcd = ylcd;
/*     */   }
/*     */ 
/*     */   public Double getPrice()
/*     */   {
/* 246 */     return this.price;
/*     */   }
/*     */ 
/*     */   public void setPrice(Double price)
/*     */   {
/* 258 */     this.price = price;
/*     */   }
/*     */ 
/*     */   public String getRemark()
/*     */   {
/* 270 */     return this.remark;
/*     */   }
/*     */ 
/*     */   public void setRemark(String remark)
/*     */   {
/* 282 */     this.remark = remark;
/*     */   }
/*     */ 
/*     */   public String getJbState()
/*     */   {
/* 294 */     return this.jbState;
/*     */   }
/*     */ 
/*     */   public void setJbState(String jbState)
/*     */   {
/* 306 */     this.jbState = jbState;
/*     */   }
/*     */ 
/*     */   public String getBeginDate()
/*     */   {
/* 311 */     return this.beginDate;
/*     */   }
/*     */ 
/*     */   public void setBeginDate(String beginDate) {
/* 315 */     this.beginDate = beginDate;
/*     */   }
/*     */ 
/*     */   public String getEndDate() {
/* 319 */     return this.endDate;
/*     */   }
/*     */ 
/*     */   public void setEndDate(String endDate) {
/* 323 */     this.endDate = endDate;
/*     */   }
/*     */ }

/* Location:           D:\李慧医药项目\tcmages\krt\WEB-INF\classes\
 * Qualified Name:     cn.krt.zbcg.commons.bo.system.MedicineJbBO
 * JD-Core Version:    0.6.2
 */