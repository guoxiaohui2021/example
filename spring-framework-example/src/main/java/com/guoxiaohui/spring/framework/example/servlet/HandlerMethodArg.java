package com.guoxiaohui.spring.framework.example.servlet;

/**
 * {@link org.springframework.web.context.request.WebRequest,org.springframework.web.context.request.NativeWebRequest}  通用，不依赖Servlet API
 * {@link javax.servlet.ServletRequest,javax.servlet.ServletResponse}
 * {@link javax.servlet.http.HttpSession}   非线程安全
 * {@link javax.servlet.http.PushBuilder}   Servlet4.0,HTTP 2
 * {@link java.security.Principal}  当前经过身份验证的用户——如果已知，可能是特定的主实现类。
 * {@link org.springframework.http.HttpMethod}
 * {@link java.util.Locale}
 * {@link java.util.TimeZone,java.time.ZoneId}
 * {@link java.io.InputStream,java.io.Reader}
 * {@link java.io.OutputStream,java.io.Writer}
 * {@link org.springframework.web.bind.annotation.PathVariable} URL模版变量
 * {@link org.springframework.web.bind.annotation.MatrixVariable} 用于访问URI路径段中的名称值对。路径参数
 * {@link org.springframework.web.bind.annotation.RequestParam}
 * {@link org.springframework.web.bind.annotation.RequestHeader}
 * {@link org.springframework.web.bind.annotation.CookieValue}
 * {@link org.springframework.web.bind.annotation.RequestBody}
 * {@link org.springframework.http.HttpEntity}
 * {@link org.springframework.web.bind.annotation.RequestPart} 要访问多部件/表单数据请求中的部件，请使用HttpMessageConverter转换部件的主体。
 * {@link java.util.Map,org.springframework.ui.Model,org.springframework.ui.ModelMap}
 * {@link org.springframework.web.servlet.mvc.support.RedirectAttributes} 指定在重定向时使用的属性，以及要临时存储的闪存属性，直到重定向后的请求。请参阅重定向属性和Flash属性。
 * {@link org.springframework.web.bind.annotation.ModelAttribute}
 * {@link org.springframework.validation.Errors,org.springframework.validation.BindingResult}
 * {@link org.springframework.web.bind.support.SessionStatus,org.springframework.web.bind.annotation.SessionAttribute}
 * {@link org.springframework.web.util.UriComponentsBuilder}
 * {@link org.springframework.web.bind.annotation.SessionAttribute}
 * {@link org.springframework.web.bind.annotation.RequestAttribute}
 * {@link }
 *
 * @author guoxiaohui
 */
public class HandlerMethodArg {
}
