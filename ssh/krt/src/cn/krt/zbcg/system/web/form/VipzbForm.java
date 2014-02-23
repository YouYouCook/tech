/*     */ package cn.krt.zbcg.system.web.form;
/*     */ 
/*     */ import cn.krt.zbcg.commons.bo.system.VipzbBO;
/*     */ import org.ssi.struts.actionform.BaseForm;
/*     */ 
/*     */ public class VipzbForm extends BaseForm
/*     */ {
/*  13 */   private VipzbBO zbBO = new VipzbBO();
/*     */   private Integer vipzbId;
/*     */   private Integer customerId;
/*     */   private Integer medicineId;
/*     */   private String beginDate;
/*     */   private String endDate;
/*     */ 
/*     */   public VipzbBO getZbBO()
/*     */   {
/*  58 */     return this.zbBO;
/*     */   }
/*     */ 
/*     */   public void setZbBO(VipzbBO zbBO)
/*     */   {
/*  70 */     this.zbBO = zbBO;
/*     */   }
/*     */ 
/*     */   public Integer getVipzbId()
/*     */   {
/*  82 */     return this.vipzbId;
/*     */   }
/*     */ 
/*     */   public void setVipzbId(Integer vipzbId)
/*     */   {
/*  94 */     this.vipzbId = vipzbId;
/*     */   }
/*     */ 
/*     */   public Integer getCustomerId()
/*     */   {
/* 106 */     return this.customerId;
/*     */   }
/*     */ 
/*     */   public void setCustomerId(Integer customerId)
/*     */   {
/* 118 */     this.customerId = customerId;
/*     */   }
/*     */ 
/*     */   public Integer getMedicineId()
/*     */   {
/* 130 */     return this.medicineId;
/*     */   }
/*     */ 
/*     */   public void setMedicineId(Integer medicineId)
/*     */   {
/* 142 */     this.medicineId = medicineId;
/*     */   }
/*     */ 
/*     */   public String getBeginDate() {
/* 146 */     return this.beginDate;
/*     */   }
/*     */ 
/*     */   public void setBeginDate(String beginDate) {
/* 150 */     this.beginDate = beginDate;
/*     */   }
/*     */ 
/*     */   public String getEndDate() {
/* 154 */     return this.endDate;
/*     */   }
/*     */ 
/*     */   public void setEndDate(String endDate) {
/* 158 */     this.endDate = endDate;
/*     */   }
/*     */ }

/* Location:           D:\李慧医药项目\tcmages\krt\WEB-INF\classes\
 * Qualified Name:     cn.krt.zbcg.system.web.form.VipzbForm
 * JD-Core Version:    0.6.2
 */