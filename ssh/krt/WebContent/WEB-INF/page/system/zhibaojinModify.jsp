<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/WEB-INF/ssi.tld" prefix="ssi"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>质保金-修改</title>
<link href="<%=request.getContextPath()%>/styles/gzt_css.css" rel="stylesheet" type="text/css" />
<script language="javascript" src="<%=request.getContextPath()%>/js/jquery-1.2.6.js"></script>
<script language="javascript" src="<%=request.getContextPath()%>/js/commons.js"></script>
<script language="javascript" src="<%=request.getContextPath()%>/js/control.js"></script>
<script language="javascript" src="<%=request.getContextPath()%>/js/formcheck.js"></script>
<script language="javascript" src="<%=request.getContextPath()%>/js/ajax.js"></script>
<script language="javascript" src="<%=request.getContextPath()%>/js/livevalidation_standalone.js"></script>
<script language="javascript" src="<%=request.getContextPath()%>/js/My97DatePicker/WdatePicker.js"></script>
</head>

<html:form method="post" action="/zhaobiaojinduManage.do?operate=ZBJupdate"   enctype="multipart/form-data">
<input type="hidden" name="operate"/>
<input type="hidden" name="zhaobiaojinduBo.id"  value="${zhaobiaojinduBo.id}"  />
<div class="weizhi">
	<div class="weizhi_bj">修改质保金</div>
</div>
<table width="100%" border="0" cellspacing="0" cellpadding="0" class="table_add">
  <tr>
  
  <th>品名 ： </th>
	<td><html:text property="zhaobiaojinduBo.pinming"   value="${zhaobiaojinduBo.pinming}"   styleId="Y_str_zhaobiaojinduBo.pinming"    title="品名" />
	</td>
    <th >供方单位：</th>
	<td><input type="text" name="zhaobiaojinduBo.gonghuoshang"  value="${zhaobiaojinduBo.gonghuoshang}"  styleId="N_str_zhaobiaojinduBo.gonghuoshang" title="供方单位"  />
	</td>
	
