package com.rui.framework.shiro;

import com.alibaba.fastjson.JSON;
import com.rui.framework.result.Result;
import com.rui.framework.result.ResultCode;
import com.rui.framework.utils.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.stereotype.Service;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 表单验证过滤类
 */
@Service
public class FormAuthenticationFilter extends org.apache.shiro.web.filter.authc.FormAuthenticationFilter {

	/**
	 * 登录认证成功后回调方法
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@Override
	protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request, ServletResponse response) throws Exception {
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		response.getWriter().print(JSON.toJSONString(new Result(ResultCode.SUCCESS,subject.getSession().getId())));
		return false;
	}

	@Override
	protected void issueSuccessRedirect(ServletRequest request, ServletResponse response) throws Exception {
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		response.getWriter().print(JSON.toJSONString(Result.success()));
	}

	@Override
	protected void redirectToLogin(ServletRequest request, ServletResponse response) throws IOException {
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		response.getWriter().print(JSON.toJSONString(Result.failure(ResultCode.USER_NOT_LOGIN)));
	}

	/**
	 * 登录失败调用事件
	 */
	@Override
	protected boolean onLoginFailure(AuthenticationToken token,
			AuthenticationException e, ServletRequest request, ServletResponse response) {
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		try {
			response.getWriter().print(JSON.toJSONString(Result.failure(ResultCode.USER_LOGIN_ERROR)));
		} catch (IOException ioException) {
			ioException.printStackTrace();
		}
        return false;
	}
	
}