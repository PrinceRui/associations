package com.rui.framework.result;

import com.alibaba.fastjson.JSONObject;
import com.rui.framework.annotation.ResponseResult;
import com.rui.framework.result.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResponseResultHandler implements ResponseBodyAdvice {

    /* 日志对象 */
    private final Logger logger = LoggerFactory.getLogger(getClass());

    /* 标记名称 */
    public static final String RESPONSE_RESULT_ANN = "RESPONSE-RESULT-ANN";

    /* 是否请求包含了包装注解标记，没有就直接返回，不需要重写返回体 */
    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request =  sra.getRequest();
        /* 判断请求是否有包装标记 */
        ResponseResult responseResultAnn = (ResponseResult) request.getAttribute(RESPONSE_RESULT_ANN);
        return responseResultAnn == null ? false : true;
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        logger.info("进入返回体重写格式");
        if(o instanceof Result){
            return o;
        }
        logger.info(JSONObject.toJSONString(Result.success(o)));
        return Result.success(o);
    }
}
