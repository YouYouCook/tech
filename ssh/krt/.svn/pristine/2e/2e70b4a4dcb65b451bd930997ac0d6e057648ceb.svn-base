<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/ssi.tld" prefix="ssi"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>发票信息维护</title>
<link href="<%=request.getContextPath()%>/styles/gzt_css.css" rel="stylesheet" type="text/css" />
<script language="javascript" src="<%=request.getContextPath()%>/js/control.js"></script>
<script language="javascript" src="<%=request.getContextPath()%>/js/commons.js"></script>
<script language="javascript" src="<%=request.getContextPath()%>/js/formcheck.js"></script>
<script language="javascript" src="<%=request.getContextPath()%>/js/My97DatePicker/WdatePicker.js"></script>
</head>
<body>
<jsp:include page="/common/exception.jsp" flush="true" />
<html:form method="post" action="/fapiaoManage.do?operate=list">
<div class="weizhi">
<div class="weizhi_bj">发票信息</div>
<div class="weizhi_ss"><img id="controlSearchBtn" style="cursor:pointer" onclick="loadHiddenPage('<%=request.getContextPath()%>');" src="<%=request.getContextPath()%>/images/button_minus.gif" width="66" height="17" /></div>
</div>
 <table border="0" cellspacing="0" cellpadding="0" class="table_chax" id="adSearch">
  <tr>
    <th width="">供应商：</th>
    <td><input type="text" name="fapiaoInfoBo.gongyingshang"   value="${gongyingshang}"   size="16" title="供应商"  />
	</td>
   <th width="">发票号码：</th>
    <td><input type="text" name="fapiaoInfoBo.fapiaohao"   value="${fapiaohao}"   size="16" title="发票号码"  />
	</td>
	  <th width="">票面信息：</th>
    <td><input type="text" name="fapiaoInfoBo.piaomianxinxi"   value="${piaomianxinxi}"   size="16" title="票面信息"  />
	</td>
	
	 <th width="">发票日期：</th>
    <td><input type="text" name="fapiaoInfoBo.kaipiaoriqi"  value="${kaipiaoriqi}"   onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" class="Wdate"   size="6" title="发票日期:"/>
	</td>
	<td><input name="button" type="button" value="查询" onclick="toSearch();" /></td>
  </tr>
</table>
<table border="0" cellpadding="0" cellspacing="0" class="table_list">
	 <tr>
	    <th width="11%">发票信息列表</th>
	    <th width="89%">
		<div>
		 <input name="add" type="button" value="导出excel" onclick="toExcel();" /> 
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
			<th width="10%">接收日期</th>
			<th width="20%">供应商</th>
			<th width="10%">发票号码</th>
			<th width="10%">票额</th>
			<th width="10%">开票日期</th>
			<th width="10%">票面信息</th>
			<th width="20%">备注</th>
		  </tr>
		  <tr>
		  <logic:present name="fapiaoList">
							<logic:notEmpty name="fapiaoList">
								<logic:iterate id="item" name="fapiaoList" indexId="indexNo">
									<tr onmouseover="this.className='over'" onmouseout="this.className='out'" onclick="showInfo(<bean:write name="indexNo"/>,this);">
									    <td><input type="radio" name="selectNos" id="radioId<bean:write name="indexNo"/>"  onclick="doBoxChange(configForm.isAll,configForm.selectNos);" value="<bean:write name="item" property="id"/>"/></td>									
										<td><div><bean:write name="item" property="jieshouriqi" /></div></td>
										<td><div><bean:write name="item" property="gongyingshang" /></div></td>
										<td><div><bean:write name="item" property="fapiaohao" /></div></td>
										<td><div><bean:write name="item" property="kaipiaojiage" /></div></td>
										<td><div><bean:write name="item" property="kaipiaoriqi" /></div></td>
										<td><div><bean:write name="item" property="piaomianxinxi" /></div></td>
										<td><div><bean:write name="item" property="beizhu" /></div></td>
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
					<logic:present name="fapiaoList">
							<logic:empty name="fapiaoList">
								<div style="text-align:center; height:30px; line-height:30px;">暂无记录！</div>
							</logic:empty>
					</logic:present>
					
					<ssi:page property="pageInfo"  action="/fapiaoManage.do?operate=list"/>
	</div>
	</td>
  </tr>
</table>
</html:form>
</body>
</html>
<script language="JavaScript">

function toExcel(){
	
	document.fapiaoForm.action="fapiaoManage.do?operate=excelreport";
	document.fapiaoForm.submit();
}
	function toAdd(){
		
		document.fapiaoForm.action="fapiaoManage.do?operate=toAdd";
		document.fapiaoForm.submit();
	}
    function toUpdate()
    {
    	if(isRadioChecked(fapiaoForm.selectNos))
        {
        document.fapiaoForm.action="fapiaoManage.do?operate=toUpdate";
        document.fapiaoForm.submit();
        }
        else
        {
            alert("请选择唯一的品名！");
        }
    }
    function toSearch(){
	    if(checkSubmit(document.fapiaoForm)){
	        document.fapiaoForm.action="fapiaoManage.do?operate=list";
	    	document.fapiaoForm.submit();
	    	}
    }
    function toDelete()
    {
      
   	 if(isRadioChecked(fapiaoForm.selectNos))
        {
        	if(confirm("确定要删除吗？"))
        	 {
       document.fapiaoForm.action="fapiaoManage.do?operate=toDelete";
        document.fapiaoForm.submit();
        	}
        }
        else
        {
            alert("请选择唯一的品种信息！");
        }
	}
	

</script>

