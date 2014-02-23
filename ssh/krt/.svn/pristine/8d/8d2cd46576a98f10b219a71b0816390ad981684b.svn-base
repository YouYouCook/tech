/*     */ package cn.krt.zbcg.system.services.impl;
/*     */ 
/*     */ import cn.krt.zbcg.commons.bo.system.MedicineZbBO;
/*     */ import cn.krt.zbcg.system.dao.IMedicineZbDAO;
/*     */ import cn.krt.zbcg.system.services.IMedicineZbServices;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.apache.commons.lang.exception.ExceptionUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import org.ssi.common.PageInfo;
/*     */ import org.ssi.services.impl.ServiceImpl;
/*     */ 
/*     */ public class MedicineZbServicesImpl extends ServiceImpl
/*     */   implements IMedicineZbServices
/*     */ {
/*     */   private IMedicineZbDAO cineZbDAO;
/*     */ 
/*     */   public IMedicineZbDAO getCineZbDAO()
/*     */   {
/*  31 */     return this.cineZbDAO;
/*     */   }
/*     */ 
/*     */   public void setCineZbDAO(IMedicineZbDAO cineZbDAO)
/*     */   {
/*  43 */     this.cineZbDAO = cineZbDAO;
/*     */   }
/*     */ 
/*     */   public void insert(MedicineZbBO record)
/*     */   {
/*     */     try
/*     */     {
/*  54 */       this.cineZbDAO.insert(record);
/*     */     }
/*     */     catch (Exception e) {
/*  57 */       ExceptionUtils.getFullStackTrace(e);
/*     */     }
/*     */   }
/*     */ 
/*     */   public int update(MedicineZbBO record)
/*     */   {
/*  68 */     int rows = 0;
/*     */     try {
/*  70 */       rows = this.cineZbDAO.update(record);
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
/* 100 */     this.pageInfo = pageInfo;
/* 101 */     this.cineZbDAO.insertPrepare(map);
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
/* 121 */     list = this.cineZbDAO.selectAll(obj);
/* 122 */     this.logger.debug("list.size(befor reset)=" + (list != null ? Integer.valueOf(list.size()) : ""));
/*     */ 
/* 124 */     if ((list == null) || (list.size() == 0))
/*     */     {
/* 126 */       if ((this.pageInfo != null) && (this.pageInfo.getPageNum() > 0))
/*     */       {
/* 128 */         setPublicParams((Map)obj, true);
/* 129 */         list = this.cineZbDAO.selectAll(obj);
/* 130 */         this.logger.debug("list.size(befor reset)=" + (list != null ? Integer.valueOf(list.size()) : ""));
/*     */       }
/*     */     }
/*     */ 
/* 134 */     Object o = this.cineZbDAO.selectAllOfCount(obj);
/* 135 */     if (o != null)
/*     */     {
/* 137 */       this.logger.debug("���=" + o.toString());
/* 138 */       this.pageInfo.setTotalSize(Integer.parseInt(o.toString()));
/*     */     }
/* 140 */     return list;
/*     */   }
/*     */ 
/*     */   public MedicineZbBO findById(Integer zbId)
/*     */   {
/* 150 */     MedicineZbBO key = new MedicineZbBO();
/* 151 */     key.setZbId(zbId);
/* 152 */     MedicineZbBO record = (MedicineZbBO)this.cineZbDAO.queryData(key);
/* 153 */     return record;
/*     */   }
/*     */ 
/*     */   public int delete(MedicineZbBO record)
/*     */   {
/* 163 */     int rows = 0;
/*     */     try {
/* 165 */       rows = this.cineZbDAO.delete(record);
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
/* 181 */     MedicineZbBO key = new MedicineZbBO();
/*     */     try {
/* 183 */       int i = 0;
/*     */       do { key.setZbId(Integer.valueOf(ids[i]));
/* 185 */         rows += this.cineZbDAO.delete(key);
/*     */ 
/* 183 */         i++; if (ids == null) break;  } while (i < ids.length);
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 189 */       ExceptionUtils.getFullStackTrace(e);
/*     */     }
/* 191 */     return rows;
/*     */   }
/*     */   public List checkZbMedicine(Map map) {
/* 194 */     List list = this.cineZbDAO.checkZbMedicine(map);
/* 195 */     return list;
/*     */   }
/*     */   public List resultForCg(Map map ,PageInfo pageInfo) {
					this.pageInfo = pageInfo;
/* 198 */    // List list = this.cineZbDAO.resultForCg(map);
				List list = queryListByPageCG(map);
/* 199 */     return list;
/*     */   }

				public List queryListByPageCG(Object obj)
				{
				  this.pageInfo = this.pageInfo;
				  Map map = new HashMap();
				
				  List list = null;
				
				  setPublicParams((Map)obj);
				  this.logger.debug("��ѯ��" + (this.pageInfo != null ? this.pageInfo.getPageNum() : 0) + "ҳ���");
				
				  list = this.cineZbDAO.resultForCg((Map)obj);
				  this.logger.debug("list.size(befor reset)=" + (list != null ? Integer.valueOf(list.size()) : ""));
				
				  if ((list == null) || (list.size() == 0))
				  {
				    if ((this.pageInfo != null) && (this.pageInfo.getPageNum() > 0))
				    {
				      setPublicParams((Map)(Map)obj, true);
				      list = this.cineZbDAO.resultForCg((Map)obj);
				      this.logger.debug("list.size(befor reset)=" + (list != null ? Integer.valueOf(list.size()) : ""));
				    }
				  }
				  
				  /* 134 */     Object o = this.cineZbDAO.selectCgCount(obj);
				  /* 135 */     if (o != null)
				  /*     */     {
				  /* 137 */       this.logger.debug("���=" + o.toString());
				  /* 138 */       this.pageInfo.setTotalSize(Integer.parseInt(o.toString()));
				  /*     */     }
				  
				  return list;
				}

/*     */   public List resultForSuppliers(Map map) {
/* 202 */     List list = this.cineZbDAO.resultForSuppliers(map);
/* 203 */     return list;
/*     */   }
/*     */   public void updateZbState(MedicineZbBO record) {
/*     */     try {
/* 207 */       this.cineZbDAO.updateZbState(record);
/*     */     }
/*     */     catch (Exception e) {
/* 210 */       ExceptionUtils.getFullStackTrace(e);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void updateZbStateFq(String medicineId, String cgDate) {
/*     */     try { this.cineZbDAO.updateZbStateFq(medicineId, cgDate);
/*     */     } catch (Exception e)
/*     */     {
/* 218 */       ExceptionUtils.getFullStackTrace(e);
/*     */     }
/*     */   }
/*     */ 
/* 222 */   public List tqjb(Map map) { List list = this.cineZbDAO.tqjb(map);
/* 223 */     return list; }
/*     */ 
/*     */   public void updateZbAuthState(String medicineId, String cgDate) {
/*     */     try {
/* 227 */       this.cineZbDAO.updateZbAuthState(medicineId, cgDate);
/*     */     }
/*     */     catch (Exception e) {
/* 230 */       ExceptionUtils.getFullStackTrace(e);
/*     */     }
/*     */   }
/*     */ }

/* Location:           D:\李慧医药项目\tcmages\krt\WEB-INF\classes\
 * Qualified Name:     cn.krt.zbcg.system.services.impl.MedicineZbServicesImpl
 * JD-Core Version:    0.6.2
 */