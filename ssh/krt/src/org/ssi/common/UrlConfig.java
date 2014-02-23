/*    */ package org.ssi.common;
/*    */ 
/*    */ import java.io.PrintStream;
/*    */ import java.util.ResourceBundle;
/*    */ 
/*    */ public final class UrlConfig
/*    */ {
/* 11 */   private static ResourceBundle resource = null;
/* 12 */   private static UrlConfig config = null;
/*    */ 
/*    */   private UrlConfig() {
/* 15 */     resource = ResourceBundle.getBundle("url");
/*    */   }
/*    */ 
/*    */   public static UrlConfig getInstance() {
/* 19 */     if ((config == null) || (resource == null)) {
/* 20 */       synchronized (UrlConfig.class) {
/* 21 */         if (config == null) {
/* 22 */           config = new UrlConfig();
/*    */         }
/*    */       }
/*    */     }
/* 26 */     return config;
/*    */   }
/*    */ 
/*    */   public String get(String key) {
/* 30 */     return resource.getString(key);
/*    */   }
/*    */ 
/*    */   public static void main(String[] args) {
/* 34 */     String s = getInstance().get("serviceURL");
/* 35 */     System.out.println(s);
/*    */   }
/*    */ }

/* Location:           D:\李慧医药项目\tcmages\krt\WEB-INF\classes\
 * Qualified Name:     org.ssi.common.UrlConfig
 * JD-Core Version:    0.6.2
 */