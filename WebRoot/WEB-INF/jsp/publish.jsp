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
<script src="。/js/jquery-1.11.1.min.js"></script>
<script src="./js/bootstrap.min.js"></script>
<!-- start menu -->
  <style>
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
					<li class="active"><a href="essay_publish">发表</a></li>
					<li><a href="user_info?userid=${existUser.userid }">我的信息</a></li>
		  	
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
	    <div class="work">
				<div class="details">
					<form action="essay_save" method="post"role="form">
					  <div class="form-group">
					    <label for="name">文本框</label>
					   <textarea id="essay"  name="essay"  style=" height: 127px; width: 600px;"></textarea>
					   <input type="hidden" name="user.userid" value="${existUser.userid}"/>
					   <input type="hidden" name="estate" value="1"/>
					  </div>
					  <input class="btn btn-success pull-left" type="submit"/>
					</form>
					
				</div>
			</div>		
</div>					
		
		 <div class="copywrite">
			 <p>© 2015 Curriculum Vitae All Rights Reseverd | Design by <a href="http://w3layouts.com/" target="_blank">W3layouts</a> </p>
		 </div>
	</div>
</div>
<!---->
<script type="text/javascript" charset="utf-8" src="./edit/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8" src="./edit/ueditor.all.min.js"> </script>
<script type="text/javascript">
var editor=UE.getEditor('essay',{
	toolbars: [
        ['fullscreen',  'redo', 'bold', 'italic', 'underline', 'fontborder', 'strikethrough', 'superscript', 
        	'subscript', 'removeformat', 'formatmatch', 'autotypeset', 'simpleupload','backcolor','scrawl','spechars',
        	'blockquote', 'pasteplain', '|', 'forecolor',  'insertorderedlist', 'emotion',
        	'insertunorderedlist',]
    ],
		    
		    autoHeightEnabled: true,
		    autoFloatEnabled: true
			
		});
		var lang = ue.getOpt('lang');
		
	
</script>
</body></html>