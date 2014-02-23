<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/ssi.tld" prefix="ssi"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>用户管理-用户增加</title>
<link href="<%=request.getContextPath()%>/styles/gzt_css.css" rel="stylesheet" type="text/css" />
<script language="javascript" src="<%=request.getContextPath()%>/js/commons.js"></script>
<script language="javascript" src="<%=request.getContextPath()%>/js/control.js"></script>
<script language="javascript" src="<%=request.getContextPath()%>/js/formcheck.js"></script>
<script language="javascript" src="<%=request.getContextPath()%>/js/ajax.js"></script>
</head>
<body>
<jsp:include page="/common/ajaxSession.jsp" />
<html:form method="post" action="/user.do?operate=add">
<div class="weizhi">
	<div class="weizhi_bj">添加用户</div>
</div>
<table width="100%" border="0" cellspacing="0" cellpadding="0" class="table_add">
	<tr>
    <td colspan="2">注意：<span>*</span> 号为必填项！</td>
  	</tr>
  <tr>
    <th width="19%">用户名：</th>
    <td width="81%"><html:text property="userBO.username"
							styleId="Y_eng_userBO.username" 
							onblur="return checkUnique('user.do?operate=checkUserName&username=' + this.value,this);"
							title="用户名" maxlength="50" ></html:text><span>*</span><font>用户名为1-50位英文、数字、下划线或组合,第一位不允许为下划线</font>
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
    <th>登录密码：</th>
    <td><input id="N_str_password" type="password" title="登录密码" name="password" size="22" maxlength="50"/><span>*</span>
	</td>
  </tr>
  <tr>
    <th>确认登录密码：</th>
    <td><input id="Y_PS2_password" title="确认登录密码" passwordName="password" type="password" name="userPasswordw" size="22" maxlength="50"/><span>*</span>
	</td>
  </tr>
  <tr>
    <th>联系电话：</th>
   <td><html:text property="userBO.phone" styleId="Y_ph4_userBO.phone" title="电话" maxlength="50"></html:text> <span>*</span><font>电话格式为：01088888888(-888888)</font></td>		
	</td>
  </tr>
  <tr>
    <th>角色类型：</th>
    <td><input type="radio" name="roleType" value="1" checked="true" />超级管理员
		<input type="radio" name="roleType" value="2" />采购部
		<input type="radio" name="roleType" value="4" />质量部
		<input type="radio" name="roleType" value="5" />物流部
		<input type="radio" name="roleType" value="6" />财务部
		<input type="radio" name="roleType" value="7" />运营部
	</td>
  </tr>
  <tr>
    <td colspan="2">
	<div>
	<input type="button" name="Submit" value="确 认" onclick="addUser()"/>
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
    function addUser()
    {
    	if(checkUnique('user.do?operate=checkUserName&username=' + document.all['userBO.username'].value,document.all['userBO.username']))
    	{
       		 if(checkSubmit(document.userForm)){
    		    if(confirm("确定要增加此信息吗？"))
		        {
		         	document.userForm.action="user.do?operate=add";
					userForm.submit();
		        }
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
