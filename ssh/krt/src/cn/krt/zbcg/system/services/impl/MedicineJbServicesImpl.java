/*     */ package cn.krt.zbcg.system.services.impl;
/*     */ 
/*     */ import cn.krt.zbcg.commons.bo.system.MedicineJbBO;
/*     */ import cn.krt.zbcg.system.dao.IMedicineJbDAO;
/*     */ import cn.krt.zbcg.system.services.IMedicineJbServices;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.apache.commons.lang.exception.ExceptionUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import org.ssi.common.PageInfo;
/*     */ import org.ssi.services.impl.ServiceImpl;
/*     */ 
/*     */ public class MedicineJbServicesImpl extends ServiceImpl
/*     */   implements IMedicineJbServices
/*     */ {
/*     */   private IMedicineJbDAO cineJbDAO;
/*     */ 
/*     */   public IMedicineJbDAO getCineJbDAO()
/*     */   {
/*  31 */     return this.cineJbDAO;
/*     */   }
/*     */ 
/*     */   public void setCineJbDAO(IMedicineJbDAO cineJbDAO)
/*     */   {
/*  43 */     this.cineJbDAO = cineJbDAO;
/*     */   }
/*     */ 
/*     */   public void insert(MedicineJbBO record)
/*     */   {
/*     */     try
/*     */     {
/*  54 */       this.cineJbDAO.insert(record);
/*     */     }
/*     */     catch (Exception e) {
/*  57 */       ExceptionUtils.getFullStackTrace(e);
/*     */     }
/*     */   }
/*     */ 
/*     */   public int update(MedicineJbBO record)
/*     */   {
/*  68 */     int rows = 0;
/*     */     try {
/*  70 */       rows = this.cineJbDAO.update(record);
/*     */     }
/*     */     catch (Exception e) {
/*  73 */       ExceptionUtils.getFullStackTrace(e);
/*     */     }
/*  75 */     return rows;
/*     */   }
/*     */ 
/*     */   public List findAll(PageInfo pageInfo)
/*     */     throws Exception
/*     */   {
/*  86 */     this.pageInfo = pageInfo;
/*  87 */     Map map = new HashMap();
/*  88 */     List list = findAll(pageInfo, map);
/*  89 */     return list;
/*     */   }
/*     */ 
/*     */   public List findAll(PageInfo pageInfo, Map map)
/*     */     throws Exception
/*     */   {
/* 100 */     this.cineJbDAO.insertPrepare((String)map.get("customerAccount"));
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
/* 121 */     list = this.cineJbDAO.selectAll(obj);
/* 122 */     this.logger.debug("list.size(befor reset)=" + (list != null ? Integer.valueOf(list.size()) : ""));
/*     */ 
/* 124 */     if ((list == null) || (list.size() == 0))
/*     */     {
/* 126 */       if ((this.pageInfo != null) && (this.pageInfo.getPageNum() > 0))
/*     */       {
/* 128 */         setPublicParams((Map)obj, true);
/* 129 */         list = this.cineJbDAO.selectAll(obj);
/* 130 */         this.logger.debug("list.size(befor reset)=" + (list != null ? Integer.valueOf(list.size()) : ""));
/*     */       }
/*     */     }
/*     */ 
/* 134 */     Object o = this.cineJbDAO.selectAllOfCount(obj);
/* 135 */     if (o != null)
/*     */     {
/* 137 */       this.logger.debug("���=" + o.toString());
/* 138 */       this.pageInfo.setTotalSize(Integer.parseInt(o.toString()));
/*     */     }
/* 140 */     return list;
/*     */   }
/*     */ 
/*     */   public MedicineJbBO findById(Integer jbId)
/*     */   {
/* 150 */     MedicineJbBO key = new MedicineJbBO();
/* 151 */     key.setJbId(jbId);
/* 152 */     MedicineJbBO record = (MedicineJbBO)this.cineJbDAO.queryData(key);
/* 153 */     return record;
/*     */   }
/*     */   public MedicineJbBO judeJB(MedicineJbBO record) {
/* 156 */     MedicineJbBO jbBO = this.cineJbDAO.judeJB(record);
/* 157 */     return jbBO;
/*     */   }
/*     */ 
/*     */   public int delete(MedicineJbBO record)
/*     */   {
/* 166 */     int rows = 0;
/*     */     try {
/* 168 */       rows = this.cineJbDAO.delete(record);
/*     */     }
/*     */     catch (Exception e) {
/* 171 */       ExceptionUtils.getFullStackTrace(e);
/*     */     }
/* 173 */     return rows;
/*     */   }
/*     */ 
/*     */   public int delete(String[] ids)
/*     */   {
/* 183 */     int rows = 0;
/* 184 */     MedicineJbBO key = new MedicineJbBO();
/*     */     try {
/* 186 */       int i = 0;
/*     */       do { key.setJbId(Integer.valueOf(ids[i]));
/* 188 */         rows += this.cineJbDAO.delete(key);
/*     */ 
/* 186 */         i++; if (ids == null) break;  } while (i < ids.length);
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 192 */       ExceptionUtils.getFullStackTrace(e);
				e.printStackTrace();
/*     */     }
/* 194 */     return rows;
/*     */   }
/*     */ 
/*     */   public void updateJb(Map map) throws Exception {
/* 198 */     this.cineJbDAO.updateJb(map);
/*     */   }
/*     */   public List tqjb(Map map) {
/* 201 */     List list = this.cineJbDAO.tqjb(map);
/* 202 */     return list;
/*     */   }
/*     */   public void updateJbJB(Map map) throws Exception {
/* 205 */     this.cineJbDAO.updateJbJB(map);
/*     */   }
/*     */ }

/* Location:           D:\李慧医药项目\tcmages\krt\WEB-INF\classes\
 * Qualified Name:     cn.krt.zbcg.system.services.impl.MedicineJbServicesImpl
 * JD-Core Version:    0.6.2
 */