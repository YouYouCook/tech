/*    */ package org.ssi.common;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ public class Constans
/*    */ {
/*  7 */   static Map map = null;
/*    */   static final String reg1 = ".*省.*市.*县.*";
/*    */   static final String reg2 = ".*省.*市.*区.*";
/*    */   static final String reg3 = ".*省.*市.*";
/*    */   static final String reg4 = ".*省.*自治州.*县.*";
/*    */   static final String reg5 = ".*省.*自治州.*区.*";
/*    */   static final String reg6 = ".*省.*自治州.*";
/*    */   static final String reg7 = ".*省.*盟.*县.*";
/*    */   static final String reg8 = ".*省.*盟.*区.*";
/*    */   static final String reg9 = ".*省.*盟.*";
/*    */   static final String reg10 = ".*省.*县.*";
/*    */   static final String reg11 = ".*省.*区.*";
/*    */   static final String reg12 = ".*省.*";
/*    */   static final String reg13 = ".*自治区.*市.*县.*";
/*    */   static final String reg14 = ".*自治区.*市.*区.*";
/*    */   static final String reg15 = ".*自治区.*市.*";
/*    */   static final String reg16 = ".*自治区.*自治州.*县.*";
/*    */   static final String reg17 = ".*自治区.*自治州.*区.*";
/*    */   static final String reg18 = ".*自治区.*自治州.*";
/*    */   static final String reg19 = ".*自治区.*盟.*县.*";
/*    */   static final String reg20 = ".*自治区.*盟.*区.*";
/*    */   static final String reg21 = ".*自治区.*盟.*";
/*    */   static final String reg22 = ".*自治区.*县.*";
/*    */   static final String reg23 = ".*自治区.*区.*";
/*    */   static final String reg24 = ".*自治区.*";
/*    */   static final String reg25 = ".*市.*县.*";
/*    */   static final String reg26 = ".*市.*区.*";
/*    */   static final String reg27 = ".*市.*";
/*    */   static final String reg28 = ".*自治州.*县.*";
/*    */   static final String reg29 = ".*自治州.*区.*";
/*    */   static final String reg30 = ".*自治州.*";
/*    */   static final String reg31 = ".*盟.*县.*";
/*    */   static final String reg32 = ".*盟.*区.*";
/*    */   static final String reg33 = ".*盟.*";
/*    */   static final String reg34 = ".*县.*";
/*    */   static final String reg35 = ".*区.*";
/*    */   static final String reg36 = ".*";
/*    */ 
/*    */   public static Map getRegMap()
/*    */   {
/* 47 */     if (map == null) map = new HashMap();
/* 48 */     map.put("1", ".*省.*市.*县.*");
/* 49 */     map.put("2", ".*省.*市.*区.*");
/* 50 */     map.put("3", ".*省.*市.*");
/* 51 */     map.put("4", ".*省.*自治州.*县.*");
/* 52 */     map.put("5", ".*省.*自治州.*区.*");
/* 53 */     map.put("6", ".*省.*自治州.*");
/* 54 */     map.put("7", ".*省.*盟.*县.*");
/* 55 */     map.put("8", ".*省.*盟.*区.*");
/* 56 */     map.put("9", ".*省.*盟.*");
/* 57 */     map.put("10", ".*省.*县.*");
/* 58 */     map.put("10", ".*省.*县.*");
/* 59 */     map.put("11", ".*省.*区.*");
/* 60 */     map.put("12", ".*省.*");
/* 61 */     map.put("13", ".*自治区.*市.*县.*");
/* 62 */     map.put("14", ".*自治区.*市.*区.*");
/* 63 */     map.put("15", ".*自治区.*市.*");
/* 64 */     map.put("16", ".*自治区.*自治州.*县.*");
/* 65 */     map.put("17", ".*自治区.*自治州.*区.*");
/* 66 */     map.put("18", ".*自治区.*自治州.*");
/* 67 */     map.put("19", ".*自治区.*盟.*县.*");
/* 68 */     map.put("20", ".*自治区.*盟.*区.*");
/* 69 */     map.put("21", ".*自治区.*盟.*");
/* 70 */     map.put("22", ".*自治区.*县.*");
/* 71 */     map.put("23", ".*自治区.*区.*");
/* 72 */     map.put("24", ".*自治区.*");
/* 73 */     map.put("25", ".*市.*县.*");
/* 74 */     map.put("26", ".*市.*区.*");
/* 75 */     map.put("27", ".*市.*");
/* 76 */     map.put("28", ".*自治州.*县.*");
/* 77 */     map.put("29", ".*自治州.*区.*");
/* 78 */     map.put("30", ".*自治州.*");
/* 79 */     map.put("31", ".*盟.*县.*");
/* 80 */     map.put("32", ".*盟.*区.*");
/* 81 */     map.put("33", ".*盟.*");
/* 82 */     map.put("34", ".*县.*");
/* 83 */     map.put("35", ".*区.*");
/* 84 */     map.put("36", ".*");
/* 85 */     return map;
/*    */   }
/*    */ }

/* Location:           D:\李慧医药项目\tcmages\krt\WEB-INF\classes\
 * Qualified Name:     org.ssi.common.Constans
 * JD-Core Version:    0.6.2
 */