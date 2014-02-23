/*    */ package cn.krt.zbcg.system.dao.impl;
/*    */ 
/*    */ import cn.krt.zbcg.commons.bo.system.VipzbBO;
/*    */ import cn.krt.zbcg.system.dao.IVipzbDAO;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import org.ssi.dao.impl.BaseDaoImpl;
/*    */ 
/*    */ public class VipzbDAOImpl extends BaseDaoImpl
/*    */   implements IVipzbDAO
/*    */ {
/*    */   public void insert(VipzbBO record)
/*    */     throws Exception
/*    */   {
/* 29 */     insert("vip_zb.insert", record);
/*    */   }
/*    */ 
/*    */   public int update(VipzbBO record)
/*    */     throws Exception
/*    */   {
/* 39 */     int rows = update("vip_zb.updateByPrimaryKey", record);
/* 40 */     return rows;
/*    */   }
/*    */ 
/*    */   public List selectAll(Object obj)
/*    */   {
/* 50 */     List list = queryList("vip_zb.selectAll", obj);
/* 51 */     return list;
/*    */   }
/*    */ 
/*    */   public Object selectAllOfCount(Object obj)
/*    */   {
/* 61 */     Object o = queryData("vip_zb.selectAllOfCount", obj);
/* 62 */     return o;
/*    */   }
/*    */ 
/*    */   public Object queryData(Object obj)
/*    */   {
/* 72 */     Object record = queryData("vip_zb.selectByPrimaryKey", obj);
/* 73 */     return record;
/*    */   }
/*    */ 
/*    */   public int delete(VipzbBO key)
/*    */     throws Exception
/*    */   {
/* 83 */     int rows = delete("vip_zb.deleteByPrimaryKey", key);
/* 84 */     return rows;
/*    */   }
/*    */   public List findZbCustomer(Map record) {
/* 87 */     List a = queryList("vip_zb.findZbCustomer", record);
/* 88 */     return a;
/*    */   }
/*    */   public VipzbBO findByMc(VipzbBO record) {
/* 91 */     VipzbBO a = (VipzbBO)queryData("vip_zb.findByMc", record);
/* 92 */     return a;
/*    */   }
/*    */   public int updateOne(VipzbBO record) throws Exception {
/* 95 */     int rows = update("vip_zb.updateOne", record);
/* 96 */     return rows;
/*    */   }
/*    */ }

/* Location:           D:\李慧医药项目\tcmages\krt\WEB-INF\classes\
 * Qualified Name:     cn.krt.zbcg.system.dao.impl.VipzbDAOImpl
 * JD-Core Version:    0.6.2
 */