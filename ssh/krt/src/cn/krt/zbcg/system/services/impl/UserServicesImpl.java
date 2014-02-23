/*     */ package cn.krt.zbcg.system.services.impl;
/*     */ 
/*     */ import cn.krt.zbcg.commons.bo.system.UserBO;
/*     */ import cn.krt.zbcg.system.dao.IUserDAO;
/*     */ import cn.krt.zbcg.system.services.IUserServices;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.apache.commons.lang.exception.ExceptionUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import org.ssi.common.PageInfo;
/*     */ import org.ssi.services.impl.ServiceImpl;
/*     */ 
/*     */ public class UserServicesImpl extends ServiceImpl
/*     */   implements IUserServices
/*     */ {
/*     */   private IUserDAO userDAO;
/*     */ 
/*     */   public IUserDAO getUserDAO()
/*     */   {
/*  24 */     return this.userDAO;
/*     */   }
/*     */ 
/*     */   public void setUserDAO(IUserDAO userDAO) {
/*  28 */     this.userDAO = userDAO;
/*     */   }
/*     */ 
/*     */   public void insert(UserBO record)
/*     */   {
/*     */     try
/*     */     {
/*  39 */       this.userDAO.insert(record);
/*     */     }
/*     */     catch (Exception e) {
/*  42 */       ExceptionUtils.getFullStackTrace(e);
/*     */     }
/*     */   }
/*     */ 
/*     */   public int update(UserBO record)
/*     */   {
/*  53 */     int rows = 0;
/*     */     try {
/*  55 */       rows = this.userDAO.update(record);
/*     */     }
/*     */     catch (Exception e) {
/*  58 */       ExceptionUtils.getFullStackTrace(e);
/*     */     }
/*  60 */     return rows;
/*     */   }
/*     */ 
/*     */   public List findAll(PageInfo pageInfo)
/*     */   {
/*  70 */     this.pageInfo = pageInfo;
/*  71 */     Map map = new HashMap();
/*  72 */     List list = findAll(pageInfo, map);
/*  73 */     return list;
/*     */   }
/*     */ 
/*     */   public List findAll(PageInfo pageInfo, Map map)
/*     */   {
/*  83 */     this.pageInfo = pageInfo;
/*  84 */     List list = queryListByPage(map);
/*  85 */     return list;
/*     */   }
/*     */ 
/*     */   public List queryListByPage(Object obj)
/*     */   {
/*  95 */     this.pageInfo = this.pageInfo;
/*  96 */     Map map = new HashMap();
/*     */ 
/*  98 */     List list = null;
/*     */ 
/* 100 */     setPublicParams((Map)obj);
/* 101 */     this.logger.debug("锟斤拷询锟斤拷" + (this.pageInfo != null ? this.pageInfo.getPageNum() : 0) + "页锟斤拷锟�");
/*     */ 
/* 103 */     list = this.userDAO.selectAll(obj);
/* 104 */     this.logger.debug("list.size(befor reset)=" + (list != null ? Integer.valueOf(list.size()) : ""));
/*     */ 
/* 106 */     if ((list == null) || (list.size() == 0))
/*     */     {
/* 108 */       if ((this.pageInfo != null) && (this.pageInfo.getPageNum() > 0))
/*     */       {
/* 110 */         setPublicParams((Map)obj, true);
/* 111 */         list = this.userDAO.selectAll(obj);
/* 112 */         this.logger.debug("list.size(befor reset)=" + (list != null ? Integer.valueOf(list.size()) : ""));
/*     */       }
/*     */     }
/*     */ 
/* 116 */     Object o = this.userDAO.selectAllOfCount(obj);
/* 117 */     if (o != null)
/*     */     {
/* 119 */       this.logger.debug("锟斤拷锟�=" + o.toString());
/* 120 */       this.pageInfo.setTotalSize(Integer.parseInt(o.toString()));
/*     */     }
/* 122 */     return list;
/*     */   }
/*     */ 
/*     */   public UserBO findById(Integer userId)
/*     */   {
/* 132 */     UserBO key = new UserBO();
/* 133 */     key.setUserId(userId);
/* 134 */     UserBO record = (UserBO)this.userDAO.queryData(key);
/* 135 */     return record;
/*     */   }
/*     */ 
/*     */   public int delete(UserBO record)
/*     */   {
/* 145 */     int rows = 0;
/*     */     try {
/* 147 */       rows = this.userDAO.delete(record);
/*     */     }
/*     */     catch (Exception e) {
/* 150 */       ExceptionUtils.getFullStackTrace(e);
/*     */     }
/* 152 */     return rows;
/*     */   }
/*     */ 
/*     */   public int delete(String[] ids)
/*     */   {
/* 162 */     int rows = 0;
/* 163 */     UserBO key = new UserBO();
/*     */     try {
/* 165 */       int i = 0;
/*     */       do { key.setUserId(Integer.valueOf(ids[i]));
/* 167 */         rows += this.userDAO.delete(key);
/*     */ 
/* 165 */         i++; if (ids == null) break;  } while (i < ids.length);
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 171 */       ExceptionUtils.getFullStackTrace(e);
/*     */     }
/* 173 */     return rows;
/*     */   }
/*     */   public UserBO getUserByName(String username) {
/* 176 */     UserBO key = new UserBO();
/* 177 */     key.setUsername(username);
/* 178 */     UserBO record = this.userDAO.getUserByName(key);
/* 179 */     return record;
/*     */   }
/*     */   public void updatePassword(UserBO userBO) {
/* 182 */     this.userDAO.updatePassword(userBO);
/*     */   }
/*     */ 
/*     */   public UserBO getUserByLoginName(String loginName) {
/* 186 */     UserBO key = new UserBO();
/* 187 */     key.setLoginName(loginName);
/* 188 */     UserBO record = this.userDAO.getUserByLoginName(key);
/* 189 */     return record;
/*     */   }
/*     */ 
/*     */   public UserBO getPasswordByCheck(UserBO userBO) {
/* 193 */     UserBO record = this.userDAO.getPasswordByCheck(userBO);
/* 194 */     return record;
/*     */   }
/*     */   public void updateUserPassword(UserBO userBO) {
/* 197 */     this.userDAO.updateUserPassword(userBO);
/*     */   }
/*     */ }

/* Location:           D:\鏉庢収鍖昏嵂椤圭洰\tcmages\krt\WEB-INF\classes\
 * Qualified Name:     cn.krt.zbcg.system.services.impl.UserServicesImpl
 * JD-Core Version:    0.6.2
 */