/*     */ package cn.krt.zbcg.system.dao.impl;
/*     */ 
/*     */ import cn.krt.zbcg.commons.bo.system.MedicineCgBO;
/*     */ import cn.krt.zbcg.system.dao.IMedicineCgDAO;
/*     */ import com.ibatis.sqlmap.client.SqlMapClient;
/*     */ import java.sql.SQLException;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.ssi.dao.impl.BaseDaoImpl;
/*     */ 
/*     */ public class MedicineCgDAOImpl extends BaseDaoImpl
/*     */   implements IMedicineCgDAO
/*     */ {
/*     */   public void insert(MedicineCgBO record)
/*     */     throws Exception
/*     */   {
/*  31 */     insert("medicine_cg.insert", record);
/*     */   }
/*     */ 
/*     */   public int update(MedicineCgBO record)
/*     */     throws Exception
/*     */   {
/*  41 */     int rows = update("medicine_cg.updateByPrimaryKey", record);
/*  42 */     return rows;
/*     */   }
/*     */ 
/*     */   public List selectAll(Object obj)
/*     */   {
/*  52 */     List list = queryList("medicine_cg.selectAll", obj);
/*  53 */     return list;
/*     */   }
/*     */ 
/*     */   public Object selectAllOfCount(Object obj)
/*     */   {
/*  63 */     Object o = queryData("medicine_cg.selectAllOfCount", obj);
/*  64 */     return o;
/*     */   }
/*     */ 
/*     */   public Object queryData(Object obj)
/*     */   {
/*  74 */     Object record = queryData("medicine_cg.selectByPrimaryKey", obj);
/*  75 */     return record;
/*     */   }
/*     */ 
/*     */   public int delete(MedicineCgBO key)
/*     */     throws Exception
/*     */   {
/*  85 */     int rows = delete("medicine_cg.deleteZb", key);
/*  86 */     delete("medicine_cg.deleteJb", key);
/*  87 */     delete("medicine_cg.deleteByPrimaryKey", key);
/*  88 */     return rows;
/*     */   }
/*     */ 
/*     */   public void addCG(Map map) throws SQLException {
/*  92 */     getSqlMapClient().update("medicine_cg.addCG", map);
/*     */   }
/*     */ 
/*     */   public List selectByCgDate(String date)
/*     */   {
/*  97 */     return queryList("medicine_cg.selectByCgDate", date);
/*     */   }
/*     */   public void updateCgJB(Map map) {
/*     */     try {
/* 101 */       update("medicine_cg.updateCgJB", map);
/*     */     }
/*     */     catch (Exception e) {
/* 104 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   public List selectAllList()
/*     */   {
/* 114 */     return queryList("medicine_cg.selectAllList");
/*     */   }
/*     */ }

/* Location:           D:\李慧医药项目\tcmages\krt\WEB-INF\classes\
 * Qualified Name:     cn.krt.zbcg.system.dao.impl.MedicineCgDAOImpl
 * JD-Core Version:    0.6.2
 */