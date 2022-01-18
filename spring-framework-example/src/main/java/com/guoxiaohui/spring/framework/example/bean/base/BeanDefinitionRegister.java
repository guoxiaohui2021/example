package com.guoxiaohui.spring.framework.example.bean.base;

import com.guoxiaohui.spring.framework.example.domain.User;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.AnnotationConfigRegistry;

/**
 * 注册 BeanDefinition 示例
 *
 * @author guoxiaohui
 * <注解注册配置元信息>
 * @see org.springframework.context.annotation.Bean
 * @see org.springframework.context.annotation.Import
 * @see org.springframework.stereotype.Component
 * <Java API 注册配置元信息>
 * @see org.springframework.beans.factory.support.BeanDefinitionRegistry
 * @see org.springframework.beans.factory.support.BeanDefinitionReaderUtils
 * @see org.springframework.context.annotation.AnnotatedBeanDefinitionReader
 * <p>
 * 相同的BeanName在同一个Bean Factory会覆盖？ 不仅仅是ID不允许
 */
public class BeanDefinitionRegister {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        useConfigurationClass(annotationConfigApplicationContext);
        useBeanDefinitionRegistry(annotationConfigApplicationContext);
        useBeanDefinitionReaderUtils(annotationConfigApplicationContext);
        annotationConfigApplicationContext.refresh();

        System.out.println(annotationConfigApplicationContext.getBeansOfType(User.class));

        annotationConfigApplicationContext.close();
    }

    /**
     * 使用BeanDefinitionReaderUtils注册
     */
    private static void useBeanDefinitionReaderUtils(BeanDefinitionRegistry beanDefinitionRegistry) {
        BeanDefinitionHolder beanDefinitionHolder = new BeanDefinitionHolder(BeanDefinitionCreation.buildBeanDefinition(), "user3");
        BeanDefinitionReaderUtils.registerBeanDefinition(beanDefinitionHolder, beanDefinitionRegistry);
    }

    /**
     * 使用 BeanDefinitionRegistry 注册
     */
    private static void useBeanDefinitionRegistry(BeanDefinitionRegistry beanDefinitionRegistry) {
        beanDefinitionRegistry.registerBeanDefinition("user", BeanDefinitionCreation.buildBeanDefinition());
        beanDefinitionRegistry.registerBeanDefinition("user2", BeanDefinitionCreation.buildBeanDefinitionByAbstractBeanDefinition());
    }

    /**
     * 使用 AnnotatedBeanDefinitionReader 注册
     */
    private static void useConfigurationClass(AnnotationConfigRegistry annotationConfigRegistry) {
        //原理 AnnotatedBeanDefinitionReader
        annotationConfigRegistry.register(User.class);
    }
}
