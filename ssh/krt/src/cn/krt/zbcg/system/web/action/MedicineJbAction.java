/*     */ package cn.krt.zbcg.system.web.action;
/*     */ 
/*     */ import cn.krt.zbcg.commons.bo.system.MedicineBO;
import cn.krt.zbcg.commons.bo.system.MedicineCgBO;
/*     */ import cn.krt.zbcg.commons.bo.system.MedicineJbBO;
/*     */ import cn.krt.zbcg.commons.bo.system.UserBO;
/*     */ import cn.krt.zbcg.system.services.IMedicineCgServices;
/*     */ import cn.krt.zbcg.system.services.IMedicineJbServices;
/*     */ import cn.krt.zbcg.system.web.form.MedicineJbForm;

/*     */ import java.io.PrintWriter;
/*     */ import java.util.List;
/*     */ import java.util.Map;
import java.util.Random;

/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ import javax.servlet.http.HttpSession;

/*     */ import org.apache.commons.lang.exception.ExceptionUtils;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.struts.action.ActionForm;
/*     */ import org.apache.struts.action.ActionForward;
/*     */ import org.apache.struts.action.ActionMapping;
/*     */ import org.ssi.common.Operate;
/*     */ import org.ssi.common.PageInfo;
/*     */ import org.ssi.struts.action.SSIDispatchAction;
/*     */ 
/*     */ public class MedicineJbAction extends SSIDispatchAction
/*     */ {
/*     */   private IMedicineJbServices cineJbServices;
/*     */   private IMedicineCgServices cineCgServices;
/*     */ 
/*     */   private IMedicineJbServices getCineJbServices()
/*     */   {
/*  29 */     if (this.cineJbServices == null) {
/*  30 */       this.cineJbServices = ((IMedicineJbServices)getBean("cineJbServices"));
/*     */     }
/*  32 */     return this.cineJbServices;
/*     */   }
/*     */ 
/*     */   private IMedicineCgServices getCineCgServices() {
/*  36 */     if (this.cineCgServices == null) {
/*  37 */       this.cineCgServices = ((IMedicineCgServices)getBean("cineCgServices"));
/*     */     }
/*  39 */     return this.cineCgServices;
/*     */   }


				public void processImagePath(HttpServletRequest request,MedicineBO medicineBO){
						 String path = request.getContextPath();   
						  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; 
						  String dir=basePath+"/uploadfiles/"; 
							MedicineBO bo = (MedicineBO) medicineBO;
							String imagename = bo.getMedicineimagefilename();
							if(imagename!=null && !imagename.equals("")){
								 Random random=new Random();
								 String version = "?v=" +random.nextInt();
								 bo.setMedicineVistorimagePath(dir+imagename+version);
							}else{
								// bo.setMedicineimagefilename(dir+"test.jpg");
								//默认图
							}
						
					
				}
/*     */ 
/*     */   public ActionForward list(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */     throws Exception
/*     */   {
/*  49 */     UserBO userBO = (UserBO)request.getSession().getAttribute("Logon.User");
/*  50 */     MedicineJbForm cineJbForm = (MedicineJbForm)form;
/*  51 */     PageInfo pageInfo = new PageInfo();
/*  52 */     getCineJbServices().setRequest(request);
/*  53 */     Map map = Operate.describe(cineJbForm);
/*  54 */     map.put("customerAccount", userBO.getLoginName());
/*  55 */     map.put("beginDate", cineJbForm.getBeginDate());
/*  56 */     map.put("endDate", cineJbForm.getEndDate());
/*  57 */     List cineJbList = getCineJbServices().findAll(pageInfo, map);
/*  58 */     int qtys = 0;
/*  59 */     double amounts = 0.0D;
/*  60 */     if ((cineJbList != null) && (cineJbList.size() > 0)) {
/*  61 */       for (Object ob : cineJbList) {
					MedicineJbBO bo = (MedicineJbBO)ob;
					
					processImagePath(request,bo.getMedicineCgBO().getMedicineBO());
/*  62 */         if (bo.getPrice() != null) {
/*  63 */           qtys++;
/*  64 */           amounts += bo.getMedicineCgBO().getCgQty().intValue() * bo.getPrice().doubleValue();
/*     */         }
/*     */       }
/*     */     }
/*  68 */     request.setAttribute("qtys", Integer.valueOf(qtys));
/*  69 */     request.setAttribute("amounts", Double.valueOf(amounts));
/*  70 */     request.setAttribute("cineJbList", cineJbList);
/*  71 */     request.setAttribute("pageInfo", pageInfo);
/*  72 */     request.setAttribute("name", cineJbForm.getName());
/*  73 */     request.setAttribute("beginDate", cineJbForm.getBeginDate());
/*  74 */     request.setAttribute("endDate", cineJbForm.getEndDate());
/*  75 */     request.setAttribute("medicineId", cineJbForm.getMedicineId());
/*  76 */     if (map != null) { map.clear(); map = null; }
/*  77 */     return mapping.findForward("list");
/*     */   }
/*     */ 
/*     */   public ActionForward toAdd(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */     throws Exception
/*     */   {
/*  87 */     if (log.isDebugEnabled()) log.debug("forward to add page.");
/*  88 */     return mapping.findForward("toAdd");
/*     */   }
/*     */ 
/*     */   public ActionForward add(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */     throws Exception
/*     */   {
/*  98 */     MedicineJbForm cineJbForm = (MedicineJbForm)form;
/*  99 */     MedicineJbBO cineJbBO = cineJbForm.getCineJbBO();
/*     */     try {
/* 101 */       if (log.isDebugEnabled()) log.debug("insert data.");
/* 102 */       getCineJbServices().insert(cineJbBO);
/*     */     } catch (Exception e) {
/* 104 */       ExceptionUtils.getFullStackTrace(e);
/*     */     }
/* 106 */     return list(mapping, form, request, response);
/*     */   }
/*     */ 
/*     */   public ActionForward jbConfirm(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
/* 110 */     MedicineJbForm cineJbForm = (MedicineJbForm)form;
/*     */ 
/* 112 */     getCineJbServices().setRequest(request);
/* 113 */     Map map = Operate.describe(cineJbForm);
/* 114 */     String jbId = request.getParameter("jbId1");
/* 115 */     String ylcd = request.getParameter(jbId + "ylcd");
/* 116 */     String price = request.getParameter(jbId + "price");
/* 117 */     String remark = request.getParameter(jbId + "remark");
/* 118 */     map.put("jbId", jbId);
/* 119 */     map.put("ylcd", ylcd);
/* 120 */     map.put("price", price);
/* 121 */     map.put("remark", remark);
/*     */     try {
/* 123 */       getCineJbServices().updateJb(map);
/*     */     } catch (Exception e) {
/* 125 */       ExceptionUtils.getFullStackTrace(e);
/*     */     }
/* 127 */     return list(mapping, form, request, response);
/*     */   }
/*     */ 
/*     */   public ActionForward toUpdate(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */     throws Exception
/*     */   {
/* 137 */     if (log.isDebugEnabled()) log.debug("get actionForm object.");
/* 138 */     MedicineJbForm cineJbForm = (MedicineJbForm)form;
/* 139 */     String id = cineJbForm.getSelectNos()[0];
/* 140 */     if (log.isDebugEnabled()) log.debug("get data detail by id=" + id + ".");
/* 141 */     MedicineJbBO cineJbBO = getCineJbServices().findById(Integer.valueOf(id));
/* 142 */     if (log.isDebugEnabled()) log.debug("set business object.");
/* 143 */     cineJbForm.setCineJbBO(cineJbBO);
/* 144 */     return mapping.findForward("toUpdate");
/*     */   }
/*     */ 
/*     */   public ActionForward update(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */     throws Exception
/*     */   {
/* 154 */     MedicineJbForm cineJbForm = (MedicineJbForm)form;
/* 155 */     MedicineJbBO cineJbBO = cineJbForm.getCineJbBO();
/* 156 */     String jbId = request.getParameter("ids");
/* 157 */     String hgState = request.getParameter(jbId + "hgState");
/* 158 */     String view = request.getParameter(jbId + "view");
/* 159 */     cineJbBO.setJbId(Integer.valueOf(Integer.parseInt(jbId)));
/* 160 */     cineJbBO.setHgState(hgState);
/* 161 */     cineJbBO.setView(view);
/*     */     try
/*     */     {
/* 164 */       getCineJbServices().update(cineJbBO);
/*     */     } catch (Exception e) {
/* 166 */       ExceptionUtils.getFullStackTrace(e);
/*     */     }
/* 168 */     return list(mapping, form, request, response);
/*     */   }
/*     */ 
/*     */   public ActionForward toDelete(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */     throws Exception
/*     */   {
/* 178 */     if (log.isDebugEnabled()) log.debug("get actionForm object.");
/* 179 */     MedicineJbForm cineJbForm = (MedicineJbForm)form;
/* 180 */     String[] ids = cineJbForm.getSelectNos();
/*     */     try {
/* 182 */       if (log.isDebugEnabled()) log.debug("delete data or change data's status to delete.");
/* 183 */       getCineJbServices().delete(ids);
/*     */     } catch (Exception localException) {
/*     */     }
/* 186 */     return list(mapping, form, request, response);
/*     */   }
/*     */ 
/*     */   public ActionForward toDetail(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */     throws Exception
/*     */   {
/* 196 */     if (log.isDebugEnabled()) log.debug("get actionForm object.");
/* 197 */     MedicineJbForm cineJbForm = (MedicineJbForm)form;
/* 198 */     String id = cineJbForm.getSelectNos()[0];
/* 199 */     if (log.isDebugEnabled()) log.debug("get data detail by id=" + id + ".");
/* 200 */     MedicineJbBO cineJbBO = getCineJbServices().findById(Integer.valueOf(id));
/* 201 */     if (log.isDebugEnabled()) log.debug("set business object.");
/* 202 */     cineJbForm.setCineJbBO(cineJbBO);
/* 203 */     return mapping.findForward("toDetail");
/*     */   }
/*     */ 
/*     */   public ActionForward toTqjb(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */     throws Exception
/*     */   {
/* 209 */     return mapping.findForward("tqjb");
/*     */   }
/*     */ 
/*     */   public ActionForward Tqjb(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */     throws Exception
/*     */   {
/* 216 */     String beginDate = request.getParameter("beginDate");
/*     */ 
/* 219 */     MedicineJbForm cineZbForm = (MedicineJbForm)form;
/* 220 */     getCineJbServices().setRequest(request);
/* 221 */     Map map = Operate.describe(cineZbForm);
/* 222 */     map.put("beginDate", beginDate);
/* 223 */     List reslutList = getCineJbServices().tqjb(map);
/* 224 */     request.setAttribute("beginDate", beginDate);
/* 225 */     request.setAttribute("reslutList", reslutList);
/* 226 */     return mapping.findForward("tqjb");
/*     */   }
/*     */ 
/*     */   public ActionForward sureJB(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */     throws Exception
/*     */   {
/* 233 */     String beginDate = request.getParameter("beginDate");
/*     */ 
/* 236 */     MedicineJbForm cineJbForm = (MedicineJbForm)form;
/* 237 */     String[] ids = cineJbForm.getSelectNos();
/* 238 */     for (String id : ids) {
/* 239 */       String[] a = id.split(",");
/* 240 */       getCineJbServices().setRequest(request);
/* 241 */       Map map = Operate.describe(cineJbForm);
/* 242 */       map.put("jbId", a[0]);
/* 243 */       map.put("cgId", a[1]);
/*     */ 
/* 245 */       getCineCgServices().updateCgJB(map);
/*     */ 
/* 247 */       getCineJbServices().updateJbJB(map);
/*     */     }
/* 249 */     request.setAttribute("exception.message", "截标成功！");
/* 250 */     request.setAttribute("beginDate", beginDate);
/*     */ 
/* 252 */     return Tqjb(mapping, form, request, response);
/*     */   }
/*     */ 
/*     */   public ActionForward judeJB(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */     throws Exception
/*     */   {
/* 259 */     String endDate = request.getParameter("endDate");
/* 260 */     String jbId = request.getParameter("jbId");
/* 261 */     MedicineJbBO jbBO = new MedicineJbBO();
/* 262 */     jbBO.setEndDate(endDate);
/* 263 */     jbBO.setJbId(Integer.valueOf(jbId));
/*     */ 
/* 265 */     MedicineJbBO cineJbBO = getCineJbServices().judeJB(jbBO);
/* 266 */     if (cineJbBO == null) {
/* 267 */       response.getWriter().println(0);
/* 268 */       return null;
/*     */     }
/* 270 */     response.getWriter().println(1);
/* 271 */     return null;
/*     */   }
/*     */ }

/* Location:           D:\李慧医药项目\tcmages\krt\WEB-INF\classes\
 * Qualified Name:     cn.krt.zbcg.system.web.action.MedicineJbAction
 * JD-Core Version:    0.6.2
 */