/*     */ package cn.krt.zbcg.system.services.impl;
/*     */ 
/*     */ import cn.krt.zbcg.commons.bo.system.CustomerBO;
/*     */ import cn.krt.zbcg.commons.bo.system.MedicineBO;
/*     */ import cn.krt.zbcg.commons.bo.system.MedicineCgBO;
/*     */ import cn.krt.zbcg.commons.bo.system.MedicineJbBO;
/*     */ import cn.krt.zbcg.system.dao.ICustomerDAO;
/*     */ import cn.krt.zbcg.system.dao.IMedicineCgDAO;
/*     */ import cn.krt.zbcg.system.dao.IMedicineDAO;
/*     */ import cn.krt.zbcg.system.dao.IMedicineJbDAO;
/*     */ import cn.krt.zbcg.system.services.IMedicineCgServices;
/*     */ import java.io.BufferedReader;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.InputStreamReader;
/*     */ import java.io.OutputStream;
/*     */ import java.net.HttpURLConnection;
/*     */ import java.net.URL;
/*     */ import java.net.URLConnection;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ import org.apache.commons.lang.exception.ExceptionUtils;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.ssi.common.PageInfo;
/*     */ import org.ssi.common.UrlConfig;
/*     */ import org.ssi.services.impl.ServiceImpl;
/*     */ 
/*     */ public class MedicineCgServicesImpl extends ServiceImpl
/*     */   implements IMedicineCgServices
/*     */ {
/*  34 */   protected Log logger = LogFactory.getLog(getClass());
/*     */   private IMedicineCgDAO cineCgDAO;
/*     */   private IMedicineJbDAO cineJbDAO;
/*     */   private IMedicineDAO medicineDAO;
/*     */   private ICustomerDAO customerDAO;
/*     */ 
/*     */   public ICustomerDAO getCustomerDAO()
/*     */   {
/*  46 */     return this.customerDAO;
/*     */   }
/*     */ 
/*     */   public void setCustomerDAO(ICustomerDAO customerDAO)
/*     */   {
/*  51 */     this.customerDAO = customerDAO;
/*     */   }
/*     */ 
/*     */   public IMedicineDAO getMedicineDAO()
/*     */   {
/*  56 */     return this.medicineDAO;
/*     */   }
/*     */ 
/*     */   public void setMedicineDAO(IMedicineDAO medicineDAO)
/*     */   {
/*  61 */     this.medicineDAO = medicineDAO;
/*     */   }
/*     */ 
/*     */   public IMedicineJbDAO getCineJbDAO() {
/*  65 */     return this.cineJbDAO;
/*     */   }
/*     */ 
/*     */   public void setCineJbDAO(IMedicineJbDAO cineJbDAO) {
/*  69 */     this.cineJbDAO = cineJbDAO;
/*     */   }
/*     */ 
/*     */   public IMedicineCgDAO getCineCgDAO()
/*     */   {
/*  74 */     return this.cineCgDAO;
/*     */   }
/*     */ 
/*     */   public void setCineCgDAO(IMedicineCgDAO cineCgDAO)
/*     */   {
/*  79 */     this.cineCgDAO = cineCgDAO;
/*     */   }
/*     */ 
/*     */   public void insert(MedicineCgBO record)
/*     */   {
/*     */     try
/*     */     {
/*  90 */       this.cineCgDAO.insert(record);
/*     */     }
/*     */     catch (Exception e) {
/*  93 */       ExceptionUtils.getFullStackTrace(e);
/*     */     }
/*     */   }
/*     */ 
/*     */   public int update(MedicineCgBO record)
/*     */   {
/* 104 */     int rows = 0;
/*     */     try {
/* 106 */       rows = this.cineCgDAO.update(record);
/*     */     }
/*     */     catch (Exception e) {
/* 109 */       ExceptionUtils.getFullStackTrace(e);
/*     */     }
/* 111 */     return rows;
/*     */   }
/*     */ 
/*     */   public List findAll(PageInfo pageInfo)
/*     */   {
/* 121 */     this.pageInfo = pageInfo;
/* 122 */     Map map = new HashMap();
/* 123 */     List list = findAll(pageInfo, map);
/* 124 */     return list;
/*     */   }
/*     */ 
/*     */   public List findAll(PageInfo pageInfo, Map map)
/*     */   {
/* 134 */     this.pageInfo = pageInfo;
/* 135 */     List list = queryListByPage(map);
/* 136 */     return list;
/*     */   }
/*     */ 
/*     */   public List queryListByPage(Object obj)
/*     */   {
/* 146 */     this.pageInfo = this.pageInfo;
/* 147 */     Map map = new HashMap();
/*     */ 
/* 149 */     List list = null;
/*     */ 
/* 151 */     setPublicParams((Map)obj);
/* 152 */     this.logger.debug("��ѯ��" + (this.pageInfo != null ? this.pageInfo.getPageNum() : 0) + "ҳ���");
/*     */ 
/* 154 */     list = this.cineCgDAO.selectAll(obj);
/* 155 */     this.logger.debug("list.size(befor reset)=" + (list != null ? Integer.valueOf(list.size()) : ""));
/*     */ 
/* 157 */     if ((list == null) || (list.size() == 0))
/*     */     {
/* 159 */       if ((this.pageInfo != null) && (this.pageInfo.getPageNum() > 0))
/*     */       {
/* 161 */         setPublicParams((Map)obj, true);
/* 162 */         list = this.cineCgDAO.selectAll(obj);
/* 163 */         this.logger.debug("list.size(befor reset)=" + (list != null ? Integer.valueOf(list.size()) : ""));
/*     */       }
/*     */     }
/*     */ 
/* 167 */     Object o = this.cineCgDAO.selectAllOfCount(obj);
/* 168 */     if (o != null)
/*     */     {
/* 170 */       this.logger.debug("���=" + o.toString());
/* 171 */       this.pageInfo.setTotalSize(Integer.parseInt(o.toString()));
/*     */     }
/* 173 */     return list;
/*     */   }
/*     */ 
/*     */   public MedicineCgBO findById(Integer cgId)
/*     */   {
/* 183 */     MedicineCgBO key = new MedicineCgBO();
/* 184 */     key.setCgId(cgId);
/* 185 */     MedicineCgBO record = (MedicineCgBO)this.cineCgDAO.queryData(key);
/* 186 */     return record;
/*     */   }
/*     */ 
/*     */   public int delete(MedicineCgBO record)
/*     */   {
/* 196 */     int rows = 0;
/*     */     try {
/* 198 */       rows = this.cineCgDAO.delete(record);
/*     */     }
/*     */     catch (Exception e) {
/* 201 */       ExceptionUtils.getFullStackTrace(e);
/*     */     }
/* 203 */     return rows;
/*     */   }
/*     */ 
/*     */   public int delete(String[] ids)
/*     */   {
/* 213 */     int rows = 0;
/* 214 */     MedicineCgBO key = new MedicineCgBO();
/*     */     try {
/* 216 */       int i = 0;
/*     */       do { key.setCgId(Integer.valueOf(ids[i]));
/* 218 */         rows += this.cineCgDAO.delete(key);
/*     */ 
/* 216 */         i++; if (ids == null) break;  } while (i < ids.length);
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 223 */       ExceptionUtils.getFullStackTrace(e);
/*     */     }
/* 225 */     return rows;
/*     */   }
/*     */ 
/*     */   public void addCG(Map map) throws Exception {
/* 229 */     this.cineCgDAO.addCG(map);
/*     */   }
/*     */ 
/*     */   public List getTops(Map map)
/*     */     throws Exception
/*     */   {
/* 239 */     List list = null;
/*     */ 
/* 274 */     list = this.cineJbDAO.isTops(map);
/*     */ 
/* 282 */     return list;
/*     */   }
/*     */ 
/*     */   public void resetGetTops()
/*     */     throws Exception
/*     */   {
/* 291 */     Map map = new HashMap();
/* 292 */     Map maps = new HashMap();
/* 293 */     Map mapus = new HashMap();
/* 294 */     List list = null;
/* 295 */     List allList = this.medicineDAO.all();
/* 296 */     for (int j = 0; j < allList.size(); j++) {
/* 297 */       MedicineBO BO = (MedicineBO)allList.get(j);
/* 298 */       map.put("medicineId", BO.getMedicineId());
/*     */ 
/* 300 */       list = this.cineJbDAO.resetGetTops(map);
/*     */ 
/* 302 */       for (int i = 0; i < list.size(); i++) {
/* 303 */         MedicineJbBO jbBO = (MedicineJbBO)list.get(i);
/* 304 */         maps.put("jbId", jbBO.getJbId());
/* 305 */         maps.put("endDate", jbBO.getEndDate());
/*     */ 
/* 307 */         this.cineJbDAO.updateTopsUp(maps);
/*     */ 
/* 309 */         mapus.put("medicineCode", jbBO.getMedicineCgBO().getMedicineId() + jbBO.getBeginDate().replace("-", "") + (i + 1));
/* 310 */         mapus.put("jbId", jbBO.getJbId());
/*     */ 
/* 312 */         this.cineJbDAO.updateMedicineCode(mapus);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public void updateTops(String[] ids) throws Exception
/*     */   {
/* 319 */     Map map = new HashMap();
/* 320 */     for (String jbId : ids) {
/* 321 */       map.put("jbId", jbId);
/* 322 */       this.cineJbDAO.updateTopsUp(map);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void updateCgJB(Map map) {
/* 327 */     this.cineCgDAO.updateCgJB(map);
/*     */   }
/*     */   public String GetNowDate() {
/* 330 */     String temp_str = "";
/* 331 */     Date dt = new Date();
/* 332 */     SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
/* 333 */     temp_str = sf.format(dt);
/* 334 */     return temp_str;
/*     */   }
/*     */ 
/*     */   public void startTender()
/*     */     throws Exception
/*     */   {
/* 342 */     StringBuilder sb = new StringBuilder();
/* 343 */     String telephone = "";
/* 344 */     List list = this.cineJbDAO.startTender();
/*     */     try {
/* 346 */       if ((list != null) && (list.size() > 0))
/*     */       {
/* 348 */         Map map = (Map)list.get(0);
/* 349 */         String beginYear = String.valueOf(map.get("begin_date")).substring(0, 4);
/* 350 */         String beginMonth = String.valueOf(map.get("begin_date")).substring(5, 7);
/* 351 */         String beginDay = String.valueOf(map.get("begin_date")).substring(8, 10);
/* 352 */         String endYear = String.valueOf(map.get("end_date")).substring(0, 4);
/* 353 */         String endMonth = String.valueOf(map.get("end_date")).substring(5, 7);
/* 354 */         String endDay = String.valueOf(map.get("end_date")).substring(8, 10);
/* 355 */         List customerList = this.customerDAO.selectAllCustomer();
/* 356 */         if ((customerList != null) && (customerList.size() > 0))
/*     */         {
/* 358 */           for (int i = 0; i < customerList.size(); i++)
/*     */           {
/* 360 */             CustomerBO customer = (CustomerBO)customerList.get(i);
/* 361 */             sb.append(String.valueOf(customer.getTelephone())).append(",");
/*     */           }
/*     */ 
/* 364 */           telephone = sb.delete(sb.length() - 1, sb.length()).toString();
/*     */         }
/* 366 */         startTenderB(beginYear, beginMonth, beginDay, endYear, endMonth, endDay, telephone);
/*     */       }
/*     */     } catch (Exception e) {
/* 369 */       e.printStackTrace();
/* 370 */       this.logger.info("发送短信失败,请联系管理员!");
/*     */     }
/*     */   }
/*     */ 
/*     */   public String startTenderB(String beginYear, String beginMonth, String beginDay, String endYear, String endMonth, String endDay, String telephone)
/*     */     throws Exception
/*     */   {
/* 378 */     String result = "";
/* 379 */     String soapAction = "http://tempuri.org/mt";
/* 380 */     String xml = "<?xml version=\"1.0\" encoding=\"utf-8\"?>";
/* 381 */     xml = xml + "<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">";
/* 382 */     xml = xml + "<soap:Body>";
/* 383 */     xml = xml + "<mt xmlns=\"http://tempuri.org/\">";
/* 384 */     xml = xml + "<Sn>" + UrlConfig.getInstance().get("sn") + "</Sn>";
/* 385 */     xml = xml + "<Pwd>" + UrlConfig.getInstance().get("pwd") + "</Pwd>";
/* 386 */     xml = xml + "<mobile>" + telephone + "</mobile>";
/*     */ 
/* 388 */     xml = xml + "<content>" + String.format(new String(UrlConfig.getInstance().get("preMsg").getBytes("iso8859-1"), "utf-8"), new Object[] { beginYear, beginMonth, beginDay, endYear, endMonth, endDay }) + "</content>";
/*     */ 
/* 390 */     xml = xml + "</mt>";
/* 391 */     xml = xml + "</soap:Body>";
/* 392 */     xml = xml + "</soap:Envelope>";
/*     */     try
/*     */     {
/* 396 */       URL url = new URL(UrlConfig.getInstance().get("serviceURL"));
/*     */ 
/* 398 */       URLConnection connection = url.openConnection();
/* 399 */       HttpURLConnection httpconn = (HttpURLConnection)connection;
/* 400 */       ByteArrayOutputStream bout = new ByteArrayOutputStream();
/* 401 */       bout.write(xml.getBytes());
/* 402 */       byte[] b = bout.toByteArray();
/* 403 */       httpconn.setRequestProperty("Content-Length", String.valueOf(b.length));
/* 404 */       httpconn.setRequestProperty("Content-Type", "text/xml; charset=gb2312");
/* 405 */       httpconn.setRequestProperty("SOAPAction", soapAction);
/* 406 */       httpconn.setRequestMethod("POST");
/* 407 */       httpconn.setDoInput(true);
/* 408 */       httpconn.setDoOutput(true);
/*     */ 
/* 410 */       OutputStream out = httpconn.getOutputStream();
/* 411 */       out.write(b);
/* 412 */       out.close();
/*     */ 
/* 414 */       InputStreamReader isr = new InputStreamReader(httpconn.getInputStream());
/* 415 */       BufferedReader in = new BufferedReader(isr);
/*     */       Matcher matcher;
/*     */       String inputLine;
				while ((inputLine = in.readLine()) != null) {
					Pattern pattern = Pattern.compile("<mtResult>(.*)</mtResult>");
					matcher = pattern.matcher(inputLine);
					while (matcher.find()) {
					result = matcher.group(1);
					}
				}
/*     */ 
/* 424 */       return result;
/*     */     } catch (Exception e) {
/* 426 */       e.printStackTrace();
/* 427 */     }return "";
/*     */   }
/*     */ 
/*     */   public void endTender()
/*     */     throws Exception
/*     */   {
/* 436 */     StringBuilder sb = new StringBuilder();
/* 437 */     String telephone = "";
/* 438 */     List list = this.cineJbDAO.endTender();
/*     */     try {
/* 440 */       if ((list != null) && (list.size() > 0))
/*     */       {
/* 442 */         Map map = (Map)list.get(0);
/* 443 */         String endYear = String.valueOf(map.get("end_date")).substring(0, 4);
/* 444 */         String endMonth = String.valueOf(map.get("end_date")).substring(5, 7);
/* 445 */         String endDay = String.valueOf(map.get("end_date")).substring(8, 10);
/* 446 */         List customerList = this.customerDAO.selectAllCustomer();
/* 447 */         if ((customerList != null) && (customerList.size() > 0))
/*     */         {
/* 449 */           for (int i = 0; i < customerList.size(); i++)
/*     */           {
/* 451 */             CustomerBO customer = (CustomerBO)customerList.get(i);
/* 452 */             sb.append(String.valueOf(customer.getTelephone())).append(",");
/*     */           }
/* 454 */           telephone = sb.delete(sb.length() - 1, sb.length()).toString();
/*     */         }
/*     */ 
/* 458 */         endTenderF(endYear, endMonth, endDay, telephone);
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/* 462 */       this.logger.info("发送短信失败,请联系管理员!");
/*     */     }
/*     */   }
/*     */ 
/*     */   public String endTenderF(String endYear, String endMonth, String endDay, String telephone)
/*     */     throws Exception
/*     */   {
/* 470 */     String result = "";
/* 471 */     String soapAction = "http://tempuri.org/mt";
/* 472 */     String xml = "<?xml version=\"1.0\" encoding=\"utf-8\"?>";
/* 473 */     xml = xml + "<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">";
/* 474 */     xml = xml + "<soap:Body>";
/* 475 */     xml = xml + "<mt xmlns=\"http://tempuri.org/\">";
/* 476 */     xml = xml + "<Sn>" + UrlConfig.getInstance().get("sn") + "</Sn>";
/* 477 */     xml = xml + "<Pwd>" + UrlConfig.getInstance().get("pwd") + "</Pwd>";
/* 478 */     xml = xml + "<mobile>" + telephone + "</mobile>";
/*     */ 
/* 480 */     xml = xml + "<content>" + String.format(new String(UrlConfig.getInstance().get("finMsg").getBytes("iso8859-1"), "utf-8"), new Object[] { endYear, endMonth, endDay }) + "</content>";
/*     */ 
/* 482 */     xml = xml + "</mt>";
/* 483 */     xml = xml + "</soap:Body>";
/* 484 */     xml = xml + "</soap:Envelope>";
/*     */     try
/*     */     {
/* 488 */       URL url = new URL(UrlConfig.getInstance().get("serviceURL"));
/*     */ 
/* 490 */       URLConnection connection = url.openConnection();
/* 491 */       HttpURLConnection httpconn = (HttpURLConnection)connection;
/* 492 */       ByteArrayOutputStream bout = new ByteArrayOutputStream();
/* 493 */       bout.write(xml.getBytes());
/* 494 */       byte[] b = bout.toByteArray();
/* 495 */       httpconn.setRequestProperty("Content-Length", String.valueOf(b.length));
/* 496 */       httpconn.setRequestProperty("Content-Type", "text/xml; charset=gb2312");
/* 497 */       httpconn.setRequestProperty("SOAPAction", soapAction);
/* 498 */       httpconn.setRequestMethod("POST");
/* 499 */       httpconn.setDoInput(true);
/* 500 */       httpconn.setDoOutput(true);
/*     */ 
/* 502 */       OutputStream out = httpconn.getOutputStream();
/* 503 */       out.write(b);
/* 504 */       out.close();
/*     */ 
/* 506 */       InputStreamReader isr = new InputStreamReader(httpconn.getInputStream());
/* 507 */       BufferedReader in = new BufferedReader(isr);
/*     */       Matcher matcher;
/*     */       String inputLine;
/* 509 */       for (; (inputLine = in.readLine()) != null; 
/* 512 */         matcher.find())
/*     */       {
/* 510 */         Pattern pattern = Pattern.compile("<mtResult>(.*)</mtResult>");
/* 511 */         matcher = pattern.matcher(inputLine);
/* 513 */         result = matcher.group(1);
/*     */       }
/*     */ 
/* 516 */       return result;
/*     */     } catch (Exception e) {
/* 518 */       e.printStackTrace();
/* 519 */     }return "";
/*     */   }
/*     */ }

/* Location:           D:\李慧医药项目\tcmages\krt\WEB-INF\classes\
 * Qualified Name:     cn.krt.zbcg.system.services.impl.MedicineCgServicesImpl
 * JD-Core Version:    0.6.2
 */