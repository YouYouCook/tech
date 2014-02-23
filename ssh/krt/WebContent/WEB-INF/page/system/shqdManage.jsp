<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/ssi.tld" prefix="ssi"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>库存-列表</title>
<link href="<%=request.getContextPath()%>/styles/gzt_css.css" rel="stylesheet" type="text/css" />
<script language="javascript" src="<%=request.getContextPath()%>/js/control.js"></script>
<script language="javascript" src="<%=request.getContextPath()%>/js/commons.js"></script>
<script language="javascript" src="<%=request.getContextPath()%>/js/formcheck.js"></script>
</head>
<body>
<jsp:include page="/common/exception.jsp" flush="true" />
<html:form method="post" action="/shqdManage.do?operate=list">
<div class="weizhi">
<div class="weizhi_bj">送货清单维护</div>
<div class="weizhi_ss"><img id="controlSearchBtn" style="cursor:pointer" onclick="loadHiddenPage('<%=request.getContextPath()%>');" src="<%=request.getContextPath()%>/images/button_minus.gif" width="66" height="17" /></div>
</div>
<table border="0" cellspacing="0" cellpadding="0" class="table_chax" id="adSearch">
  <tr>
  </tr>
</table>
<table border="0" cellpadding="0" cellspacing="0" class="table_list">
	 <tr>
	    <th width="11%">送货清单信息列表</th>
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
			<th width="10%">供货单位</th>
			<th width="15%">发货日期</th>
			<th width="20%">运输方式</th>
			<th width="10%">送货人</th>
			<th width="10%">收货单位</th>
			<th width="10%">品名</th>
			<th width="10%">规格</th>
			<th width="10%">件数</th>
		  </tr>
		  <tr>
		  <logic:present name="shqdlist">
							<logic:notEmpty name="shqdlist">
								<logic:iterate id="item" name="shqdlist" indexId="indexNo">
									<tr onmouseover="this.className='over'" onmouseout="this.className='out'" onclick="showInfo(<bean:write name="indexNo"/>,this);">
										<td><input type="radio" name="selectNos" id="radioId<bean:write name="indexNo"/>"  onclick="doBoxChange(configForm.isAll,configForm.selectNos);" value="<bean:write name="item" property="id"/>"/></td>									
								        <td><div><bean:write name="item" property="customerBO.name" /></div></td>
								        <td><div><bean:write name="item" property="fhrq" /></div></td>
										<td><div><bean:write name="item" property="ysfs" /></div></td>
										<td><div><bean:write name="item" property="shr" /></div></td>
										<td><div><bean:write name="item" property="shdw" /></div></td>
										<td><div><bean:write name="item" property="medicineBO.medicineName" /></div></td>
										<td><div><bean:write name="item" property="guige" /></div></td>
										<td><div><bean:write name="item" property="jianshu" /></div></td>
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
					<logic:present name="shqdlist">
							<logic:empty name="shqdlist">
								<div style="text-align:center; height:30px; line-height:30px;">暂无记录！</div>
							</logic:empty>
					</logic:present>
					
					<ssi:page property="pageInfo"  action="/shqdManage.do?operate=list"/>
	</div>
	</td>
  </tr>
</table>
</html:form>
</body>
</html>
<script language="JavaScript">
	function toAdd(){
		
		document.shqdForm.action="shqdManage.do?operate=toAdd";
		document.shqdForm.submit();
	}
    function toUpdate(){
    	if(isRadioChecked(shqdForm.selectNos))
        {
        document.shqdForm.action="shqdManage.do?operate=toUpdate";
        document.shqdForm.submit();
        }
        else
        {
            alert("请选择唯一的品名！");
        }
    }
    function toSerch(){
	    if(checkSubmit(document.shqdForm)){
	    	document.shqdForm.operate.value="list";
	    	document.shqdForm.submit();
	    	}
    }
    function toDelete()
    {
      
   	 if(isRadioChecked(shqdForm.selectNos))
        {
        	if(confirm("确定要删除吗？"))
        	 {
       document.shqdForm.action="shqdManage.do?operate=toDelete";
        document.shqdForm.submit();
        	}
        }
        else
        {
            alert("请选择唯一的品种信息！");
        }
	}
	

</script>

