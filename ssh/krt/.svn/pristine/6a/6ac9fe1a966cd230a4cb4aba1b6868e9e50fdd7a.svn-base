<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/ssi.tld" prefix="ssi"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>质量部检测-列表</title>
<link href="<%=request.getContextPath()%>/styles/gzt_css.css" rel="stylesheet" type="text/css" />
<script language="javascript" src="<%=request.getContextPath()%>/js/control.js"></script>
<script language="javascript" src="<%=request.getContextPath()%>/js/commons.js"></script>
<script language="javascript" src="<%=request.getContextPath()%>/js/date/common.js"></script>
<script language="javascript" src="<%=request.getContextPath()%>/js/My97DatePicker/WdatePicker.js"></script>
<script language="javascript" src="<%=request.getContextPath()%>/js/formcheck.js"></script>
<script language="javascript" src="<%=request.getContextPath()%>/js/formcheck.js"></script>
</head>
<body>
<jsp:include page="/common/exception.jsp" flush="true" />
<html:form 	method="post" action="/MedicineZbAction">
<input type="hidden" name="operate">
<input type="hidden" name="medicineId" id="medicineId" value="${medicineId }">
<div class="weizhi">
<div class="weizhi_bj">质量部检测招标品种</div>
<div class="weizhi_ss"><img id="controlSearchBtn" style="cursor:pointer" onclick="loadHiddenPage('<%=request.getContextPath()%>');" src="<%=request.getContextPath()%>/images/button_minus.gif" width="66" height="17" /></div>
</div>
</div>
<table border="0" cellspacing="0" cellpadding="0" class="table_chax" id="adSearch">
  <tr>
    <th width="12%">样品编号：</th>
    <td width="10%"><html:text property="medicineCode" size="12"></html:text></td>
    <th width="">品名：</th>
    <td width=""> <input type="text" name="name" value="${name}" title="品名"  size="12"/><input name="button" type="button" value="查询" onclick="openwinMedicine();" /></td>
    <th width="">合格状态：</th>
    <td width=""> <select name="state" style= "width:100px">
    										<option value="" <logic:equal name="state" value="">selected</logic:equal>>请选择</option>
											<option value="0" <logic:equal name="state" value="0">selected</logic:equal>>未检测</option>
											<option value="1" <logic:equal name="state" value="1">selected</logic:equal>>不合格</option>
											<option value="2" <logic:equal name="state" value="2">selected</logic:equal>>合格</option>
										</select></td>
   <th width="">投标起始日：</th>
    <td><input type="text" name="beginDate" value="${beginDate}"  readonly="true" size="6" title="投标起始日" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" class="Wdate" />
	</td>
	<th width="">投标截止日：</th>
    <td><input type="text" name="endDate" value="${endDate}"  readonly="true" size="6" title="投标截止日" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" class="Wdate" />
	</td>
    <th><input name="checks"  type="button" value="查询" onclick="check()"/></th>
    <td></td>
  </tr>
