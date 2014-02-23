/*     */ package org.ssi.common;
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
/*     */ import java.io.FileOutputStream;
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
/*  36 */   private static String pressImg = "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";
/*     */ 
/*     */   public static final String pressImage(String srcStr, String preImg)
/*     */   {
/*  47 */     if ((srcStr == null) || (srcStr.trim().length() < 1)) {
/*  48 */       return srcStr;
/*     */     }
/*  50 */     if ((preImg != null) && (preImg.trim().length() > 0)) {
/*  51 */       pressImg = preImg;
/*     */     }
/*     */ 
/*  55 */     float alpha = 0.2F;
/*  56 */     int srcWidth = 0;
/*  57 */     int srcHeight = 0;
/*     */     try
/*     */     {
/*  60 */       byte[] b = base64de.decodeBuffer(srcStr);
/*  61 */       InputStream is = new ByteArrayInputStream(b);
/*  62 */       BufferedImage src = ImageIO.read(is);
/*  63 */       if (src != null) {
/*  64 */         srcWidth = src.getWidth(null);
/*  65 */         srcHeight = src.getHeight(null);
/*  66 */         if ((srcWidth <= 0) || (srcHeight <= 0)) {
/*  67 */           return null;
/*     */         }
/*  69 */         BufferedImage waterMark = extend(pressImg, srcWidth, srcHeight);
/*     */ 
/*  72 */         BufferedImage img = new BufferedImage(srcWidth, srcHeight, 8);
/*     */ 
/*  74 */         Graphics2D graph = img.createGraphics();
/*     */ 
/*  76 */         graph.drawImage(src, null, 0, 0);
/*     */ 
/*  78 */         graph.setComposite(AlphaComposite.getInstance(10, alpha));
/*     */ 
/*  80 */         graph.drawImage(waterMark, null, 0, 0);
/*     */ 
/*  82 */         ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();
/*  83 */         JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(jpegOutputStream);
/*  84 */         encoder.encode(img);
/*  85 */         byte[] resultByte = jpegOutputStream.toByteArray();
/*     */ 
/*  88 */         graph.dispose();
/*     */ 
/*  90 */         return base64en.encode(resultByte);
/*     */       }
/*  92 */       return srcStr;
/*     */     }
/*     */     catch (IOException e) {
/*  95 */       return srcStr;
/*     */     } catch (Exception e) {
/*     */     }
/*  98 */     return srcStr;
/*     */   }
/*     */ 
/*     */   public static String pressImage(File srcFile, File pressFile)
/*     */     throws IOException, Exception
/*     */   {
/* 111 */     if ((srcFile == null) || (pressFile == null)) {
/* 112 */       return null;
/*     */     }
/* 114 */     String srcStr = fileToBase64(srcFile);
/* 115 */     String pressStr = fileToBase64(pressFile);
/* 116 */     String baseCode = pressImage(srcStr, pressStr);
/* 117 */     return baseCode;
/*     */   }
/*     */ 
/*     */   public static String fileToBase64(File file)
/*     */     throws IOException
/*     */   {
/* 127 */     String baseCode = "";
/* 128 */     BufferedImage img = ImageIO.read(file);
/* 129 */     ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();
/* 130 */     JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(jpegOutputStream);
/* 131 */     encoder.encode(img);
/* 132 */     byte[] resultByte = jpegOutputStream.toByteArray();
/* 133 */     baseCode = base64en.encode(resultByte);
/* 134 */     return baseCode;
/*     */   }
/*     */ 
/*     */   public static BufferedImage extend(String src, int w, int h)
/*     */   {
/*     */     try
/*     */     {
/* 157 */       byte[] b = base64de.decodeBuffer(pressImg);
/* 158 */       InputStream is = new ByteArrayInputStream(b);
/* 159 */       BufferedImage img = ImageIO.read(is);
/*     */ 
/* 162 */       BufferedImage mini = new BufferedImage(w, h, 
/* 163 */         8);
/* 164 */       Graphics2D gmini = mini.createGraphics();
/* 165 */       gmini.setBackground(Color.WHITE);
/*     */ 
/* 167 */       gmini.clearRect(0, 0, w, h);
/* 168 */       AffineTransform trans = new AffineTransform();
/*     */ 
/* 170 */       trans.scale(w / img.getWidth(), h / 
/* 171 */         img.getHeight());
/* 172 */       gmini.setComposite(AlphaComposite.getInstance(
/* 173 */         10, 0.7F));
/* 174 */       AffineTransformOp op = new AffineTransformOp(trans, 
/* 175 */         2);
/* 176 */       gmini.drawImage(img, op, 0, 0);
/* 177 */       gmini.dispose();
/* 178 */       return mini; } catch (IOException e) {
/*     */     }
/* 180 */     return null;
/*     */   }
/*     */ 
/*     */   public static BufferedImage extend(String src, double rate, int w, int h)
/*     */     throws IOException
/*     */   {
/* 195 */     src = src.replace("background.gif", "background.png");
/* 196 */     System.out.println(src);
/* 197 */     BufferedImage img = ImageIO.read(new File(src));
/*     */ 
/* 200 */     BufferedImage mini = new BufferedImage(w, h, 8);
/* 201 */     Graphics2D gmini = mini.createGraphics();
/* 202 */     gmini.setBackground(Color.WHITE);
/*     */ 
/* 204 */     gmini.clearRect(0, 0, w, h);
/* 205 */     AffineTransform trans = new AffineTransform();
/*     */ 
/* 207 */     trans.scale(rate, rate);
/* 208 */     gmini.setComposite(AlphaComposite.getInstance(10, 0.4F));
/* 209 */     AffineTransformOp op = new AffineTransformOp(trans, 2);
/* 210 */     gmini.drawImage(img, op, 0, 0);
/*     */ 
/* 212 */     gmini.dispose();
/*     */ 
/* 214 */     return mini;
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/* 226 */     File file = new File("d:\\sy.jpg");
/*     */     try {
/* 228 */       BufferedImage img = ImageIO.read(file);
/* 229 */       ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();
/* 230 */       JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(jpegOutputStream);
/* 231 */       encoder.encode(img);
/*     */ 
/* 233 */       String fileBase64 = "/9j/4AAQSkZJRgABAQAAAQABAAD/2wBDAC8gIykjHS8pJik1Mi84R3ZMR0FBR5BnbVV2q5azsKiWpaK81P/lvMj/y6Kl6//u////////tuL/////////////2wBDATI1NUc+R4pMTIr/wqXC////////////////////////////////////////////////////////////////////wAARCADcALIDASIAAhEBAxEB/8QAHwAAAQUBAQEBAQEAAAAAAAAAAAECAwQFBgcICQoL/8QAtRAAAgEDAwIEAwUFBAQAAAF9AQIDAAQRBRIhMUEGE1FhByJxFDKBkaEII0KxwRVS0fAkM2JyggkKFhcYGRolJicoKSo0NTY3ODk6Q0RFRkdISUpTVFVWV1hZWmNkZWZnaGlqc3R1dnd4eXqDhIWGh4iJipKTlJWWl5iZmqKjpKWmp6ipqrKztLW2t7i5usLDxMXGx8jJytLT1NXW19jZ2uHi4+Tl5ufo6erx8vP09fb3+Pn6/8QAHwEAAwEBAQEBAQEBAQAAAAAAAAECAwQFBgcICQoL/8QAtREAAgECBAQDBAcFBAQAAQJ3AAECAxEEBSExBhJBUQdhcRMiMoEIFEKRobHBCSMzUvAVYnLRChYkNOEl8RcYGRomJygpKjU2Nzg5OkNERUZHSElKU1RVVldYWVpjZGVmZ2hpanN0dXZ3eHl6goOEhYaHiImKkpOUlZaXmJmaoqOkpaanqKmqsrO0tba3uLm6wsPExcbHyMnK0tPU1dbX2Nna4uPk5ebn6Onq8vP09fb3+Pn6/9oADAMBAAIRAxEAPwDWooooAKKKKACiiigAoopKAFoqhd6kkRKRAO3c54FZs15LN94nHtQBvmRFOC6g+5pcjGc8VzYldemB3oNw+MdvSgDoPtEJ6Sofowp6srjKkEeoNczvPrVhbvy5A8eRk5I9aAOgorJGqNwTjp6d6nTUfNGUQAA87j1oAv0VHFJ5i52lSOCDUlABRRRQAUUUUAFFFFABRRRQAUUUUAFFFNkdY0LscADJoAbNKkMZdzgfzrIu7958qvyx+g71Fd3TXEhJyEHRarmgBetIfakJooAQ/WkpevSjaaYCUU7YduabQAoPNKWJ6kntTaKAL9jMVcbDtOcEHo3/ANettTkZxiuWUkHIODWvY3uVCuTwMUAadFJS0gCi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";
/* 234 */       System.out.println("转换为base64码完毕");
/* 235 */       String pressBase64 = pressImage(fileBase64, null);
/* 236 */       System.out.println(pressBase64);
/* 237 */       System.out.println("添加水印完毕");
/*     */ 
/* 239 */       byte[] result = new BASE64Decoder().decodeBuffer(pressBase64.trim());
/*     */ 
/* 241 */       FileOutputStream fos = new FileOutputStream(new File("d:\\s.jpg"));
/* 242 */       fos.write(result);
/* 243 */       fos.flush();
/* 244 */       fos.close();
/*     */     }
/*     */     catch (Exception e) {
/* 247 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */ }

/* Location:           D:\李慧医药项目\tcmages\krt\WEB-INF\classes\
 * Qualified Name:     org.ssi.common.ImageUtils
 * JD-Core Version:    0.6.2
 */