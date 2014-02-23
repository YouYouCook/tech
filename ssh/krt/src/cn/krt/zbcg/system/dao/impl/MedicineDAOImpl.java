/*    */ package cn.krt.zbcg.system.dao.impl;
/*    */ 
/*    */ import cn.krt.zbcg.commons.bo.system.MedicineBO;
/*    */ import cn.krt.zbcg.system.dao.IMedicineDAO;
/*    */ import java.util.List;
/*    */ import org.ssi.dao.impl.BaseDaoImpl;
/*    */ 
/*    */ public class MedicineDAOImpl extends BaseDaoImpl
/*    */   implements IMedicineDAO
/*    */ {
/*    */   public void insert(MedicineBO record)
/*    */     throws Exception
/*    */   {
/* 27 */     insert("medicine.insert", record);
/*    */   }
/*    */ 
/*    */   public int update(MedicineBO record)
/*    */     throws Exception
/*    */   {
/* 37 */     int rows = update("medicine.updateByPrimaryKey", record);
/* 38 */     return rows;
/*    */   }
/*    */ 
/*    */   public List selectAll(Object obj)
/*    */   {
/* 48 */     List list = queryList("medicine.selectAll", obj);
/* 49 */     return list;
/*    */   }
/*    */   public List selectAlls(Object obj) {
/* 52 */     List list = queryList("medicine.selectAlls", obj);
/* 53 */     return list;
/*    */   }
/*    */ 
/*    */   public Object selectAllOfCount(Object obj)
/*    */   {
/* 62 */     Object o = queryData("medicine.selectAllOfCount", obj);
/* 63 */     return o;
/*    */   }
/*    */   public Object selectAllOfCounts(Object obj) {
/* 66 */     Object o = queryData("medicine.selectAllOfCounts", obj);
/* 67 */     return o;
/*    */   }
/*    */ 
/*    */   public Object queryData(Object obj)
/*    */   {
/* 76 */     Object record = queryData("medicine.selectByPrimaryKey", obj);
/* 77 */     return record;
/*    */   }
/*    */ 
/*    */   public int delete(MedicineBO key)
/*    */     throws Exception
/*    */   {
/* 87 */     int rows = delete("medicine.deleteByPrimaryKey", key);
/* 88 */     return rows;
/*    */   }
/*    */ 
/*    */   public List all()
/*    */   {
/* 93 */     List list = queryList("medicine.all");
/* 94 */     return list;
/*    */   }
/*    */ }

/* Location:           D:\李慧医药项目\tcmages\krt\WEB-INF\classes\
 * Qualified Name:     cn.krt.zbcg.system.dao.impl.MedicineDAOImpl
 * JD-Core Version:    0.6.2
 */