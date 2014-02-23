<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/ssi.tld" prefix="ssi"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>管理员确认招标结果-列表</title>
<link href="<%=request.getContextPath()%>/styles/gzt_css.css" rel="stylesheet" type="text/css" />
<script language="javascript" src="<%=request.getContextPath()%>/js/control.js"></script>
<script language="javascript" src="<%=request.getContextPath()%>/js/commons.js"></script>
<script language="javascript" src="<%=request.getContextPath()%>/js/date/common.js"></script>
<script language="javascript" src="<%=request.getContextPath()%>/js/formcheck.js"></script>
<script language="javascript" src="<%=request.getContextPath()%>/js/My97DatePicker/WdatePicker.js"></script>
</head>
<body>
<jsp:include page="/common/exception.jsp" flush="true" />
<html:form 	method="post" action="/MedicineZbAction.do?operate=resultList">
<input id="medicineId" type="hidden" name="medicineId" value="${medicineId}">
<div class="weizhi">
<div class="weizhi_bj">管理员确认招标结果</div>
<div class="weizhi_ss"><img id="controlSearchBtn" style="cursor:pointer" onclick="loadHiddenPage('<%=request.getContextPath()%>');" src="<%=request.getContextPath()%>/images/button_minus.gif" width="66" height="17" /></div>
</div>
</div>
<table border="0" cellspacing="0" cellpadding="0" class="table_chax" id="adSearch">
  <tr>
     <th width="12%">品名：</th>
    <td width="20%"><input type="text" id="medicineName" readonly="true" name="medicineName" value="${medicineName}" title="品名"/><input name="button" type="button" value="查询" onclick="openwinMedicine();" /></td>
    <th>投标起始日：</th>
    <td colspan="3"><input type="text" name="beginDate" value="${beginDate}"  readonly="true" size="6" title="投标起始日" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" class="Wdate" /><font color="red">请选择确切日期</font>
	</td>
    <th><input name="checks"  type="button" value="查询" onclick="checka()"/></th>
    <td></td>
  </tr>
</table>
<table border="0" cellpadding="0" cellspacing="0" class="table_list">
  <tr>
    <th width="15%">VIP供应商招标结果信息</th>
    <th width="85%">
	<div>
	<input name="toAdd" type="button" value="确认流标" onclick="sureLB()" />
	  <input name="toAdd" type="button" value="确认中标" onclick="sureZB()" />
	</div>
	</th>
  </tr>
  </br>
  
  <tr>
    <td colspan="2">
		<table border="0" cellpadding="0" cellspacing="0" class="table_date" id="dataTable">
		  <tr>
			<th width="2%">选择中标VIP供应商</th>
			<th width="8%">供应商名称</th>
			<th width="8%">是否中标</th>
		  </tr>
		  <logic:present name="customerVipList">
							<logic:notEmpty name="customerVipList">
								<logic:iterate id="item" name="customerVipList" indexId="indexNo">
									<tr onmouseover="this.className='over'" onmouseout="this.className='out'" onclick="showInfo(<bean:write name="indexNo"/>,this);">
										<td><input
											type="radio" name="selectNos"	id="radioId<bean:write name="indexNo"/>"
											value="customer,<bean:write name="item" property="customerId"/>,<bean:write name="item" property="medicineId"/>"
											onclick="doBoxChange(medicineZbForm.isAll,medicineZbForm.selectNos);" /></td>
										<td align="center"><div ><bean:write name="item" property="customerBO.name" /></div></td>
										<td align="center"><div ><logic:equal name="item" property="state"  value="1"><font color="red">中标</font></logic:equal><logic:notEqual name="item" property="state"  value="1">未中标</logic:notEqual></div></td>
									</tr>
								</logic:iterate>
							</logic:notEmpty>
						</logic:present>
		 		</table>
		 </td>
	</tr>
