<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/ssi.tld" prefix="ssi"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>后台首页-密码修改</title>
<link href="<%=request.getContextPath()%>/styles/gzt_css.css" rel="stylesheet" type="text/css" />
<script language="javascript" src="<%=request.getContextPath()%>/js/commons.js"></script>
<script language="javascript" src="<%=request.getContextPath()%>/js/control.js"></script>
<script language="javascript" src="<%=request.getContextPath()%>/js/formcheck.js"></script>
<script language="javascript" src="<%=request.getContextPath()%>/js/ajax.js"></script>
</head>
<body>
<jsp:include page="/common/exception.jsp" flush="true" />
<html:form method="post" action="/user.do?operate=modifyEmpP">
<input type="hidden" name="operate">
<div class="weizhi">
	<div class="weizhi_bj">修改密码</div>
</div>
<table width="100%" border="0" cellspacing="0" cellpadding="0" class="table_add">
	<tr>
    <td colspan="2">注意：<span>*</span> 号为必填项！</td>
  	</tr>
  <tr>
    <th width="19%">输入原密码：</th>
    <td width="81%"><input type="password" name="opassword" id="Y_str_opassword" title="输入原密码" onblur="return checkUnique('user.do?operate=checkPasswordCusertomer&checkpassword=' + this.value,this,'与原密码输入不一致，请重试！');"size="22" maxlength="50" /><span>*</span><font>保持和原密码一致</font>
	</td>     
  </tr>
  <tr>
    <th width="19%">新密码：</th>
    <td width="81%"><input id="N_str_password" type="password" title="新密码" name="password" size="22" maxlength="50"/><span>*</span><font>登录密码为8-50位英文,数字,特殊字符的组合</font>
	</td>
  </tr>
  <tr>
    <th>确认新密码：</th>
    <td><input id="Y_PS2_password" title="确认新密码" passwordName="password" type="password" name="emPasswordw" size="22" maxlength="50"/><span>*</span><font>确认登录密码为8-50位英文,数字,特殊字符的组合</font>
	</td>
  </tr>
  <tr>
    <td colspan="2">
	<div>
	<input type="button" name="Submit" value="确 认" onclick="updatePassword()"/>
    <input type="button" name="Submit2" value="重 置" onclick="reset();"/>
	</div>
	</td>
  </tr>
</table>
</html:form>
</body>
</html>
<script language="JavaScript">
<logic:equal name="flag"  value="true">

	alert("修改密码成功,请重新登录！");
	window.location = "<%=request.getContextPath()%>/user.do?operate=backSystem";
  
</logic:equal>
    function updatePassword()
    {		
    		 
	     		 	if(checkSubmit(document.userForm)){ 
		     		 if(checkUnique('user.do?operate=checkPasswordCusertomer&checkpassword=' + document.all['opassword'].value,document.all['opassword'],'与原密码输入不一致，请重试！'))
		     		 {  	
		     		 	     		   
		   		    	if(confirm("确定要修改密码吗？"))
			        	{
			         	document.userForm.action="user.do?operate=updatePasswordCustomer";
						userForm.submit();
			       		}
	      			}
	     		}
    }
   function reset()
    {       		
    	document.customerForm.reset();  
    }
</script>
