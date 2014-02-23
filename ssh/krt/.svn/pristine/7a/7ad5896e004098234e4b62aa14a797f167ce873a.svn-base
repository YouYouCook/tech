<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/ssi.tld" prefix="ssi"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>发票信息维护</title>
<link href="<%=request.getContextPath()%>/styles/gzt_css.css" rel="stylesheet" type="text/css" />
<script language="javascript" src="<%=request.getContextPath()%>/js/control.js"></script>
<script language="javascript" src="<%=request.getContextPath()%>/js/commons.js"></script>
<script language="javascript" src="<%=request.getContextPath()%>/js/My97DatePicker/WdatePicker.js"></script>
<script language="javascript" src="<%=request.getContextPath()%>/js/formcheck.js"></script>
<base target='_self'/>
</head>
<body>
<jsp:include page="/common/exception.jsp" flush="true" />
<html:form method="post" action="/fapiaoManage.do?operate=windowlist">
<div class="weizhi">
<div class="weizhi_bj">发票信息</div>
<div class="weizhi_ss"><img id="controlSearchBtn" style="cursor:pointer" onclick="loadHiddenPage('<%=request.getContextPath()%>');" src="<%=request.getContextPath()%>/images/button_minus.gif" width="66" height="17" /></div>
</div>
<table border="0" cellspacing="0" cellpadding="0" class="table_chax" id="adSearch">
  <tr>
  </tr>
</table>
<table border="0" cellpadding="0" cellspacing="0" class="table_list">

	<tr>
    <td colspan="2">
		<table border="0" cellpadding="0" cellspacing="0" class="table_date" id="dataTable">
		  <tr>
		    <th width="10%">请选择</th>
			<th width="10%">接收日期</th>
			<th width="20%">供应商</th>
			<th width="10%">发票号码</th>
			<th width="10%">票额</th>
			<th width="10%">开票日期</th>
			<th width="10%">票面信息</th>
			<th width="20%">备注</th>
		  </tr>
		  <tr>
		  <logic:present name="fapiaoList">
							<logic:notEmpty name="fapiaoList">
								<logic:iterate id="item" name="fapiaoList" indexId="indexNo">
									<tr onmouseover="this.className='over'" onmouseout="this.className='out'" onclick="showInfo(<bean:write name="indexNo"/>,this);">
									    <td><input type="radio" name="selectNos" id="radioId<bean:write name="indexNo"/>" 
									     onclick="doBoxChange(configForm.isAll,configForm.selectNos);"
									     value="<bean:write name="item" property="fapiaohao"/>,<bean:write name="item" property="gongyingshang"/>"/></td>									
										<td><div><bean:write name="item" property="jieshouriqi" /></div></td>
										<td><div><bean:write name="item" property="gongyingshang" /></div></td>
										<td><div><bean:write name="item" property="fapiaohao" /></div></td>
										<td><div><bean:write name="item" property="kaipiaojiage" /></div></td>
										<td><div><bean:write name="item" property="kaipiaoriqi" /></div></td>
										<td><div><bean:write name="item" property="piaomianxinxi" /></div></td>
										<td><div><bean:write name="item" property="beizhu" /></div></td>
									</tr>
								</logic:iterate>
							</logic:notEmpty>
						</logic:present>
		</tr>	
								
	 </table>
	</td>
	</tr>
  <tr>
    <td height="40" colspan="2">
	<div>
					<logic:present name="fapiaoList">
							<logic:empty name="fapiaoList">
								<div style="text-align:center; height:30px; line-height:30px;">暂无记录！</div>
							</logic:empty>
					</logic:present>
					
					<ssi:page property="pageInfo"  action="/fapiaoManage.do?operate=windowlist"/>
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
<script language="JavaScript">
function toCheck(){
	var radio= document.getElementsByName('selectNos');
		if(isRadioChecked(fapiaoForm.selectNos)){
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
    function toSerch(){
	    if(checkSubmit(document.fapiaoForm)){
	    	document.fapiaoForm.operate.value="list";
	    	document.fapiaoForm.submit();
	    	}
    }

	

</script>

