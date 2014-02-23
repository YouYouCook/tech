/*     */ package cn.krt.zbcg.system.services.impl;
/*     */ 
/*     */ import cn.krt.zbcg.commons.bo.system.CustomerBO;
/*     */ import cn.krt.zbcg.system.dao.ICustomerDAO;
/*     */ import cn.krt.zbcg.system.services.ICustomerServices;

/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;

/*     */ import org.apache.commons.lang.exception.ExceptionUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import org.ssi.common.PageInfo;
/*     */ import org.ssi.services.impl.ServiceImpl;
/*     */ 
/*     */ public class CustomerServicesImpl extends ServiceImpl
/*     */   implements ICustomerServices
/*     */ {
/*     */   private ICustomerDAO customerDAO;
/*     */ 
/*     */   public ICustomerDAO getCustomerDAO()
/*     */   {
/*  31 */     return this.customerDAO;
/*     */   }
/*     */ 
/*     */   public void setCustomerDAO(ICustomerDAO customerDAO)
/*     */   {
/*  43 */     this.customerDAO = customerDAO;
/*     */   }
/*     */ 
/*     */   public void insert(CustomerBO record)
/*     */   {
/*     */     try
/*     */     {
/*  54 */       this.customerDAO.insert(record);
/*     */     }
/*     */     catch (Exception e) {
/*  57 */       ExceptionUtils.getFullStackTrace(e);	e.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   public int update(CustomerBO record)
/*     */   {
/*  68 */     int rows = 0;
/*     */     try {
/*  70 */       rows = this.customerDAO.update(record);
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
/* 118 */     list = this.customerDAO.selectAll(obj);
/* 119 */     this.logger.debug("list.size(befor reset)=" + (list != null ? Integer.valueOf(list.size()) : ""));
/*     */ 
/* 121 */     if ((list == null) || (list.size() == 0))
/*     */     {
/* 123 */       if ((this.pageInfo != null) && (this.pageInfo.getPageNum() > 0))
/*     */       {
/* 125 */         setPublicParams((Map)obj, true);
/* 126 */         list = this.customerDAO.selectAll(obj);
/* 127 */         this.logger.debug("list.size(befor reset)=" + (list != null ? Integer.valueOf(list.size()) : ""));
/*     */       }
/*     */     }
/*     */ 
/* 131 */     Object o = this.customerDAO.selectAllOfCount(obj);
/* 132 */     if (o != null)
/*     */     {
/* 134 */       this.logger.debug("���=" + o.toString());
/* 135 */       this.pageInfo.setTotalSize(Integer.parseInt(o.toString()));
/*     */     }
/* 137 */     return list;
/*     */   }
/*     */ 
/*     */   public CustomerBO findById(Integer customerId)
/*     */   {
/* 147 */     CustomerBO key = new CustomerBO();
/* 148 */     key.setCustomerId(customerId);
/* 149 */     CustomerBO record = (CustomerBO)this.customerDAO.queryData(key);
/* 150 */     return record;
/*     */   }
/*     */ 
/*     */   public int delete(CustomerBO record)
/*     */   {
/* 160 */     int rows = 0;
/*     */     try {
/* 162 */       rows = this.customerDAO.delete(record);
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
/* 178 */     CustomerBO key = new CustomerBO();
			 String id = ids[0];
/*     */     try {
					if(id.contains(",")){
						id  = id.split(",")[0];
					}
/*     */         key.setCustomerId(Integer.valueOf(id));
/* 182 */         rows = this.customerDAO.delete(key);
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 186 */       ExceptionUtils.getFullStackTrace(e);	e.printStackTrace();
/*     */     }
/* 188 */     return rows;
/*     */   }
/*     */   public CustomerBO checkCustomerId(String customerAccount) {
/* 191 */     CustomerBO key = new CustomerBO();
/* 192 */     key.setCustomerAccount(customerAccount);
/* 193 */     CustomerBO customerBO = this.customerDAO.checkCustomerId(key);
/* 194 */     return customerBO;
/*     */   }
/*     */   public void updatePassword(CustomerBO customerBO) {
/* 197 */     this.customerDAO.updatePassword(customerBO);
/*     */   }
/*     */   public CustomerBO getPasswordByCheck(CustomerBO record) {
/* 200 */     CustomerBO customerBO = this.customerDAO.getPasswordByCheck(record);
/* 201 */     return customerBO;
/*     */   }

		public List getOutofDate( PageInfo pageInfo) throws Exception {
				this.pageInfo = pageInfo;
			     Map map = new HashMap();
			     this.pageInfo = this.pageInfo;

			     List list = null;

			     setPublicParams(map);
			     this.logger.debug("��ѯ��" + (this.pageInfo != null ? this.pageInfo.getPageNum() : 0) + "ҳ���");

			     list = this.customerDAO.selectOutofDate();
			     this.logger.debug("list.size(befor reset)=" + (list != null ? Integer.valueOf(list.size()) : ""));

			     if ((list == null) || (list.size() == 0))
			     {
			       if ((this.pageInfo != null) && (this.pageInfo.getPageNum() > 0))
			       {
			         setPublicParams(map, true);
			         list = this.customerDAO.selectOutofDate();
			         this.logger.debug("list.size(befor reset)=" + (list != null ? Integer.valueOf(list.size()) : ""));
			       }
			     }

			   //  Object o = this.customerDAO.selectAllOfCount(obj);
			    // if (o != null)
			    // {
			     //  this.logger.debug("���=" + o.toString());
			       this.pageInfo.setTotalSize(list.size());
			    // }
			     return list;
		}

/*     */ }

/* Location:           D:\李慧医药项目\tcmages\krt\WEB-INF\classes\
 * Qualified Name:     cn.krt.zbcg.system.services.impl.CustomerServicesImpl
 * JD-Core Version:    0.6.2
 */