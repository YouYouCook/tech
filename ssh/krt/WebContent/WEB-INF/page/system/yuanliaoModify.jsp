<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/ssi.tld" prefix="ssi"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>原料订货确认-修改</title>
<link href="<%=request.getContextPath()%>/styles/gzt_css.css" rel="stylesheet" type="text/css" />
<script language="javascript" src="<%=request.getContextPath()%>/js/jquery-1.2.6.js"></script>
<script language="javascript" src="<%=request.getContextPath()%>/js/commons.js"></script>
<script language="javascript" src="<%=request.getContextPath()%>/js/control.js"></script>
<script language="javascript" src="<%=request.getContextPath()%>/js/formcheck.js"></script>
<script language="javascript" src="<%=request.getContextPath()%>/js/ajax.js"></script>
<script language="javascript" src="<%=request.getContextPath()%>/js/livevalidation_standalone.js"></script>
<script language="javascript" src="<%=request.getContextPath()%>/js/My97DatePicker/WdatePicker.js"></script>
</head>

<html:form method="post" action="/zhaobiaojinduManage.do?operate=update"   enctype="multipart/form-data">
<input type="hidden" name="operate"/>
<input type="hidden" name="zhaobiaojinduBo.id"  value="${zhaobiaojinduBo.id}"  />
<div class="weizhi">
	<div class="weizhi_bj">修改原料订货</div>
</div>
<table width="100%" border="0" cellspacing="0" cellpadding="0" class="table_add">
  <tr>
    <th >供方单位：</th>
	<td><input type="text" name="zhaobiaojinduBo.gonghuoshang"  value="${zhaobiaojinduBo.gonghuoshang}"  styleId="N_str_zhaobiaojinduBo.gonghuoshang" title="供方单位"  />
	</td>
	<th>需方单位：</th>
    <td><html:text property="zhaobiaojinduBo.xufangdanwei"  value="北京康仁堂药业有限公司"  styleId="N_str_zhaobiaojinduBo.xufangdanwei"  title="需方单位" />
	</td>
</tr>
<tr>	
	<th>联系人：</th>
    <td><html:text property="zhaobiaojinduBo.lianxiren"   value="${zhaobiaojinduBo.lianxiren}"  styleId="N_str_zhaobiaojinduBo.gonghuoshang"  title="联系人" />
	</td>
	<th >开标日期：</th>
	<td><input type="text" name="zhaobiaojinduBo.kaibiaoriqi"    value="${zhaobiaojinduBo.kaibiaoriqi}"   readonly="true"  title="开标日期" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" class="Wdate" />
	</td>
</tr>
<tr>	
	<th>电话：</th>
    <td><html:text property="zhaobiaojinduBo.dianhua"  value="${zhaobiaojinduBo.dianhua}"   styleId="N_str_zhaobiaojinduBo.dianhua"  title="电话" />
	</td>
	<th>最迟交大货日期：</th>
    <td><input type="text" name="zhaobiaojinduBo.zcjdhrq"    value="${zhaobiaojinduBo.zcjdhrq}"   readonly="true"  title="最迟交大货日期" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" class="Wdate" />
	</td>
</tr>
<!-- 
<tr>
	<th>质保金缴纳日期 ：</th>
    <td><input type="text" name="zhaobiaojinduBo.zhibaojinjnrq"   readonly="true"  title="质保金缴纳日期" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" class="Wdate" />
	</td>
	<th></th>
    <td></td>
 </tr> -->
 <tr>
    <th>品种明细</th>
 </tr>   
 <tr>
	<th>品名 ： </th>
	<td><html:text property="zhaobiaojinduBo.pinming"   value="${zhaobiaojinduBo.pinming}"   styleId="Y_str_zhaobiaojinduBo.pinming"    title="品名" />
	</td>
	<th>数量（kg） ：</th>
	<td><html:text property="zhaobiaojinduBo.shuliang"   value="${zhaobiaojinduBo.shuliang}"   styleId="Y_str_zhaobiaojinduBo.shuliang"  title="数量（kg）" />
	</td>
 </tr>
 <tr>
	<th>产地 ：</th>
	<td><html:text property="zhaobiaojinduBo.chandi"   value="${zhaobiaojinduBo.chandi}"  styleId="Y_str_zhaobiaojinduBo.chandi"     title="产地" />
	</td>
	<th>单价（元/kg） ：</th>
	<td><html:text property="zhaobiaojinduBo.danjia"   value="${zhaobiaojinduBo.danjia}"  styleId="Y_str_zhaobiaojinduBo.danjia"     title="单价（元/kg）" />
	</td>
 </tr>
 <tr>
	<th>金额(元) ：</th>	
	<td><html:text property="zhaobiaojinduBo.jine" value="${zhaobiaojinduBo.jine}"  styleId="Y_str_zhaobiaojinduBo.jine"    title="金额(元)" />
	</td>
	<th>质保金（元） ：</th>
	<td><html:text property="zhaobiaojinduBo.zhibaojin"   value="${zhaobiaojinduBo.zhibaojin}"  styleId="Y_str_zhaobiaojinduBo.zhibaojin"    title="质保金（元）" />
	</td>
 </tr>
 <tr>
	<th>装卸费（元） ：</th>
	<td><html:text property="zhaobiaojinduBo.zhuangxiefei" value="${zhaobiaojinduBo.zhuangxiefei}" styleId="Y_str_zhaobiaojinduBo.zhuangxiefei"    title="装卸费（元）" />
	</td>
	<th>确认交货日期 ：</th>
	<td><input type="text" name="zhaobiaojinduBo.qrjhrq"  value="${zhaobiaojinduBo.qrjhrq}"   readonly="true"  title="确认交货日期" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" class="Wdate" />
	</td>
 </tr>
 <tr>
	<th>品种属性 ：</th>
	<td><html:text property="zhaobiaojinduBo.pinzhongshuxing" value="${zhaobiaojinduBo.pinzhongshuxing}"   styleId="Y_str_zhaobiaojinduBo.pinzhongshuxing"      title="品种属性" />
	</td>
	<th>备注 ：</th>
	<td><html:text property="zhaobiaojinduBo.beizhu" value="${zhaobiaojinduBo.beizhu}"   styleId="N_str_zhaobiaojinduBo.beizhu"   title="备注" />
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
	         	document.zhaobiaojinduForm.action="zhaobiaojinduManage.do?operate=update";
	        	document.zhaobiaojinduForm.submit();
	        }
         }
    	
    }
    
    function backup()
    {
    	document.zhaobiaojinduForm.action="zhaobiaojinduManage.do?operate=list";
        document.zhaobiaojinduForm.submit();
    }

   function reset()
    {       		
    	document.zhaobiaojinduForm.reset();  
    }
   

</script>

</html>



