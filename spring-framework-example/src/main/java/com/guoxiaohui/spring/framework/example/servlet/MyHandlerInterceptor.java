package com.guoxiaohui.spring.framework.example.servlet;

/**
 * 所有HandlerMapping实现都支持处理程序拦截器
 * 当您想将特定功能应用于某些请求时，这些拦截器非常有用——例如，检查主体。
 * <p>
 * 匹配到的HandlerInterceptor会添加到HandlerExecutionChain
 * <p>
 * {@link org.springframework.web.servlet.HandlerInterceptor}
 * preHandle(..)方法返回布尔值。此方法可中断或继续执行链的处理。
 * 当此方法返回true时，处理程序执行链将继续。
 * 当它返回false时，DispatcherServlet假设拦截器本身已经处理了请求（例如，呈现了适当的视图），并且不继续执行执行链中的其他拦截器和实际处理程序。
 * <p>
 * 请注意，postHandle对@ResponseBody和ResponseEntity方法用处较小
 * 这些方法在HandlerAdapter中和postHandle之前编写和提交响应。
 * 这意味着对响应进行任何更改为时已晚，
 * 对于此类场景，可以实现ResponseBodyAdvice，并将其声明为控制器建议bean，或直接在RequestMappingHandlerAdapter上配置它。
 *
 * @author guoxiaohui
 */
public class MyHandlerInterceptor {
}
