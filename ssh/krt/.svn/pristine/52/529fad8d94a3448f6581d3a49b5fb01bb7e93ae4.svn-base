/*    */ package cn.krt.zbcg.system.dao.impl;
/*    */ 
/*    */ import cn.krt.zbcg.commons.bo.system.CustomerVipBO;
/*    */ import cn.krt.zbcg.system.dao.ICustomerVipDAO;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import org.ssi.dao.impl.BaseDaoImpl;
/*    */ 
/*    */ public class CustomerVipDAOImpl extends BaseDaoImpl
/*    */   implements ICustomerVipDAO
/*    */ {
/*    */   public void insert(CustomerVipBO record)
/*    */     throws Exception
/*    */   {
/* 29 */     insert("customer_vip.insert", record);
/*    */   }
/*    */ 
/*    */   public int update(CustomerVipBO record)
/*    */     throws Exception
/*    */   {
/* 39 */     int rows = update("customer_vip.updateByPrimaryKey", record);
/* 40 */     return rows;
/*    */   }
/*    */ 
/*    */   public List selectAll(Object obj)
/*    */   {
/* 50 */     List list = queryList("customer_vip.selectAll", obj);
/* 51 */     return list;
/*    */   }
/*    */ 
/*    */   public Object selectAllOfCount(Object obj)
/*    */   {
/* 61 */     Object o = queryData("customer_vip.selectAllOfCount", obj);
/* 62 */     return o;
/*    */   }
/*    */ 
/*    */   public Object queryData(Object obj)
/*    */   {
/* 72 */     Object record = queryData("customer_vip.selectByPrimaryKey", obj);
/* 73 */     return record;
/*    */   }
/*    */ 
/*    */   public int delete(CustomerVipBO key)
/*    */     throws Exception
/*    */   {
/* 83 */     int rows = delete("customer_vip.deleteByPrimaryKey", key);
/* 84 */     return rows;
/*    */   }
/*    */ 
/*    */   public List findVipCustomer(Map map) {
/* 88 */     List list = queryList("customer_vip.findVipCustomer", map);
/* 89 */     return list;
/*    */   }
/*    */   public CustomerVipBO checkResult(CustomerVipBO bo) {
/* 92 */     CustomerVipBO vipBO = (CustomerVipBO)queryData("customer_vip.checkResult", bo);
/* 93 */     return vipBO;
/*    */   }
/*    */   public List findVipCustomerOne(CustomerVipBO bo) {
/* 96 */     List list = queryList("customer_vip.findVipCustomerOne", bo);
/* 97 */     return list;
/*    */   }
/*    */ }

/* Location:           D:\李慧医药项目\tcmages\krt\WEB-INF\classes\
 * Qualified Name:     cn.krt.zbcg.system.dao.impl.CustomerVipDAOImpl
 * JD-Core Version:    0.6.2
 */