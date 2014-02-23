/*     */ package org.ssi.common;
/*     */ 
/*     */ import java.lang.reflect.Field;
/*     */ import java.lang.reflect.InvocationTargetException;
/*     */ import java.lang.reflect.Method;
/*     */ import org.apache.commons.beanutils.BeanUtils;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ 
/*     */ public class ObjectReflect
/*     */ {
/*  18 */   private Object obj = null;
/*     */ 
/*  20 */   private int len = 1;
/*  21 */   private static Log log = LogFactory.getLog(ObjectReflect.class);
/*     */ 
/*  23 */   public ObjectReflect(Object obj) { this.obj = obj; }
/*     */ 
/*     */ 
/*     */   public int getLen()
/*     */   {
/*  30 */     return this.len;
/*     */   }
/*     */ 
/*     */   public void setLen(int len)
/*     */   {
/*  37 */     this.len = len;
/*     */   }
/*     */ 
/*     */   public Field getField(String name, boolean caseSensitive)
/*     */   {
/*  47 */     Field revalue = null;
/*     */     try {
/*  49 */       if (caseSensitive) {
/*  50 */         revalue = this.obj.getClass().getDeclaredField(name);
/*     */       } else {
/*  52 */         Field[] fields = this.obj.getClass().getDeclaredFields();
/*  53 */         if (fields.length == 0)
/*     */         {
/*  55 */           fields = this.obj.getClass().getSuperclass().getDeclaredFields();
/*     */         }
/*  57 */         for (int i = 0; i < fields.length; i++)
/*  58 */           if (fields[i].getName().equalsIgnoreCase(name)) {
/*  59 */             revalue = fields[i];
/*  60 */             break;
/*     */           }
/*     */       }
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/*  66 */       log.warn(ex.getMessage());
/*  67 */       if (log.isDebugEnabled())
/*     */       {
/*  69 */         ex.printStackTrace();
/*     */       }
/*     */     }
/*  72 */     return revalue;
/*     */   }
/*     */ 
/*     */   public Method getSetVarMethod(Field field)
/*     */   {
/*  82 */     Method revalue = null;
/*  83 */     String methodName = "set" + field.getName().substring(0, this.len).toUpperCase() + field.getName().substring(this.len);
/*  84 */     Class[] param = { field.getType() };
/*     */     try {
/*  86 */       revalue = this.obj.getClass().getDeclaredMethod(methodName, param);
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/*     */       try
/*     */       {
/*  92 */         if (revalue == null)
/*     */         {
/*  94 */           revalue = this.obj.getClass().getSuperclass().getDeclaredMethod(methodName, param);
/*     */         }
/*     */       }
/*     */       catch (Exception e)
/*     */       {
/*  99 */         log.warn(ex.getMessage());
/* 100 */         if (log.isDebugEnabled())
/*     */         {
/* 102 */           ex.printStackTrace();
/*     */         }
/*     */       }
/*     */     }
/* 106 */     return revalue;
/*     */   }
/*     */ 
/*     */   public Method getSetVarMethod(String field, Class clazz)
/*     */   {
/* 114 */     Method revalue = null;
/* 115 */     String methodName = "set" + field.substring(0, this.len).toUpperCase() + field.substring(this.len);
/* 116 */     Class[] param = { clazz };
/*     */     try {
/* 118 */       revalue = this.obj.getClass().getDeclaredMethod(methodName, param);
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/*     */       try
/*     */       {
/* 124 */         if (revalue == null)
/*     */         {
/* 126 */           revalue = this.obj.getClass().getSuperclass().getDeclaredMethod(methodName, param);
/*     */         }
/*     */       }
/*     */       catch (Exception e)
/*     */       {
/* 131 */         log.warn(ex.getMessage());
/* 132 */         if (log.isDebugEnabled())
/*     */         {
/* 134 */           ex.printStackTrace();
/*     */         }
/*     */       }
/*     */     }
/* 138 */     return revalue;
/*     */   }
/*     */ 
/*     */   public Method getGetVarMethod(Field field)
/*     */   {
/* 146 */     Method revalue = null;
/* 147 */     String methodName = "get" + field.getName().substring(0, this.len).toUpperCase() + field.getName().substring(this.len);
/*     */     try {
/* 149 */       revalue = this.obj.getClass().getDeclaredMethod(methodName, null);
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/*     */       try {
/* 154 */         if (revalue == null)
/*     */         {
/* 156 */           revalue = this.obj.getClass().getSuperclass().getDeclaredMethod(methodName, new Class[0]);
/*     */         }
/*     */       }
/*     */       catch (Exception e)
/*     */       {
/* 161 */         log.warn(ex.getMessage());
/* 162 */         if (log.isDebugEnabled())
/*     */         {
/* 164 */           ex.printStackTrace();
/*     */         }
/*     */       }
/*     */     }
/* 168 */     return revalue;
/*     */   }
/*     */ 
/*     */   public void invokeSet(String name, Object value)
/*     */   {
/* 179 */     invokeSet(name, value, false);
/*     */   }
/*     */ 
/*     */   public void invokeGet(String name)
/*     */   {
/* 189 */     invokeGet(name, false);
/*     */   }
/*     */ 
/*     */   public void invokeSet(String name, Object value, boolean caseSensitive)
/*     */   {
/* 199 */     if ((this.obj != null) && (name != null) && (!"".equals(name)))
/*     */     {
/* 202 */       String field = name;
/* 203 */       if (field != null)
/*     */       {
/* 205 */         Method method = getSetVarMethod(field, value.getClass());
/* 206 */         if (method != null)
/*     */           try
/*     */           {
/* 209 */             method.invoke(this.obj, new Object[] { value });
/*     */           }
/*     */           catch (IllegalArgumentException ex) {
/* 212 */             log.warn(ex.getMessage());
/* 213 */             if (log.isDebugEnabled())
/*     */             {
/* 215 */               ex.printStackTrace();
/*     */             }
/*     */           }
/*     */           catch (IllegalAccessException ex) {
/* 219 */             log.warn(ex.getMessage());
/* 220 */             if (log.isDebugEnabled())
/*     */             {
/* 222 */               ex.printStackTrace();
/*     */             }
/*     */           }
/*     */           catch (InvocationTargetException ex) {
/* 226 */             log.warn(ex.getMessage());
/* 227 */             if (log.isDebugEnabled())
/*     */             {
/* 229 */               ex.printStackTrace();
/*     */             }
/*     */           }
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public void invokeGet(String name, boolean caseSensitive)
/*     */   {
/* 244 */     if ((this.obj != null) && (name != null) && (!"".equals(name)))
/*     */     {
/* 246 */       Field field = getField(name, caseSensitive);
/* 247 */       if (field != null)
/*     */       {
/* 249 */         Method method = getGetVarMethod(field);
/* 250 */         if (method != null)
/*     */           try
/*     */           {
/* 253 */             method.invoke(this.obj, new Object[0]);
/*     */           }
/*     */           catch (IllegalArgumentException ex) {
/* 256 */             log.warn(ex.getMessage());
/* 257 */             if (log.isDebugEnabled())
/*     */             {
/* 259 */               ex.printStackTrace();
/*     */             }
/*     */           }
/*     */           catch (IllegalAccessException ex) {
/* 263 */             log.warn(ex.getMessage());
/* 264 */             if (log.isDebugEnabled())
/*     */             {
/* 266 */               ex.printStackTrace();
/*     */             }
/*     */           }
/*     */           catch (InvocationTargetException ex) {
/* 270 */             log.warn(ex.getMessage());
/* 271 */             if (log.isDebugEnabled())
/*     */             {
/* 273 */               ex.printStackTrace();
/*     */             }
/*     */           }
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public static void copyProperties(Object target, Object source)
/*     */   {
/*     */     try
/*     */     {
/* 290 */       BeanUtils.copyProperties(target, source);
/*     */     }
/*     */     catch (IllegalAccessException ex) {
/* 293 */       log.warn(ex.getMessage());
/* 294 */       if (log.isDebugEnabled())
/*     */       {
/* 296 */         ex.printStackTrace();
/*     */       }
/*     */     }
/*     */     catch (InvocationTargetException ex) {
/* 300 */       log.warn(ex.getMessage());
/* 301 */       if (log.isDebugEnabled())
/*     */       {
/* 303 */         ex.printStackTrace();
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public static void copyProperty(Object target, String name, Object value)
/*     */   {
/*     */     try
/*     */     {
/* 317 */       BeanUtils.copyProperty(target, name, value);
/*     */     }
/*     */     catch (IllegalAccessException ex) {
/* 320 */       log.warn(ex.getMessage());
/* 321 */       if (log.isDebugEnabled())
/*     */       {
/* 323 */         ex.printStackTrace();
/*     */       }
/*     */     }
/*     */     catch (InvocationTargetException ex) {
/* 327 */       log.warn(ex.getMessage());
/* 328 */       if (log.isDebugEnabled())
/*     */       {
/* 330 */         ex.printStackTrace();
/*     */       }
/*     */     }
/*     */   }
/*     */ }

/* Location:           D:\李慧医药项目\tcmages\krt\WEB-INF\classes\
 * Qualified Name:     org.ssi.common.ObjectReflect
 * JD-Core Version:    0.6.2
 */