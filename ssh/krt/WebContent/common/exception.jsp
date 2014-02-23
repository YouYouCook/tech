<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<script language="javascript" src="<%=request.getContextPath()%>/js/commons.js"></script>
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
<logic:present name="exception.message">
	<logic:notEmpty name="exception.message">
	<div id="title_message" class="titleDiv">
		<bean:write name="exception.message" />
	</div>
	</logic:notEmpty>
</logic:present>

