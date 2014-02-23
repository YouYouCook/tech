<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/ssi.tld" prefix="ssi"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>添加库存信息</title>
<link href="<%=request.getContextPath()%>/styles/gzt_css.css" rel="stylesheet" type="text/css" />
<script language="javascript" src="<%=request.getContextPath()%>/js/commons.js"></script>
<script language="javascript" src="<%=request.getContextPath()%>/js/control.js"></script>
<script language="javascript" src="<%=request.getContextPath()%>/js/date/common.js"></script>
<script language="javascript" src="<%=request.getContextPath()%>/js/formcheck.js"></script>
<script language="javascript" src="<%=request.getContextPath()%>/js/ajax.js"></script>
<script language="javascript" src="<%=request.getContextPath()%>/js/My97DatePicker/WdatePicker.js"></script>
</head>
<body>
<jsp:include page="/common/ajaxSession.jsp" />
<html:form method="post" action="/storageManage.do?operate=toAdd">
<input type="hidden" name="operate">
<input type="hidden" name="storageBO.id"  value="${storageBO.id}">
<input type="hidden" name="storageBO.supplyid"  id="supplyid">
<div class="weizhi">
	<div class="weizhi_bj">添加库存信息</div>
</div>
<table width="100%" border="0" cellspacing="0" cellpadding="0" class="table_add">
<tr>
    <td colspan="4">注意：<span>*</span> 号为必填项！</td>
  	</tr>
<tr>
 <th width="12%">品名：</th>
 <td width="20%"> <input type="text" name="storageBO.name" value="${storageBO.name}" /><input name="button" type="button" value="查询" onclick="openwinMedicine();" /></td>
<th>品号：</th>
  <td><html:text property="storageBO.pinhao" styleId="Y_str_storageBO.pinhao"  value="${storageBO.pinhao}"   title="规格" maxlength="20"></html:text><span>*</span>
</tr>
 <tr>
   <th width="12%">供货单位：</th>
   <td width="20%"> <input type="text" name="storageBO.supplyname" value="${storageBO.supplyname}" /><input name="button" type="button" value="查询" onclick="openwinSupplier();" /></td>
			     <th>放行日期：</th>
		    <td width="25%">
									<input type="text" name="storageBO.fangxingdate"   value="${storageBO.fangxingdate}"  size="20" title="有效期至：" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" class="Wdate" /><font color="red">请选择确切日期</font>
			</td>
 
 </tr>
   <tr>
   <th width="12%">品种属性：</th>
   <td width="20%"> <input type="text" name="storageBO.pinzhongshuxing" title="品种属性"  styleId="Y_str_storageBO.pinzhongshuxing"  value="${storageBO.pinzhongshuxing}" /><span>*</span></td>
 </tr>
<tr>
	  <th>次数：</th>
    <td><html:text property="storageBO.times" styleId="N_int_storageBO.times"  value="${storageBO.times}"    title="次数" maxlength="20"></html:text><font>为数字</font>	
	</td>
	
	
    <th width="25%">批号：</th>
   	<td width="25%">
	<input type="text" name="storageBO.pnumber" value="${storageBO.pnumber}"  size="20" title="批号" />
	</td>
 </tr>
<tr>
  <th width="25%">清验单号</th>
  <td width="25%">
	<input type="text" name="storageBO.checknumber" value="${storageBO.checknumber}" size="20" title="清验单号" />
  </td>
	   <th>到达后称量数量：</th>
	   <td><html:text property="storageBO.daodaozhongliang" styleId="N_str_storageBO.daodaozhongliang"  value="${storageBO.daodaozhongliang}"      title="件数" maxlength="20"></html:text>
		
	</td>
</tr>
  	
 <tr>
  <th width="25%">存放地：</th>
	<td width="25%">
	 <input type="text" name="storageBO.locationcity" value="${storageBO.locationcity}" size="20" title="有效期至：" />
	</td>
	     <th width="25%">收货日期：</th>
	   <td width="25%">
		<input type="text" name="storageBO.fromdate" value="${storageBO.fromdate}" size="20" title="有效期至：" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" class="Wdate" /><font color="red">请选择确切日期</font>
	</td>
</tr>
<tr>
	<th>产地：</th>
	<td><html:text property="storageBO.detailchandi" styleId="N_str_storageBO.chandi"   value="${storageBO.detailchandi}"   title="规格" maxlength="30"></html:text>
	</td>
	<th>规格：</th>
	<td><html:text property="storageBO.guige" styleId="N_str_storageBO.guige"  value="${storageBO.guige}"   title="规格" maxlength="20"></html:text>
	</td>
 </tr>
 	  
 <tr>
	<th>件数：</th>
	<td><html:text property="storageBO.jianshu" styleId="N_int_storageBO.jianshu"   value="${storageBO.jianshu}"  title="件数" maxlength="20"></html:text><font>件数为数字</font>
	</td>
	 <th>数量(kg)：</th>
	 <td><html:text property="storageBO.shuliang" styleId="N_str_storageBO.shishoushuliang"    value="${storageBO.shuliang}"  title="件数" maxlength="20"></html:text>
	</td>
 </tr>
  	  