</table>
<table border="0" cellpadding="0" cellspacing="0" class="table_list">
  <tr>
    <th width="15%">其它供应商招标结果信息</th>
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
			<th width="8%">选择中标供应商</th>
			<th width="12%">供应商名称</th>
			<th>计划采购数量</th>		
			 <th>单价</th>
			<th>金额</th>
			<!--<th>初选标识</th>-->
			<!--<th>初选意见</th>-->
			<th>安国报价</th>
			<th>亳州报价</th>
			<!--<th>是否合格</th>-->
			<!--<th>含水量(%)</th>--> 
			<th>出粉率(%)</th>
			<th width="14%">性价比</th>
			<th width="8%">是否中标</th>
			<th>备注</th>
		  </tr>
		  <logic:present name="reslutList">
							<logic:notEmpty name="reslutList">
								<logic:iterate id="item" name="reslutList" indexId="indexNo">
									<tr onmouseover="this.className='over'" onmouseout="this.className='out'" onclick="showInfo('${indexNo + fn:length(customerVipList)}',this);">
										<td><input
											type="radio" name="selectNos"	id="radioId${indexNo + fn:length(customerVipList)}"
											value="<bean:write name="item" property="zbId"/>,<bean:write name="item" property="medicineJbBO.customerBO.customerId"/>,<bean:write name="item" property="medicineJbBO.medicineCgBO.medicineBO.medicineId"/>,
											<bean:write name="item" property="medicineJbBO.beginDate"/>"
											onclick="doBoxChange(medicineZbForm.isAll,medicineZbForm.selectNos);" /></td>
										<td><div><bean:write name="item" property="medicineJbBO.customerBO.name" /></div></td>
										<td><div><bean:write name="item" property="medicineJbBO.medicineCgBO.cgQty" /></div></td>
										<!--  <td><div><bean:write name="item" property="medicineJbBO.medicineCgBO.reachDate" /></div></td>
										<td><div><bean:write name="item" property="medicineJbBO.ylcd" /></div></td>-->
										<td><div><bean:write name="item" property="medicineJbBO.price" /></div></td>
										<td><div>${item.medicineJbBO.medicineCgBO.cgQty*item.medicineJbBO.price }</div></td>
										<!--<td><div><logic:equal name="item"  property="medicineJbBO.hgState" value="1">不合格</logic:equal><logic:equal name="item"  property="medicineJbBO.hgState" value="2">合格</logic:equal><logic:equal name="item"  property="medicineJbBO.hgState" value="">未标识</logic:equal></div></td>-->
										<!--<td><div><bean:write name="item" property="medicineJbBO.view" /></div></td>-->
										<td><div><bean:write name="item" property="medicineJbBO.medicineCgBO.agbj" /></div></td>
										<td><div><bean:write name="item" property="medicineJbBO.medicineCgBO.bzbj" /></div></td>
										<!--<td><div>合格</div></td>
										<td><div><bean:write name="item" property="hsl" /></div></td>-->
										<td><div><bean:write name="item" property="cfl" /></div></td>
										<td><div>${item.medicineJbBO.price/((100-item.hsl)*item.cfl)*10000}</div></td>
										<input type="hidden" name="date" value="<bean:write name="item" property="medicineJbBO.beginDate" />">
										<td align="center"><div ><logic:equal name="item" property="zbState"  value="1"><font color="red">中标</font></logic:equal><logic:notEqual name="item" property="zbState"  value="1">未中标</logic:notEqual></div></td>
										<td><div STYLE="width: 120px; height: 20px; border: 0px solid blue;overflow: hidden; text-overflow:ellipsis" onmouseover="this.style.cssText='overflow:visible'" onmouseout="this.style.cssText='width:120px;height: 20px;border: 0px solid blue;overflow:hidden;text-overflow:ellipsis'"><bean:write name="item" property="remark" /></div></td>
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
 function openwinMedicine()
    { 
    	var returnValue=window.showModalDialog("<%=request.getContextPath()%>/medicineManage.do?operate=windowlist",window, "dialogWidth:700px,dialogHeight:335px,dialogTop:200px,dialogLeft,200px ");
    	if (returnValue == undefined) {
            returnValue = window.returnValue;
        }
    	if(returnValue && returnValue!="")
 		{
	 	  	var  ret =returnValue.split(',');
	 	   	document.getElementById("medicineName").value =ret[0];
	 	   	document.getElementById("medicineId").value=ret[1];
 		}
  	}
  	
  	function checka(){
	  	if(checkSubmit(document.medicineZbForm)){
	  	 	var medicineName=document.getElementById("medicineName").value;
	  	 	//var cgDate=document.getElementById("cgDate").value;
	  	 	if(medicineName == ""){alert("品名不能为空！");return false;}
	  	 	if(medicineZbForm.beginDate.value.trim()==null||medicineZbForm.beginDate.value.trim()==""){alert("投标起始日不能为空！");return false;}
	  	 	
				document.medicineZbForm.action="MedicineZbAction.do?operate=resultList";
				document.medicineZbForm.submit();
			
			
		}
	}
	function sureZB(){    
        if(isRadioChecked(medicineZbForm.selectNos))
        {
        document.medicineZbForm.action="MedicineZbAction.do?operate=sureZB";
        document.medicineZbForm.submit();
        }
        else
        {
            alert("请选择中标的供应商信息!");
        }
	}
	function sureLB(){        
        document.medicineZbForm.action="MedicineZbAction.do?operate=sureLB";
        document.medicineZbForm.submit();
	}
</script> 
