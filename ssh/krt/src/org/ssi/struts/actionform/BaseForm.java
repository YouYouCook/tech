/*     */ package org.ssi.struts.actionform;
/*     */ 
/*     */ import org.apache.struts.action.ActionForm;
/*     */ 
/*     */ public class BaseForm extends ActionForm
/*     */ {
/*     */   private static final long serialVersionUID = -4122724762971720564L;
/*  20 */   private String type = null;
/*     */ 
/*  23 */   private int pageNum = 1;
/*     */ 
/*  26 */   private int pageSize = 10;
/*     */ 
/*  28 */   private int order = 0;
/*     */ 
/*  30 */   private String orderField = null;
/*     */ 
/*  32 */   private String orgNo = null;
/*     */ 
/*  34 */   private String queryUserId = null;
/*     */ 
/*  36 */   private boolean currentUser = false;
/*     */ 
/*  38 */   private String[] selectNos = null;
/*     */ 
/*  40 */   private String startDate = null;
/*     */ 
/*  42 */   private String endDate = null;
/*     */ 
/*     */   public String getStartDate()
/*     */   {
/*  48 */     return this.startDate;
/*     */   }
/*     */ 
/*     */   public String getEndDate()
/*     */   {
/*  55 */     return this.endDate;
/*     */   }
/*     */ 
/*     */   public void setStartDate(String startDate)
/*     */   {
/*  62 */     this.startDate = startDate;
/*     */   }
/*     */ 
/*     */   public void setEndDate(String endDate)
/*     */   {
/*  69 */     this.endDate = endDate;
/*     */   }
/*     */ 
/*     */   public String[] getSelectNos()
/*     */   {
/*  76 */     return this.selectNos;
/*     */   }
/*     */ 
/*     */   public void setSelectNos(String[] selectNos)
/*     */   {
/*  83 */     this.selectNos = selectNos;
/*     */   }
/*     */ 
/*     */   public String getQueryUserId()
/*     */   {
/*  90 */     return this.queryUserId;
/*     */   }
/*     */ 
/*     */   public void setQueryUserId(String queryUserId)
/*     */   {
/*  97 */     this.queryUserId = queryUserId;
/*     */   }
/*     */ 
/*     */   public boolean isCurrentUser()
/*     */   {
/* 104 */     return this.currentUser;
/*     */   }
/*     */ 
/*     */   public void setCurrentUser(boolean currentUser)
/*     */   {
/* 111 */     this.currentUser = currentUser;
/*     */   }
/*     */ 
/*     */   public String getOrgNo()
/*     */   {
/* 118 */     return this.orgNo;
/*     */   }
/*     */ 
/*     */   public void setOrgNo(String orgNo)
/*     */   {
/* 125 */     this.orgNo = orgNo;
/*     */   }
/*     */ 
/*     */   public String getType()
/*     */   {
/* 132 */     return this.type;
/*     */   }
/*     */ 
/*     */   public void setType(String type)
/*     */   {
/* 139 */     this.type = type;
/*     */   }
/*     */ 
/*     */   public int getPageNum()
/*     */   {
/* 146 */     return this.pageNum;
/*     */   }
/*     */ 
/*     */   public int getPageSize()
/*     */   {
/* 153 */     return this.pageSize;
/*     */   }
/*     */ 
/*     */   public void setPageNum(int pageNum)
/*     */   {
/* 160 */     this.pageNum = pageNum;
/*     */   }
/*     */ 
/*     */   public void setPageSize(int pageSize)
/*     */   {
/* 167 */     this.pageSize = pageSize;
/*     */   }
/*     */ 
/*     */   public int getOrder()
/*     */   {
/* 174 */     return this.order;
/*     */   }
/*     */ 
/*     */   public String getOrderField()
/*     */   {
/* 181 */     return this.orderField;
/*     */   }
/*     */ 
/*     */   public void setOrder(int order)
/*     */   {
/* 188 */     this.order = order;
/*     */   }
/*     */ 
/*     */   public void setOrderField(String orderField)
/*     */   {
/* 195 */     this.orderField = orderField;
/*     */   }
/*     */ }

/* Location:           D:\李慧医药项目\tcmages\krt\WEB-INF\classes\
 * Qualified Name:     org.ssi.struts.actionform.BaseForm
 * JD-Core Version:    0.6.2
 */