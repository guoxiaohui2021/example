package com.guoxiaohui.spring.framework.example.dependency.lookup;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;

/**
 * @author guoxiaohui
 * <p>
 * Spring Framework 内置的可查找的依赖
 * @see org.springframework.context.support.AbstractApplicationContext#prepareBeanFactory(ConfigurableListableBeanFactory)
 * @see org.springframework.beans.factory.config.SingletonBeanRegistry#registerSingleton(String, Object)
 * {@link org.springframework.core.env.Environment}
 * {@link java.util.Properties} Bean名称:systemProperties    Java系统属性
 * {@link java.util.Map}        Bean名称:systemEnvironment    OS环境变量
 * {@link org.springframework.context.MessageSource} 国际化
 * {@link org.springframework.context.LifecycleProcessor}   Lifecycle Bean 处理器
 * {@link org.springframework.context.event.ApplicationEventMulticaster}    Spring 事件广播器
 * <p>
 * 注解驱动Spring应用上下文内置的可查找的依赖
 * Bean 名称：internal+类名
 * @see org.springframework.context.annotation.AnnotationConfigUtils#registerAnnotationConfigProcessors(BeanDefinitionRegistry) 激活以下内置依赖的地方很多
 * {@link org.springframework.context.annotation.ConfigurationClassPostProcessor}   处理  Spring 配置类  BeanFactory生命周期中处理配置类{@link org.springframework.context.annotation.ConfigurationClass}&{@link org.springframework.context.annotation.Configuration}
 * {@link org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor}    处理 {@link org.springframework.beans.factory.annotation.Autowired} & {@link org.springframework.beans.factory.annotation.Value}
 * {@link org.springframework.context.annotation.CommonAnnotationBeanPostProcessor} (条件激活)  处理JSR250 e.g: {@link javax.annotation.PostConstruct}
 * {@link org.springframework.context.event.EventListenerMethodProcessor}   处理标注 {@link org.springframework.context.event.EventListener} 的Spring事件监听方法
 * {@link org.springframework.context.event.DefaultEventListenerFactory}    {@link org.springframework.context.event.EventListener} 事件监听方法适配为 {@link org.springframework.context.ApplicationListener}   方法适配为对象
 * {@link PersistenceAnnotationBeanPostProcessor}  处理JPA注解场景的类
 */
public class InternalMayLookupSpringFrameworkDependency {
}
