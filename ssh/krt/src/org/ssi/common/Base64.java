/*     */ package org.ssi.common;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.OutputStream;
/*     */ import java.io.Writer;
/*     */ 
/*     */ public class Base64
/*     */ {
/*  15 */   private static final char[] S_BASE64CHAR = { 'A', 'B', 'C', 'D', 'E', 'F', 
/*  16 */     'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 
/*  17 */     'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 
/*  18 */     'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 
/*  19 */     't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', 
/*  20 */     '6', '7', '8', '9', '+', '/' };
/*     */ 
/*  25 */   private static final byte[] S_DECODETABLE = new byte[''];
/*     */ 
/*  26 */   static { for (int i = 0; i < S_DECODETABLE.length; i++) {
/*  27 */       S_DECODETABLE[i] = 127;
/*     */     }
/*  29 */     for (int i = 0; i < S_BASE64CHAR.length; i++)
/*  30 */       S_DECODETABLE[S_BASE64CHAR[i]] = ((byte)i);
/*     */   }
/*     */ 
/*     */   private static int decode0(char[] ibuf, byte[] obuf, int wp)
/*     */   {
/*  42 */     int outlen = 3;
/*  43 */     if (ibuf[3] == '=')
/*  44 */       outlen = 2;
/*  45 */     if (ibuf[2] == '=')
/*  46 */       outlen = 1;
/*  47 */     int b0 = S_DECODETABLE[ibuf[0]];
/*  48 */     int b1 = S_DECODETABLE[ibuf[1]];
/*  49 */     int b2 = S_DECODETABLE[ibuf[2]];
/*  50 */     int b3 = S_DECODETABLE[ibuf[3]];
/*  51 */     switch (outlen) {
/*     */     case 1:
/*  53 */       obuf[wp] = ((byte)(b0 << 2 & 0xFC | b1 >> 4 & 0x3));
/*  54 */       return 1;
/*     */     case 2:
/*  57 */       obuf[(wp++)] = ((byte)(b0 << 2 & 0xFC | b1 >> 4 & 0x3));
/*  58 */       obuf[wp] = ((byte)(b1 << 4 & 0xF0 | b2 >> 2 & 0xF));
/*  59 */       return 2;
/*     */     case 3:
/*  62 */       obuf[(wp++)] = ((byte)(b0 << 2 & 0xFC | b1 >> 4 & 0x3));
/*  63 */       obuf[(wp++)] = ((byte)(b1 << 4 & 0xF0 | b2 >> 2 & 0xF));
/*  64 */       obuf[wp] = ((byte)(b2 << 6 & 0xC0 | b3 & 0x3F));
/*  65 */       return 3;
/*     */     }
/*  67 */     throw new RuntimeException("Internal error");
/*     */   }
/*     */ 
/*     */   public static byte[] decode(char[] data, int off, int len)
/*     */   {
/*  78 */     char[] ibuf = new char[4];
/*  79 */     int ibufcount = 0;
/*  80 */     byte[] obuf = new byte[len / 4 * 3 + 3];
/*  81 */     int obufcount = 0;
/*  82 */     for (int i = off; i < off + len; i++) {
/*  83 */       char ch = data[i];
/*  84 */       if ((ch == '=') || (
/*  85 */         (ch < S_DECODETABLE.length) && (S_DECODETABLE[ch] != 127)))
/*     */       {
/*  87 */         ibuf[(ibufcount++)] = ch;
/*  88 */         if (ibufcount == ibuf.length) {
/*  89 */           ibufcount = 0;
/*  90 */           obufcount += decode0(ibuf, obuf, obufcount);
/*     */         }
/*     */       }
/*     */     }
/*  94 */     if (obufcount == obuf.length) {
/*  95 */       return obuf;
/*     */     }
/*  97 */     byte[] ret = new byte[obufcount];
/*  98 */     System.arraycopy(obuf, 0, ret, 0, obufcount);
/*  99 */     return ret;
/*     */   }
/*     */ 
/*     */   public static byte[] decode(String data)
/*     */   {
/* 109 */     char[] ibuf = new char[4];
/* 110 */     int ibufcount = 0;
/* 111 */     byte[] obuf = new byte[data.length() / 4 * 3 + 3];
/* 112 */     int obufcount = 0;
/* 113 */     for (int i = 0; i < data.length(); i++) {
/* 114 */       char ch = data.charAt(i);
/* 115 */       if ((ch == '=') || (
/* 116 */         (ch < S_DECODETABLE.length) && (S_DECODETABLE[ch] != 127)))
/*     */       {
/* 118 */         ibuf[(ibufcount++)] = ch;
/* 119 */         if (ibufcount == ibuf.length) {
/* 120 */           ibufcount = 0;
/* 121 */           obufcount += decode0(ibuf, obuf, obufcount);
/*     */         }
/*     */       }
/*     */     }
/* 125 */     if (obufcount == obuf.length) {
/* 126 */       return obuf;
/*     */     }
/* 128 */     byte[] ret = new byte[obufcount];
/* 129 */     System.arraycopy(obuf, 0, ret, 0, obufcount);
/* 130 */     return ret;
/*     */   }
/*     */ 
/*     */   public static void decode(char[] data, int off, int len, OutputStream ostream)
/*     */     throws IOException
/*     */   {
/* 144 */     char[] ibuf = new char[4];
/* 145 */     int ibufcount = 0;
/* 146 */     byte[] obuf = new byte[3];
/* 147 */     for (int i = off; i < off + len; i++) {
/* 148 */       char ch = data[i];
/* 149 */       if ((ch == '=') || (
/* 150 */         (ch < S_DECODETABLE.length) && (S_DECODETABLE[ch] != 127)))
/*     */       {
/* 152 */         ibuf[(ibufcount++)] = ch;
/* 153 */         if (ibufcount == ibuf.length) {
/* 154 */           ibufcount = 0;
/* 155 */           int obufcount = decode0(ibuf, obuf, 0);
/* 156 */           ostream.write(obuf, 0, obufcount);
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public static void decode(String data, OutputStream ostream)
/*     */     throws IOException
/*     */   {
/* 170 */     char[] ibuf = new char[4];
/* 171 */     int ibufcount = 0;
/* 172 */     byte[] obuf = new byte[3];
/* 173 */     for (int i = 0; i < data.length(); i++) {
/* 174 */       char ch = data.charAt(i);
/* 175 */       if ((ch == '=') || (
/* 176 */         (ch < S_DECODETABLE.length) && (S_DECODETABLE[ch] != 127)))
/*     */       {
/* 178 */         ibuf[(ibufcount++)] = ch;
/* 179 */         if (ibufcount == ibuf.length) {
/* 180 */           ibufcount = 0;
/* 181 */           int obufcount = decode0(ibuf, obuf, 0);
/* 182 */           ostream.write(obuf, 0, obufcount);
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public static String encode(byte[] data)
/*     */   {
/* 194 */     return encode(data, 0, data.length);
/*     */   }
/*     */ 
/*     */   public static String encode(byte[] data, int off, int len)
/*     */   {
/* 205 */     if (len <= 0)
/* 206 */       return "";
/* 207 */     char[] out = new char[len / 3 * 4 + 4];
/* 208 */     int rindex = off;
/* 209 */     int windex = 0;
/*     */ 		int rest;
/* 211 */     for ( rest = len - off; rest >= 3; rest -= 3) {
/* 212 */       int i = ((data[rindex] & 0xFF) << 16) + (
/* 213 */         (data[(rindex + 1)] & 0xFF) << 8) + (
/* 214 */         data[(rindex + 2)] & 0xFF);
/* 215 */       out[(windex++)] = S_BASE64CHAR[(i >> 18)];
/* 216 */       out[(windex++)] = S_BASE64CHAR[(i >> 12 & 0x3F)];
/* 217 */       out[(windex++)] = S_BASE64CHAR[(i >> 6 & 0x3F)];
/* 218 */       out[(windex++)] = S_BASE64CHAR[(i & 0x3F)];
/* 219 */       rindex += 3;
/*     */     }
/*     */ 
/* 222 */     if (rest == 1) {
/* 223 */       int i = data[rindex] & 0xFF;
/* 224 */       out[(windex++)] = S_BASE64CHAR[(i >> 2)];
/* 225 */       out[(windex++)] = S_BASE64CHAR[(i << 4 & 0x3F)];
/* 226 */       out[(windex++)] = '=';
/* 227 */       out[(windex++)] = '=';
/* 228 */     } else if (rest == 2) {
/* 229 */       int i = ((data[rindex] & 0xFF) << 8) + (data[(rindex + 1)] & 0xFF);
/* 230 */       out[(windex++)] = S_BASE64CHAR[(i >> 10)];
/* 231 */       out[(windex++)] = S_BASE64CHAR[(i >> 4 & 0x3F)];
/* 232 */       out[(windex++)] = S_BASE64CHAR[(i << 2 & 0x3F)];
/* 233 */       out[(windex++)] = '=';
/*     */     }
/* 235 */     return new String(out, 0, windex);
/*     */   }
/*     */ 
/*     */   public static void encode(byte[] data, int off, int len, OutputStream ostream)
/*     */     throws IOException
/*     */   {
/* 248 */     if (len <= 0)
/* 249 */       return;
/* 250 */     byte[] out = new byte[4];
/* 251 */     int rindex = off;
/*     */ 		int rest;
/* 253 */     for ( rest = len - off; rest >= 3; rest -= 3) {
/* 254 */       int i = ((data[rindex] & 0xFF) << 16) + (
/* 255 */         (data[(rindex + 1)] & 0xFF) << 8) + (
/* 256 */         data[(rindex + 2)] & 0xFF);
/* 257 */       out[0] = ((byte)S_BASE64CHAR[(i >> 18)]);
/* 258 */       out[1] = ((byte)S_BASE64CHAR[(i >> 12 & 0x3F)]);
/* 259 */       out[2] = ((byte)S_BASE64CHAR[(i >> 6 & 0x3F)]);
/* 260 */       out[3] = ((byte)S_BASE64CHAR[(i & 0x3F)]);
/* 261 */       ostream.write(out, 0, 4);
/* 262 */       rindex += 3;
/*     */     }
/*     */ 
/* 265 */     if (rest == 1) {
/* 266 */       int i = data[rindex] & 0xFF;
/* 267 */       out[0] = ((byte)S_BASE64CHAR[(i >> 2)]);
/* 268 */       out[1] = ((byte)S_BASE64CHAR[(i << 4 & 0x3F)]);
/* 269 */       out[2] = 61;
/* 270 */       out[3] = 61;
/* 271 */       ostream.write(out, 0, 4);
/* 272 */     } else if (rest == 2) {
/* 273 */       int i = ((data[rindex] & 0xFF) << 8) + (data[(rindex + 1)] & 0xFF);
/* 274 */       out[0] = ((byte)S_BASE64CHAR[(i >> 10)]);
/* 275 */       out[1] = ((byte)S_BASE64CHAR[(i >> 4 & 0x3F)]);
/* 276 */       out[2] = ((byte)S_BASE64CHAR[(i << 2 & 0x3F)]);
/* 277 */       out[3] = 61;
/* 278 */       ostream.write(out, 0, 4);
/*     */     }
/*     */   }
/*     */ 
/*     */   public static void encode(byte[] data, int off, int len, Writer writer)
/*     */     throws IOException
/*     */   {
/* 292 */     if (len <= 0)
/* 293 */       return;
/* 294 */     char[] out = new char[4];
/* 295 */     int rindex = off;
/* 296 */     int rest = len - off;
/* 297 */     int output = 0;
/*     */ 
/* 299 */     while (rest >= 3)
/*     */     {
/* 301 */       int i = ((data[rindex] & 0xFF) << 16) + (
/* 302 */         (data[(rindex + 1)] & 0xFF) << 8) + (
/* 303 */         data[(rindex + 2)] & 0xFF);
/* 304 */       out[0] = S_BASE64CHAR[(i >> 18)];
/* 305 */       out[1] = S_BASE64CHAR[(i >> 12 & 0x3F)];
/* 306 */       out[2] = S_BASE64CHAR[(i >> 6 & 0x3F)];
/* 307 */       out[3] = S_BASE64CHAR[(i & 0x3F)];
/* 308 */       writer.write(out, 0, 4);
/* 309 */       rindex += 3;
/* 310 */       rest -= 3;
/* 311 */       output += 4; if (output % 76 == 0)
/* 312 */         writer.write("\n");
/*     */     }
/* 314 */     if (rest == 1) {
/* 315 */       int i = data[rindex] & 0xFF;
/* 316 */       out[0] = S_BASE64CHAR[(i >> 2)];
/* 317 */       out[1] = S_BASE64CHAR[(i << 4 & 0x3F)];
/* 318 */       out[2] = '=';
/* 319 */       out[3] = '=';
/* 320 */       writer.write(out, 0, 4);
/* 321 */     } else if (rest == 2) {
/* 322 */       int i = ((data[rindex] & 0xFF) << 8) + (data[(rindex + 1)] & 0xFF);
/* 323 */       out[0] = S_BASE64CHAR[(i >> 10)];
/* 324 */       out[1] = S_BASE64CHAR[(i >> 4 & 0x3F)];
/* 325 */       out[2] = S_BASE64CHAR[(i << 2 & 0x3F)];
/* 326 */       out[3] = '=';
/* 327 */       writer.write(out, 0, 4);
/*     */     }
/*     */   }
/*     */ }

/* Location:           D:\李慧医药项目\tcmages\krt\WEB-INF\classes\
 * Qualified Name:     org.ssi.common.Base64
 * JD-Core Version:    0.6.2
 */