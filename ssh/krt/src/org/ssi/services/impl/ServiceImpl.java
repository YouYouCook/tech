/*     */ package org.ssi.services.impl;
/*     */ 
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import org.apache.log4j.Logger;
/*     */ import org.ssi.common.PageInfo;
/*     */ import org.ssi.dao.IBaseDao;
/*     */ import org.ssi.services.IService;
/*     */ 
/*     */ public abstract class ServiceImpl
/*     */   implements IService
/*     */ {
/*  22 */   protected Logger logger = Logger.getLogger(getClass());
/*     */ 
/*  24 */   protected IBaseDao baseDao = null;
/*  25 */   protected HttpServletRequest request = null;
/*     */ 
/*  29 */   protected PageInfo pageInfo = null;
/*     */ 
/*     */   public PageInfo getPageInfo()
/*     */   {
/*  37 */     return this.pageInfo;
/*     */   }
/*     */ 
/*     */   public void setPageInfo(PageInfo pageInfo)
/*     */   {
/*  45 */     this.pageInfo = pageInfo;
/*     */   }
/*     */ 
/*     */   public IBaseDao getBaseDao()
/*     */   {
/*  53 */     return this.baseDao;
/*     */   }
/*     */ 
/*     */   public void setBaseDao(IBaseDao baseDao)
/*     */   {
/*  60 */     this.baseDao = baseDao;
/*     */   }
/*     */ 
/*     */   public void a_insert(String id, Object bean)
/*     */     throws Exception
/*     */   {
/*     */     try
/*     */     {
/*  70 */       this.logger.debug("添加对象：" + bean.getClass().getName());
/*  71 */       this.baseDao.insert(id, bean);
/*     */     } catch (Exception e) {
/*  73 */       this.logger.warn(e.getMessage());
/*  74 */       throw e;
/*     */     }
/*     */   }
/*     */ 
/*     */   public int a_update(String id, Object bean)
/*     */     throws Exception
/*     */   {
/*  85 */     int rows = 0;
/*     */     try {
/*  87 */       this.logger.debug("删除对象：" + bean.getClass().getName());
/*  88 */       rows = this.baseDao.update(id, bean);
/*  89 */       this.logger.debug("成功修改" + rows + "条对象");
/*     */     } catch (Exception e) {
/*  91 */       rows = 0;
/*  92 */       this.logger.warn(e.getMessage());
/*  93 */       throw e;
/*     */     }
/*  95 */     return rows;
/*     */   }
/*     */ 
/*     */   public int a_delete(String id, Object bean)
/*     */     throws Exception
/*     */   {
/* 106 */     int rows = 0;
/*     */     try {
/* 108 */       this.logger.debug("删除对象：" + bean.getClass().getName());
/* 109 */       rows = this.baseDao.delete(id, bean);
/* 110 */       this.logger.debug("成功删除" + rows + "条对象");
/*     */     } catch (Exception e) {
/* 112 */       rows = 0;
/* 113 */       this.logger.warn(e.getMessage());
/* 114 */       throw e;
/*     */     }
/* 116 */     return rows;
/*     */   }
/*     */ 
/*     */   public Object queryData(String id, Object bean)
/*     */   {
/* 126 */     return this.baseDao.queryData(id, bean);
/*     */   }
/*     */ 
/*     */   public List queryListByPage(String id, Object obj)
/*     */   {
/* 138 */     List list = null;
/*     */ 
/* 140 */     setPublicParams((Map)obj);
/* 141 */     this.logger.debug("查询第" + (this.pageInfo != null ? this.pageInfo.getPageNum() : 0) + "页数据");
/*     */ 
/* 143 */     list = queryList(id, obj);
/* 144 */     this.logger.debug("list.size(befor reset)=" + (list != null ? Integer.valueOf(list.size()) : ""));
/*     */ 
/* 146 */     if ((list == null) || (list.size() == 0))
/*     */     {
/* 148 */       if ((this.pageInfo != null) && (this.pageInfo.getPageNum() > 0))
/*     */       {
/* 150 */         setPublicParams((Map)obj, true);
/* 151 */         list = queryList(id, obj);
/* 152 */         this.logger.debug("list.size(befor reset)=" + (list != null ? Integer.valueOf(list.size()) : ""));
/*     */       }
/*     */     }
/*     */ 
/* 156 */     Object o = queryData(id + "OfCount", obj);
/* 157 */     if (o != null)
/*     */     {
/* 159 */       this.logger.debug("数据量=" + o.toString());
/* 160 */       this.pageInfo.setTotalSize(Integer.parseInt(o.toString()));
/*     */     }
/* 162 */     return list;
/*     */   }
/*     */ 
/*     */   public List queryList(String id, Object obj)
/*     */   {
/* 171 */     return this.baseDao.queryList(id, obj);
/*     */   }
/*     */ 
/*     */   public void setRequest(HttpServletRequest request)
/*     */   {
/* 178 */     this.request = request;
/*     */   }
/*     */ 
/*     */   protected void setPublicParams(Map map)
/*     */   {
/* 188 */     setPublicParams(map, false);
/*     */   }
/*     */ 
/*     */   protected void setPublicParams(Map map, boolean isFirst)
/*     */   {
/*     */     try
/*     */     {
/* 200 */       if ((map != null) && (this.pageInfo != null) && (this.request != null))
/*     */       {
/* 202 */         Object session_operate = this.request.getSession().getAttribute("session_operate");
/* 203 */         Object session_requestURI = this.request.getSession().getAttribute("session_requestURI");
/* 204 */         String request_operate = this.request.getParameter("operate");
/* 205 */         this.request.getSession().setAttribute("session_operate", request_operate);
/* 206 */         String strContextPath = this.request.getContextPath();
/* 207 */         String strRequestURI = this.request.getRequestURI().substring(
/* 208 */           strContextPath.length());
/* 209 */         this.request.getSession().setAttribute("session_requestURI", strRequestURI);
/* 210 */         if ((session_operate != null) && (!"".equals(session_operate.toString())) && (request_operate != null) && (!"".equals(request_operate)))
/*     */         {
/* 212 */           if ((!strRequestURI.equals(session_requestURI.toString())) && (this.pageInfo.isValidPage()))
/*     */           {
/* 214 */             this.pageInfo.setPageNum(1);
/* 215 */             this.pageInfo.setPageSize(10);
/*     */           }
/* 224 */           else if (this.pageInfo.isValidPage())
/*     */           {
/* 227 */             if ((this.request.getParameter("pageNum") != null) && (!"".equals(this.request.getParameter("pageNum").trim())))
/*     */             {
/* 229 */               this.pageInfo.setPageNum(Integer.parseInt(this.request.getParameter("pageNum").trim()));
/*     */             }
/*     */ 
/* 232 */             if ((this.request.getParameter("pageSize") != null) && (!"".equals(this.request.getParameter("pageSize").trim())))
/*     */             {
/* 234 */               this.pageInfo.setPageSize(Integer.parseInt(this.request.getParameter("pageSize").trim()));
/*     */             }
/*     */           }
/*     */         }
/* 238 */         else if (this.pageInfo.isValidPage())
/*     */         {
/* 241 */           if ((this.request.getParameter("pageNum") != null) && (!"".equals(this.request.getParameter("pageNum").trim())))
/*     */           {
/* 243 */             this.pageInfo.setPageNum(Integer.parseInt(this.request.getParameter("pageNum").trim()));
/*     */           }
/*     */ 
/* 246 */           if ((this.request.getParameter("pageSize") != null) && (!"".equals(this.request.getParameter("pageSize").trim())))
/*     */           {
/* 248 */             this.pageInfo.setPageSize(Integer.parseInt(this.request.getParameter("pageSize").trim()));
/*     */           }
/*     */         }
/*     */ 
/* 252 */         if ((this.request.getParameter("startDate") != null) && (!"".equals(this.request.getParameter("startDate").trim())))
/*     */         {
/* 254 */           this.pageInfo.setStartDate(this.request.getParameter("startDate").trim());
/*     */         }
/*     */ 
/* 257 */         if ((this.request.getParameter("endDate") != null) && (!"".equals(this.request.getParameter("endDate").trim())))
/*     */         {
/* 259 */           this.pageInfo.setEndDate(this.request.getParameter("endDate").trim());
/*     */         }
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/* 264 */       e.printStackTrace();
/*     */     }
/*     */ 
/* 267 */     if ((map != null) && (this.pageInfo != null))
/*     */     {
/* 270 */       if (isFirst)
/*     */       {
/* 273 */         this.pageInfo.setPageNum(1);
/* 274 */         this.pageInfo.setPageSize(10);
/*     */ 
/* 276 */         map.put("ibegin", Integer.valueOf((this.pageInfo.getPageNum() - 1) * this.pageInfo.getPageSize()));
/*     */ 
/* 278 */         map.put("iend", Integer.valueOf(this.pageInfo.getPageNum() * this.pageInfo.getPageSize()));
/*     */       }
/*     */       else
/*     */       {
/* 283 */         map.put("ibegin", Integer.valueOf((this.pageInfo.getPageNum() - 1) * this.pageInfo.getPageSize()));
/*     */ 
/* 285 */         map.put("iend", Integer.valueOf(this.pageInfo.getPageNum() * this.pageInfo.getPageSize()));
/*     */       }
/*     */ 
/* 289 */       if ((this.pageInfo.getStartDate() != null) && (!"".equals(this.pageInfo.getStartDate().trim())))
/*     */       {
/* 291 */         map.put("startDate", this.pageInfo.getStartDate().trim());
/*     */       }
/*     */ 
/* 294 */       if ((this.pageInfo.getEndDate() != null) && (!"".equals(this.pageInfo.getEndDate().trim())))
/*     */       {
/* 296 */         map.put("endDate", this.pageInfo.getEndDate().trim());
/*     */       }
/*     */     }
/*     */   }
/*     */ }

/* Location:           D:\李慧医药项目\tcmages\krt\WEB-INF\classes\
 * Qualified Name:     org.ssi.services.impl.ServiceImpl
 * JD-Core Version:    0.6.2
 */