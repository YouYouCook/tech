/*     */ package org.ssi.common;
/*     */ 
/*     */ import cn.krt.zbcg.commons.bo.system.UserBO;
/*     */ import java.io.IOException;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import javax.servlet.Filter;
/*     */ import javax.servlet.FilterChain;
/*     */ import javax.servlet.FilterConfig;
/*     */ import javax.servlet.ServletException;
/*     */ import javax.servlet.ServletRequest;
/*     */ import javax.servlet.ServletResponse;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ import javax.servlet.http.HttpSession;
/*     */ 
/*     */ public class Id5Filter
/*     */   implements Filter
/*     */ {
/*  62 */   protected String encoding = null;
/*     */ 
/*  67 */   protected boolean ignore = true;
/*     */ 
/*  70 */   protected String[] fileNames = null;
/*     */ 
/*  72 */   protected String[] fileNameServlet = null;
/*     */ 
/*  74 */   protected String[] dirs = null;
/*     */ 
/*     */   public void destroy()
/*     */   {
/*  82 */     this.encoding = null;
/*     */   }
/*     */ 
/*     */   public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
/*     */     throws IOException, ServletException
/*     */   {
/* 105 */     boolean temp_boolean = true;
/*     */ 
/* 109 */     if ((request instanceof HttpServletRequest))
/*     */     {
/* 111 */       initCharset(request);
/* 112 */       HttpServletRequest httpReq = (HttpServletRequest)request;
/* 113 */       HttpServletResponse httpResp = (HttpServletResponse)response;
/*     */ 
/* 116 */       if ((ApplicationConstants.ROOT_PATH == null) || 
/* 117 */         (ApplicationConstants.ROOT_PATH.equals("")))
/*     */       {
/* 119 */         ApplicationConstants.ROOT_PATH = httpReq.getContextPath();
/*     */       }
/*     */ 
/* 123 */       if (!ApplicationConstants.CACHE_CONTROL)
/*     */       {
/* 125 */         httpResp.setHeader("Pragma", "No-cache");
/* 126 */         httpResp.setHeader("Cache-Control", "no-cache");
/* 127 */         httpResp.setDateHeader("Expires", 0L);
/*     */       }
/*     */ 
/* 132 */       String strContextPath = httpReq.getContextPath();
/*     */ 
/* 134 */       String x = httpReq.getParameter("operate");
/* 135 */       String queryString = "";
/* 136 */       if (x != null) {
/* 137 */         queryString = "?operate=" + x;
/*     */       }
/*     */ 
/* 140 */       String strRequestURIRight = httpReq.getRequestURI().substring(strContextPath.length()) + queryString;
/* 141 */       String strRequestURI = httpReq.getRequestURI().substring(strContextPath.length());
/*     */ 
/* 146 */       HttpSession session = httpReq.getSession();
/*     */ 
/* 148 */       UserBO userRight = (UserBO)session.getAttribute("Logon.User");
/*     */ 
/* 150 */       if (!strRequestURI.equalsIgnoreCase("/"))
/*     */       {
/* 156 */         boolean isFile = false;
/* 157 */         boolean isRight = false;
/* 158 */         if ((this.fileNames != null) && (this.fileNames.length > 0))
/*     */         {
/* 160 */           for (int i = 0; i < this.fileNames.length; i++)
/*     */           {
/* 162 */             if ((this.fileNames[i] != null) && (strRequestURIRight.equalsIgnoreCase(this.fileNames[i].trim())))
/*     */             {
/* 164 */               isFile = true;
/* 165 */               break;
/*     */             }
/*     */           }
/*     */         }
/*     */ 
/* 170 */         if ((userRight != null) && ("1".equals(userRight.getLoginRole()))) {
/* 171 */           isRight = true;
/*     */         }
/* 173 */         else if ((userRight != null) && ("2".equals(userRight.getLoginRole()))) {
/* 174 */           if ((strRequestURIRight.equalsIgnoreCase("/MedicineCgAction.do?operate=list")) || 
/* 175 */             (strRequestURIRight.equalsIgnoreCase("/MedicineCgAction.do?operate=getTops")) || 
/* 176 */             (strRequestURIRight.equalsIgnoreCase("/MedicineZbAction.do?operate=resultForCg")))
/*     */           {
/* 179 */             isRight = true;
/*     */           }
/*     */         }
/* 182 */         else if ((userRight != null) && ("3".equals(userRight.getLoginRole())))
/*     */         {
/* 184 */           if ((strRequestURIRight.equalsIgnoreCase("/MedicineJbAction.do?operate=list")) || 
/* 185 */             (strRequestURIRight.equalsIgnoreCase("/MedicineZbAction.do?operate=resultForSuppliers")))
/*     */           {
/* 187 */             isRight = true;
/*     */           }
/* 189 */         } else if ((userRight != null) && ("4".equals(userRight.getLoginRole())) && 
/* 190 */           (strRequestURIRight.equalsIgnoreCase("/MedicineZbAction.do?operate=list"))) {
/* 191 */           isRight = true;
/*     */         }
/* 193 */         if ((userRight == null) && (!isRight) && (!isFile)) {
/* 194 */           temp_boolean = false;
/*     */ 
/* 196 */           httpResp.sendRedirect(strContextPath + ApplicationConstants.PAGE_INVALIDLOGIN);
/*     */         }
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 202 */     if (temp_boolean)
/*     */     {
/* 205 */       if ("true".equals(request.getParameter("ajax_login")))
/*     */       {
/* 209 */         chain.doFilter(request, response);
/*     */       }
/* 211 */       else if ((request.getParameter("ajax") == null) || (!"true".equals(request.getParameter("ajax"))))
/*     */       {
/* 215 */         chain.doFilter(request, response);
/*     */       }
/*     */       else
/*     */       {
/* 219 */         request.setCharacterEncoding("GBK");
/*     */ 
/* 221 */         chain.doFilter(request, response);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public void initCharset(ServletRequest request)
/*     */     throws UnsupportedEncodingException
/*     */   {
/* 229 */     if ((this.ignore) || (request.getCharacterEncoding() == null))
/*     */     {
/* 231 */       String encoding = selectEncoding(request);
/* 232 */       if (encoding != null)
/* 233 */         request.setCharacterEncoding(encoding);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void init(FilterConfig filterConfig)
/*     */     throws ServletException
/*     */   {
/* 245 */     this.encoding = filterConfig.getInitParameter("encoding");
/* 246 */     String value = filterConfig.getInitParameter("ignore");
/* 247 */     if (value == null)
/* 248 */       this.ignore = true;
/* 249 */     else if (value.equalsIgnoreCase("true"))
/* 250 */       this.ignore = true;
/* 251 */     else if (value.equalsIgnoreCase("yes"))
/* 252 */       this.ignore = true;
/*     */     else {
/* 254 */       this.ignore = false;
/*     */     }
/* 256 */     String str1 = filterConfig.getInitParameter("fileNames");
/* 257 */     if ((str1 != null) && (!"".equals(str1)))
/*     */     {
/* 259 */       this.fileNames = str1.split(",");
/*     */     }
/* 261 */     str1 = filterConfig.getInitParameter("fileNameServlet");
/* 262 */     if ((str1 != null) && (!"".equals(str1)))
/*     */     {
/* 264 */       this.fileNameServlet = str1.split(",");
/*     */     }
/*     */   }
/*     */ 
/*     */   protected String selectEncoding(ServletRequest request)
/*     */   {
/* 284 */     return this.encoding;
/*     */   }
/*     */ }

/* Location:           D:\李慧医药项目\tcmages\krt\WEB-INF\classes\
 * Qualified Name:     org.ssi.common.Id5Filter
 * JD-Core Version:    0.6.2
 */