</tr>
 <tr>
		<th>品种属性 ：</th>
	<td><html:text property="zhaobiaojinduBo.pinzhongshuxing" value="${zhaobiaojinduBo.pinzhongshuxing}"   styleId="Y_str_zhaobiaojinduBo.pinzhongshuxing"      title="品种属性" />
	</td>
	<th>数量（kg） ：</th>
	<td><html:text property="zhaobiaojinduBo.shuliang"   value="${zhaobiaojinduBo.shuliang}"   styleId="Y_str_zhaobiaojinduBo.shuliang"  title="数量（kg）" />
	</td>
 </tr>
 <tr>
	
	<th>单价（元/kg） ：</th>
	<td><html:text property="zhaobiaojinduBo.danjia"   value="${zhaobiaojinduBo.danjia}"  styleId="Y_str_zhaobiaojinduBo.danjia"     title="单价（元/kg）" />
	</td>
	<th>质保金（元） ：</th>
	<td><html:text property="zhaobiaojinduBo.zhibaojin"   value="${zhaobiaojinduBo.zhibaojin}"  styleId="Y_str_zhaobiaojinduBo.zhibaojin"    title="质保金（元）" />
	</td>
 </tr>
 
 
  <c:if test="${sessionScope['Logon.User'].loginRole ==1}">
  <tr>
	<th>质保金状态(采购部) ：</th>
	<td>
	<select name="zhaobiaojinduBo.zhibaojinzt" style= "width:100px">
    										<option value="" <logic:equal name="zhaobiaojinduBo" property="zhibaojinzt"   value="">selected</logic:equal>>请选择</option>
											<option value="0" <logic:equal name="zhaobiaojinduBo" property="zhibaojinzt"   value="0">selected</logic:equal>>未缴纳</option>
											<option value="1" <logic:equal name="zhaobiaojinduBo"  property="zhibaojinzt"  value="1">selected</logic:equal>>已缴纳</option>
											<option value="2" <logic:equal name="zhaobiaojinduBo"  property="zhibaojinzt"  value="2">selected</logic:equal>>已退还</option>
										</select></td>
	</td>
	<th>质保金缴纳日期(采购部) ：</th>
	    <td><input type="text" name="zhaobiaojinduBo.zhibaojinjnrq"     value="${zhaobiaojinduBo.zhibaojinjnrq}"   title="质保金缴纳日期"  readonly="true"  onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" class="Wdate" />
	 </tr>
	 
	    <tr>
	<th>质保金状态(财务部) ：</th>
	<td>
	<select name="zhaobiaojinduBo.zhibaojinztzl" style= "width:100px">
    										<option value="" <logic:equal name="zhaobiaojinduBo" property="zhibaojinztzl"   value="">selected</logic:equal>>请选择</option>
											<option value="0" <logic:equal name="zhaobiaojinduBo" property="zhibaojinztzl"   value="0">selected</logic:equal>>未缴纳</option>
											<option value="1" <logic:equal name="zhaobiaojinduBo"  property="zhibaojinztzl"  value="1">selected</logic:equal>>已缴纳</option>
											<option value="2" <logic:equal name="zhaobiaojinduBo"  property="zhibaojinztzl"  value="2">selected</logic:equal>>已退还</option>
										</select></td>
	</td>
	<th>质保金缴纳日期(财务部) ：</th>
	    <td><input type="text" name="zhaobiaojinduBo.zhibaojinjnrqzl"     value="${zhaobiaojinduBo.zhibaojinjnrqzl}"   title="质保金缴纳日期"  readonly="true"  onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" class="Wdate" />
	 </tr>
	 </c:if>
 
 <c:if test="${sessionScope['Logon.User'].loginRole ==2}">
  <tr>
	<th>质保金状态(采购部) ：</th>
	<td>
	<select name="zhaobiaojinduBo.zhibaojinzt" style= "width:100px">
    										<option value="" <logic:equal name="zhaobiaojinduBo" property="zhibaojinzt"   value="">selected</logic:equal>>请选择</option>
											<option value="0" <logic:equal name="zhaobiaojinduBo" property="zhibaojinzt"   value="0">selected</logic:equal>>未缴纳</option>
											<option value="1" <logic:equal name="zhaobiaojinduBo"  property="zhibaojinzt"  value="1">selected</logic:equal>>已缴纳</option>
											<option value="2" <logic:equal name="zhaobiaojinduBo"  property="zhibaojinzt"  value="2">selected</logic:equal>>已退还</option>
										</select></td>
	</td>
	<th>质保金缴纳日期(采购部) ：</th>
	    <td><input type="text" name="zhaobiaojinduBo.zhibaojinjnrq"     value="${zhaobiaojinduBo.zhibaojinjnrq}"   title="质保金缴纳日期"  readonly="true"  onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" class="Wdate" />
	 </tr>
	 </c:if>
	 
	  <c:if test="${sessionScope['Logon.User'].loginRole ==4}">
	   <tr>
	<th>质保金状态(财务部) ：</th>
	<td>
	<select name="zhaobiaojinduBo.zhibaojinztzl" style= "width:100px">
    										<option value="" <logic:equal name="zhaobiaojinduBo" property="zhibaojinztzl"   value="">selected</logic:equal>>请选择</option>
											<option value="0" <logic:equal name="zhaobiaojinduBo" property="zhibaojinztzl"   value="0">selected</logic:equal>>未缴纳</option>
											<option value="1" <logic:equal name="zhaobiaojinduBo"  property="zhibaojinztzl"  value="1">selected</logic:equal>>已缴纳</option>
											<option value="2" <logic:equal name="zhaobiaojinduBo"  property="zhibaojinztzl"  value="2">selected</logic:equal>>已退还</option>
										</select></td>
	</td>
	<th>质保金缴纳日期(财务部) ：</th>
	    <td><input type="text" name="zhaobiaojinduBo.zhibaojinjnrqzl"     value="${zhaobiaojinduBo.zhibaojinjnrqzl}"   title="质保金缴纳日期"  readonly="true"  onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" class="Wdate" />
	 </tr>
	 </c:if>
	<tr>
		<th>备注 ：</th>
	<td><html:text property="zhaobiaojinduBo.beizhu" value="${zhaobiaojinduBo.beizhu}"   styleId="N_str_zhaobiaojinduBo.beizhu"   title="备注" />
	</td>
	
		<th>应退质保金 ：</th>
	<td><html:text property="zhaobiaojinduBo.yingtuizhibaojin"   value="${zhaobiaojinduBo.yingtuizhibaojin}"  styleId="N_str_zhaobiaojinduBo.zhibaojin"    title="应退质保金（元）" />
	</td>
 </tr>
 
 <tr>
    <td colspan="4">
	<div>
	<input type="button" name="Submit" value="确 认" onclick="update()"/>
    <input type="button" name="Submit2" value="重 置" onclick="reset();"/>
    <input type="button" name="Submit3" value="返 回" onclick="backup();"/>
	</div>
	</td>
  </tr>
</table>
	    
</html:form>
<script language="JavaScript">

    function update()
    {	
    	
        if(checkSubmit(document.zhaobiaojinduForm)){
    		if(confirm("确定要修改此信息吗？"))
	        {
	         	document.zhaobiaojinduForm.action="zhaobiaojinduManage.do?operate=ZBJupdate";
	        	document.zhaobiaojinduForm.submit();
	        }
         }
    	
    }
    
    function backup()
    {
    	document.zhaobiaojinduForm.action="zhaobiaojinduManage.do?operate=zhibaolist";
        document.zhaobiaojinduForm.submit();
    }

   function reset()
    {       		
    	document.zhaobiaojinduForm.reset();  
    }
   

</script>

</html>



