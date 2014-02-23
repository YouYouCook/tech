/*     */ package org.ssi.struts.action;
/*     */ 
/*     */ import com.sun.image.codec.jpeg.JPEGCodec;
/*     */ import com.sun.image.codec.jpeg.JPEGImageEncoder;
/*     */ import java.awt.Color;
/*     */ import java.awt.Font;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.image.BufferedImage;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.PrintStream;
/*     */ import java.util.Random;
/*     */ import javax.imageio.ImageIO;
/*     */ import javax.servlet.ServletOutputStream;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ import javax.servlet.http.HttpSession;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.struts.action.ActionForm;
/*     */ import org.apache.struts.action.ActionForward;
/*     */ import org.apache.struts.action.ActionMapping;
/*     */ 
/*     */ public class ImageAction extends SSIDispatchAction
/*     */ {
/*     */   public ActionForward showGoImg(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/*     */     throws Exception
/*     */   {
/*  37 */     response.setContentType("image/gif");
/*  38 */     int width = 21; int height = 15;
/*  39 */     BufferedImage image = new BufferedImage(width, height, 1);
/*  40 */     Graphics g = image.getGraphics();
/*     */ 
/*  42 */     g.setColor(Color.white);
/*  43 */     g.fillRect(0, 0, width, height);
/*  44 */     g.setColor(Color.BLACK);
/*  45 */     g.drawRect(0, 0, 20, 13);
/*  46 */     g.setColor(new Color(200, 10, 100));
/*  47 */     g.drawString("Go", 2, 11);
/*  48 */     g.dispose();
/*  49 */     ServletOutputStream sos = null;
/*     */     try
/*     */     {
/*  52 */       sos = response.getOutputStream();
/*  53 */       JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(sos);
/*  54 */       encoder.encode(image);
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  58 */       log.warn(e.getMessage());
/*  59 */       if (log.isDebugEnabled())
/*     */       {
/*  61 */         e.printStackTrace();
/*     */       }
/*     */     }
/*     */     finally
/*     */     {
/*  66 */       if (sos != null)
/*     */       {
/*  68 */         sos.close();
/*     */       }
/*     */     }
/*  71 */     return null;
/*     */   }
/*     */ 
/*     */   public ActionForward authImg(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/*     */     throws Exception
/*     */   {
/*  81 */     response.setContentType("image/gif");
/*     */ 
/*  83 */     response.setHeader("Pragma", "No-cache");
/*  84 */     response.setHeader("Cache-Control", "no-cache");
/*  85 */     response.setDateHeader("Expires", 0L);
/*  86 */     ServletOutputStream sos = null;
/*     */ 
/*  88 */     int width = 60; int height = 20;
/*  89 */     BufferedImage image = new BufferedImage(width, height, 
/*  90 */       1);
/*     */ 
/*  92 */     Graphics g = image.getGraphics();
/*     */ 
/*  94 */     Random random = new Random();
/*     */ 
/*  96 */     g.setColor(getRandColor(200, 250));
/*  97 */     g.fillRect(0, 0, width, height);
/*     */ 
/*  99 */     g.setFont(new Font("Times New Roman", 0, 18));
/*     */ 
/* 102 */     g.setColor(getRandColor(160, 200));
/* 103 */     for (int i = 0; i < 155; i++) {
/* 104 */       int x = random.nextInt(width);
/* 105 */       int y = random.nextInt(height);
/* 106 */       int xl = random.nextInt(12);
/* 107 */       int yl = random.nextInt(12);
/* 108 */       g.drawLine(x, y, x + xl, y + yl);
/*     */     }
/*     */ 
/* 112 */     String sRand = "";
/* 113 */     for (int i = 0; i < 4; i++) {
/* 114 */       String rand = String.valueOf(random.nextInt(10));
/* 115 */       sRand = sRand + rand;
/*     */ 
/* 117 */       g.setColor(new Color(0, 0, 0));
/* 118 */       g.drawString(rand, 13 * i + 6, 16);
/*     */     }
/* 120 */     g.dispose();
/*     */ 
/* 122 */     request.getSession().setAttribute("rands", sRand);
/* 123 */     sos = response.getOutputStream();
/* 124 */     ImageIO.write(image, "JPEG", sos);
/* 125 */     if (sos != null) { sos.close(); sos = null; }
/* 126 */     return null;
/*     */   }
/*     */   Color getRandColor(int fc, int bc) {
/* 129 */     Random random = new Random();
/* 130 */     if (fc > 255)
/* 131 */       fc = 255;
/* 132 */     if (bc > 255)
/* 133 */       bc = 255;
/* 134 */     int r = fc + random.nextInt(bc - fc);
/* 135 */     int g = fc + random.nextInt(bc - fc);
/* 136 */     int b = fc + random.nextInt(bc - fc);
/* 137 */     return new Color(r, g, b);
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */     throws IOException
/*     */   {
/* 146 */     FileInputStream fis = new FileInputStream("c:/go.gif");
/* 147 */     byte[] aa = new byte[1000];
/* 148 */     int a = -1;
/* 149 */     int aaa = 0;
/* 150 */     while ((a = fis.read()) != -1)
/*     */     {
/* 153 */       aa[aaa] = ((byte)a);
/* 154 */       aaa++;
/*     */     }
/*     */ 
/* 157 */     for (int i = 0; i < aa.length; i++)
/*     */     {
/* 159 */       System.out.print(aa[i]);
/*     */     }
/*     */   }
/*     */ }

/* Location:           D:\李慧医药项目\tcmages\krt\WEB-INF\classes\
 * Qualified Name:     org.ssi.struts.action.ImageAction
 * JD-Core Version:    0.6.2
 */