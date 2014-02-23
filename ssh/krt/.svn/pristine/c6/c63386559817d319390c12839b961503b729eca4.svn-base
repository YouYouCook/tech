/*     */ package cn.id5.util;
/*     */ 
/*     */ import java.io.PrintStream;
/*     */ 
/*     */ public class ConvertCodeToNameUtil
/*     */ {
/*     */   public static String convertServiceNameCodeToString(String codeDZ)
/*     */   {
/*   7 */     if ("ZJ".equals(codeDZ))
/*   8 */       return "增补就业";
/*   9 */     if ("ZZ".equals(codeDZ))
/*  10 */       return "增补多维度证明人工作核实（一任工作）";
/*  11 */     if ("SM".equals(codeDZ))
/*  12 */       return "上门就业信息核实";
/*  13 */     if ("CJ".equals(codeDZ))
/*  14 */       return "成绩单核实";
/*  15 */     if ("XW".equals(codeDZ))
/*  16 */       return "学位信息核实";
/*  17 */     if ("FZ".equals(codeDZ))
/*  18 */       return "犯罪记录核实";
/*  19 */     if ("XD".equals(codeDZ))
/*  20 */       return "吸毒记录核实";
/*  21 */     if ("FR".equals(codeDZ))
/*  22 */       return "法定代表人核实";
/*  23 */     if ("WG".equals(codeDZ))
/*  24 */       return "全国违规记录核实";
/*  25 */     if ("WJ".equals(codeDZ))
/*  26 */       return "违禁药品滥用记录";
/*  27 */     if ("SF".equals(codeDZ))
/*  28 */       return "公民身份信息核实";
/*  29 */     if ("JZ".equals(codeDZ))
/*  30 */       return "驾驶执照核实";
/*  31 */     if ("XL".equals(codeDZ))
/*  32 */       return "学历信息核实";
/*  33 */     if ("ZH".equals(codeDZ))
/*  34 */       return "专业资格信息核实";
/*  35 */     if ("JY".equals(codeDZ))
/*  36 */       return "精英型";
/*  37 */     if ("GG".equals(codeDZ))
/*  38 */       return "骨干型";
/*  39 */     if ("ZY".equals(codeDZ))
/*  40 */       return "职员型";
/*  41 */     if ("XR".equals(codeDZ)) {
/*  42 */       return "信任型";
/*     */     }
/*  44 */     return "";
/*     */   }
/*     */ 
/*     */   public static String convertServiceNameCodesToString(String codeStrs)
/*     */   {
/*  49 */     if ((codeStrs == null) || (codeStrs.length() == 0)) {
/*  50 */       return "";
/*     */     }
/*  52 */     String[] codeArr = codeStrs.split("\\+");
/*  53 */     for (String code : codeArr) {
/*  54 */       String subCode = code.substring(0, 2);
/*  55 */       codeStrs = codeStrs.replace(subCode, convertServiceNameCodeToString(subCode));
/*     */     }
/*  57 */     return codeStrs;
/*     */   }
/*     */ 
/*     */   public static String convertSccStatusCodeToString(String codeStr)
/*     */   {
/*  62 */     if ("0".equals(codeStr))
/*  63 */       return "未使用";
/*  64 */     if ("1".equals(codeStr))
/*  65 */       return "信息收集";
/*  66 */     if ("2".equals(codeStr))
/*  67 */       return "已提交";
/*  68 */     if ("3".equals(codeStr))
/*  69 */       return "订单已接受";
/*  70 */     if ("4".equals(codeStr))
/*  71 */       return "核实中";
/*  72 */     if ("5".equals(codeStr))
/*  73 */       return "已完成";
/*  74 */     if ("6".equals(codeStr)) {
/*  75 */       return "放弃";
/*     */     }
/*  77 */     return "";
/*     */   }
/*     */ 
/*     */   public static String convertEnterprisePropertyCodeToString(String codeStr)
/*     */   {
/*  83 */     if ("1".equals(codeStr))
/*  84 */       return "外商独资/外企办事处";
/*  85 */     if ("2".equals(codeStr))
/*  86 */       return "中外合资（合资、合作）";
/*  87 */     if ("3".equals(codeStr))
/*  88 */       return "股份制企业";
/*  89 */     if ("4".equals(codeStr))
/*  90 */       return "股份制企业";
/*  91 */     if ("5".equals(codeStr))
/*  92 */       return "私营.民营企业";
/*  93 */     if ("6".equals(codeStr))
/*  94 */       return "国有企业";
/*  95 */     if ("7".equals(codeStr))
/*  96 */       return "政府机关/非营利机构";
/*  97 */     if ("8".equals(codeStr)) {
/*  98 */       return "事业单位";
/*     */     }
/* 100 */     return "";
/*     */   }
/*     */ 
/*     */   public static String convertEnterpriseScaleCodeToString(String codeStr)
/*     */   {
/* 105 */     if ("1".equals(codeStr))
/* 106 */       return "1-49人";
/* 107 */     if ("2".equals(codeStr))
/* 108 */       return "50-99人";
/* 109 */     if ("3".equals(codeStr))
/* 110 */       return "100-499人";
/* 111 */     if ("4".equals(codeStr))
/* 112 */       return "500-999人";
/* 113 */     if ("5".equals(codeStr)) {
/* 114 */       return "1000人以上";
/*     */     }
/* 116 */     return "";
/*     */   }
/*     */ 
/*     */   public static void main(String[] args) {
/* 120 */     System.out.println(convertServiceNameCodesToString("JY+JY×8"));
/*     */   }
/*     */ }

/* Location:           D:\李慧医药项目\tcmages\krt\WEB-INF\classes\
 * Qualified Name:     cn.id5.util.ConvertCodeToNameUtil
 * JD-Core Version:    0.6.2
 */