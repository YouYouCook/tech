<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<script language="javascript" src="<%=request.getContextPath()%>/js/commons.js"></script>
<script language="javascript" src="<%=request.getContextPath()%>/js/control.js"></script>
<script language="javascript" src="<%=request.getContextPath()%>/js/ajax.js"></script>
<style type="text/css">
.titleDiv {
	width:240px;
	height:50px;
	position:absolute;	
	display:none;
	background:url(<%=request.getContextPath()%>/images/xiaoxi_bj.gif) no-repeat;
	text-align:center;
	line-height:50px;
	font-size:14px;
	color:#333333;
}
</style>
<script language="JavaScript">
    function ajaxSession()
    {
	    var ajax = new AJAX();
		var url = "<%=request.getContextPath()%>/employees.do?operate=ajaxSession";
		ajax.post(url);
		var str = ajax.getValue();
		if(str.indexOf('<html xmlns="http://www.w3.org/1999/xhtml">')>-1)
		{
		  return false;
		}	
		return  true;
	}
</script>
