package com.zone.interceptor;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import com.zone.user.entity.Admin;

public class PrivilegeInterceptor extends MethodFilterInterceptor {

	@Override
	protected String doIntercept(ActionInvocation actionInvocation) throws Exception {
		// TODO Auto-generated method stub
	
		Admin admin =(Admin) ServletActionContext.getRequest()
				.getSession().getAttribute("admin");//取出域对象的值
		if(admin!=null){
			//登陆成功
			return actionInvocation.invoke();
		}else {
			ActionSupport support=(ActionSupport) actionInvocation.getAction();
			support.addActionError("没有登入没有访问权限");
			
			return ActionSupport.LOGIN;
		}
		
	}

}
