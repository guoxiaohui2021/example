package com.guoxiaohui.spring.framework.example.mvc;

/**
 * Spring-Web 提供的一些过滤器
 * Form Data:
 * 浏览器只能通过HTTP GET或HTTP POST提交表单数据，但非浏览器客户端也可以使用HTTP PUT、PATCH和DELETE。Servlet API需要ServletRequest.getParameter*()方法来支持HTTP POST的表单字段访问。
 * Spring-web模块提供 FormContentFilter，用于拦截具有应用程序/x-www-form-urlencoded内容类型的HTTP PUT、PATCH和DELETE请求，从请求正文读取表单数据，并包装ServletRequest，以通过ServletRequest.getParameter*()系列方法提供表单数据。
 * <p>
 * Forwarded Headers:
 * 当请求通过代理（如负载均衡器）时，主机、端口和方案可能会发生变化，因此从客户端角度创建指向正确主机、端口和方案的链接是一个挑战。
 * RFC 7239定义了代理可用于提供有关原始请求信息的转发HTTP标头。还有其他非标准标头，包括X-Forwarded-Host、X-Forwarded-Port、X-Forwarded-Proto、X-Forwarded-Ssl和X-Forwarded-Prefix。
 * ForwardedHeaderFilter 是一个Servlet过滤器，用于修改请求，以便
 * a）根据转发头更改主机、端口和方案
 * b）删除这些标头以消除进一步影响。过滤器依赖于包装请求，因此必须先订购其他过滤器，例如RequestContextFilter，这些过滤器应该适用于修改后的请求，而不是原始请求。
 * <p>
 * Shallow ETag
 * ShallowEtagHeaderFilter过滤器通过缓存写入响应的内容并从中计算MD5散列来创建“浅”ETag。
 * 下次客户端发送时，它也会这样做，但它也会将计算值与If-None-Match请求标头进行比较，如果两者相等，则返回304（NOT_MODIFIED）。
 * 此策略节省了网络带宽，但不节省CPU，因为必须为每个请求计算完整的响应。前面描述的控制器级别的其他策略可以避免计算，通过HTTP缓存。
 * <p>
 * CORS
 * Spring MVC通过控制器上的注释为CORS配置提供细粒度支持。然而，当与Spring Security一起使用时，我们建议依赖内置的CorsFilter，该过滤器必须在Spring Security的过滤器链之前。
 *
 * @author guoxiaohui
 */
public class MyFilters {
}
