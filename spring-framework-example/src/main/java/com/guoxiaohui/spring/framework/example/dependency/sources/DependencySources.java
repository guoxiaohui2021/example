package com.guoxiaohui.spring.framework.example.dependency.sources;

import com.guoxiaohui.spring.framework.example.dependency.lookup.InternalMayLookupSpringFrameworkDependency;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.TypeConverter;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.DependencyDescriptor;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.ResourceLoader;

import java.util.Set;

/**
 * 依赖查询(Lookup)来源：
 * 1.BeanDefinition
 * 2.Spring内建的BeanDefinition {@link InternalMayLookupSpringFrameworkDependency}
 * 3.Spring内建的单例对象 {@link InternalMayLookupSpringFrameworkDependency}   无生命周期
 * 依赖注入来源：
 * 1.来源： {@link org.springframework.beans.factory.config.ConfigurableListableBeanFactory#registerResolvableDependency(Class, Object)}
 * {@link DefaultListableBeanFactory#doResolveDependency(DependencyDescriptor, String, Set, TypeConverter)}
 * {@link DefaultListableBeanFactory#findAutowireCandidates(String, Class, DependencyDescriptor)}
 * {@link DefaultListableBeanFactory#resolvableDependencies} 来源一是为这些依赖注入服务
 * 2.同依赖查找的来源
 */
public class DependencySources {

    /**
     * 注入在{@link InstantiationAwareBeanPostProcessor#postProcessProperties(PropertyValues, Object, String)} 阶段
     */
    private final BeanFactory beanFactory;

    private final ApplicationContext applicationContext;

    private final ApplicationEventPublisher applicationEventPublisher;

    private final ResourceLoader resourceLoader;

    public DependencySources(BeanFactory beanFactory, ApplicationContext applicationContext, ApplicationEventPublisher applicationEventPublisher, ResourceLoader resourceLoader) {
        this.beanFactory = beanFactory;
        this.applicationContext = applicationContext;
        this.applicationEventPublisher = applicationEventPublisher;
        this.resourceLoader = resourceLoader;
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        context.register(DependencySources.class);

        context.refresh();
        DependencySources dependencySources = context.getBean(DependencySources.class);
        System.out.println("beanFactory:" + dependencySources.beanFactory);
        System.out.println("applicationContext:" + dependencySources.applicationContext);
        System.out.println("applicationEventPublisher:" + dependencySources.applicationEventPublisher);
        System.out.println("resourceLoader:" + dependencySources.resourceLoader);

        context.close();

    }
}