</table>
<table border="0" cellpadding="0" cellspacing="0" class="table_list">
  <tr>
    <th width="15%">检测结果信息列表</th>
    <th width="85%">
	<div>
	</div>
	</th>
  </tr>
  <tr>
    <td colspan="2">
		<table border="0" cellpadding="0" cellspacing="0" class="table_date" id="dataTable">
		  <tr>
		  	<th width="8%">投标起始日</th>
		  	<th width="8%">投标截止日</th>
			<th width="9%">样品序列号</th>
			<th>品名</th>
			<th>原料产地</th>
			<!-- <th>初选标识</th> -->
			<!--<th>初选意见</th> -->
			<th>是否合格</th>
			<!--<th>含水量(%)</th> -->
			<th width="10%">历史纯出粉率(%)</th>
			<th>出粉率(%)</th>
			<th>检测员</th>
			<th>审核人</th>
			<th>备注</th>
			<th>操作</th>
		  </tr>
		  <logic:present name="cineZbList">
							<logic:notEmpty name="cineZbList">
								<logic:iterate id="item" name="cineZbList" indexId="indexNo">
									<tr onmouseover="this.className='over'" onmouseout="this.className='out'" onclick="showInfo(<bean:write name="indexNo"/>,this);">
										<td><div><bean:write name="item" property="beginDate" /></div></td>
										<td><div><bean:write name="item" property="endDate" /></div></td>
										<td><div><bean:write name="item" property="medicineJbBO.medicineCode" /></div></td>
										<td><div><bean:write name="item" property="medicineJbBO.medicineCgBO.medicineBO.medicineName" /></div></td>
										<!--  <td><div><bean:write name="item" property="medicineJbBO.medicineCgBO.reachDate" /></div></td>-->
										<td><div><bean:write name="item" property="medicineJbBO.ylcd" /></div></td>
										<!-- <td><div><logic:equal name="item"  property="medicineJbBO.hgState" value="1">不合格</logic:equal><logic:equal name="item"  property="medicineJbBO.hgState" value="2">合格</logic:equal><logic:equal name="item"  property="medicineJbBO.hgState" value="">未标识</logic:equal></div></td>-->
										<!-- <td><div><bean:write name="item" property="medicineJbBO.view" /></div></td> -->
										<td><div>
										<select name="<bean:write name="item" property="zbId" />state">
											<option value="0" <logic:equal name="item" property="state" value="0">selected</logic:equal>>未检测</option>
											<option value="1" <logic:equal name="item" property="state" value="1">selected</logic:equal>>不合格</option>
											<option value="2" <logic:equal name="item" property="state" value="2">selected</logic:equal>>合格</option>
										</select>
										</div></td>
										<!-- <td><div><input type="text" name="<bean:write name="item" property="zbId" />hsl" value="<bean:write name="item" property="hsl" />" id="<bean:write name="item" property="zbId" />hsl" value="<bean:write name="item" property="hsl" />" size="4"></div></td>-->
										<td><div><bean:write name="item" property="medicineJbBO.medicineCgBO.lscfl" /></div></td>
										<td><div><input type="text" name="<bean:write name="item" property="zbId" />cfl" value="<bean:write name="item" property="cfl" />" id="<bean:write name="item" property="zbId" />cfl" value="<bean:write name="item" property="cfl" />" size="4"></div></td>
										<td><div><input type="text" name="<bean:write name="item" property="zbId" />jcy" value="<bean:write name="item" property="jcy" />" size="4"></div></td>
										<td><div><input type="text" name="<bean:write name="item" property="zbId" />shr" value="<bean:write name="item" property="shr" />" size="4"></div></td>
										<td><div><input type="text" name="<bean:write name="item" property="zbId" />remark" value="<bean:write name="item" property="remark" />" size="4" maxlength="200"></div></td>
										<td><div><input type="button" value="确认" onclick="toConfirm('<bean:write name="item" property="zbId" />')"></div></td>
										<input type="hidden" name="zbId1" id="zbId1" >
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
					<logic:present name="cineZbList">
							<logic:empty name="cineZbList">
								<div style="text-align:center; height:30px; line-height:30px;">暂无记录！</div>
							</logic:empty>
					</logic:present>
					
					<ssi:page property="pageInfo"  action="/MedicineZbAction.do?operate=list"/>
	</div>
	</td>
  </tr>
</table>
</html:form>
</body>
</html>
<script language="javascript">
	function  check(){
		if(checkSubmit(document.medicineZbForm)){
		document.medicineZbForm.operate.value="list";
		medicineZbForm.submit();
		}
	}
	
	function  toConfirm(obj){
		document.getElementById("zbId1").value=obj;
		//var hsl = document.getElementById(obj+"hsl").value.trim();
		var cfl = document.getElementById(obj+"cfl").value.trim();
		//if (hsl==null||hsl==""){
		//	alert("请填写含水量");
		//	return;
		//}
		//if (!Number(hsl)){
		//	alert("含水量请填写数字");
		//	return;
		//}
		if (cfl==null||cfl==""){
			alert("请填写出粉率");
			return;
		}
		if (!Number(cfl)){
			alert("出粉率请填写数字");
			return;
		}
		if (confirm('请确认检测结果是否正确!')){
		document.medicineZbForm.operate.value="update";
		medicineZbForm.submit();}
	}
	
	function  toadd(){
		document.employeesForm.operate.value="toCheckProductLr";
		employeesForm.submit();
	}
	function  tomodify(){
		document.employeesForm.operate.value="toSuppliersLrModify";
		employeesForm.submit();
	}
	function openwinMedicine()
    { 
    	var returnValue=window.showModalDialog("<%=request.getContextPath()%>/medicineManage.do?operate=medicineWindowForCg",window, "dialogWidth:700px,dialogHeight:335px,dialogTop:200px,dialogLeft,200px ");
 		if(returnValue && returnValue!="")
 		{
	 	  	var  ret =returnValue.split(',');
	 	   	window.document.all['name'].value =ret[0];
	 	   	document.getElementById("medicineId").value=ret[1];
	 	   	//window.document.all['customerVipBO.medicineId'].value=ret[1];
	 	  
 		}
  	}
</script> 
