<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title></title>
<link rel="stylesheet" href="./css/pintuer.css">
<link rel="stylesheet" href="./css/admin.css">
<script src=".//js/jquery.js"></script>
<script src=".//js/pintuer.js"></script>
</head>
<body>
<div class="panel admin-panel">
  <div class="panel-head"><strong><span class="icon-key"></span> 修改会员密码</strong></div>
  <div class="body-content">
    <form  class="form-x" action="<%=path %>/manageruser_update" method="post">
    <input name="userid" hidden="true" value='<s:property value="user.userid"/>'>
      <div class="form-group">
        <div class="label">
          <label for="sitename">管理员帐号：</label>
        </div>
        <div class="field">
          <label style="line-height:33px;">
          <s:property value="user.username"/>
          </label>
        </div>
      </div>      
      
      <div class="form-group">
        <div class="label">
          <label for="sitename">权限</label>
        </div>
        <div class="field">
         <select class="w50 input" name="ustate">
         	<s:if test="user.ustate==1">
				<option value="0">不可用</option>
				<option value="1" selected>可用</option>
			</s:if>
			<s:if test="user.ustate==0">
				<option value="0"selected>不可用</option>
				<option value="1">可用</option>
			</s:if>		
		</select>       
        </div>
      </div>
      
      <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="field">
          <button class="button bg-main icon-check-square-o" type="submit"> 提交</button>   
        </div>
      </div>      
    </form>
  </div>
</div>
</body></html>