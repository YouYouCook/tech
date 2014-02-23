/*    */ package cn.krt.zbcg.system.dao.impl;
/*    */ 
/*    */ import cn.krt.zbcg.commons.bo.system.NoticeBO;
/*    */ import cn.krt.zbcg.system.dao.INoticeDAO;
/*    */ import java.util.List;
/*    */ import org.ssi.dao.impl.BaseDaoImpl;
/*    */ 
/*    */ public class NoticeDAOImpl extends BaseDaoImpl
/*    */   implements INoticeDAO
/*    */ {
/*    */   public void insert(NoticeBO record)
/*    */     throws Exception
/*    */   {
/* 27 */     insert("notice.insert", record);
/*    */   }
/*    */ 
/*    */   public int update(NoticeBO record)
/*    */     throws Exception
/*    */   {
/* 37 */     int rows = update("notice.updateByPrimaryKey", record);
/* 38 */     return rows;
/*    */   }
/*    */ 
/*    */   public List selectAll(Object obj)
/*    */   {
/* 48 */     List list = queryList("notice.selectAll", obj);
/* 49 */     return list;
/*    */   }
/*    */ 
/*    */   public Object selectAllOfCount(Object obj)
/*    */   {
/* 59 */     Object o = queryData("notice.selectAllOfCount", obj);
/* 60 */     return o;
/*    */   }
/*    */ 
/*    */   public Object queryData(Object obj)
/*    */   {
/* 70 */     Object record = queryData("notice.selectByPrimaryKey", obj);
/* 71 */     return record;
/*    */   }
/*    */ 
/*    */   public int delete(NoticeBO key)
/*    */     throws Exception
/*    */   {
/* 81 */     int rows = delete("notice.deleteByPrimaryKey", key);
/* 82 */     return rows;
/*    */   }
/*    */ 
/*    */   public NoticeBO findNotice() {
/* 86 */     NoticeBO bo = (NoticeBO)queryData("notice.findNotice", "");
/* 87 */     return bo;
/*    */   }
/*    */ }

/* Location:           D:\李慧医药项目\tcmages\krt\WEB-INF\classes\
 * Qualified Name:     cn.krt.zbcg.system.dao.impl.NoticeDAOImpl
 * JD-Core Version:    0.6.2
 */