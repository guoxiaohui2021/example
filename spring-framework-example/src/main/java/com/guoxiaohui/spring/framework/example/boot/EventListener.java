package com.guoxiaohui.spring.framework.example.boot;

/**
 * 一些事件实际上是在创建ApplicationContext之前触发的，因此无法将这些事件上的侦听器注册为@Bean。
 * 可以使用SpringApplication.addListeners(...)方法或SpringApplicationBuilder.listeners(...)方法注册它们。
 * <p>
 * 如果希望自动注册这些侦听器，可以将META-INF/spring.factories文件添加到项目中，并使用org.springframework.context.ApplicationListener作为key指定全限定名，
 * <p>
 * {@link org.springframework.boot.context.event.ApplicationStartingEvent} 在运行开始时但在任何处理之前发送，但侦听器和初始化器的注册除外
 * <p>
 * {@link org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent} 创建上下文之前发送
 * <p>
 * {@link org.springframework.boot.context.event.ApplicationPreparedEvent} 在刷新开始之前发送
 * <p>
 * {@link org.springframework.boot.context.event.ApplicationStartedEvent} 在上下文刷新后但在调用任何应用程序和命令行运行程序之前发送
 * <p>
 * {@link org.springframework.boot.context.event.ApplicationReadyEvent} 调用任何应用程序和命令行运行程序后都会发送ApplicationReadyEvent。它表示应用程序已准备好处理请求
 * <p>
 * {@link org.springframework.boot.context.event.ApplicationFailedEvent} 启动时出现异常
 * <p>
 * 使用Spring Framework的事件发布机制发送应用程序事件。该机制的一部分确保在子上下文中发布给侦听器的事件也在任何祖先上下文中发布给侦听器。
 * 因此，如果您的应用程序使用SpringApplication实例的层次结构，侦听器可能会收到相同类型应用程序事件的多个实例。
 *
 * @author guoxiaohui
 */
public class EventListener {
}
