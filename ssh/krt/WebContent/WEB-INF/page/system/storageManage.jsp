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
<div class="weizhi_bj">库存维护</div>
<div class="weizhi_ss"><img id="controlSearchBtn" style="cursor:pointer" onclick="loadHiddenPage('<%=request.getContextPath()%>');" src="<%=request.getContextPath()%>/images/button_minus.gif" width="66" height="17" /></div>
</div>
<table border="0" cellspacing="0" cellpadding="0" class="table_chax" id="adSearch"  >
  <tr>
    <th width="10%">检验状态：</th>
    <td width="20%">
    
   <select name="storageBO.checkresult" style= "width:100px">
    										<option value="" <logic:equal name="storageForm" property="storageBO.checkresult"   value="">selected</logic:equal>>请选择</option>
											<option  value="待验" <logic:equal name="storageForm" property="storageBO.checkresult"   value="待验">selected</logic:equal>>待验</option>
											<option value="合格" <logic:equal name="storageForm"  property="storageBO.checkresult"  value="合格">selected</logic:equal>>合格</option>
											<option  value="不合格" <logic:equal name="storageForm"  property="storageBO.checkresult"  value="不合格">selected</logic:equal>>不合格</option>
										</select></td>
    </td>
    
    
    
    </td>
    <td width="5%"><input name="checks"  type="button" value="查询" onclick="toSerch()"/></td>
     <th width="60%"></th>
  </tr>
</table>
<table border="0" cellspacing="0" cellpadding="0" class="table_chax" style="height:20px;">
 <tr>
	    <th width="85%"></th>
	    <th width="5%">
	     <input name="add" type="button" value="新增" onclick="toAdd();" />  
	    </th>
	    <th width="5%">
		<div>
	      <input name="update" type="button" value="修改" onclick="toUpdate();"/>
		</div>
		</th>
		  <th width="5%">
		<div>
	      <input name="update" type="button" value="删除" onclick="toDelete();"/>
		</div>
		</th>
</table>
<table border="0" cellpadding="0" cellspacing="0" class="table_list" style="width:200%;margin-top:0px;">
	 <tr>
	    <th width="11%">库存信息列表</th>
	    <th width="10%">
		</th>
  	</tr>
	<tr>
    <td colspan="2">
		<table border="0" cellpadding="0" cellspacing="0" class="table_date" id="dataTable">
		  <tr>
			<th >请选择</th>
			<th>品名</th>
			<th>品号</th>
			<th>品种属性</th>
			<th>次数</th>
			<th >批号</th>
			<th >请验单号</th>
			<th >供货单位</th>
			<th >办事处</th>
			<th >存放地</th>
			<th >产地</th>
			<th >规格</th>
			<th >件数</th>
			<th >数量（kg)</th>
			<th >到货日期</th>
			<th >送样日期</th>
			<th >放行日期</th>
			<th >检验结果</th>
			<th >合格后发货日期</th>
			<!-- 
			<th >退货日期</th>
			<th >退货数量</th> -->
			<th >接收地点</th>
			<th >原料到达日期</th>
			<th >到达后称量数量</th>
			<th >备注</th>
			<th >发货地址</th>
			<th>退货数量</th>
			<th>退货日期</th>
		  </tr>
		  <tr>
		  <logic:present name="storageList">
							<logic:notEmpty name="storageList">
								<logic:iterate id="item" name="storageList" indexId="indexNo">
									<tr onmouseover="this.className='over'" onmouseout="this.className='out'" onclick="showInfo(<bean:write name="indexNo"/>,this);">
										<td><input type="radio" name="selectNos" id="radioId<bean:write name="indexNo"/>"  onclick="doBoxChange(configForm.isAll,configForm.selectNos);" value="<bean:write name="item" property="id"/>"/></td>									
										<td><div><bean:write name="item" property="name" /></div></td>
										<td><div><bean:write name="item" property="pinhao" /></div></td>
										<td><div><bean:write name="item" property="pinzhongshuxing" /></div></td>
										<td><div><bean:write name="item" property="times" /></div></td>
										<td><div><bean:write name="item" property="pnumber" /></div></td>
										<td><div><bean:write name="item" property="checknumber" /></div></td>
										<td><div><bean:write name="item" property="supplyname" /></div></td>
										<td>  
										<logic:notEmpty name="item" property="customerBO">  
													<div><bean:write name="item" property="customerBO.banshichu" /></div>
  					 						  </logic:notEmpty> 
									   </td>
										<td><div><bean:write name="item" property="locationcity" /></div></td>
										<td><div><bean:write name="item" property="detailchandi" /></div></td>
										<td><div><bean:write name="item" property="guige" /></div></td>
										<td><div><bean:write name="item" property="jianshu" /></div></td>
										<td><div><bean:write name="item" property="shuliang" /></div></td>
										<td><div><bean:write name="item" property="fromdate" /></div></td>
										<td><div><bean:write name="item" property="demodate" /></div></td>
										<td><div><bean:write name="item" property="fangxingdate" /></div></td>
										<td><div><bean:write name="item" property="checkresult" /></div></td>
										<td><div><bean:write name="item" property="senddate" /></div></td>
										
										<td><div><bean:write name="item" property="receivelocation" /></div></td>
										<td><div><bean:write name="item" property="yuanliaodaodate" /></div></td>
										<td><div><bean:write name="item" property="daodaozhongliang" /></div></td>
										<td><div><bean:write name="item" property="beizhu" /></div></td>
										<td><div><bean:write name="item" property="sendaddress" /></div></td>
										<td><div><bean:write name="item" property="tuihuoriqi" /></div></td>
										<td><div><bean:write name="item" property="tuihuoshuliang" /></div></td>
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

