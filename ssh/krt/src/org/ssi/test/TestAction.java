/*     */ package org.ssi.test;
/*     */ 
/*     */ import java.io.PrintStream;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ import org.apache.struts.action.ActionForm;
/*     */ import org.apache.struts.action.ActionForward;
/*     */ import org.apache.struts.action.ActionMapping;
/*     */ import org.ssi.struts.action.SSIDispatchAction;
/*     */ 
/*     */ public class TestAction extends SSIDispatchAction
/*     */ {
/*     */   public ActionForward toUserManage(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */     throws Exception
/*     */   {
/*  18 */     System.out.println("---------------跳转到系统账号管理----------------");
/*  19 */     return mapping.findForward("toUserManage");
/*     */   }
/*     */ 
/*     */   public ActionForward toAdd(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */     throws Exception
/*     */   {
/*  27 */     System.out.println("---------------跳转到系统账号管理新增页面----------------");
/*  28 */     return mapping.findForward("toAdd");
/*     */   }
/*     */ 
/*     */   public ActionForward toUpdate(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */     throws Exception
/*     */   {
/*  36 */     System.out.println("---------------跳转到系统账号管理修改页面----------------");
/*  37 */     return mapping.findForward("toUpdate");
/*     */   }
/*     */ 
/*     */   public ActionForward toSuppliersInfo(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */     throws Exception
/*     */   {
/*  45 */     System.out.println("---------------跳转到供应商账号管理页面----------------");
/*  46 */     return mapping.findForward("toSuppliersInfo");
/*     */   }
/*     */ 
/*     */   public ActionForward toSuppliersInfoAdd(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */     throws Exception
/*     */   {
/*  54 */     System.out.println("---------------跳转到供应商账号管理增加页面----------------");
/*  55 */     return mapping.findForward("toSuppliersInfoAdd");
/*     */   }
/*     */ 
/*     */   public ActionForward toProductProtect(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */     throws Exception
/*     */   {
/*  63 */     System.out.println("---------------跳转到品种维护页面----------------");
/*  64 */     return mapping.findForward("toProductProtect");
/*     */   }
/*     */ 
/*     */   public ActionForward totestMakeSuppliersResult(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */     throws Exception
/*     */   {
/*  72 */     System.out.println("---------------跳转到确认供应商页面----------------");
/*  73 */     return mapping.findForward("totestMakeSuppliersResult");
/*     */   }
/*     */ 
/*     */   public ActionForward toAddProduct(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */     throws Exception
/*     */   {
/*  81 */     System.out.println("---------------跳转到品种增加页面----------------");
/*  82 */     return mapping.findForward("toAddProduct");
/*     */   }
/*     */ 
/*     */   public ActionForward toLrpz(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */     throws Exception
/*     */   {
/*  90 */     System.out.println("---------------跳转到录入信息列表页面----------------");
/*  91 */     return mapping.findForward("toLrpz");
/*     */   }
/*     */ 
/*     */   public ActionForward toCheck(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */     throws Exception
/*     */   {
/*  99 */     System.out.println("---------------跳转到采购人员查询产品价格低的供应商---------------");
/* 100 */     return mapping.findForward("toCheck");
/*     */   }
/*     */ 
/*     */   public ActionForward toCheckZbResult(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */     throws Exception
/*     */   {
/* 108 */     System.out.println("---------------跳转到采购人员查询中标结果页面---------------");
/* 109 */     return mapping.findForward("toCheckZbResult");
/*     */   }
/*     */ 
/*     */   public ActionForward toSuppliers(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */     throws Exception
/*     */   {
/* 117 */     System.out.println("---------------跳转到供应商录查看要录入的招标品种详细页面---------------");
/* 118 */     return mapping.findForward("toSuppliers");
/*     */   }
/*     */ 
/*     */   public ActionForward toSuppliersLr(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */     throws Exception
/*     */   {
/* 126 */     System.out.println("---------------跳转到供应商录查看要录入的招标品种页面---------------");
/* 127 */     return mapping.findForward("toSuppliersLr");
/*     */   }
/*     */ 
/*     */   public ActionForward toSuppliersLrModify(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */     throws Exception
/*     */   {
/* 135 */     System.out.println("---------------跳转到供应商录修改品种页面---------------");
/* 136 */     return mapping.findForward("toSuppliersLrModify");
/*     */   }
/*     */ 
/*     */   public ActionForward testSuppliersResult(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */     throws Exception
/*     */   {
/* 144 */     System.out.println("---------------跳转到供应商查询招标结果页面---------------");
/* 145 */     return mapping.findForward("testSuppliersResult");
/*     */   }
/*     */ 
/*     */   public ActionForward toCheckProduct(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */     throws Exception
/*     */   {
/* 153 */     System.out.println("---------------跳转到质量部检测招标品种页面---------------");
/* 154 */     return mapping.findForward("toCheckProduct");
/*     */   }
/*     */ 
/*     */   public ActionForward toCheckProductLr(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */     throws Exception
/*     */   {
/* 162 */     System.out.println("---------------跳转到质量部检测招标品种录入页面---------------");
/* 163 */     return mapping.findForward("toCheckProductLr");
/*     */   }
/*     */ }

/* Location:           D:\李慧医药项目\tcmages\krt\WEB-INF\classes\
 * Qualified Name:     org.ssi.test.TestAction
 * JD-Core Version:    0.6.2
 */