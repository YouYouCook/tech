<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/ssi.tld" prefix="ssi"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>品种信息-列表</title>
<link href="<%=request.getContextPath()%>/styles/gzt_css.css" rel="stylesheet" type="text/css" />
<script language="javascript" src="<%=request.getContextPath()%>/js/control.js"></script>
<script language="javascript" src="<%=request.getContextPath()%>/js/commons.js"></script>
<script language="javascript" src="<%=request.getContextPath()%>/js/formcheck.js"></script>
</head>
<body>
<jsp:include page="/common/exception.jsp" flush="true" />
<html:form method="post" action="/medicineManage.do?operate=list">
<input type="hidden" name="operate"/>
<div class="weizhi">
<div class="weizhi_bj">品种维护</div>
<div class="weizhi_ss"><img id="controlSearchBtn" style="cursor:pointer" onclick="loadHiddenPage('<%=request.getContextPath()%>');" src="<%=request.getContextPath()%>/images/button_minus.gif" width="66" height="17" /></div>
</div>
<table border="0" cellspacing="0" cellpadding="0" class="table_chax" id="adSearch">
  <tr>
    <th width="3%">品名：</th>
    <td width="20%"><html:text property="medicineName" size="15" title="品名"></html:text></td>
    <td width="5%"><input name="checks"  type="button" value="查询" onclick="toSerch()"/></td>
  </tr>
</table>
<table border="0" cellpadding="0" cellspacing="0" class="table_list">
	 <tr>
	    <th width="11%">品种信息列表</th>
	    <th width="89%">
		<div>
		  <input name="add" type="button" value="新增" onclick="toAdd();" />  
	      <input name="update" type="button" value="修改" onclick="toUpdate();"/>
	      <input name="delete" type="button" value="删除" onclick="toDelete();"/> 
		</div>
		</th>
  	</tr>
	<tr>
    <td colspan="2">
		<table border="0" cellpadding="0" cellspacing="0" class="table_date" id="dataTable">
		  <tr>
			<th width="10%">请选择</th>
			<th width="15%">品名</th>
			<th width="10%">基本质量要求</th>
			<th width="10%">类别</th>
			<th width="10%">物料编码</th>
			<th width="10%">图片</th>
			<th width="10%">备注</th>
		  </tr>
		  <tr>
		  <logic:present name="medicineList">
							<logic:notEmpty name="medicineList">
								<logic:iterate id="item" name="medicineList" indexId="indexNo">
									<tr onmouseover="this.className='over'" onmouseout="this.className='out'" onclick="showInfo(<bean:write name="indexNo"/>,this);">
										<td><input type="radio" name="selectNos" id="radioId<bean:write name="indexNo"/>"  onclick="doBoxChange(configForm.isAll,configForm.selectNos);" value="<bean:write name="item" property="medicineId"/>"/></td>									
										<td><div><bean:write name="item" property="medicineName" /></div></td>
										<td><div STYLE="width: 120px; height: 20px; border: 0px solid blue;overflow: hidden; text-overflow:ellipsis" onmouseover="this.style.cssText='overflow:visible'" onmouseout="this.style.cssText='width:120px;height: 20px;border: 0px solid blue;overflow:hidden;text-overflow:ellipsis'"><bean:write name="item" property="zlyq" /></div></td>
										<td><div><bean:write name="item" property="leibie" /></div></td>
										<td><div><bean:write name="item" property="wlbm" /></div></td>
											<td>
											<logic:notEmpty name="item" property="medicineVistorimagePath">  
												<a target="blank" href=<bean:write name="item" property="medicineVistorimagePath" />><img src=<bean:write name="item" property="medicineVistorimagePath" /> style="max-width:300px;height:50px;"/></a>
  					 						  </logic:notEmpty> 
											</td>
										<td><div><bean:write name="item" property="remark" /></div></td>
									</tr>
								</logic:iterate>
							</logic:notEmpty>
						</logic:present>
		</tr>	
								
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
					
					<ssi:page property="pageInfo"  action="/medicineManage.do?operate=list"/>
	</div>
	</td>
  </tr>
</table>
</html:form>
</body>
</html>
<script language="JavaScript">
	function toAdd(){
		document.medicineForm.action="medicineManage.do?operate=toAdd";
		medicineForm.submit();
	}
    function toUpdate()
    {
    	if(isRadioChecked(medicineForm.selectNos))
        {
        document.medicineForm.action="medicineManage.do?operate=toUpdate";
        document.medicineForm.submit();
        }
        else
        {
            alert("请选择唯一的品名！");
        }
    }
    function toSerch(){
    	console.log("toSearch")
	    if(checkSubmit(document.medicineForm)){
	    	console.log("toSearch function")
	    	document.medicineForm.operate.value="list";
	    	document.medicineForm.submit();
	    	}
    }
    function toDelete()
    {
      
   	 if(isRadioChecked(medicineForm.selectNos))
        {
        	if(confirm("确定要删除吗？"))
        	 {
       document.medicineForm.action="medicineManage.do?operate=toDelete";
        document.medicineForm.submit();
        	}
        }
        else
        {
            alert("请选择唯一的品种信息！");
        }
	}
	

</script>

