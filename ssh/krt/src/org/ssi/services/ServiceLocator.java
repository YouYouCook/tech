/*     */ package org.ssi.services;
/*     */ 
/*     */ import java.lang.reflect.Constructor;
/*     */ import java.lang.reflect.InvocationTargetException;
/*     */ import java.net.MalformedURLException;
/*     */ import java.net.URL;
/*     */ import java.rmi.Remote;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import javax.xml.namespace.QName;
/*     */ import javax.xml.rpc.ServiceException;
/*     */ import org.apache.axis.EngineConfiguration;
/*     */ import org.apache.axis.client.Stub;
/*     */ 
/*     */ public class ServiceLocator extends org.apache.axis.client.Service
/*     */   implements Service
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*  47 */   private String url = null;
/*  48 */   private Class stubClass = null;
/*     */ 
/*  68 */   private String wsddServiceName = null;
/*     */ 
/* 211 */   private HashSet ports = null;
/*     */ 
/*     */   public ServiceLocator()
/*     */   {
/*     */   }
/*     */ 
/*     */   public ServiceLocator(EngineConfiguration config)
/*     */   {
/*  39 */     super(config);
/*     */   }
/*     */ 
/*     */   public ServiceLocator(String wsdlLoc, QName sName) throws ServiceException {
/*  43 */     super(wsdlLoc, sName);
/*     */   }
/*     */ 
/*     */   public Class getStubClass()
/*     */   {
/*  53 */     return this.stubClass;
/*     */   }
/*     */ 
/*     */   public void setStubClass(Class stubClass)
/*     */   {
/*  60 */     this.stubClass = stubClass;
/*     */   }
/*     */ 
/*     */   public String getUrl() {
/*  64 */     return this.url;
/*     */   }
/*     */ 
/*     */   public String getWsddServiceName()
/*     */   {
/*  71 */     return this.wsddServiceName;
/*     */   }
/*     */ 
/*     */   public void setWsddServiceName(String name) {
/*  75 */     this.wsddServiceName = name;
/*     */   }
/*     */ 
/*     */   public IDriverService getService() throws ServiceException
/*     */   {
/*     */     URL endpoint = null;
				try
/*     */     {
/*  82 */       endpoint = new URL(this.url);
/*     */     }
/*     */     catch (MalformedURLException e)
/*     */     {
/*  84 */       throw new ServiceException(e);
/*     */     }
/*     */     
/*  86 */     return getService(endpoint);
/*     */   }
/*     */ 
/*     */   public IDriverService getService(URL portAddress)
/*     */     throws ServiceException
/*     */   {
/*  92 */     Constructor c = null;
/*  93 */     ServiceSoapBindingStub _stub = null;
/*     */     try {
/*  95 */       c = this.stubClass.getConstructor(new Class[] { URL.class, Service.class });
/*  96 */       Object o = (ServiceSoapBindingStub)c.newInstance(new Object[] { portAddress, this });
/*  97 */       _stub = (ServiceSoapBindingStub)o;
/*  98 */       _stub.setPortName(getWsddServiceName());
/*     */     }
/*     */     catch (SecurityException e) {
/* 101 */       e.printStackTrace();
/*     */     }
/*     */     catch (NoSuchMethodException e) {
/* 104 */       e.printStackTrace();
/*     */     }
/*     */     catch (IllegalArgumentException e) {
/* 107 */       e.printStackTrace();
/*     */     }
/*     */     catch (InstantiationException e) {
/* 110 */       e.printStackTrace();
/*     */     }
/*     */     catch (IllegalAccessException e) {
/* 113 */       e.printStackTrace();
/*     */     }
/*     */     catch (InvocationTargetException e) {
/* 116 */       e.printStackTrace();
/*     */     }
/*     */ 
/* 120 */     return _stub;
/*     */   }
/*     */ 
/*     */   public void setUrl(String url)
/*     */   {
/* 129 */     this.url = url;
/*     */   }
/*     */ 
/*     */   public Remote getPort(Class serviceEndpointInterface)
/*     */     throws ServiceException
/*     */   {
/*     */     try
/*     */     {
/* 140 */       if (IDriverService.class.isAssignableFrom(serviceEndpointInterface))
/*     */       {
/* 142 */         Constructor c = null;
/* 143 */         ServiceSoapBindingStub _stub = null;
/*     */         try {
/* 145 */           c = this.stubClass.getConstructor(new Class[] { URL.class, Service.class });
/* 146 */           _stub = (ServiceSoapBindingStub)c.newInstance(new Object[] { new URL(this.url), this });
/* 147 */           _stub.setPortName(getWsddServiceName());
/*     */         }
/*     */         catch (SecurityException e) {
/* 150 */           e.printStackTrace();
/*     */         }
/*     */         catch (NoSuchMethodException e) {
/* 153 */           e.printStackTrace();
/*     */         }
/*     */         catch (IllegalArgumentException e) {
/* 156 */           e.printStackTrace();
/*     */         }
/*     */         catch (InstantiationException e) {
/* 159 */           e.printStackTrace();
/*     */         }
/*     */         catch (IllegalAccessException e) {
/* 162 */           e.printStackTrace();
/*     */         }
/*     */         catch (InvocationTargetException e) {
/* 165 */           e.printStackTrace();
/*     */         }
/*     */ 
/* 168 */         return _stub;
/*     */       }
/*     */     } catch (Throwable t) {
/* 171 */       throw new ServiceException(t);
/*     */     }
/* 173 */     throw new ServiceException(
/* 174 */       "There is no stub implementation for the interface:  " + (
/* 175 */       serviceEndpointInterface == null ? "null" : 
/* 176 */       serviceEndpointInterface.getName()));
/*     */   }
/*     */ 
/*     */   public Remote getPort(QName portName, Class serviceEndpointInterface)
/*     */     throws ServiceException
/*     */   {
/* 186 */     if (portName == null) {
/* 187 */       return getPort(serviceEndpointInterface);
/*     */     }
/* 189 */     String inputPortName = portName.getLocalPart();
/* 190 */     if (this.wsddServiceName.equals(inputPortName)) {
/* 191 */       return getService();
/*     */     }
/* 193 */     Remote _stub = getPort(serviceEndpointInterface);
/* 194 */     ((Stub)_stub).setPortName(portName);
/* 195 */     return _stub;
/*     */   }
/*     */ 
/*     */   public QName getServiceName()
/*     */   {
/* 204 */     return new QName(
/* 205 */       this.url, 
/* 206 */       this.wsddServiceName + "Service");
/*     */   }
/*     */ 
/*     */   public Iterator getPorts()
/*     */   {
/* 217 */     if (this.ports == null) {
/* 218 */       this.ports = new HashSet();
/* 219 */       this.ports
/* 220 */         .add(new QName(
/* 221 */         this.url, 
/* 222 */         this.wsddServiceName));
/*     */     }
/*     */ 
/* 225 */     return this.ports.iterator();
/*     */   }
/*     */ 
/*     */   public void setEndpointAddress(String portName, String address)
/*     */     throws ServiceException
/*     */   {
/* 234 */     if (this.wsddServiceName.equals(portName))
/* 235 */       setUrl(address);
/*     */     else
/* 237 */       throw new ServiceException(
/* 238 */         " Cannot set Endpoint Address for Unknown Port" + portName);
/*     */   }
/*     */ 
/*     */   public void setEndpointAddress(QName portName, String address)
/*     */     throws ServiceException
/*     */   {
/* 247 */     setEndpointAddress(portName.getLocalPart(), address);
/*     */   }
/*     */ }

/* Location:           D:\李慧医药项目\tcmages\krt\WEB-INF\classes\
 * Qualified Name:     org.ssi.services.ServiceLocator
 * JD-Core Version:    0.6.2
 */