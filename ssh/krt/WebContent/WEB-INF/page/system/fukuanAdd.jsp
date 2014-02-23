<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/ssi.tld" prefix="ssi"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>发票信息维护-增加</title>
<link href="<%=request.getContextPath()%>/styles/gzt_css.css" rel="stylesheet" type="text/css" />
<script language="javascript" src="<%=request.getContextPath()%>/js/jquery-1.2.6.js"></script>
<script language="javascript" src="<%=request.getContextPath()%>/js/commons.js"></script>
<script language="javascript" src="<%=request.getContextPath()%>/js/control.js"></script>
<script language="javascript" src="<%=request.getContextPath()%>/js/formcheck.js"></script>
<script language="javascript" src="<%=request.getContextPath()%>/js/ajax.js"></script>
<script language="javascript" src="<%=request.getContextPath()%>/js/livevalidation_standalone.js"></script>
<script language="javascript" src="<%=request.getContextPath()%>/js/My97DatePicker/WdatePicker.js"></script>
</head>

<html:form method="post" action="/fukuanManage.do?operate=toAdd"   enctype="multipart/form-data">
<input type="hidden" name="operate">
<div class="weizhi">
	<div class="weizhi_bj">添加发票</div>
</div>
<table width="100%" border="0" cellspacing="0" cellpadding="0" class="table_add">

  <tr>
    <th >发票号：</th>
	    <td><html:text property="fukuanDetailbo.fapiaohaoma"   readonly="true" styleId="N_str_fukuanDetailbo.fapiaohaoma"  title="供应商"/><input name="button" type="button" value="查询" onclick="openwinFapiao();" />
	</td>
</tr>
  <tr>
    <th >品名：</th>
	    <td><html:text property="fukuanDetailbo.pinming" styleId="N_str_fukuanDetailbo.pinming"  title="供应商" />
	</td>
	  <th >预计支付时间：</th>
	<td><input type="text" name="fukuanDetailbo.yjzfsj"  readonly="true" title="接收日期" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" class="Wdate" />
	</td>
</tr>
<tr>	
	<th>供应商：</th>
    <td><html:text property="fukuanDetailbo.gongyingshang"    styleId="N_str_fukuanDetailbo.gongyingshang"  title="供应商" />
	</td>
	<th>实际付款时间：</th>
	<td><input type="text" name="fukuanDetailbo.sjfksj"  readonly="true" title="接收日期" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" class="Wdate" />
	</td>
</tr>
<tr>	
 <th>开票日期：</th>
	<td><input type="text" name="fukuanDetailbo.kaipiaoriqi"  readonly="true" title="接收日期" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" class="Wdate" />
	</td>
	<th>挂账金额：</th>
    <td><html:text property="fukuanDetailbo.guazhangjie" styleId="Y_str_fapiaoInfoB.guazhangjie"  title="挂账金额" /></textarea><span>*</span><font>此项为必填项</font>
	</td>
</tr>
<tr>	
	<th>账期：</th>
	<td><input type="text" name="fukuanDetailbo.zhangqi"  styleId="Y_str_fukuanDetailbo.zhangqi"    title="账期"  />
	</td>
	<th >放行时间：</th>
	<td><input type="text" name="fukuanDetailbo.gzsj""  readonly="true" title="接收日期" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" class="Wdate" />
	</td>
</tr>	

<tr>	
	<th>预计支付金额：</th>
    <td><html:text property="fukuanDetailbo.yjzfje" styleId="N_float_fukuanDetailbo.yjzfje"  title="票额" />
	</td>
	<th >备注：</th>
	<td><input type="text" name="fukuanDetailbo.beizhu"     title="备注" />
	</td>
</tr>	
<tr>
	<th>数量：</th>
    <td><html:text property="fukuanDetailbo.shuliang" styleId="N_str_fukuanDetailbo.shuliang"  title="票面信息" />
	</td>
	<th>批号：</th>
    <td><html:text property="fukuanDetailbo.pihao" styleId="N_str_fukuanDetailbo.pihao"  title="备注" />
	</td>
  </tr>
   <tr>
    <td colspan="2">
	<div>
	<input type="button" name="Submit" value="确 认" onclick="add()"/>
    <input type="button" name="Submit2" value="重 置" onclick="reset();"/>
    <input type="button" name="Submit3" value="返 回" onclick="backup();"/>
	</div>
	</td>
  </tr>
</table>
</html:form>
</html>
<script language="JavaScript">

    function add()
    {	
    	
        if(checkSubmit(document.fukuanForm)){
    		if(confirm("确定要增加此信息吗？"))
	        {
	         	document.fukuanForm.action="fukuanManage.do?operate=add";
	        	document.fukuanForm.submit();
	        }
         }
    	
    }
	function openwinFapiao()  { 
  
    	var returnValue=window.showModalDialog("<%=request.getContextPath()%>/fapiaoManage.do?operate=windowlist",window, "dialogWidth:700px,dialogHeight:335px,dialogTop:200px,dialogLeft,200px ");
 		if(returnValue && returnValue!="")
 		{
	 	  	var  ret =returnValue.split(',');
	 	  	if(window.document.all['fukuanDetailbo.fapiaohaoma'].value==""){
	 	  	  	window.document.all['fukuanDetailbo.fapiaohaoma'].value = ret[0];
	 	  	}else{
	 	  	  	window.document.all['fukuanDetailbo.fapiaohaoma'].value =window.document.all['fukuanDetailbo.fapiaohaoma'].value+","+ret[0];
	 	  	}
	 		window.document.all['fukuanDetailbo.gongyingshang'].value =ret[1];
	 	   
 		}
  	}
    
    function backup()
    {
    	document.fukuanForm.action="fukuanManage.do?operate=list";
        document.fukuanForm.submit();
    }

   function reset()
    {       		
    	document.fukuanForm.reset();  
    }
</script>



