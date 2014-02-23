/*     */ package org.ssi.common;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ 
/*     */ public class PageInfo
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = -3772902891319631586L;
/*  16 */   private static Log log = LogFactory.getLog(PageInfo.class);
/*     */ 
/*  18 */   private int totalSize = 0;
/*     */ 
/*  20 */   private int pageNum = 1;
/*     */ 
/*  22 */   private int pageSize = 10;
/*     */   public static final int DEFAUTL_PAGESIZE = 10;
/*  26 */   private int totalPageNum = 0;
/*     */ 
/*  29 */   private String orgNo = null;
/*     */ 
/*  31 */   private boolean currentUser = false;
/*     */ 
/*  33 */   private String orgName = null;
/*     */ 
/*  35 */   private String startDate = null;
/*     */ 
/*  37 */   private String endDate = null;
/*     */ 
/*  39 */   private int userId = -1;
/*     */ 
/*  41 */   private String queryUserId = null;
/*     */ 
/*  43 */   private boolean currentOrgAdmin = false;
/*     */ 
/*  45 */   private boolean validUser = true;
/*     */ 
/*  47 */   private boolean queryAll = false;
/*     */ 
/*  49 */   private boolean validPage = true;
/*     */ 
/*     */   public boolean isValidPage()
/*     */   {
/*  54 */     return this.validPage;
/*     */   }
/*     */ 
/*     */   public void setValidPage(boolean validPage)
/*     */   {
/*  60 */     this.validPage = validPage;
/*     */   }
/*     */ 
/*     */   public String getOrgName()
/*     */   {
/*  66 */     return this.orgName;
/*     */   }
/*     */ 
/*     */   public String getStartDate()
/*     */   {
/*  72 */     return this.startDate;
/*     */   }
/*     */ 
/*     */   public String getEndDate()
/*     */   {
/*  78 */     return this.endDate;
/*     */   }
/*     */ 
/*     */   public void setOrgName(String orgName)
/*     */   {
/*  84 */     this.orgName = orgName;
/*     */   }
/*     */ 
/*     */   public void setStartDate(String startDate)
/*     */   {
/*  90 */     this.startDate = startDate;
/*     */   }
/*     */ 
/*     */   public void setEndDate(String endDate)
/*     */   {
/*  96 */     this.endDate = endDate;
/*     */   }
/*     */ 
/*     */   public boolean isValidUser()
/*     */   {
/* 105 */     return this.validUser;
/*     */   }
/*     */ 
/*     */   public void setValidUser(boolean validUser)
/*     */   {
/* 111 */     this.validUser = validUser;
/*     */   }
/*     */ 
/*     */   public int getUserId()
/*     */   {
/* 117 */     return this.userId;
/*     */   }
/*     */ 
/*     */   public void setUserId(int userId)
/*     */   {
/* 123 */     this.userId = userId;
/*     */   }
/*     */ 
/*     */   public boolean isCurrentUser()
/*     */   {
/* 129 */     return this.currentUser;
/*     */   }
/*     */ 
/*     */   public void setCurrentUser(boolean currentUser)
/*     */   {
/* 135 */     this.currentUser = currentUser;
/*     */   }
/*     */ 
/*     */   public String getOrgNo()
/*     */   {
/* 141 */     return this.orgNo;
/*     */   }
/*     */ 
/*     */   public void setOrgNo(String orgNo)
/*     */   {
/* 147 */     this.orgNo = orgNo;
/*     */   }
/*     */ 
/*     */   public int getPageNum()
/*     */   {
/* 154 */     return this.pageNum;
/*     */   }
/*     */ 
/*     */   public int getPageSize()
/*     */   {
/* 160 */     return this.pageSize;
/*     */   }
/*     */ 
/*     */   public int getTotalPageNum()
/*     */   {
/* 167 */     if (this.pageSize > 0)
/* 168 */       this.totalPageNum = ((this.totalSize + this.pageSize - 1) / this.pageSize);
/* 169 */     return this.totalPageNum;
/*     */   }
/*     */ 
/*     */   public int getTotalSize()
/*     */   {
/* 175 */     return this.totalSize;
/*     */   }
/*     */ 
/*     */   public void setPageNum(int pageNum)
/*     */   {
/* 181 */     this.pageNum = pageNum;
/*     */   }
/*     */ 
/*     */   public void setPageSize(int pageSize)
/*     */   {
/* 187 */     this.pageSize = pageSize;
/*     */   }
/*     */ 
/*     */   public void setTotalSize(int totalSize)
/*     */   {
/* 193 */     this.totalSize = totalSize;
/*     */   }
/*     */ 
/*     */   public void setTotalPageNum(int totalPageNum)
/*     */   {
/* 199 */     this.totalPageNum = totalPageNum;
/*     */   }
/*     */ 
/*     */   public String getQueryUserId()
/*     */   {
/* 207 */     return this.queryUserId;
/*     */   }
/*     */ 
/*     */   public boolean isCurrentOrgAdmin()
/*     */   {
/* 213 */     return this.currentOrgAdmin;
/*     */   }
/*     */ 
/*     */   public void setQueryUserId(String queryUserId)
/*     */   {
/* 219 */     this.queryUserId = queryUserId;
/*     */   }
/*     */ 
/*     */   public void setCurrentOrgAdmin(boolean currentOrgAdmin)
/*     */   {
/* 225 */     this.currentOrgAdmin = currentOrgAdmin;
/*     */   }
/*     */ 
/*     */   public boolean isQueryAll()
/*     */   {
/* 231 */     return this.queryAll;
/*     */   }
/*     */ 
/*     */   public void setQueryAll(boolean queryAll)
/*     */   {
/* 237 */     this.queryAll = queryAll;
/* 238 */     this.pageNum = 1;
/* 239 */     this.pageSize = 10000;
/*     */   }
/*     */ 
/*     */   public void setQueryAll(boolean queryAll, int pageSize)
/*     */   {
/* 246 */     this.queryAll = queryAll;
/* 247 */     this.pageNum = 1;
/*     */ 
/* 249 */     this.pageSize = pageSize;
/* 250 */     if (pageSize <= 0) this.pageSize = 10000;
/*     */   }
/*     */ }

/* Location:           D:\李慧医药项目\tcmages\krt\WEB-INF\classes\
 * Qualified Name:     org.ssi.common.PageInfo
 * JD-Core Version:    0.6.2
 */