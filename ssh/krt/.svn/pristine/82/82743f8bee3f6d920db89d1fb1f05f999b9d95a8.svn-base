<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/ssi.tld" prefix="ssi"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>质保金清单</title>
<link href="<%=request.getContextPath()%>/styles/gzt_css.css" rel="stylesheet" type="text/css" />
<script language="javascript" src="<%=request.getContextPath()%>/js/control.js"></script>
<script language="javascript" src="<%=request.getContextPath()%>/js/commons.js"></script>
<script language="javascript" src="<%=request.getContextPath()%>/js/formcheck.js"></script>
</head>
<body>
<jsp:include page="/common/exception.jsp" flush="true" />
<html:form method="post" action="/zhaobiaojinduManage?operate=zhibaolist">
<input type="hidden" name="operate"/>
<div class="weizhi">
<div class="weizhi_bj">质保金清单信息</div>
<div class="weizhi_ss"><img id="controlSearchBtn" style="cursor:pointer" onclick="loadHiddenPage('<%=request.getContextPath()%>');" src="<%=request.getContextPath()%>/images/button_minus.gif" width="66" height="17" /></div>
</div>
<table border="0" cellspacing="0" cellpadding="0" class="table_chax" id="adSearch">
  <tr>

    <th width="">品种属性：</th>
    <td width=""> <input type="text" name="zhaobiaojinduBo.pinzhongshuxing"  value="${pinzhongshuxing}"   title="品种属性"  size="20"/></td>
    <th width="">供应商：</th>
    <td><input type="text" name="zhaobiaojinduBo.gonghuoshang"   value="${gonghuoshang}"   size="30" title="供应商"  />
	</td>
   <th width="">品名：</th>
    <td><input type="text" name="zhaobiaojinduBo.pinming"  value="${pinming}"    size="15" title="品名:"/>
	</td>
	<td><input name="button" type="button" value="查询" onclick="toSearch();" /></td>
  </tr>
</table>

<table border="0" cellspacing="0" cellpadding="0" class="table_chax" style="height:20px;">
	 <tr>
	    <th width="11%">质保金信息列表</th>
	    <th width="89%">
		<div>
	      <input name="update" type="button" value="修改" onclick="toUpdate();"/>
		</div>
		</th>
  	</tr>
</table>
<table border="0" cellpadding="0" cellspacing="0" class="table_list" style="width:100%;overflow:auto">

	<tr>
    <td colspan="2">
		<table border="0" cellpadding="0" cellspacing="0" class="table_date" id="dataTable" >
		  <tr>
		    <th>请选择</th>
			<th>品名 </th>
			<th>供货商</th>
			<th>品种属性</th>
			<th>数量</th>
			<th>单价（元）</th>
			<th>质保金（元）</th>
			<th>装卸费（元）</th>
			<th>质保金状态(采购部)</th>
			<th>质保金缴纳日期(采购部)</th>
			<th>质保金状态(财务部)</th>
			<th>质保金缴纳日期((财务部)</th>
			<th>应退质保金</th>
			<th>备注</th>
		  </tr>
		  <tr>
		  <logic:present name="zhaobiaoList">
							<logic:notEmpty name="zhaobiaoList">
								<logic:iterate id="item" name="zhaobiaoList" indexId="indexNo">
									<tr onmouseover="this.className='over'" onmouseout="this.className='out'" onclick="showInfo(<bean:write name="indexNo"/>,this);">
									    <td><input type="radio" name="selectNos" id="radioId<bean:write name="indexNo"/>"  onclick="doBoxChange(configForm.isAll,configForm.selectNos);" value="<bean:write name="item" property="id"/>"/></td>									
										<td><div><bean:write name="item" property="pinming" /></div></td>
										<td><div><bean:write name="item" property="gonghuoshang" /></div></td>
										<td><div><bean:write name="item" property="pinzhongshuxing" /></div></td>
										<td><div><bean:write name="item" property="shuliang" /></div></td>
										<td><div><bean:write name="item" property="danjia" /></div></td>
										<td><div><bean:write name="item" property="zhibaojin" /></div></td>
										<td><div><bean:write name="item" property="zhuangxiefei" /></div></td>
									    <td>
										<logic:equal name="item" property="zhibaojinzt" value="">未设置</logic:equal>
											<logic:equal name="item" property="zhibaojinzt" value="0">未缴纳</logic:equal>
											<logic:equal name="item" property="zhibaojinzt" value="1">已缴纳</logic:equal>
											 <logic:equal name="item" property="zhibaojinzt" value="2">已退还</logic:equal>
										</td>
										<td><div><bean:write name="item" property="zhibaojinjnrq" /></div></td>
										  <td>
										<logic:equal name="item" property="zhibaojinztzl" value="">未设置</logic:equal>
											<logic:equal name="item" property="zhibaojinztzl" value="0">未缴纳</logic:equal>
											<logic:equal name="item" property="zhibaojinztzl" value="1">已缴纳</logic:equal>
											 <logic:equal name="item" property="zhibaojinztzl" value="2">已退还</logic:equal>
										</td>
										<td><div><bean:write name="item" property="zhibaojinjnrqzl" /></div></td>
										<td><div><bean:write name="item" property="yingtuizhibaojin" /></div></td>
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

    function toUpdate()
    {
    	if(isRadioChecked(zhaobiaojinduForm.selectNos))
        {
        document.zhaobiaojinduForm.action="zhaobiaojinduManage.do?operate=toUpdateZBJ";
        document.zhaobiaojinduForm.submit();
        }
        else
        {
            alert("请选择唯一的品名！");
        }
    }
    function toSearch(){
    	
	    if(checkSubmit(document.zhaobiaojinduForm)){
	    	document.zhaobiaojinduForm.operate.value="zhibaolist";
	    	document.zhaobiaojinduForm.submit();
	    	}
    }

	

</script>

