/*     */ package cn.krt.zbcg.system.services.impl;
/*     */ 
/*     */ import cn.krt.zbcg.commons.bo.system.CustomerVipBO;
/*     */ import cn.krt.zbcg.system.dao.ICustomerVipDAO;
/*     */ import cn.krt.zbcg.system.services.ICustomerVipServices;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.apache.commons.lang.exception.ExceptionUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import org.ssi.common.PageInfo;
/*     */ import org.ssi.services.impl.ServiceImpl;
/*     */ 
/*     */ public class CustomerVipServicesImpl extends ServiceImpl
/*     */   implements ICustomerVipServices
/*     */ {
/*     */   private ICustomerVipDAO customerVipDAO;
/*     */ 
/*     */   public ICustomerVipDAO getCustomerVipDAO()
/*     */   {
/*  31 */     return this.customerVipDAO;
/*     */   }
/*     */ 
/*     */   public void setCustomerVipDAO(ICustomerVipDAO customerVipDAO)
/*     */   {
/*  43 */     this.customerVipDAO = customerVipDAO;
/*     */   }
/*     */ 
/*     */   public void insert(CustomerVipBO record)
/*     */   {
/*     */     try
/*     */     {
/*  54 */       this.customerVipDAO.insert(record);
/*     */     }
/*     */     catch (Exception e) {
/*  57 */       ExceptionUtils.getFullStackTrace(e);	e.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   public int update(CustomerVipBO record)
/*     */   {
/*  68 */     int rows = 0;
/*     */     try {
/*  70 */       rows = this.customerVipDAO.update(record);
/*     */     }
/*     */     catch (Exception e) {
/*  73 */       ExceptionUtils.getFullStackTrace(e);	e.printStackTrace();
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
/* 118 */     list = this.customerVipDAO.selectAll(obj);
/* 119 */     this.logger.debug("list.size(befor reset)=" + (list != null ? Integer.valueOf(list.size()) : ""));
/*     */ 
/* 121 */     if ((list == null) || (list.size() == 0))
/*     */     {
/* 123 */       if ((this.pageInfo != null) && (this.pageInfo.getPageNum() > 0))
/*     */       {
/* 125 */         setPublicParams((Map)obj, true);
/* 126 */         list = this.customerVipDAO.selectAll(obj);
/* 127 */         this.logger.debug("list.size(befor reset)=" + (list != null ? Integer.valueOf(list.size()) : ""));
/*     */       }
/*     */     }
/*     */ 
/* 131 */     Object o = this.customerVipDAO.selectAllOfCount(obj);
/* 132 */     if (o != null)
/*     */     {
/* 134 */       this.logger.debug("���=" + o.toString());
/* 135 */       this.pageInfo.setTotalSize(Integer.parseInt(o.toString()));
/*     */     }
/* 137 */     return list;
/*     */   }
/*     */ 
/*     */   public CustomerVipBO findById(Integer vipId)
/*     */   {
/* 147 */     CustomerVipBO key = new CustomerVipBO();
/* 148 */     key.setVipId(vipId);
/* 149 */     CustomerVipBO record = (CustomerVipBO)this.customerVipDAO.queryData(key);
/* 150 */     return record;
/*     */   }
/*     */ 
/*     */   public int delete(CustomerVipBO record)
/*     */   {
/* 160 */     int rows = 0;
/*     */     try {
/* 162 */       rows = this.customerVipDAO.delete(record);
/*     */     }
/*     */     catch (Exception e) {
/* 165 */       ExceptionUtils.getFullStackTrace(e);	e.printStackTrace();
/*     */     }
/* 167 */     return rows;
/*     */   }
/*     */ 
/*     */   public int delete(String[] ids)
/*     */   {
/* 177 */     int rows = 0;
/* 178 */     CustomerVipBO key = new CustomerVipBO();
/*     */     try {
/* 180 */       int i = 0;
/*     */       do { key.setVipId(Integer.valueOf(ids[i]));
/* 182 */         rows += this.customerVipDAO.delete(key);
/*     */ 
/* 180 */         i++; if (ids == null) break;  } while (i < ids.length);
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 186 */       ExceptionUtils.getFullStackTrace(e);	e.printStackTrace();
/*     */     }
/* 188 */     return rows;
/*     */   }
/*     */   public List findVipCustomer(Map map) {
/* 191 */     List list = this.customerVipDAO.findVipCustomer(map);
/* 192 */     return list;
/*     */   }
/*     */ 
/*     */   public CustomerVipBO checkResult(CustomerVipBO vipBO)
/*     */   {
/* 197 */     CustomerVipBO bo = this.customerVipDAO.checkResult(vipBO);
/* 198 */     return bo;
/*     */   }
/*     */ 
/*     */   public List findVipCustomerOne(int customerId, int medicineId) {
/* 202 */     CustomerVipBO vipBO = new CustomerVipBO();
/* 203 */     vipBO.setCustomerId(Integer.valueOf(customerId));
/* 204 */     vipBO.setMedicineId(Integer.valueOf(medicineId));
/* 205 */     List list = this.customerVipDAO.findVipCustomerOne(vipBO);
/* 206 */     return list;
/*     */   }
/*     */ }

/* Location:           D:\李慧医药项目\tcmages\krt\WEB-INF\classes\
 * Qualified Name:     cn.krt.zbcg.system.services.impl.CustomerVipServicesImpl
 * JD-Core Version:    0.6.2
 */