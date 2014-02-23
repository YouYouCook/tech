<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/ssi.tld" prefix="ssi"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>供应商录入品种-列表</title>
<link href="<%=request.getContextPath()%>/styles/gzt_css.css" rel="stylesheet" type="text/css" />
<script language="javascript" src="<%=request.getContextPath()%>/js/control.js"></script>
<script language="javascript" src="<%=request.getContextPath()%>/js/commons.js"></script>
<script language="javascript" src="<%=request.getContextPath()%>/js/My97DatePicker/WdatePicker.js"></script>
<script language="javascript" src="<%=request.getContextPath()%>/js/date/common.js"></script>
<script language="javascript" src="<%=request.getContextPath()%>/js/formcheck.js"></script>
<script language="javascript" src="<%=request.getContextPath()%>/js/ajax.js"></script>
</head>
<body>
<jsp:include page="/common/exception.jsp" flush="true" />
<html:form 	method="post" action="/MedicineJbAction.do">
<input type="hidden" name="operate">
<input type="hidden" name="medicineId" id="medicineId" value="${medicineId }">
<div class="weizhi">
<div class="weizhi_bj">供应商录入品种管理</div>
<div class="weizhi_ss"><img id="controlSearchBtn" style="cursor:pointer" onclick="loadHiddenPage('<%=request.getContextPath()%>');" src="<%=request.getContextPath()%>/images/button_minus.gif" width="66" height="17" /></div>
</div>
</div>
<table border="0" cellspacing="0" cellpadding="0" class="table_chax" id="adSearch">
  <tr>
    <th width="12%">品名：</th>
    <td width="20%"><input type="text" name="name" value="${name}" title="品名" readonly/><input name="button" type="button" value="查询" onclick="openwinMedicine();" /></td>
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
    <th width="15%">供应商录入品种列表</th>
    <th width="85%">
	<div>
		本次竞标产品种类数:${qtys }&nbsp;&nbsp;&nbsp;&nbsp;总金额:${amounts }
	</div>
	</th>
  </tr>
  </br>
  
  <tr>
    <td colspan="2">
		<table border="0" cellpadding="0" cellspacing="0" class="table_date" id="dataTable">
		  <tr>
			<th>投标起始日</th>
			<th>投标截止日</th>
			<th>品名</th>
			<th>图片</th>
			<th>采购数量（kg）</th>
			<!-- <th>样品截止时间</th> -->
			<th>基本质量要求</th>
			<th>原料产地</th>
			<th>单价</th>
			<th>金额</th>
			<th>备注</th>
			<th>操作</th>
		  </tr>
		  <logic:present name="cineJbList">
				<logic:notEmpty name="cineJbList">
					<logic:iterate id="item" name="cineJbList" indexId="indexNo">
						<tr onmouseover="this.className='over'" onmouseout="this.className='out'" onclick="showInfo(<bean:write name="indexNo"/>,this);">
							
							<td><div><bean:write name="item" property="beginDate" /></div></td>
							<td><div><input type="hidden" id="<bean:write name="item" property="jbId"/>endDate" value="<bean:write name="item" property="endDate" />"/><bean:write name="item" property="endDate" /></div></td>
							<td><div><bean:write name="item" property="medicineCgBO.medicineBO.medicineName" /></div></td>
								<td>
											<logic:notEmpty name="item" property="medicineCgBO.medicineBO.medicineVistorimagePath">  
												 <img src=<bean:write name="item" property="medicineCgBO.medicineBO.medicineVistorimagePath" /> style="max-width:300px;height:50px;"/>
  					 						  </logic:notEmpty> 
											</td>
							<td><div><bean:write name="item" property="medicineCgBO.cgQty" /></div></td>
							<td><div STYLE="width: 120px; height: 20px; border: 0px solid blue;overflow: hidden; text-overflow:ellipsis" onmouseover="this.style.cssText='overflow:visible'" onmouseout="this.style.cssText='width:120px;height: 20px;border: 0px solid blue;overflow:hidden;text-overflow:ellipsis'"><bean:write name="item" property="medicineCgBO.medicineBO.zlyq" /></div></td>
							<td><div><input type="text" name="<bean:write name="item" property="jbId"/>ylcd" 
							id="<bean:write name="item" property="jbId"/>ylcd" 
							value="<bean:write name="item" property="ylcd"/>" size="10" /></div></td>
							<td><div>
							<input type="text" onblur="amount(this,'<bean:write name="item" property="jbId"/>','<bean:write name="item" property="medicineCgBO.cgQty"/>')" name="<bean:write name="item" property="jbId"/>price" 
							id="<bean:write name="item" property="jbId"/>price" 
							value="<bean:write name="item" property="price"/>" size="10"/>
							</div></td>
							<td><div><input type="text" id="<bean:write name="item" property="jbId"/>amount" value="${item.medicineCgBO.cgQty*item.price }" size="6" disabled></div></td>
							<td><div><input type="text" name="<bean:write name="item" property="jbId"/>remark" id="remark" value="<bean:write name="item" property="remark"/>" size="10" /></div></td>
							<td><div><input type="button" value="确认" 
							<logic:notEmpty name="item" property="price">
								disabled
							</logic:notEmpty>
							 onclick="qr('<bean:write name="item" property="jbId"/>')"/></div></td>
							<input type="hidden" name="jbId1" id="jbId1" />
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
					<logic:present name="cineJbList">
							<logic:empty name="cineJbList">
								<div style="text-align:center; height:30px; line-height:30px;">暂无记录！</div>
							</logic:empty>
					</logic:present>
					
					<ssi:page property="pageInfo"  action="/MedicineJbAction.do?operate=list"/>
	</div>
	</td>
  </tr>
</table>
</html:form>
</body>
</html>
<script language="javascript">
	
	function amount(obj,jbId,qty){
		document.getElementById(jbId+"amount").value=obj.value*qty;
	}
	
	function qr(obj){
			document.getElementById("jbId1").value=obj;
			var ajax = new AJAX();
			var url = "<%=request.getContextPath()%>/MedicineJbAction.do?operate=judeJB&jbId=" + obj +"&endDate=" + document.getElementById(obj+"endDate").value;
			ajax.post(url);
			var str = ajax.getValue().trim();
			if(str == "1")
			{
				alert("该产品已经截标！");
				return;
			}else
			{
			
				var price = document.getElementById(obj+"price").value.trim();
				var ylcd = document.getElementById(obj+"ylcd").value.trim();
				if (ylcd==null||ylcd==""){
					alert("请填写原料产地");
					return;
				}
				if (price==null||price==""){
					alert("请填写单价");
					return;
				}else if (!isFloat(price)){
					alert("单价请填写数字");
					return;
				}
			
				if(confirm("一旦确认，不能修改，您确定进行本次确认操作吗？"))
				{
					document.medicineJbForm.operate.value="jbConfirm";
					medicineJbForm.submit();
				}
			}
	}
	
	function  check(){
		document.medicineJbForm.operate.value="list";
		medicineJbForm.submit();
	}
	
	
	function openwinMedicine()
    { 
    	var returnValue=window.showModalDialog("<%=request.getContextPath()%>/medicineManage.do?operate=windowlist",window, "dialogWidth:700px,dialogHeight:335px,dialogTop:200px,dialogLeft,200px ");
 		if(returnValue && returnValue!="")
 		{
	 	  	var  ret =returnValue.split(',');
	 	   	window.document.all['name'].value =ret[0];
	 	   	//window.document.all['customerVipBO.medicineId'].value=ret[1];
	 	  	document.getElementById("medicineId").value=ret[1];
 		}
  	}
</script> 
