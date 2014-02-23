/*     */ package cn.krt.zbcg.system.dao.impl;
/*     */ 
/*     */ import cn.krt.zbcg.commons.bo.system.MedicineJbBO;
/*     */ import cn.krt.zbcg.system.dao.IMedicineJbDAO;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.ssi.dao.impl.BaseDaoImpl;
/*     */ 
/*     */ public class MedicineJbDAOImpl extends BaseDaoImpl
/*     */   implements IMedicineJbDAO
/*     */ {
/*     */   public void insert(MedicineJbBO record)
/*     */     throws Exception
/*     */   {
/*  29 */     insert("medicine_jb.insert", record);
/*     */   }
/*     */ 
/*     */   public int update(MedicineJbBO record)
/*     */     throws Exception
/*     */   {
/*  39 */     int rows = update("medicine_jb.updateByPrimaryKey", record);
/*  40 */     return rows;
/*     */   }
/*     */ 
/*     */   public List selectAll(Object obj)
/*     */   {
/*  50 */     List list = queryList("medicine_jb.selectAll", obj);
/*  51 */     return list;
/*     */   }
/*     */ 
/*     */   public Object selectAllOfCount(Object obj)
/*     */   {
/*  61 */     Object o = queryData("medicine_jb.selectAllOfCount", obj);
/*  62 */     return o;
/*     */   }
/*     */ 
/*     */   public Object queryData(Object obj)
/*     */   {
/*  72 */     Object record = queryData("medicine_jb.selectByPrimaryKey", obj);
/*  73 */     return record;
/*     */   }
/*     */ 
/*     */   public int delete(MedicineJbBO key)
/*     */     throws Exception
/*     */   {
/*  83 */     int rows = delete("medicine_jb.deleteByPrimaryKey", key);
/*  84 */     return rows;
/*     */   }
/*     */ 
/*     */   public void insertPrepare(String customerAccount) throws Exception {
/*  88 */     update("medicine_jb.insertPrepare", customerAccount);
/*     */   }
/*     */ 
/*     */   public void updateJb(Map map) throws Exception
/*     */   {
/*  93 */     update("medicine_jb.updateJb", map);
/*     */   }
/*     */ 
/*     */   public List getTops(Map map)
/*     */   {
/* 100 */     return queryList("medicine_jb.getTops", map);
/*     */   }
/*     */ 
/*     */   public List isTops(Map map) {
/* 104 */     return queryList("medicine_jb.isTops", map);
/*     */   }
/*     */ 
/*     */   public void updateTopsDown(Map map) throws Exception {
/* 108 */     update("medicine_jb.updateTopsDown", map);
/*     */   }
/*     */ 
/*     */   public void updateTopsUp(Map map) throws Exception
/*     */   {
/* 113 */     update("medicine_jb.updateTopsUp", map);
/*     */   }
/*     */ 
/*     */   public void updateMedicineCode(Map map) throws Exception {
/* 117 */     update("medicine_jb.updateMedicineCode", map);
/*     */   }
/*     */ 
/*     */   public List tqjb(Map map) {
/* 121 */     return queryList("medicine_jb.tqjb", map);
/*     */   }
/*     */   public void updateJbJB(Map map) throws Exception {
/* 124 */     update("medicine_jb.updateJbJB", map);
/*     */   }
/*     */ 
/*     */   public MedicineJbBO judeJB(MedicineJbBO obj) {
/* 128 */     MedicineJbBO record = (MedicineJbBO)queryData("medicine_jb.judeJB", obj);
/* 129 */     return record;
/*     */   }
/*     */ 
/*     */   public List resetGetTops(Map map)
/*     */   {
/* 135 */     return queryList("medicine_jb.resetGetTops", map);
/*     */   }
/*     */ 
/*     */   public List startTender()
/*     */   {
/* 141 */     return queryList("medicine_cg.startTender");
/*     */   }
/*     */ 
/*     */   public List endTender()
/*     */   {
/* 147 */     return queryList("medicine_cg.endTender");
/*     */   }
/*     */ }

/* Location:           D:\李慧医药项目\tcmages\krt\WEB-INF\classes\
 * Qualified Name:     cn.krt.zbcg.system.dao.impl.MedicineJbDAOImpl
 * JD-Core Version:    0.6.2
 */