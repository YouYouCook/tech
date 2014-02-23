/*     */ package cn.id5.idreal_hr.commons;
/*     */ 
/*     */ public class JstlFunction
/*     */ {
/*     */   public static String getServiceStateMessage(String state, String logonKey)
/*     */   {
/*  12 */     String str = "";
/*  13 */     if ("0".equals(state))
/*  14 */       str = "未使用";
/*  15 */     else if ("1".equals(state))
/*  16 */       str = "信息收集";
/*  17 */     else if ("2".equals(state)) {
/*  18 */       if ("1".equals(logonKey))
/*  19 */         str = "已提交";
/*  20 */       else if ("2".equals(logonKey)) {
/*  21 */         str = "信息收集";
/*     */       }
/*     */     }
/*  24 */     else if ("3".equals(state)) {
/*  25 */       if ("1".equals(logonKey))
/*  26 */         str = "订单已接受";
/*  27 */       else if ("2".equals(logonKey))
/*  28 */         str = "信息收集";
/*     */     }
/*  30 */     else if ("4".equals(state))
/*  31 */       str = "核实中";
/*  32 */     else if ("5".equals(state))
/*  33 */       str = "已完成";
/*  34 */     else if ("6".equals(state)) {
/*  35 */       str = "放弃";
/*     */     }
/*     */ 
/*  38 */     return str;
/*     */   }
/*     */ 
/*     */   public static String getHeadMessage(String state)
/*     */   {
/*  47 */     String str = "";
/*  48 */     if ("0".equals(state))
/*  49 */       str = "未使用";
/*  50 */     else if ("1".equals(state))
/*  51 */       str = "信息收集";
/*  52 */     else if ("2".equals(state))
/*  53 */       str = "已提交";
/*  54 */     else if ("3".equals(state))
/*  55 */       str = "订单已接受";
/*  56 */     else if ("4".equals(state))
/*  57 */       str = "核实中";
/*  58 */     else if ("5".equals(state))
/*  59 */       str = "已完成";
/*  60 */     else if ("6".equals(state))
/*  61 */       str = "放弃";
/*  62 */     else if (("".equals(state)) || (state == null)) {
/*  63 */       str = "统计信息";
/*     */     }
/*     */ 
/*  66 */     return str;
/*     */   }
/*     */ 
/*     */   public static String getTitleMessage(String state)
/*     */   {
/*  75 */     StringBuilder str = new StringBuilder();
/*  76 */     if ("0".equals(state))
/*  77 */       str.append("<th>企业用户ID</th>")
/*  78 */         .append("<th>Service Code</th>")
/*  79 */         .append("<th>密  码</th>")
/*  80 */         .append("<th>服务内容</th>")
/*  81 */         .append("<th>服务开始时间</th>")
/*  82 */         .append("<th>服务结束时间</th>")
/*  83 */         .append("<th>状  态</th>")
/*  84 */         .append("<th>备    注</th>");
/*  85 */     else if ("1".equals(state))
/*  86 */       str.append("<th>企业用户ID</th>")
/*  87 */         .append("<th>Service Code</th>")
/*  88 */         .append("<th>服务内容</th>")
/*  89 */         .append("<th>服务开始时间</th>")
/*  90 */         .append("<th>服务结束时间</th>")
/*  91 */         .append("<th>状  态</th>")
/*  92 */         .append("<th>备    注</th>");
/*  93 */     else if ("2".equals(state))
/*  94 */       str.append("<th>企业用户ID</th>")
/*  95 */         .append("<th>Service Code</th>")
/*  96 */         .append("<th>服务内容</th>")
/*  97 */         .append("<th>服务开始时间</th>")
/*  98 */         .append("<th>服务结束时间</th>")
/*  99 */         .append("<th>状  态</th>")
/* 100 */         .append("<th>备    注</th>");
/* 101 */     else if ("3".equals(state))
/* 102 */       str.append("<th>企业用户ID</th>")
/* 103 */         .append("<th>Service Code</th>")
/* 104 */         .append("<th>服务内容</th>")
/* 105 */         .append("<th>服务开始时间</th>")
/* 106 */         .append("<th>服务结束时间</th>")
/* 107 */         .append("<th>状  态</th>")
/* 108 */         .append("<th>备    注</th>");
/* 109 */     else if ("4".equals(state))
/* 110 */       str.append("<th>企业用户ID</th>")
/* 111 */         .append("<th>Service Code</th>")
/* 112 */         .append("<th>服务内容</th>")
/* 113 */         .append("<th>核查开始时间</th>")
/* 114 */         .append("<th>核查结束时间</th>")
/* 115 */         .append("<th>状  态</th>")
/* 116 */         .append("<th>备    注</th>");
/* 117 */     else if ("5".equals(state))
/* 118 */       str.append("<th>企业用户ID</th>")
/* 119 */         .append("<th>Service Code</th>")
/* 120 */         .append("<th>服务内容</th>")
/* 121 */         .append("<th>开始时间</th>")
/* 122 */         .append("<th>结束时间</th>")
/* 123 */         .append("<th>状  态</th>")
/* 124 */         .append("<th>报告下载</th>")
/* 125 */         .append("<th>备    注</th>");
/* 126 */     else if ("6".equals(state))
/* 127 */       str.append("<th>企业用户ID</th>")
/* 128 */         .append("<th>Service Code</th>")
/* 129 */         .append("<th>服务内容</th>")
/* 130 */         .append("<th>开始时间</th>")
/* 131 */         .append("<th>结束时间</th>")
/* 132 */         .append("<th>状  态</th>")
/* 133 */         .append("<th>备    注</th>");
/* 134 */     else if (("".equals(state)) || (state == null)) {
/* 135 */       str.append("<th>企业用户ID</th>")
/* 136 */         .append("<th>Service Code</th>")
/* 137 */         .append("<th>密  码</th>")
/* 138 */         .append("<th>服务内容</th>")
/* 139 */         .append("<th>状  态</th>")
/* 140 */         .append("<th>备    注</th>");
/*     */     }
/*     */ 
/* 143 */     return str.toString();
/*     */   }
/*     */ 
/*     */   public static String strSubIntercept(String str)
/*     */   {
/* 151 */     if (("".equals(str)) || (str == null)) {
/* 152 */       return str;
/*     */     }
/* 154 */     String resultStr = "";
/* 155 */     if (str.length() > 10) {
/* 156 */       resultStr = str.substring(0, 10);
/* 157 */       resultStr = resultStr + "....";
/*     */     } else {
/* 159 */       resultStr = str;
/*     */     }
/* 161 */     return resultStr;
/*     */   }
/*     */ }

/* Location:           D:\李慧医药项目\tcmages\krt\WEB-INF\classes\
 * Qualified Name:     cn.id5.idreal_hr.commons.JstlFunction
 * JD-Core Version:    0.6.2
 */