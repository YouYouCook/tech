/*     */ package org.ssi.tag;
/*     */ 
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.ssi.common.ObjectReflect;
/*     */ 
/*     */ public class ComparableTag extends SSITag
/*     */ {
/*     */   private static final long serialVersionUID = -5690637185210464785L;
/*  24 */   private String property = null;
/*     */ 
/*  26 */   private String type = null;
/*     */ 
/*  28 */   private String propertyName = null;
/*     */ 
/* 100 */   private String propertyValue = null;
/*     */ 
/* 102 */   private int len = 1;
/*     */ 
/*     */   public String getProperty()
/*     */   {
/*  33 */     return this.property;
/*     */   }
/*     */ 
/*     */   public String getType()
/*     */   {
/*  40 */     return this.type;
/*     */   }
/*     */ 
/*     */   public String getPropertyName()
/*     */   {
/*  47 */     return this.propertyName;
/*     */   }
/*     */ 
/*     */   public String getPropertyValue()
/*     */   {
/*  54 */     return this.propertyValue;
/*     */   }
/*     */ 
/*     */   public int getLen()
/*     */   {
/*  61 */     return this.len;
/*     */   }
/*     */ 
/*     */   public void setProperty(String property)
/*     */   {
/*  68 */     this.property = property;
/*     */   }
/*     */ 
/*     */   public void setType(String type)
/*     */   {
/*  75 */     this.type = type;
/*     */   }
/*     */ 
/*     */   public void setPropertyName(String propertyName)
/*     */   {
/*  82 */     this.propertyName = propertyName;
/*     */   }
/*     */ 
/*     */   public void setPropertyValue(String propertyValue)
/*     */   {
/*  89 */     this.propertyValue = propertyValue;
/*     */   }
/*     */ 
/*     */   public void setLen(int len)
/*     */   {
/*  96 */     this.len = len;
/*     */   }
/*     */ 
/*     */   protected int doEndEntity()
/*     */   {
/* 108 */     return 6;
/*     */   }
/*     */ 
/*     */   protected int doStartEntity()
/*     */   {
/* 114 */     boolean hasValue = false;
/* 115 */     if ((this.property != null) && (!"".equals(this.property)) && (this.type != null) && (!"".equals(this.type)) && (this.propertyName != null) && (!"".equals(this.propertyName)) && (this.propertyValue != null) && (!"".equals(this.propertyValue)))
/*     */     {
/* 117 */       List list = (List)this.request.getAttribute(this.property);
/*     */ 
/* 119 */       Class clazz = null;
/* 120 */       Object obj = null;
/*     */       try {
/* 122 */         clazz = Class.forName(this.type);
/* 123 */         if ((clazz != null) && (list != null) && (list.size() > 0))
/*     */         {
/* 125 */           obj = clazz.newInstance();
/*     */         }
/*     */       }
/*     */       catch (ClassNotFoundException e) {
/* 129 */         this.log.warn(e.getMessage());
/* 130 */         if (this.log.isDebugEnabled())
/*     */         {
/* 132 */           e.printStackTrace();
/*     */         }
/*     */       }
/*     */       catch (InstantiationException e) {
/* 136 */         this.log.warn(e.getMessage());
/* 137 */         if (this.log.isDebugEnabled())
/*     */         {
/* 139 */           e.printStackTrace();
/*     */         }
/*     */       }
/*     */       catch (IllegalAccessException e) {
/* 143 */         this.log.warn(e.getMessage());
/* 144 */         if (this.log.isDebugEnabled())
/*     */         {
/* 146 */           e.printStackTrace();
/*     */         }
/*     */       }
/*     */       catch (Exception e) {
/* 150 */         this.log.warn(e.getMessage());
/* 151 */         if (this.log.isDebugEnabled())
/*     */         {
/* 153 */           e.printStackTrace();
/*     */         }
/*     */       }
/* 156 */       if (obj != null)
/*     */       {
/* 158 */         ObjectReflect or = new ObjectReflect(obj);
/* 159 */         or.setLen(this.len);
/*     */ 
/* 161 */         or.invokeSet(this.propertyName, this.propertyValue);
/*     */ 
/* 163 */         Collections.sort(list);
/*     */ 
/* 165 */         int index = Collections.binarySearch(list, obj);
/* 166 */         if (index >= 0)
/*     */         {
/* 168 */           hasValue = true;
/*     */         }
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 174 */     if (hasValue)
/*     */     {
/* 176 */       return 1;
/*     */     }
/* 178 */     return 0;
/*     */   }
/*     */ }

/* Location:           D:\李慧医药项目\tcmages\krt\WEB-INF\classes\
 * Qualified Name:     org.ssi.tag.ComparableTag
 * JD-Core Version:    0.6.2
 */