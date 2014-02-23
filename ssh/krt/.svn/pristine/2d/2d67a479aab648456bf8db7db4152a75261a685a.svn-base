/*    */ package cn.id5.util;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.io.Writer;
/*    */ 
/*    */ public class CsvUtil
/*    */ {
/*    */   public static void generateCsv(Writer writer, String[] titleArr, String[][] dataArrs)
/*    */   {
/*  8 */     String retVar = "";
/*  9 */     for (int i = 0; i < titleArr.length; i++) {
/* 10 */       if (i != 0) retVar = retVar + ",";
/* 11 */       retVar = retVar + titleArr[i];
/*    */     }
/* 13 */     retVar = retVar + "\r\n";
/* 14 */     for (int i = 0; i < dataArrs.length; i++) {
/* 15 */       for (int j = 0; j < dataArrs[i].length; j++) {
/* 16 */         if (j != 0) retVar = retVar + ",";
/* 17 */         retVar = retVar + dataArrs[i][j];
/*    */       }
/* 19 */       retVar = retVar + "\r\n";
/*    */     }
/*    */   }
/*    */ 
/*    */   public static void generateCsv(Writer writer, String[][] strArrs) throws IOException
/*    */   {
/* 25 */     for (String[] strArr : strArrs)
/* 26 */       generateCsv(writer, strArr);
/*    */   }
/*    */ 
/*    */   public static void generateCsv(Writer writer, String[] strArr) throws IOException
/*    */   {
/* 31 */     writer.write(mergeArrToStr(strArr, ",") + "\r\n");
/*    */   }
/*    */ 
/*    */   public static String mergeArrToStr(String[] strArr, String split) {
/* 35 */     String retVar = "";
/* 36 */     for (int i = 0; i < strArr.length; i++) {
/* 37 */       if (i != 0) {
/* 38 */         retVar = retVar + split;
/*    */       }
/* 40 */       retVar = retVar + strArr[i];
/*    */     }
/* 42 */     return retVar;
/*    */   }
/*    */ }

/* Location:           D:\李慧医药项目\tcmages\krt\WEB-INF\classes\
 * Qualified Name:     cn.id5.util.CsvUtil
 * JD-Core Version:    0.6.2
 */