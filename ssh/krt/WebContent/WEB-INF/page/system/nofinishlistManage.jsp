<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/ssi.tld" prefix="ssi"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>原料订货确认</title>
<link href="<%=request.getContextPath()%>/styles/gzt_css.css" rel="stylesheet" type="text/css" />
<script language="javascript" src="<%=request.getContextPath()%>/js/control.js"></script>
<script language="javascript" src="<%=request.getContextPath()%>/js/commons.js"></script>
<script language="javascript" src="<%=request.getContextPath()%>/js/formcheck.js"></script>
<script language="javascript" src="<%=request.getContextPath()%>/js/My97DatePicker/WdatePicker.js"></script>
</head>
<body>
<jsp:include page="/common/exception.jsp" flush="true" />
<html:form method="post" action="/zhaobiaojinduManage?operate=nofinishlist">
<input type="hidden" name="operate"/>
<div class="weizhi">
<div class="weizhi_bj">未完成订单信息</div>
<div class="weizhi_ss"><img id="controlSearchBtn" style="cursor:pointer" onclick="loadHiddenPage('<%=request.getContextPath()%>');" src="<%=request.getContextPath()%>/images/button_minus.gif" width="66" height="17" /></div>
</div>
<table border="0" cellspacing="0" cellpadding="0" class="table_chax" id="adSearch">
  
</table>

<table border="0" cellspacing="0" cellpadding="0" class="table_chax" style="height:20px;">
	
</table>
<table border="0" cellpadding="0" cellspacing="0" class="table_list" style="width:100%;overflow:auto">

	<tr>
    <td colspan="2">
		<table border="0" cellpadding="0" cellspacing="0" class="table_date" id="dataTable" >
		  <tr>
			<th>品名 </th>
			<th>品种属性</th>
			<th>库存总数量（kg）</th>
			<th>订单总数量（kg）</th>
		  </tr>
		  <tr>
		  <logic:present name="nofinishlist">
							<logic:notEmpty name="nofinishlist">
								<logic:iterate id="item" name="nofinishlist">
									<tr>
										<td><div><bean:write name="item" property="pinming" /></div></td>
										<td><div><bean:write name="item" property="pinzhongshuxing" /></div></td>
										<td><div><bean:write name="item" property="kucunsum" /></div></td>
										<td><div><bean:write name="item" property="dingdansum" /></div></td>
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
					<logic:present name="nofinishList">
							<logic:empty name="nofinishList">
								<div style="text-align:center; height:30px; line-height:30px;">暂无记录！</div>
							</logic:empty>
					</logic:present>
					
					<ssi:page property="pageInfo"  action="/zhaobiaojinduManage.do?operate=nofinishlist"/>
	</div>
	</td>
  </tr>
</table>
</html:form>
</body>
</html>
<script language="JavaScript">
	function toExcel(){
		
		document.zhaobiaojinduForm.action="excelReportManage.do?operate=exportylghd";
		document.zhaobiaojinduForm.submit();
	}

	function toAdd(){
		
		document.zhaobiaojinduForm.action="zhaobiaojinduManage.do?operate=toAdd";
		document.zhaobiaojinduForm.submit();
	}
    function toUpdate()
    {
    	if(isRadioChecked(zhaobiaojinduForm.selectNos))
        {
        document.zhaobiaojinduForm.action="zhaobiaojinduManage.do?operate=toUpdate";
        document.zhaobiaojinduForm.submit();
        }
        else
        {
            alert("请选择唯一的品名！");
        }
    }
    function toSearch(){
    	
	    if(checkSubmit(document.zhaobiaojinduForm)){
	    	document.zhaobiaojinduForm.operate.value="nofinishlist";
	    	document.zhaobiaojinduForm.submit();
	    	}
    }
    function toDelete()
    {
      
   	 if(isRadioChecked(zhaobiaojinduForm.selectNos))
        {
        	if(confirm("确定要删除吗？"))
        	 {
       document.zhaobiaojinduForm.action="zhaobiaojinduManage.do?operate=toDelete";
        document.zhaobiaojinduForm.submit();
        	}
        }
        else
        {
            alert("请选择唯一的品名信息！");
        }
	}
	

</script>

