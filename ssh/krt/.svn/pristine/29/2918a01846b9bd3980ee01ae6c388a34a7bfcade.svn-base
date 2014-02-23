/*     */ package org.ssi.common;
/*     */ 
/*     */ import java.io.PrintStream;
/*     */ import java.text.ParseException;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Calendar;
/*     */ import java.util.Date;
/*     */ import java.util.GregorianCalendar;
/*     */ import java.util.regex.Pattern;
/*     */ import org.apache.commons.lang.StringUtils;
/*     */ import org.apache.commons.lang.exception.ExceptionUtils;
/*     */ import org.apache.log4j.BasicConfigurator;
/*     */ import org.apache.log4j.Level;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class CheckFilter
/*     */ {
/*  18 */   private static Logger logger = Logger.getLogger(CheckFilter.class);
/*     */ 
/*     */   public static boolean filterName(String name)
/*     */   {
/*  32 */     boolean result = false;
/*     */ 
/*  34 */     name = StringUtils.trimToNull(name);
/*     */ 
/*  36 */     if (name == null)
/*     */     {
/*  38 */       result = false;
/*  39 */       logger.warn(String.format("不符合规则=>姓名不可为空！[name=%s]", new Object[] { name }));
/*  40 */       return result;
/*     */     }
/*     */ 
/*  44 */     String strPattern = "^[一-龥·.·]{2,30}$";
/*  45 */     boolean isValid = Pattern.matches(strPattern, name);
/*  46 */     if (!isValid) {
/*  47 */       result = false;
/*  48 */       logger.warn("不符合规则=>姓名长度30位限制、汉字限制校验！name" + name + ",strPattern=" + strPattern);
/*  49 */       return result;
/*  50 */     }if ((StringUtils.startsWith(name, "·")) || (StringUtils.startsWith(name, ".")) || (StringUtils.endsWith(name, "·")) || (StringUtils.endsWith(name, "."))) {
/*  51 */       result = false;
/*  52 */       logger.warn("不符合规则=>姓名以·.开始或结尾！");
/*  53 */       return result;
/*     */     }
/*  55 */     result = true;
/*  56 */     return result;
/*     */   }
/*     */ 
/*     */   public static boolean filterId(String id)
/*     */   {
/*  75 */     boolean result = false;
/*     */ 
/*  77 */     id = StringUtils.trimToNull(id);
/*     */ 
/*  80 */     if (id == null)
/*     */     {
/*  82 */       result = false;
/*  83 */       logger.warn(String.format("不符合规则=>身份证不可为空！[id=%s]", new Object[] { id }));
/*  84 */       return result;
/*     */     }
/*     */ 
/*  88 */     String idPattern15 = "^[0-9]{15}$";
/*     */ 
/*  90 */     String idPattern18 = "^[0-9]{17}[0-9xX]{1}$";
/*  91 */     if (Pattern.matches("^[0-9]{15}$", id))
/*     */     {
/*  93 */       String birthday = id.substring(6, 12);
/*  94 */       SimpleDateFormat sf = new SimpleDateFormat("yyMMdd");
/*  95 */       sf.setLenient(false);
/*  96 */       logger.debug("15位身份证生日：" + birthday);
/*     */       try
/*     */       {
/*  99 */         Date d = sf.parse(birthday);
/* 100 */         logger.debug("15位身份证生日：" + d);
/* 101 */         Calendar calendar = new GregorianCalendar();
/* 102 */         calendar.setTime(d);
/* 103 */         int year = calendar.get(1);
/* 104 */         logger.debug("出身年份");
/* 105 */         return (year >= 1900) && (year <= 2099);
/*     */       }
/*     */       catch (ParseException ex)
/*     */       {
/* 110 */         logger.error("生日解析异常：\n" + ExceptionUtils.getFullStackTrace(ex));
/* 111 */         return false;
/*     */       }
/*     */     }
/*     */ 
/* 115 */     if (Pattern.matches("^[0-9]{17}[0-9xX]{1}$", id))
/*     */     {
/* 117 */       String birthday = id.substring(6, 14);
/* 118 */       SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");
/* 119 */       sf.setLenient(false);
/* 120 */       logger.debug("18位身份证生日：" + birthday);
/*     */       try
/*     */       {
/* 123 */         Date d = sf.parse(birthday);
/* 124 */         logger.debug("18位身份证生日：" + d);
/* 125 */         Calendar calendar = new GregorianCalendar();
/* 126 */         calendar.setTime(d);
/* 127 */         int year = calendar.get(1);
/* 128 */         logger.debug("出身年份");
/* 129 */         return (year >= 1900) && (year <= 2099);
/*     */       }
/*     */       catch (ParseException ex)
/*     */       {
/* 134 */         logger.error("生日解析异常：\n" + ExceptionUtils.getFullStackTrace(ex));
/* 135 */         return false;
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 141 */     result = false;
/* 142 */     logger.warn(String.format("不符合规则=>身份证不符合15或18位规则！[id=%s,idPattern15=%s,idPattern18=%s]", new Object[] { id, "^[0-9]{15}$", "^[0-9]{17}[0-9xX]{1}$" }));
/* 143 */     return result;
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/* 150 */     BasicConfigurator.configure();
/* 151 */     Logger.getRootLogger().setLevel(Level.DEBUG);
/*     */ 
/* 153 */     System.out.println("身份证错误测试*5");
/* 154 */     System.out.println(filterId("42100219790619107"));
/* 155 */     System.out.println(filterId("421002197900191071"));
/* 156 */     System.out.println(filterId("421002200702291071"));
/* 157 */     System.out.println(filterId("421002187906191071"));
/* 158 */     System.out.println(filterId("421002217906191071"));
/*     */ 
/* 160 */     System.out.println("身份证正确测试*2");
/* 161 */     System.out.println(filterId("421002790619107"));
/* 162 */     System.out.println(filterId("421002197906191071"));
/*     */ 
/* 165 */     System.out.println("错误测试*3");
/* 166 */     System.out.println(filterName("a张三"));
/* 167 */     System.out.println(filterName("1张三"));
/* 168 */     System.out.println(filterName(",张三"));
/*     */ 
/* 170 */     System.out.println("错误测试*3");
/* 171 */     System.out.println(filterName("张a三"));
/* 172 */     System.out.println(filterName("张1三"));
/* 173 */     System.out.println(filterName("张,三"));
/*     */ 
/* 175 */     System.out.println("错误测试*3");
/* 176 */     System.out.println(filterName("张三a"));
/* 177 */     System.out.println(filterName("张三1"));
/* 178 */     System.out.println(filterName("张三,"));
/*     */ 
/* 180 */     System.out.println("错误测试*1");
/* 181 */     System.out.println(filterName("超长汉字测试中超长汉字测试中超长汉字测试中"));
/*     */ 
/* 183 */     System.out.println("正确测试*3");
/* 184 */     System.out.println(filterName("张三·"));
/* 185 */     System.out.println(filterName("张·三"));
/* 186 */     System.out.println(filterName("·张三"));
/*     */   }
/*     */ }

/* Location:           D:\李慧医药项目\tcmages\krt\WEB-INF\classes\
 * Qualified Name:     org.ssi.common.CheckFilter
 * JD-Core Version:    0.6.2
 */