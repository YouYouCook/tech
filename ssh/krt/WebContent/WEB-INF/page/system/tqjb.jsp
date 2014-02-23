<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/ssi.tld" prefix="ssi"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>管理员提前截标-列表</title>
<link href="<%=request.getContextPath()%>/styles/gzt_css.css" rel="stylesheet" type="text/css" />
<script language="javascript" src="<%=request.getContextPath()%>/js/control.js"></script>
<script language="javascript" src="<%=request.getContextPath()%>/js/commons.js"></script>
<script language="javascript" src="<%=request.getContextPath()%>/js/date/common.js"></script>
<script language="javascript" src="<%=request.getContextPath()%>/js/formcheck.js"></script>
<script language="javascript" src="<%=request.getContextPath()%>/js/My97DatePicker/WdatePicker.js"></script>
</head>
<body>
<jsp:include page="/common/exception.jsp" flush="true" />
<html:form 	method="post" action="/MedicineJbAction.do?operate=tqjb">
<input id="medicineId" type="hidden" name="medicineId" value="${medicineId}">
<div class="weizhi">
<div class="weizhi_bj">管理员提前截标产品</div>
<div class="weizhi_ss"><img id="controlSearchBtn" style="cursor:pointer" onclick="loadHiddenPage('<%=request.getContextPath()%>');" src="<%=request.getContextPath()%>/images/button_minus.gif" width="66" height="17" /></div>
</div>
</div>
<table border="0" cellspacing="0" cellpadding="0" class="table_chax" id="adSearch">
  <tr>
    <!--  <th width="12%">品名：</th>
    <td width="20%"><input type="text" id="medicineName" name="medicineName" readonly="true" value="${medicineName}" title="品名"/><input name="button" type="button" value="查询" onclick="openwinMedicine();" /></td>-->
    <th>投标起始日：</th>
    <td colspan="3"><input type="text" id="beginDate" name="beginDate" value="${beginDate}"  size="6" title="投标起始日" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" class="Wdate" readonly="true"/>
	</td>
    <th><input name="checks"  type="button" value="查询" onclick="checka()"/></th>
    <td></td>
  </tr>
</table>
<table border="0" cellpadding="0" cellspacing="0" class="table_list">
  <tr>
    <th width="15%">查看投标起始日产品信息</th>
    <th width="85%">
	<div>
	 <input name="add" type="button" value="确认截标" onclick="sureJB();" /> 
	</div>
	</th>
  </tr>
  </br>
  
  <tr>
    <td colspan="2">
		<table border="0" cellpadding="0" cellspacing="0" class="table_date" id="dataTable">
		  <tr>
		  	<th>全选<input type="checkbox" name="selectAll" onclick="doBoxControl(medicineJbForm.selectAll,medicineJbForm.selectNos);"/></th>
		  	<th>供应商名称</th>
			<th>品名</th>
			<th>投标起始日</th>
			<th>投标截止日</th>
		  </tr>
		  <logic:present name="reslutList">
							<logic:notEmpty name="reslutList">
								<logic:iterate id="item" name="reslutList" >									
									<td><input type="checkbox" name="selectNos" onclick="doBoxChange(medicineJbForm.selectAll,medicineJbForm.selectNos);"
									value="<bean:write name="item" property="jbId"/>,<bean:write name="item" property="medicineCgBO.cgId" />"/></td>
										<td><div><bean:write name="item" property="customerBO.name" /></div></td>
										<td><div><bean:write name="item" property="medicineCgBO.medicineBO.medicineName" /></div></td>
										<td><div><bean:write name="item" property="beginDate" /></div></td>
										<td><div><bean:write name="item" property="endDate" /></div></td>
									</tr>
								</logic:iterate>
							</logic:notEmpty>
						</logic:present>
		 	</table>
		 </td>
	</tr>
</table>
</html:form>
</body>
</html>
<script language="javascript">
  	
  	function checka(){
  	if(checkSubmit(document.medicineJbForm)){
  			//var medicineName=document.getElementById("medicineName").value;
	  	 	//var cgDate=document.getElementById("cgDate").value;
	  	 	//if(medicineName == ""){alert("品名不能为空！");return false;}
	  	 	if(medicineJbForm.beginDate.value.trim()==null||medicineJbForm.beginDate.value.trim()==""){alert("投标起始日不能为空！");return false;}
			document.medicineJbForm.action="MedicineJbAction.do?operate=Tqjb";
			document.medicineJbForm.submit();
	}
	}
	function sureJB(){    
		if(isBoxChecked(medicineJbForm.selectNos)){
			if(confirm("批量确认这些记录?")){
				 document.medicineJbForm.action="MedicineJbAction.do?operate=sureJB";
        		 document.medicineJbForm.submit();
			}
		}else{
			alert("请选择记录");
		}
}
</script> 
