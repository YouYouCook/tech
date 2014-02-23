/*     */ package cn.krt.zbcg.system.dao.impl;
/*     */ 
/*     */ import cn.krt.zbcg.commons.bo.system.UserBO;
/*     */ import cn.krt.zbcg.system.dao.IUserDAO;
/*     */ import java.util.List;
/*     */ import org.ssi.dao.impl.BaseDaoImpl;
/*     */ 
/*     */ public class UserDAOImpl extends BaseDaoImpl
/*     */   implements IUserDAO
/*     */ {
/*     */   public void insert(UserBO record)
/*     */     throws Exception
/*     */   {
/*  27 */     insert("users.insert", record);
/*     */   }
/*     */ 
/*     */   public int update(UserBO record)
/*     */     throws Exception
/*     */   {
/*  37 */     int rows = update("users.updateByPrimaryKey", record);
/*  38 */     return rows;
/*     */   }
/*     */ 
/*     */   public List selectAll(Object obj)
/*     */   {
/*  48 */     List list = queryList("users.selectAll", obj);
/*  49 */     return list;
/*     */   }
/*     */ 
/*     */   public Object selectAllOfCount(Object obj)
/*     */   {
/*  59 */     Object o = queryData("users.selectAllOfCount", obj);
/*  60 */     return o;
/*     */   }
/*     */ 
/*     */   public Object queryData(Object obj)
/*     */   {
/*  70 */     Object record = queryData("users.selectByPrimaryKey", obj);
/*  71 */     return record;
/*     */   }
/*     */ 
/*     */   public int delete(UserBO key)
/*     */     throws Exception
/*     */   {
/*  81 */     int rows = delete("users.deleteByPrimaryKey", key);
/*  82 */     return rows;
/*     */   }
/*     */   public UserBO getUserByName(UserBO obj) {
/*  85 */     UserBO record = (UserBO)queryData("users.getUserByName", obj);
/*  86 */     return record;
/*     */   }
/*     */   public void updatePassword(UserBO userBO) {
/*     */     try {
/*  90 */       update("users.updatePassword", userBO);
/*     */     } catch (Exception e) {
/*  92 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*  96 */   public UserBO getUserByLoginName(UserBO obj) { UserBO record = (UserBO)queryData("users.getUserByLoginName", obj);
/*  97 */     return record; }
/*     */ 
/*     */   public UserBO getPasswordByCheck(UserBO obj) {
/* 100 */     UserBO record = (UserBO)queryData("users.getPasswordByCheck", obj);
/* 101 */     return record;
/*     */   }
/*     */   public void updateUserPassword(UserBO userBO) {
/*     */     try {
/* 105 */       update("users.updateUserPassword", userBO);
/*     */     } catch (Exception e) {
/* 107 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */ }

/* Location:           D:\李慧医药项目\tcmages\krt\WEB-INF\classes\
 * Qualified Name:     cn.krt.zbcg.system.dao.impl.UserDAOImpl
 * JD-Core Version:    0.6.2
 */