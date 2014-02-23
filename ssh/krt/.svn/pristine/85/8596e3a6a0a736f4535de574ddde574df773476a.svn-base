/*     */ package cn.id5.idreal_hr.commons;
/*     */ 
/*     */ import com.sun.image.codec.jpeg.JPEGCodec;
/*     */ import com.sun.image.codec.jpeg.JPEGImageEncoder;
/*     */ import java.awt.AlphaComposite;
/*     */ import java.awt.Color;
/*     */ import java.awt.Graphics2D;
/*     */ import java.awt.geom.AffineTransform;
/*     */ import java.awt.image.AffineTransformOp;
/*     */ import java.awt.image.BufferedImage;
/*     */ import java.io.ByteArrayInputStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.PrintStream;
/*     */ import javax.imageio.ImageIO;
/*     */ import sun.misc.BASE64Decoder;
/*     */ import sun.misc.BASE64Encoder;
/*     */ 
/*     */ public final class ImageUtils
/*     */ {
/*  31 */   private static BASE64Encoder base64en = new BASE64Encoder();
/*  32 */   private static BASE64Decoder base64de = new BASE64Decoder();
/*     */ 
/*  35 */   private static String pressImg = "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";
/*     */ 
/*     */   public static final String pressImage(String privateKey, String addContent, String srcStr)
/*     */     throws IOException, Exception
/*     */   {
/*  50 */     float alpha = 0.2F;
/*  51 */     int srcWidth = 0;
/*  52 */     int srcHeight = 0;
/*     */     try
/*     */     {
/*  55 */       byte[] b = base64de.decodeBuffer(srcStr);
/*  56 */       InputStream is = new ByteArrayInputStream(b);
/*  57 */       BufferedImage src = ImageIO.read(is);
/*  58 */       if (src != null) {
/*  59 */         srcWidth = src.getWidth(null);
/*  60 */         srcHeight = src.getHeight(null);
/*  61 */         if ((srcWidth <= 0) || (srcHeight <= 0)) {
/*  62 */           return null;
/*     */         }
/*  64 */         BufferedImage waterMark = extend(pressImg, srcWidth, srcHeight);
/*     */ 
/*  67 */         BufferedImage img = new BufferedImage(srcWidth, srcHeight, 8);
/*     */ 
/*  69 */         Graphics2D graph = img.createGraphics();
/*     */ 
/*  71 */         graph.drawImage(src, null, 0, 0);
/*     */ 
/*  73 */         graph.setComposite(AlphaComposite.getInstance(10, alpha));
/*     */ 
/*  75 */         graph.drawImage(waterMark, null, 0, 0);
/*     */ 
/*  77 */         ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();
/*  78 */         JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(jpegOutputStream);
/*  79 */         encoder.encode(img);
/*  80 */         byte[] resultByte = jpegOutputStream.toByteArray();
/*     */ 
/*  83 */         graph.dispose();
/*     */ 
/*  85 */         return base64en.encode(resultByte);
/*     */       }
/*  87 */       return null;
/*     */     }
/*     */     catch (IOException e) {
/*  90 */       return null;
/*     */     } catch (Exception e) {
/*     */     }
/*  93 */     return null;
/*     */   }
/*     */ 
/*     */   public static BufferedImage extend(String src, int w, int h)
/*     */   {
/*     */     try
/*     */     {
/* 117 */       byte[] b = base64de.decodeBuffer(pressImg);
/* 118 */       InputStream is = new ByteArrayInputStream(b);
/* 119 */       BufferedImage img = ImageIO.read(is);
/*     */ 
/* 122 */       BufferedImage mini = new BufferedImage(w, h, 
/* 123 */         8);
/* 124 */       Graphics2D gmini = mini.createGraphics();
/* 125 */       gmini.setBackground(Color.WHITE);
/*     */ 
/* 127 */       gmini.clearRect(0, 0, w, h);
/* 128 */       AffineTransform trans = new AffineTransform();
/*     */ 
/* 130 */       trans.scale(w / img.getWidth(), h / 
/* 131 */         img.getHeight());
/* 132 */       gmini.setComposite(AlphaComposite.getInstance(
/* 133 */         10, 0.7F));
/* 134 */       AffineTransformOp op = new AffineTransformOp(trans, 
/* 135 */         2);
/* 136 */       gmini.drawImage(img, op, 0, 0);
/* 137 */       gmini.dispose();
/* 138 */       return mini; } catch (IOException e) {
/*     */     }
/* 140 */     return null;
/*     */   }
/*     */ 
/*     */   public static BufferedImage extend(String src, double rate, int w, int h)
/*     */     throws IOException
/*     */   {
/* 155 */     src = src.replace("background.gif", "background.png");
/* 156 */     System.out.println(src);
/* 157 */     BufferedImage img = ImageIO.read(new File(src));
/*     */ 
/* 160 */     BufferedImage mini = new BufferedImage(w, h, 8);
/* 161 */     Graphics2D gmini = mini.createGraphics();
/* 162 */     gmini.setBackground(Color.WHITE);
/*     */ 
/* 164 */     gmini.clearRect(0, 0, w, h);
/* 165 */     AffineTransform trans = new AffineTransform();
/*     */ 
/* 167 */     trans.scale(rate, rate);
/* 168 */     gmini.setComposite(AlphaComposite.getInstance(10, 0.4F));
/* 169 */     AffineTransformOp op = new AffineTransformOp(trans, 2);
/* 170 */     gmini.drawImage(img, op, 0, 0);
/*     */ 
/* 172 */     gmini.dispose();
/*     */ 
/* 174 */     return mini;
/*     */   }
/*     */ }

/* Location:           D:\李慧医药项目\tcmages\krt\WEB-INF\classes\
 * Qualified Name:     cn.id5.idreal_hr.commons.ImageUtils
 * JD-Core Version:    0.6.2
 */