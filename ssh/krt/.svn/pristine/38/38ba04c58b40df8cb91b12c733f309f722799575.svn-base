/*    */ package org.ssi.tag;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.jsp.JspWriter;
/*    */ import org.apache.commons.logging.Log;
/*    */ 
/*    */ public class HiddenTag extends SSITag
/*    */ {
/*    */   private static final long serialVersionUID = -5690637185210464785L;
/* 21 */   private String propertyNames = null;
/*    */ 
/*    */   protected int doEndEntity()
/*    */   {
/* 27 */     if ((this.propertyNames != null) && (!"".equals(this.propertyNames)))
/*    */     {
/* 30 */       String[] str = this.propertyNames.split(";");
/* 31 */       if ((str != null) && (str.length > 0)) {
/*    */         try
/*    */         {
/* 34 */           for (int i = 0; i < str.length; i++)
/*    */           {
/* 36 */             if ((this.request.getParameter(str[i]) != null) && (!"".equals(this.request.getParameter(str[i]).trim())))
/*    */             {
/* 38 */               this.out.println("<input type=\"hidden\" name=\"" + str[i] + "\" value=\"" + this.request.getParameter(str[i]).trim() + "\" />");
/*    */             }
/*    */             else
/* 41 */               this.out.println("<input type=\"hidden\" name=\"" + str[i] + "\" value=\"\" />");
/*    */           }
/*    */         }
/*    */         catch (IOException e)
/*    */         {
/* 46 */           this.log.warn(e.getMessage());
/* 47 */           if (this.log.isDebugEnabled())
/*    */           {
/* 49 */             e.printStackTrace();
/*    */           }
/*    */         }
/*    */       }
/*    */     }
/* 54 */     return 6;
/*    */   }
/*    */ 
/*    */   protected int doStartEntity()
/*    */   {
/* 60 */     return 0;
/*    */   }
/*    */ 
/*    */   public String getPropertyNames()
/*    */   {
/* 67 */     return this.propertyNames;
/*    */   }
/*    */ 
/*    */   public void setPropertyNames(String propertyNames)
/*    */   {
/* 74 */     this.propertyNames = propertyNames;
/*    */   }
/*    */ }

/* Location:           D:\李慧医药项目\tcmages\krt\WEB-INF\classes\
 * Qualified Name:     org.ssi.tag.HiddenTag
 * JD-Core Version:    0.6.2
 */