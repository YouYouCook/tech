/*     */ package cn.krt.zbcg.commons.bo.system;
/*     */ 
/*     */ public class MedicineCgBO
/*     */ {
/*     */   private Integer cgId;
/*     */   private Integer medicineId;
/*     */   private Integer cgQty;
/*     */   private String reachDate;
/*     */   private String cgState;
/*     */   private String beginDate;
/*     */   private String endDate;
/*     */   private MedicineBO medicineBO;
/*     */   private String remark;
/*     */   private Double agbj;
/*     */   private Double bzbj;
/*     */   private Double lscfl;


			private String pinzhongshuxing;
			public String getPinzhongshuxing() {
				return pinzhongshuxing;
			}
			public void setPinzhongshuxing(String pinzhongshuxing) {
				this.pinzhongshuxing = pinzhongshuxing;
			}
/*     */ 
/*     */   public Double getAgbj()
/*     */   {
/*  66 */     return this.agbj;
/*     */   }
/*     */ 
/*     */   public void setAgbj(Double agbj) {
/*  70 */     this.agbj = agbj;
/*     */   }
/*     */ 
/*     */   public Double getBzbj() {
/*  74 */     return this.bzbj;
/*     */   }
/*     */ 
/*     */   public void setBzbj(Double bzbj) {
/*  78 */     this.bzbj = bzbj;
/*     */   }
/*     */ 
/*     */   public Double getLscfl() {
/*  82 */     return this.lscfl;
/*     */   }
/*     */ 
/*     */   public void setLscfl(Double lscfl) {
/*  86 */     this.lscfl = lscfl;
/*     */   }
/*     */ 
/*     */   public String getRemark() {
/*  90 */     return this.remark;
/*     */   }
/*     */ 
/*     */   public void setRemark(String remark) {
/*  94 */     this.remark = remark;
/*     */   }
/*     */ 
/*     */   public MedicineBO getMedicineBO() {
/*  98 */     return this.medicineBO;
/*     */   }
/*     */ 
/*     */   public void setMedicineBO(MedicineBO medicineBO) {
/* 102 */     this.medicineBO = medicineBO;
/*     */   }
/*     */ 
/*     */   public Integer getCgId()
/*     */   {
/* 114 */     return this.cgId;
/*     */   }
/*     */ 
/*     */   public void setCgId(Integer cgId)
/*     */   {
/* 126 */     this.cgId = cgId;
/*     */   }
/*     */ 
/*     */   public Integer getMedicineId()
/*     */   {
/* 138 */     return this.medicineId;
/*     */   }
/*     */ 
/*     */   public void setMedicineId(Integer medicineId)
/*     */   {
/* 150 */     this.medicineId = medicineId;
/*     */   }
/*     */ 
/*     */   public Integer getCgQty()
/*     */   {
/* 162 */     return this.cgQty;
/*     */   }
/*     */ 
/*     */   public void setCgQty(Integer cgQty)
/*     */   {
/* 174 */     this.cgQty = cgQty;
/*     */   }
/*     */ 
/*     */   public String getReachDate()
/*     */   {
/* 186 */     return this.reachDate;
/*     */   }
/*     */ 
/*     */   public void setReachDate(String reachDate)
/*     */   {
/* 198 */     this.reachDate = reachDate;
/*     */   }
/*     */ 
/*     */   public String getCgState()
/*     */   {
/* 210 */     return this.cgState;
/*     */   }
/*     */ 
/*     */   public void setCgState(String cgState)
/*     */   {
/* 222 */     this.cgState = cgState;
/*     */   }
/*     */ 
/*     */   public String getBeginDate() {
/* 226 */     return this.beginDate;
/*     */   }
/*     */ 
/*     */   public void setBeginDate(String beginDate) {
/* 230 */     this.beginDate = beginDate;
/*     */   }
/*     */ 
/*     */   public String getEndDate() {
/* 234 */     return this.endDate;
/*     */   }
/*     */ 
/*     */   public void setEndDate(String endDate) {
/* 238 */     this.endDate = endDate;
/*     */   }
/*     */ }

/* Location:           D:\李慧医药项目\tcmages\krt\WEB-INF\classes\
 * Qualified Name:     cn.krt.zbcg.commons.bo.system.MedicineCgBO
 * JD-Core Version:    0.6.2
 */