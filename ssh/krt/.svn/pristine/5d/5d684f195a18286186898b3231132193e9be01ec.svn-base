/*     */ package org.ssi.dao.impl;
/*     */ 
/*     */ import com.ibatis.sqlmap.client.SqlMapClient;
/*     */ import java.sql.SQLException;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.apache.log4j.Logger;
/*     */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*     */ import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
/*     */ import org.ssi.dao.IBaseDao;
/*     */ 
/*     */ public class BaseDaoImpl extends SqlMapClientDaoSupport
/*     */   implements IBaseDao
/*     */ {
/*  20 */   protected Logger logger = Logger.getLogger(getClass());
/*     */ 
/*     */   public void insert(String id, Object bean)
/*     */     throws Exception
/*     */   {
/*     */     try
/*     */     {
/*  30 */       getSqlMapClient().insert(id, bean);
/*     */     } catch (SQLException e) {
/*  32 */       e.printStackTrace();
/*  33 */       this.logger.warn(e.getMessage());
/*  34 */       throw e;
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  38 */       e.printStackTrace();
/*  39 */       this.logger.warn(e.getMessage());
/*  40 */       throw e;
/*     */     }
/*     */   }
/*     */ 
/*     */   public int update(String id, Object bean)
/*     */     throws Exception
/*     */   {
/*  52 */     int rows = 0;
/*     */     try
/*     */     {
/*  55 */       rows = getSqlMapClient().update(id, bean);
/*     */     } catch (SQLException e) {
/*  57 */       this.logger.warn(e.getMessage());
/*  58 */       throw e;
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  62 */       this.logger.warn(e.getMessage());
/*  63 */       throw e;
/*     */     }
/*  65 */     return rows;
/*     */   }
/*     */ 
/*     */   public int delete(String id, Object bean)
/*     */     throws Exception
/*     */   {
/*  75 */     int rows = 0;
/*     */     try
/*     */     {
/*  78 */       rows = getSqlMapClient().update(id, bean);
/*     */     } catch (SQLException e) {
/*  80 */       this.logger.warn(e.getMessage());
/*  81 */       throw e;
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  85 */       this.logger.warn(e.getMessage());
/*  86 */       throw e;
/*     */     }
/*  88 */     return rows;
/*     */   }
/*     */ 
/*     */   public Object queryData(String id, Object obj)
/*     */   {
/*  99 */     return getSqlMapClientTemplate().queryForObject(id, obj);
/*     */   }
/*     */ 
/*     */   public List queryList(String id)
/*     */   {
/* 109 */     return getSqlMapClientTemplate().queryForList(id);
/*     */   }
/*     */ 
/*     */   public List queryList(String id, Object obj)
/*     */   {
/* 120 */     return getSqlMapClientTemplate().queryForList(id, obj);
/*     */   }
/*     */ 
/*     */   public Integer getSequence(String tableName)
/*     */   {
/* 129 */     int num = 0;
/* 130 */     Object o = getSqlMapClientTemplate().queryForObject("getzdbh", tableName);
/* 131 */     if (o != null)
/*     */     {
/* 133 */       num = new Integer(((Map)o).get("ID").toString()).intValue();
/*     */     }
/* 135 */     return Integer.valueOf(num);
/*     */   }
/*     */ }

/* Location:           D:\李慧医药项目\tcmages\krt\WEB-INF\classes\
 * Qualified Name:     org.ssi.dao.impl.BaseDaoImpl
 * JD-Core Version:    0.6.2
 */