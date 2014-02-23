/*     */ package org.ssi.services;
/*     */ 
/*     */ import javax.xml.rpc.ServiceException;
/*     */ import javax.xml.rpc.Stub;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ 
/*     */ public abstract class ServiceProxy
/*     */   implements IDriverService
/*     */ {
/*  27 */   protected Log log = LogFactory.getLog(getClass());
/*  28 */   private String _endpoint = null;
/*     */ 
/*  31 */   protected IDriverService service = null;
/*     */ 
/*  33 */   private String url = null;
/*     */ 
/*  35 */   private String wsddServiceName = null;
/*     */ 
/*  37 */   private Class stubClass = null;
/*     */ 
/*     */   public Object getObject(String methodName, Object[] param)
/*     */   {
/*  24 */     return null;
/*     */   }
/*     */ 
/*     */   public ServiceProxy()
/*     */   {
/*     */   }
/*     */ 
/*     */   public ServiceProxy(String url, String name, Class c)
/*     */   {
/*  54 */     setUrl(url);
/*  55 */     setWsddServiceName(name);
/*  56 */     setStubClass(c);
/*  57 */     _initProxy();
/*     */   }
/*     */ 
/*     */   private void _initProxy()
/*     */   {
/*     */     try
/*     */     {
/*  65 */       this.log.debug("初始化代理");
/*  66 */       ServiceLocator tempServiceLocator = new ServiceLocator();
/*  67 */       tempServiceLocator.setUrl(this.url);
/*  68 */       tempServiceLocator.setWsddServiceName(this.wsddServiceName);
/*  69 */       tempServiceLocator.setStubClass(this.stubClass);
/*  70 */       this.service = tempServiceLocator.getService();
/*  71 */       if (this.service != null)
/*  72 */         if (this._endpoint != null)
/*  73 */           ((Stub)this.service)
/*  74 */             ._setProperty(
/*  75 */             "javax.xml.rpc.service.endpoint.address", 
/*  76 */             this._endpoint);
/*     */         else
/*  78 */           this._endpoint = ((String)
/*  79 */             ((Stub)this.service)._getProperty("javax.xml.rpc.service.endpoint.address"));
/*     */     }
/*     */     catch (ServiceException e)
/*     */     {
/*  83 */       e.printStackTrace();
/*     */     }
/*     */     catch (IllegalArgumentException e)
/*     */     {
/*  87 */       e.printStackTrace();
/*     */     }
/*     */     catch (SecurityException e) {
/*  90 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   public String getEndpoint()
/*     */   {
/*  99 */     return this._endpoint;
/*     */   }
/*     */ 
/*     */   public IDriverService getService()
/*     */   {
/* 109 */     if (this.service == null)
/* 110 */       _initProxy();
/* 111 */     return this.service;
/*     */   }
/*     */ 
/*     */   public void setEndpoint(String endpoint)
/*     */   {
/* 119 */     this._endpoint = endpoint;
/* 120 */     if (this.service != null)
/* 121 */       ((Stub)this.service)._setProperty(
/* 122 */         "javax.xml.rpc.service.endpoint.address", this._endpoint);
/*     */   }
/*     */ 
/*     */   public void setUrl(String url)
/*     */   {
/* 130 */     this.url = url;
/*     */ 
/* 132 */     if ((this.url != null) && (this.wsddServiceName != null) && (this.stubClass != null))
/*     */     {
/* 134 */       if (this.service == null)
/* 135 */         _initProxy();
/*     */     }
/*     */   }
/*     */ 
/*     */   public void setWsddServiceName(String wsddServiceName)
/*     */   {
/* 143 */     this.wsddServiceName = wsddServiceName;
/*     */ 
/* 145 */     if ((this.url != null) && (this.wsddServiceName != null) && (this.stubClass != null))
/*     */     {
/* 147 */       if (this.service == null)
/* 148 */         _initProxy();
/*     */     }
/*     */   }
/*     */ 
/*     */   public void setStubClass(Class stubClass)
/*     */   {
/* 155 */     this.stubClass = stubClass;
/*     */ 
/* 157 */     if ((this.url != null) && (this.wsddServiceName != null) && (stubClass != null))
/*     */     {
/* 159 */       if (this.service == null)
/* 160 */         _initProxy();
/*     */     }
/*     */   }
/*     */ }

/* Location:           D:\李慧医药项目\tcmages\krt\WEB-INF\classes\
 * Qualified Name:     org.ssi.services.ServiceProxy
 * JD-Core Version:    0.6.2
 */