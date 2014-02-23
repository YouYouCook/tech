<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <script type="text/javascript" src="js/jquery-1.2.6.js"></script>   
       <script type="text/javascript" src="js/ajaxfileupload.js"></script>   
<title>兼容所有浏览器完美拖拽弹出层,网页特效,网页特效代码,javascript 特效</title>
<meta name="description" content="蜗客div+css网页制作工作室网页特效区为你提供网页特效,网页特效代码,javascript 特效,javascript网页特效,javascript特效下载,javascript特效代码等方面的知识">
<meta name="keywords" content="兼容所有浏览器完美拖拽弹出层,网页特效,网页特效代码,javascript 特效,javascript网页特效,javascript特效下载">
<style>

*{margin:0;padding:0;}
#div2{
	z-index: 9999;
	width:50%;
	height:200px;
	position:absolute;
	top:35%;
	left:25%;
	display:none;
	background:#fff;
	border-top:5px solid #999;
	border-bottom:7px solid #999;
	border-left:5px solid #999;
	border-right:7px solid #999;
}

.movediv{width:100%; height:100%;  overflow:hidden; background:#fff; border:1px #8c9ccb solid;}

.divneirong{padding:10px; line-height:24px; font-size:12px; color:#333333;}


        .mask {   
            color:#C7EDCC;
            background-color:#999;
            position:absolute;
            top:0px;
            left:0px;
            width:100%;
            height:3000px;
            opacity: 0.6;  
            filter: "alpha(opacity=60)";
            filter: alpha(Opacity=60);
        } 
		
#div2 h2{width:100%; background:#06F; height:29px; line-height:29px; font-size:12px; cursor:move; background:url(images/tanchukuang_bj01.gif) left top;}
.tanchu_bt01{float:left; width:70%; background:url(images/tanchukuang_ico01.gif) left 4px no-repeat; padding-left:20px; color:#FFF; font-weight:bold;}
.tanchu_bt02{float:right; width:33px; text-align:right; padding-right:10px;}
.tanchu_bt02 a{display:block; width:33px; height:21px; background:url(images/tanchukuang_ico03.gif) left top no-repeat;}
.tanchu_bt02 a:hover{display:block; width:33px; height:21px; background:url(images/tanchukuang_ico02.gif) left top no-repeat;}


</style>
<script type="text/javascript">

			
   	function ajaxFileUpload()   {  
   		if($("#file").val().length<=0){
   	 		alert("请先选择文件");
   	 		return false;
   		}
         $("#loading")   
        .ajaxStart(function(){   
            $(this).show();   
        })//开始上传文件时显示一个图片   
        .ajaxComplete(function(){   
            $(this).hide();   
        });//文件上传完成将图片隐藏起来   
        $.ajaxFileUpload   
        (   
            {   
                url:'uploadReport.do?operate=upload&serviceId='+$("#serviceId").val()+"&sccId="+$("#sccId").val(),//用于文件上传的服务器端请求地址   
                secureuri:false,//一般设置为false   
                fileElementId:'file',//文件上传空间的id属性  <input type="file" id="file" name="file" />   
                dataType: 'json',//返回值类型 一般设置为json  
                error: function (data, status)//服务器响应失败处理函数   
                {   
               		alert("上传附件失败，请稍后再试！");
                },
                success: function (data, status)  //服务器成功响应处理函数   
                {   
                	if(data.result==1){
                		alert("报告上传已完成");
                		//返回我的任务主界面
                		window.location = "<%=request.getContextPath()%>/verificate.do?operate=myList";
                	}else{
                		alert(data.message);
                	}
                }  
            }   
        )   
           
        return false;   
    }   



window.onload=function()
{
	
	var oDiv2=document.getElementById("div2");
	var zhezhao = document.getElementById("zhezhao");
	//var h2=oDiv2.getElementsByTagName("h2")[0];
	var h2 = document.getElementById("head");
	var right=document.getElementById("right");
	var bottom=document.getElementById("bottom");
	var mouseStart={};
	var divStart={};
	var rightStart={};
	var bottomStart={};
	//h2完美拖拽
	h2.onmousedown=function(ev)
	{
		var oEvent=ev||event;
		mouseStart.x=oEvent.clientX;
		mouseStart.y=oEvent.clientY;
		divStart.x=oDiv2.offsetLeft;
		divStart.y=oDiv2.offsetTop;
		
		if(h2.setCapture)
		{
			h2.onmousemove=doDrag3;
			h2.onmouseup=stopDrag3;
			h2.setCapture();
		}
		else
		{
			document.addEventListener("mousemove",doDrag3,true);
			document.addEventListener("mouseup",stopDrag3,true);
		}
	};
	function doDrag3(ev)
	{
		var oEvent=ev||event;
		var l=oEvent.clientX-mouseStart.x+divStart.x;
		var t=oEvent.clientY-mouseStart.y+divStart.y;
		if(l<0)
		{
			l=0;
		}
		else if(l>document.documentElement.clientWidth-oDiv2.offsetWidth)
		{
			l=document.documentElement.clientWidth-oDiv2.offsetWidth;
		}
		if(t<0)
		{
			t=0;
		}
		else if(t>document.documentElement.clientHeight-oDiv2.offsetHeight)
		{
			t=document.documentElement.clientHeight-oDiv2.offsetHeight;
		}
		oDiv2.style.left=l+"px";
		oDiv2.style.top=t+"px";
	};
	function stopDrag3()
	{
		if(h2.releaseCapture)
		{
			h2.onmousemove=null;
			h2.onmouseup=null;
			h2.releaseCapture();
		}
		else
		{
			document.removeEventListener("mousemove",doDrag3,true);
			document.removeEventListener("mouseup",stopDrag3,true);
		}
	}
};

function show(){ 
        var windowWidth = document.body.clientWidth;       
        var windowHeight = document.body.clientHeight;  
        //添加并显示遮罩层   
        $("<div id='mask'></div>").addClass("mask")   
                                  .click(function() {}) //hideDiv(div_id); })   
                                  .appendTo("body")
                                  .fadeIn(0);     
	document.getElementById("mask").style.display = "block";
	document.getElementById("div2").style.display = "block";
	
}

function hide(){
	$("#mask").remove();
	document.getElementById("div2").style.display = "none";
}




</script>
</head>

<body>
<div id="div2" >
	<div style="width:100% ;height:100%; overflow:hidden;">
	<table class = "" id ="head">
		<tr>
			<td>&nbsp;&nbsp;上传报告</td>
			<td></td>
			<td align="right" style="cursor:hand;"><a href = "javascript:hide();">
				<img src = "<%=request.getContextPath() %>/img/close.gif" border=0/></a>
				&nbsp;&nbsp;
			</td>
		</tr>
	</table>
	    <br />   
       
        <h2>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;请上传报告模板:</h2>
        
         <br />
         
		<div align="center">
		 	<font size ="3px">文件地址:&nbsp;&nbsp;</font><input type="file" id="file"  name = "file" onkeypress="event.returnValue=false;"/>    
        	<img src="<%=request.getContextPath() %>/img/loading.gif" id="loading" style="display: none;">   
	        <!-- 记录serviceId传递到后台 ，根据此id更新数据-->
	        <input type="hidden"  id="sccId" value='21'>
	        <input type="hidden"  id="serviceId" value = "111113DZ0008">   
	        <br />
	        <br />
		        <table>
					<tr>
						<td></td>
						<td><input type="button" value="确认提交" onclick="return ajaxFileUpload();">   </td>
						<td><input type="button" value="取&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;消" onclick="hide()"> </td>
						<td></td>
					</tr>
				</table>
        </div>
	</div>
</div>


<br/><br/><br/><br/><br/><br/><br/><br/>
<!--  
<input type ="button" value="test div show" onclick = "show()"></input>
<br/><br/>
<input type ="button" value="test div hide" onclick = "hide()"></input>

-->
显示图片
<img src = "<%=request.getContextPath()%>/showPhoto.do?operate=showPhoto&path=C:/Winter.jpg&scale=0.4"/>


</body>
</html>
