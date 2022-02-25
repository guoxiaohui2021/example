package com.guoxiaohui.spring.framework.example.bean.lifecycle;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;

import java.util.Arrays;

/**
 * 1⃣️
 * BeanDefinition   解析阶段
 * XML  {@link org.springframework.beans.factory.xml.XmlBeanDefinitionReader}
 * Annotation {@link org.springframework.context.annotation.AnnotatedBeanDefinitionReader}
 * <p>
 * Xml :Resource -> BeanDefinition
 * Annotation: Class -> BeanDefinition
 *
 * @author guoxiaohui
 */
public class BeanDefinitionParserExample {

    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        int beanDefinitionCountBefore = beanFactory.getBeanDefinitionCount();
        useAnnotatedBeanDefinitionParser(beanFactory);
        int beanDefinitionCountAfter = beanFactory.getBeanDefinitionCount();
        System.out.println("beanDefinitionCountBefore:" + beanDefinitionCountBefore);
        System.out.println("beanDefinitionCountAfter:" + beanDefinitionCountAfter);
        System.out.println(beanFactory.getBean(BeanDefinitionParserExample.class));
        Arrays.stream(beanFactory.getBeanDefinitionNames()).forEach(System.out::println);
    }

    private static void useAnnotatedBeanDefinitionParser(BeanDefinitionRegistry beanDefinitionRegistry) {
        AnnotatedBeanDefinitionReader annotatedBeanDefinitionReader = new AnnotatedBeanDefinitionReader(beanDefinitionRegistry);
        //注册当前类
        annotatedBeanDefinitionReader.register(BeanDefinitionParserExample.class);
    }

}
