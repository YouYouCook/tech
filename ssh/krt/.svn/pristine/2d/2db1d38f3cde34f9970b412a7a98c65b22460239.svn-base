/*     */ package cn.krt.zbcg.system.services.impl;
/*     */ 
/*     */ import cn.krt.zbcg.commons.bo.system.MedicineBO;
/*     */ import cn.krt.zbcg.system.dao.IMedicineDAO;
/*     */ import cn.krt.zbcg.system.services.IMedicineServices;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.apache.commons.lang.exception.ExceptionUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import org.ssi.common.PageInfo;
/*     */ import org.ssi.services.impl.ServiceImpl;
/*     */ 
/*     */ public class MedicineServicesImpl extends ServiceImpl
/*     */   implements IMedicineServices
/*     */ {
/*     */   private IMedicineDAO medicineDAO;
/*     */ 
/*     */   public IMedicineDAO getMedicineDAO()
/*     */   {
/*  31 */     return this.medicineDAO;
/*     */   }
/*     */ 
/*     */   public void setMedicineDAO(IMedicineDAO medicineDAO)
/*     */   {
/*  43 */     this.medicineDAO = medicineDAO;
/*     */   }
/*     */ 
/*     */   public void insert(MedicineBO record)
/*     */   {
/*     */     try
/*     */     {
/*  54 */       this.medicineDAO.insert(record);
/*     */     }
/*     */     catch (Exception e) {
/*  57 */       ExceptionUtils.getFullStackTrace(e);
/*     */     }
/*     */   }
/*     */ 
/*     */   public int update(MedicineBO record)
/*     */   {
/*  68 */     int rows = 0;
/*     */     try {
/*  70 */       rows = this.medicineDAO.update(record);
/*     */     }
/*     */     catch (Exception e) {
/*  73 */       ExceptionUtils.getFullStackTrace(e);
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
/*     */   public List findAlls(PageInfo pageInfo, Map map) {
/* 103 */     this.pageInfo = pageInfo;
/* 104 */     List list = queryListByPages(map);
/* 105 */     return list;
/*     */   }
/*     */ 
/*     */   public List queryListByPage(Object obj)
/*     */   {
/* 114 */     this.pageInfo = this.pageInfo;
/* 115 */     Map map = new HashMap();
/*     */ 
/* 117 */     List list = null;
/*     */ 
/* 119 */     setPublicParams((Map)obj);
/* 120 */     this.logger.debug("��ѯ��" + (this.pageInfo != null ? this.pageInfo.getPageNum() : 0) + "ҳ���");
/*     */ 
/* 122 */     list = this.medicineDAO.selectAll(obj);
/* 123 */     this.logger.debug("list.size(befor reset)=" + (list != null ? Integer.valueOf(list.size()) : ""));
/*     */ 
/* 125 */     if ((list == null) || (list.size() == 0))
/*     */     {
/* 127 */       if ((this.pageInfo != null) && (this.pageInfo.getPageNum() > 0))
/*     */       {
/* 129 */         setPublicParams((Map)obj, true);
/* 130 */         list = this.medicineDAO.selectAll(obj);
/* 131 */         this.logger.debug("list.size(befor reset)=" + (list != null ? Integer.valueOf(list.size()) : ""));
/*     */       }
/*     */     }
/*     */ 
/* 135 */     Object o = this.medicineDAO.selectAllOfCount(obj);
/* 136 */     if (o != null)
/*     */     {
/* 138 */       this.logger.debug("���=" + o.toString());
/* 139 */       this.pageInfo.setTotalSize(Integer.parseInt(o.toString()));
/*     */     }
/* 141 */     return list;
/*     */   }
/*     */ 
/*     */   public List queryListByPages(Object obj) {
/* 145 */     this.pageInfo = this.pageInfo;
/* 146 */     Map map = new HashMap();
/*     */ 
/* 148 */     List list = null;
/*     */ 
/* 150 */     setPublicParams((Map)obj);
/* 151 */     this.logger.debug("��ѯ��" + (this.pageInfo != null ? this.pageInfo.getPageNum() : 0) + "ҳ���");
/*     */ 
/* 153 */     list = this.medicineDAO.selectAlls(obj);
/* 154 */     this.logger.debug("list.size(befor reset)=" + (list != null ? Integer.valueOf(list.size()) : ""));
/*     */ 
/* 156 */     if ((list == null) || (list.size() == 0))
/*     */     {
/* 158 */       if ((this.pageInfo != null) && (this.pageInfo.getPageNum() > 0))
/*     */       {
/* 160 */         setPublicParams((Map)obj, true);
/* 161 */         list = this.medicineDAO.selectAlls(obj);
/* 162 */         this.logger.debug("list.size(befor reset)=" + (list != null ? Integer.valueOf(list.size()) : ""));
/*     */       }
/*     */     }
/*     */ 
/* 166 */     Object o = this.medicineDAO.selectAllOfCounts(obj);
/* 167 */     if (o != null)
/*     */     {
/* 169 */       this.logger.debug("���=" + o.toString());
/* 170 */       this.pageInfo.setTotalSize(Integer.parseInt(o.toString()));
/*     */     }
/* 172 */     return list;
/*     */   }
/*     */ 
/*     */   public MedicineBO findById(Integer medicineId)
/*     */   {
/* 181 */     MedicineBO key = new MedicineBO();
/* 182 */     key.setMedicineId(medicineId);
/* 183 */     MedicineBO record = (MedicineBO)this.medicineDAO.queryData(key);
/* 184 */     return record;
/*     */   }
/*     */ 
/*     */   public int delete(MedicineBO record)
/*     */   {
/* 194 */     int rows = 0;
/*     */     try {
/* 196 */       rows = this.medicineDAO.delete(record);
/*     */     }
/*     */     catch (Exception e) {
/* 199 */       ExceptionUtils.getFullStackTrace(e);
				e.printStackTrace();
/*     */     }
/* 201 */     return rows;
/*     */   }
/*     */ 
/*     */   public int delete(String[] ids)
/*     */   {
/* 211 */     int rows = 0;
/* 212 */     MedicineBO key = new MedicineBO();
/*     */     try {
/* 214 */       int i = 0;
/*     */       do { key.setMedicineId(Integer.valueOf(ids[i]));
/* 216 */         rows += this.medicineDAO.delete(key);
/*     */ 
/* 214 */         i++; if (ids == null) break;  } while (i < ids.length);
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 220 */       ExceptionUtils.getFullStackTrace(e);
				e.printStackTrace();
			
/*     */     }
/* 222 */     return rows;
/*     */   }
/*     */ 
/*     */   public List findAlls(PageInfo pageInfo) {
/* 226 */     this.pageInfo = pageInfo;
/* 227 */     Map map = new HashMap();
/* 228 */     List list = findAlls(pageInfo, map);
/* 229 */     return list;
/*     */   }
/*     */ }

/* Location:           D:\李慧医药项目\tcmages\krt\WEB-INF\classes\
 * Qualified Name:     cn.krt.zbcg.system.services.impl.MedicineServicesImpl
 * JD-Core Version:    0.6.2
 */