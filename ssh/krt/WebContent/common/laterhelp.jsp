	<%@ page contentType="text/html; charset=utf-8"%>
	<div align='center' id='hLater' style="VISIBILITY: visible;display:none;position:absolute;left:expression((document.body.clientWidth-200)/2);top:expression((document.body.clientHeight-40)/2);width:200;height:40;background-color:#FAFAD8;" >
			<table id='hgrid'>
				<tr><td>
			  <font style="family:宋体;size:12;">
			  正在处理中,请不要关闭此页面...<br>
			  </font>
				</td></tr><tr><td>
				<img src="<%=request.getContextPath() %>/images/loading.gif" width="120" height="15">
			  </td></tr>
		  </table>
	</div>