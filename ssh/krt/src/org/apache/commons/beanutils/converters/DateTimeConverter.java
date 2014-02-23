/*     */ package org.apache.commons.beanutils.converters;
/*     */ 
/*     */ import java.sql.Time;
/*     */ import java.sql.Timestamp;
/*     */ import java.text.DateFormat;
/*     */ import java.text.ParsePosition;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Calendar;
/*     */ import java.util.Locale;
/*     */ import java.util.TimeZone;
/*     */ import org.apache.commons.beanutils.ConversionException;
/*     */ import org.apache.commons.logging.Log;
/*     */ 
/*     */ public abstract class DateTimeConverter extends AbstractConverter
/*     */ {
/*     */   private String[] patterns;
/*     */   private String displayPatterns;
/*     */   private Locale locale;
/*     */   private TimeZone timeZone;
/*     */   private boolean useLocaleFormat;
/*     */ 
/*     */   public DateTimeConverter()
/*     */   {
/*     */   }
/*     */ 
/*     */   public DateTimeConverter(Object defaultValue)
/*     */   {
/* 107 */     super(defaultValue);
/*     */   }
/*     */ 
/*     */   public void setUseLocaleFormat(boolean useLocaleFormat)
/*     */   {
/* 120 */     this.useLocaleFormat = useLocaleFormat;
/*     */   }
/*     */ 
/*     */   public TimeZone getTimeZone()
/*     */   {
/* 130 */     return this.timeZone;
/*     */   }
/*     */ 
/*     */   public void setTimeZone(TimeZone timeZone)
/*     */   {
/* 139 */     this.timeZone = timeZone;
/*     */   }
/*     */ 
/*     */   public Locale getLocale()
/*     */   {
/* 149 */     return this.locale;
/*     */   }
/*     */ 
/*     */   public void setLocale(Locale locale)
/*     */   {
/* 158 */     this.locale = locale;
/* 159 */     setUseLocaleFormat(true);
/*     */   }
/*     */ 
/*     */   public void setPattern(String pattern)
/*     */   {
/* 170 */     setPatterns(new String[] { pattern });
/*     */   }
/*     */ 
/*     */   public String[] getPatterns()
/*     */   {
/* 182 */     return this.patterns;
/*     */   }
/*     */ 
/*     */   public void setPatterns(String[] patterns)
/*     */   {
/* 193 */     this.patterns = patterns;
/* 194 */     if ((patterns != null) && (patterns.length > 1)) {
/* 195 */       StringBuffer buffer = new StringBuffer();
/* 196 */       for (int i = 0; i < patterns.length; i++) {
/* 197 */         if (i > 0) {
/* 198 */           buffer.append(", ");
/*     */         }
/* 200 */         buffer.append(patterns[i]);
/*     */       }
/* 202 */       this.displayPatterns = buffer.toString();
/*     */     }
/* 204 */     setUseLocaleFormat(true);
/*     */   }
/*     */ 
/*     */   protected String convertToString(Object value)
/*     */     throws Throwable
/*     */   {
/* 224 */     java.util.Date date = null;
/* 225 */     if ((value instanceof java.util.Date))
/* 226 */       date = (java.util.Date)value;
/* 227 */     else if ((value instanceof Calendar))
/* 228 */       date = ((Calendar)value).getTime();
/* 229 */     else if ((value instanceof Long)) {
/* 230 */       date = new java.util.Date(((Long)value).longValue());
/*     */     }
/*     */ 
/* 233 */     String result = null;
/* 234 */     if ((this.useLocaleFormat) && (date != null)) {
/* 235 */       DateFormat format = null;
/* 236 */       if ((this.patterns != null) && (this.patterns.length > 0))
/* 237 */         format = getFormat(this.patterns[0]);
/*     */       else {
/* 239 */         format = getFormat(this.locale, this.timeZone);
/*     */       }
/* 241 */       logFormat("Formatting", format);
/* 242 */       result = format.format(date);
/* 243 */       if (log().isDebugEnabled())
/* 244 */         log().debug("    Converted  to String using format '" + result + "'");
/*     */     }
/*     */     else {
/* 247 */       result = value.toString();
/* 248 */       if (log().isDebugEnabled()) {
/* 249 */         log().debug("    Converted  to String using toString() '" + result + "'");
/*     */       }
/*     */     }
/* 252 */     return result;
/*     */   }
/*     */ 
/*     */   protected Object convertToType(Class targetType, Object value)
/*     */     throws Exception
/*     */   {
/* 286 */     Class sourceType = value.getClass();
/*     */ 
/* 289 */     if ((value instanceof Timestamp))
/*     */     {
/* 295 */       Timestamp timestamp = (Timestamp)value;
/* 296 */       long timeInMillis = timestamp.getTime() / 1000L * 1000L;
/* 297 */       timeInMillis += timestamp.getNanos() / 1000000;
/*     */ 
/* 299 */       return toDate(targetType, timeInMillis);
/*     */     }
/*     */ 
/* 303 */     if ((value instanceof java.util.Date)) {
/* 304 */       java.util.Date date = (java.util.Date)value;
/* 305 */       return toDate(targetType, date.getTime());
/*     */     }
/*     */ 
/* 309 */     if ((value instanceof Calendar)) {
/* 310 */       Calendar calendar = (Calendar)value;
/* 311 */       return toDate(targetType, calendar.getTime().getTime());
/*     */     }
/*     */ 
/* 315 */     if ((value instanceof Long)) {
/* 316 */       Long longObj = (Long)value;
/* 317 */       return toDate(targetType, longObj.longValue());
/*     */     }
/*     */ 
/* 322 */     String stringValue = value.toString().trim();
/* 323 */     if (stringValue.length() == 0)
/*     */     {
/* 325 */       setDefaultValue(null);
/* 326 */       return handleMissing(targetType);
/*     */     }
/*     */ 
/* 330 */     if (this.useLocaleFormat) {
/* 331 */       Calendar calendar = null;
/* 332 */       if ((this.patterns != null) && (this.patterns.length > 0)) {
/* 333 */         calendar = parse(sourceType, targetType, stringValue);
/*     */       } else {
/* 335 */         DateFormat format = getFormat(this.locale, this.timeZone);
/* 336 */         calendar = parse(sourceType, targetType, stringValue, format);
/*     */       }
/* 338 */       if (Calendar.class.isAssignableFrom(targetType)) {
/* 339 */         return calendar;
/*     */       }
/* 341 */       return toDate(targetType, calendar.getTime().getTime());
/*     */     }
/*     */ 
/* 346 */     return toDate(targetType, stringValue);
/*     */   }
/*     */ 
/*     */   private Object toDate(Class type, long value)
/*     */   {
/* 371 */     if (type.equals(java.util.Date.class)) {
/* 372 */       return new java.util.Date(value);
/*     */     }
/*     */ 
/* 376 */     if (type.equals(java.sql.Date.class)) {
/* 377 */       return new java.sql.Date(value);
/*     */     }
/*     */ 
/* 381 */     if (type.equals(Time.class)) {
/* 382 */       return new Time(value);
/*     */     }
/*     */ 
/* 386 */     if (type.equals(Timestamp.class)) {
/* 387 */       return new Timestamp(value);
/*     */     }
/*     */ 
/* 391 */     if (type.equals(Calendar.class)) {
/* 392 */       Calendar calendar = null;
/* 393 */       if ((this.locale == null) && (this.timeZone == null))
/* 394 */         calendar = Calendar.getInstance();
/* 395 */       else if (this.locale == null)
/* 396 */         calendar = Calendar.getInstance(this.timeZone);
/* 397 */       else if (this.timeZone == null)
/* 398 */         calendar = Calendar.getInstance(this.locale);
/*     */       else {
/* 400 */         calendar = Calendar.getInstance(this.timeZone, this.locale);
/*     */       }
/* 402 */       calendar.setTime(new java.util.Date(value));
/* 403 */       calendar.setLenient(false);
/* 404 */       return calendar;
/*     */     }
/*     */ 
/* 407 */     String msg = toString(getClass()) + " cannot handle conversion to '" + 
/* 408 */       toString(type) + "'";
/* 409 */     if (log().isWarnEnabled()) {
/* 410 */       log().warn("    " + msg);
/*     */     }
/* 412 */     throw new ConversionException(msg);
/*     */   }
/*     */ 
/*     */   private Object toDate(Class type, String value)
/*     */   {
/* 435 */     if (type.equals(java.sql.Date.class)) {
/*     */       try {
/* 437 */         return java.sql.Date.valueOf(value);
/*     */       } catch (IllegalArgumentException e) {
/* 439 */         throw new ConversionException(
/* 440 */           "String must be in JDBC format [yyyy-MM-dd] to create a java.sql.Date");
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 445 */     if (type.equals(Time.class)) {
/*     */       try {
/* 447 */         return Time.valueOf(value);
/*     */       } catch (IllegalArgumentException e) {
/* 449 */         throw new ConversionException(
/* 450 */           "String must be in JDBC format [HH:mm:ss] to create a java.sql.Time");
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 455 */     if (type.equals(Timestamp.class)) {
/*     */       try {
/* 457 */         return Timestamp.valueOf(value);
/*     */       } catch (IllegalArgumentException e) {
/* 459 */         throw new ConversionException(
/* 460 */           "String must be in JDBC format [yyyy-MM-dd HH:mm:ss.fffffffff] to create a java.sql.Timestamp");
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 465 */     String msg = toString(getClass()) + " does not support default String to '" + 
/* 466 */       toString(type) + "' conversion.";
/* 467 */     if (log().isWarnEnabled()) {
/* 468 */       log().warn("    " + msg);
/* 469 */       log().warn("    (N.B. Re-configure Converter or use alternative implementation)");
/*     */     }
/* 471 */     throw new ConversionException(msg);
/*     */   }
/*     */ 
/*     */   protected DateFormat getFormat(Locale locale, TimeZone timeZone)
/*     */   {
/* 482 */     DateFormat format = null;
/* 483 */     if (locale == null)
/* 484 */       format = DateFormat.getDateInstance(3);
/*     */     else {
/* 486 */       format = DateFormat.getDateInstance(3, locale);
/*     */     }
/* 488 */     if (timeZone != null) {
/* 489 */       format.setTimeZone(timeZone);
/*     */     }
/* 491 */     return format;
/*     */   }
/*     */ 
/*     */   private DateFormat getFormat(String pattern)
/*     */   {
/* 501 */     DateFormat format = new SimpleDateFormat(pattern);
/* 502 */     if (this.timeZone != null) {
/* 503 */       format.setTimeZone(this.timeZone);
/*     */     }
/* 505 */     return format;
/*     */   }
/*     */ 
/*     */   private Calendar parse(Class sourceType, Class targetType, String value)
/*     */     throws Exception
/*     */   {
/* 519 */     Exception firstEx = null;
/* 520 */     for (int i = 0; i < this.patterns.length; i++) {
/*     */       try {
/* 522 */         DateFormat format = getFormat(this.patterns[i]);
/* 523 */         return parse(sourceType, targetType, value, format);
/*     */       }
/*     */       catch (Exception ex) {
/* 526 */         if (firstEx == null) {
/* 527 */           firstEx = ex;
/*     */         }
/*     */       }
/*     */     }
/* 531 */     if (this.patterns.length > 1) {
/* 532 */       throw new ConversionException("Error converting '" + toString(sourceType) + "' to '" + toString(targetType) + 
/* 533 */         "' using  patterns '" + this.displayPatterns + "'");
/*     */     }
/* 535 */     throw firstEx;
/*     */   }
/*     */ 
/*     */   private Calendar parse(Class sourceType, Class targetType, String value, DateFormat format)
/*     */   {
/* 552 */     logFormat("Parsing", format);
/* 553 */     format.setLenient(false);
/* 554 */     ParsePosition pos = new ParsePosition(0);
/* 555 */     java.util.Date parsedDate = format.parse(value, pos);
/* 556 */     if ((pos.getErrorIndex() >= 0) || (pos.getIndex() != value.length()) || (parsedDate == null)) {
/* 557 */       String msg = "Error converting '" + toString(sourceType) + "' to '" + toString(targetType) + "'";
/* 558 */       if ((format instanceof SimpleDateFormat)) {
/* 559 */         msg = msg + " using pattern '" + ((SimpleDateFormat)format).toPattern() + "'";
/*     */       }
/* 561 */       if (log().isDebugEnabled()) {
/* 562 */         log().debug("    " + msg);
/*     */       }
/* 564 */       throw new ConversionException(msg);
/*     */     }
/* 566 */     Calendar calendar = format.getCalendar();
/* 567 */     return calendar;
/*     */   }
/*     */ 
/*     */   public String toString()
/*     */   {
/* 576 */     StringBuffer buffer = new StringBuffer();
/* 577 */     buffer.append(toString(getClass()));
/* 578 */     buffer.append("[UseDefault=");
/* 579 */     buffer.append(isUseDefault());
/* 580 */     buffer.append(", UseLocaleFormat=");
/* 581 */     buffer.append(this.useLocaleFormat);
/* 582 */     if (this.displayPatterns != null) {
/* 583 */       buffer.append(", Patterns={");
/* 584 */       buffer.append(this.displayPatterns);
/* 585 */       buffer.append('}');
/*     */     }
/* 587 */     if (this.locale != null) {
/* 588 */       buffer.append(", Locale=");
/* 589 */       buffer.append(this.locale);
/*     */     }
/* 591 */     if (this.timeZone != null) {
/* 592 */       buffer.append(", TimeZone=");
/* 593 */       buffer.append(this.timeZone);
/*     */     }
/* 595 */     buffer.append(']');
/* 596 */     return buffer.toString();
/*     */   }
/*     */ 
/*     */   private void logFormat(String action, DateFormat format)
/*     */   {
/* 605 */     if (log().isDebugEnabled()) {
/* 606 */       StringBuffer buffer = new StringBuffer(45);
/* 607 */       buffer.append("    ");
/* 608 */       buffer.append(action);
/* 609 */       buffer.append(" with Format");
/* 610 */       if ((format instanceof SimpleDateFormat)) {
/* 611 */         buffer.append("[");
/* 612 */         buffer.append(((SimpleDateFormat)format).toPattern());
/* 613 */         buffer.append("]");
/*     */       }
/* 615 */       buffer.append(" for ");
/* 616 */       if (this.locale == null) {
/* 617 */         buffer.append("default locale");
/*     */       } else {
/* 619 */         buffer.append("locale[");
/* 620 */         buffer.append(this.locale);
/* 621 */         buffer.append("]");
/*     */       }
/* 623 */       if (this.timeZone != null) {
/* 624 */         buffer.append(", TimeZone[");
/* 625 */         buffer.append(this.timeZone);
/* 626 */         buffer.append("]");
/*     */       }
/* 628 */       log().debug(buffer.toString());
/*     */     }
/*     */   }
/*     */ }

/* Location:           D:\李慧医药项目\tcmages\krt\WEB-INF\classes\
 * Qualified Name:     org.apache.commons.beanutils.converters.DateTimeConverter
 * JD-Core Version:    0.6.2
 */