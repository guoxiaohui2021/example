package com.guoxiaohui.spring.framework.example.dependency.resolution;

import org.springframework.beans.factory.annotation.InitDestroyAnnotationBeanPostProcessor;

/**
 * Java 通用注解注入
 * {@link org.springframework.context.annotation.CommonAnnotationBeanPostProcessor}
 * 处理
 * {@link EJB}
 * {@link javax.annotation.Resource}
 * {@link WebserviceRef}
 * <p>
 * {@link javax.annotation.PostConstruct}
 * {@link javax.annotation.PreDestroy}
 * <p>
 * CommonAnnotationBeanPostProcessor 和 AutowiredAnnotationBeanPostProcessor 实现差不多，CommonAnnotationBeanPostProcessor包含了一些生命周期的东西
 * <p>
 * {@link javax.annotation.PostConstruct}&{@link javax.annotation.PreDestroy}注解的处理也是通过BeanPostProcess {@link InitDestroyAnnotationBeanPostProcessor}
 *
 * @author guoxiaohui
 */
public class JavaCommonAnnotation {
}
