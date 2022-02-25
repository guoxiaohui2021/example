package com.guoxiaohui.spring.framework.example.servlet;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

/**
 * {@link javax.servlet.ServletContainerInitializer} 接口的实现类在Servlet3.0环境中，用于配置容器。
 * <p>
 * Spring中提供上述接口的实现类{@link org.springframework.web.SpringServletContainerInitializer},它反过来会查找实现{@link WebApplicationInitializer}的类，将配置的任务交给他们来完成。
 * <p>
 *
 * @see <a href="https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#web.servlet.spring-mvc.auto-configuration"/>
 * Spring Boot遵循不同的初始化顺序。Spring Boot没有钩入Servlet容器的生命周期，而是使用Spring配置引导自己和嵌入式Servlet容器。在Spring配置中检测到过滤器和Servlet声明，并在Servlet容器中注册。
 * <p>
 * DispatcherServlet委派请求给以下Bean做出合适的响应：
 * {@link org.springframework.web.servlet.HandlerMapping} 将请求映射(映射基于内部实际约定)到处理程序，以及用于处理前和处理后的拦截器列表。
 * ****** 两个主要的HandlerMapping实现是{@link RequestMappingHandlerMapping}（支持@RequestMapping注释方法）
 * ****** {@link SimpleUrlHandlerMapping}（它保持URI路径模式对处理程序的显式注册）。
 * {@link org.springframework.web.servlet.HandlerAdapter} 帮助DispatcherServlet调用映射到请求的处理程序，无论处理程序的实际调用方式如何。例如，调用带注释的控制器需要解析注释。HandlerAdapter的主要目的是保护DispatcherServlet免受此类细节的影响。
 * {@link org.springframework.web.servlet.HandlerExceptionResolver} 映射到错误处理模块或视图模块或其他目标
 * {@link org.springframework.web.servlet.ViewResolver} 解析处理程序返回的字符串为实际视图的逻辑视图名称，以便渲染到响应。
 * {@link org.springframework.web.servlet.LocaleResolver,org.springframework.web.servlet.LocaleContextResolver} 解析国际化内容
 * {@link org.springframework.web.servlet.ThemeResolver} 解决Web应用程序可以使用主题——例如，提供个性化布局。查看主题。
 * {@link org.springframework.web.multipart.MultipartResolver} 在一些Multipart解析库的帮助下解析Multipart请求的抽象（例如，浏览器表单文件上传）。
 * {@link org.springframework.web.servlet.FlashMapManager} 存储并检索“输入”和“输出”FlashMap，这些FlashMap可用于将属性从一个请求传递到另一个请求，通常是通过重定向。
 * <p>
 * <p>
 * 可根据需要定制以上特殊的Bean
 * <p>
 * DispatcherServlet处理流程：
 * 1.请求中放入
 * request.setAttribute(WEB_APPLICATION_CONTEXT_ATTRIBUTE, getWebApplicationContext()); 绑定上下文
 * request.setAttribute(LOCALE_RESOLVER_ATTRIBUTE, this.localeResolver);    解决国际化
 * request.setAttribute(THEME_RESOLVER_ATTRIBUTE, this.themeResolver); 解决Web应用程序可以使用的主题
 * request.setAttribute(THEME_SOURCE_ATTRIBUTE, getThemeSource());  解决Web应用程序可以使用的主题
 * 根据需要放入：
 * request.setAttribute(INPUT_FLASH_MAP_ATTRIBUTE, Collections.unmodifiableMap(inputFlashMap));}
 * request.setAttribute(OUTPUT_FLASH_MAP_ATTRIBUTE, new FlashMap());
 * request.setAttribute(FLASH_MAP_MANAGER_ATTRIBUTE, this.flashMapManager);
 * 2.查询请求类型
 * checkMultipart(javax.servlet.http.HttpServletRequest)
 * 3.搜索合适的处理程序。如果找到处理程序，则运行与处理程序（预处理器、后处理器和控制器）关联的执行链，以准备渲染模型。或者，对于带注释的控制器，可以呈现响应（在HandlerAdapter中），而不是返回视图。
 * 4.WebApplicationContext中声明的HandlerExceptionResolverbean用于解析请求处理期间抛出的异常。异常解析器允许自定义逻辑以解决异常。
 */
public class MyWebApplicationInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        DispatcherServlet dispatcherServlet = new DispatcherServlet(context);
        ServletRegistration.Dynamic servlet = servletContext.addServlet("app", dispatcherServlet);
        servlet.setLoadOnStartup(1);
        servlet.addMapping("/app/*");

        //WebApplicationContext有一个指向ServletContext及其关联的Servlet的链接。因此应用程序如果需要访问WebApplicationContext，可以使用RequestContextUtils上的静态方法来查找WebApplicationContext。
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        RequestContextUtils.findWebApplicationContext(servletRequestAttributes.getRequest());


    }


}
