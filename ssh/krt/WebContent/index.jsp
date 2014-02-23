<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ page import="org.ssi.common.SessionConstants" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%
if(session.getAttribute(SessionConstants.USER_KEY) != null){
	if(!response.isCommitted()) {
	response.sendRedirect(request.getContextPath()+ "/user.do?operate=login");
	return;
	}
}
//设置页面不缓存
response.setHeader("Pragma","No-cache");
response.setHeader("Cache-Control","no-cache");
response.setDateHeader("Expires", 0);
%>
<head>
<title>康仁堂采购招标系统</title>
<script language="javascript" src="<%=request.getContextPath()%>/js/ajax.js"></script>
<script language="javascript" src="<%=request.getContextPath()%>/js/control.js"></script>
<script language="javascript" src="<%=request.getContextPath()%>/js/md5.js"></script>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	background-color: #7fa3eb;
}
body,td,th {
	font-size: 12px;
	color: #333333;
}
-->
</style>
</head>
<body>
<html:form action="user.do?operate=login" method="post">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="180" valign="top" style="background:url(images/login_bj01.jpg) no-repeat center bottom">&nbsp;</td>
  </tr>
</table>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="248" valign="top" style="background:url(images/login_bj02.jpg) no-repeat center top">
	  <table width="910" border="0" align="center" cellpadding="0" cellspacing="0">
		  <tr>
			<td width="515" height="223" align="right"><img src="images/login_bj03.jpg" width="515" height="248" /></td>
			<td width="395" valign="top" style="background:url(images/login_bj04.jpg) no-repeat left top;"><table width="280" border="0" align="center" cellpadding="0" cellspacing="0">
              <tr>
                <td width="68" height="66">&nbsp;</td>
                <td colspan="2">&nbsp;</td>
              </tr>
              <tr>
                <td height="30" align="right">用户名：</td>
                <td colspan="2" align="left"><div style="background:url(images/login_input01.gif) no-repeat left top; border:solid 1px #B1CBE6; height:18px; background-color:#FFFFFF; width:140px; padding-left:20px; line-height:18px; ">
                <input id="user" type="text" name="loginName" accesskey="U" title="快捷访问：alt+U" style="width:135px; height:18px; border:0px; background-color:transparent;"/></div></td>
              </tr>
              <tr>
                <td height="30" align="right">密&nbsp;&nbsp;码：</td>
                <td colspan="2" align="left"><div style="background:url(images/login_input02.gif) no-repeat left top; border:solid 1px #B1CBE6; height:18px; background-color:#FFFFFF; width:140px; padding-left:20px; line-height:18px; ">
                <input id="pwd" type="password" name="loginPwd"  accesskey="P" title="快捷访问：alt+P"  style="width:135px; height:18px; border:0px; background-color:transparent;"/></div></td>
              </tr>
             
              <tr>
                <td height="59" colspan="3" align="center" valign="middle">
				<img src="images/login_menu01.gif" style="cursor:hand" onclick="return form_submit();"/>&nbsp;&nbsp;
                <img src="images/login_menu02.gif" style="cursor:hand" onclick="return form_reset();"/>
                </td>
              </tr>
            </table></td>
		  </tr>
	  </table>
	</td>
  </tr>
</table>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="103" style="background:url(images/login_bj05.jpg) no-repeat center top;">&nbsp;</td>
  </tr>
</table>
<div id="copyright" style="height:20px; line-height:20px; width:100%; left: 0px;text-align:center; color:#ffffff; margin-top:30px;">
申明：为保证系统安全性，用户持续30分钟内在系统不产生操作，系统将会自动退出，并请您重新登录 <br />
本系统建议浏览分辨率1024*768及以上&nbsp;&nbsp;Copyright 2011 IDReal.cn, All Rights Reserved. 
</div>
</html:form>
</body>
</html>
<script type="text/javascript">
	function form_reset(){
		document.userForm.reset(); 
		
		}
	window.onload = function(){
		var copy = document.getElementById("copyright");
		copy.style.top = (document.documentElement.clientHeight  - 50) + "px";
	}
	window.onresize = function(){
		var copy = document.getElementById("copyright");
		copy.style.top = (document.documentElement.clientHeight  - 50) + "px";
	}
	window.document.onkeydown = function kdown(){
	if(window.event.keyCode == 13)
		{
			return form_submit();
		}
   	}
   	
	function form_submit() 
	{
		if(document.getElementById("user").value == "") {
			alert("用户名不能为空!");
			document.getElementById("user").focus();
			return false;
		}
		else if(document.getElementById("pwd").value == "") {
			alert("密码不能为空!");
			document.getElementById("pwd").focus();
			return false;
		}
		else
		{
			var ajax = new AJAX();
			var loginPwd=hex_md5(document.getElementById("pwd").value);
			var url = "<%=request.getContextPath()%>/user.do?ajax_login=true&operate=user&loginName=" + document.getElementById("user").value +"&loginPwd=" + loginPwd;
			ajax.post(url);
			var str = ajax.getValue();
			if(str == "1")
			{
				alert("用户名不存在,请重新输入！");
				employeesForm.user.select();
				employeesForm.user.focus();
			}
			else if(str == "2")
			{
				alert("输入的密码不匹配,请重试！");
				employeesForm.pwd.select();
				employeesForm.pwd.focus();
			}
			else 
			{
				window.location = "<%=request.getContextPath()%>/user.do?operate=login";
			
			}						
		 }
	}
	
	
		if (top.location != self.location) 
		{ 
  		top.location=self.location; 
		} 	
		{
		
	window.onload=function(){
		auto_focus();
		}
		
	function auto_focus(){
		if(document.getElementById('user')!=null) 
			employeesForm.user.focus();
		}
}
</script>