
<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/ssi.tld" prefix="ssi"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>供应商-信息列表</title>
<link href="<%=request.getContextPath()%>/styles/gzt_css.css" rel="stylesheet" type="text/css" />
<script language="javascript" src="<%=request.getContextPath()%>/js/control.js"></script>
<script language="javascript" src="<%=request.getContextPath()%>/js/commons.js"></script>
<base target='_self'/>
</head>
<body>
<jsp:include page="/common/exception.jsp" flush="true" />
<html:form 	method="post" action="/supplier.do?operate=windowlist">
<div class="weizhi">
<div class="weizhi_bj">供应商信息列表</div>
<div class="weizhi_ss"><img id="controlSearchBtn" style="cursor:pointer" onclick="loadHiddenPage('<%=request.getContextPath()%>');" src="<%=request.getContextPath()%>/images/button_minus.gif" width="66" height="17" /></div>
</div>
<table border="0" cellspacing="0" cellpadding="0" class="table_chax" id="adSearch">
  <tr>
    <th width="12%">供应商代码：</th>
    <td width="20%"><html:text property="customerAccount" size="15" title="用户名"></html:text></td>
    <th width="12%">供应商名称：</th>
    <td width="21%"><html:text property="name" size="15" title="姓名"></html:text></td>
    <th width="11%"><input name="checks"  type="button" value="查询" onclick="check()"/></th>
    <td width="19%"></td>
    <th width="5%"></th>
  </tr>
</table>
<table border="0" cellpadding="0" cellspacing="0" class="table_list">
  <tr>
    <th width="20%">供应商信息列表</th>
    <th width="80%">
	</th>
  </tr>
  <tr>
    <td colspan="2">
		<table border="0" cellpadding="0" cellspacing="0" class="table_date" id="dataTable">
		  <tr>
			<th>请选择</th>
			<th>供应商代码</th>
			<th>供应商名称</th>
			<th>VIP</th>		
		  </tr>
		 <logic:present name="list">
							<logic:notEmpty name="list">
								<logic:iterate id="item" name="list" indexId="indexNo">
									<tr onmouseover="this.className='over'" onmouseout="this.className='out'" onclick="showInfo(<bean:write name="indexNo"/>,this);">
										<td><input
											type="radio" name="selectNos" id="radioId<bean:write name="indexNo"/>"
											value="<bean:write name="item" property="name"/>,<bean:write name="item" property="customerId"/>,<bean:write name="item" property="customerAccount" />"
											 /></td>
										<td><div><bean:write name="item" property="customerAccount" /></div></td>
										<td><div><bean:write name="item" property="name" /></div></td>
										<td><div><bean:write name="item" property="vip" /></div></td>
								</logic:iterate>
							</logic:notEmpty>
						</logic:present>
		 		</table>
		 </td>
	</tr>
  <tr>
    <td height="40" colspan="2">
	<div>
					<logic:present name="list">
							<logic:empty name="list">
								<div style="text-align:center; height:30px; line-height:30px;">暂无记录！</div>
							</logic:empty>
					</logic:present>
					
					<ssi:page property="pageInfo"  action="/supplier.do?operate=windowlist"/>
	</div>
	</td>
  </tr>
  <tr>
						<td colspan="5" align="center">
						<input name="toCode" type="button" value="确认" onclick="toCheck()" />
						</td>
 </tr>
</table>
</html:form>
</body>
</html>
<script language="javascript">

function toCheck(){
var radio= document.getElementsByName('selectNos');
	if(isRadioChecked(customerForm.selectNos)){
       for(var i=0; i<radio.length; i++){
              if(radio[i].checked == true){
                     window.returnValue=radio[i].value;
                     window.close();
              }
         }
       } else
        {
            alert("请选择品名信息！");
        }
}
function  check(){
document.customerForm.action="supplier.do?operate=windowlist";
customerForm.submit();
}

</script>