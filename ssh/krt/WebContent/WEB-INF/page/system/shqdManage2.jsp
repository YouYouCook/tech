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
<script language="javascript" src="<%=request.getContextPath()%>/js/My97DatePicker/WdatePicker.js"></script>
</head>
<body>
<jsp:include page="/common/exception.jsp" flush="true" />

<div class="weizhi">
<div class="weizhi_bj">送货清单维护</div>
<div class="weizhi_ss"><img id="controlSearchBtn" style="cursor:pointer" onclick="loadHiddenPage('<%=request.getContextPath()%>');" src="<%=request.getContextPath()%>/images/button_minus.gif" width="66" height="17" /></div>
</div>
<html:form method="post" action="/shqdHeadManage.do">
<table border="0" cellspacing="0" cellpadding="0" class="table_chax" id="adSearch">
  <tr>
    <th width="12%">供货单位：</th>
    <td width="20%"><input type="text" id="supplyname" readonly="true"   name="supplyname" title="供应商"/><input name="button" type="button" value="查询" onclick="openwinSupplier();" /></td>
    <input type="hidden" name="supplyid" id="supplyid" />
    <th>发货日期：</th>
    <td><input type="text" id="sfhrq" name="fhrq"    size="15" title="投标起始日" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" class="Wdate" />
	</td>
    <th width="12%">运输方式：</th>
    <td width="20%"><input type="text" id="shqdheadBO.ysfs"  name="ysfs"  title="运输方式"/></td>
    <th width="13%">联系电话：</th>
    <td width="20%"><input type="text" id="shqdheadBO.lxdh"  name="lxdh"   title="联系电话"/></td>
  </tr>
   <tr>
     <th width="12%">送货人：</th>
    <td width="20%"><input type="text" id="shqdheadBO.shr"  name="shr"   title="送货人"/></td>
    <th width="12%">收货单位：</th>
    <td width="20%"><input type="text" id="shqdheadBO.shdw"  name="shdw"   title="收货单位"/></td>
    <th width="12%">车牌号：</th>
    <td width="20%"><input type="text" id="shqdheadBO.chepaihao"  name="chepaihao"   title="车牌号"/></td>
    <th><input name="checks"  type="button" value="添加" onclick="addshqdHead()"/></th>
  </tr>
</table>
<table border="0" cellpadding="0" cellspacing="0" class="table_list">
	 <tr>
	    <th width="11%">送货清单信息列表</th>
	    <th width="89%">
		<div>
		   <input name="add" type="button" value="输出excel" onclick="excelReport();" />  
		   <input name="add" type="button" value="查询送货信息" onclick="clicklist();" />  
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
			<th width="10%">车牌号</th>
		  </tr>
		  <tr>
		  <logic:present name="shqdheadlist">
							<logic:notEmpty name="shqdheadlist">
								<logic:iterate id="item" name="shqdheadlist" indexId="indexNo">
									<tr onmouseover="this.className='over'" onmouseout="this.className='out'" onclick="showInfo(<bean:write name="indexNo"/>,this);">
										<td><input type="radio" name="selectNos_shqdHead" id="radioId<bean:write name="indexNo"/>"  onclick="doBoxChange(configForm.isAll,configForm.selectNos);" value="<bean:write name="item" property="id"/>"/></td>									
								        	<td>  
										<logic:notEmpty name="item" property="customerBO">  
													<div><bean:write name="item" property="customerBO.name" /></div>
  					 						  </logic:notEmpty> 
									   </td>
								        <td><div><bean:write name="item" property="fhrq" /></div></td>
										<td><div><bean:write name="item" property="ysfs" /></div></td>
										<td><div><bean:write name="item" property="shr" /></div></td>
										<td><div><bean:write name="item" property="shdw" /></div></td>
										<td><div><bean:write name="item" property="chepaihao" /></div></td>
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
					
					<ssi:page property="pageInfo"  action="/shqdHeadManage.do?operate=list"/>
	</div>
	</td>
  </tr>
</table>
<table border="0" cellspacing="0" cellpadding="0" class="table_chax" id="adSearch">
  <tr>
    <th>品名：</th>
    <td><input type="text" id="pinming" readonly="true"   name="pinming" title="供应商"/><input name="button" type="button" value="查询" onclick="openwinMedicine();" /></td>
     <input type="hidden" name="pinzhongid" id="pinzhongid" />
    <th>规格：</th>
    <td><input type="text" id="guige"  name="guige"  title="运输方式"/></td>
  
   
    <th>件数：</th>
    <td><input type="text" id="jianshu"  name="jianshu"   title="联系电话"/></td>
     <th>来货数量：</th>
    <td><input type="text" id="laihuoshuliang"  name="laihuoshuliang"   title="送货人"/></td>
  </tr>
    <tr>
    <th>实收数量：</th>
    <td><input type="text" id="shishoushuliang"  name="shishoushuliang"   title="收货单位"/></td>
    <th>产地：</th>
    <td><input type="text" id="chandi"  name="chandi"   title="车牌号"/></td>
     <th>备注(批号)：</th>
    <td><input type="text" id="beizhu"  name="beizhu"   title="车牌号"/></td>
    <th><input name="checks"  type="button" value="添加" onclick="addShqd()"/></th>
  </tr>
