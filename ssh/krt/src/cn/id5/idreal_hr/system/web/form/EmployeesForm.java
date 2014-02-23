/*     */ package cn.id5.idreal_hr.system.web.form;
/*     */ 
/*     */ import cn.id5.idreal_hr.commons.bo.system.EmployeesBO;
/*     */ import org.ssi.struts.actionform.BaseForm;
/*     */ 
/*     */ public class EmployeesForm extends BaseForm
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*  14 */   private String[] selectNos = null;
/*  15 */   private String[] selectNoses = null;
/*  16 */   private EmployeesBO employeesBO = new EmployeesBO();
/*     */   private String name;
/*     */   private String empName;
/*     */   private String empPassword;
/*     */   private String invcode;
/*     */   private String empname;
/*     */   private String id5Radio;
/*     */   private String custmerRadio;
/*     */   private String deptEmpName;
/*     */   private String type;
/*  32 */   private String[] selectNo = null;
/*     */ 
/*  34 */   public String[] getSelectNo() { return this.selectNo; }
/*     */ 
/*     */   public void setSelectNo(String[] selectNo)
/*     */   {
/*  38 */     this.selectNo = selectNo;
/*     */   }
/*     */ 
/*     */   public String getId5Radio()
/*     */   {
/*  45 */     return this.id5Radio;
/*     */   }
/*     */ 
/*     */   public void setId5Radio(String id5Radio)
/*     */   {
/*  52 */     this.id5Radio = id5Radio;
/*     */   }
/*     */ 
/*     */   public String getCustmerRadio()
/*     */   {
/*  59 */     return this.custmerRadio;
/*     */   }
/*     */ 
/*     */   public void setCustmerRadio(String custmerRadio)
/*     */   {
/*  66 */     this.custmerRadio = custmerRadio;
/*     */   }
/*     */ 
/*     */   public String getInvcode()
/*     */   {
/*  73 */     return this.invcode;
/*     */   }
/*     */ 
/*     */   public void setInvcode(String invcode)
/*     */   {
/*  80 */     this.invcode = invcode;
/*     */   }
/*     */ 
/*     */   public String getEmpName()
/*     */   {
/*  87 */     return this.empName;
/*     */   }
/*     */ 
/*     */   public void setEmpName(String empName)
/*     */   {
/*  94 */     this.empName = empName;
/*     */   }
/*     */ 
/*     */   public String getEmpPassword()
/*     */   {
/* 101 */     return this.empPassword;
/*     */   }
/*     */ 
/*     */   public void setEmpPassword(String empPassword)
/*     */   {
/* 108 */     this.empPassword = empPassword;
/*     */   }
/*     */ 
/*     */   public String getName()
/*     */   {
/* 115 */     return this.name;
/*     */   }
/*     */ 
/*     */   public void setName(String name)
/*     */   {
/* 122 */     this.name = name;
/*     */   }
/*     */ 
/*     */   public EmployeesBO getEmployeesBO()
/*     */   {
/* 129 */     return this.employeesBO;
/*     */   }
/*     */ 
/*     */   public void setEmployeesBO(EmployeesBO employeesBO)
/*     */   {
/* 136 */     this.employeesBO = employeesBO;
/*     */   }
/*     */ 
/*     */   public static long getSerialVersionUID()
/*     */   {
/* 143 */     return 1L;
/*     */   }
/*     */ 
/*     */   public String[] getSelectNos()
/*     */   {
/* 150 */     return this.selectNos;
/*     */   }
/*     */ 
/*     */   public void setSelectNos(String[] selectNos)
/*     */   {
/* 157 */     this.selectNos = selectNos;
/*     */   }
/*     */ 
/*     */   public String[] getSelectNoses()
/*     */   {
/* 164 */     return this.selectNoses;
/*     */   }
/*     */ 
/*     */   public void setSelectNoses(String[] selectNoses)
/*     */   {
/* 171 */     this.selectNoses = selectNoses;
/*     */   }
/*     */ 
/*     */   public String getEmpname()
/*     */   {
/* 178 */     return this.empname;
/*     */   }
/*     */ 
/*     */   public void setEmpname(String empname)
/*     */   {
/* 185 */     this.empname = empname;
/*     */   }
/*     */ 
/*     */   public String getDeptEmpName()
/*     */   {
/* 192 */     return this.deptEmpName;
/*     */   }
/*     */ 
/*     */   public void setDeptEmpName(String deptEmpName)
/*     */   {
/* 199 */     this.deptEmpName = deptEmpName;
/*     */   }
/*     */ 
/*     */   public String getType() {
/* 203 */     return this.type;
/*     */   }
/*     */ 
/*     */   public void setType(String type) {
/* 207 */     this.type = type;
/*     */   }
/*     */ }

/* Location:           D:\李慧医药项目\tcmages\krt\WEB-INF\classes\
 * Qualified Name:     cn.id5.idreal_hr.system.web.form.EmployeesForm
 * JD-Core Version:    0.6.2
 */