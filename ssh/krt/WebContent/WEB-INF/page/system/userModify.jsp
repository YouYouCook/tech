<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/ssi.tld" prefix="ssi"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>用户管理-用户修改</title>
<link href="<%=request.getContextPath()%>/styles/gzt_css.css" rel="stylesheet" type="text/css" />
<script language="javascript" src="<%=request.getContextPath()%>/js/commons.js"></script>
<script language="javascript" src="<%=request.getContextPath()%>/js/control.js"></script>
<script language="javascript" src="<%=request.getContextPath()%>/js/formcheck.js"></script>
</head>
<body>
<html:form method="post" action="/user.do?operate=list">
<html:hidden property="userBO.userId"/>
<ssi:hidden propertyNames="name;empname;pageNum;pageSize"/>
<div class="weizhi">
	<div class="weizhi_bj">修改用户信息</div>
</div>
<table width="100%" border="0" cellspacing="0" cellpadding="0" class="table_add">
  <tr>
   <th width="19%">用户名：</th>
    <td width="81%">
         <bean:write name="userBO" property="username"/> 
   </td>
  </tr>
 <tr>
    <th>姓名：</th>
    <td><html:text property="userBO.name"
							styleId="Y_USN_userBO.name"
							 title="姓名"
							 
							maxlength="30"></html:text><span>*</span><font>姓名为2-15个汉字</font>
	</td>
  </tr>
  <tr>
    <th>联系电话：</th>
    <td><html:text property="userBO.phone" styleId="Y_ph4_userBO.phone"  title="联系电话" maxlength="20"></html:text><span>*</span><font>电话格式为：01088888888(-888888)</font>
		
	</td>
  </tr>
  <tr>
    <th>角色类型：</th>
    <td>
		<html:radio property="userBO.roleType" value="1">超级管理员</html:radio>
		<html:radio property="userBO.roleType" value="2">采购部</html:radio>
		<html:radio property="userBO.roleType" value="4">质量部</html:radio>
		<html:radio property="userBO.roleType" value="5">物流部</html:radio>
		<html:radio property="userBO.roleType" value="6">财务部</html:radio>
		<html:radio property="userBO.roleType" value="7">运营部</html:radio>
	</td>
	</tr>
   <tr>
    <td colspan="2">
	<div>
	<input type="button" name="Submit" value="确 认" onclick="update()"/>
    <input type="button" name="Submit2" value="重 置" onclick="reset();"/>
    <input type="button" name="Submit3" value="返 回" onclick="backup();"/>
	</div>
	</td>
  </tr>
</table>
</html:form>
</body>
</html>
<script language="JavaScript">
    function update()
    {
        if(checkSubmit(document.userForm)){
        	if(confirm("确定要修改此信息吗？")){
	         	document.userForm.action="user.do?operate=update";
				userForm.submit();
	     	}
	     
	   }
	     
    }
    function backup()
    {
    	document.userForm.action="user.do?operate=list";
        document.userForm.submit();
    }
    function reset()
    {       		
    	  
    	document.userForm.reset();  
    }
</script>
