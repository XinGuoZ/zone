<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="/struts-tags"  prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title></title>  
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    <script src="./js/jquery.js"></script>
    <script src="./js/pintuer.js"></script>  
</head>
<body>
<form method="post" action="">
  <div class="panel admin-panel">
    <div class="panel-head"><strong class="icon-reorder"> 留言管理</strong></div>
    <div class="padding border-bottom">
      <ul class="search">
        <li>
          <button type="button"  class="button border-green" id="checkall"><span class="icon-check"></span> 全选</button>
          <button type="submit" class="button border-red"><span class="icon-trash-o"></span> 批量删除</button>
        </li>
      </ul>
    </div>
    <table class="table table-hover text-center">
      <tr>
        <th width="120">userID</th>
        <th>头像</th>
        <th>用户名</th>       
        <th>密码</th>
        <th>用户生日</th>
        <th>邮箱</th>
        <th>加入时间</th>
         <th>状态</th>
        <th>操作</th>       
      </tr>
      <s:iterator value="puser.list" var="user">      
        <tr>
          <td><input type="checkbox" name="id[]" value="1" />
            <s:property value="#user.userid"/></td>
          <td><img alt="" src="<s:property value="#user.imgpath"/>" height="50" width="50"></td>
          <td><s:property value="#user.username"/></td>
          <td><s:property value="#user.userpass"/></td>  
           <td><s:property value="#user.userboth"/></td>         
          <td><s:property value="#user.email"/></td>
          <td><s:property value="#user.joinin"/></td>
          <td><s:property value="#user.ustate"/></td>
          <td>
          	<div class="button-group">
          		<c:if test="${admin.state==0 }">
          			<a class="button border-red" href="manageruser_delete?userid=<s:property value="#user.userid"/>" onclick="return del(1)"><span class="icon-trash-o"></span> 删除</a> 
          		</c:if>
          		<a class="button border-blue" href="manageruser_findByuid?userid=<s:property value="#user.userid"/>" ><span class="icon-trash-o"></span>编辑</a>
          	</div>
          </td>
        </tr>
        </s:iterator>
      <tr>
        <td colspan="8">
        	<div class="pagelist">
        		<a href="manageruser_findalluser.action?page=1">首页</a> 
        		<c:if test="${puser.page-1>0}">
        			<a href="manageruser_findalluser.action?page=${puser.page-1 }">上一页</a> 
        		</c:if>
        		<c:if test="${puser.page-2>0}">
        	
        		<a href="manageruser_findalluser.action?page=${puser.page-2 }">${puser.page-2 }</a> 
        		</c:if>
        		<c:if test="${puser.page-1>0}">
        		<a href="manageruser_findalluser.action?page=${puser.page-1 }">${puser.page-1 }</a> 
        		</c:if>
        		
        		<span class="current">${puser.page}</span>
        		
        		<c:if test="${puser.page+1<puser.totalpage}">
        		<a href="manageruser_findalluser.action?page=${puser.page+1 }">${puser.page+1 }</a> 
        		</c:if>
        		<c:if test="${puser.page+2<puser.totalpage}">
        		<a href="manageruser_findalluser.action?page=${puser.page+2 }">${puser.page+2 }</a> 
        		</c:if>
        		<c:if test="${puser.page<puser.totalpage }">
        		<a href="manageruser_findalluser.action?page=${puser.page+1 }">下一页</a>
        		
        		</c:if>
        		<a href="manageruser_findalluser.action?page=${puser.totalpage }">尾页</a>
        	 </div>
        </td>
      </tr>
    </table>
  </div>
</form>
<script type="text/javascript">

function del(id){
	if(confirm("您确定要删除吗?")){
		return true;
	}
	return false;
}

$("#checkall").click(function(){ 
  $("input[name='id[]']").each(function(){
	  if (this.checked) {
		  this.checked = false;
	  }
	  else {
		  this.checked = true;
	  }
  });
})

function DelSelect(){
	var Checkbox=false;
	 $("input[name='id[]']").each(function(){
	  if (this.checked==true) {		
		Checkbox=true;	
	  }
	});
	if (Checkbox){
		var t=confirm("您确认要删除选中的内容吗？");
		if (t==false) return false; 		
	}
	else{
		alert("请选择您要删除的内容!");
		return false;
	}
}

</script>
</body></html>