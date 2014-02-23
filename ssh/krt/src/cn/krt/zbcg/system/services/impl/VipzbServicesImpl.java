/*     */ package cn.krt.zbcg.system.services.impl;
/*     */ 
/*     */ import cn.krt.zbcg.commons.bo.system.VipzbBO;
/*     */ import cn.krt.zbcg.system.dao.IVipzbDAO;
/*     */ import cn.krt.zbcg.system.services.IVipzbServices;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.apache.commons.lang.exception.ExceptionUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import org.ssi.common.PageInfo;
/*     */ import org.ssi.services.impl.ServiceImpl;
/*     */ 
/*     */ public class VipzbServicesImpl extends ServiceImpl
/*     */   implements IVipzbServices
/*     */ {
/*     */   private IVipzbDAO zbDAO;
/*     */ 
/*     */   public IVipzbDAO getZbDAO()
/*     */   {
/*  31 */     return this.zbDAO;
/*     */   }
/*     */ 
/*     */   public void setZbDAO(IVipzbDAO zbDAO)
/*     */   {
/*  43 */     this.zbDAO = zbDAO;
/*     */   }
/*     */ 
/*     */   public void insert(VipzbBO record)
/*     */   {
/*     */     try
/*     */     {
/*  54 */       this.zbDAO.insert(record);
/*     */     }
/*     */     catch (Exception e) {
/*  57 */       ExceptionUtils.getFullStackTrace(e);
/*     */     }
/*     */   }
/*     */ 
/*     */   public int update(VipzbBO record)
/*     */   {
/*  68 */     int rows = 0;
/*     */     try {
/*  70 */       rows = this.zbDAO.update(record);
/*     */     }
/*     */     catch (Exception e) {
/*  73 */       e.printStackTrace();
/*     */     }
/*  75 */     return rows;
/*     */   }
/*     */ 
/*     */   public List findAll(PageInfo pageInfo)
/*     */   {
/*  85 */     this.pageInfo = pageInfo;
/*  86 */     Map map = new HashMap();
/*  87 */     List list = findAll(pageInfo, map);
/*  88 */     return list;
/*     */   }
/*     */ 
/*     */   public List findAll(PageInfo pageInfo, Map map)
/*     */   {
/*  98 */     this.pageInfo = pageInfo;
/*  99 */     List list = queryListByPage(map);
/* 100 */     return list;
/*     */   }
/*     */ 
/*     */   public List queryListByPage(Object obj)
/*     */   {
/* 110 */     this.pageInfo = this.pageInfo;
/* 111 */     Map map = new HashMap();
/*     */ 
/* 113 */     List list = null;
/*     */ 
/* 115 */     setPublicParams((Map)obj);
/* 116 */     this.logger.debug("��ѯ��" + (this.pageInfo != null ? this.pageInfo.getPageNum() : 0) + "ҳ���");
/*     */ 
/* 118 */     list = this.zbDAO.selectAll(obj);
/* 119 */     this.logger.debug("list.size(befor reset)=" + (list != null ? Integer.valueOf(list.size()) : ""));
/*     */ 
/* 121 */     if ((list == null) || (list.size() == 0))
/*     */     {
/* 123 */       if ((this.pageInfo != null) && (this.pageInfo.getPageNum() > 0))
/*     */       {
/* 125 */         setPublicParams((Map)obj, true);
/* 126 */         list = this.zbDAO.selectAll(obj);
/* 127 */         this.logger.debug("list.size(befor reset)=" + (list != null ? Integer.valueOf(list.size()) : ""));
/*     */       }
/*     */     }
/*     */ 
/* 131 */     Object o = this.zbDAO.selectAllOfCount(obj);
/* 132 */     if (o != null)
/*     */     {
/* 134 */       this.logger.debug("���=" + o.toString());
/* 135 */       this.pageInfo.setTotalSize(Integer.parseInt(o.toString()));
/*     */     }
/* 137 */     return list;
/*     */   }
/*     */ 
/*     */   public VipzbBO findById(Integer vipzbId)
/*     */   {
/* 147 */     VipzbBO key = new VipzbBO();
/* 148 */     key.setVipzbId(vipzbId);
/* 149 */     VipzbBO record = (VipzbBO)this.zbDAO.queryData(key);
/* 150 */     return record;
/*     */   }
/*     */ 
/*     */   public int delete(VipzbBO record)
/*     */   {
/* 160 */     int rows = 0;
/*     */     try {
/* 162 */       rows = this.zbDAO.delete(record);
/*     */     }
/*     */     catch (Exception e) {
/* 165 */       ExceptionUtils.getFullStackTrace(e);
/*     */     }
/* 167 */     return rows;
/*     */   }
/*     */ 
/*     */   public int delete(String[] ids)
/*     */   {
/* 177 */     int rows = 0;
/* 178 */     VipzbBO key = new VipzbBO();
/*     */     try {
/* 180 */       int i = 0;
/*     */       do { key.setVipzbId(Integer.valueOf(ids[i]));
/* 182 */         rows += this.zbDAO.delete(key);
/*     */ 
/* 180 */         i++; if (ids == null) break;  } while (i < ids.length);
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 186 */       ExceptionUtils.getFullStackTrace(e);
/*     */     }
/* 188 */     return rows;
/*     */   }
/*     */   public List findZbCustomer(Map record) {
/* 191 */     List a = this.zbDAO.findZbCustomer(record);
/* 192 */     return a;
/*     */   }
/*     */ 
/*     */   public VipzbBO findByMc(VipzbBO record) {
/* 196 */     VipzbBO a = this.zbDAO.findByMc(record);
/* 197 */     return a;
/*     */   }
/*     */   public int updateOne(VipzbBO record) {
/* 200 */     int rows = 0;
/*     */     try {
/* 202 */       rows = this.zbDAO.updateOne(record);
/*     */     }
/*     */     catch (Exception e) {
/* 205 */       ExceptionUtils.getFullStackTrace(e);
/*     */     }
/* 207 */     return rows;
/*     */   }
/*     */ }

/* Location:           D:\李慧医药项目\tcmages\krt\WEB-INF\classes\
 * Qualified Name:     cn.krt.zbcg.system.services.impl.VipzbServicesImpl
 * JD-Core Version:    0.6.2
 */