/*     */ package cn.krt.zbcg.commons.bo.system;
/*     */ 
/*     */ public class MedicineZbBO
/*     */ {
/*     */   private Integer zbId;
/*     */   private Integer jbId;
/*     */   private Double hsl;
/*     */   private Double cfl;
/*     */   private String jcy;
/*     */   private String shr;
/*     */   private String state;
/*     */   private String zbState;
/*     */   private String remark;
/*     */   private String beginDate;
/*     */   private String endDate;
/*     */   private String authState;
/*     */   private MedicineJbBO medicineJbBO;
/*     */   private MedicineBO medicineBO;
/*     */ 
/*     */   public MedicineBO getMedicineBO()
/*     */   {
/* 102 */     return this.medicineBO;
/*     */   }
/*     */ 
/*     */   public void setMedicineBO(MedicineBO medicineBO) {
/* 106 */     this.medicineBO = medicineBO;
/*     */   }
/*     */ 
/*     */   public MedicineJbBO getMedicineJbBO() {
/* 110 */     return this.medicineJbBO;
/*     */   }
/*     */ 
/*     */   public void setMedicineJbBO(MedicineJbBO medicineJbBO) {
/* 114 */     this.medicineJbBO = medicineJbBO;
/*     */   }
/*     */ 
/*     */   public String getAuthState() {
/* 118 */     return this.authState;
/*     */   }
/*     */ 
/*     */   public void setAuthState(String authState) {
/* 122 */     this.authState = authState;
/*     */   }
/*     */ 
/*     */   public Integer getZbId() {
/* 126 */     return this.zbId;
/*     */   }
/*     */ 
/*     */   public void setZbId(Integer zbId)
/*     */   {
/* 138 */     this.zbId = zbId;
/*     */   }
/*     */ 
/*     */   public Integer getJbId()
/*     */   {
/* 150 */     return this.jbId;
/*     */   }
/*     */ 
/*     */   public void setJbId(Integer jbId)
/*     */   {
/* 162 */     this.jbId = jbId;
/*     */   }
/*     */ 
/*     */   public String getJcy()
/*     */   {
/* 176 */     return this.jcy;
/*     */   }
/*     */ 
/*     */   public void setJcy(String jcy)
/*     */   {
/* 188 */     this.jcy = jcy;
/*     */   }
/*     */ 
/*     */   public String getShr()
/*     */   {
/* 200 */     return this.shr;
/*     */   }
/*     */ 
/*     */   public void setShr(String shr)
/*     */   {
/* 212 */     this.shr = shr;
/*     */   }
/*     */ 
/*     */   public String getState()
/*     */   {
/* 224 */     return this.state;
/*     */   }
/*     */ 
/*     */   public void setState(String state)
/*     */   {
/* 236 */     this.state = state;
/*     */   }
/*     */ 
/*     */   public String getZbState()
/*     */   {
/* 248 */     return this.zbState;
/*     */   }
/*     */ 
/*     */   public void setZbState(String zbState)
/*     */   {
/* 260 */     this.zbState = zbState;
/*     */   }
/*     */ 
/*     */   public String getRemark()
/*     */   {
/* 272 */     return this.remark;
/*     */   }
/*     */ 
/*     */   public void setRemark(String remark)
/*     */   {
/* 284 */     this.remark = remark;
/*     */   }
/*     */ 
/*     */   public String getBeginDate() {
/* 288 */     return this.beginDate;
/*     */   }
/*     */ 
/*     */   public void setBeginDate(String beginDate) {
/* 292 */     this.beginDate = beginDate;
/*     */   }
/*     */ 
/*     */   public String getEndDate() {
/* 296 */     return this.endDate;
/*     */   }
/*     */ 
/*     */   public void setEndDate(String endDate) {
/* 300 */     this.endDate = endDate;
/*     */   }
/*     */ 
/*     */   public Double getHsl() {
/* 304 */     return this.hsl;
/*     */   }
/*     */ 
/*     */   public void setHsl(Double hsl) {
/* 308 */     this.hsl = hsl;
/*     */   }
/*     */ 
/*     */   public Double getCfl() {
/* 312 */     return this.cfl;
/*     */   }
/*     */ 
/*     */   public void setCfl(Double cfl) {
/* 316 */     this.cfl = cfl;
/*     */   }
/*     */ }

/* Location:           D:\李慧医药项目\tcmages\krt\WEB-INF\classes\
 * Qualified Name:     cn.krt.zbcg.commons.bo.system.MedicineZbBO
 * JD-Core Version:    0.6.2
 */