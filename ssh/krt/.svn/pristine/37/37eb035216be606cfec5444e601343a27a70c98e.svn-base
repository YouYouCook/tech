/*     */ package org.ssi.common;
/*     */ 
/*     */ import java.io.PrintStream;
/*     */ import java.security.Key;
/*     */ import javax.crypto.Cipher;
/*     */ import javax.crypto.SecretKeyFactory;
/*     */ import javax.crypto.spec.DESKeySpec;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import sun.misc.BASE64Decoder;
/*     */ import sun.misc.BASE64Encoder;
/*     */ 
/*     */ public class DesEncrypt
/*     */ {
/*  31 */   private static Log log = LogFactory.getLog(DesEncrypt.class);
/*     */   Key key;
/*  34 */   private String keyValue = null;
/*     */ 
/*     */   public String getKeyValue()
/*     */   {
/*  40 */     return this.keyValue;
/*     */   }
/*     */ 
/*     */   public void setKeyValue(String keyValue)
/*     */   {
/*  47 */     this.keyValue = keyValue;
/*     */   }
/*     */ 
/*     */   public DesEncrypt()
/*     */   {
/*  52 */     this(null);
/*     */   }
/*     */ 
/*     */   public DesEncrypt(String key) {
/*  56 */     getKey(key);
/*     */   }
/*     */ 
/*     */   private void getKey(String strKey)
/*     */   {
/*     */     try
/*     */     {
/*  66 */       if ((strKey != null) && (!"".equals(strKey)))
/*     */       {
/*  68 */         this.keyValue = strKey;
/*     */       }
/*  70 */       log.debug("key:" + this.keyValue);
/*  71 */       DESKeySpec dks = new DESKeySpec(strKey.getBytes());
/*  72 */       SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
/*     */ 
/*  74 */       this.key = keyFactory.generateSecret(dks);
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  81 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   public String getEncString(String strMing)
/*     */   {
/*  92 */     log.debug("strMing:" + strMing);
/*  93 */     byte[] byteMi = (byte[])null;
/*  94 */     byte[] byteMing = (byte[])null;
/*  95 */     String strMi = "";
/*  96 */     BASE64Encoder base64en = new BASE64Encoder();
/*     */     try
/*     */     {
/* 104 */       byteMing = strMing.getBytes("UTF8");
/*     */ 
/* 107 */       byteMi = getEncCode(byteMing);
/* 108 */       strMi = base64en.encode(byteMi);
/*     */     } catch (Exception e) {
/* 110 */       e.printStackTrace();
/*     */     } finally {
/* 112 */       base64en = null;
/* 113 */       byteMing = (byte[])null;
/* 114 */       byteMi = (byte[])null;
/*     */     }
/* 116 */     return strMi;
/*     */   }
/*     */ 
/*     */   public String getDesString(String strMi)
/*     */   {
/* 126 */     log.debug("strMi=" + strMi);
/* 127 */     BASE64Decoder base64De = new BASE64Decoder();
/* 128 */     byte[] byteMing = (byte[])null;
/* 129 */     byte[] byteMi = (byte[])null;
/* 130 */     String strMing = "";
/*     */     try {
/* 132 */       byteMi = base64De.decodeBuffer(strMi);
/* 133 */       byteMing = getDesCode(byteMi);
/*     */ 
/* 141 */       strMing = new String(byteMing, "UTF8");
/*     */     }
/*     */     catch (Exception e) {
/* 144 */       e.printStackTrace();
/*     */     } finally {
/* 146 */       base64De = null;
/* 147 */       byteMing = (byte[])null;
/* 148 */       byteMi = (byte[])null;
/*     */     }
/* 150 */     return strMing;
/*     */   }
/*     */ 
/*     */   private byte[] getEncCode(byte[] byteS)
/*     */   {
/* 160 */     byte[] byteFina = (byte[])null;
/*     */   
/*     */  
/*     */     try
/*     */     {
/* 163 */       Cipher cipher = Cipher.getInstance("DES");
/* 164 */       cipher.init(1, this.key);
/* 165 */       byteFina = cipher.doFinal(byteS);
/*     */     } catch (Exception e) {
/* 167 */       e.printStackTrace();
/*     */     }
/*     */     finally
/*     */     {
/*     */       Cipher cipher;
/* 169 */       cipher = null;
/*     */     }
/* 171 */     return byteFina;
/*     */   }
/*     */ 
/*     */   private byte[] getDesCode(byte[] byteD)
/*     */   {
/* 182 */     byte[] byteFina = (byte[])null;
/*     */     Cipher cipher;
/*     */     try
/*     */     {
/* 184 */        cipher = Cipher.getInstance("DES");
/* 185 */       cipher.init(2, this.key);
/* 186 */       byteFina = cipher.doFinal(byteD);
/*     */     } catch (Exception e) {
/* 188 */       e.printStackTrace();
/*     */     }
/*     */     finally
/*     */     {
/*     */      
/* 190 */       cipher = null;
/*     */     }
/* 192 */     return byteFina;
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/* 197 */     System.out.println("des demo");
/* 198 */     DesEncrypt des = new DesEncrypt("wwwid5cn");
/* 199 */     des.getKey("wwwid5cn");
/*     */ 
/* 205 */     String strDes = des.getDesString("ABB0E340805D367C438E24FC4005C121F60247F6EE4430B5");
/* 206 */     System.out.println("明文=" + strDes);
/*     */   }
/*     */ }

/* Location:           D:\李慧医药项目\tcmages\krt\WEB-INF\classes\
 * Qualified Name:     org.ssi.common.DesEncrypt
 * JD-Core Version:    0.6.2
 */