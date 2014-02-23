/*    */ package org.ssi.common;
/*    */ 
/*    */ import java.io.PrintStream;
/*    */ import java.util.Map;
/*    */ import java.util.regex.Pattern;
/*    */ 
/*    */ public class Address
/*    */ {
/*    */   public static void main(String[] args)
/*    */   {
/*  8 */     String address = "云南省昆明市晋宁县北苑小区";
/*  9 */     for (int i = 1; i < 36; i++)
/*    */     {
/* 11 */       boolean flag = Pattern.matches(Constans.getRegMap().get(String.valueOf(i)).toString(), address);
/* 12 */       System.out.println(i + " " + flag);
/* 13 */       if (flag)
/*    */       {
/* 15 */         String matched_reg = Constans.getRegMap().get(String.valueOf(i)).toString();
/*    */ 
/* 17 */         int last = matched_reg.lastIndexOf(".*");
/* 18 */         String matched_reg_last = String.valueOf(matched_reg.charAt(last - 1));
/* 19 */         System.out.println(matched_reg_last);
/* 20 */         int address_split = address.indexOf(matched_reg_last) + 1;
/* 21 */         System.out.println(address.substring(0, address_split));
/* 22 */         break;
/*    */       }
/*    */     }
/*    */   }
/*    */ 
/*    */   public static String getAreaFromAddress(String address) {
/* 28 */     String area = address;
/* 29 */     if ((area == null) || ("".equals(area))) {
/* 30 */       return area;
/*    */     }
/* 32 */     for (int i = 1; i < 36; i++)
/*    */     {
/* 34 */       boolean flag = Pattern.matches(Constans.getRegMap().get(String.valueOf(i)).toString(), address);
/* 35 */       System.out.println(i + " " + flag);
/* 36 */       if (flag)
/*    */       {
/* 38 */         String matched_reg = Constans.getRegMap().get(String.valueOf(i)).toString();
/*    */ 
/* 40 */         int last = matched_reg.lastIndexOf(".*");
/* 41 */         String matched_reg_last = String.valueOf(matched_reg.charAt(last - 1));
/* 42 */         System.out.println(matched_reg_last);
/* 43 */         int address_split = address.indexOf(matched_reg_last) + 1;
/* 44 */         area = address.substring(0, address_split);
/* 45 */         System.out.println(area);
/* 46 */         break;
/*    */       }
/*    */     }
/* 49 */     return area;
/*    */   }
/*    */ }

/* Location:           D:\李慧医药项目\tcmages\krt\WEB-INF\classes\
 * Qualified Name:     org.ssi.common.Address
 * JD-Core Version:    0.6.2
 */