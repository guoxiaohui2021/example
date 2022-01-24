package com.guoxiaohui.spring.framework.example.dependency.injection;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * {@link org.springframework.beans.factory.Aware}
 *
 * @author guoxiaohui
 * @see org.springframework.beans.factory.BeanFactoryAware
 * @see org.springframework.beans.factory.BeanNameAware
 * @see org.springframework.context.ApplicationContextAware
 * @see org.springframework.context.ResourceLoaderAware
 * @see org.springframework.context.EnvironmentAware
 * @see org.springframework.beans.factory.BeanClassLoaderAware
 * @see org.springframework.context.MessageSourceAware
 * @see org.springframework.context.ApplicationEventPublisherAware
 * @see org.springframework.context.EmbeddedValueResolverAware  占位符处理，StringValueResolver对象
 */
public class AwareInjection implements BeanFactoryAware {

    private BeanFactory beanFactory;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(AwareInjection.class);

        applicationContext.refresh();

        System.out.println(applicationContext.getBean(AwareInjection.class).beanFactory);

        applicationContext.close();
    }
}
