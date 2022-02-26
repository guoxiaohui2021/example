package com.guoxiaohui.spring.framework.example.mvc;

/**
 * 来自org.springframework.web.multipart软件包的MultipartResolver是一种解析包括文件上传在内的多部分请求的策略。
 * 有一个基于Commons FileUpload的实现，另一个基于Servlet 3.0多部分请求解析。
 *
 * 要启用多部分处理，您需要在DispatcherServlet Spring配置中声明名称为multipartResolver的MultipartResolver bean。
 * DispatcherServlet检测到它，并将其应用于传入的请求。
 * 当收到具有多部分/表单数据内容类型的POST时，解析器将内容将当前HttpServletRequest包装为MultipartHttpServletRequest，
 * 除了将部件公开为请求参数外，还提供对已解析文件的访问。
 * @author guoxiaohui
 */
public class MyMultipartResolver {
}
