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
<html:form method="post" action="/zhaobiaojinduManage?operate=list">
<input type="hidden" name="operate"/>
<div class="weizhi">
<div class="weizhi_bj">原料订货信息</div>
<div class="weizhi_ss"><img id="controlSearchBtn" style="cursor:pointer" onclick="loadHiddenPage('<%=request.getContextPath()%>');" src="<%=request.getContextPath()%>/images/button_minus.gif" width="66" height="17" /></div>
</div>
<table border="0" cellspacing="0" cellpadding="0" class="table_chax" id="adSearch">
  <tr>
    <th width="">供应商：</th>
    <td><input type="text" name="zhaobiaojinduBo.gonghuoshang"   value="${gonghuoshang}"   size="16" title="供应商"  />
	</td>
   <th width="">开标日期：</th>
    <td><input type="text" name="zhaobiaojinduBo.kaibiaoriqi"  value="${kaibiaoriqi}"   onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" class="Wdate"   size="6" title="开标日期:"/>
	</td>
	  <th width="">最迟交大货日期：</th>
    <td><input type="text" name="zhaobiaojinduBo.zcjdhrq"  value="${zcjdhrq}"   onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" class="Wdate"   size="6" title="最迟较大或日期:"/>
	</td>
	<td><input name="button" type="button" value="查询" onclick="toSearch();" /></td>
  </tr>
</table>

<table border="0" cellspacing="0" cellpadding="0" class="table_chax" style="height:20px;">
	 <tr>
	    <th width="11%">原料订货信息列表</th>
	    <th width="89%">
		<div>
		 <input name="add" type="button" value="导出excel" onclick="toExcel();" /> 
		  <input name="add" type="button" value="新增" onclick="toAdd();" />  
	      <input name="update" type="button" value="修改" onclick="toUpdate();"/>
	      <input name="delete" type="button" value="删除" onclick="toDelete();"/>
		</div>
		</th>
  	</tr>
</table>
<table border="0" cellpadding="0" cellspacing="0" class="table_list" style="width:170%;overflow:auto">

	<tr>
    <td colspan="2">
		<table border="0" cellpadding="0" cellspacing="0" class="table_date" id="dataTable" >
		  <tr>
		    <th>请选择</th>
			<th>品名 </th>
			<th>数量（kg）</th>
			<th>产地</th>
			<th>单价（元/kg）</th>
			<th>金额(元)</th>	
			<th>质保金（元）</th>
			<th>装卸费（元）</th>
			<th>确认交货日期</th>
			<th>品种属性</th>
			<th>备注</th>
			<th>供方单位</th>
			<th>联系人</th>
			<th>电话</th>
			<th>需方单位</th>
			<th>开标日期</th>
			<th>最迟交大货日期</th>
			<th>质保金缴纳日期</th>
		  </tr>
		  <tr>
		  <logic:present name="zhaobiaoList">
							<logic:notEmpty name="zhaobiaoList">
								<logic:iterate id="item" name="zhaobiaoList" indexId="indexNo">
									<tr onmouseover="this.className='over'" onmouseout="this.className='out'" onclick="showInfo(<bean:write name="indexNo"/>,this);">
									    <td><input type="radio" name="selectNos" id="radioId<bean:write name="indexNo"/>"  onclick="doBoxChange(configForm.isAll,configForm.selectNos);" value="<bean:write name="item" property="id"/>"/></td>									
										<td><div><bean:write name="item" property="pinming" /></div></td>
										<td><div><bean:write name="item" property="shuliang" /></div></td>
										<td><div><bean:write name="item" property="chandi" /></div></td>
										<td><div><bean:write name="item" property="danjia" /></div></td>
										<td><div><bean:write name="item" property="jine" /></div></td>
										<td><div><bean:write name="item" property="zhibaojin" /></div></td>
										<td><div><bean:write name="item" property="zhuangxiefei" /></div></td>
										<td><div><bean:write name="item" property="qrjhrq" /></div></td>
										<td><div><bean:write name="item" property="pinzhongshuxing" /></div></td>
										<td><div><bean:write name="item" property="beizhu" /></div></td>
										<td><div><bean:write name="item" property="gonghuoshang" /></div></td>
										<td><div><bean:write name="item" property="lianxiren" /></div></td>
										<td><div><bean:write name="item" property="dianhua" /></div></td>
										<td><div><bean:write name="item" property="xufangdanwei" /></div></td>
										<td><div><bean:write name="item" property="kaibiaoriqi" /></div></td>
										<td><div><bean:write name="item" property="zcjdhrq" /></div></td>
										<td><div><bean:write name="item" property="zhibaojinjnrq" /></div></td>
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
					<logic:present name="zhaobiaoList">
							<logic:empty name="zhaobiaoList">
								<div style="text-align:center; height:30px; line-height:30px;">暂无记录！</div>
							</logic:empty>
					</logic:present>
					
					<ssi:page property="pageInfo"  action="/zhaobiaojinduManage.do?operate=list"/>
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
	    	document.zhaobiaojinduForm.operate.value="list";
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

