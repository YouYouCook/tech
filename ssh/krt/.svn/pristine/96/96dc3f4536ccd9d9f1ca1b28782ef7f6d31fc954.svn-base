/*      */ package org.ssi.common;
/*      */ 
/*      */ import java.io.BufferedReader;
/*      */ import java.io.ByteArrayInputStream;
/*      */ import java.io.ByteArrayOutputStream;
/*      */ import java.io.IOException;
/*      */ import java.io.InputStream;
/*      */ import java.io.InputStreamReader;
/*      */ import java.io.PrintStream;
/*      */ import java.io.StringReader;
/*      */ import java.io.UnsupportedEncodingException;
/*      */ import java.lang.reflect.InvocationTargetException;
/*      */ import java.lang.reflect.Method;
/*      */ import java.math.BigDecimal;
/*      */ import java.net.ConnectException;
/*      */ import java.net.HttpURLConnection;
/*      */ import java.net.URL;
/*      */ import java.security.MessageDigest;
/*      */ import java.security.NoSuchAlgorithmException;
/*      */ import java.sql.SQLException;
/*      */ import java.sql.Time;
/*      */ import java.sql.Timestamp;
/*      */ import java.text.DecimalFormat;
/*      */ import java.text.SimpleDateFormat;
/*      */ import java.util.Calendar;
/*      */ import java.util.HashMap;
/*      */ import java.util.Iterator;
/*      */ import java.util.Map;
/*      */ import java.util.Random;
/*      */ import java.util.Set;
/*      */ import java.util.StringTokenizer;
/*      */ import java.util.Vector;
/*      */ import java.util.zip.ZipInputStream;
/*      */ import org.apache.commons.beanutils.BeanUtils;
/*      */ import org.hibernate.id.IdentifierGenerator;
/*      */ import org.hibernate.id.UUIDHexGenerator;
/*      */ import sun.misc.BASE64Encoder;
/*      */ 
/*      */ public class Operate
/*      */ {
/*   48 */   public static String DATABASE_DRIVER_TYPE = "oracle";
/*      */   public static final int FMT_DATE_YYYYMMDD = 1;
/*      */   public static final int FMT_DATE_YYYYMMDD_HHMMSS = 2;
/*      */   public static final int FMT_DATE_HHMMSS = 3;
/*      */   public static final int FMT_DATE_HHMM = 4;
/*      */   public static final int FMT_DATE_YYYYMM = 5;
/*      */   public static final int FMT_DATE_MMDD = 6;
/*   55 */   private static final IdentifierGenerator gen = new UUIDHexGenerator();
/*      */   private static final long DAY_TIME = 86400000L;
/*   58 */   private static String[] CN = { "零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", 
/*   59 */     "玖" };
/*      */ 
/*   60 */   private static String[] LP = { "仟", "佰", "拾", "亿", "仟", "佰", "拾", "万", "仟", 
/*   61 */     "佰", "拾", "元" };
/*      */ 
/*   62 */   private static String[] RP = { "角", "分" };
/*      */   public static final String m_strEncodeKeys = "qwertyuiop[]asdfghjkl;;'zxcvbnm,./QWERTYUIOP{}ASDFGHJKL:\"ZXCVBNM<>?`1234567890-=\\~!@#$%^&*()_+|";
/*      */ 
/*      */   public static String valueOf(boolean bool)
/*      */   {
/*   71 */     return bool ? "1" : "0";
/*      */   }
/*      */ 
/*      */   public static boolean valueOf(String key)
/*      */   {
/*   81 */     return (key.equals("1")) || (key == "1");
/*      */   }
/*      */ 
/*      */   public static String getDateTime(java.util.Date date)
/*      */   {
/*   91 */     return getDateTime(null, date);
/*      */   }
/*      */ 
/*      */   public static String getDateTime(String str, java.util.Date date)
/*      */   {
/*  103 */     String str_return = "";
/*      */ 
/*  105 */     if ((str == null) || ("".equals(str))) {
/*  106 */       str = "yyyy-MM-dd";
/*      */     }
/*  108 */     if (date != null) {
/*  109 */       str_return = new SimpleDateFormat(str).format(date);
/*      */     }
/*  111 */     return str_return;
/*      */   }
/*      */ 
/*      */   public static String getSysDateTime() {
/*  115 */     return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date());
/*      */   }
/*      */ 
/*      */   public static java.util.Date parseStringToDate(String strDate)
/*      */   {
/*  125 */     java.util.Date d = null;
/*      */     try {
/*  127 */       if ((strDate != null) && (!"".equals(strDate)))
/*      */       {
/*  129 */         d = java.sql.Date.valueOf(strDate);
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/*  133 */       d = null;
/*      */     }
/*  135 */     return d;
/*      */   }
/*      */ 
/*      */   public static java.util.Date parseDate(String time)
/*      */     throws Exception
/*      */   {
/*  146 */     return parseDate(null, time);
/*      */   }
/*      */ 
/*      */   public static java.util.Date parseDate(String str, String time)
/*      */     throws Exception
/*      */   {
/*  158 */     SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
/*  159 */     if ((str != null) && (!"".equals(str))) {
/*  160 */       sdf = new SimpleDateFormat(str);
/*      */     }
/*  162 */     return sdf.parse(time);
/*      */   }
/*      */ 
/*      */   public static Long[] valueOf(String[] str)
/*      */   {
/*  172 */     Long[] values = (Long[])null;
/*  173 */     if ((str != null) && (str.length > 0)) {
/*  174 */       values = new Long[str.length];
/*  175 */       for (int i = 0; i < str.length; i++) {
/*  176 */         values[i] = new Long(str[i]);
/*      */       }
/*      */     }
/*  179 */     return values;
/*      */   }
/*      */ 
/*      */   public static String addTime(String time, int minutes)
/*      */   {
/*  191 */     String value = null;
/*  192 */     if ((time != null) && (time.indexOf(":") != -1))
/*      */     {
/*  194 */       Time tt = new Time(Integer.parseInt(time.split(":")[0]), 
/*  195 */         Integer.parseInt(time.split(":")[1]), 0);
/*  196 */       tt.setTime(tt.getTime() + minutes * 60 * 1000);
/*      */ 
/*  198 */       if (tt.getMinutes() < 10)
/*  199 */         value = tt.getHours() + ":0" + tt.getMinutes();
/*      */       else
/*  201 */         value = tt.getHours() + ":" + tt.getMinutes();
/*      */     }
/*  203 */     return value;
/*      */   }
/*      */ 
/*      */   public static String pick(String url)
/*      */   {
/*  213 */     String sCurrentLine = "";
/*  214 */     String sTotalString = "";
/*  215 */     InputStream l_urlStream = null;
/*      */ 
/*  217 */     URL l_url = null;
/*      */ 
/*  219 */     HttpURLConnection l_connection = null;
/*      */ 
/*  221 */     BufferedReader l_reader = null;
/*      */     try
/*      */     {
/*  225 */       l_url = new URL(url);
/*      */ 
/*  228 */       l_connection = (HttpURLConnection)l_url.openConnection();
/*      */ 
/*  230 */       l_connection.connect();
/*      */ 
/*  232 */       l_urlStream = l_connection.getInputStream();
/*      */ 
/*  234 */       l_reader = new BufferedReader(new InputStreamReader(l_urlStream));
/*      */ 
/*  240 */       int i = 0;
/*      */ 
/*  242 */       while ((i = l_reader.read()) != -1) {
/*  243 */         sTotalString = sTotalString + (char)i;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (ConnectException localConnectException)
/*      */     {
/*      */       try
/*      */       {
/*  254 */         if (l_url != null) {
/*  255 */           l_url = null;
/*      */         }
/*  257 */         if (l_connection != null) {
/*  258 */           l_connection.disconnect();
/*  259 */           l_connection = null;
/*      */         }
/*  261 */         if (l_reader != null) {
/*  262 */           l_reader.close();
/*  263 */           l_reader = null;
/*      */         }
/*  265 */         if (l_urlStream != null) {
/*  266 */           l_urlStream.close();
/*  267 */           l_urlStream = null;
/*      */         }
/*      */       } catch (Exception e) {
/*  270 */         e.printStackTrace();
/*      */       }
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  249 */       e.printStackTrace(System.err);
/*      */       try
/*      */       {
/*  254 */         if (l_url != null) {
/*  255 */           l_url = null;
/*      */         }
/*  257 */         if (l_connection != null) {
/*  258 */           l_connection.disconnect();
/*  259 */           l_connection = null;
/*      */         }
/*  261 */         if (l_reader != null) {
/*  262 */           l_reader.close();
/*  263 */           l_reader = null;
/*      */         }
/*  265 */         if (l_urlStream != null) {
/*  266 */           l_urlStream.close();
/*  267 */           l_urlStream = null;
/*      */         }
/*      */       } catch (Exception e1) {
/*  270 */         e1.printStackTrace();
/*      */       }
/*      */     }
/*      */     finally
/*      */     {
/*      */       try
/*      */       {
/*  254 */         if (l_url != null) {
/*  255 */           l_url = null;
/*      */         }
/*  257 */         if (l_connection != null) {
/*  258 */           l_connection.disconnect();
/*  259 */           l_connection = null;
/*      */         }
/*  261 */         if (l_reader != null) {
/*  262 */           l_reader.close();
/*  263 */           l_reader = null;
/*      */         }
/*  265 */         if (l_urlStream != null) {
/*  266 */           l_urlStream.close();
/*  267 */           l_urlStream = null;
/*      */         }
/*      */       } catch (Exception e) {
/*  270 */         e.printStackTrace();
/*      */       }
/*      */     }
/*  273 */     return sTotalString;
/*      */   }
/*      */ 
/*      */   public static byte[] pickBytes(String url)
/*      */   {
/*  283 */     byte[] bytes = (byte[])null;
/*  284 */     InputStream l_urlStream = null;
/*      */ 
/*  286 */     URL l_url = null;
/*      */ 
/*  288 */     HttpURLConnection l_connection = null;
/*      */     try
/*      */     {
/*  294 */       l_url = new URL(url);
/*      */ 
/*  297 */       l_connection = (HttpURLConnection)l_url.openConnection();
/*      */ 
/*  299 */       l_connection.connect();
/*      */ 
/*  301 */       l_urlStream = l_connection.getInputStream();
/*  302 */       if (l_urlStream.available() > 0) {
/*  303 */         bytes = new byte[l_urlStream.available()];
/*  304 */         l_urlStream.read(bytes);
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (ConnectException localConnectException)
/*      */     {
/*      */       try
/*      */       {
/*  314 */         if (l_url != null) {
/*  315 */           l_url = null;
/*      */         }
/*  317 */         if (l_connection != null) {
/*  318 */           l_connection.disconnect();
/*  319 */           l_connection = null;
/*      */         }
/*  321 */         if (l_urlStream != null) {
/*  322 */           l_urlStream.close();
/*  323 */           l_urlStream = null;
/*      */         }
/*      */       } catch (Exception e) {
/*  326 */         e.printStackTrace();
/*      */       }
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  309 */       e.printStackTrace(System.err);
/*      */       try
/*      */       {
/*  314 */         if (l_url != null) {
/*  315 */           l_url = null;
/*      */         }
/*  317 */         if (l_connection != null) {
/*  318 */           l_connection.disconnect();
/*  319 */           l_connection = null;
/*      */         }
/*  321 */         if (l_urlStream != null) {
/*  322 */           l_urlStream.close();
/*  323 */           l_urlStream = null;
/*      */         }
/*      */       } catch (Exception e1) {
/*  326 */         e1.printStackTrace();
/*      */       }
/*      */     }
/*      */     finally
/*      */     {
/*      */       try
/*      */       {
/*  314 */         if (l_url != null) {
/*  315 */           l_url = null;
/*      */         }
/*  317 */         if (l_connection != null) {
/*  318 */           l_connection.disconnect();
/*  319 */           l_connection = null;
/*      */         }
/*  321 */         if (l_urlStream != null) {
/*  322 */           l_urlStream.close();
/*  323 */           l_urlStream = null;
/*      */         }
/*      */       } catch (Exception e) {
/*  326 */         e.printStackTrace();
/*      */       }
/*      */     }
/*  329 */     return bytes;
/*      */   }
/*      */ 
/*      */   public static String[] split(String source, String flag)
/*      */   {
/*  340 */     StringTokenizer token = new StringTokenizer(source, flag);
/*  341 */     int nCount = token.countTokens();
/*  342 */     String[] strArrays = new String[nCount];
/*  343 */     for (int i = 0; token.hasMoreElements(); i++) {
/*  344 */       strArrays[i] = ((String)token.nextElement());
/*      */     }
/*  346 */     return strArrays;
/*      */   }
/*      */ 
/*      */   public static String replaceFirst(String source, String rep, String obj)
/*      */   {
/*  358 */     if ((source != null) && (source.length() > 0) && (rep != null) && 
/*  359 */       (rep.length() > 0)) {
/*  360 */       String temp = "";
/*  361 */       for (int i = 0; i < source.length(); i++) {
/*  362 */         if (i + rep.length() <= source.length()) {
/*  363 */           temp = source.substring(i, i + rep.length());
/*  364 */           if ((temp != null) && (temp.equals(rep))) {
/*  365 */             source = source.substring(0, i) + 
/*  366 */               obj + 
/*  367 */               source.substring(i + rep.length(), 
/*  368 */               source.length());
/*  369 */             break;
/*      */           }
/*      */         }
/*      */       }
/*      */     }
/*  374 */     return source;
/*      */   }
/*      */ 
/*      */   public static int lastIndexOf(String source, String obj)
/*      */   {
/*  385 */     int nIndex = -1;
/*  386 */     if ((source != null) && (source.length() > 0) && (obj != null) && 
/*  387 */       (obj.length() > 0)) {
/*  388 */       String temp = "";
/*  389 */       for (int i = source.length() - 1; i >= 0; i--) {
/*  390 */         if (i - obj.length() >= 0) {
/*  391 */           temp = source.substring(i - obj.length(), i);
/*  392 */           if ((temp != null) && (temp.equals(obj))) {
/*  393 */             nIndex = i - obj.length();
/*  394 */             break;
/*      */           }
/*      */         }
/*      */       }
/*      */     }
/*  399 */     return nIndex;
/*      */   }
/*      */ 
/*      */   public static String showChinese(double dAmount)
/*      */   {
/*  404 */     return showChinese(dAmount, 1L);
/*      */   }
/*      */ 
/*      */   public static String showChinese(double dAmount, long lCurrencyID) {
/*  408 */     String sResult = "";
/*  409 */     String sAmount = reverseFormatAmount(formatAmount(dAmount, 4));
/*  410 */     if ((sAmount == null) || (sAmount == "") || (dAmount == 0.0D)) {
/*  411 */       sResult = "零元整";
/*      */     }
/*      */     else {
/*  414 */       int nPoint = sAmount.indexOf(".");
/*  415 */       String sLeft = "";
/*  416 */       String sRight = "";
/*  417 */       if (nPoint != -1) {
/*  418 */         sLeft = sAmount.substring(0, nPoint);
/*  419 */         sRight = sAmount.substring(nPoint + 1, sAmount.length());
/*      */       } else {
/*  421 */         sLeft = sAmount;
/*      */       }
/*  423 */       sResult = getLeftOfPoint(sLeft);
/*  424 */       if ((sResult == null) || (sResult.length() == 0)) {
/*  425 */         sResult = "零";
/*      */       }
/*  427 */       switch ((int)lCurrencyID) {
/*      */       case 1:
/*      */       default:
/*  430 */         sResult = sResult + "元";
/*  431 */         break;
/*      */       case 2:
/*  433 */         sResult = "美元" + sResult + "元";
/*  434 */         break;
/*      */       case 3:
/*  436 */         sResult = "英镑" + sResult + "镑";
/*  437 */         break;
/*      */       case 4:
/*  439 */         sResult = "欧元" + sResult + "元";
/*  440 */         break;
/*      */       case 5:
/*  442 */         sResult = "日元" + sResult + "元";
/*  443 */         break;
/*      */       case 6:
/*  445 */         sResult = "新加坡元" + sResult + "元";
/*      */       }
/*      */ 
/*  448 */       if (isLeftHaveSingle(sLeft)) {
/*  449 */         getRightOfPoint(sRight, lCurrencyID);
/*      */       }
/*      */ 
/*  452 */       sResult = sResult + getRightOfPoint(sRight, lCurrencyID);
/*  453 */       if (isFullRight(sRight, lCurrencyID)) {
/*  454 */         sResult = sResult + "整";
/*      */       }
/*      */     }
/*  457 */     return (sResult == null) || (sResult.length() == 0) ? "零元整" : sResult;
/*      */   }
/*      */ 
/*      */   public static String transferString(String str)
/*      */     throws Exception
/*      */   {
/*  468 */     StringBuffer sbResult = new StringBuffer();
/*  469 */     char[] cFilter = { '\'', '"', '\\' };
/*  470 */     if ((str != null) && (!str.equals(""))) {
/*  471 */       for (int i = 0; i < str.length(); i++) {
/*  472 */         for (int j = 0; j < cFilter.length; j++) {
/*  473 */           if (str.charAt(i) == cFilter[j]) {
/*  474 */             sbResult.append("\\");
/*      */           }
/*      */         }
/*  477 */         sbResult.append(str.charAt(i));
/*      */       }
/*      */     }
/*  480 */     return sbResult.toString();
/*      */   }
/*      */ 
/*      */   public static String replace(String strSource, String strFrom, String strTo)
/*      */   {
/*  496 */     if ((strFrom == null) || (strFrom.equals("")))
/*  497 */       return strSource;
/*  498 */     String strDest = "";
/*      */ 
/*  500 */     int intFromLen = strFrom.length();
/*      */     int intPos;
/*  503 */     while ((intPos = strSource.indexOf(strFrom)) != -1)
/*      */     {
/*      */      
/*  505 */       strDest = strDest + strSource.substring(0, intPos);
/*      */ 
/*  507 */       strDest = strDest + strTo;
/*      */ 
/*  509 */       strSource = strSource.substring(intPos + intFromLen);
/*      */     }
/*      */ 
/*  512 */     strDest = strDest + strSource;
/*      */ 
/*  514 */     return strDest;
/*      */   }
/*      */ 
/*      */   public static String formatAmount(double dAmount, int lSacle)
/*      */   {
/*  527 */     String strData = new BigDecimal(Math.abs(dAmount))
/*  528 */       .setScale(lSacle, 4)
/*  529 */       .toString();
/*      */ 
/*  532 */     int nPoint = strData.indexOf(".");
/*  533 */     String strFront = new String(strData); String strEnd = "";
/*  534 */     if (nPoint != -1) {
/*  535 */       strFront = strData.substring(0, nPoint);
/*  536 */       strEnd = strData.substring(nPoint + 1, strData.length());
/*      */     }
/*  538 */     String strTemp = "";
/*      */ 
/*  540 */     strTemp = new String(strFront);
/*  541 */     strFront = "";
/*      */ 
/*  543 */     int nNum = 0;
/*  544 */     for (int i = strTemp.length() - 1; i >= 0; i--) {
/*  545 */       if (nNum == 3) {
/*  546 */         strFront = "," + strFront;
/*  547 */         nNum = 0;
/*      */       }
/*  549 */       nNum++;
/*      */ 
/*  551 */       char cData = strTemp.charAt(i);
/*  552 */       strFront = cData + strFront;
/*      */     }
/*      */ 
/*  555 */     if (lSacle > 0) {
/*  556 */       strData = strFront + "." + strEnd;
/*      */     }
/*      */     else
/*      */     {
/*  560 */       strData = strFront;
/*      */     }
/*  562 */     if ((dAmount < 0.0D) && (!strData.equals("0.00"))) {
/*  563 */       strData = "-" + strData;
/*      */     }
/*  565 */     return strData;
/*      */   }
/*      */ 
/*      */   public static String formatAmountInt(int dAmount, int lScale)
/*      */   {
/*  578 */     String strTmp = "";
/*  579 */     StringBuffer strReturn = new StringBuffer();
/*  580 */     int iTmp = 0;
/*  581 */     strTmp = String.valueOf(dAmount);
/*  582 */     if ((iTmp = strTmp.length()) < lScale) {
/*  583 */       for (int i = 0; i < lScale - iTmp; i++) {
/*  584 */         strReturn.append("0");
/*      */       }
/*      */     }
/*  587 */     strReturn.append(strTmp);
/*  588 */     return strReturn.toString();
/*      */   }
/*      */ 
/*      */   public static String formatAmount2(double dAmount, int lSacle)
/*      */   {
/*  602 */     if ((dAmount > -1.E-009D) && (dAmount < 1.0E-007D))
/*  603 */       return "";
/*  604 */     String strData = new BigDecimal(Math.abs(dAmount))
/*  605 */       .setScale(lSacle, 4)
/*  606 */       .toString();
/*      */ 
/*  609 */     int nPoint = strData.indexOf(".");
/*  610 */     String strFront = new String(strData); String strEnd = "";
/*  611 */     if (nPoint != -1) {
/*  612 */       strFront = strData.substring(0, nPoint);
/*  613 */       strEnd = strData.substring(nPoint + 1, strData.length());
/*      */     }
/*  615 */     String strTemp = "";
/*      */ 
/*  617 */     strTemp = new String(strFront);
/*  618 */     strFront = "";
/*      */ 
/*  620 */     for (int i = strTemp.length() - 1; i >= 0; i--)
/*      */     {
/*  622 */       char cData = strTemp.charAt(i);
/*  623 */       strFront = cData + strFront;
/*      */     }
/*      */ 
/*  626 */     if (lSacle > 0) {
/*  627 */       strData = strFront + "." + strEnd;
/*      */     }
/*      */     else
/*      */     {
/*  631 */       strData = strFront;
/*      */     }
/*  633 */     if ((dAmount < 0.0D) && (!strData.equals("0.00"))) {
/*  634 */       strData = "-" + strData;
/*      */     }
/*  636 */     return strData;
/*      */   }
/*      */ 
/*      */   public static String formatAmount3(double dAmount, int lSacle)
/*      */   {
/*  650 */     return dAmount == 0.0D ? "" : formatAmount(dAmount, lSacle);
/*      */   }
/*      */ 
/*      */   public static String reverseFormatAmount(String strData)
/*      */   {
/*  663 */     String strTemp = new String(strData);
/*  664 */     strData = "";
/*  665 */     for (int i = 0; i < strTemp.length(); i++)
/*      */     {
/*  667 */       char cData = strTemp.charAt(i);
/*  668 */       if (cData != ',') {
/*  669 */         strData = strData + cData;
/*      */       }
/*      */     }
/*  672 */     return strData;
/*      */   }
/*      */ 
/*      */   public static double reverseFormatAmountTodouble(String strData)
/*      */   {
/*  682 */     if ((strData == null) || ("".equals(strData))) {
/*  683 */       return 0.0D;
/*      */     }
/*  685 */     return Double.parseDouble(reverseFormatAmount(strData));
/*      */   }
/*      */ 
/*      */   private static double getDouble(int iValue)
/*      */   {
/*  690 */     double dTempValue = 1.0D;
/*  691 */     for (int i = 0; i < iValue; i++) {
/*  692 */       dTempValue /= 10.0D;
/*      */     }
/*  694 */     return dTempValue;
/*      */   }
/*      */ 
/*      */   public static double doubleRound(double dValue, int lScale)
/*      */   {
/*  716 */     double dValue1 = Math.abs(dValue);
/*  717 */     BigDecimal bd1 = new BigDecimal(Double.toString(dValue1));
/*  718 */     BigDecimal bd2 = new BigDecimal(Double.toString(getDouble(lScale + 4)));
/*      */ 
/*  721 */     BigDecimal bd = bd1.add(bd2);
/*  722 */     bd = bd.setScale(lScale, 4);
/*  723 */     if (dValue >= 0.0D) {
/*  724 */       return bd.doubleValue();
/*      */     }
/*  726 */     return bd.doubleValue() * -1.0D;
/*      */   }
/*      */ 
/*      */   public static double doubleRound2(double dValue, int lScale)
/*      */   {
/*  732 */     BigDecimal bd = new BigDecimal(Double.toString(dValue));
/*  733 */     bd = bd.setScale(lScale, 0);
/*  734 */     return bd.doubleValue();
/*      */   }
/*      */ 
/*      */   public static String convertDigToCH(int iDigital)
/*      */   {
/*  745 */     String[] strArray = { "一", "二", "三", "四", "五", "六", "七", "八", "九", "十" };
/*  746 */     String strReturn = "";
/*  747 */     if (iDigital <= 10) {
/*  748 */       strReturn = "第" + strArray[(iDigital - 1)] + "条";
/*      */     }
/*  750 */     if ((iDigital > 10) && (iDigital < 100)) {
/*  751 */       if (iDigital % 10 == 0) {
/*  752 */         if (iDigital == 10)
/*  753 */           strReturn = "第十条";
/*      */         else {
/*  755 */           strReturn = "第" + strArray[(iDigital / 10 - 1)] + "十" + "条";
/*      */         }
/*      */       }
/*  758 */       else if (iDigital / 10 < 2)
/*  759 */         strReturn = "第十" + strArray[(iDigital % 10 - 1)] + "条";
/*      */       else {
/*  761 */         strReturn = "第" + strArray[(iDigital / 10 - 1)] + "十" + 
/*  762 */           strArray[(iDigital % 10)] + "条";
/*      */       }
/*      */     }
/*      */ 
/*  766 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public static String toUtf8String(String str)
/*      */   {
/*  776 */     StringBuffer sb = new StringBuffer();
/*  777 */     for (int i = 0; i < str.length(); i++) {
/*  778 */       char c = str.charAt(i);
/*  779 */       if ((c >= 0) && (c < 'ÿ')) {
/*  780 */         sb.append(c);
/*      */       } else {
/*  782 */         byte[] b = (byte[])null;
/*      */         try {
/*  784 */           b = String.valueOf(new char[] { c }).getBytes("utf-8");
/*      */         } catch (Exception ex) {
/*  786 */           System.out.println(ex);
/*      */         }
/*  788 */         if (b != null) {
/*  789 */           for (int j = 0; j < b.length; j++) {
/*  790 */             int k = b[j];
/*  791 */             if (k < 0) {
/*  792 */               k += 256;
/*      */             }
/*      */ 
/*  795 */             sb.append(Integer.toHexString(k).toUpperCase());
/*      */           }
/*      */         }
/*      */       }
/*      */     }
/*  800 */     return sb.toString();
/*      */   }
/*      */ 
/*      */   public static String FormatContent(String content) throws Exception {
/*  804 */     StringReader stringReader = new StringReader(content);
/*  805 */     BufferedReader bufferedReader = new BufferedReader(stringReader);
/*  806 */     int i = 0;
/*  807 */     String temp = "";
/*  808 */     while ((i = bufferedReader.read()) != -1) {
/*  809 */       if (i == 60) {
/*  810 */         temp.replace('<', ' ');
/*  811 */         temp = temp + "&lt;";
/*  812 */       } else if (i == 62) {
/*  813 */         temp.replace('>', ' ');
/*  814 */         temp = temp + "&gt;";
/*  815 */       } else if (i == 39) {
/*  816 */         temp.replace('\'', ' ');
/*  817 */         temp = temp + "&#39;";
/*  818 */       } else if (i == 34) {
/*  819 */         temp.replace('"', ' ');
/*  820 */         temp = temp + "&quot;";
/*      */       } else {
/*  822 */         temp = temp + (char)i;
/*      */       }
/*      */     }
/*  825 */     return temp;
/*      */   }
/*      */ 
/*      */   private static boolean isLeftHaveSingle(String strData)
/*      */   {
/*  834 */     if (Integer.parseInt(strData.substring(strData.length() - 1, 
/*  835 */       strData.length())) > 0) {
/*  836 */       return false;
/*      */     }
/*  838 */     return true;
/*      */   }
/*      */ 
/*      */   private static String getLeftOfPoint(String sLeft)
/*      */   {
/*  846 */     long lYiNum = 0L;
/*  847 */     long lWalNum = 0L;
/*  848 */     long lRemailNum = 0L;
/*  849 */     String strReturn = "";
/*      */ 
/*  851 */     lRemailNum = Long.valueOf(sLeft).longValue();
/*  852 */     lYiNum = lRemailNum / 100000000L;
/*  853 */     lRemailNum -= lYiNum * 100000000L;
/*  854 */     lWalNum = lRemailNum / 10000L;
/*  855 */     lRemailNum -= lWalNum * 10000L;
/*      */ 
/*  858 */     if (lYiNum > 0L)
/*      */     {
/*  860 */       if (lYiNum >= 10000L)
/*  861 */         strReturn = strReturn + getLeftOfPoint(sLeft);
/*      */       else {
/*  863 */         strReturn = strReturn + getThousandChineseData(lYiNum);
/*      */       }
/*  865 */       strReturn = strReturn + "亿";
/*      */ 
/*  867 */       if (((lWalNum > 0L) || (lRemailNum > 0L)) && 
/*  868 */         (lWalNum < 1000L) && (lWalNum > 0L)) {
/*  869 */         strReturn = strReturn + "零";
/*      */       }
/*      */     }
/*      */ 
/*  873 */     if (lWalNum > 0L) {
/*  874 */       strReturn = strReturn + getThousandChineseData(lWalNum);
/*  875 */       strReturn = strReturn + "万";
/*  876 */       if ((lRemailNum > 0L) && 
/*  877 */         (lRemailNum < 1000L) && (lRemailNum > 0L)) {
/*  878 */         strReturn = strReturn + "零";
/*      */       }
/*      */     }
/*      */ 
/*  882 */     if (lRemailNum > 0L) {
/*  883 */       strReturn = strReturn + getThousandChineseData(lRemailNum);
/*      */     }
/*  885 */     return strReturn;
/*      */   }
/*      */ 
/*      */   private static String getThousandChineseData(long lData)
/*      */   {
/*  892 */     String strReturn = "";
/*  893 */     if (lData > 9999L) {
/*  894 */       return "错误的千";
/*      */     }
/*  896 */     long lRemailNum = lData;
/*  897 */     long lThousandNum = 0L;
/*  898 */     long lHundredNum = 0L;
/*  899 */     long lTelNum = 0L;
/*  900 */     long lNum = 0L;
/*      */ 
/*  902 */     lThousandNum = lRemailNum / 1000L;
/*  903 */     lRemailNum -= lThousandNum * 1000L;
/*  904 */     lHundredNum = lRemailNum / 100L;
/*  905 */     lRemailNum -= lHundredNum * 100L;
/*  906 */     lTelNum = lRemailNum / 10L;
/*  907 */     lNum = lRemailNum - lTelNum * 10L;
/*  908 */     if (lThousandNum > 0L) {
/*  909 */       strReturn = strReturn + CN[((int)lThousandNum)] + "仟";
/*      */     }
/*  911 */     if (lHundredNum > 0L) {
/*  912 */       strReturn = strReturn + CN[((int)lHundredNum)] + "佰";
/*      */     }
/*  914 */     if (lTelNum > 0L) {
/*  915 */       if ((lThousandNum > 0L) && (lHundredNum == 0L)) {
/*  916 */         strReturn = strReturn + "零";
/*      */       }
/*  918 */       strReturn = strReturn + CN[((int)lTelNum)] + "拾";
/*      */     }
/*  920 */     if (lNum > 0L) {
/*  921 */       if ((lTelNum == 0L) && (
/*  922 */         (lThousandNum > 0L) || (lHundredNum > 0L))) {
/*  923 */         strReturn = strReturn + "零";
/*      */       }
/*      */ 
/*  926 */       strReturn = strReturn + CN[((int)lNum)];
/*      */     }
/*      */ 
/*  929 */     return strReturn;
/*      */   }
/*      */ 
/*      */   private static boolean isFullRight(String sRight, long lCurrencyID)
/*      */   {
/*  941 */     if (sRight.equals("")) {
/*  942 */       sRight = "00";
/*      */     }
/*  944 */     else if (sRight.length() == 1) {
/*  945 */       sRight = sRight + "0";
/*      */     }
/*      */ 
/*  948 */     boolean bIsFull = false;
/*  949 */     if (sRight.equals("")) {
/*  950 */       bIsFull = true;
/*      */     } else {
/*  952 */       sRight = sRight.substring(0, 2);
/*  953 */       if (Integer.parseInt(sRight) == 0)
/*  954 */         bIsFull = true;
/*      */       else {
/*  956 */         switch ((int)lCurrencyID) {
/*      */         case 1:
/*  958 */           if (Integer.parseInt(sRight) >= 10)
/*      */           {
/*  960 */             if ((sRight.substring(1, 2).equals("0")) || 
/*  961 */               (sRight.substring(1, 2).equals(""))) {
/*  962 */               bIsFull = true;
/*      */             }
/*      */           }
/*  965 */           break;
/*      */         case 2:
/*      */         case 3:
/*      */         case 4:
/*      */         case 6:
/*  970 */           if (Integer.parseInt(sRight) == 0) {
/*  971 */             bIsFull = true;
/*      */           }
/*  973 */           break;
/*      */         case 5:
/*  975 */           bIsFull = true;
/*      */         }
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/*  981 */     return bIsFull;
/*      */   }
/*      */ 
/*      */   private static String getRightOfPoint(String sRight, long lCurrencyID)
/*      */   {
/*  986 */     if (sRight.equals("")) {
/*  987 */       sRight = "00";
/*      */     }
/*  989 */     else if (sRight.length() == 1) {
/*  990 */       sRight = sRight + "0";
/*      */     }
/*      */ 
/*  993 */     sRight = sRight.substring(0, 2);
/*  994 */     long lRight = Long.valueOf(sRight).longValue();
/*  995 */     String sb = "";
/*  996 */     if (lRight > 0L) {
/*  997 */       if (lRight < 10L) {
/*  998 */         sb = sb + "零";
/*      */       }
/* 1000 */       switch ((int)lCurrencyID) {
/*      */       case 1:
/*      */       default:
/* 1003 */         for (int i = 0; i < sRight.length(); i++) {
/* 1004 */           long lNum = Long.valueOf(sRight.substring(i, i + 1))
/* 1005 */             .longValue();
/* 1006 */           if (lNum != 0L) {
/* 1007 */             sb = sb + CN[((int)lNum)];
/* 1008 */             sb = sb + RP[i];
/*      */           }
/*      */         }
/* 1011 */         break;
/*      */       case 2:
/* 1014 */         sb = sb + getThousandChineseData(lRight) + "美分";
/* 1015 */         break;
/*      */       case 3:
/* 1017 */         sb = sb + getThousandChineseData(lRight) + "便士";
/* 1018 */         break;
/*      */       case 4:
/* 1020 */         sb = sb + getThousandChineseData(lRight) + "欧分";
/*      */       }
/*      */     }
/*      */ 
/* 1024 */     return sb;
/*      */   }
/*      */ 
/*      */   public static String enMonthToNum(String strEnMonth)
/*      */   {
/* 1035 */     String strTemp = strEnMonth;
/* 1036 */     String[] strEnMonths = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", 
/* 1037 */       "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };
/* 1038 */     String[] strNumMonths = { "01", "02", "03", "04", "05", "06", "07", 
/* 1039 */       "08", "09", "10", "11", "12" };
/*      */ 
/* 1041 */     for (int i = 0; i < strEnMonths.length; i++) {
/* 1042 */       if (strEnMonths[i].toUpperCase().equals(strTemp.toUpperCase())) {
/* 1043 */         strTemp = strNumMonths[i];
/* 1044 */         break;
/*      */       }
/*      */     }
/* 1047 */     return strTemp;
/*      */   }
/*      */ 
/*      */   public static String getSystemDate()
/*      */   {
/* 1057 */     SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
/* 1058 */     return simpleDateFormat.format(new java.util.Date(System.currentTimeMillis()));
/*      */   }
/*      */ 
/*      */   public static String getSystemTime()
/*      */   {
/* 1069 */     SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:MM:ss");
/* 1070 */     return simpleDateFormat.format(new java.util.Date(System.currentTimeMillis()));
/*      */   }
/*      */ 
/*      */   public static String getSystemDateTime()
/*      */   {
/* 1080 */     SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
/* 1081 */       "yyyy-MM-dd HH:mm:ss");
/* 1082 */     return simpleDateFormat.format(new java.util.Date(System.currentTimeMillis()));
/*      */   }
/*      */ 
/*      */   public static String getSystemDateTime24()
/*      */   {
/* 1092 */     SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
/* 1093 */       "yyyy-MM-dd HH:mm:ss");
/* 1094 */     return simpleDateFormat.format(new java.util.Date(System.currentTimeMillis()));
/*      */   }
/*      */ 
/*      */   public static String formatDate(long lTime, String strFormat)
/*      */   {
/* 1105 */     SimpleDateFormat simpleDateFormat = new SimpleDateFormat(strFormat);
/* 1106 */     return simpleDateFormat.format(new java.util.Date(lTime));
/*      */   }
/*      */ 
/*      */   public static String formatDate(String strTime, String strFormatChar)
/*      */   {
/* 1117 */     SimpleDateFormat simpleDateFormat = new SimpleDateFormat(strFormatChar);
/* 1118 */     return simpleDateFormat.format(new java.util.Date(Long.parseLong(strTime)));
/*      */   }
/*      */ 
/*      */   public static String formatDate(java.util.Date dtDate, String strFormatChar)
/*      */   {
/* 1129 */     SimpleDateFormat simpleDateFormat = new SimpleDateFormat(strFormatChar);
/* 1130 */     return simpleDateFormat.format(dtDate);
/*      */   }
/*      */ 
/*      */   public static String formatCurrencyDouble(int nFraction, double dfValue)
/*      */   {
/* 1141 */     return formatCurrencyDouble(dfValue, nFraction + 1, nFraction, false, 0);
/*      */   }
/*      */ 
/*      */   private static String formatCurrencyDouble(double dfValue, int nWidth, int nFraction, boolean bZeroPreffixed, int nGroupWidth)
/*      */   {
/* 1157 */     DecimalFormat dfDouble = new DecimalFormat();
/* 1158 */     if (nGroupWidth > 0) {
/* 1159 */       dfDouble.setGroupingSize(nGroupWidth + 1);
/* 1160 */       dfDouble.setGroupingUsed(true);
/*      */     }
/* 1162 */     if (bZeroPreffixed) {
/* 1163 */       dfDouble.setMinimumIntegerDigits(1);
/*      */     }
/*      */ 
/* 1166 */     dfDouble.setMaximumFractionDigits(nFraction - 1);
/* 1167 */     dfDouble.setMinimumFractionDigits(nFraction - 1);
/* 1168 */     String sValue = dfDouble.format(dfValue);
/* 1169 */     return sValue;
/*      */   }
/*      */ 
/*      */   public static String formatDouble(int nFraction, double dfValue)
/*      */   {
/* 1181 */     String sPoint = "###0.0";
/* 1182 */     for (int i = 1; i < nFraction - 1; i++) {
/* 1183 */       sPoint = sPoint + "0";
/*      */     }
/* 1185 */     DecimalFormat dfDouble = new DecimalFormat(sPoint);
/* 1186 */     String sValue = dfDouble.format(dfValue);
/*      */ 
/* 1188 */     if (dfValue > 0.0D)
/*      */     {
/* 1190 */       while ((sValue.substring(sValue.length() - 1, sValue.length())
/* 1190 */         .equals("0")) || (
/* 1191 */         sValue.substring(sValue.length() - 1, sValue.length())
/* 1192 */         .equals(".")))
/*      */       {
/* 1194 */         if (sValue.substring(sValue.length() - 1, sValue.length())
/* 1194 */           .equals(".")) {
/* 1195 */           sValue = sValue.substring(0, sValue.length() - 1);
/* 1196 */           break;
/*      */         }
/* 1198 */         sValue = sValue.substring(0, sValue.length() - 1);
/*      */       }
/*      */     }
/*      */     else
/*      */     {
/* 1203 */       sValue = "0";
/*      */     }
/*      */ 
/* 1206 */     return sValue;
/*      */   }
/*      */ 
/*      */   public static String formatRate(int nFraction, double dfValue)
/*      */   {
/* 1218 */     String sValue = "0";
/* 1219 */     if (nFraction == 0) {
/* 1220 */       Double dTemp = new Double(dfValue);
/* 1221 */       sValue = String.valueOf(dTemp.intValue());
/*      */     }
/* 1223 */     else if (nFraction > 0) {
/* 1224 */       sValue = formatDouble(nFraction + 1, dfValue);
/*      */     }
/* 1226 */     sValue = sValue + "%";
/*      */ 
/* 1228 */     return sValue;
/*      */   }
/*      */ 
/*      */   public static java.sql.Date getDate(String strDate)
/*      */     throws SQLException
/*      */   {
/* 1239 */     return java.sql.Date.valueOf(strDate);
/*      */   }
/*      */ 
/*      */   public static String addDate(String strTime, int lTime, String strType)
/*      */     throws SQLException
/*      */   {
/* 1252 */     Calendar m = Calendar.getInstance();
/* 1253 */     String sReturn = "";
/* 1254 */     m.setTime(getDate(strTime));
/* 1255 */     if (strType.equalsIgnoreCase("d"))
/* 1256 */       m.add(5, lTime);
/* 1257 */     else if (strType.equalsIgnoreCase("m"))
/* 1258 */       m.add(2, lTime);
/* 1259 */     else if (strType.equalsIgnoreCase("y"))
/* 1260 */       m.add(1, lTime);
/* 1261 */     sReturn = sReturn + m.get(1) + "-";
/* 1262 */     if (("0" + (m.get(2) + 1)).length() == 2)
/* 1263 */       sReturn = sReturn + "0" + (m.get(2) + 1) + "-";
/*      */     else
/* 1265 */       sReturn = sReturn + (m.get(2) + 1) + "-";
/* 1266 */     if (("0" + m.get(5)).length() == 2)
/* 1267 */       sReturn = sReturn + "0" + m.get(5);
/*      */     else
/* 1269 */       sReturn = sReturn + m.get(5);
/* 1270 */     return sReturn;
/*      */   }
/*      */ 
/*      */   public static String formatDate(java.sql.Date date, int nFmt)
/*      */   {
/* 1282 */     SimpleDateFormat fmtDate = null;
/* 1283 */     switch (nFmt)
/*      */     {
/*      */     case 1:
/* 1286 */       fmtDate = new SimpleDateFormat("yyyy-MM-dd");
/* 1287 */       break;
/*      */     case 5:
/* 1289 */       fmtDate = new SimpleDateFormat("yyyy-MM");
/* 1290 */       break;
/*      */     case 2:
/* 1293 */       fmtDate = new SimpleDateFormat("yyyy-MM-dd HH:mm");
/* 1294 */       break;
/*      */     case 4:
/* 1296 */       fmtDate = new SimpleDateFormat("HH:mm");
/* 1297 */       break;
/*      */     case 3:
/* 1299 */       fmtDate = new SimpleDateFormat("HH:mm:ss");
/* 1300 */       break;
/*      */     case 6:
/* 1302 */       fmtDate = new SimpleDateFormat("MM.dd");
/*      */     }
/*      */ 
/* 1306 */     return fmtDate.format(date);
/*      */   }
/*      */ 
/*      */   public static String formatDate(Timestamp date, int nFmt)
/*      */   {
/* 1319 */     SimpleDateFormat fmtDate = null;
/* 1320 */     switch (nFmt)
/*      */     {
/*      */     case 1:
/* 1323 */       fmtDate = new SimpleDateFormat("yyyy-MM-dd");
/* 1324 */       break;
/*      */     case 5:
/* 1326 */       fmtDate = new SimpleDateFormat("yyyy-MM");
/* 1327 */       break;
/*      */     case 2:
/* 1330 */       fmtDate = new SimpleDateFormat("yyyy-MM-dd HH:mm");
/* 1331 */       break;
/*      */     case 4:
/* 1333 */       fmtDate = new SimpleDateFormat("HH:mm");
/* 1334 */       break;
/*      */     case 3:
/* 1336 */       fmtDate = new SimpleDateFormat("HH:mm:ss");
/*      */     }
/*      */ 
/* 1340 */     return fmtDate.format(date);
/*      */   }
/*      */ 
/*      */   public static String getFileName(String strFilePath)
/*      */   {
/* 1351 */     int nIndex = 0;
/* 1352 */     if ((nIndex = strFilePath.lastIndexOf('\\')) == -1) {
/* 1353 */       nIndex = strFilePath.lastIndexOf('/');
/*      */     }
/* 1355 */     return strFilePath.substring(nIndex + 1, strFilePath.length());
/*      */   }
/*      */ 
/*      */   public static String filterHTML(String strHTML)
/*      */   {
/* 1367 */     if (strHTML == null) {
/* 1368 */       return "";
/*      */     }
/* 1370 */     StringBuffer sbResult = new StringBuffer();
/* 1371 */     int nLen = strHTML.length();
/*      */ 
/* 1373 */     for (int i = 0; i < nLen; i++) {
/* 1374 */       char chCur = strHTML.charAt(i);
/*      */ 
/* 1376 */       switch (chCur) {
/*      */       case '"':
/* 1378 */         sbResult.append("&quot;");
/* 1379 */         break;
/*      */       case '>':
/* 1381 */         sbResult.append("&gt;");
/* 1382 */         break;
/*      */       case '<':
/* 1384 */         sbResult.append("&lt;");
/* 1385 */         break;
/*      */       case '\n':
/*      */       case '\r':
/* 1388 */         sbResult.append("<br>");
/* 1389 */         break;
/*      */       default:
/* 1391 */         sbResult.append(chCur);
/*      */       }
/*      */     }
/*      */ 
/* 1395 */     return sbResult.toString();
/*      */   }
/*      */ 
/*      */   private static String normalizeString(String strValue)
/*      */   {
/* 1406 */     return strValue == null ? "" : strValue.trim();
/*      */   }
/*      */ 
/*      */   public static String toChinese(String str)
/*      */   {
/*      */     try
/*      */     {
/* 1418 */       return new String(normalizeString(str).getBytes("ISO8859_1"), "GBK");
/*      */     } catch (UnsupportedEncodingException uee) {
/* 1420 */       uee.printStackTrace();
/* 1421 */     }return null;
/*      */   }
/*      */ 
/*      */   public static String transString(String strIn, char cTransferChar, long lType)
/*      */   {
/* 1438 */     String strReturn = "";
/*      */ 
/* 1440 */     for (int nIndex = 0; nIndex < strIn.length(); nIndex++) {
/* 1441 */       char cChar = strIn.charAt(nIndex);
/* 1442 */       switch (cChar) {
/*      */       case '\'':
/* 1444 */         strReturn = strReturn + "'";
/* 1445 */         break;
/*      */       case '%':
/* 1447 */         if (lType == 0L)
/* 1448 */           strReturn = strReturn + new Character(cTransferChar);
/* 1449 */         break;
/*      */       case '_':
/* 1452 */         if (lType == 0L) {
/* 1453 */           strReturn = strReturn + new Character(cTransferChar);
/*      */         }
/*      */         break;
/*      */       }
/* 1457 */       if ((cChar == cTransferChar) && (lType == 0L)) {
/* 1458 */         strReturn = strReturn + new Character(cTransferChar);
/*      */       }
/* 1460 */       strReturn = strReturn + new Character(cChar);
/*      */     }
/* 1462 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public static Vector changeStringGroup(String strParam, String strSeparator)
/*      */   {
/* 1475 */     String strData = "";
/* 1476 */     Vector vcReturn = new Vector();
/* 1477 */     if ((strParam != null) && (!strParam.equals(""))) {
/* 1478 */       StringTokenizer st = new StringTokenizer(strParam, strSeparator);
/* 1479 */       while (st.hasMoreTokens()) {
/* 1480 */         strData = st.nextToken();
/* 1481 */         vcReturn.add(strData);
/*      */       }
/*      */     } else {
/* 1484 */       vcReturn.add(strData);
/* 1485 */     }return vcReturn;
/*      */   }
/*      */ 
/*      */   public static String randomPassword(int nLen)
/*      */   {
/* 1498 */     if (nLen <= 0)
/* 1499 */       nLen = 8;
/* 1500 */     char[] charyKeys = new char[nLen];
/* 1501 */     char[] charyEncodeKeys = "qwertyuiop[]asdfghjkl;;'zxcvbnm,./QWERTYUIOP{}ASDFGHJKL:\"ZXCVBNM<>?`1234567890-=\\~!@#$%^&*()_+|".toCharArray();
/* 1502 */     Random rndSequence = new Random();
/*      */ 
/* 1504 */     int nKeyLen = "qwertyuiop[]asdfghjkl;;'zxcvbnm,./QWERTYUIOP{}ASDFGHJKL:\"ZXCVBNM<>?`1234567890-=\\~!@#$%^&*()_+|".length();
/* 1505 */     for (int i = 0; i < nLen; i++) {
/* 1506 */       int nSequence = Math.abs(rndSequence.nextInt()) % nKeyLen;
/* 1507 */       charyKeys[i] = charyEncodeKeys[nSequence];
/*      */     }
/* 1509 */     return charyKeys.toString();
/*      */   }
/*      */ 
/*      */   public static long getDays(java.sql.Date dtBegin, java.sql.Date dtEnd)
/*      */     throws Exception
/*      */   {
/* 1526 */     if ((dtBegin == null) || (dtEnd == null)) {
/* 1527 */       throw new Exception("Parameter is null!");
/*      */     }
/*      */ 
/* 1530 */     if (dtBegin.after(dtEnd)) {
/* 1531 */       throw new Exception("Begin Time after End Time!");
/*      */     }
/*      */ 
/* 1534 */     Calendar temp = Calendar.getInstance();
/*      */ 
/* 1536 */     temp.setTime(dtBegin);
/* 1537 */     temp.set(10, 0);
/* 1538 */     temp.set(12, 0);
/* 1539 */     temp.set(13, 0);
/* 1540 */     temp.set(14, 0);
/* 1541 */     long lBegin = temp.getTime().getTime();
/*      */ 
/* 1543 */     temp.setTime(dtEnd);
/* 1544 */     temp.set(10, 0);
/* 1545 */     temp.set(12, 0);
/* 1546 */     temp.set(13, 0);
/* 1547 */     temp.set(14, 0);
/* 1548 */     long lEnd = temp.getTime().getTime();
/*      */ 
/* 1550 */     long lTime = (lEnd - lBegin) / 86400000L;
/*      */ 
/* 1552 */     return lTime;
/*      */   }
/*      */ 
/*      */   public static int getDaysOfMonth(int iYear, int iMonth)
/*      */   {
/* 1563 */     Calendar cal = Calendar.getInstance();
/* 1564 */     cal.clear();
/* 1565 */     cal.set(iYear, iMonth, 1);
/* 1566 */     int result = cal.getActualMaximum(5);
/*      */ 
/* 1568 */     return result;
/*      */   }
/*      */ 
/*      */   public static java.util.Date getEndDayOfMonth(int iYear, int iMonth)
/*      */   {
/* 1579 */     int endDay = getDaysOfMonth(iYear, iMonth);
/*      */ 
/* 1581 */     Calendar cal = Calendar.getInstance();
/* 1582 */     cal.clear();
/* 1583 */     cal.set(iYear, iMonth, endDay);
/*      */ 
/* 1585 */     java.util.Date result = cal.getTime();
/*      */ 
/* 1587 */     return result;
/*      */   }
/*      */ 
/*      */   public static int getMonths(java.util.Date dtBegin, java.util.Date dtEnd)
/*      */   {
/* 1600 */     int result = 0;
/*      */ 
/* 1602 */     Calendar calBegin = Calendar.getInstance();
/* 1603 */     calBegin.clear();
/* 1604 */     calBegin.setTime(dtBegin);
/* 1605 */     Calendar calEnd = Calendar.getInstance();
/* 1606 */     calEnd.clear();
/* 1607 */     calEnd.setTime(dtEnd);
/*      */ 
/* 1609 */     if ((calBegin.before(calEnd)) || (calBegin.equals(calEnd)))
/*      */     {
/* 1611 */       if (calBegin.get(1) == calEnd.get(1)) {
/* 1612 */         result = calEnd.get(2) - 
/* 1613 */           calBegin.get(2) + 1;
/*      */       } else {
/* 1615 */         result = (calEnd.get(1) - 
/* 1616 */           calBegin.get(1)) * 12;
/* 1617 */         result = result - calBegin.get(2) + 
/* 1618 */           calEnd.get(2) + 1;
/*      */       }
/*      */     }
/*      */ 
/* 1622 */     return result;
/*      */   }
/*      */ 
/*      */   public static boolean compareDate(java.util.Date dtOne, java.util.Date dtOther)
/*      */   {
/* 1634 */     boolean result = false;
/*      */ 
/* 1636 */     if ((dtOne != null) && (dtOther != null)) {
/* 1637 */       Calendar calOne = Calendar.getInstance();
/* 1638 */       calOne.clear();
/* 1639 */       calOne.setTime(dtOne);
/*      */ 
/* 1641 */       Calendar calOther = Calendar.getInstance();
/* 1642 */       calOther.clear();
/* 1643 */       calOther.setTime(dtOther);
/*      */ 
/* 1645 */       result = calOne.get(1) == calOther.get(1);
/*      */ 
/* 1647 */       result = result & calOne.get(2) == 
/* 1647 */         calOther.get(2);
/* 1648 */       result &= calOne.get(5) == calOther.get(5);
/*      */     }
/*      */ 
/* 1652 */     return result;
/*      */   }
/*      */ 
/*      */   public static long getLongValue(String strLong)
/*      */   {
/* 1662 */     long lReturn = -1L;
/*      */     try {
/* 1664 */       if ((strLong != null) && (!strLong.equals("")))
/* 1665 */         lReturn = Long.valueOf(strLong).longValue();
/*      */     }
/*      */     catch (Exception e) {
/* 1668 */       lReturn = -1L;
/*      */     }
/* 1670 */     return lReturn;
/*      */   }
/*      */ 
/*      */   public static double getDoubleValue(String strDouble)
/*      */   {
/* 1680 */     double dReturn = 0.0D;
/*      */     try {
/* 1682 */       if ((strDouble != null) && (!"".equals(strDouble)))
/* 1683 */         dReturn = Double.valueOf(strDouble).doubleValue();
/*      */     }
/*      */     catch (Exception e) {
/* 1686 */       dReturn = 0.0D;
/*      */     }
/* 1688 */     return dReturn;
/*      */   }
/*      */ 
/*      */   public static int getIntValue(String strInt)
/*      */   {
/* 1698 */     int nReturn = 0;
/*      */     try {
/* 1700 */       if ((strInt != null) && (!strInt.equals("")))
/* 1701 */         nReturn = Integer.parseInt(strInt);
/*      */     }
/*      */     catch (Exception e) {
/* 1704 */       nReturn = -1;
/*      */     }
/* 1706 */     return nReturn;
/*      */   }
/*      */ 
/*      */   public static String formatString(String str)
/*      */   {
/* 1716 */     String strReturn = "";
/* 1717 */     if (str != null) {
/* 1718 */       strReturn = str.trim();
/*      */     }
/* 1720 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public static String[] formatStringArray(String[] strArray) {
/* 1724 */     String[] arrayRtn = (String[])null;
/* 1725 */     if ((strArray != null) && (strArray.length > 0)) {
/* 1726 */       arrayRtn = new String[strArray.length];
/* 1727 */       for (int i = 0; i < strArray.length; i++) {
/* 1728 */         arrayRtn[i] = formatString(strArray[i]);
/*      */       }
/*      */     }
/* 1731 */     return arrayRtn;
/*      */   }
/*      */ 
/*      */   public static double[] formatDoubleArray(String[] strArray) {
/* 1735 */     double[] arrayRtn = (double[])null;
/* 1736 */     if ((strArray != null) && (strArray.length > 0)) {
/* 1737 */       arrayRtn = new double[strArray.length];
/* 1738 */       for (int i = 0; i < strArray.length; i++) {
/* 1739 */         arrayRtn[i] = getDoubleValue(strArray[i]);
/*      */       }
/*      */     }
/* 1742 */     return arrayRtn;
/*      */   }
/*      */ 
/*      */   public static long[] formatLongArray(String[] strArray) {
/* 1746 */     long[] arrayRtn = (long[])null;
/* 1747 */     if ((strArray != null) && (strArray.length > 0)) {
/* 1748 */       arrayRtn = new long[strArray.length];
/* 1749 */       for (int i = 0; i < strArray.length; i++) {
/* 1750 */         arrayRtn[i] = getLongValue(strArray[i]);
/*      */       }
/*      */     }
/* 1753 */     return arrayRtn;
/*      */   }
/*      */ 
/*      */   public static int[] formatIntArray(String[] strArray) {
/* 1757 */     int[] arrayRtn = (int[])null;
/* 1758 */     if ((strArray != null) && (strArray.length > 0)) {
/* 1759 */       arrayRtn = new int[strArray.length];
/* 1760 */       for (int i = 0; i < strArray.length; i++) {
/* 1761 */         arrayRtn[i] = getIntValue(strArray[i]);
/*      */       }
/*      */     }
/* 1764 */     return arrayRtn;
/*      */   }
/*      */ 
/*      */   public static String[] vector2String(Vector v)
/*      */     throws Exception
/*      */   {
/* 1775 */     String[] strReturn = (String[])null;
/*      */     try {
/* 1777 */       if ((v != null) && (v.size() > 0)) {
/* 1778 */         Object[] objs = v.toArray();
/* 1779 */         strReturn = new String[objs.length];
/* 1780 */         for (int i = 0; i < objs.length; i++)
/*      */         {
/* 1782 */           strReturn[i] = ((String)objs[i]);
/*      */         }
/*      */       }
/*      */     } catch (Exception e) {
/* 1786 */       throw e;
/*      */     }
/* 1788 */     return strReturn;
/*      */   }
/*      */ 
/*      */   public static boolean hasStarOrPercent(String oldStr) {
/* 1792 */     StringBuffer newStr = new StringBuffer(oldStr);
/* 1793 */     int lengthOfStr = newStr.length();
/* 1794 */     for (int i = 0; i < lengthOfStr; i++) {
/* 1795 */       if ((newStr.charAt(i) == '*') || (newStr.charAt(i) == '%')) {
/* 1796 */         return true;
/*      */       }
/*      */     }
/* 1799 */     return false;
/*      */   }
/*      */ 
/*      */   public static String starStr2SqlStr(String oldStr)
/*      */   {
/* 1804 */     if ((oldStr == null) || (oldStr.trim().equals(""))) {
/* 1805 */       return "";
/*      */     }
/* 1807 */     StringBuffer newStr = new StringBuffer(oldStr);
/* 1808 */     int lengthOfStr = newStr.length();
/* 1809 */     for (int i = 0; i < lengthOfStr; i++) {
/* 1810 */       if (newStr.charAt(i) == '*') {
/* 1811 */         newStr.setCharAt(i, '%');
/*      */       }
/*      */     }
/* 1814 */     return newStr.toString();
/*      */   }
/*      */ 
/*      */   public static String encodePassword(String password) {
/* 1818 */     String encPwd = password.trim();
/*      */     try
/*      */     {
/* 1821 */       MessageDigest sha = MessageDigest.getInstance("SHA-1");
/*      */ 
/* 1823 */       sha.update(password.getBytes());
/* 1824 */       MessageDigest tc1 = (MessageDigest)sha.clone();
/*      */ 
/* 1826 */       byte[] pwdInfo = tc1.digest();
/*      */ 
/* 1828 */       BASE64Encoder base64Encoder = new BASE64Encoder();
/* 1829 */       encPwd = base64Encoder.encode(pwdInfo);
/* 1830 */       sha.reset();
/*      */     }
/*      */     catch (NoSuchAlgorithmException localNoSuchAlgorithmException) {
/*      */     }
/*      */     catch (CloneNotSupportedException localCloneNotSupportedException) {
/*      */     }
/* 1836 */     return encPwd;
/*      */   }
/*      */ 
/*      */   public static boolean checkEnglishChar(char a)
/*      */   {
/* 1847 */     boolean flag = false;
/* 1848 */     String all = "abcdefghijklmnopqrstuvwxyz";
/* 1849 */     if (all.indexOf(String.valueOf(a).toLowerCase()) != -1) {
/* 1850 */       flag = true;
/*      */     }
/* 1852 */     return flag;
/*      */   }
/*      */ 
/*      */   public static boolean checkDigitalChar(char a)
/*      */   {
/* 1863 */     boolean flag = false;
/* 1864 */     String all = "0123456789";
/* 1865 */     if (all.indexOf(String.valueOf(a).toLowerCase()) != -1) {
/* 1866 */       flag = true;
/*      */     }
/* 1868 */     return flag;
/*      */   }
/*      */ 
/*      */   public static boolean checkLineChar(char a)
/*      */   {
/* 1879 */     boolean flag = false;
/* 1880 */     String all = "-_";
/* 1881 */     if (all.indexOf(String.valueOf(a).toLowerCase()) != -1) {
/* 1882 */       flag = true;
/*      */     }
/* 1884 */     return flag;
/*      */   }
/*      */ 
/*      */   public static boolean checkMatchChar(char a)
/*      */   {
/* 1895 */     boolean flag = false;
/* 1896 */     String all = "%*";
/* 1897 */     if (all.indexOf(String.valueOf(a).toLowerCase()) != -1) {
/* 1898 */       flag = true;
/*      */     }
/* 1900 */     return flag;
/*      */   }
/*      */ 
/*      */   public static boolean checkMailChar(char a)
/*      */   {
/* 1911 */     boolean flag = false;
/* 1912 */     String all = "@.";
/* 1913 */     if (all.indexOf(String.valueOf(a).toLowerCase()) != -1) {
/* 1914 */       flag = true;
/*      */     }
/* 1916 */     return flag;
/*      */   }
/*      */ 
/*      */   public static String convertPassword(String password)
/*      */   {
/* 1926 */     if (password == null) {
/* 1927 */       return "";
/*      */     }
/* 1929 */     String convertPasw = "";
/* 1930 */     for (int i = 0; i < password.length(); i++) {
/* 1931 */       convertPasw = convertPasw + "*";
/*      */     }
/* 1933 */     return convertPasw;
/*      */   }
/*      */ 
/*      */   public static final String toISO(String strVal)
/*      */   {
/*      */     try
/*      */     {
/* 1945 */       if (strVal == null) {
/* 1946 */         return "";
/*      */       }
/* 1948 */       return new String(strVal.getBytes("GBK"), "ISO8859_1");
/*      */     }
/*      */     catch (Exception exp) {
/*      */     }
/* 1952 */     return "";
/*      */   }
/*      */ 
/*      */   public static String null2Zreo(String str)
/*      */   {
/* 1964 */     if ((str == null) || (str.equals(""))) {
/* 1965 */       return "0";
/*      */     }
/* 1967 */     return str;
/*      */   }
/*      */ 
/*      */   public static String encoding(String str) {
/*      */     try {
/* 1972 */       if (str == null) {
/* 1973 */         return "";
/*      */       }
/* 1975 */       return new String(str.getBytes("GB2312"), "8859_1"); } catch (Exception exp) {
/*      */     }
/* 1977 */     return "";
/*      */   }
/*      */ 
/*      */   public static String encoding2Html(String str)
/*      */   {
/*      */     try {
/* 1983 */       if (str == null) {
/* 1984 */         return "";
/*      */       }
/* 1986 */       return new String(str.getBytes("8859_1"), "GB2312"); } catch (Exception exp) {
/*      */     }
/* 1988 */     return "";
/*      */   }
/*      */ 
/*      */   public static String zipToString(String value)
/*      */   {
/* 2000 */     String str = null;
/* 2001 */     if (value != null)
/*      */     {
/* 2003 */       byte[] bytes = Base64.decode(value);
/* 2004 */       if (bytes != null)
/*      */       {
/* 2006 */         ByteArrayOutputStream out = null;
/*      */ 
/* 2008 */         ByteArrayInputStream in = null;
/*      */ 
/* 2010 */         ZipInputStream zin = null;
/*      */         try
/*      */         {
/* 2013 */           out = new ByteArrayOutputStream();
/*      */ 
/* 2015 */           in = new ByteArrayInputStream(bytes);
/*      */ 
/* 2017 */           zin = new ZipInputStream(in);
/*      */ 
/* 2019 */           zin.getNextEntry();
/*      */ 
/* 2021 */           byte[] buffer = new byte[1024];
/*      */ 
/* 2023 */           int offset = -1;
/* 2024 */           while ((offset = zin.read(buffer)) != -1)
/*      */           {
/* 2026 */             out.write(buffer, 0, offset);
/*      */           }
/* 2028 */           str = out.toString();
/*      */         } catch (IOException e) {
/* 2030 */           str = null;
/* 2031 */           System.err.println(e.getMessage());
/*      */ 
/* 2034 */           if (zin != null) {
/*      */             try {
/* 2036 */               zin.close();
/*      */             } catch (IOException e1) {
/* 2038 */               System.err.println(e1.getMessage());
/*      */             }
/*      */           }
/* 2041 */           if (in != null) {
/*      */             try {
/* 2043 */               in.close();
/*      */             } catch (IOException e1) {
/* 2045 */               System.err.println(e1.getMessage());
/*      */             }
/*      */           }
/* 2048 */           if (out != null)
/*      */             try {
/* 2050 */               out.close();
/*      */             } catch (IOException e2) {
/* 2052 */               System.err.println(e2.getMessage());
/*      */             }
/*      */         }
/*      */         finally
/*      */         {
/* 2034 */           if (zin != null) {
/*      */             try {
/* 2036 */               zin.close();
/*      */             } catch (IOException e) {
/* 2038 */               System.err.println(e.getMessage());
/*      */             }
/*      */           }
/* 2041 */           if (in != null) {
/*      */             try {
/* 2043 */               in.close();
/*      */             } catch (IOException e) {
/* 2045 */               System.err.println(e.getMessage());
/*      */             }
/*      */           }
/* 2048 */           if (out != null) {
/*      */             try {
/* 2050 */               out.close();
/*      */             } catch (IOException e) {
/* 2052 */               System.err.println(e.getMessage());
/*      */             }
/*      */           }
/*      */         }
/*      */       }
/*      */     }
/* 2058 */     return str;
/*      */   }
/*      */ 
/*      */   public static String getRandomValue8()
/*      */   {
/* 2067 */     String value = "";
/* 2068 */     String key = "QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm1234567890`~!@#$%^&*()-=[]\\;',./_+{}|:\"<>?";
/* 2069 */     Random random = new Random();
/*      */ 
/* 2071 */     for (int i = 0; i < 8; i++) {
/* 2072 */       int j = random.nextInt(key.length());
/* 2073 */       value = value + key.substring(j, j + 1);
/*      */     }
/* 2075 */     return value;
/*      */   }
/*      */ 
/*      */   public static String getByteStr(byte[] byt) {
/* 2079 */     String strRet = "";
/* 2080 */     for (int i = 0; i < byt.length; i++)
/*      */     {
/* 2082 */       strRet = strRet + getHexValue((byt[i] & 0xF0) / 16);
/* 2083 */       strRet = strRet + getHexValue(byt[i] & 0xF);
/*      */     }
/* 2085 */     return strRet;
/*      */   }
/*      */ 
/*      */   private static String getHexValue(int s) {
/* 2089 */     String sRet = null;
/* 2090 */     switch (s) {
/*      */     case 0:
/* 2092 */       sRet = "0";
/* 2093 */       break;
/*      */     case 1:
/* 2095 */       sRet = "1";
/* 2096 */       break;
/*      */     case 2:
/* 2098 */       sRet = "2";
/* 2099 */       break;
/*      */     case 3:
/* 2101 */       sRet = "3";
/* 2102 */       break;
/*      */     case 4:
/* 2104 */       sRet = "4";
/* 2105 */       break;
/*      */     case 5:
/* 2107 */       sRet = "5";
/* 2108 */       break;
/*      */     case 6:
/* 2110 */       sRet = "6";
/* 2111 */       break;
/*      */     case 7:
/* 2113 */       sRet = "7";
/* 2114 */       break;
/*      */     case 8:
/* 2116 */       sRet = "8";
/* 2117 */       break;
/*      */     case 9:
/* 2119 */       sRet = "9";
/* 2120 */       break;
/*      */     case 10:
/* 2122 */       sRet = "A";
/* 2123 */       break;
/*      */     case 11:
/* 2125 */       sRet = "B";
/* 2126 */       break;
/*      */     case 12:
/* 2128 */       sRet = "C";
/* 2129 */       break;
/*      */     case 13:
/* 2131 */       sRet = "D";
/* 2132 */       break;
/*      */     case 14:
/* 2134 */       sRet = "E";
/* 2135 */       break;
/*      */     case 15:
/* 2137 */       sRet = "F";
/*      */     }
/* 2139 */     return sRet;
/*      */   }
/*      */ 
/*      */   public static byte[] getKeyByStr(String str)
/*      */   {
/* 2148 */     byte[] bRet = new byte[str.length() / 2];
/* 2149 */     for (int i = 0; i < str.length() / 2; i++) {
/* 2150 */       Integer itg = new Integer(16 * getChrInt(str.charAt(2 * i)) + 
/* 2151 */         getChrInt(str.charAt(2 * i + 1)));
/* 2152 */       bRet[i] = itg.byteValue();
/*      */     }
/* 2154 */     return bRet;
/*      */   }
/*      */ 
/*      */   private static int getChrInt(char chr)
/*      */   {
/* 2162 */     int iRet = 0;
/* 2163 */     if (chr == "0".charAt(0))
/* 2164 */       iRet = 0;
/* 2165 */     if (chr == "1".charAt(0))
/* 2166 */       iRet = 1;
/* 2167 */     if (chr == "2".charAt(0))
/* 2168 */       iRet = 2;
/* 2169 */     if (chr == "3".charAt(0))
/* 2170 */       iRet = 3;
/* 2171 */     if (chr == "4".charAt(0))
/* 2172 */       iRet = 4;
/* 2173 */     if (chr == "5".charAt(0))
/* 2174 */       iRet = 5;
/* 2175 */     if (chr == "6".charAt(0))
/* 2176 */       iRet = 6;
/* 2177 */     if (chr == "7".charAt(0))
/* 2178 */       iRet = 7;
/* 2179 */     if (chr == "8".charAt(0))
/* 2180 */       iRet = 8;
/* 2181 */     if (chr == "9".charAt(0))
/* 2182 */       iRet = 9;
/* 2183 */     if (chr == "A".charAt(0))
/* 2184 */       iRet = 10;
/* 2185 */     if (chr == "B".charAt(0))
/* 2186 */       iRet = 11;
/* 2187 */     if (chr == "C".charAt(0))
/* 2188 */       iRet = 12;
/* 2189 */     if (chr == "D".charAt(0))
/* 2190 */       iRet = 13;
/* 2191 */     if (chr == "E".charAt(0))
/* 2192 */       iRet = 14;
/* 2193 */     if (chr == "F".charAt(0))
/* 2194 */       iRet = 15;
/* 2195 */     return iRet;
/*      */   }
/*      */ 
/*      */   public static String getAreaCodeByPhone(String phone)
/*      */   {
/* 2206 */     String code = "";
/* 2207 */     if ((phone != null) && (phone.length() > 4)) {
/* 2208 */       if ((phone.startsWith("010")) || (phone.startsWith("020")) || 
/* 2209 */         (phone.startsWith("021")) || (phone.startsWith("022")) || 
/* 2210 */         (phone.startsWith("023")) || (phone.startsWith("024")) || 
/* 2211 */         (phone.startsWith("025")) || (phone.startsWith("026")) || 
/* 2212 */         (phone.startsWith("027")) || (phone.startsWith("028")) || 
/* 2213 */         (phone.startsWith("029")))
/* 2214 */         code = phone.substring(0, 3);
/*      */       else {
/* 2216 */         code = phone.substring(0, 4);
/*      */       }
/*      */     }
/* 2219 */     return code;
/*      */   }
/*      */ 
/*      */   public static String get18IdentityCardBy15(String identityCard)
/*      */   {
/* 2231 */     if ((identityCard == null) || (identityCard.trim().length() != 15)) {
/* 2232 */       if ((identityCard != null) && (identityCard.length() == 18)) {
/* 2233 */         identityCard = identityCard.toUpperCase();
/*      */       }
/* 2235 */       return identityCard;
/*      */     }
/*      */ 
/* 2238 */     identityCard = identityCard.trim();
/* 2239 */     char[] strJiaoYan = { '1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', 
/* 2240 */       '2' };
/* 2241 */     int[] intQuan = { 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2, 
/* 2242 */       1 };
/*      */     String birth;
/* 2245 */     if (identityCard.length() == 15) {
/* 2246 */       int year = Integer.parseInt(new SimpleDateFormat("yy")
/* 2247 */         .format(new java.util.Date()));
/* 2248 */       birth = 
/* 2250 */         "20" + identityCard.substring(6, 12);
/*      */     } else {
/* 2252 */       birth = identityCard.substring(6, 14);
/*      */     }
/*      */ 
/* 2256 */     String strTemp = identityCard.substring(0, 6) + birth + 
/* 2257 */       identityCard.substring(12);
/* 2258 */     int intTemp = 0;
/* 2259 */     for (int i = 0; i < strTemp.length(); i++)
/*      */     {
/* 2261 */       intTemp = intTemp + Integer.parseInt(strTemp.substring(i, i + 1)) * 
/* 2261 */         intQuan[i];
/*      */     }
/* 2263 */     intTemp %= 11;
/* 2264 */     return strTemp + strJiaoYan[intTemp];
/*      */   }
/*      */ 
/*      */   public static boolean compairStr(String str1, String str2)
/*      */   {
/* 2271 */     boolean flag = false;
/* 2272 */     if (str1.trim().equals(str2.trim())) {
/* 2273 */       flag = true;
/*      */     }
/* 2275 */     return flag;
/*      */   }
/*      */ 
/*      */   public static Map describe(Object bean)
/*      */   {
/* 2282 */     return describe(bean, new String[0]);
/*      */   }
/*      */ 
/*      */   public static Map describe(Object bean, String[] removeKeys)
/*      */   {
/* 2288 */     Map retMap = new HashMap();
/*      */     try {
/* 2290 */       Map map = BeanUtils.describe(bean);
/*      */ 
/* 2292 */       if (map.containsKey("class")) {
/* 2293 */         map.remove("class");
/*      */       }
/* 2295 */       for (int i = 0; i < removeKeys.length; i++) {
/* 2296 */         if (map.containsKey(removeKeys[i])) {
/* 2297 */           map.remove(removeKeys[i]);
/*      */         }
/*      */       }
/* 2300 */       for (Iterator ite = map.keySet().iterator(); ite.hasNext(); ) {
/* 2301 */         Object key = ite.next();
/* 2302 */         Object value = map.get(key);
/* 2303 */         if (key.toString().indexOf("BO") > 0) {
/* 2304 */           String name = (String)key;
/* 2305 */           String methodName = "get" + 
/* 2306 */             name.substring(0, 1).toUpperCase() + 
/* 2307 */             name.substring(1);
/* 2308 */           Method getMethod = bean.getClass().getMethod(methodName, 
/* 2309 */             new Class[0]);
/* 2310 */           Object bo = getMethod.invoke(bean, new Object[0]);
/* 2311 */           retMap.put(key, bo);
/*      */         }
/* 2313 */         if ((value != null) && (!"".equals(value)) && 
/* 2314 */           (key.toString().indexOf("BO") == -1))
/* 2315 */           retMap.put(key, value);
/*      */       }
/*      */     }
/*      */     catch (IllegalAccessException e)
/*      */     {
/* 2320 */       e.printStackTrace();
/*      */     }
/*      */     catch (InvocationTargetException e) {
/* 2323 */       e.printStackTrace();
/*      */     }
/*      */     catch (NoSuchMethodException e) {
/* 2326 */       e.printStackTrace();
/*      */     }
/* 2328 */     return retMap;
/*      */   }
/*      */ 
/*      */   public static Map form2Map(Object bean, String[] removeKeys)
/*      */   {
/* 2333 */     Map retMap = new HashMap();
/*      */     try {
/* 2335 */       Map map = BeanUtils.describe(bean);
/*      */ 
/* 2337 */       if (map.containsKey("class")) {
/* 2338 */         map.remove("class");
/*      */       }
/* 2340 */       for (int i = 0; i < removeKeys.length; i++) {
/* 2341 */         if (map.containsKey(removeKeys[i])) {
/* 2342 */           map.remove(removeKeys[i]);
/*      */         }
/*      */       }
/* 2345 */       for (Iterator ite = map.keySet().iterator(); ite.hasNext(); ) {
/* 2346 */         Object key = ite.next();
/* 2347 */         Object value = map.get(key);
/* 2348 */         if ((value != null) && (!"".equals(value)))
/*      */         {
/* 2351 */           retMap.put(key, value);
/*      */         }
/*      */       }
/*      */     }
/*      */     catch (IllegalAccessException e) {
/* 2356 */       e.printStackTrace();
/*      */     }
/*      */     catch (InvocationTargetException e) {
/* 2359 */       e.printStackTrace();
/*      */     }
/*      */     catch (NoSuchMethodException e) {
/* 2362 */       e.printStackTrace();
/*      */     }
/* 2364 */     return retMap;
/*      */   }
/*      */ 
/*      */   public static String getUUIDHex()
/*      */   {
/* 2373 */     String value = gen.generate(null, null).toString();
/* 2374 */     return value;
/*      */   }
/*      */ 
/*      */   public static String getEncodeRandom(String filePath, String key)
/*      */   {
/* 2384 */     String value = "";
/* 2385 */     RSA rsa = RSA.getInstance(filePath);
/*      */ 
/* 2387 */     value = getByteStr(rsa.encrypt(key));
/* 2388 */     return value;
/*      */   }
/*      */ 
/*      */   public static String getDecodeRandom(String filePath, String encodeKey)
/*      */   {
/* 2398 */     String value = "";
/* 2399 */     RSA rsa = RSA.getInstance(filePath);
/* 2400 */     System.out.println("encodeKey=" + encodeKey);
/* 2401 */     System.out.println("encodeKeybyes=" + getKeyByStr(encodeKey));
/*      */ 
/* 2403 */     value = new String(rsa.decrypt(getKeyByStr(encodeKey)));
/* 2404 */     System.out.println("value=" + value);
/* 2405 */     return value;
/*      */   }
/*      */ }

/* Location:           D:\李慧医药项目\tcmages\krt\WEB-INF\classes\
 * Qualified Name:     org.ssi.common.Operate
 * JD-Core Version:    0.6.2
 */