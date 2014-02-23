<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/ssi.tld" prefix="ssi"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>付款明细维护</title>
<link href="<%=request.getContextPath()%>/styles/gzt_css.css" rel="stylesheet" type="text/css" />
<script language="javascript" src="<%=request.getContextPath()%>/js/control.js"></script>
<script language="javascript" src="<%=request.getContextPath()%>/js/commons.js"></script>
<script language="javascript" src="<%=request.getContextPath()%>/js/formcheck.js"></script>
</head>
<body>
<jsp:include page="/common/exception.jsp" flush="true" />
<html:form method="post" action="/fukuanManage.do?operate=list">
<div class="weizhi">
<div class="weizhi_bj">付款明细</div>
<div class="weizhi_ss"><img id="controlSearchBtn" style="cursor:pointer" onclick="loadHiddenPage('<%=request.getContextPath()%>');" src="<%=request.getContextPath()%>/images/button_minus.gif" width="66" height="17" /></div>
</div>
<table border="0" cellspacing="0" cellpadding="0" class="table_chax" id="adSearch">
  <tr>
  </tr>
</table>
<table border="0" cellpadding="0" cellspacing="0" class="table_list">
	 <tr>
	    <th width="11%">付款明细列表</th>
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
		    <th >请选择</th>
			<th >品名</th>
			<th >预计支付时间</th>
			<th >实际付款时间</th>
			<th >供应商</th>
			<th >开票日期</th>
			<th >挂账金额</th>
			<th >放行日期</th>
			<th >账期</th>
			<th >预计支付金额</th>
			<th >备注 </th>
			<th >数量</th>
			<th >发票号码</th>
			<th >批号</th>
		  </tr>
		  <tr>
		  <logic:present name="fukuanList">
							<logic:notEmpty name="fukuanList">
								<logic:iterate id="item" name="fukuanList" indexId="indexNo">
									<tr onmouseover="this.className='over'" onmouseout="this.className='out'" onclick="showInfo(<bean:write name="indexNo"/>,this);">
									    <td><input type="radio" name="selectNos" id="radioId<bean:write name="indexNo"/>"  onclick="doBoxChange(configForm.isAll,configForm.selectNos);" value="<bean:write name="item" property="id"/>"/></td>									
										<td><div><bean:write name="item" property="pinming" /></div></td>
										<td><div><bean:write name="item" property="yjzfsj" /></div></td>
										<td><div><bean:write name="item" property="sjfksj" /></div></td>
										<td><div><bean:write name="item" property="gongyingshang" /></div></td>
										<td><div><bean:write name="item" property="kaipiaoriqi" /></div></td>
										<td><div><bean:write name="item" property="guazhangjie" /></div></td>
										<td><div><bean:write name="item" property="gzsj" /></div></td>
										<td><div><bean:write name="item" property="zhangqi" /></div></td>
										<td><div><bean:write name="item" property="yjzfje" /></div></td>
										<td><div><bean:write name="item" property="beizhu" /></div></td>
										<td><div><bean:write name="item" property="shuliang" /></div></td>
										<td><div><bean:write name="item" property="fapiaohaoma" /></div></td>
										<td><div><bean:write name="item" property="pihao" /></div></td>
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
					<logic:present name="fukuanList">
							<logic:empty name="fukuanList">
								<div style="text-align:center; height:30px; line-height:30px;">暂无记录！</div>
							</logic:empty>
					</logic:present>
					
					<ssi:page property="pageInfo"  action="/fukuanManage.do?operate=list"/>
	</div>
	</td>
  </tr>
</table>
</html:form>
</body>
</html>
<script language="JavaScript">
	function toAdd(){
		
		document.fukuanForm.action="fukuanManage.do?operate=toAdd";
		document.fukuanForm.submit();
	}
    function toUpdate()
    {
    	if(isRadioChecked(fukuanForm.selectNos))
        {
        document.fukuanForm.action="fukuanManage.do?operate=toUpdate";
        document.fukuanForm.submit();
        }
        else
        {
            alert("请选择唯一的品名！");
        }
    }
    function toSerch(){
	    if(checkSubmit(document.fukuanForm)){
	    	document.fukuanForm.operate.value="list";
	    	document.fukuanForm.submit();
	    	}
    }
    function toDelete()
    {
      
   	 if(isRadioChecked(fukuanForm.selectNos))
        {
        	if(confirm("确定要删除吗？"))
        	 {
       document.fukuanForm.action="fukuanManage.do?operate=toDelete";
        document.fukuanForm.submit();
        	}
        }
        else
        {
            alert("请选择唯一的品种信息！");
        }
	}
	

</script>

