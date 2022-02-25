package com.guoxiaohui.spring.framework.example.servlet;


import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.springframework.web.servlet.mvc.annotation.ResponseStatusExceptionResolver;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;
import org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver;

/**
 * {@link org.springframework.web.servlet.HandlerExceptionResolver}
 * 如果异常发生在请求映射期间或从请求处理程序（如@Controller）抛出，DispatcherServlet将委托给HandlerExceptionResolver链，以解决异常并提供替代处理，这通常是一种错误响应。
 * <p>
 * {@link SimpleMappingExceptionResolver}  异常类名称和错误视图名称之间的映射。用于在浏览器应用程序中渲染错误页面。
 * {@link DefaultHandlerExceptionResolver} 解决Spring MVC引发的异常，并将其映射到HTTP状态代码。
 * {@link ResponseStatusExceptionResolver} 使用@ResponseStatus注释解决异常，并根据注释中的值将其映射到HTTP状态代码。
 * {@link ExceptionHandlerExceptionResolver} @ExceptionHandler方法来解决异常。
 * <p>
 * 解决链通过Order控制顺序
 */
public class MyHandlerExceptionResolver {
}
