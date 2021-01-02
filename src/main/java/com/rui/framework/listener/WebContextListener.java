package com.rui.framework.listener;

import javax.servlet.ServletContext;
import org.springframework.web.context.WebApplicationContext;

public class WebContextListener extends org.springframework.web.context.ContextLoaderListener {

    @Override
    public WebApplicationContext initWebApplicationContext(ServletContext servletContext) {
        StringBuilder sb = new StringBuilder();
        sb.append("\r\n======================================================================\r\n");
        sb.append("\r\n         欢迎使用 山西大学商务学院社团管理系统  - Powered By rui\r\n");
        sb.append("\r\n======================================================================\r\n");
        System.out.println(sb.toString());
        return super.initWebApplicationContext(servletContext);
    }
}

