/*     */ package cn.krt.zbcg.system.web.action;
/*     */ 
/*     */ import cn.krt.zbcg.commons.bo.system.MedicineBO;
/*     */ import cn.krt.zbcg.system.services.IMedicineServices;
/*     */ import cn.krt.zbcg.system.web.form.MedicineForm;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/*     */ import org.ssi.common.MD5;

/*     */ import java.util.List;
/*     */ import java.util.Map;
import java.util.Random;

/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;

/*     */ import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.struts.action.ActionForm;
/*     */ import org.apache.struts.action.ActionForward;
/*     */ import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;
/*     */ import org.ssi.common.Operate;
/*     */ import org.ssi.common.PageInfo;
/*     */ import org.ssi.struts.action.SSIDispatchAction;
/*     */ 
/*     */ public class MedicineAction extends SSIDispatchAction
/*     */ {
/*     */   private IMedicineServices medicineServices;
/*     */ 
/*     */   private IMedicineServices getMedicineServices()
/*     */   {
/*  36 */     if (this.medicineServices == null) {
/*  37 */       this.medicineServices = ((IMedicineServices)getBean("medicineServices"));
/*     */     }
/*  39 */     return this.medicineServices;
/*     */   }
/*     */ 

			public String getVistorPath(HttpServletRequest request,String file){
				String result = "";
				if(file!=null && !file.equals("")){
					 String path = request.getContextPath();   
					  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; 
					  String dir=basePath+"/uploadfiles/"; 
					  Random random=new Random();
					 String version = "?v=" +random.nextInt();
					  result = dir+file+version;
				}
				return result;
			}

			public void processImagePath(HttpServletRequest request,List medicineList){
				if(medicineList!=null){
					 String path = request.getContextPath();   
					  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; 
					  String dir=basePath+"/uploadfiles/"; 
					for(Object mbo:medicineList){
						MedicineBO bo = (MedicineBO) mbo;
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
					
				}
				
			}

/*     */   public ActionForward list(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */     throws Exception
/*     */   {
/*  51 */     MedicineForm medicineForm = (MedicineForm)form;
/*  52 */     String medicineName = medicineForm.getMedicineName();
/*  53 */     PageInfo pageInfo = new PageInfo();
/*  54 */     getMedicineServices().setRequest(request);
/*  55 */     Map map = Operate.describe(medicineForm);
/*  56 */     map.put(medicineName, medicineName);

			 
/*  57 */     List medicineList = getMedicineServices().findAll(pageInfo, map);
				processImagePath(request,medicineList);
				request.setAttribute("medicineList", medicineList);
/*  59 */     request.setAttribute("pageInfo", pageInfo);
/*     */ 
/*  61 */     return mapping.findForward("medicineList");
/*     */   }
/*     */ 
/*     */   public ActionForward toAdd(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */     throws Exception
/*     */   {
/*  73 */     return mapping.findForward("toAdd");
/*     */   }


			public ActionForward add(ActionMapping mapping, ActionForm form,
					HttpServletRequest request, HttpServletResponse response)
					throws Exception {
				MedicineForm cineForm = (MedicineForm) form;
				MedicineBO cineBO = cineForm.getMedicineBO();
				FormFile file = cineBO.getMedicineImage();
				if(file!=null ){
					String md5Str = new MD5().getMD5ofStr(cineBO.getMedicineName());
					String fname = getFileName(file,md5Str);
					cineBO.setMedicineimagefilename(fname);
					upload(request,file,fname);
				}
			
				try {
					getMedicineServices().insert(cineBO);
				} catch (Exception e) {
					ExceptionUtils.getFullStackTrace(e);
				}
				return list(mapping, form, request, response);
			}



			public void upload(HttpServletRequest request,FormFile file,String fname) throws IOException{
				  String dir=request.getSession().getServletContext().getRealPath("")+"/uploadfiles/"; 
				  if(fname==null || fname.equals("")){
					  file.destroy();
					  return;
				  }
				  String size=Integer.toString(file.getFileSize())+"bytes";
				  InputStream streamIn=file.getInputStream();
				  OutputStream streamOut=new FileOutputStream(dir+"/"+fname);
				  int bytesRead=0;
				  byte[] buffer=new byte[8192];
				  while((bytesRead=streamIn.read(buffer,0,8192))!=-1){
				   streamOut.write(buffer,0,bytesRead);
				  }
				  streamOut.close();
				  streamIn.close();
				  file.destroy();
			}

/*     */ 
/*     */   public ActionForward toUpdate(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */     throws Exception
/*     */   {
	
				
/* 104 */     MedicineForm cineForm = (MedicineForm)form;
/* 105 */     String id = cineForm.getSelectNos()[0];
/* 106 */     MedicineBO cineBO = getMedicineServices().findById(Integer.valueOf(id));

				 
				cineBO.setMedicineVistorimagePath(getVistorPath(request,cineBO.getMedicineimagefilename()));
				cineForm.setMedicineBO(cineBO);
/* 108 */     return mapping.findForward("toUpdate");
/*     */   }

			public String getFileName(FormFile file,String id){
				String result = "";
				if(file.getFileName().split("\\.").length==2){
					String type = file.getFileName().split("\\.")[1];
					result  = "medicine"+id+"."+type;
				}
				return result;
			}

/*     */   public ActionForward update(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */     throws Exception
/*     */   {
/* 120 */     MedicineForm cineForm = (MedicineForm)form;
/* 121 */     MedicineBO cineBO = cineForm.getMedicineBO();
				FormFile file = cineBO.getMedicineImage();
				String filechanged = cineForm.getFilechanged();
				if(filechanged!=null && !filechanged.equals("")){
					String md5Str = new MD5().getMD5ofStr(cineBO.getMedicineName());
					String fname = getFileName(file,md5Str);
					if(file!=null ){
						cineBO.setMedicineimagefilename(fname);
					}
					upload(request,file,fname);
				}
/*     */     try {
/* 123 */       getMedicineServices().update(cineBO);
/*     */     } catch (Exception e) {
/* 125 */       ExceptionUtils.getFullStackTrace(e);
/*     */     }
/* 127 */     return list(mapping, form, request, response);
/*     */   }
/*     */ 
/*     */   public ActionForward toDelete(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */     throws Exception
/*     */   {
/* 139 */     MedicineForm cineForm = (MedicineForm)form;
/* 140 */     String[] ids = cineForm.getSelectNos();
/*     */     try {
/* 142 */       getMedicineServices().delete(ids);
/*     */     } catch (Exception localException) {
/*     */     }
/* 145 */     return list(mapping, form, request, response);
/*     */   }
/*     */ 
/*     */   public ActionForward toDetail(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */     throws Exception
/*     */   {
/* 157 */     if (log.isDebugEnabled()) {
/* 158 */       log.debug("get actionForm object.");
/*     */     }
/* 160 */     MedicineForm cineForm = (MedicineForm)form;
/* 161 */     String id = cineForm.getSelectNos()[0];
/* 162 */     if (log.isDebugEnabled()) {
/* 163 */       log.debug("get data detail by id=" + id + ".");
/*     */     }
/* 165 */     MedicineBO cineBO = getMedicineServices().findById(Integer.valueOf(id));
/* 166 */     if (log.isDebugEnabled()) {
/* 167 */       log.debug("set business object.");
/*     */     }
/* 169 */     cineForm.setMedicineBO(cineBO);
/* 170 */     return mapping.findForward("toDetail");
/*     */   }
/*     */ 
/*     */   public ActionForward windowlist(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */     throws Exception
/*     */   {
/* 177 */     MedicineForm medicineForm = (MedicineForm)form;
/* 178 */     String medicineName = medicineForm.getMedicineName();
/* 179 */     String beginDate = medicineForm.getBeginDate();
/* 180 */     String endDate = medicineForm.getEndDate();
/* 181 */     PageInfo pageInfo = new PageInfo();
/* 182 */     getMedicineServices().setRequest(request);
/* 183 */     Map map = Operate.describe(medicineForm);
/* 184 */     map.put(medicineName, medicineName);
/* 185 */     map.put("beginDate", beginDate);
/* 186 */     map.put("endDate", endDate);
/* 187 */     List medicineList = getMedicineServices().findAlls(pageInfo, map);
			  processImagePath(request,medicineList);
/* 188 */     request.setAttribute("medicineList", medicineList);
/* 189 */     request.setAttribute("pageInfo", pageInfo);
/* 190 */     request.setAttribute("beginDate", beginDate);
/* 191 */     request.setAttribute("endDate", endDate);
/* 192 */     return mapping.findForward("medicineWindowList");
/*     */   }
/*     */ 
/*     */   public ActionForward medicineWindowForCg(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */     throws Exception
/*     */   {
/* 198 */     MedicineForm medicineForm = (MedicineForm)form;
/* 199 */     String medicineName = medicineForm.getMedicineName();
/*     */ 
/* 201 */     PageInfo pageInfo = new PageInfo();
/* 202 */     getMedicineServices().setRequest(request);
/* 203 */     Map map = Operate.describe(medicineForm);
/* 204 */     map.put(medicineName, medicineName);
/*     */ 
/* 206 */     List medicineList = getMedicineServices().findAll(pageInfo, map);

			processImagePath(request,medicineList);
/* 207 */     request.setAttribute("medicineList", medicineList);
/* 208 */     request.setAttribute("pageInfo", pageInfo);
/*     */ 
/* 210 */     return mapping.findForward("medicineWindowForCg");
/*     */   }
/*     */ }

/* Location:           D:\李慧医药项目\tcmages\krt\WEB-INF\classes\
 * Qualified Name:     cn.krt.zbcg.system.web.action.MedicineAction
 * JD-Core Version:    0.6.2
 */