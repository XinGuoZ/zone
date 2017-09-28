<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
width: 150px;
height: 150px;
opacity: 0;
margin: 1px auto;
}


</style>
</head>
<body>
<!-- header -->
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
					<li ><a href="user_registPage">注册</a></li>
					<li><a href="index_myessay.action?userid=${existUser.userid}">我的</a></li>
					<li ><a href="essay_publish">发表</a></li>
		  			<li class="active"> <a>我的信息</a></li>
			  		<li><form class="navbar-form navbar-left " role="search" action="user_login"method="post">
					  <div class="form-group ">
					    <input name="username" type="text" class="form-control" placeholder="用户名">
					  </div>
					  <div class="form-group ">
					    <input name="userpass" type="password" class="form-control" placeholder="密码">
					  </div>
					  <button type="submit" class="btn btn-info">登入</button>
					</form></li>
				</ul>
			</div>
  		</div>
</div>


<div class="content">
	 <div class="container">		 
		  <h3>Work Experience</h3>
	    <div class="work">
	     <form class="form-horizontal col-sm-offset-3 col-md-offset-3" id="register_form" action="user_update" method="post"
            validate="true" novalidate="novalidate" enctype="multipart/form-data" onsubmit="return checkForm()">  
                <h3 class="form-title">Login to your account</h3>  
                <div class="col-sm-9 col-md-9"> 
                	<div class="form-group ">  
                            <i class="fa fa-envelope fa-lg"></i>  
                            <div class="btn btn-info " style="background-image: url('${user.imgpath}');">
                            	<input type="file" class="file" name="imgfile"/>  
                            </div>
                            
                    </div> 
                    <div class="form-group">  
                        <i class="fa fa-user fa-lg"></i>  
                        <input class="form-control required" type="text" placeholder="用户名" value="${user.username }" id="username" name="username" onblur="checkUsername()" autofocus="autofocus"/>
                       	<input type="hidden" value="${existUser.userid}" name="userid">  
                        <span id="span1"></span>
                    </div>  
                     <div class="form-group">  
                        <input type="submit" class="btn btn-success pull-right" value="Sign Up "/>  
                        <input type="reset" class="btn btn-info pull-left" id="back_btn" value="Back"/>  
                    </div>  
                </div>  
            </form>  
	    
		</div>		
</div>					
		 
		 <div class="copywrite">
			 <p>© 2015 Curriculum Vitae All Rights Reseverd | Design by <a href="http://w3layouts.com/" target="_blank">W3layouts</a> </p>
		 </div>
	</div>
</div>
<!---->

</body>
	<script type="text/javascript">
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
	</script>
</html>