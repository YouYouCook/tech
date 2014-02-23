/*     */ package cn.krt.zbcg.system.web.form;
/*     */ 
/*     */ import cn.krt.zbcg.commons.bo.system.MedicineCgBO;
/*     */ import org.ssi.struts.actionform.BaseForm;
/*     */ 
/*     */ public class MedicineCgForm extends BaseForm
/*     */ {
/*  13 */   private MedicineCgBO cineCgBO = new MedicineCgBO();
/*     */   private Integer cgId;
/*     */   private Integer medicineId;
/*     */   private Integer cgQty;
/*     */   private String reachDate;
/*     */   private String cgState;
/*     */   private String beginDate;
/*     */   private String endDate;
/*     */   private String remark;
/*     */   private String name;
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
/*     */   public String getName()
/*     */   {
/*  70 */     return this.name;
/*     */   }
/*     */ 
/*     */   public void setName(String name) {
/*  74 */     this.name = name;
/*     */   }
/*     */ 
/*     */   public Double getAgbj()
/*     */   {
/*  84 */     return this.agbj;
/*     */   }
/*     */ 
/*     */   public void setAgbj(Double agbj) {
/*  88 */     this.agbj = agbj;
/*     */   }
/*     */ 
/*     */   public Double getBzbj() {
/*  92 */     return this.bzbj;
/*     */   }
/*     */ 
/*     */   public void setBzbj(Double bzbj) {
/*  96 */     this.bzbj = bzbj;
/*     */   }
/*     */ 
/*     */   public Double getLscfl() {
/* 100 */     return this.lscfl;
/*     */   }
/*     */ 
/*     */   public void setLscfl(Double lscfl) {
/* 104 */     this.lscfl = lscfl;
/*     */   }
/*     */ 
/*     */   public MedicineCgBO getCineCgBO()
/*     */   {
/* 115 */     return this.cineCgBO;
/*     */   }
/*     */ 
/*     */   public void setCineCgBO(MedicineCgBO cineCgBO)
/*     */   {
/* 127 */     this.cineCgBO = cineCgBO;
/*     */   }
/*     */ 
/*     */   public Integer getCgId()
/*     */   {
/* 139 */     return this.cgId;
/*     */   }
/*     */ 
/*     */   public void setCgId(Integer cgId)
/*     */   {
/* 151 */     this.cgId = cgId;
/*     */   }
/*     */ 
/*     */   public Integer getMedicineId()
/*     */   {
/* 163 */     return this.medicineId;
/*     */   }
/*     */ 
/*     */   public void setMedicineId(Integer medicineId)
/*     */   {
/* 175 */     this.medicineId = medicineId;
/*     */   }
/*     */ 
/*     */   public Integer getCgQty()
/*     */   {
/* 187 */     return this.cgQty;
/*     */   }
/*     */ 
/*     */   public void setCgQty(Integer cgQty)
/*     */   {
/* 199 */     this.cgQty = cgQty;
/*     */   }
/*     */ 
/*     */   public String getReachDate()
/*     */   {
/* 211 */     return this.reachDate;
/*     */   }
/*     */ 
/*     */   public void setReachDate(String reachDate)
/*     */   {
/* 223 */     this.reachDate = reachDate;
/*     */   }
/*     */ 
/*     */   public String getCgState()
/*     */   {
/* 235 */     return this.cgState;
/*     */   }
/*     */ 
/*     */   public void setCgState(String cgState)
/*     */   {
/* 247 */     this.cgState = cgState;
/*     */   }
/*     */ 
/*     */   public String getBeginDate() {
/* 251 */     return this.beginDate;
/*     */   }
/*     */ 
/*     */   public void setBeginDate(String beginDate) {
/* 255 */     this.beginDate = beginDate;
/*     */   }
/*     */ 
/*     */   public String getEndDate() {
/* 259 */     return this.endDate;
/*     */   }
/*     */ 
/*     */   public void setEndDate(String endDate) {
/* 263 */     this.endDate = endDate;
/*     */   }
/*     */ 
/*     */   public String getRemark() {
/* 267 */     return this.remark;
/*     */   }
/*     */ 
/*     */   public void setRemark(String remark) {
/* 271 */     this.remark = remark;
/*     */   }
/*     */ }

/* Location:           D:\李慧医药项目\tcmages\krt\WEB-INF\classes\
 * Qualified Name:     cn.krt.zbcg.system.web.form.MedicineCgForm
 * JD-Core Version:    0.6.2
 */