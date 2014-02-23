<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/ssi.tld" prefix="ssi"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>发票信息维护-修改</title>
<link href="<%=request.getContextPath()%>/styles/gzt_css.css" rel="stylesheet" type="text/css" />
<script language="javascript" src="<%=request.getContextPath()%>/js/jquery-1.2.6.js"></script>
<script language="javascript" src="<%=request.getContextPath()%>/js/commons.js"></script>
<script language="javascript" src="<%=request.getContextPath()%>/js/control.js"></script>
<script language="javascript" src="<%=request.getContextPath()%>/js/formcheck.js"></script>
<script language="javascript" src="<%=request.getContextPath()%>/js/ajax.js"></script>
<script language="javascript" src="<%=request.getContextPath()%>/js/livevalidation_standalone.js"></script>
<script language="javascript" src="<%=request.getContextPath()%>/js/My97DatePicker/WdatePicker.js"></script>
</head>

<html:form method="post" action="/fapiaoManage.do?operate=toAdd"   enctype="multipart/form-data">
<input type="hidden" name="operate">
<input type="hidden" name="fapiaoInfoBo.id"  value="${fapiaoInfoBo.id}">
<div class="weizhi">
	<div class="weizhi_bj">修改发票信息</div>
</div>
<table width="100%" border="0" cellspacing="0" cellpadding="0" class="table_add">
  <tr>
    <th >接收日期：</th>
	<td><input type="text" name="fapiaoInfoBo.jieshouriqi"  value = "${fapiaoInfoBo.jieshouriqi}" readonly="true" title="接收日期" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" class="Wdate" />
	
	</td>
</tr>
<tr>	
	<th>供应商：</th>
    <td><input type="text" name="fapiaoInfoBo.gongyingshang" value="${fapiaoInfoBo.gongyingshang}"  title="供应商" />
	</td>
</tr>
<tr>	
	<th>发票号码：</th>
    <td><input type="text" name="fapiaoInfoBo.fapiaohao" value="${fapiaoInfoBo.fapiaohao}"  title="发票号码" />
	</td>
</tr>
<tr>	
	<th>票额：</th>
    <td><input type="text" name="fapiaoInfoBo.kaipiaojiage" value="${fapiaoInfoBo.kaipiaojiage}"  title="票额" />
	</td>
</tr>	
<tr>
	<th >开票日期：</th>
	<td><input type="text" name="fapiaoInfoBo.kaipiaoriqi" value="${fapiaoInfoBo.kaipiaoriqi}"  readonly="true"  title="开票日期" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" class="Wdate" />
	</td>
</tr>	
<tr>
	<th>票面信息：</th>
    <td><input type="text" name="fapiaoInfoBo.piaomianxinxi" value="${fapiaoInfoBo.piaomianxinxi}"  title="票面信息" />
	</td>
</tr>	
<tr>
	<th>备注 ：</th>
    <td><input type="text" name="fapiaoInfoBo.beizhu" value="${fapiaoInfoBo.beizhu}"  title="备注" />
	</td>
  </tr>
   <tr>
    <td colspan="2">
	<div>
	<input type="button" name="Submit" value="确 认" onclick="update()"/>
    <input type="button" name="Submit2" value="重 置" onclick="reset();"/>
    <input type="button" name="Submit3" value="返 回" onclick="backup();"/>
	</div>
	</td>
  </tr>
</table>
</html:form>
</html>
<script language="JavaScript">
	
	function update()
	{
		
	   		 if(checkSubmit(document.fapiaoForm)){
			    if(confirm("确定要修改此信息吗？"))
		        {
		         	document.fapiaoForm.action="fapiaoManage.do?operate=update";
		         	fapiaoForm.submit();
		        }
	    	}
	    
	     
	}
    
    function backup()
    {
    	document.fapiaoForm.action="fapiaoManage.do?operate=list";
        document.fapiaoForm.submit();
    }

   function reset()
    {       		
    	document.fapiaoForm.reset();  
    }
</script>



