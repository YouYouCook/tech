/*     */ package org.ssi.tag;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.jsp.JspWriter;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.ssi.common.PageInfo;
/*     */ 
/*     */ public class PageTag extends SSITag
/*     */ {
/*     */   private static final long serialVersionUID = 3957478781155271259L;
/*  23 */   private String property = null;
/*     */ 
/*  25 */   private String cssPath = null;
/*     */ 
/*  27 */   private String action = null;
/*     */ 
/*  29 */   private int formIndex = 0;
/*     */ 
/*  31 */   private String imgPath = null;
/*     */ 
/*  33 */   private static PageInfo defaultPage = new PageInfo();
/*     */ 
/*     */   public int getFormIndex()
/*     */   {
/*  38 */     return this.formIndex;
/*     */   }
/*     */ 
/*     */   public void setFormIndex(int formIndex)
/*     */   {
/*  45 */     this.formIndex = formIndex;
/*     */   }
/*     */ 
/*     */   public String getCssPath()
/*     */   {
/*  52 */     return this.cssPath;
/*     */   }
/*     */ 
/*     */   public String getAction()
/*     */   {
/*  59 */     return this.action;
/*     */   }
/*     */ 
/*     */   public void setCssPath(String cssPath)
/*     */   {
/*  66 */     this.cssPath = cssPath;
/*     */   }
/*     */ 
/*     */   public void setAction(String action)
/*     */   {
/*  73 */     this.action = action;
/*     */   }
/*     */ 
/*     */   protected int doEndEntity()
/*     */   {
/*  79 */     if ((this.property != null) && (!"".equals(this.property)))
/*     */     {
/*  82 */       Object o = this.request.getAttribute(this.property);
/*  83 */       PageInfo pageInfo = null;
/*  84 */       if (o != null)
/*     */       {
/*  86 */         pageInfo = (PageInfo)o;
/*     */       }
/*  88 */       if (pageInfo != null)
/*     */       {
/*     */         try
/*     */         {
/*  92 */           if ((this.cssPath != null) && (!"".equals(this.cssPath)))
/*     */           {
/*  94 */             this.out.println("<link rel=\"styleshee\" href=\"" + this.path + this.cssPath + "\" type=\"text/css\">");
/*     */           }
/*  96 */           this.out.println("<table width=\"96%\" border=\"0\" cellpadding=\"3\" cellspacing=\"0\"><tr><td><div align=\"right\">");
/*     */ 
/*  98 */           this.out.println("<input type=\"hidden\" name=\"totalPageNum\" value=\"" + pageInfo.getTotalPageNum() + "\" >");
/*  99 */           this.out.println("<a href=\"javascript:doFirst()\">首页</a> | ");
/* 100 */           this.out.println("<a href=\"javascript:doPrevious()\">上一页</a> ");
/* 101 */           this.out.println("| 第");
/* 102 */           if (pageInfo.getTotalPageNum() == 0)
/*     */           {
/* 104 */             this.out.println("0");
/*     */           }
/*     */           else
/*     */           {
/* 108 */             this.out.println(pageInfo.getPageNum());
/*     */           }
/* 110 */           this.out.println("/" + pageInfo.getTotalPageNum());
/* 111 */           this.out.println("<a href=\"javascript:doNext()\">下一页</a> | <a href=\"javascript:doLast()\">末页</a> ");
/*     */ 
/* 113 */           this.out.println("| 共" + pageInfo.getTotalSize() + "条 |  ");
/* 114 */           this.out.println("<input type=\"text\"  disabled name=\"pageSize\" title=\"请输入大于0的数字,输入其它字符将被转换为默认值（" + defaultPage.getPageSize() + "）\" onchange=\"pageNum.value=1;\"" + 
/* 115 */             " value=\"" + pageInfo.getPageSize() + "\" " + 
/* 116 */             "class=\"text\" size=\"3\" maxlength=\"3\" onblur=\"disFocus()\"  " + 
/* 117 */             "onkeydown=\"javascript:return doRowByOnKeyDown();\"/>");
/* 118 */           this.out.println("条 ");
/*     */ 
/* 128 */           this.out.println(" | 转到第 <select name=\"pageNum\" onchange=\"dojump()\" value=\"" + pageInfo.getPageNum() + "\">");
/*     */ 
/* 130 */           for (int i = 1; i <= pageInfo.getTotalPageNum(); i++)
/*     */           {
/* 132 */             if (i == pageInfo.getPageNum())
/*     */             {
/* 134 */               this.out.println("<option value=\"" + i + "\" selected>" + i + "</option>");
/*     */             }
/*     */             else
/*     */             {
/* 138 */               this.out.println("<option value=\"" + i + "\">" + i + "</option>");
/*     */             }
/*     */           }
/* 141 */           this.out.println("</select>页");
/* 142 */           this.out.println("</div></td></tr></table>");
/*     */ 
/* 145 */           this.out.println("<script language=\"javascript\">");
/*     */ 
/* 147 */           this.out.println("var listForm = document.forms[" + this.formIndex + "];");
/* 148 */           this.out.println("function disFocus()");
/* 149 */           this.out.println("{");
/* 150 */           this.out.println("if (Trim(listForm.elements[\"pageSize\"].value)=='')");
/* 151 */           this.out.println("{");
/* 152 */           this.out.println("\tlistForm.elements[\"pageSize\"].value=" + defaultPage.getPageSize() + ";");
/* 153 */           this.out.println("\tlistForm.elements[\"pageSize\"].focus();");
/* 154 */           this.out.println("listForm.elements[\"pageSize\"].select();");
/* 155 */           this.out.println("return true;");
/* 156 */           this.out.println("}");
/* 157 */           this.out.println("if (isNaN(listForm.elements[\"pageSize\"].value))");
/* 158 */           this.out.println("{");
/* 159 */           this.out.println("listForm.elements[\"pageSize\"].value=" + defaultPage.getPageSize() + ";");
/* 160 */           this.out.println("listForm.elements[\"pageSize\"].focus();");
/* 161 */           this.out.println("listForm.elements[\"pageSize\"].select();");
/* 162 */           this.out.println("return true;");
/* 163 */           this.out.println("}");
/* 164 */           this.out.println("else");
/* 165 */           this.out.println("{");
/* 166 */           this.out.println("if(parseInt(listForm.elements[\"pageSize\"].value) <= 0)");
/* 167 */           this.out.println("{");
/* 168 */           this.out.println("listForm.elements[\"pageSize\"].value=" + defaultPage.getPageSize() + ";");
/* 169 */           this.out.println("listForm.elements[\"pageSize\"].focus();");
/* 170 */           this.out.println("listForm.elements[\"pageSize\"].select();");
/* 171 */           this.out.println("return true;");
/* 172 */           this.out.println("}");
/* 173 */           this.out.println("}");
/* 174 */           this.out.println("}");
/*     */ 
/* 176 */           this.out.println("function doPrevious()");
/* 177 */           this.out.println("{\tif(isEmpty()) return;");
/* 178 */           this.out.println("if (listForm.elements[\"pageNum\"].value <= 1)");
/* 179 */           this.out.println("{");
/* 180 */           this.out.println("alert(\"已经是第一页了\");");
/* 181 */           this.out.println("return;");
/* 182 */           this.out.println("}");
/* 183 */           this.out.println("listForm.elements[\"pageNum\"].value --;");
/* 184 */           this.out.println("showhelp();");
/* 185 */           if ((this.action != null) && (!"".equals(this.action)))
/*     */           {
/* 187 */             this.out.println("listForm.action = \"" + this.path + this.action + "\";");
/*     */           }
/* 189 */           this.out.println("listForm.submit();");
/* 190 */           this.out.println("}");
/*     */ 
/* 192 */           this.out.println("function doFirst()");
/* 193 */           this.out.println("{\tif(isEmpty()) return;");
/* 194 */           this.out.println("\tif (listForm.elements[\"pageNum\"].value <= 1)");
/* 195 */           this.out.println("\t{");
/* 196 */           this.out.println("\t\talert(\"已经是第一页了\");");
/* 197 */           this.out.println("\t\treturn;");
/* 198 */           this.out.println("\t}");
/* 199 */           this.out.println("\tlistForm.elements[\"pageNum\"].value = 1;");
/* 200 */           this.out.println("\tshowhelp();");
/* 201 */           if ((this.action != null) && (!"".equals(this.action)))
/*     */           {
/* 203 */             this.out.println("listForm.action = \"" + this.path + this.action + "\";");
/*     */           }
/* 205 */           this.out.println("listForm.submit();");
/* 206 */           this.out.println("}");
/*     */ 
/* 208 */           this.out.println("function doNext()");
/* 209 */           this.out.println("{");
/* 210 */           this.out.println("if(isEmpty()) return;");
/* 211 */           this.out.println("if (listForm.elements[\"pageNum\"].value == listForm.elements[\"totalPageNum\"].value  ||  listForm.elements[\"totalPageNum\"].value <=1 )");
/* 212 */           this.out.println("{");
/* 213 */           this.out.println("\talert(\"已经是最后一页了\");");
/* 214 */           this.out.println("\treturn;");
/* 215 */           this.out.println("}");
/* 216 */           this.out.println("listForm.elements[\"pageNum\"].value ++;");
/* 217 */           this.out.println("showhelp();");
/* 218 */           if ((this.action != null) && (!"".equals(this.action)))
/*     */           {
/* 220 */             this.out.println("listForm.action = \"" + this.path + this.action + "\";");
/*     */           }
/* 222 */           this.out.println("listForm.submit();");
/* 223 */           this.out.println("}");
/*     */ 
/* 225 */           this.out.println("function doLast()");
/* 226 */           this.out.println("{");
/* 227 */           this.out.println("\tif(isEmpty()) return;");
/* 228 */           this.out.println("\tif (listForm.elements[\"pageNum\"].value == listForm.elements[\"totalPageNum\"].value  ||  listForm.elements[\"totalPageNum\"].value <=1 )");
/* 229 */           this.out.println("{");
/* 230 */           this.out.println("alert(\"已经是最后一页了\");");
/* 231 */           this.out.println("return;");
/* 232 */           this.out.println("}");
/* 233 */           this.out.println("listForm.elements[\"pageNum\"].value = listForm.elements[\"totalPageNum\"].value;");
/* 234 */           this.out.println("showhelp();");
/* 235 */           if ((this.action != null) && (!"".equals(this.action)))
/*     */           {
/* 237 */             this.out.println("listForm.action = \"" + this.path + this.action + "\";");
/*     */           }
/* 239 */           this.out.println("listForm.submit();");
/* 240 */           this.out.println("}");
/* 241 */           this.out.println("var isDoRowByOnKeyDown = 0;");
/* 242 */           this.out.println("function doRow()");
/* 243 */           this.out.println("{");
/* 244 */           this.out.println("if(isEmpty()) return false;");
/* 245 */           this.out.println("if (listForm.elements[\"totalPageNum\"].value == 0)");
/* 246 */           this.out.println("{");
/* 247 */           this.out.println("\talert(\"没有记录\");");
/* 248 */           this.out.println("listForm.elements[\"pageSize\"].focus();");
/* 249 */           this.out.println("\tlistForm.elements[\"pageSize\"].select();");
/* 250 */           this.out.println("return false;");
/* 251 */           this.out.println("}");
/*     */ 
/* 253 */           this.out.println(" if (isDoRowByOnKeyDown==1)");
/* 254 */           this.out.println("\t {");
/* 255 */           this.out.println("\treturn false;");
/* 256 */           this.out.println(" }");
/* 257 */           this.out.println("if(listForm.elements[\"pageSize\"].value != " + pageInfo.getPageSize() + "){");
/* 258 */           this.out.println(" listForm.elements[\"pageNum\"].value = 1;");
/* 259 */           this.out.println(" }");
/* 260 */           this.out.println("isDoRowByOnKeyDown=1;");
/* 261 */           this.out.println("showhelp();");
/* 262 */           if ((this.action != null) && (!"".equals(this.action)))
/*     */           {
/* 264 */             this.out.println("listForm.action = \"" + this.path + this.action + "\";");
/*     */           }
/* 266 */           this.out.println("listForm.submit();");
/* 267 */           this.out.println("}");
/*     */ 
/* 269 */           this.out.println("function dojump()");
/* 270 */           this.out.println("{\t\t");
/* 271 */           this.out.println("\tif(isEmpty()) return;");
/* 272 */           this.out.println("\tshowhelp();");
/* 273 */           if ((this.action != null) && (!"".equals(this.action)))
/*     */           {
/* 275 */             this.out.println("listForm.action = \"" + this.path + this.action + "\";");
/*     */           }
/* 277 */           this.out.println("\tlistForm.submit();");
/* 278 */           this.out.println("}");
/* 279 */           this.out.println("");
/* 280 */           this.out.println("function isEmpty()");
/* 281 */           this.out.println("{");
/* 282 */           this.out.println("\tif (Trim(listForm.elements[\"pageSize\"].value)=='')");
/* 283 */           this.out.println("\t{");
/* 284 */           this.out.println("\t\tlistForm.elements[\"pageSize\"].focus();");
/* 285 */           this.out.println("\t\tlistForm.elements[\"pageSize\"].select();");
/* 286 */           this.out.println("\t\talert(\"请输入数字\");");
/* 287 */           this.out.println("\t\treturn true;");
/* 288 */           this.out.println("}");
/* 289 */           this.out.println("if (isNaN(listForm.elements[\"pageSize\"].value))");
/* 290 */           this.out.println("{");
/* 291 */           this.out.println("\tlistForm.elements[\"pageSize\"].focus();");
/* 292 */           this.out.println("\tlistForm.elements[\"pageSize\"].select();");
/* 293 */           this.out.println("\talert(\"请输入数字\");");
/* 294 */           this.out.println("\treturn true;");
/* 295 */           this.out.println("\t}");
/* 296 */           this.out.println("else");
/* 297 */           this.out.println("{");
/* 298 */           this.out.println("\tif(parseInt(listForm.elements[\"pageSize\"].value) <= 0)");
/* 299 */           this.out.println("\t{");
/* 300 */           this.out.println("\tlistForm.elements[\"pageSize\"].focus();");
/* 301 */           this.out.println("listForm.elements[\"pageSize\"].select();");
/* 302 */           this.out.println("alert(\"数字必须大于零\");");
/* 303 */           this.out.println("\treturn true;");
/* 304 */           this.out.println("}");
/* 305 */           this.out.println("}");
/* 306 */           this.out.println("return false;");
/* 307 */           this.out.println("}");
/*     */ 
/* 309 */           this.out.println("function doRowByOnKeyDown()");
/* 310 */           this.out.println("{");
/* 311 */           this.out.println("\tif(event.keyCode=='13')");
/* 312 */           this.out.println("{");
/* 313 */           this.out.println("\treturn doRow();");
/* 314 */           this.out.println("}");
/* 315 */           this.out.println("}");
/* 316 */           this.out.println("function showhelp()");
/* 317 */           this.out.println("{");
/* 318 */           this.out.println("if(document.getElementById(\"hLater\"))");
/* 319 */           this.out.println("{");
/* 320 */           this.out.println("\tdocument.getElementById(\"hLater\").style.display = \"\";");
/* 321 */           this.out.println("}");
/* 322 */           this.out.println("}");
/* 323 */           this.out.println("function Trim(str){");
/* 324 */           this.out.println("if(str.charAt(0) == ' '){");
/* 325 */           this.out.println("str = str.slice(1);");
/* 326 */           this.out.println("str = Trim(str); ");
/* 327 */           this.out.println("}");
/* 328 */           this.out.println("return str;");
/* 329 */           this.out.println("}");
/* 330 */           this.out.println("</script>");
/*     */         }
/*     */         catch (IOException e)
/*     */         {
/* 334 */           this.log.warn(e.getMessage());
/* 335 */           if (this.log.isDebugEnabled())
/*     */           {
/* 337 */             e.printStackTrace();
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/* 342 */     return 6;
/*     */   }
/*     */ 
/*     */   protected int doStartEntity()
/*     */   {
/* 348 */     return 0;
/*     */   }
/*     */ 
/*     */   public String getProperty()
/*     */   {
/* 355 */     return this.property;
/*     */   }
/*     */ 
/*     */   public void setProperty(String property)
/*     */   {
/* 362 */     this.property = property;
/*     */   }
/*     */ 
/*     */   public String getImgPath()
/*     */   {
/* 369 */     return this.imgPath;
/*     */   }
/*     */ 
/*     */   public void setImgPath(String imgPath)
/*     */   {
/* 376 */     this.imgPath = imgPath;
/*     */   }
/*     */ }

/* Location:           D:\李慧医药项目\tcmages\krt\WEB-INF\classes\
 * Qualified Name:     org.ssi.tag.PageTag
 * JD-Core Version:    0.6.2
 */