<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/ssi.tld" prefix="ssi"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>VIP供应商管理-列表</title>
<link href="<%=request.getContextPath()%>/styles/gzt_css.css" rel="stylesheet" type="text/css" />
<script language="javascript" src="<%=request.getContextPath()%>/js/control.js"></script>
<script language="javascript" src="<%=request.getContextPath()%>/js/commons.js"></script>
<script language="javascript" src="<%=request.getContextPath()%>/js/formcheck.js"></script>
</head>
<body>
<jsp:include page="/common/exception.jsp" flush="true" />
<html:form 	method="post" action="/vip.do?operate=list">
<div class="weizhi">
<div class="weizhi_bj">VIP供应商管理</div>
<div class="weizhi_ss"><img id="controlSearchBtn" style="cursor:pointer" onclick="loadHiddenPage('<%=request.getContextPath()%>');" src="<%=request.getContextPath()%>/images/button_minus.gif" width="66" height="17" /></div>
</div>
<table border="0" cellpadding="0" cellspacing="0" class="table_list">
  <tr>
    <th width="11%">VIP供应商信息列表</th>
    <th width="89%">
	<div>
	  <input name="toAdd" type="button" value="新增" onclick="toAdds()" />
     <input name="toCode" type="button" value="删除" onclick="todelete()"/>
	</div>
	</th>
  </tr>
  <tr>
    <td colspan="2">
		<table border="0" cellpadding="0" cellspacing="0" class="table_date" id="dataTable">
		  <tr>
			<th width="8%">请选择</th>
			<th width="">品名</th>
			<th width="">VIP供应商ID</th>
			<th width="">VIP供货商名称</th>
		  </tr>
		  <logic:present name="list">
							<logic:notEmpty name="list">
								<logic:iterate id="item" name="list" indexId="indexNo">
									<tr onmouseover="this.className='over'" onmouseout="this.className='out'" onclick="showInfo(<bean:write name="indexNo"/>,this);">
										<td><input type="radio" name="selectNos" id="radioId<bean:write name="indexNo"/>"  onclick="doBoxChange(customerVipForm.isAll,customerVipForm.selectNos);" value="<bean:write name="item" property="vipId"/>"
											 /></td>
										<td><div><bean:write name="item" property="medicineName" /></div></td>
										<td><div><bean:write name="item" property="customerAccount" /></div></td>
										<td><div><bean:write name="item" property="customerName" /></div></td>
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
					
					<ssi:page property="pageInfo"  action="/vip.do?operate=list"/>
	</div>
	</td>
  </tr>
</table>
</html:form>
</body>
</html>
<script language="javascript">
	function toAdds(){
		document.customerVipForm.action="vip.do?operate=toAdd";
		document.customerVipForm.submit();
	}
	function todelete(){    
        if(isRadioChecked(customerVipForm.selectNos))
        {
        document.customerVipForm.action="vip.do?operate=toDelete";
        document.customerVipForm.submit();
        }
        else
        {
            alert("请选择唯一的VIP供货商信息!");
        }
	}
</script> 
