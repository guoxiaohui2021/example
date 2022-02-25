package com.guoxiaohui.spring.framework.example.dependency.resolution;

/**
 * 无论是处理Autowired注解的AutowiredAnnotationBeanPostProcessor还是处理Resource注解的CommonAnnotationBeanPostProcessor
 * 要点：
 * 1.BeanDefinition的合并  {@link org.springframework.beans.factory.support.MergedBeanDefinitionPostProcessor}
 * 2.实例化前后回调         {@link org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor}
 * 3.{@link org.springframework.beans.factory.annotation.InjectionMetadata.InjectedElement}
 * 4.{@link org.springframework.beans.factory.annotation.InjectionMetadata}
 *
 * @author guoxiaohui
 */
public class X {
}