</table>

<table border="0" cellpadding="0" cellspacing="0" class="table_list">
	 <tr>
	    <th width="89%">
		<div>
	      <input name="delete" type="button" value="删除" onclick="toDeleteShqd();"/>
		</div>
		</th>
  	</tr>
	<tr>
    <td colspan="2">
		<table border="0" cellpadding="0" cellspacing="0" class="table_date" id="dataTable">
		  <tr>
		    <th width="10%">请选择</th>
			<th width="10%">品名</th>
			<th width="15%">规格</th>
			<th width="20%">件数</th>
			<th width="10%">来货数量</th>
			<th width="10%">实收数量</th>
			<th width="10%">产地</th>
			<th width="10%">备注</th>
		  </tr>
		  <tr>
		  <logic:present name="shqdlist">
							<logic:notEmpty name="shqdlist">
								<logic:iterate id="item" name="shqdlist" indexId="indexNo">
									<tr onmouseover="this.className='over'" onmouseout="this.className='out'" onclick="showInfo('<bean:write name="indexNo"/>z',this);">
										<td><input type="radio" name="selectNos" id="radioId<bean:write name="indexNo"/>z"  onclick="doBoxChange(configForm.isAll,configForm.selectNos);" value="<bean:write name="item" property="id"/>"/></td>									
								          	<td>  
										<logic:notEmpty name="item" property="medicineBO">  
													<div><bean:write name="item" property="medicineBO.medicineName" /></div>
  					 						  </logic:notEmpty> 
									   </td>
								        <td><div><bean:write name="item" property="guige" /></div></td>
										<td><div><bean:write name="item" property="jianshu" /></div></td>
										<td><div><bean:write name="item" property="laihuoshuliang" /></div></td>
										<td><div><bean:write name="item" property="shishoushuliang" /></div></td>
										<td><div><bean:write name="item" property="chandi" /></div></td>
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

  </tr>
</table>
</html:form>
</body>
</html>
<script language="JavaScript">

			function excelReport (){
				 if(isRadioChecked(shqdHeadForm.selectNos_shqdHead)){
						document.shqdHeadForm.action="shqdHeadManage.do?operate=excelReport";
						document.shqdHeadForm.submit();
						 } else
					        {
					            alert("请选择唯一表头信息！");
					        }
					}
				function clicklist(){
					 if(isRadioChecked(shqdHeadForm.selectNos_shqdHead)){
					document.shqdHeadForm.action="shqdHeadManage.do?operate=list";
					document.shqdHeadForm.submit();
					 } else
				        {
				            alert("请选择唯一表头信息！");
				        }
				}

		function addShqd(){
			 if(isRadioChecked(shqdHeadForm.selectNos_shqdHead)){
			   document.shqdHeadForm.action="shqdHeadManage.do?operate=addShqd";
			   document.shqdHeadForm.submit();
			} else
	        {
	            alert("请选择唯一表头信息！");
	        }
		}
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
	function openwinMedicine()
    { 
    	var returnValue=window.showModalDialog("<%=request.getContextPath()%>/medicineManage.do?operate=windowlist",window, "dialogWidth:700px,dialogHeight:335px,dialogTop:200px,dialogLeft,200px ");
    	if (returnValue == undefined) {
            returnValue = window.returnValue;
        }
    	if(returnValue && returnValue!="")
 		{
	 	  	var  ret =returnValue.split(',');
	 	   	window.document.all['pinming'].value =ret[0];
	 	 	document.getElementById("pinzhongid").value=ret[1];
 		}
  	}
    function openwinSupplier()
    { 
    	var returnValue=window.showModalDialog("<%=request.getContextPath()%>/supplier.do?operate=windowlist",window, "dialogWidth:700px,dialogHeight:335px,dialogTop:200px,dialogLeft,200px ");
 		if(returnValue && returnValue!="")
 		{
	 	  	var  ret =returnValue.split(',');
	 	   	window.document.all['supplyname'].value =ret[0];
	 	 	document.getElementById("supplyid").value=ret[1];
 		}
  	}
    
    function addshqdHead(){
    	
    	   document.shqdHeadForm.action="shqdHeadManage.do?operate=add";
    	 //  document.shqdHeadForm.operate.value="add";
    	   document.shqdHeadForm.submit();
    }
    function toDelete()
    {
      
   	 if(isRadioChecked(shqdHeadForm.selectNos_shqdHead))
        {
        	if(confirm("确定要删除吗？"))
        	 {
       document.shqdHeadForm.action="shqdHeadManage.do?operate=toDelete";
        document.shqdHeadForm.submit();
        	}
        }
        else
        {
            alert("请选择唯一的品种信息！");
        }
	}
    
    function toDeleteShqd()
    {
      
   	 if(isRadioChecked(shqdHeadForm.selectNos))
        {
        	if(confirm("确定要删除吗？"))
        	 {
	       document.shqdHeadForm.action="shqdHeadManage.do?operate=toDeleteShqd";
	        document.shqdHeadForm.submit();
        	}
        }
        else
        {
            alert("请选择唯一的品种信息！");
        }
	}
	

</script>

