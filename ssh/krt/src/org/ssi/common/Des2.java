/*     */ package org.ssi.common;
/*     */ 
/*     */ import java.io.PrintStream;
/*     */ import java.security.Key;
/*     */ import java.security.SecureRandom;
/*     */ import java.security.spec.AlgorithmParameterSpec;
/*     */ import javax.crypto.Cipher;
/*     */ import javax.crypto.SecretKeyFactory;
/*     */ import javax.crypto.spec.DESKeySpec;
/*     */ import javax.crypto.spec.IvParameterSpec;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ 
/*     */ public class Des2
/*     */ {
/*     */   public static final String ALGORITHM_DES = "DES/CBC/PKCS5Padding";
/*  23 */   private static Log log = LogFactory.getLog(Des2.class);
/*     */ 
/*     */   public static String encode(String key, String data)
/*     */     throws Exception
/*     */   {
/*  35 */     return encode(key, data.getBytes());
/*     */   }
/*     */ 
/*     */   public static String encode(String key, byte[] data)
/*     */     throws Exception
/*     */   {
/*     */     try
/*     */     {
/*  49 */       DESKeySpec dks = new DESKeySpec(key.getBytes());
/*     */ 
/*  51 */       SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
/*     */ 
/*  53 */       Key secretKey = keyFactory.generateSecret(dks);
/*  54 */       Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
/*  55 */       IvParameterSpec iv = new IvParameterSpec("12345678".getBytes());
/*  56 */       AlgorithmParameterSpec paramSpec = iv;
/*  57 */       cipher.init(1, secretKey, paramSpec);
/*     */ 
/*  59 */       byte[] bytes = cipher.doFinal(data);
/*  60 */       return Base64.encode(bytes);
/*     */     }
/*     */     catch (Exception e) {
/*  63 */       throw new Exception(e);
/*     */     }
/*     */   }
/*     */ 
/*     */   public static byte[] decode(String key, byte[] data)
/*     */     throws Exception
/*     */   {
/*     */     try
/*     */     {
/*  79 */       SecureRandom sr = new SecureRandom();
/*  80 */       DESKeySpec dks = new DESKeySpec(key.getBytes());
/*  81 */       SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
/*     */ 
/*  83 */       Key secretKey = keyFactory.generateSecret(dks);
/*  84 */       Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
/*  85 */       IvParameterSpec iv = new IvParameterSpec("12345678".getBytes());
/*  86 */       AlgorithmParameterSpec paramSpec = iv;
/*  87 */       cipher.init(2, secretKey, paramSpec);
/*  88 */       return cipher.doFinal(data);
/*     */     }
/*     */     catch (Exception e) {
/*  91 */       e.printStackTrace();
/*  92 */       throw new Exception(e);
/*     */     }
/*     */   }
/*     */ 
/*     */   public static String decodeValue(String key, String data)
/*     */   {
/* 106 */     String value = null;
/*     */     try
/*     */     {
/*     */       byte[] datas;
/* 108 */       if ((System.getProperty("os.name") != null) && ((System.getProperty("os.name").equalsIgnoreCase("sunos")) || (System.getProperty("os.name").equalsIgnoreCase("linux"))))
/*     */       {
/* 110 */         log.debug("os.name(true)=" + System.getProperty("os.name"));
/* 111 */          datas = decode(key, Base64.decode(data));
/* 112 */         log.debug("ddd=" + new String(datas));
/*     */       }
/*     */       else
/*     */       {
/* 116 */         log.debug("os.name(false)=" + System.getProperty("os.name"));
/* 117 */         datas = decode(key, Base64.decode(data));
/* 118 */         log.debug("ddd=" + new String(datas));
/*     */       }
/*     */ 
/* 121 */       value = new String(datas);
/*     */     } catch (Exception e) {
/* 123 */       e.printStackTrace();
/* 124 */       log.warn("解密失败");
/* 125 */       value = "";
/*     */     }
/* 127 */     return value;
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */     throws Exception
/*     */   {
/* 141 */     System.out.println("dd=" + encode("12345678", new String("idtagpckhd")));
/*     */ 
/* 143 */     System.out.println("dd=" + decodeValue("12345678", "yPJEpR5wlVn35Ag+YyRsSw=="));
/*     */   }
/*     */ }

/* Location:           D:\李慧医药项目\tcmages\krt\WEB-INF\classes\
 * Qualified Name:     org.ssi.common.Des2
 * JD-Core Version:    0.6.2
 */