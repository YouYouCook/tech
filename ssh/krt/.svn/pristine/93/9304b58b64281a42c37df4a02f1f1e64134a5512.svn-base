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
<html:form method="post" action="/storageManage.do?operate=list">
<input type="hidden" name="operate"/>
<div class="weizhi">
<div class="weizhi_bj">${title}</div>
<div class="weizhi_ss"><img id="controlSearchBtn" style="cursor:pointer" onclick="loadHiddenPage('<%=request.getContextPath()%>');" src="<%=request.getContextPath()%>/images/button_minus.gif" width="66" height="17" /></div>
</div>
<table border="0" cellspacing="0" cellpadding="0" class="table_chax" id="adSearch"  >
  <tr>
    <th width="10%">${ptitle}：</th>
    <td width="20%"><html:text property="sumshuliang"   readonly="true"  value="${sumshuliang}"  size="15" title="待验数量和"></html:text></td>
     <th width="60%"></th>
  </tr>
</table>
<table border="0" cellpadding="0" cellspacing="0" class="table_list" style="width:100%;margin-top:0px;">
	 <tr>
	    <th width="11%">库存信息列表</th>
	    <th width="10%">
		</th>
  	</tr>
	<tr>
    <td colspan="2">
		<table border="0" cellpadding="0" cellspacing="0" class="table_date" id="dataTable">
		  <tr>
			<th>批号</th>
		  </tr>
		  <tr>
		  <logic:present name="storageList">
							<logic:notEmpty name="storageList">
								<logic:iterate id="item" name="storageList" indexId="indexNo">
									<tr onmouseover="this.className='over'" onmouseout="this.className='out'" onclick="showInfo(<bean:write name="indexNo"/>,this);">
										<td><div><bean:write name="item" property="pnumber" /></div></td>
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
					<logic:present name="storageList">
							<logic:empty name="storageList">
								<div style="text-align:center; height:30px; line-height:30px;">暂无记录！</div>
							</logic:empty>
					</logic:present>
					
					<ssi:page property="pageInfo"  action="/storageManage.do?operate=list"/>
	</div>
	</td>
  </tr>
</table>
</html:form>
</body>
</html>
<script language="JavaScript">
	function toAdd(){
		document.storageForm.action="storageManage.do?operate=toAdd";
		storageForm.submit();
	}
    function toUpdate()
    {
    	if(isRadioChecked(storageForm.selectNos))
        {
        document.storageForm.action="storageManage.do?operate=toUpdate";
        document.storageForm.submit();
        }
        else
        {
            alert("请选择唯一的品名！");
        }
    }
    function toSerch(){
	    if(checkSubmit(document.storageForm)){
	    	document.storageForm.operate.value="list";
	    	document.storageForm.submit();
	    	}
    }
    function toDelete()
    {
      
   	 if(isRadioChecked(storageForm.selectNos))
        {
        	if(confirm("确定要删除吗？"))
        	 {
       document.storageForm.action="storageManage.do?operate=toDelete";
        document.storageForm.submit();
        	}
        }
        else
        {
            alert("请选择唯一的品种信息！");
        }
	}
	

</script>

