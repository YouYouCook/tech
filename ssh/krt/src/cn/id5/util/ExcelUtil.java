/*    */ package cn.id5.util;
/*    */ 
/*    */ import org.apache.poi.hssf.usermodel.HSSFCell;
/*    */ import org.apache.poi.hssf.usermodel.HSSFCellStyle;
/*    */ import org.apache.poi.hssf.usermodel.HSSFFont;
/*    */ import org.apache.poi.hssf.usermodel.HSSFRow;
/*    */ import org.apache.poi.hssf.usermodel.HSSFSheet;
/*    */ import org.apache.poi.hssf.usermodel.HSSFWorkbook;
/*    */ 
/*    */ public class ExcelUtil
/*    */ {
/*    */   private static HSSFWorkbook createHSSFWorkbookObj()
/*    */   {
/* 19 */     HSSFWorkbook workbook = new HSSFWorkbook();
/* 20 */     return workbook;
/*    */   }
/*    */ 
/*    */   private static HSSFCellStyle createCellstyleTitleBold(HSSFWorkbook workbook)
/*    */   {
/* 25 */     HSSFCellStyle cellstyleTitleBold = workbook.createCellStyle();
/* 26 */     cellstyleTitleBold.setBorderRight((short)1);
/* 27 */     cellstyleTitleBold.setBorderBottom((short)1);
/* 28 */     cellstyleTitleBold.setAlignment((short)2);
/* 29 */     cellstyleTitleBold.setVerticalAlignment((short)1);
/* 30 */     cellstyleTitleBold.setWrapText(true);
/*    */ 
/* 33 */     HSSFFont fontTitleBold = workbook.createFont();
/* 34 */     fontTitleBold.setFontName("宋体");
/* 35 */     fontTitleBold.setFontHeightInPoints((short)10);
/* 36 */     fontTitleBold.setBoldweight((short)700);
/* 37 */     cellstyleTitleBold.setFont(fontTitleBold);
/*    */ 
/* 39 */     return cellstyleTitleBold;
/*    */   }
/*    */ 
/*    */   private static HSSFCellStyle createCellstyleTitleNormal(HSSFWorkbook workbook) {
/* 43 */     HSSFCellStyle cellstyleTitleNormal = workbook.createCellStyle();
/* 44 */     cellstyleTitleNormal.setBorderRight((short)1);
/* 45 */     cellstyleTitleNormal.setBorderBottom((short)1);
/* 46 */     cellstyleTitleNormal.setAlignment((short)2);
/* 47 */     cellstyleTitleNormal.setVerticalAlignment((short)1);
/*    */ 
/* 50 */     HSSFFont fontContentNormal = workbook.createFont();
/* 51 */     fontContentNormal.setFontName("宋体");
/* 52 */     fontContentNormal.setFontHeightInPoints((short)10);
/* 53 */     cellstyleTitleNormal.setFont(fontContentNormal);
/*    */ 
/* 55 */     return cellstyleTitleNormal;
/*    */   }
/*    */ 
/*    */   public static HSSFWorkbook toCreateBook(String[] titleArr, String[][] dataArrs, int[] columnWidthArr)
/*    */   {
/* 61 */     HSSFWorkbook workbook = createHSSFWorkbookObj();
/* 62 */     HSSFCellStyle cellstyleTitleBold = createCellstyleTitleBold(workbook);
/* 63 */     HSSFCellStyle cellstyleNormal = createCellstyleTitleNormal(workbook);
/*    */ 
/* 65 */     HSSFSheet sheet = workbook.createSheet();
/* 66 */     HSSFRow row0 = sheet.createRow(0);
/* 67 */     row0.setHeight((short)450);
/*    */ 
/* 70 */     for (int i = 0; i < titleArr.length; i++) {
/* 71 */       HSSFCell cell = row0.createCell(i);
/* 72 */       cell.setCellValue(titleArr[i]);
/* 73 */       cell.setCellStyle(cellstyleTitleBold);
/*    */     }
/*    */ 
/* 77 */     for (int i = 0; i < dataArrs.length; i++) {
/* 78 */       HSSFRow row = sheet.createRow(i + 1);
/* 79 */       row.setHeight((short)360);
/* 80 */       for (int j = 0; j < dataArrs[i].length; j++) {
/* 81 */         HSSFCell cell0 = row.createCell(j);
/* 82 */         cell0.setCellValue(dataArrs[i][j]);
/* 83 */         cell0.setCellStyle(cellstyleNormal);
/*    */       }
/*    */ 
/*    */     }
/*    */ 
/* 94 */     for (int i = 0; i < columnWidthArr.length; i++) {
/* 95 */       sheet.setColumnWidth(i, columnWidthArr[i]);
/*    */     }
/*    */ 
/* 98 */     return workbook;
/*    */   }
/*    */ }

/* Location:           D:\李慧医药项目\tcmages\krt\WEB-INF\classes\
 * Qualified Name:     cn.id5.util.ExcelUtil
 * JD-Core Version:    0.6.2
 */