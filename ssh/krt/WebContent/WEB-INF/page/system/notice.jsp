<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/ssi.tld" prefix="ssi"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>招标公告-招标公告维护</title>
<link href="<%=request.getContextPath()%>/styles/gzt_css.css" rel="stylesheet" type="text/css" />
<script language="javascript" src="<%=request.getContextPath()%>/js/commons.js"></script>
<script language="javascript" src="<%=request.getContextPath()%>/js/control.js"></script>
<script language="javascript" src="<%=request.getContextPath()%>/js/formcheck.js"></script>
<script language="javascript" src="<%=request.getContextPath()%>/js/ajax.js"></script>
</head>
<body>
<jsp:include page="/common/exception.jsp" flush="true" />
<html:form method="post" action="/notice.do?operate=list">
<input type="hidden" name="id" value="<bean:write name="noticeForm" property="noticeBO.id" />">
<div class="weizhi">
	<div class="weizhi_bj">招标公告维护</div>
</div>
<table width="100%" border="0" cellspacing="0" cellpadding="0" class="table_add">
	<tr>
    <td colspan="2">注意：<span>*</span> 号为必填项！</td>
  	</tr>
  <tr height="100">
    <th>招标公告：</th>
    <td ><textarea name="noticeBO.notic"  style="height:100px" styleId="N_str_noticeBO.notic" title="招标公告" maxlength="4000"><bean:write name="noticeForm" property="noticeBO.notic" /></textarea><span>*</span><font>招标公告为1-1000个汉字</font>
	</td>	
  </tr>
  <tr height="100">
	<th>招标通知：</th>
    <td ><textarea name="noticeBO.message"  style="height:100px" styleId="N_str_noticeBO.message" title="招标通知" maxlength="4000"><bean:write name="noticeForm" property="noticeBO.message" /></textarea><span>*</span><font>招标通知为1-1000个汉字</font>
	</td>
  </tr>
    <td colspan="2">
	<div>
	<input type="button" name="Submit" value="确 认" onclick="addUser()"/>
    <input type="button" name="Submit2" value="重 置" onclick="reset();"/>
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
    	
       		 if(checkSubmit(document.noticeForm)){
    		    if(confirm("确定要增加此信息吗？"))
		        {
		         	document.noticeForm.action="notice.do?operate=update";
					noticeForm.submit();
		        }
        	}
        
	     
    }

   function reset()
    {       		
    	document.noticeForm.reset();  
    }
</script>
