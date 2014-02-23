/*    */ package cn.id5.util;
/*    */ 
/*    */ import java.io.PrintStream;
/*    */ import java.util.Random;
/*    */ 
/*    */ public class GenerateUtil
/*    */ {
/*    */   public static String generatePass(int pwd_len)
/*    */   {
/* 11 */     int maxNum = 36;
/*    */ 
/* 13 */     int count = 0;
/* 14 */     char[] str = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 
/* 15 */       'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 
/* 16 */       'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
/*    */ 
/* 18 */     StringBuffer pwd = new StringBuffer("");
/* 19 */     Random r = new Random();
/* 20 */     while (count < pwd_len)
/*    */     {
/* 23 */       int i = Math.abs(r.nextInt(36));
/*    */ 
/* 25 */       if ((i >= 0) && (i < str.length)) {
/* 26 */         pwd.append(str[i]);
/* 27 */         count++;
/*    */       }
/*    */     }
/*    */ 
/* 31 */     return pwd.toString();
/*    */   }
/*    */ 
/*    */   public static String generatePass()
/*    */   {
/* 37 */     return generatePass(8);
/*    */   }
/*    */ 
/*    */   public static void main(String[] args) {
/* 41 */     System.out.println("generatePass : " + generatePass(8));
/*    */   }
/*    */ }

/* Location:           D:\李慧医药项目\tcmages\krt\WEB-INF\classes\
 * Qualified Name:     cn.id5.util.GenerateUtil
 * JD-Core Version:    0.6.2
 */