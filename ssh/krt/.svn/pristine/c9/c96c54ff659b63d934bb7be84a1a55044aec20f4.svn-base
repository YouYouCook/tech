/*     */ package org.ssi.common;
/*     */ 
/*     */ import java.io.PrintStream;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Calendar;
/*     */ import java.util.Date;
/*     */ 
/*     */ public class DateUtils
/*     */ {
/*     */   public static final String FMT_DATE_YYYY = "yyyy";
/*     */   public static final String FMT_DATE_YYMMDD = "yyMMdd";
/*     */   public static final String FMT_DATE_YYYYMMDD = "yyyyMMdd";
/*     */   public static final String FMT_DATE_YYYY_MM_DD = "yyyy-MM-dd";
/*     */   public static final String FMT_DATE_DATETIME = "yyyy-MM-dd HH:mm:ss";
/*     */   public static final String FMT_DATE_DATETIME_TIGHT = "yyyyMMddHHmmss";
/*     */   public static final String FMT_DATE_YY_MM = "yy-MM";
/*     */   public static final String FMT_DATE_YYYY_MM = "yyyy-MM";
/*     */   public static final String FMT_DATE_MM = "MM";
/*     */   public static final String FMT_DATE_DD = "dd";
/*     */   public static final String FMT_DATE_TIME = "HH:mm:ss";
/*     */ 
/*     */   public static String formatDate(Date date, String strExpression)
/*     */   {
/*  50 */     SimpleDateFormat sdfDate = new SimpleDateFormat(strExpression);
/*  51 */     return sdfDate.format(date);
/*     */   }
/*     */ 
/*     */   public static Date getDate(String strDate)
/*     */   {
/*  63 */     SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd");
/*  64 */     Date date = null;
/*     */     try
/*     */     {
/*  67 */       date = sdfDate.parse(strDate);
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  71 */       date = null;
/*     */     }
/*  73 */     return date;
/*     */   }
/*     */ 
/*     */   public static String getChineseDate(Date date)
/*     */   {
/*  83 */     return getChineseDate(formatDate(date, "yyyy-MM-dd"));
/*     */   }
/*     */ 
/*     */   public static String getChineseDate(String strDate)
/*     */   {
/*  94 */     if ((strDate == null) || (strDate.length() != 10))
/*  95 */       return "";
/*  96 */     return strDate.substring(0, 4) + 
/*  97 */       "年" + 
/*  98 */       strDate.substring(5, 7) + 
/*  99 */       "月" + 
/* 100 */       strDate.substring(8, 10) + 
/* 101 */       "日";
/*     */   }
/*     */ 
/*     */   public static Date getFirstDayOfYear(Date date)
/*     */   {
/* 123 */     Calendar c = Calendar.getInstance();
/* 124 */     c.setTime(date);
/* 125 */     c.set(2, 0);
/* 126 */     c.set(5, 1);
/* 127 */     return c.getTime();
/*     */   }
/*     */ 
/*     */   public static Date getLastDayOfYear(Date date)
/*     */   {
/* 138 */     Calendar c = Calendar.getInstance();
/* 139 */     c.setTime(date);
/* 140 */     c.set(2, 11);
/* 141 */     c.set(5, 31);
/* 142 */     return c.getTime();
/*     */   }
/*     */ 
/*     */   public static Date getFirstDayOfMonth(Date date)
/*     */   {
/* 153 */     Calendar c = Calendar.getInstance();
/* 154 */     c.setTime(date);
/* 155 */     c.set(5, 1);
/* 156 */     return c.getTime();
/*     */   }
/*     */ 
/*     */   public static Date getLastDayOfMonth(Date date)
/*     */   {
/* 167 */     Calendar c = Calendar.getInstance();
/* 168 */     c.setTime(date);
/* 169 */     c.set(2, c.get(2) + 1);
/* 170 */     c.set(5, 1);
/* 171 */     c.add(5, -1);
/* 172 */     return c.getTime();
/*     */   }
/*     */ 
/*     */   public static Date getFirstDayOfWeek(Date date)
/*     */   {
/* 183 */     Calendar c = Calendar.getInstance();
/* 184 */     c.setTime(date);
/* 185 */     c.set(7, 1);
/* 186 */     return c.getTime();
/*     */   }
/*     */ 
/*     */   public static Date getLastDayOfWeek(Date date)
/*     */   {
/* 197 */     Calendar c = Calendar.getInstance();
/* 198 */     c.setTime(date);
/* 199 */     c.set(7, 7);
/* 200 */     return c.getTime();
/*     */   }
/*     */ 
/*     */   public static Date addTime(Date date, int year, int month, int day, int week)
/*     */   {
/* 221 */     Calendar c = Calendar.getInstance();
/* 222 */     c.setTime(date);
/* 223 */     c.add(1, year);
/* 224 */     c.add(2, month);
/* 225 */     c.add(5, day);
/* 226 */     c.add(3, week);
/* 227 */     return c.getTime();
/*     */   }
/*     */ 
/*     */   public static Date getSystemDate()
/*     */   {
/* 245 */     Calendar c = Calendar.getInstance();
/* 246 */     return c.getTime();
/*     */   }
/*     */ 
/*     */   public static String getSystemDate(String strExpression)
/*     */   {
/* 256 */     return formatDate(getSystemDate(), strExpression);
/*     */   }
/*     */ 
/*     */   public static String getSystemTime(String strTime)
/*     */   {
/* 266 */     return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
/*     */   }
/*     */ 
/*     */   public static String getSystemTime()
/*     */   {
/* 276 */     return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
/*     */   }
/*     */ 
/*     */   public static String getCurrentDateTime()
/*     */   {
/* 284 */     return new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
/*     */   }
/*     */ 
/*     */   public static void main(String[] args) {
/* 288 */     System.out.println(getCurrentDateTime());
/*     */   }
/*     */ }

/* Location:           D:\李慧医药项目\tcmages\krt\WEB-INF\classes\
 * Qualified Name:     org.ssi.common.DateUtils
 * JD-Core Version:    0.6.2
 */