package edu.niit.jspdemo;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author WU, Homer
 * @version 1.0
 * @date 2020/3/24
 * @description : 获取Servlet的外部支持
 */
public class ServletInitializer extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(JspDemoApplication.class);
    }
}
