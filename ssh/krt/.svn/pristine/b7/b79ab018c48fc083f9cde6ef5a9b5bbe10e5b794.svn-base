/*     */ package cn.krt.zbcg.system.dao.impl;
/*     */ 
/*     */ import cn.krt.zbcg.commons.bo.system.CustomerBO;
/*     */ import cn.krt.zbcg.system.dao.ICustomerDAO;
/*     */ import java.util.List;
/*     */ import org.ssi.dao.impl.BaseDaoImpl;
/*     */ 
/*     */ public class CustomerDAOImpl extends BaseDaoImpl
/*     */   implements ICustomerDAO
/*     */ {
/*     */   public void insert(CustomerBO record)
/*     */     throws Exception
/*     */   {
/*  27 */     insert("customer.insert", record);
/*     */   }
/*     */ 
/*     */   public int update(CustomerBO record)
/*     */     throws Exception
/*     */   {
/*  37 */     int rows = update("customer.updateByPrimaryKey", record);
/*  38 */     return rows;
/*     */   }
/*     */ 
/*     */   public List selectAll(Object obj)
/*     */   {
/*  48 */     List list = queryList("customer.selectAll", obj);
/*  49 */     return list;
/*     */   }
/*     */ 
/*     */   public Object queryData(Object obj)
/*     */   {
/*  58 */     Object record = queryData("customer.selectByPrimaryKey", obj);
/*  59 */     return record;
/*     */   }

/*     */   public List selectOutofDate()
/*     */   {
	/* 102 */     List list = queryList("customer.selectByOutOfDate");
	/* 103 */     return list;
/*     */   }

/*     */ 
/*     */   public int delete(CustomerBO key)
/*     */     throws Exception
/*     */   {
/*  69 */     int rows = delete("customer.deleteByPrimaryKey", key);
/*  70 */     return rows;
/*     */   }
/*     */ 
/*     */   public Object selectAllOfCount(Object obj) {
/*  74 */     Object o = queryData("customer.selectAllOfCount", obj);
/*  75 */     return o;
/*     */   }
/*     */ 
/*     */   public CustomerBO checkCustomerId(CustomerBO customerBO) {
/*  79 */     CustomerBO record = (CustomerBO)queryData("customer.checkCustomerId", customerBO);
/*     */ 
/*  81 */     return record;
/*     */   }
/*     */   public void updatePassword(CustomerBO customerBO) {
/*     */     try {
/*  85 */       update("customer.updatePassword", customerBO);
/*     */     }
/*     */     catch (Exception e) {
/*  88 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   public CustomerBO getPasswordByCheck(CustomerBO customerBO) {
/*  93 */     CustomerBO record = (CustomerBO)queryData("customer.getPasswordByCheck", customerBO);
/*     */ 
/*  95 */     return record;
/*     */   }
/*     */ 
/*     */   public List selectAllCustomer()
/*     */     throws Exception
/*     */   {
/* 102 */     List list = queryList("customer.selectAllCustomer");
/* 103 */     return list;
/*     */   }
/*     */ }

/* Location:           D:\李慧医药项目\tcmages\krt\WEB-INF\classes\
 * Qualified Name:     cn.krt.zbcg.system.dao.impl.CustomerDAOImpl
 * JD-Core Version:    0.6.2
 */