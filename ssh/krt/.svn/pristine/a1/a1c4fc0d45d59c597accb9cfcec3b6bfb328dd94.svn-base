/*    */ package cn.id5.idreal_hr.commons;
/*    */ 
/*    */ import java.io.PrintStream;
/*    */ 
/*    */ public class StringUtils
/*    */ {
/*    */   public static String removeAllBlank(String s)
/*    */   {
/* 15 */     String result = "";
/* 16 */     if ((s != null) && (!"".equals(s))) {
/* 17 */       result = s.replaceAll("[　*| *| *|\\s*]*", "");
/*    */     }
/* 19 */     return result;
/*    */   }
/*    */ 
/*    */   public static String trim(String s)
/*    */   {
/* 28 */     String result = "";
/* 29 */     if ((s != null) && (!"".equals(s))) {
/* 30 */       result = s.replaceAll("^[　*| *| *|\\s*]*", "").replaceAll("[　*| *| *|\\s*]*$", "");
/*    */     }
/* 32 */     return result;
/*    */   }
/*    */ 
/*    */   public static void main(String[] s) {
/* 36 */     String str = "\t 　\t\t我爱\t中国，我是中国 　人 ";
/* 37 */     String id = "　　　　\t34　\t082120  931295\t513\t2　";
/* 38 */     System.out.println("|" + trim(str) + "|");
/* 39 */     System.out.println("|" + removeAllBlank(id) + "|");
/*    */   }
/*    */ }

/* Location:           D:\李慧医药项目\tcmages\krt\WEB-INF\classes\
 * Qualified Name:     cn.id5.idreal_hr.commons.StringUtils
 * JD-Core Version:    0.6.2
 */