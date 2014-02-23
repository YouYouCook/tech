/*     */ package org.ssi.common;
/*     */ 
/*     */ import java.io.PrintStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/*     */ 
/*     */ public class MD5
/*     */ {
/*     */   static final int S11 = 7;
/*     */   static final int S12 = 12;
/*     */   static final int S13 = 17;
/*     */   static final int S14 = 22;
/*     */   static final int S21 = 5;
/*     */   static final int S22 = 9;
/*     */   static final int S23 = 14;
/*     */   static final int S24 = 20;
/*     */   static final int S31 = 4;
/*     */   static final int S32 = 11;
/*     */   static final int S33 = 16;
/*     */   static final int S34 = 23;
/*     */   static final int S41 = 6;
/*     */   static final int S42 = 10;
/*     */   static final int S43 = 15;
/*     */   static final int S44 = 21;
/*  38 */   static final byte[] PADDING = { 
/*  39 */     -128 };
/*     */ 
/* 106 */   private long[] state = new long[4];
/* 107 */   private long[] count = new long[2];
/*     */ 
/* 109 */   private byte[] buffer = new byte[64];
/*     */   public String digestHexStr;
/* 118 */   private byte[] digest = new byte[16];
/*     */ 
	public String getMD5ofStr(String inbuf) {
		String md5 = null;

		if (null == inbuf)
			return null;

		try {

			// Create MessageDigest object for MD5
			MessageDigest digest = MessageDigest.getInstance("MD5");

			// Update input string in message digest
			digest.update(inbuf.getBytes(), 0, inbuf.length());

			// Converts message digest value in base 16 (hex)
			md5 = new BigInteger(1, digest.digest()).toString(16);
			
		} catch (NoSuchAlgorithmException e) {

			e.printStackTrace();
		}
		return md5.toUpperCase();
		
		
	}

//			public String getMD5ofStr(String inbuf)
//			{
//			  md5Init();
//			  md5Update(inbuf.getBytes(), inbuf.length());
//			  md5Final();
//			  this.digestHexStr = "";
//			  for (int i = 0; i < 16; i++) {
//			    this.digestHexStr += byteHEX(this.digest[i]);
//			  }
//			  return this.digestHexStr;
//			}
/*     */ 
/*     */   public MD5()
/*     */   {
/* 138 */     md5Init();
/*     */   }
/*     */ 
/*     */   private void md5Init()
/*     */   {
/* 145 */     this.count[0] = 0L;
/* 146 */     this.count[1] = 0L;
/*     */ 
/* 149 */     this.state[0] = 1732584193L;
/* 150 */     this.state[1] = 4023233417L;
/* 151 */     this.state[2] = 2562383102L;
/* 152 */     this.state[3] = 271733878L;
/*     */   }
/*     */ 
/*     */   private long F(long x, long y, long z)
/*     */   {
/* 162 */     return x & y | (x ^ 0xFFFFFFFF) & z;
/*     */   }
/*     */ 
/*     */   private long G(long x, long y, long z)
/*     */   {
/* 167 */     return x & z | y & (z ^ 0xFFFFFFFF);
/*     */   }
/*     */ 
/*     */   private long H(long x, long y, long z)
/*     */   {
/* 172 */     return x ^ y ^ z;
/*     */   }
/*     */ 
/*     */   private long I(long x, long y, long z) {
/* 176 */     return y ^ (x | z ^ 0xFFFFFFFF);
/*     */   }
/*     */ 
/*     */   private long FF(long a, long b, long c, long d, long x, long s, long ac)
/*     */   {
/* 186 */     a += F(b, c, d) + x + ac;
/* 187 */     a = (int)a << (int)s | (int)a >>> (int)(32L - s);
/* 188 */     a += b;
/* 189 */     return a;
/*     */   }
/*     */ 
/*     */   private long GG(long a, long b, long c, long d, long x, long s, long ac) {
/* 193 */     a += G(b, c, d) + x + ac;
/* 194 */     a = (int)a << (int)s | (int)a >>> (int)(32L - s);
/* 195 */     a += b;
/* 196 */     return a;
/*     */   }
/*     */ 
/*     */   private long HH(long a, long b, long c, long d, long x, long s, long ac) {
/* 200 */     a += H(b, c, d) + x + ac;
/* 201 */     a = (int)a << (int)s | (int)a >>> (int)(32L - s);
/* 202 */     a += b;
/* 203 */     return a;
/*     */   }
/*     */ 
/*     */   private long II(long a, long b, long c, long d, long x, long s, long ac) {
/* 207 */     a += I(b, c, d) + x + ac;
/* 208 */     a = (int)a << (int)s | (int)a >>> (int)(32L - s);
/* 209 */     a += b;
/* 210 */     return a;
/*     */   }
/*     */ 
/*     */   private void md5Update(byte[] inbuf, int inputLen)
/*     */   {
/* 220 */     byte[] block = new byte[64];
/* 221 */     int index = (int)(this.count[0] >>> 3) & 0x3F;
/*     */ 
/* 223 */    // if (this.count[0] += (inputLen << 3) < inputLen << 3) {
				if ((this.count[0] += (inputLen << 3)) < inputLen << 3) {
/* 224 */       this.count[1] += 1L;
/*     */     }
/* 226 */     this.count[1] += (inputLen >>> 29);
/*     */ 
/* 228 */     int partLen = 64 - index;
/*     */     int i;
/* 231 */     if (inputLen >= partLen) {
/* 232 */       md5Memcpy(this.buffer, inbuf, index, 0, partLen);
/* 233 */       md5Transform(this.buffer);
/*     */ 
/* 235 */       for ( i = partLen; i + 63 < inputLen; i += 64)
/*     */       {
/* 237 */         md5Memcpy(block, inbuf, 0, i, 64);
/* 238 */         md5Transform(block);
/*     */       }
/* 240 */       index = 0;
/*     */     }
/*     */     else
/*     */     {
/* 244 */       i = 0;
/*     */     }
/*     */ 
/* 248 */     md5Memcpy(this.buffer, inbuf, index, i, inputLen - i);
/*     */   }
/*     */ 
/*     */   private void md5Final()
/*     */   {
/* 256 */     byte[] bits = new byte[8];
/*     */ 
/* 260 */     Encode(bits, this.count, 8);
/*     */ 
/* 263 */     int index = (int)(this.count[0] >>> 3) & 0x3F;
/* 264 */     int padLen = index < 56 ? 56 - index : 120 - index;
/* 265 */     md5Update(PADDING, padLen);
/*     */ 
/* 268 */     md5Update(bits, 8);
/*     */ 
/* 271 */     Encode(this.digest, this.state, 16);
/*     */   }
/*     */ 
/*     */   private void md5Memcpy(byte[] output, byte[] input, int outpos, int inpos, int len)
/*     */   {
/* 287 */     for (int i = 0; i < len; i++)
/* 288 */       output[(outpos + i)] = input[(inpos + i)];
/*     */   }
/*     */ 
/*     */   private void md5Transform(byte[] block)
/*     */   {
/* 296 */     long a = this.state[0]; long b = this.state[1]; long c = this.state[2]; long d = this.state[3];
/* 297 */     long[] x = new long[16];
/*     */ 
/* 299 */     Decode(x, block, 64);
/*     */ 
/* 302 */     a = FF(a, b, c, d, x[0], 7L, 3614090360L);
/* 303 */     d = FF(d, a, b, c, x[1], 12L, 3905402710L);
/* 304 */     c = FF(c, d, a, b, x[2], 17L, 606105819L);
/* 305 */     b = FF(b, c, d, a, x[3], 22L, 3250441966L);
/* 306 */     a = FF(a, b, c, d, x[4], 7L, 4118548399L);
/* 307 */     d = FF(d, a, b, c, x[5], 12L, 1200080426L);
/* 308 */     c = FF(c, d, a, b, x[6], 17L, 2821735955L);
/* 309 */     b = FF(b, c, d, a, x[7], 22L, 4249261313L);
/* 310 */     a = FF(a, b, c, d, x[8], 7L, 1770035416L);
/* 311 */     d = FF(d, a, b, c, x[9], 12L, 2336552879L);
/* 312 */     c = FF(c, d, a, b, x[10], 17L, 4294925233L);
/* 313 */     b = FF(b, c, d, a, x[11], 22L, 2304563134L);
/* 314 */     a = FF(a, b, c, d, x[12], 7L, 1804603682L);
/* 315 */     d = FF(d, a, b, c, x[13], 12L, 4254626195L);
/* 316 */     c = FF(c, d, a, b, x[14], 17L, 2792965006L);
/* 317 */     b = FF(b, c, d, a, x[15], 22L, 1236535329L);
/*     */ 
/* 320 */     a = GG(a, b, c, d, x[1], 5L, 4129170786L);
/* 321 */     d = GG(d, a, b, c, x[6], 9L, 3225465664L);
/* 322 */     c = GG(c, d, a, b, x[11], 14L, 643717713L);
/* 323 */     b = GG(b, c, d, a, x[0], 20L, 3921069994L);
/* 324 */     a = GG(a, b, c, d, x[5], 5L, 3593408605L);
/* 325 */     d = GG(d, a, b, c, x[10], 9L, 38016083L);
/* 326 */     c = GG(c, d, a, b, x[15], 14L, 3634488961L);
/* 327 */     b = GG(b, c, d, a, x[4], 20L, 3889429448L);
/* 328 */     a = GG(a, b, c, d, x[9], 5L, 568446438L);
/* 329 */     d = GG(d, a, b, c, x[14], 9L, 3275163606L);
/* 330 */     c = GG(c, d, a, b, x[3], 14L, 4107603335L);
/* 331 */     b = GG(b, c, d, a, x[8], 20L, 1163531501L);
/* 332 */     a = GG(a, b, c, d, x[13], 5L, 2850285829L);
/* 333 */     d = GG(d, a, b, c, x[2], 9L, 4243563512L);
/* 334 */     c = GG(c, d, a, b, x[7], 14L, 1735328473L);
/* 335 */     b = GG(b, c, d, a, x[12], 20L, 2368359562L);
/*     */ 
/* 338 */     a = HH(a, b, c, d, x[5], 4L, 4294588738L);
/* 339 */     d = HH(d, a, b, c, x[8], 11L, 2272392833L);
/* 340 */     c = HH(c, d, a, b, x[11], 16L, 1839030562L);
/* 341 */     b = HH(b, c, d, a, x[14], 23L, 4259657740L);
/* 342 */     a = HH(a, b, c, d, x[1], 4L, 2763975236L);
/* 343 */     d = HH(d, a, b, c, x[4], 11L, 1272893353L);
/* 344 */     c = HH(c, d, a, b, x[7], 16L, 4139469664L);
/* 345 */     b = HH(b, c, d, a, x[10], 23L, 3200236656L);
/* 346 */     a = HH(a, b, c, d, x[13], 4L, 681279174L);
/* 347 */     d = HH(d, a, b, c, x[0], 11L, 3936430074L);
/* 348 */     c = HH(c, d, a, b, x[3], 16L, 3572445317L);
/* 349 */     b = HH(b, c, d, a, x[6], 23L, 76029189L);
/* 350 */     a = HH(a, b, c, d, x[9], 4L, 3654602809L);
/* 351 */     d = HH(d, a, b, c, x[12], 11L, 3873151461L);
/* 352 */     c = HH(c, d, a, b, x[15], 16L, 530742520L);
/* 353 */     b = HH(b, c, d, a, x[2], 23L, 3299628645L);
/*     */ 
/* 356 */     a = II(a, b, c, d, x[0], 6L, 4096336452L);
/* 357 */     d = II(d, a, b, c, x[7], 10L, 1126891415L);
/* 358 */     c = II(c, d, a, b, x[14], 15L, 2878612391L);
/* 359 */     b = II(b, c, d, a, x[5], 21L, 4237533241L);
/* 360 */     a = II(a, b, c, d, x[12], 6L, 1700485571L);
/* 361 */     d = II(d, a, b, c, x[3], 10L, 2399980690L);
/* 362 */     c = II(c, d, a, b, x[10], 15L, 4293915773L);
/* 363 */     b = II(b, c, d, a, x[1], 21L, 2240044497L);
/* 364 */     a = II(a, b, c, d, x[8], 6L, 1873313359L);
/* 365 */     d = II(d, a, b, c, x[15], 10L, 4264355552L);
/* 366 */     c = II(c, d, a, b, x[6], 15L, 2734768916L);
/* 367 */     b = II(b, c, d, a, x[13], 21L, 1309151649L);
/* 368 */     a = II(a, b, c, d, x[4], 6L, 4149444226L);
/* 369 */     d = II(d, a, b, c, x[11], 10L, 3174756917L);
/* 370 */     c = II(c, d, a, b, x[2], 15L, 718787259L);
/* 371 */     b = II(b, c, d, a, x[9], 21L, 3951481745L);
/*     */ 
/* 373 */     this.state[0] += a;
/* 374 */     this.state[1] += b;
/* 375 */     this.state[2] += c;
/* 376 */     this.state[3] += d;
/*     */   }
/*     */ 
/*     */   private void Encode(byte[] output, long[] input, int len)
/*     */   {
/* 386 */     int i = 0; for (int j = 0; j < len; j += 4) {
/* 387 */       output[j] = ((byte)(int)(input[i] & 0xFF));
/* 388 */       output[(j + 1)] = ((byte)(int)(input[i] >>> 8 & 0xFF));
/* 389 */       output[(j + 2)] = ((byte)(int)(input[i] >>> 16 & 0xFF));
/* 390 */       output[(j + 3)] = ((byte)(int)(input[i] >>> 24 & 0xFF));
/*     */ 
/* 386 */       i++;
/*     */     }
/*     */   }
/*     */ 
/*     */   private void Decode(long[] output, byte[] input, int len)
/*     */   {
/* 400 */     int i = 0; for (int j = 0; j < len; j += 4) {
/* 401 */       output[i] = 
/* 402 */         (b2iu(input[j]) | 
/* 403 */         b2iu(input[(j + 1)]) << 8 | 
/* 404 */         b2iu(input[(j + 2)]) << 16 | 
/* 405 */         b2iu(input[(j + 3)]) << 24);
/*     */ 
/* 400 */       i++;
/*     */     }
/*     */   }
/*     */ 
/*     */   public static long b2iu(byte b)
/*     */   {
/* 415 */     return b < 0 ? b & 0xFF : b;
/*     */   }
/*     */ 
/*     */   public static String byteHEX(byte ib)
/*     */   {
/* 423 */     char[] Digit = { 
/* 424 */       '0', 
/* 425 */       '1', 
/* 426 */       '2', 
/* 427 */       '3', 
/* 428 */       '4', 
/* 429 */       '5', 
/* 430 */       '6', 
/* 431 */       '7', 
/* 432 */       '8', 
/* 433 */       '9', 
/* 434 */       'A', 
/* 435 */       'B', 
/* 436 */       'C', 
/* 437 */       'D', 
/* 438 */       'E', 
/* 439 */       'F' };
/* 440 */     char[] ob = new char[2];
/* 441 */     ob[0] = Digit[(ib >>> 4 & 0xF)];
/* 442 */     ob[1] = Digit[(ib & 0xF)];
/* 443 */     String s = new String(ob);
/* 444 */     return s;
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/* 449 */     MD5 m = new MD5();
/*     */ 
/* 462 */     System.out.println("dd=" + m.getMD5ofStr("asdf234444444444444444444444444444444444444441"));
/*     */   }
/*     */ }

/* Location:           D:\李慧医药项目\tcmages\krt\WEB-INF\classes\
 * Qualified Name:     org.ssi.common.MD5
 * JD-Core Version:    0.6.2
 */