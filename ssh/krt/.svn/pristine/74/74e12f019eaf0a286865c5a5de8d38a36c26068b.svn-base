/*     */ package cn.krt.zbcg.system.services.impl;
/*     */ 
/*     */ import cn.krt.zbcg.commons.bo.system.NoticeBO;
/*     */ import cn.krt.zbcg.system.dao.INoticeDAO;
/*     */ import cn.krt.zbcg.system.services.INoticeServices;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.apache.commons.lang.exception.ExceptionUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import org.ssi.common.PageInfo;
/*     */ import org.ssi.services.impl.ServiceImpl;
/*     */ 
/*     */ public class NoticeServicesImpl extends ServiceImpl
/*     */   implements INoticeServices
/*     */ {
/*     */   private INoticeDAO ceDAO;
/*     */ 
/*     */   public INoticeDAO getCeDAO()
/*     */   {
/*  31 */     return this.ceDAO;
/*     */   }
/*     */ 
/*     */   public void setCeDAO(INoticeDAO ceDAO)
/*     */   {
/*  43 */     this.ceDAO = ceDAO;
/*     */   }
/*     */ 
/*     */   public void insert(NoticeBO record)
/*     */   {
/*     */     try
/*     */     {
/*  54 */       this.ceDAO.insert(record);
/*     */     }
/*     */     catch (Exception e) {
/*  57 */       ExceptionUtils.getFullStackTrace(e);
/*     */     }
/*     */   }
/*     */ 
/*     */   public int update(NoticeBO record)
/*     */   {
/*  68 */     int rows = 0;
/*     */     try {
/*  70 */       rows = this.ceDAO.update(record);
/*     */     }
/*     */     catch (Exception e) {
/*  73 */       ExceptionUtils.getFullStackTrace(e);
/*     */     }
/*  75 */     return rows;
/*     */   }
/*     */   public NoticeBO findNotice() {
/*  78 */     NoticeBO bo = this.ceDAO.findNotice();
/*  79 */     return bo;
/*     */   }
/*     */ 
/*     */   public List findAll(PageInfo pageInfo)
/*     */   {
/*  88 */     this.pageInfo = pageInfo;
/*  89 */     Map map = new HashMap();
/*  90 */     List list = findAll(pageInfo, map);
/*  91 */     return list;
/*     */   }
/*     */ 
/*     */   public List findAll(PageInfo pageInfo, Map map)
/*     */   {
/* 101 */     this.pageInfo = pageInfo;
/* 102 */     List list = queryListByPage(map);
/* 103 */     return list;
/*     */   }
/*     */ 
/*     */   public List queryListByPage(Object obj)
/*     */   {
/* 113 */     this.pageInfo = this.pageInfo;
/* 114 */     Map map = new HashMap();
/*     */ 
/* 116 */     List list = null;
/*     */ 
/* 118 */     setPublicParams((Map)obj);
/* 119 */     this.logger.debug("��ѯ��" + (this.pageInfo != null ? this.pageInfo.getPageNum() : 0) + "ҳ���");
/*     */ 
/* 121 */     list = this.ceDAO.selectAll(obj);
/* 122 */     this.logger.debug("list.size(befor reset)=" + (list != null ? Integer.valueOf(list.size()) : ""));
/*     */ 
/* 124 */     if ((list == null) || (list.size() == 0))
/*     */     {
/* 126 */       if ((this.pageInfo != null) && (this.pageInfo.getPageNum() > 0))
/*     */       {
/* 128 */         setPublicParams((Map)obj, true);
/* 129 */         list = this.ceDAO.selectAll(obj);
/* 130 */         this.logger.debug("list.size(befor reset)=" + (list != null ? Integer.valueOf(list.size()) : ""));
/*     */       }
/*     */     }
/*     */ 
/* 134 */     Object o = this.ceDAO.selectAllOfCount(obj);
/* 135 */     if (o != null)
/*     */     {
/* 137 */       this.logger.debug("���=" + o.toString());
/* 138 */       this.pageInfo.setTotalSize(Integer.parseInt(o.toString()));
/*     */     }
/* 140 */     return list;
/*     */   }
/*     */ 
/*     */   public NoticeBO findById(Integer id)
/*     */   {
/* 150 */     NoticeBO key = new NoticeBO();
/* 151 */     key.setId(id);
/* 152 */     NoticeBO record = (NoticeBO)this.ceDAO.queryData(key);
/* 153 */     return record;
/*     */   }
/*     */ 
/*     */   public int delete(NoticeBO record)
/*     */   {
/* 163 */     int rows = 0;
/*     */     try {
/* 165 */       rows = this.ceDAO.delete(record);
/*     */     }
/*     */     catch (Exception e) {
/* 168 */       ExceptionUtils.getFullStackTrace(e);
/*     */     }
/* 170 */     return rows;
/*     */   }
/*     */ 
/*     */   public int delete(String[] ids)
/*     */   {
/* 180 */     int rows = 0;
/* 181 */     NoticeBO key = new NoticeBO();
/*     */     try {
/* 183 */       int i = 0;
/*     */       do { key.setId(Integer.valueOf(ids[i]));
/* 185 */         rows += this.ceDAO.delete(key);
/*     */ 
/* 183 */         i++; if (ids == null) break;  } while (i < ids.length);
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 189 */       ExceptionUtils.getFullStackTrace(e);
/*     */     }
/* 191 */     return rows;
/*     */   }
/*     */ }

/* Location:           D:\李慧医药项目\tcmages\krt\WEB-INF\classes\
 * Qualified Name:     cn.krt.zbcg.system.services.impl.NoticeServicesImpl
 * JD-Core Version:    0.6.2
 */