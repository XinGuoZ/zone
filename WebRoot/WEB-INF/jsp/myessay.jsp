<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html><head>
<title>www.zxgmw.cc</title>
<!-- Custom Theme files -->
<link href="./css/bootstrap.css" rel="stylesheet" type="text/css">
<link href="./css/style.css" rel="stylesheet" type="text/css">
<!--//theme-style-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="keywords" content="Curriculum Vitae Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design">
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<link href="http://fonts.googleapis.com/css?family=Ubuntu:300,400,500,700" rel="stylesheet" type="text/css">
<link href="http://fonts.googleapis.com/css?family=Varela+Round" rel="stylesheet" type="text/css">

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
					<li><a class="active" href="index_myessay.action?userid=${existUser.userid}">${username}</a></li>
					<li><a onclick="return check()" href="essay_publish">发表</a></li>
					<li><a onclick="return check()" href="user_info?userid=${existUser.userid }">我的信息</a></li>
	  			
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


<div class="container">
	 <div class="header">		 
		 <img src="${existUser.imgpath }" class="img-circle" height="120" width="120">
	 </div>
	 <div class="header-right">
		 
		 <h2>web developer<br> &amp; designer</h2>		
	 </div>
	 <div class="clearfix"></div>
</div>


<!---->
<div class="content">
	 <div class="container">		 
		  <h3>当前用户：<c:out value="${existUser.username }"></c:out></h3>
		  <c:forEach items="${eslist.list}" var="list">
		  	
	       <div class="work">
	       
			 <div class="details">
				 <div class="col-md-7 posts">
				 <c:forEach items="${user}" var="user"> 
				 	<c:if test="${list.user.userid==user.userid }">
				 		<h4><c:if test="${user.imgpath!=null &&user.imgpath!='' }">	
									<img src="${user.imgpath }" class="img-circle" height="50" width="50">
								</c:if>
								 <c:if test="${user.imgpath==null||user.imgpath=='' }">	
								 	<img src="images/head.png" class="img-circle" height="50" width="50">
								 </c:if>
					 			&amp;<c:out value="${user.username }"></c:out></h4>
				 	</c:if>
				</c:forEach>
					 <p><c:out value="${list.essay }" escapeXml="false"></c:out></p>
				 </div>	
				 <!--评论的模块-->
				 
				 <div  class="col-md-7 posts">
				 	<a id="tog">查看评论</a>
				 	<div  id="ptext">
				 	<c:forEach items="${comments }" var="comments">
				 		<c:if test="${list.esid==comments.essay.esid}">
				 		<c:forEach items="${user}" var="user"> 
				 			<c:if test="${user.userid==comments.user.userid }">
				 				<p style="padding: 5px;"><img src="${user.imgpath }" class="img-circle" height="35" width="35"><c:out value="${user.username }"></c:out>:<c:out value="${comments.comment }"></c:out></p>
				 				<c:forEach items="${reply }" var="reply">
				 					<c:if test="${comments.comid==reply.comment.comid }">
				 						<c:if test="${user.userid==reply.user.userid }">
				 							<p><c:out value="${user.username }"></c:out>回复:<c:out value="${reply.reply }"></c:out></p>
				 						</c:if>
				 					</c:if>
				 					
				 				</c:forEach>
				 			</c:if>
				 		</c:forEach>
				 			
				 		</c:if>
				 	 </c:forEach>	
				 	</div>
				 </div>
				
				 <div class="col-md-2 date">
					 <p><c:out value="${list.date }"></c:out></p>
				 </div>
				 <c:if test="${list.user.userid==existUser.userid }">
				 	<a onclick="return del()" href="essay_delete?esid=${list.esid }" class="btn btn-danger">删除文章</a>
				 </c:if>
				 
				 <div class="clearfix"></div>
			 </div>
			 
		 		<div class="col-md-7 posts">
					<form class="bs-example bs-example-form" onsubmit="return check()" method="post" role="form" action="comment_save">
						<input type="hidden" name="essay.esid" value="<c:out value="${list.esid }"/>">
						<input name="user.userid" type="hidden" value="<c:out value='${existUser.userid}'/>">
								<div class="input-group">
									<input name="comment" type="text" class="form-control">
									<span class="input-group-btn">
										<button class="btn btn-default" type="submit">
											评论
										</button>
									</span>
								</div><!-- /input-group -->
					</form>
					
				</div>	
				
			</div>
			 <div class="clearfix"></div>
			 	
			</c:forEach>	
	     <ul class="pagination">
	    	<li><a href="index_myessay?page=1&userid=${userid}">首页</a></li> 
	    	<c:if test="${eslist.page-1>0}">
        		<li><a href="index_myessay?page=${eslist.page-1 }&userid=${userid}">&laquo;</a></li> 
        	</c:if>
	    	<c:if test="${eslist.page-2>0}">
        		<li><a href="index_myessay?page=${eslist.page-2 }&userid=${userid}">${eslist.page-2 }</a></li> 
        	</c:if>
        	<c:if test="${eslist.page-1>0}">
        		<li><a href="index_myessay?page=${eslist.page-1 }&userid=${userid}">${eslist.page-1 }</a></li> 
        	</c:if>
				<li class="active"><a>${eslist.page}</a></li>
				
			<c:if test="${eslist.page+1<eslist.totalpage}">
        		<li><a href="index_myessay?page=${eslist.page+1 }&userid=${userid}">${eslist.page+1 }</a></li> 
        	</c:if>
        	<c:if test="${eslist.page+2<eslist.totalpage}">
        		<li><a href="index_myessay?page=${eslist.page+2 }&userid=${userid}">${eslist.page+2 }</a></li> 
        	</c:if>
        	<c:if test="${eslist.page+1<eslist.totalpage }">
        		<li><a href="index_myessay?page=${eslist.page+1 }&userid=${userid}">&raquo;</a></li>
        	</c:if>
        	<li><a href="index_myessay?page=${eslist.totalpage }&userid=${userid}">末页</a></li>
			</ul>	 
		 
		 
		 <div class="copywrite">
			 <p>© 2015 Curriculum Vitae All Rights Reseverd | Design by <a href="http://w3layouts.com/" target="_blank">W3layouts</a> </p>
		 </div>
	</div>
</div>
<!---->
<script src="./js/jquery.min.js"></script>
<script src="./js/bootstrap.min.js"></script>
<script src="./js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
function check(){
	 var user=<%=session.getAttribute("existUser")%>;
	 if(user!=null){
		 
		return true;
		
	} 
	 alert("未登入请登入再发表");
	 return false;
}
function del(){
	if(confirm("您确定要删除吗?")){
		return true;
	}
	return false;
}

</script>
</body></html>