<tr>
	  <th width="25%">到货日期：</th>
		<td width="25%">
				<input type="text" name="storageBO.fromdate"  size="20" title="有效期至："   value="${storageBO.fromdate}"   onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" class="Wdate" /><font color="red">请选择确切日期</font>
		</td>
	  <th width="25%">送样日期：</th>
	   <td width="25%">
			   <input type="text" name="storageBO.demodate"  size="20" title="有效期至："   value="${storageBO.demodate}"   onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" class="Wdate" /><font color="red">请选择确切日期</font>
		</td>
 </tr>
 
		
	
  
     <tr>
	     <th width="25%">合格后发货日期：</th>
    <td width="25%">
							<input type="text" name="storageBO.senddate" value="${storageBO.senddate}" size="20" title="有效期至：" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" class="Wdate" /><font color="red">请选择确切日期</font>
	</td>
	      <th>检验结果</th>
				 <td>	   <select name="storageBO.checkresult" style= "width:100px">
    										<option value="" <logic:equal name="storageForm" property="storageBO.checkresult"   value="">selected</logic:equal>>请选择</option>
											<option  value="待验" <logic:equal name="storageForm" property="storageBO.checkresult"   value="待验">selected</logic:equal>>待验</option>
											<option value="合格" <logic:equal name="storageForm"  property="storageBO.checkresult"  value="合格">selected</logic:equal>>合格</option>
											<option  value="不合格" <logic:equal name="storageForm"  property="storageBO.checkresult"  value="不合格">selected</logic:equal>>不合格</option>
										</select></td>
  </tr>
  <tr>
    <th>接收地点：</th>
    <td><html:text property="storageBO.receivelocation" styleId="N_USN_storageBO.receivelocation"  value="${storageBO.receivelocation}"   title="运输方式" maxlength="50"></html:text><font>地址为汉字</font>	
	</td>
	 <th>原料到达日期：</th>
	 <td>
							<input type="text" name="storageBO.yuanliaodaodate" value="${storageBO.yuanliaodaodate}" size="20" title="有效期至：" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" class="Wdate" /><font color="red">请选择确切日期</font>
	</td>
	 </tr>
	 
	    <tr>

	
	 </tr>
	 
	    <tr>
	   <th>备注：</th>
	   <td><html:text property="storageBO.beizhu" styleId="N_str_storageBO.beizhu"   value="${storageBO.beizhu}"    title="件数" maxlength="20"></html:text>
		
	</td>
	<th>发货地址：</th>
	   <td><html:text property="storageBO.sendaddress" styleId="N_str_storageBO.sendaddress"   value="${storageBO.sendaddress}"      title="件数" maxlength="20"></html:text>
		
	</td>
	
	
	  <tr>
	   <th>退货数量：</th>
	   <td><html:text property="storageBO.tuihuoshuliang" styleId="N_str_storageBO.tuihuoshuliang"   value="${storageBO.tuihuoshuliang}"    title="件数" maxlength="20"></html:text>
		
	</td>
	<th>退货日期：</th>
	   <td>	<input type="text" name="storageBO.tuihuoriqi" styleId="N_str_storageBO.tuihuoriqi"   value="${storageBO.tuihuoriqi}"   onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" class="Wdate"     title="件数" maxlength="20"/><font color="red">请选择确切日期</font>
		
	</td>
 </tr>
  
   
  <tr>
    <td colspan="2">
	<div>
	<input type="button" name="Submit" value="确 认" onclick="updateShqd()"/>
    <input type="button" name="Submit2" value="重 置" onclick="reset();"/>
    <input type="button" name="Submit3" value="返 回" onclick="backup();"/>
	</div>
	</td>
  </tr>
</table>
</html:form>
</body>
</html>
<script language="JavaScript">
    function updateShqd()
    {
    	
       		 if(checkSubmit(document.storageForm)){
    		    if(confirm("确定要增加此信息吗？"))
		        {
		         	document.storageForm.action="storageManage.do?operate=add";
					storageForm.submit();
		        }
        	}
        
	     
    }
    function backup()
    {
    	document.storageForm.action="storageManage.do?operate=list";
        document.storageForm.submit();
    }

   function reset()
    {       		
    	document.storageForm.reset();  
    }
	function openwinMedicine()
    { 
    	var returnValue=window.showModalDialog("<%=request.getContextPath()%>/medicineManage.do?operate=windowlist",window, "dialogWidth:700px,dialogHeight:335px,dialogTop:200px,dialogLeft,200px ");
    	if (returnValue == undefined) {
            returnValue = window.returnValue;
        }
    	if(returnValue && returnValue!="")
 		{
	 	  	var  ret =returnValue.split(',');
	 	   	window.document.all['storageBO.name'].value =ret[0];
	 	 	//document.getElementById("pinzhongid").value=ret[1];
 		}
  	}
	
	function openwinSupplier()
    { 
    	var returnValue=window.showModalDialog("<%=request.getContextPath()%>/supplier.do?operate=windowlist",window, "dialogWidth:700px,dialogHeight:335px,dialogTop:200px,dialogLeft,200px ");
 		if(returnValue && returnValue!="")
 		{
	 	  	var  ret =returnValue.split(',');
	 	   	window.document.all['storageBO.supplyname'].value =ret[0];
	 	 	document.getElementById("supplyid").value=ret[1];
 		}
  	}
</script>
