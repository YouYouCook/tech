<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/ssi.tld" prefix="ssi"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>品种维护-增加</title>
<link href="<%=request.getContextPath()%>/styles/gzt_css.css" rel="stylesheet" type="text/css" />
<script language="javascript" src="<%=request.getContextPath()%>/js/commons.js"></script>
<script language="javascript" src="<%=request.getContextPath()%>/js/control.js"></script>
<script language="javascript" src="<%=request.getContextPath()%>/js/formcheck.js"></script>
<script language="javascript" src="<%=request.getContextPath()%>/js/ajax.js"></script>
<script language="javascript" src="<%=request.getContextPath()%>/js/livevalidation_standalone.js"></script>
</head>
<html:form method="post" action="/medicineManage.do?operate=toAdd"  enctype="multipart/form-data">
<html:hidden property="medicineBO.medicineId"/>
<input type="hidden" name="operate">
<div class="weizhi">
	<div class="weizhi_bj">添加品种</div>
</div>
<table width="100%" border="0" cellspacing="0" cellpadding="0" class="table_add">
	<tr>
    <td colspan="2">注意：<span>*</span> 号为必填项！</td>
  	</tr>
  <tr>
    <th width="19%">品种名称：</th>
    <td width="81%"> <html:text property="medicineBO.medicineName"  styleId="Y_str_medicineBO.medicineName" title="品种名称" maxlength="20" /><span>*</span><font>品种名称为1-25中文</font>
	</td>     
  </tr>
  <tr>
    <th>基本质量要求：</th>
    <td><textarea name="medicineBO.zlyq"  styleId="N_str_medicineBO.zlyq" title="基本质量要求" maxlength="1000"><bean:write name="medicineForm" property="medicineBO.zlyq" /></textarea><span>*</span><font>基本质量为1-250个汉字</font>
	</td>
  </tr>
    <tr>
    <th>类别：</th>
    <td><textarea name="medicineBO.leibie"  styleId="N_str_medicineBO.leibie" title="类别" maxlength="1000"><bean:write name="medicineForm" property="medicineBO.leibie" /></textarea><span></span><font></font>
	</td>
  </tr>
    <tr>
    <th>物料编码：</th>
    <td><textarea name="medicineBO.wlbm"  styleId="N_str_medicineBO.wlbm" title="物料彬妈" maxlength="1000"><bean:write name="medicineForm" property="medicineBO.wlbm" /></textarea><span></span><font></font>
	</td>
  </tr>
     <tr>
    <th>图片：</th>
     <td  width="10%"><input type="file" onchange="show()"  onpropertychange="show()" id="medicindeFile" styleId="Y_fil_medicineBO.medicineImage"  name="medicineBO.medicineImage" size="50"  maxlength="80"/> 
	</td>
  	</tr>
  	   <tr>
  	    <th>
  	    <input type="hidden" name="filechanged" id="filechanged" />
  	     <input type="hidden" name="medicineBO.medicineimagefilename" value="${medicineForm.medicineBO.medicineimagefilename}" />
  	    </th>
  		<td>
		<logic:notEmpty name="medicineForm" property="medicineBO.medicineVistorimagePath">  
												 <img src=<bean:write name="medicineForm" property="medicineBO.medicineVistorimagePath" /> style="max-width:300px;height:50px;"/>
  		 </logic:notEmpty> 
	</td>
  	</tr>
  <tr>
    <th>备注：</th>
    <td><textarea name="medicineBO.remark"  title="备注" maxlength="200"><bean:write name="medicineForm" property="medicineBO.remark" /></textarea></td>
  </tr>
  <tr>
    <td colspan="2">
	<div>
	<input type="button" name="Submit" value="确 认" onclick="update()"/>
    <input type="button" name="Submit2" value="重 置" onclick="reset();"/>
    <input type="button" name="Submit3" value="返 回" onclick="backup();"/>
	</div>
	</td>
  </tr>
</table>
</html:form>
</html>
<script language="JavaScript">

function   show(){   
	
	  document.getElementById("filechanged").value="ccc";
	  }   
    function update()
    {	
    	
        if(checkSubmit(document.medicineForm)){
    		if(confirm("确定要修改此信息吗？"))
	        {
	         	document.medicineForm.action="medicineManage.do?operate=update";
	        	document.medicineForm.submit();
	        }
         }
    	
    }

    function reset()
    {  
    	document.medicineForm.reset();  
    }
    

    function backup()
    {
    	document.medicineForm.action="medicineManage.do?operate=list";
        document.medicineForm.submit();
    }
</script>



