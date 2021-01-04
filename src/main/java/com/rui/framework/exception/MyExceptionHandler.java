package com.rui.framework.exception;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;

/**
 * 自定义全局异常处理类，返回json
 */
public class MyExceptionHandler implements HandlerExceptionResolver {

    private static Logger logger = LoggerFactory.getLogger(MyExceptionHandler.class);

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
                                         Exception ex) {
        ModelAndView mv = new ModelAndView();
        /* 使用response返回	*/
        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value()); //设置状态码500
        response.setContentType(MediaType.APPLICATION_JSON_VALUE); //设置ContentType
        response.setCharacterEncoding("UTF-8"); //避免乱码
        response.setHeader("Cache-Control", "no-cache, must-revalidate");
        try {
            response.getWriter().write(ex.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.debug("异常:" + ex.getMessage(), ex);
        return mv;
    }
}