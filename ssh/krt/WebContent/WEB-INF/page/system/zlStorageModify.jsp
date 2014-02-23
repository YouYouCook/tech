<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/ssi.tld" prefix="ssi"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>库存放行维护</title>
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
<html:form method="post" action="/storageManage.do?operate=zltoUpdate">
<input type="hidden" name="operate">
<input type="hidden" name="storageBO.id"  value="${storageBO.id}">
<div class="weizhi">
	<div class="weizhi_bj">库存放行维护</div>
</div>
<table width="100%" border="0" cellspacing="0" cellpadding="0" class="table_add">
<tr>
    <td colspan="3">注意：<span>*</span> 号为必填项！</td>
</tr>
<tr>
 <th width="12%">品名：</th>
 <td width="20%"> <input type="text" name="storageBO.name" value="${storageBO.name}"  readonly="true"  /></td>
 </tr>
 <tr>
<th>品号：</th>
  <td><html:text property="storageBO.pinhao" styleId="Y_str_storageBO.pinhao"  readonly="true"   value="${storageBO.pinhao}"   title="规格" maxlength="20"></html:text><span>*</span>
</tr>

   <tr>
   <th width="12%">品种属性：</th>
   <td width="20%"> <input type="text" name="storageBO.pinzhongshuxing" title="品种属性"  readonly="true" styleId="Y_str_storageBO.pinzhongshuxing"  value="${storageBO.pinzhongshuxing}" /><span>*</span></td>
 </tr>
<tr>
    <th width="25%">批号：</th>
   	<td width="25%">
	<input type="text" name="storageBO.pnumber" value="${storageBO.pnumber}"   readonly="true"  size="20" title="批号" />
	</td>
 </tr>

     <tr>
	
	</td>
	      <th>检验结果</th>
					<td>
							<select name="storageBO.checkresult" style= "width:100px">
    										<option value="" <logic:equal name="storageBO" property="checkresult"   value="">selected</logic:equal>>请选择</option>
											<option  value="待验" <logic:equal name="storageBO" property="checkresult"   value="待验">selected</logic:equal>>待验</option>
											<option value="合格" <logic:equal name="storageBO"  property="checkresult"  value="合格">selected</logic:equal>>合格</option>
											<option  value="不合格" <logic:equal name="storageBO"  property="checkresult"  value="不合格">selected</logic:equal>>不合格</option>
										</select></td>
  </tr>
   
  <tr>
  <th></th>
    <td  width="25%"  >
	<div style="padding-left:0px;">
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
    		    if(confirm("确定要修改此信息吗？"))
		        {
		         	document.storageForm.action="storageManage.do?operate=zlupdate";
					storageForm.submit();
		        }
        	}
        
	     
    }
    function backup()
    {
    	document.storageForm.action="storageManage.do?operate=zllist";
        document.storageForm.submit();
    }

   function reset()
    {       		
    	document.storageForm.reset();  
    }
	function openwinMedicine()
    { 
    	var returnValue=window.showModalDialog("<%=request.getContextPath()%>/medicineManage.do?operate=windowlist",window, "dialogWidth:700px,dialogHeight:335px,dialogTop:200px,dialogLeft,200px ");
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
	 	 	//document.getElementById("supplyid").value=ret[1];
 		}
  	}
</script>
