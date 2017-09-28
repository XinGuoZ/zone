<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html><head>
<title>www.zxgmw.cc</title>
<!-- Custom Theme files -->
<link href="css/bootstrap.css" rel="stylesheet" type="text/css">
<link href="css/style.css" rel="stylesheet" type="text/css">
<!--//theme-style-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="keywords" content="Curriculum Vitae Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design">
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<link href="http://fonts.googleapis.com/css?family=Ubuntu:300,400,500,700" rel="stylesheet" type="text/css">
<link href="http://fonts.googleapis.com/css?family=Varela+Round" rel="stylesheet" type="text/css">
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<!-- start menu -->
<style>
.signin{
width:650px;
height:100px;
}
.file{
width: 50px;
opacity: 0;
margin: 1px auto;
}


.img{background-image:url(images/img.jpg);}
</style>
<script type="text/javascript">
		/* 
			标点验证
		
		*/
		function checkForm(){
			// 校验用户名:
			// 获得用户名文本框的值:
			var username = document.getElementById("username").value;
			if(username == null || username == ''){
				alert("用户名不能为空!");
				return false;
			}
			// 校验密码:
			// 获得密码框的值:
			var password = document.getElementById("userpass").value;
			if(password == null || password == ''){
				alert("密码不能为空!");
				return false;
			}
			// 校验确认密码:
			var repassword = document.getElementById("repassword").value;
			if(repassword != password){
				alert("两次密码输入不一致!");
				return false;
			}
		}
		
		/* 进行ajax校验 */
			function checkUsername(){
				// 获得文件框值:
				var username = document.getElementById("username").value;
				// 1.创建异步交互对象
				var xhr = createXmlHttp();
				// 2.设置监听
				xhr.onreadystatechange = function(){
					if(xhr.readyState == 4){
						if(xhr.status == 200){
							document.getElementById("span1").innerHTML = xhr.responseText;
						}
					}
				}
				// 3.打开连接
				xhr.open("GET","${pageContext.request.contextPath}/user_findByName?time="+new Date().getTime()+"&username="+username,true);
				// 4.发送
				xhr.send(null);
			}
			
			function createXmlHttp(){
				   var xmlHttp;
				   try{ // Firefox, Opera 8.0+, Safari
				        xmlHttp=new XMLHttpRequest();
				    }
				    catch (e){
					   try{// Internet Explorer
					         xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
					      }
					    catch (e){
					      try{
					         xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
					      }
					      catch (e){}
					      }
				    }
	
					return xmlHttp;
				 }
			
			function change(){
				var img1 = document.getElementById("checkImg");
				img1.src="${pageContext.request.contextPath}/CheckImg.action?"+new Date().getTime();
			}
			
		</script>
</head>
<body>
<!-- header -->

<nav class="navbar navbar-default navbar-static-top">
  <div class="container">
  	<div class="navbar-header">
			<a class="navbar-brand" href="index">首页</a>
		</div>
		
		<div>
			<ul class="nav navbar-nav">
				
			</ul>
		</div>
  	
  
  </div>
</nav>

<div class="navbar navbar-default navbar-static-top">
  <div class="container">
  	<div class="navbar-header">
	  	<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
		    <span class="sr-only">切换导航</span>
		    <span class="icon-bar"></span>
		    <span class="icon-bar"></span>
		    <span class="icon-bar"></span>
	    </button>
		<a class="navbar-brand" href="index">首页</a>
	</div>
		
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="user_register">注册</a></li>
					<li><a href="#">我的</a></li>
					<li ><a href="#">发表</a></li>
				</ul>
			</div>
  		</div>
</div>

<div class="form row signin">  
            <form class="form-horizontal col-sm-offset-3 col-md-offset-3" id="register_form" action="user_regist" method="post"
            validate="true" novalidate="novalidate" enctype="multipart/form-data" onsubmit="return checkForm()">  
                <h3 class="form-title">Login to your account</h3>  
                <div class="col-sm-9 col-md-9"> 
                	<div class="form-group ">  
                            <i class="fa fa-envelope fa-lg"></i>  
                            <div class="btn btn-info img">
                            	<input type="file" class="file" name="imgfile"/>  
                            </div>
                            
                    </div> 
                    <div class="form-group">  
                        <i class="fa fa-user fa-lg"></i>  
                        <input class="form-control required" type="text" placeholder="用户名" id="username" name="username" onblur="checkUsername()" autofocus="autofocus"/>  
                        <span id="span1"></span>
                    </div>  
                    <div class="form-group">  
                            <i class="fa fa-lock fa-lg"></i>  
                            <input class="form-control required" type="password" placeholder="密码" id="userpass" name="userpass"/>  
                    </div>  
                    <div class="form-group">  
                            <i class="fa fa-check fa-lg"></i>  
                            <input class="form-control required" type="password" placeholder="确认密码" name="rpassword"/>  
                    </div>  
                   
                    <div class="form-group">  
                            <i class="fa fa-envelope fa-lg"></i>  
                            <input class="form-control eamil" type="text" placeholder="Email" name="email"/>  
                    </div> 
					
					 					<div class="form-group">  
                        <i class="fa fa-user fa-lg">用户生日</i> 
                        <div class="pull-left">
                        	<input class="" type="date" name="userboth"/>
                        </div>
                             
                    </div>  
										
                    <div class="form-group ">  
                      <input type="text" id="checkcode" name="checkcode" placeholder="请输入验证码" class="text captcha" maxlength="4" autocomplete="off">
                    	<img id="checkImg" class="captchaImage" src="${pageContext.request.contextPath}/CheckImg.action" onclick="change()" title="点击更换验证码">
                    </div> 
                    
                    <div class="form-group">  
                        <input type="submit" class="btn btn-success pull-right" value="Sign Up "/>  
                        <input type="reset" class="btn btn-info pull-left" id="back_btn" value="Back"/>  
                    </div>  
                </div>  
            </form>  
        </div>  
		 </div>



</body></html>