<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/ssi.tld" prefix="ssi"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>招标信息查询-列表</title>
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
<html:form 	method="post"  action="/MedicineCgAction.do">
<input type="hidden" name="operate">
<input type="hidden" name="medicineId" id="medicineId" value="${medicineId }">
<div class="weizhi">
<div class="weizhi_bj">招标信息查询</div>
<div class="weizhi_ss"><img id="controlSearchBtn" style="cursor:pointer" onclick="loadHiddenPage('<%=request.getContextPath()%>');" src="<%=request.getContextPath()%>/images/button_minus.gif" width="66" height="17" /></div>
</div>
</div>
<table border="0" cellspacing="0" cellpadding="0" class="table_chax" id="adSearch">
  <tr>
    <th width="12%">品名：</th>
    <td width="20%"> <input type="text" name="name" value="${name}" readonly/><input name="button" type="button" value="查询" onclick="openwinMedicine();" /></td>
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
    <th width="15%">招标信息查询列表</th>
    <th width="85%">
	<div>
      <font color="red">产品只有到投标截止日才可以看到</font>
	</div>
	</th>
  </tr>
  <tr>
    <td colspan="2">
		<table border="0" cellpadding="0" cellspacing="0" class="table_date" id="dataTable">
		 <logic:present name="medicineCgBO">
							<logic:notEmpty name="medicineCgBO">
		  <tr>
			<th>品名：<bean:write name="medicineCgBO" property="medicineBO.medicineName" /></th>
			<th>计划采购数量（公斤）</th>
			<th><bean:write name="medicineCgBO" property="cgQty" /></th>
			<th>交大货最迟时间</th>
			<th><bean:write name="medicineCgBO" property="reachDate" /></th>
		  </tr>
		  </logic:notEmpty>
		  </logic:present>
		 </table>
	</td>
	</tr>
	<tr>
	<td colspan="2">
		<table border="0" cellpadding="0" cellspacing="0" class="table_date" id="dataTable">
		  <tr>
		  	<th>样品序列号</th>
		  	<th>投标起始日</th>
			<th>投标截止日</th>		
			<th>原料产地</th>
			<th>供货商代码</th>
			<th>供货商</th>
			<!--<th>安国报价</th>
			<th>亳州报价</th>
			<th>历史纯出粉率(%)</th>-->
			<th>备注</th>
			<!-- <th>初选标识</th> -->
			<!-- <th>意见</th> -->
			<!-- <th>操作</th>  -->	
		  </tr>
		  <logic:present name="cineJbList">
				<logic:notEmpty name="cineJbList">
				
					<logic:iterate id="item" name="cineJbList" indexId="indexNo">
					<logic:equal name="item"  property="jbState" value="2">
					<logic:equal name="indexNo"  value="0">
					<tr bgcolor="D2F7F0"   onclick="showInfo(<bean:write name="indexNo"/>,this);">
					</logic:equal>
					<logic:notEqual name="indexNo"  value="0">
						<tr onmouseover="this.className='over'" onmouseout="this.className='out'" onclick="showInfo(<bean:write name="indexNo"/>,this);">
				     </logic:notEqual>		
							<td><div><bean:write name="item" property="medicineCode" /></div></td>
							<!--  <td><div><bean:write name="item" property="price" /></div></td>-->
							<!-- <td><div>${medicineCgBO.cgQty*item.price}</div></td>-->
							<td><div><bean:write name="item" property="beginDate" /></div></td>
							<td><div><bean:write name="item" property="endDate" /></div></td>
							<td><div><bean:write name="item" property="ylcd" /></div></td>
							<td><div><bean:write name="item" property="customerBO.customerAccount" /></div></td>
							<td><div><bean:write name="item" property="customerBO.name" /></div></td>
							<!-- 招标系统第4次修改，请勿删除 -->	
							<!-- <td><div>
								<select name="<bean:write name="item" property="jbId" />hgState">
									<option value="0" <logic:equal name="item" property="hgState" value="0">selected</logic:equal>>未标识</option>
									<option value="1" <logic:equal name="item" property="hgState" value="1">selected</logic:equal>>不合格</option>
									<option value="2" <logic:equal name="item" property="hgState" value="2">selected</logic:equal>>合格</option>
								</select>
								</div>
							</td>
							<td><div><input type="text" name="<bean:write name="item" property="jbId" />view" value="<bean:write name="item" property="view" />" id="<bean:write name="item" property="jbId" />view" value="<bean:write name="item" property="view" />" size="12"></div></td>					
							<td><div><input type="button" value="确认" 
							<logic:notEmpty name="item" property="view">
								disabled
							</logic:notEmpty>
							onclick="toConfirm('<bean:write name="item" property="jbId" />')"></div></td>	-->
							<!--<td><div><bean:write name="item" property="medicineCgBO.agbj" /></div></td>
							<td><div><bean:write name="item" property="medicineCgBO.bzbj" /></div></td>
							<td><div><bean:write name="item" property="medicineCgBO.lscfl" /></div></td>-->
							<td><div><bean:write name="item" property="remark" /></div></td>
						</tr>
					</logic:equal>	
						<input type="hidden" id="ids" name="ids" value="<bean:write name="item" property="jbId" />">
					</logic:iterate>
				</logic:notEmpty>
			</logic:present>
		 	</table>
	</td>
	</tr>
  <tr>
    <td height="40" colspan="2">
	
	</td>
  </tr>
</table>
</html:form>
</body>
</html>
<script language="javascript">
	
	
	function  check(){
		//if (medicineCgForm.name.value.trim()==null||medicineCgForm.name.value.trim()==""){
		//	alert("请填写品名");
		//	return;
		//}
		//if (medicineCgForm.beginDate.value.trim()==null||medicineCgForm.beginDate.value.trim()==""){
		//	alert("请填写投标起始日");
		//	return;
		//}
		//if (medicineCgForm.endDate.value.trim()==null||medicineCgForm.endDate.value.trim()==""){
		//	alert("请填写投标截止日");
			//return;
		//}
		document.medicineCgForm.operate.value="getTops";
		medicineCgForm.submit();
		
	}
	
	function  toConfirm(obj){
		document.getElementById("ids").value=obj;
		var view = document.getElementById(obj+"view").value.trim();
		if (view==null||view==""){
			alert("请填初选意见！");
			return;
		}
		if (confirm('请确认初选标识!')){
		document.medicineCgForm.operate.value="updateBx";
		medicineCgForm.submit();}
	}
	
	function zhijian(){
		
		if(document.getElementById("ids")!=null){
			if(confirm("确定要发送到质检部吗？"))
		    {
				document.medicineCgForm.operate.value="updateTops";
				medicineCgForm.submit();
			}
		}else{
			alert("没有排名选项");
		}
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
