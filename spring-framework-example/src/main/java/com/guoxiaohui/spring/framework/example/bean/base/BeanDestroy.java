package com.guoxiaohui.spring.framework.example.bean.base;

import com.guoxiaohui.spring.framework.example.domain.User;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Bean 销毁 示例
 * <p>
 * 方法一：{@link javax.annotation.PreDestroy}
 * 方法二：{@link org.springframework.beans.factory.DisposableBean}
 * 方法三：{@link org.springframework.beans.factory.config.BeanDefinition#setDestroyMethodName(String)} (String)}
 * 三者同时存在，执行顺序：PreDestroy > DisposableBean > BeanDefinition#setDestroyMethodName
 *
 * @author guoxiaohui
 */
public class BeanDestroy {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        AbstractBeanDefinition beanDefinition = new GenericBeanDefinition();
        beanDefinition.setBeanClass(User.class);
        beanDefinition.setInitMethodName("initMethod");
        beanDefinition.setDestroyMethodName("destroyMethod");
        applicationContext.registerBeanDefinition("useBeanDefinitionInitMethodName", beanDefinition);

        applicationContext.refresh();

        System.out.println(applicationContext.getBean(User.class));

        applicationContext.close();

    }
}
