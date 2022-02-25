package com.guoxiaohui.spring.framework.example.servlet;

import org.springframework.core.convert.converter.Converter;
import org.springframework.format.Formatter;
import org.springframework.web.servlet.config.annotation.*;

import java.util.List;

/**
 * 可以配置什么以及怎么配置
 * 通常配置方式
 * {@link org.springframework.web.servlet.config.annotation.WebMvcConfigurer}
 * {@link  org.springframework.web.bind.annotation.InitBinder}
 * 通常配置
 * {@link org.springframework.format.FormatterRegistry#addConverter(Converter)}
 * {@link org.springframework.format.FormatterRegistry#addFormatter(Formatter)}
 * {@link WebDataBinder添加一个Validator}
 * {@link WebMvcConfigurer#addInterceptors(InterceptorRegistry)}
 * {@link WebMvcConfigurer#configureContentNegotiation(ContentNegotiationConfigurer)}
 * {@link WebMvcConfigurer#configureMessageConverters(List)}
 * {@link WebMvcConfigurer#addViewControllers(ViewControllerRegistry)}
 * {@link WebMvcConfigurer#configureViewResolvers(ViewResolverRegistry)}
 * {@link WebMvcConfigurer#addResourceHandlers(ResourceHandlerRegistry)}
 * {@link WebMvcConfigurer#configureDefaultServletHandling(DefaultServletHandlerConfigurer)}
 * {@link WebMvcConfigurer#configurePathMatch(PathMatchConfigurer)}
 * <p>
 * 对于高级模式，可以删除@EnableWebMvc并直接从DelegatingWebMvcConfiguration扩展，而不是实现WebMvcConfigurer
 *
 * @author guoxiaohui
 */
public class MyWebConfig {


}
