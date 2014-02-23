/*    */ package cn.id5.idreal_hr.commons;
/*    */ 
/*    */ import java.io.PrintStream;
/*    */ import java.util.Enumeration;
/*    */ import java.util.ResourceBundle;
/*    */ 
/*    */ public class Configurator
/*    */ {
/* 14 */   static Configurator config = null;
/* 15 */   static ResourceBundle resource = null;
/*    */ 
/*    */   private Configurator() {
/* 18 */     resource = ResourceBundle.getBundle("config");
/*    */   }
/*    */ 
/*    */   public static Configurator getInstance() {
/* 22 */     if (config == null) {
/* 23 */       synchronized (Configurator.class) {
/* 24 */         if (config == null) {
/* 25 */           config = new Configurator();
/*    */         }
/*    */       }
/*    */     }
/* 29 */     return config;
/*    */   }
/*    */ 
/*    */   public String getKey(String name)
/*    */   {
/* 34 */     String strPhyPath = "";
/* 35 */     Enumeration keyEnum = resource.getKeys();
/* 36 */     while (keyEnum.hasMoreElements()) {
/* 37 */       if ("PHY_PATH".equals(keyEnum.nextElement())) {
/* 38 */         strPhyPath = strPhyPath + resource.getString("PHY_PATH");
/*    */       }
/*    */     }
/* 41 */     return strPhyPath + resource.getString(name);
/*    */   }
/*    */ 
/*    */   public static void main(String[] args) {
/* 45 */     System.out.println(getInstance().getKey("FILE_UPLOAD_CHECK_REPORT_PATH"));
/* 46 */     System.out.println(getInstance().getKey("EXCEL_DOWNLOAD_CACHE_PATH"));
/*    */   }
/*    */ }

/* Location:           D:\李慧医药项目\tcmages\krt\WEB-INF\classes\
 * Qualified Name:     cn.id5.idreal_hr.commons.Configurator
 * JD-Core Version:    0.6.2
 */