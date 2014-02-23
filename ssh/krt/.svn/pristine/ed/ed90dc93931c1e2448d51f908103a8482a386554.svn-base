<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/ssi.tld" prefix="ssi"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>供应商查看招标结果-列表</title>
<link href="<%=request.getContextPath()%>/styles/gzt_css.css" rel="stylesheet" type="text/css" />
<script language="javascript" src="<%=request.getContextPath()%>/js/control.js"></script>
<script language="javascript" src="<%=request.getContextPath()%>/js/commons.js"></script>
<script language="javascript" src="<%=request.getContextPath()%>/js/date/common.js"></script>
<script language="javascript" src="<%=request.getContextPath()%>/js/formcheck.js"></script>
<script language="javascript" src="<%=request.getContextPath()%>/js/My97DatePicker/WdatePicker.js"></script>
</head>
<body>
<jsp:include page="/common/exception.jsp" flush="true" />
<html:form 	method="post" action="/MedicineZbAction.do?operate=resultForSuppliersList">
<input id="medicineId" type="hidden" name="medicineId">
<div class="weizhi">
<div class="weizhi_bj">供应商查看招标结果</div>
<div class="weizhi_ss"><img id="controlSearchBtn" style="cursor:pointer" onclick="loadHiddenPage('<%=request.getContextPath()%>');" src="<%=request.getContextPath()%>/images/button_minus.gif" width="66" height="17" /></div>
</div>
</div>
<table border="0" cellspacing="0" cellpadding="0" class="table_chax" id="adSearch">
  <tr>
    <!--  <th width="12%">品名：</th>
    <td width="20%"><input type="text" name="medicineName" value="${medicineName}" title="品名"/><input name="button" type="button" value="查询" onclick="openwinMedicine();" /></td> -->
    <th width="8%">投标起始日：</th>
    <td><input type="text" name="beginDate" value="${beginDate}"  size="6"  title="投标起始日" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" class="Wdate" readonly="true"/>
	</td>
    <th><input name="checks"  type="button" value="查询" onclick="checka()"/></th>
    <td></td>
  </tr>
</table>
<table border="0" cellpadding="0" cellspacing="0" class="table_list">
  <tr>
    <th width="15%">查看中标结果信息</th>
    <th width="85%">
	<div>
	</div>
	</th>
  </tr>
  </br>
  
  <tr>
    <td colspan="2">
		<table border="0" cellpadding="0" cellspacing="0" class="table_date" id="dataTable">
		  <tr>
			<th>品名</th>
			<th>计划采购数量</th>
			<!--<th>样品截止时间</th>-->
			<th>基本质量要求</th> 
			<th>原料产地</th>
			<th>单价</th>
			<th>金额</th>
			<th>中标结果</th>
			<th>备注</th>

		  </tr>
		  <logic:present name="reslutList">
							<logic:notEmpty name="reslutList">
								<logic:iterate id="item" name="reslutList" indexId="indexNo">
									<tr onmouseover="this.className='over'" onmouseout="this.className='out'" onclick="showInfo(<bean:write name="indexNo"/>,this);">
										<td><div><bean:write name="item" property="medicineJbBO.medicineCgBO.medicineBO.medicineName" /></div></td>
										<td><div><bean:write name="item" property="medicineJbBO.medicineCgBO.cgQty" /></div></td>
										<!--<td><div><bean:write name="item" property="medicineJbBO.medicineCgBO.reachDate" /></div></td>-->
										<td><div STYLE="width: 120px; height: 20px; border: 0px solid blue;overflow: hidden; text-overflow:ellipsis" onmouseover="this.style.cssText='overflow:visible'" onmouseout="this.style.cssText='width:120px;height: 20px;border: 0px solid blue;overflow:hidden;text-overflow:ellipsis'"><bean:write name="item" property="medicineJbBO.medicineCgBO.medicineBO.zlyq" /></div></td>
										<td><div><bean:write name="item" property="medicineJbBO.ylcd" /></div></td>
										<td><div><bean:write name="item" property="medicineJbBO.price" /></div></td>
										<td><div>${item.medicineJbBO.medicineCgBO.cgQty*item.medicineJbBO.price }</div></td>
										<td><div><logic:equal name="item"  property="zbState" value="1">中标</logic:equal>
										<logic:notEqual name="item"  property="zbState" value="1">未中标</logic:notEqual></div></td>
										<td><div><bean:write name="item" property="medicineJbBO.remark" /></div></td>									
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
					<logic:present name="list">
							<logic:empty name="list">
								<div style="text-align:center; height:30px; line-height:30px;">暂无记录！</div>
							</logic:empty>
					</logic:present>
					
					<ssi:page property="pageInfo"  action="/MedicineZbAction.do?operate=resultForSuppliersList"/>
	</div>
	</td>
  </tr>
</table>
</html:form>
</body>
</html>
<script language="javascript">
 function openwinMedicine()
    { 
    	var returnValue=window.showModalDialog("<%=request.getContextPath()%>/medicineManage.do?operate=windowlist",window, "dialogWidth:700px,dialogHeight:335px,dialogTop:200px,dialogLeft,200px ");
 		if(returnValue && returnValue!="")
 		{
	 	  	var  ret =returnValue.split(',');
	 	   	document.getElementById("medicineName").value =ret[0];
	 	   	document.getElementById("medicineId").value=ret[1];
 		}
  	}
  	
  	function checka(){
  	if(checkSubmit(document.medicineZbForm)){
		document.medicineZbForm.action="MedicineZbAction.do?operate=resultForSuppliersList";
		document.medicineZbForm.submit();
	}
	}
</script> 
