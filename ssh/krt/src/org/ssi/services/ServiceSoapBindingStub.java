/*    */ package org.ssi.services;
/*    */ 
/*    */ import java.net.URL;
/*    */ import java.rmi.RemoteException;
/*    */ import java.util.Enumeration;
/*    */ import java.util.Properties;
/*    */ import java.util.Vector;
/*    */ import javax.xml.namespace.QName;
/*    */ import org.apache.axis.AxisFault;
/*    */ import org.apache.axis.client.Call;
/*    */ import org.apache.axis.client.Stub;
/*    */ import org.apache.axis.encoding.DeserializerFactory;
/*    */ import org.apache.axis.soap.SOAPConstants;
/*    */ 
/*    */ public abstract class ServiceSoapBindingStub extends Stub
/*    */   implements IDriverService
/*    */ {
/* 25 */   protected Vector cachedSerClasses = new Vector();
/*    */ 
/* 27 */   protected Vector cachedSerQNames = new Vector();
/*    */ 
/* 29 */   protected Vector cachedSerFactories = new Vector();
/*    */ 
/* 31 */   protected Vector cachedDeserFactories = new Vector();
/*    */ 
/* 33 */   protected String url = null;
/*    */ 
/*    */   public abstract Object getObject(String paramString, Object[] paramArrayOfObject)
/*    */     throws RemoteException;
/*    */ 
/*    */   public ServiceSoapBindingStub()
/*    */     throws AxisFault
/*    */   {
/* 43 */     this(null);
/*    */   }
/*    */ 
/*    */   public ServiceSoapBindingStub(URL endpointURL, Service service)
/*    */     throws AxisFault
/*    */   {
/* 54 */     this(service);
/* 55 */     this.cachedEndpoint = endpointURL;
/*    */   }
/*    */ 
/*    */   public ServiceSoapBindingStub(Service service)
/*    */     throws AxisFault
/*    */   {
/* 64 */     if (service == null) {
/* 65 */       this.service = new org.apache.axis.client.Service();
/*    */     }
/*    */     else {
/* 68 */       this.service = service;
/*    */     }
/* 70 */     this.url = (service.getUrl() != null ? service.getUrl().trim() : "");
/*    */   }
/*    */ 
/*    */   protected Call createCall() throws RemoteException
/*    */   {
/*    */     try {
/* 76 */       Call _call = super._createCall();
/* 77 */       if (this.maintainSessionSet) {
/* 78 */         _call.setMaintainSession(this.maintainSession);
/*    */       }
/* 80 */       if (this.cachedUsername != null) {
/* 81 */         _call.setUsername(this.cachedUsername);
/*    */       }
/* 83 */       if (this.cachedPassword != null) {
/* 84 */         _call.setPassword(this.cachedPassword);
/*    */       }
/* 86 */       if (this.cachedEndpoint != null) {
/* 87 */         _call.setTargetEndpointAddress(this.cachedEndpoint);
/*    */       }
/* 89 */       if (this.cachedTimeout != null) {
/* 90 */         _call.setTimeout(this.cachedTimeout);
/*    */       }
/* 92 */       if (this.cachedPortName != null) {
/* 93 */         _call.setPortName(this.cachedPortName);
/*    */       }
/* 95 */       Enumeration keys = this.cachedProperties.keys();
/* 96 */       while (keys.hasMoreElements()) {
/* 97 */         String key = (String)keys.nextElement();
/* 98 */         _call.setProperty(key, this.cachedProperties.get(key));
/*    */       }
/*    */ 
/* 105 */       synchronized (this) {
/* 106 */         if (firstCall())
/*    */         {
/* 108 */           _call
/* 109 */             .setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
/* 110 */           _call
/* 111 */             .setEncodingStyle("http://schemas.xmlsoap.org/soap/encoding/");
/* 112 */           for (int i = 0; i < this.cachedSerFactories.size(); i++) {
/* 113 */             Class cls = 
/* 114 */               (Class)this.cachedSerClasses
/* 114 */               .get(i);
/* 115 */             QName qName = 
/* 116 */               (QName)this.cachedSerQNames
/* 116 */               .get(i);
/* 117 */             Object x = this.cachedSerFactories.get(i);
/* 118 */             if ((x instanceof Class)) {
/* 119 */               Class sf = 
/* 120 */                 (Class)this.cachedSerFactories
/* 120 */                 .get(i);
/* 121 */               Class df = 
/* 122 */                 (Class)this.cachedDeserFactories
/* 122 */                 .get(i);
/* 123 */               _call
/* 124 */                 .registerTypeMapping(cls, qName, sf, df, 
/* 125 */                 false);
/* 126 */             } else if ((x instanceof javax.xml.rpc.encoding.SerializerFactory)) {
/* 127 */               org.apache.axis.encoding.SerializerFactory sf = 
/* 128 */                 (org.apache.axis.encoding.SerializerFactory)this.cachedSerFactories
/* 128 */                 .get(i);
/* 129 */               DeserializerFactory df = 
/* 130 */                 (DeserializerFactory)this.cachedDeserFactories
/* 130 */                 .get(i);
/* 131 */               _call
/* 132 */                 .registerTypeMapping(cls, qName, sf, df, 
/* 133 */                 false);
/*    */             }
/*    */           }
/*    */         }
/*    */       }
/* 138 */       return _call;
/*    */     } catch (Throwable _t) {
/* 140 */       throw new AxisFault(
/* 141 */         "Failure trying to get the Call object", _t);
/*    */     }
/*    */   }
/*    */ }

/* Location:           D:\李慧医药项目\tcmages\krt\WEB-INF\classes\
 * Qualified Name:     org.ssi.services.ServiceSoapBindingStub
 * JD-Core Version:    0.6.2
 */