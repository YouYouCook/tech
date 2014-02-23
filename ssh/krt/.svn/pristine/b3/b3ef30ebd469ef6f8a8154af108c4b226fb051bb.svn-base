<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title></title>
<link href="styles/gzt_css.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div class="top">
	<div class="top_logo"></div>
	<div class="top_menu">
		<div class="top_menu1">
			<div class="top_ico01"><a href="user.do?operate=modifyEmpP" target="rightFrame">修改密码</a></div>		
		</div>
		<div  class="top_menu2">
		<div class="top_menu3">当前用户:${sessionScope['Logon.User'].loginUserName}</div>
            <div class="top_but01"><a href="user.do?operate=backSystem" onclick="if (confirm('确定要退出吗？')) return true; else return false;" >退出系统</a></div>
		</div>
	</div>
</div>
</body>
</html>
