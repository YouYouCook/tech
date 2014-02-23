<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>无标题文档</title>
<style type="text/css">
<!--
body {
    background:url(images/wel_bj.jpg) left top no-repeat;
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
body,td,th {
	color: #333333;
	font-size: 12px;
}
.STYLE1 {
	font-size: 14px;
	font-weight: bold;
}
-->
</style></head>
<body>
<jsp:include page="/common/exception.jsp" flush="true" />
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td width="5%" height="157">&nbsp;</td>
    <td width="95%">&nbsp;</td>
  </tr>
  
<c:if test="${sessionScope['Logon.User'].loginRole ==3}">
   <tr>
    <td height="50">&nbsp;</td>
    <td><span class="STYLE1">招标公告</span></td>
  </tr>
  <tr>
    <td height="30">&nbsp;</td>
    <td>
		<div style="overflow:auto; zoom:1;">
			<div style="float:left;border:0px solid red;padding:10px; width:400px;">${sessionScope['Logon.Zbgg'].notic}</div>
			<div style="float:left;margin-left:100px;border:0px solid red;padding:10px;width:500px">${sessionScope['Logon.Zbgg'].message}</div>
			<div style="clear:both;"></div>
		</div>
	</td> 
  </tr>
  </c:if>
  <tr>
    <td height="50">&nbsp;</td>
    <td><span class="STYLE1">安全提示</span></td>
  </tr>
  <tr>
    <td height="30">&nbsp;</td>
    <td>
   如果您在登录后连续30分钟内未操作，系统将自动超时退出。
   </td>
  </tr>
  <tr align="left">
        <td>
        <logic:present name="loginToChangePassword" >
        <logic:notEmpty name="loginToChangePassword">
        <logic:equal value="true" name="loginToChangePassword">
        <script type="text/javascript" language="javascript">
        var vDialog=showModalDialog("<%=request.getContextPath()%>/employees.do?operate=passwordUpdate",window,"status:no;resizable:no;dialogHeight:310px;dialogWidth:600px;unadorne:yes");
        if(vDialog == "close")
        {
        	if(window.top)
            {
                 window.top.location = "<%=request.getContextPath()%>/employees.do?operate=backSystem";
            }	
            else if(window.parent)
            {
            	window.parent.location = "<%=request.getContextPath()%>/employees.do?operate=backSystem";
            }
            else
            {
            	window.location = "<%=request.getContextPath()%>/employees.do?operate=backSystem";
            }
         }
        
        </script>
        </logic:equal>
        </logic:notEmpty>
        </logic:present> </td>
        </tr>
  <tr>
    <td height="30">&nbsp;</td>
    <td><logic:equal name="Logon.UserType"  value="2">
	    	<logic:present name="loginAlertValue" >
		        <logic:notEmpty name="loginAlertValue">
		        <bean:write name="loginAlertValue" />
	        	</logic:notEmpty>
	        </logic:present>
       </logic:equal>
   </td>
  </tr>
</table>


</body>
</html>

<script type="text/javascript">
	window.onload = function(){
		var copy = document.getElementById("copyright");
		copy.style.top = (document.documentElement.clientHeight  - 130) + "px";
	}
	window.onresize = function(){
		var copy = document.getElementById("copyright");
		copy.style.top = (document.documentElement.clientHeight  - 130) + "px";
	}
</script>