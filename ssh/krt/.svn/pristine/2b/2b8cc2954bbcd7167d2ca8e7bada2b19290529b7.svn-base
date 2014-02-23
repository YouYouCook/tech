/*    */ package cn.id5.idreal_hr.commons.log.dao.impl;
/*    */ 
/*    */ import cn.id5.idreal_hr.commons.bo.log.LogBO;
/*    */ import cn.id5.idreal_hr.commons.log.dao.ILogDAO;
/*    */ import java.util.List;
/*    */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*    */ import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
/*    */ 
/*    */ public class LogDAOImpl extends SqlMapClientDaoSupport
/*    */   implements ILogDAO
/*    */ {
/*    */   public void insert(LogBO record)
/*    */     throws Exception
/*    */   {
/* 29 */     getSqlMapClientTemplate().insert("S_T_LOG.insert", record);
/*    */   }
/*    */ 
/*    */   public int update(LogBO record)
/*    */     throws Exception
/*    */   {
/* 39 */     int rows = getSqlMapClientTemplate().update("S_T_LOG.updateByPrimaryKey", record);
/* 40 */     return rows;
/*    */   }
/*    */ 
/*    */   public List selectAll(Object obj)
/*    */   {
/* 50 */     List list = getSqlMapClientTemplate().queryForList("S_T_LOG.selectAll", obj);
/* 51 */     return list;
/*    */   }
/*    */ 
/*    */   public Object selectAllOfCount(Object obj)
/*    */   {
/* 61 */     Object o = getSqlMapClientTemplate().queryForObject("S_T_LOG.selectAllOfCount", obj);
/* 62 */     return o;
/*    */   }
/*    */ 
/*    */   public Object queryData(Object obj)
/*    */   {
/* 72 */     Object record = getSqlMapClientTemplate().queryForObject("S_T_LOG.selectByPrimaryKey", obj);
/* 73 */     return record;
/*    */   }
/*    */ 
/*    */   public int delete(LogBO key)
/*    */     throws Exception
/*    */   {
/* 83 */     int rows = getSqlMapClientTemplate().delete("S_T_LOG.deleteByPrimaryKey", key);
/* 84 */     return rows;
/*    */   }
/*    */ }

/* Location:           D:\李慧医药项目\tcmages\krt\WEB-INF\classes\
 * Qualified Name:     cn.id5.idreal_hr.commons.log.dao.impl.LogDAOImpl
 * JD-Core Version:    0.6.2
 */