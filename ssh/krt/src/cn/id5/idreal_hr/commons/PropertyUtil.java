/*    */ package cn.id5.idreal_hr.commons;
/*    */ 
/*    */ import java.io.PrintStream;
/*    */ import java.io.UnsupportedEncodingException;
/*    */ import java.util.ResourceBundle;
/*    */ 
/*    */ public class PropertyUtil
/*    */ {
/*    */   public static String getProperty(String propertyName, String key, String encodeing)
/*    */     throws UnsupportedEncodingException
/*    */   {
/* 22 */     if ((propertyName == null) || ("".equals(propertyName))) {
/* 23 */       propertyName = "message";
/*    */     }
/* 25 */     if ((encodeing == null) || ("".equals(encodeing))) {
/* 26 */       encodeing = "UTF-8";
/*    */     }
/* 28 */     String value = ResourceBundle.getBundle(propertyName).getString(key);
/* 29 */     if (value == null) {
/* 30 */       return null;
/*    */     }
/* 32 */     value = new String(value.getBytes("ISO8859-1"), encodeing);
/* 33 */     return value;
/*    */   }
/*    */ 
/*    */   public static String getProperty(String key)
/*    */     throws UnsupportedEncodingException
/*    */   {
/* 43 */     return getProperty("message", key, "UTF-8");
/*    */   }
/*    */ 
/*    */   public static void main(String[] args)
/*    */   {
/* 48 */     String s = "";
/*    */     try {
/* 50 */       s = getProperty("app_success");
/*    */     }
/*    */     catch (UnsupportedEncodingException e) {
/* 53 */       e.printStackTrace();
/*    */     }
/* 55 */     System.out.println(s);
/*    */   }
/*    */ }

/* Location:           D:\李慧医药项目\tcmages\krt\WEB-INF\classes\
 * Qualified Name:     cn.id5.idreal_hr.commons.PropertyUtil
 * JD-Core Version:    0.6.2
 */