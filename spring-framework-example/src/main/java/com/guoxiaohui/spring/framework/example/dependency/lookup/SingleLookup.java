package com.guoxiaohui.spring.framework.example.dependency.lookup;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.ObjectFactoryCreatingFactoryBean;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

/**
 * 单一类型查找
 * <p>
 * 通过 {@link org.springframework.beans.factory.BeanFactory#getBeanProvider(Class)} 延迟查找
 * 返回的是 {@link org.springframework.beans.factory.ObjectProvider}
 * ObjectProvider extends {@link org.springframework.beans.factory.ObjectFactory}
 * <p>
 * 新增的覆盖默认参数的方法尽量不要去使用，因为不懂...假如当前Bean是单例，每次调用覆盖？？？
 *
 * @author guoxiaohui
 */
public class SingleLookup {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        useObjectFactory(applicationContext);
        applicationContext.register(SingleLookup.class);

        applicationContext.refresh();

        ObjectFactory<SingleLookup> objectFactory = applicationContext.getBean(ObjectFactory.class);
        System.out.println(objectFactory.getObject());

        System.out.println(applicationContext.getBeanProvider(SingleLookup.class));
        System.out.println(applicationContext.getBeanProvider(SingleLookup.class).getObject());

        applicationContext.close();
    }

    private static void useObjectFactory(BeanDefinitionRegistry beanDefinitionRegistry) {
        AbstractBeanDefinition beanDefinition = new GenericBeanDefinition();
        beanDefinition.setBeanClass(ObjectFactoryCreatingFactoryBean.class);
        MutablePropertyValues mutablePropertyValues = new MutablePropertyValues();
        mutablePropertyValues.addPropertyValues(Map.of("targetBeanName", "singleLookup"));
        beanDefinition.setPropertyValues(mutablePropertyValues);
        beanDefinitionRegistry.registerBeanDefinition("objectFactory", beanDefinition);
    }


}
