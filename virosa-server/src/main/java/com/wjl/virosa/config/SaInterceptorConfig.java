package com.wjl.virosa.config;

import cn.dev33.satoken.interceptor.SaInterceptor;
import com.wjl.virosa.filter.interceptor.RequestInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author <a href="mailto:wlonestar@163.com">wjl</a>
 * @version 0.0.1
 * @time 2023/1/4 22:52
 */
@Configuration
public class SaInterceptorConfig implements WebMvcConfigurer {

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(new SaInterceptor()).addPathPatterns("/**");
    registry.addInterceptor(new RequestInterceptor()).addPathPatterns("/**");
  }

}
