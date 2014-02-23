
<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/ssi.tld" prefix="ssi"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>品名-信息列表</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="<%=request.getContextPath()%>/styles/gzt_css.css" rel="stylesheet" type="text/css" />
<script language="javascript" src="<%=request.getContextPath()%>/js/control.js"></script>
<script language="javascript" src="<%=request.getContextPath()%>/js/commons.js"></script>
<script language="javascript" src="<%=request.getContextPath()%>/js/My97DatePicker/WdatePicker.js"></script>
<base target='_self'/>
</head>
<body>
<jsp:include page="/common/exception.jsp" flush="true" />
<html:form 	method="post" action="/medicineManage.do?operate=medicineWindowForCg">
<div class="weizhi">
<div class="weizhi_bj">品名信息列表</div>
<div class="weizhi_ss"><img id="controlSearchBtn" style="cursor:pointer" onclick="loadHiddenPage('<%=request.getContextPath()%>');" src="<%=request.getContextPath()%>/images/button_minus.gif" width="66" height="17" /></div>
</div>
<table border="0" cellspacing="0" cellpadding="0" class="table_chax" id="adSearch">
  <tr>
    <th width="10%">品名：</th>
    <td width="20%"><html:text property="medicineName" size="15" title="品名"></html:text></td>
   <!--  <th>采购下单期：</th>
    <td colspan="3"><input type="text" id="cgDate" name="cgDate" value="${cgDate}"  size="6"  readonly="true" title="采购期" onfocus="WdatePicker({dateFmt:'yyyy-MM'})" class="Wdate"  />
	</td> --> 
    <td width="5%"><input name="checks"  type="button" value="查询" onclick="toSerch()"/></td>
  </tr>
</table>
<table border="0" cellpadding="0" cellspacing="0" class="table_list">
  <tr>
    <th width="20%">品名信息列表</th>
    <th width="80%">
	</th>
  </tr>
  <tr>
    <td colspan="2">
		<table border="0" cellpadding="0" cellspacing="0" class="table_date" id="dataTable">
		  <tr>
			<th>请选择</th>
			<th>品名</th>
			<th>基本质量要求</th>	
			<th>图片</th>	
		  </tr>
		 <logic:present name="medicineList">
							<logic:notEmpty name="medicineList">
								<logic:iterate id="item" name="medicineList" indexId="indexNo">
									<tr onmouseover="this.className='over'" onmouseout="this.className='out'" onclick="showInfo(<bean:write name="indexNo"/>,this);">
										<td><input
											type="radio" name="selectNos" id="radioId<bean:write name="indexNo"/>"
											value="<bean:write name="item" property="medicineName"/>,<bean:write name="item" property="medicineId"/>"
											 /></td>
									<td><div><bean:write name="item" property="medicineName" /></div></td>
									<td><div STYLE="width: 120px; height: 20px; border: 0px solid blue;overflow: hidden; text-overflow:ellipsis" onmouseover="this.style.cssText='overflow:visible'" onmouseout="this.style.cssText='width:120px;height: 20px;border: 0px solid blue;overflow:hidden;text-overflow:ellipsis'"><bean:write name="item" property="zlyq" /></div></td>
											<td>
											<logic:notEmpty name="item" property="medicineVistorimagePath">  
												 <a target="blank" href=<bean:write name="item" property="medicineVistorimagePath" />><img src=<bean:write name="item" property="medicineVistorimagePath" /> style="max-width:300px;height:50px;"/></a>
  					 						  </logic:notEmpty> 
											</td>
									</tr>
								</logic:iterate>
							</logic:notEmpty>
						</logic:present>
		 		</table>
		 </td>
	</tr>
  <tr>
    <td height="40" colspan="2">
	<div>
					<logic:present name="medicineList">
							<logic:empty name="medicineList">
								<div style="text-align:center; height:30px; line-height:30px;">暂无记录！</div>
							</logic:empty>
					</logic:present>
					
					<ssi:page property="pageInfo"  action="/medicineManage.do?operate=medicineWindowForCg"/>
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
	if(isRadioChecked(medicineForm.selectNos)){
       for(var i=0; i<radio.length; i++){
              if(radio[i].checked == true){
                     
                     if (window.opener != undefined) {
                         //for chrome
                         window.opener.returnValue = radio[i].value;
	                  }
	                  else {
	                         window.returnValue = radio[i].value;
	                  }
                     window.close();
              }
         }
       } else
        {
            alert("请选择品名信息！");
        }
}
function  toSerch(){
document.medicineForm.action="medicineManage.do?operate=medicineWindowForCg";
medicineForm.submit();
}

</script>