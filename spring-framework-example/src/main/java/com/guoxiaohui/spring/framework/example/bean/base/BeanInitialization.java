package com.guoxiaohui.spring.framework.example.bean.base;

import com.guoxiaohui.spring.framework.example.domain.User;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Bean 初始化方法 示例
 * <p>
 * 方法一：{@link javax.annotation.PostConstruct}
 * 方法二：{@link org.springframework.beans.factory.InitializingBean}
 * 方法三：{@link org.springframework.beans.factory.config.BeanDefinition#setInitMethodName(String)}
 * 三者同时存在，执行顺序：PostConstruct > InitializingBean > BeanDefinition#setInitMethodName
 *
 * @author guoxiaohui
 */
public class BeanInitialization {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        AbstractBeanDefinition beanDefinition = new GenericBeanDefinition();
        beanDefinition.setBeanClass(User.class);
        beanDefinition.setInitMethodName("initMethod");
        applicationContext.registerBeanDefinition("useBeanDefinitionInitMethodName", beanDefinition);

        applicationContext.refresh();

        System.out.println(applicationContext.getBean(User.class));

        applicationContext.close();

    }

}
