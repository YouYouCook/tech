/*     */ package org.ssi.common;
/*     */ 
/*     */ import java.io.PrintStream;
/*     */ import java.security.Key;
/*     */ import java.security.SecureRandom;
/*     */ import javax.crypto.Cipher;
/*     */ import javax.crypto.SecretKeyFactory;
/*     */ import javax.crypto.spec.DESKeySpec;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ 
/*     */ public class Des1
/*     */ {
/*     */   public static final String ALGORITHM_DES = "DES";
/*  21 */   private static Log log = LogFactory.getLog(Des1.class);
/*     */ 
/*     */   public static String encode(String key, String data)
/*     */     throws Exception
/*     */   {
/*  33 */     return encode(key, data.getBytes("UTF-8"));
/*     */   }
/*     */ 
/*     */   public static String encode(String key, byte[] data)
/*     */     throws Exception
/*     */   {
/*     */     try
/*     */     {
/*  47 */       SecureRandom sr = new SecureRandom();
/*     */ 
/*  49 */       DESKeySpec dks = new DESKeySpec(key.getBytes());
/*     */ 
/*  51 */       SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("des");
/*     */ 
/*  59 */       Key secretKey = keyFactory.generateSecret(dks);
/*  60 */       Cipher cipher = Cipher.getInstance("DES");
/*  61 */       cipher.init(1, secretKey);
/*     */ 
/*  63 */       byte[] bytes = cipher.doFinal(data);
/*     */ 
/*  66 */       return byte2hex(bytes);
/*     */     }
/*     */     catch (Exception e) {
/*  69 */       throw new Exception(e);
/*     */     }
/*     */   }
/*     */ 
/*     */   public static byte[] decode(String key, String data)
/*     */     throws Exception
/*     */   {
/*  84 */     if ((System.getProperty("os.name") != null) && ((System.getProperty("os.name").equalsIgnoreCase("sunos")) || (System.getProperty("os.name").equalsIgnoreCase("linux"))))
/*     */     {
/*  86 */       log.debug("os.name(true)=" + System.getProperty("os.name"));
/*  87 */       log.debug(new String(new String(decode(key, data.getBytes())).getBytes("UTF-8")));
/*  88 */       log.debug(new String(new String(decode(key, data.getBytes("GBK"))).getBytes("UTF-8")));
/*  89 */       log.debug(new String(new String(decode(key, data.getBytes("UTF-8"))).getBytes("GBK")));
/*  90 */       log.debug(new String(decode(key, data.getBytes("ISO-8859-1"))));
/*  91 */       return decode(key, data.getBytes());
/*     */     }
/*     */ 
/*  95 */     log.debug("os.name(false)=" + System.getProperty("os.name"));
/*  96 */     log.debug(new String(decode(key, data.getBytes())));
/*  97 */     log.debug(new String(decode(key, data.getBytes("GBK"))));
/*  98 */     log.debug(new String(decode(key, data.getBytes("UTF-8"))));
/*  99 */     log.debug(new String(decode(key, data.getBytes("ISO-8859-1"))));
/* 100 */     return decode(key, data.getBytes());
/*     */   }
/*     */ 
/*     */   public static byte[] decode(String key, byte[] data)
/*     */     throws Exception
/*     */   {
/*     */     try
/*     */     {
/* 115 */       SecureRandom sr = new SecureRandom();
/* 116 */       DESKeySpec dks = new DESKeySpec(key.getBytes());
/* 117 */       SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("des");
/*     */ 
/* 122 */       Key secretKey = keyFactory.generateSecret(dks);
/* 123 */       Cipher cipher = Cipher.getInstance("DES");
/* 124 */       cipher.init(2, secretKey);
/* 125 */       return cipher.doFinal(data);
/*     */     }
/*     */     catch (Exception e) {
/* 128 */       throw new Exception(e);
/*     */     }
/*     */   }
/*     */ 
/*     */   public static String decodeValue(String key, String data)
/*     */   {
/* 142 */     String value = null;
/*     */     try
/*     */     {
/*     */       byte[] datas;
/* 144 */       if ((System.getProperty("os.name") != null) && ((System.getProperty("os.name").equalsIgnoreCase("sunos")) || (System.getProperty("os.name").equalsIgnoreCase("linux"))))
/*     */       {
/* 146 */         log.debug("os.name(true)=" + System.getProperty("os.name"));
/*     */ 
/* 168 */         datas = decode(key, hex2byte(data.getBytes("UTF-8")));
/*     */       }
/*     */       else
/*     */       {
/* 172 */         log.debug("os.name(false)=" + System.getProperty("os.name"));
/* 173 */         log.debug(new String(decode(key, hex2byte(data.getBytes()))));
/* 174 */         log.debug(new String(decode(key, hex2byte(data.getBytes("GBK")))));
/* 175 */         log.debug(new String(decode(key, hex2byte(data.getBytes("UTF-8")))));
/* 176 */         log.debug(new String(decode(key, hex2byte(data.getBytes("ISO-8859-1")))));
/* 177 */         datas = decode(key, hex2byte(data.getBytes()));
/*     */       }
/*     */ 
/* 180 */       value = new String(datas);
/*     */     } catch (Exception e) {
/* 182 */       value = "";
/*     */     }
/* 184 */     return value;
/*     */   }
/*     */   public static byte[] hex2byte(byte[] b) {
/* 187 */     if (b.length % 2 != 0)
/* 188 */       throw new IllegalArgumentException("长度不是偶数");
/* 189 */     byte[] b2 = new byte[b.length / 2];
/* 190 */     for (int n = 0; n < b.length; n += 2) {
/* 191 */       String item = new String(b, n, 2);
/*     */ 
/* 193 */       b2[(n / 2)] = ((byte)Integer.parseInt(item, 16));
/*     */     }
/* 195 */     return b2;
/*     */   }
/*     */ 
/*     */   public static String byte2hex(byte[] b)
/*     */   {
/* 200 */     String hs = "";
/* 201 */     String stmp = "";
/* 202 */     for (int n = 0; n < b.length; n++)
/*     */     {
/* 204 */       stmp = Integer.toHexString(b[n] & 0xFF);
/* 205 */       if (stmp.length() == 1)
/* 206 */         hs = hs + "0" + stmp;
/*     */       else {
/* 208 */         hs = hs + stmp;
/*     */       }
/*     */     }
/* 211 */     return hs.toUpperCase();
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */     throws Exception
/*     */   {
/* 220 */     System.out.println(new String(decode("wwwid5cn", "ABB0E340805D367C438E24FC4005C121F60247F6EE4430B5")));
/*     */   }
/*     */ }

/* Location:           D:\李慧医药项目\tcmages\krt\WEB-INF\classes\
 * Qualified Name:     org.ssi.common.Des1
 * JD-Core Version:    0.6.2
 */