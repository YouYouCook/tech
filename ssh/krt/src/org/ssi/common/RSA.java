/*     */ package org.ssi.common;
/*     */ 
/*     */ import java.io.FileInputStream;
/*     */ import java.io.FileNotFoundException;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.io.ObjectOutputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.security.InvalidKeyException;
/*     */ import java.security.Key;
/*     */ import java.security.KeyFactory;
/*     */ import java.security.KeyPair;
/*     */ import java.security.KeyPairGenerator;
/*     */ import java.security.NoSuchAlgorithmException;
/*     */ import java.security.PrivateKey;
/*     */ import java.security.PublicKey;
/*     */ import java.security.SecureRandom;
/*     */ import java.security.spec.EncodedKeySpec;
/*     */ import java.security.spec.InvalidKeySpecException;
/*     */ import java.security.spec.PKCS8EncodedKeySpec;
/*     */ import javax.crypto.BadPaddingException;
/*     */ import javax.crypto.Cipher;
/*     */ import javax.crypto.IllegalBlockSizeException;
/*     */ import javax.crypto.NoSuchPaddingException;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.bouncycastle.jce.provider.BouncyCastleProvider;
/*     */ import sun.security.rsa.RSAPublicKeyImpl;
/*     */ 
/*     */ public class RSA
/*     */ {
/*  46 */   private KeyPairGenerator kpg = null;
/*  47 */   private KeyPair kp = null;
/*     */ 
/*  49 */   private boolean local = true;
/*     */ 
/*  51 */   private static Log log = LogFactory.getLog(RSA.class);
/*     */ 
/*  53 */   private static RSA rsa = null;
/*     */ 
/*  55 */   private String filePath = null;
/*     */ 
/*  57 */   private String fileName = null;
/*     */ 
/*     */   public static RSA getInstance(String filePath)
/*     */   {
/*  72 */     return getInstance(filePath, null);
/*     */   }
/*     */ 
/*     */   public static RSA getInstance(String filePath, String fileName)
/*     */   {
/*  82 */     if (rsa == null)
/*     */     {
/*  84 */       rsa = new RSA();
/*     */     }
/*  86 */     if ((filePath != null) && (!"".equals(filePath.trim())))
/*     */     {
/*  88 */       rsa.filePath = filePath;
/*     */     }
/*  90 */     if ((fileName != null) && (!"".equals(fileName.trim())))
/*     */     {
/*  92 */       rsa.fileName = fileName;
/*     */     }
/*  94 */     return rsa;
/*     */   }
/*     */ 
/*     */   public void createKey()
/*     */   {
/* 101 */     createKey(null, null);
/*     */   }
/*     */ 
/*     */   public void createKey(String privateKeyFileName, String publickeyFileName)
/*     */   {
/* 111 */     ObjectOutputStream private_oos = null;
/*     */ 
/* 113 */     ObjectOutputStream public_oos = null;
/*     */ 
/* 115 */     OutputStream public_os = null;
/*     */ 
/* 117 */     OutputStream private_os = null;
/*     */     try
/*     */     {
/* 120 */       this.kpg = KeyPairGenerator.getInstance("RSA");
/* 121 */       SecureRandom secureRandom = new SecureRandom();
/* 122 */       secureRandom.setSeed("9w_3k_n0".getBytes());
/*     */ 
/* 124 */       this.kpg.initialize(1024, secureRandom);
/*     */ 
/* 126 */       this.kp = this.kpg.genKeyPair();
/* 127 */       if (this.kp != null)
/*     */       {
/* 130 */         if ((privateKeyFileName == null) || (privateKeyFileName.trim().equals("")))
/*     */         {
/* 132 */           privateKeyFileName = "private_key.dat";
/*     */         }
/*     */ 
/* 135 */         if ((publickeyFileName == null) || (publickeyFileName.trim().equals("")))
/*     */         {
/* 137 */           publickeyFileName = "public_key.dat";
/*     */         }
/*     */ 
/* 140 */         if (this.local)
/*     */         {
/* 142 */           private_oos = new ObjectOutputStream(new FileOutputStream(this.filePath + "/" + privateKeyFileName));
/* 143 */           public_oos = new ObjectOutputStream(new FileOutputStream(this.filePath + "/" + publickeyFileName));
/*     */         }
/*     */         else
/*     */         {
/* 147 */           private_os = new FileOutputStream(this.filePath + "/" + privateKeyFileName);
/* 148 */           public_os = new FileOutputStream(this.filePath + "/" + publickeyFileName);
/*     */         }
/* 150 */         log.debug("private_key=" + this.kp.getPrivate());
/* 151 */         log.debug("public_key=" + this.kp.getPublic());
/*     */ 
/* 153 */         if (this.local)
/*     */         {
/* 155 */           private_oos.writeObject(this.kp.getPrivate());
/* 156 */           public_oos.writeObject(this.kp.getPublic());
/*     */         }
/*     */         else
/*     */         {
/* 160 */           private_os.write(this.kp.getPrivate().getEncoded());
/* 161 */           public_os.write(this.kp.getPublic().getEncoded());
/*     */         }
/* 163 */         log.info("生成密钥成功!!!");
/*     */       }
/*     */     }
/*     */     catch (NoSuchAlgorithmException e) {
/* 167 */       log.warn(e.getMessage());
/* 168 */       if (log.isDebugEnabled())
/*     */       {
/* 170 */         e.printStackTrace();
/* 187 */       }
/*     */ if (private_oos == null); } catch (FileNotFoundException e) {
/* 173 */       log.warn(e.getMessage());
/* 174 */       if (log.isDebugEnabled())
/*     */       {
/* 176 */         e.printStackTrace();
/* 187 */       }
/*     */ if (private_oos == null); } catch (IOException e) {
/* 179 */       log.warn(e.getMessage());
/* 180 */       if (log.isDebugEnabled())
/*     */       {
/* 182 */         e.printStackTrace();
/*     */       }
/*     */ 
/* 187 */       if (private_oos == null);
/*     */     } finally {
/* 187 */       if (private_oos != null) {
/*     */         try
/*     */         {
/* 190 */           private_oos.close();
/* 191 */           private_oos = null;
/*     */         } catch (IOException e) {
/* 193 */           log.warn(e.getMessage());
/* 194 */           if (log.isDebugEnabled())
/*     */           {
/* 196 */             e.printStackTrace();
/*     */           }
/*     */         }
/*     */       }
/*     */ 
/* 201 */       if (public_oos != null) {
/*     */         try
/*     */         {
/* 204 */           public_oos.close();
/* 205 */           public_oos = null;
/*     */         } catch (IOException e) {
/* 207 */           log.warn(e.getMessage());
/* 208 */           if (log.isDebugEnabled())
/*     */           {
/* 210 */             e.printStackTrace();
/*     */           }
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/* 216 */       if (private_os != null) {
/*     */         try
/*     */         {
/* 219 */           private_os.close();
/* 220 */           private_os = null;
/*     */         } catch (IOException e) {
/* 222 */           log.warn(e.getMessage());
/* 223 */           if (log.isDebugEnabled())
/*     */           {
/* 225 */             e.printStackTrace();
/*     */           }
/*     */         }
/*     */       }
/*     */ 
/* 230 */       if (public_os != null)
/*     */         try
/*     */         {
/* 233 */           public_os.close();
/* 234 */           public_os = null;
/*     */         } catch (IOException e) {
/* 236 */           log.warn(e.getMessage());
/* 237 */           if (log.isDebugEnabled())
/*     */           {
/* 239 */             e.printStackTrace();
/*     */           }
/*     */         }
/*     */     }
/*     */   }
/*     */ 
/*     */   private byte[] getKeyBytes(String fileName, int type)
/*     */   {
/* 254 */     byte[] bytes = (byte[])null;
/*     */ 
/* 256 */     InputStream is = null;
/*     */     try {
/* 258 */       if ((this.fileName != null) && (!"".equals(fileName.trim())))
/*     */       {
/* 260 */         fileName = this.fileName;
/*     */       }
/*     */ 
/* 263 */       if ((type == 1) && ((fileName == null) || (fileName.trim().equals(""))))
/*     */       {
/* 265 */         fileName = "public_key.dat";
/*     */       }
/* 268 */       else if ((type == 2) && ((fileName == null) || (fileName.trim().equals(""))))
/*     */       {
/* 270 */         fileName = "private_key.dat";
/*     */       }
/* 272 */       is = new FileInputStream(this.filePath + "/" + fileName);
/* 273 */       if (is != null)
/*     */       {
/* 276 */         bytes = new byte[is.available()];
/*     */ 
/* 278 */         is.read(bytes);
/*     */       }
/*     */     } catch (FileNotFoundException e) {
/* 281 */       log.warn(e.getMessage());
/* 282 */       if (log.isDebugEnabled())
/*     */       {
/* 284 */         e.printStackTrace();
/* 295 */       }
/*     */ if (is == null); } catch (IOException e) {
/* 287 */       log.warn(e.getMessage());
/* 288 */       if (log.isDebugEnabled())
/*     */       {
/* 290 */         e.printStackTrace();
/*     */       }
/*     */ 
/* 295 */       if (is == null);
/*     */     } finally {
/* 295 */       if (is != null) {
/*     */         try
/*     */         {
/* 298 */           is.close();
/* 299 */           is = null;
/*     */         } catch (IOException e) {
/* 301 */           log.warn(e.getMessage());
/* 302 */           if (log.isDebugEnabled())
/*     */           {
/* 304 */             e.printStackTrace();
/*     */           }
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 312 */     return bytes;
/*     */   }
/*     */ 
/*     */   private Key getKey(byte[] bytes, int type)
/*     */     throws InvalidKeyException
/*     */   {
/* 323 */     Key key = null;
/* 324 */     log.debug(bytes != null ? Integer.valueOf(bytes.length) : "null");
/* 325 */     if ((bytes != null) && (bytes.length > 0))
/*     */     {
/*     */       try
/*     */       {
/* 329 */         if (type == 1)
/*     */         {
/* 331 */           key = new RSAPublicKeyImpl(bytes);
/*     */         }
/* 334 */         else if (type == 2)
/*     */         {
/* 336 */           EncodedKeySpec ks = new PKCS8EncodedKeySpec(bytes);
/* 337 */           KeyFactory kf = KeyFactory.getInstance("RSA");
/* 338 */           key = kf.generatePrivate(ks);
/*     */         }
/*     */       } catch (NoSuchAlgorithmException e) {
/* 341 */         log.warn(e.getMessage());
/* 342 */         if (log.isDebugEnabled())
/*     */         {
/* 344 */           e.printStackTrace();
/*     */         }
/*     */       } catch (InvalidKeySpecException e) {
/* 347 */         log.warn(e.getMessage());
/* 348 */         if (log.isDebugEnabled())
/*     */         {
/* 350 */           e.printStackTrace();
/*     */         }
/*     */       }
/*     */     }
/* 354 */     return key;
/*     */   }
/*     */ 
/*     */   private Cipher getCipher(String fileName, int type)
/*     */   {
/* 364 */     InputStream is = null;
/*     */ 
/* 366 */     Key key = null;
/*     */ 
/* 368 */     Cipher cipher = null;
/* 369 */     ObjectInputStream ois = null;
/*     */     try {
/* 371 */       if ((this.fileName != null) && (!"".equals(fileName.trim())))
/*     */       {
/* 373 */         fileName = this.fileName;
/*     */       }
/*     */ 
/* 376 */       if ((type == 1) && ((fileName == null) || (fileName.trim().equals(""))))
/*     */       {
/* 378 */         fileName = "public_key.dat";
/*     */       }
/* 381 */       else if ((type == 2) && ((fileName == null) || (fileName.trim().equals(""))))
/*     */       {
/* 383 */         fileName = "private_key.dat";
/*     */       }
/* 385 */       is = new FileInputStream(this.filePath + "/" + fileName);
/* 386 */       if (is != null)
/*     */       {
/* 388 */         if (this.local)
/*     */         {
/* 390 */           ois = new ObjectInputStream(is);
/* 391 */           key = (Key)ois.readObject();
/*     */         }
/*     */         else
/*     */         {
/* 395 */           key = getKey(getKeyBytes(fileName, type), type);
/*     */         }
/* 397 */         if (key != null)
/*     */         {
/* 400 */           if (type == 1)
/*     */           {
/* 403 */             cipher = Cipher.getInstance("RSA", new BouncyCastleProvider());
/* 404 */             cipher.init(1, key);
/*     */           }
/* 407 */           else if (type == 2)
/*     */           {
/* 410 */             cipher = Cipher.getInstance("RSA", new BouncyCastleProvider());
/* 411 */             cipher.init(2, key);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (InvalidKeyException e) {
/* 416 */       log.warn(e.getMessage());
/* 417 */       if (log.isDebugEnabled())
/*     */       {
/* 419 */         e.printStackTrace();
/*     */       }
/*     */     } catch (FileNotFoundException e) {
/* 422 */       log.warn(e.getMessage());
/* 423 */       if (log.isDebugEnabled())
/*     */       {
/* 425 */         e.printStackTrace();
/*     */       }
/*     */     } catch (NoSuchAlgorithmException e) {
/* 428 */       log.warn(e.getMessage());
/* 429 */       if (log.isDebugEnabled())
/*     */       {
/* 431 */         e.printStackTrace();
/*     */       }
/*     */     } catch (NoSuchPaddingException e) {
/* 434 */       log.warn(e.getMessage());
/* 435 */       if (log.isDebugEnabled())
/*     */       {
/* 437 */         e.printStackTrace();
/*     */       }
/*     */     } catch (IOException e) {
/* 440 */       log.warn(e.getMessage());
/* 441 */       if (log.isDebugEnabled())
/*     */       {
/* 443 */         e.printStackTrace();
/*     */       }
/*     */     } catch (ClassNotFoundException e) {
/* 446 */       log.warn(e.getMessage());
/* 447 */       if (log.isDebugEnabled())
/*     */       {
/* 449 */         e.printStackTrace();
/*     */       }
/*     */     }
/*     */     finally
/*     */     {
/* 454 */       if (is != null) {
/*     */         try
/*     */         {
/* 457 */           is.close();
/* 458 */           is = null;
/*     */         } catch (IOException e) {
/* 460 */           log.warn(e.getMessage());
/* 461 */           if (log.isDebugEnabled())
/*     */           {
/* 463 */             e.printStackTrace();
/*     */           }
/*     */         }
/*     */       }
/*     */ 
/* 468 */       if (key != null)
/*     */       {
/* 470 */         key = null;
/*     */       }
/*     */     }
/*     */ 
/* 474 */     return cipher;
/*     */   }
/*     */ 
/*     */   private byte[] crypt(String fileName, byte[] bytes, int type)
/*     */   {
/* 486 */     byte[] returnBytes = (byte[])null;
/* 487 */     Cipher cipher = null;
/*     */     try
/*     */     {
/* 490 */       cipher = getCipher(fileName, type);
/* 491 */       if (cipher != null)
/*     */       {
/* 493 */         returnBytes = cipher.doFinal(bytes);
/*     */       }
/*     */     }
/*     */     catch (IllegalBlockSizeException e) {
/* 497 */       log.warn(e.getMessage());
/* 498 */       if (log.isDebugEnabled())
/*     */       {
/* 500 */         e.printStackTrace();
/*     */       }
/*     */     } catch (BadPaddingException e) {
/* 503 */       log.warn(e.getMessage());
/* 504 */       if (log.isDebugEnabled())
/*     */       {
/* 506 */         e.printStackTrace();
/*     */       }
/*     */     }
/*     */     finally
/*     */     {
/* 511 */       if (cipher != null)
/*     */       {
/* 513 */         cipher = null;
/*     */       }
/*     */     }
/* 516 */     return returnBytes;
/*     */   }
/*     */ 
/*     */   public byte[] encrypt(String fileName, byte[] bytes)
/*     */   {
/* 526 */     return crypt(fileName, bytes, 1);
/*     */   }
/*     */ 
/*     */   public byte[] encrypt(byte[] bytes)
/*     */   {
/* 535 */     return crypt(null, bytes, 1);
/*     */   }
/*     */ 
/*     */   public byte[] encrypt(String fileName, String text)
/*     */   {
/* 545 */     return crypt(fileName, text.getBytes(), 1);
/*     */   }
/*     */ 
/*     */   public byte[] encrypt(String text)
/*     */   {
/* 554 */     return crypt(null, text.getBytes(), 1);
/*     */   }
/*     */ 
/*     */   public byte[] decrypt(String fileName, byte[] bytes)
/*     */   {
/* 564 */     return crypt(fileName, bytes, 2);
/*     */   }
/*     */ 
/*     */   public byte[] decrypt(byte[] bytes)
/*     */   {
/* 574 */     return crypt(null, bytes, 2);
/*     */   }
/*     */ 
/*     */   public boolean isLocal()
/*     */   {
/* 580 */     return this.local;
/*     */   }
/*     */ 
/*     */   public void setLocal(boolean local)
/*     */   {
/* 586 */     this.local = local;
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/* 594 */     RSA rsa = getInstance("c:");
/*     */ 
/* 596 */     rsa.setLocal(false);
/*     */ 
/* 598 */     rsa.createKey();
/* 599 */     byte[] bytes = rsa.encrypt("测试RSA加密解密");
/* 600 */     log.debug("cc=" + bytes);
/* 601 */     byte[] ob = rsa.decrypt(bytes);
/* 602 */     log.debug("cc=" + new String(ob));
/*     */   }
/*     */ }

/* Location:           D:\李慧医药项目\tcmages\krt\WEB-INF\classes\
 * Qualified Name:     org.ssi.common.RSA
 * JD-Core Version:    0.6.2
 */