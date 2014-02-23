/*     */ package cn.id5.idreal_hr.commons.log.services.impl;
/*     */ 
/*     */ import cn.id5.idreal_hr.commons.bo.log.LogBO;
/*     */ import cn.id5.idreal_hr.commons.log.dao.ILogDAO;
/*     */ import cn.id5.idreal_hr.commons.log.services.ILogServices;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.apache.commons.lang.exception.ExceptionUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import org.ssi.common.PageInfo;
/*     */ import org.ssi.services.impl.ServiceImpl;
/*     */ 
/*     */ public class LogServicesImpl extends ServiceImpl
/*     */   implements ILogServices
/*     */ {
/*     */   private ILogDAO logDAO;
/*     */ 
/*     */   public ILogDAO getLogDAO()
/*     */   {
/*  33 */     return this.logDAO;
/*     */   }
/*     */ 
/*     */   public void setLogDAO(ILogDAO logDAO)
/*     */   {
/*  45 */     this.logDAO = logDAO;
/*     */   }
/*     */ 
/*     */   public void insert(LogBO record)
/*     */   {
/*     */     try
/*     */     {
/*  56 */       this.logDAO.insert(record);
/*     */     }
/*     */     catch (Exception e) {
/*  59 */       ExceptionUtils.getFullStackTrace(e);
/*     */     }
/*     */   }
/*     */ 
/*     */   public int update(LogBO record)
/*     */   {
/*  70 */     int rows = 0;
/*     */     try {
/*  72 */       rows = this.logDAO.update(record);
/*     */     }
/*     */     catch (Exception e) {
/*  75 */       ExceptionUtils.getFullStackTrace(e);
/*     */     }
/*  77 */     return rows;
/*     */   }
/*     */ 
/*     */   public List findAll(PageInfo pageInfo)
/*     */   {
/*  87 */     this.pageInfo = pageInfo;
/*  88 */     Map map = new HashMap();
/*  89 */     List list = queryListByPage(map);
/*  90 */     return list;
/*     */   }
/*     */ 
/*     */   public List queryListByPage(Object obj)
/*     */   {
/* 100 */     this.pageInfo = this.pageInfo;
/* 101 */     Map map = new HashMap();
/*     */ 
/* 103 */     List list = null;
/*     */ 
/* 105 */     setPublicParams((Map)obj);
/* 106 */     this.logger.debug("查询第" + (this.pageInfo != null ? this.pageInfo.getPageNum() : 0) + "页数据");
/*     */ 
/* 108 */     list = this.logDAO.selectAll(obj);
/* 109 */     this.logger.debug("list.size(befor reset)=" + (list != null ? Integer.valueOf(list.size()) : ""));
/*     */ 
/* 111 */     if ((list == null) || (list.size() == 0))
/*     */     {
/* 113 */       if ((this.pageInfo != null) && (this.pageInfo.getPageNum() > 0))
/*     */       {
/* 115 */         setPublicParams((Map)obj, true);
/* 116 */         list = this.logDAO.selectAll(obj);
/* 117 */         this.logger.debug("list.size(befor reset)=" + (list != null ? Integer.valueOf(list.size()) : ""));
/*     */       }
/*     */     }
/*     */ 
/* 121 */     Object o = this.logDAO.selectAllOfCount(obj);
/* 122 */     if (o != null)
/*     */     {
/* 124 */       this.logger.debug("数据量=" + o.toString());
/* 125 */       this.pageInfo.setTotalSize(Integer.parseInt(o.toString()));
/*     */     }
/* 127 */     return list;
/*     */   }
/*     */ 
/*     */   public LogBO findById(Long logId)
/*     */   {
/* 137 */     LogBO key = new LogBO();
/* 138 */     key.setLogId(logId);
/* 139 */     LogBO record = (LogBO)this.logDAO.queryData(key);
/* 140 */     return record;
/*     */   }
/*     */ 
/*     */   public int delete(LogBO record)
/*     */   {
/* 150 */     int rows = 0;
/*     */     try {
/* 152 */       rows = this.logDAO.delete(record);
/*     */     }
/*     */     catch (Exception e) {
/* 155 */       ExceptionUtils.getFullStackTrace(e);
/*     */     }
/* 157 */     return rows;
/*     */   }
/*     */ 
/*     */   public int delete(String[] ids)
/*     */   {
/* 167 */     int rows = 0;
/* 168 */     LogBO key = new LogBO();
/*     */     try {
/* 170 */       int i = 0;
/*     */       do { key.setLogId(Long.valueOf(ids[i]));
/* 172 */         rows += this.logDAO.delete(key);
/*     */ 
/* 170 */         i++; if (ids == null) break;  } while (i < ids.length);
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 176 */       ExceptionUtils.getFullStackTrace(e);
/*     */     }
/* 178 */     return rows;
/*     */   }
/*     */ }

/* Location:           D:\李慧医药项目\tcmages\krt\WEB-INF\classes\
 * Qualified Name:     cn.id5.idreal_hr.commons.log.services.impl.LogServicesImpl
 * JD-Core Version:    0.6.2
 */