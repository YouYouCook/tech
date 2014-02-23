/*    */ package cn.id5.idreal_hr.commons;
/*    */ 
/*    */ import java.awt.AlphaComposite;
/*    */ import java.awt.Color;
/*    */ import java.awt.Graphics2D;
/*    */ import java.awt.geom.AffineTransform;
/*    */ import java.awt.image.AffineTransformOp;
/*    */ import java.awt.image.BufferedImage;
/*    */ 
/*    */ public final class ImageExtendsUtils
/*    */ {
/*    */   public static BufferedImage extend(BufferedImage img, double scale)
/*    */   {
/* 28 */     if (img == null)
/* 29 */       return null;
/*    */     try {
/* 31 */       int w = (int)(img.getWidth() * scale);
/* 32 */       int h = (int)(img.getHeight() * scale);
/* 33 */       w = w > 0 ? w : 400;
/* 34 */       h = h > 0 ? h : 300;
/* 35 */       BufferedImage mini = new BufferedImage(w, h, 8);
/* 36 */       Graphics2D gmini = mini.createGraphics();
/* 37 */       gmini.setBackground(Color.WHITE);
/* 38 */       gmini.clearRect(0, 0, w, h);
/* 39 */       AffineTransform trans = new AffineTransform();
/*    */ 
/* 41 */       trans.scale(scale, scale);
/* 42 */       gmini.setComposite(AlphaComposite.getInstance(10, 0.7F));
/* 43 */       AffineTransformOp op = new AffineTransformOp(trans, 2);
/* 44 */       gmini.drawImage(img, op, 0, 0);
/* 45 */       gmini.dispose();
/* 46 */       return mini; } catch (Exception e) {
/*    */     }
/* 48 */     return null;
/*    */   }
/*    */ }

/* Location:           D:\李慧医药项目\tcmages\krt\WEB-INF\classes\
 * Qualified Name:     cn.id5.idreal_hr.commons.ImageExtendsUtils
 * JD-Core Version:    0.6.2
 */