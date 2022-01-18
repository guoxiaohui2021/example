package com.guoxiaohui.spring.framework.example.bean.base;

import com.guoxiaohui.spring.framework.example.domain.User;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.serviceloader.ServiceLoaderFactoryBean;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 实例化 Bean 示例
 * 1.使用静态工厂
 * 2.使用实例工厂
 * 3.使用 FactoryBean
 *
 * @author guoxiaohui
 * @see org.springframework.beans.factory.FactoryBean
 */
public class BeanInstantiation {

    private static final User SINGLETON_USER = new User("singletonUser");

    private static final AtomicInteger atomicInteger = new AtomicInteger(1);

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        //为useInstanceFactoryMethod提供已创建好的Bean
        applicationContext.register(BeanInstantiation.class);

        //方法一：使用 FactoryBean 实例化Bean
        applicationContext.register(UserFactoryBean.class);

        //方法二：使用 静态工厂 实例化Bean
        useStaticFactory(applicationContext);

        //方法三：使用 实例工厂 实例化Bean
        useInstanceFactoryMethod(applicationContext);

        //方法四：使用 ServiceLoaderFactoryBean 实例化Bean
        useServiceLoaderFactoryBean();

        //方法六：使用 BeanDefinitionRegistry#registerBeanDefinition() 实例化Bean
        useBeanDefinitionRegistry(applicationContext);

        applicationContext.refresh();

        //方法五：前提applicationContext.refresh()已被调用  使用 AutowireCapableBeanFactory#createBean() 实例化Bean
        useAutowireCapableBeanFactory(applicationContext);

        applicationContext.getBeansOfType(User.class).forEach((k, v) -> System.out.println(atomicInteger.getAndIncrement() + "-" + k + ":" + v));

        applicationContext.close();
    }

    /**
     * 使用 {@link BeanDefinitionRegistry} #registerBeanDefinition() 实例化Bean
     */
    private static void useBeanDefinitionRegistry(BeanDefinitionRegistry beanDefinitionRegistry) {
        beanDefinitionRegistry.registerBeanDefinition("useBeanDefinitionRegistry", BeanDefinitionCreation.buildBeanDefinition());
    }

    /**
     * 使用 {@link AutowireCapableBeanFactory} #createBean() 实例化Bean
     */
    private static void useAutowireCapableBeanFactory(AnnotationConfigApplicationContext applicationContext) {
        AutowireCapableBeanFactory autowireCapableBeanFactory = applicationContext.getAutowireCapableBeanFactory();
        autowireCapableBeanFactory.createBean(User.class);
    }

    /**
     * 使用 {@link ServiceLoaderFactoryBean} 实例化Bean
     */
    private static void useServiceLoaderFactoryBean() {

    }

    /**
     * 使用静态工厂实例化Bean
     */
    private static void useStaticFactory(BeanDefinitionRegistry beanDefinitionRegistry) {
        AbstractBeanDefinition abstractBeanDefinition = new GenericBeanDefinition();
        abstractBeanDefinition.setBeanClass(BeanInstantiation.class);
        abstractBeanDefinition.setFactoryMethodName("staticFactoryBuildUser");
        beanDefinitionRegistry.registerBeanDefinition("useStaticFactory", abstractBeanDefinition);
    }

    private static User staticFactoryBuildUser() {
        System.out.println("execute staticFactoryBuildUser method!!!");
        User user = new User();
        user.setName("staticFactoryBuildUser");
        return user;
    }


    /**
     * 使用实例工厂实例化Bean
     */
    private static void useInstanceFactoryMethod(BeanDefinitionRegistry beanDefinitionRegistry) {
        AbstractBeanDefinition abstractBeanDefinition = new GenericBeanDefinition();
        //已创建好的Bean的名称
        abstractBeanDefinition.setFactoryBeanName("beanInstantiation");
        abstractBeanDefinition.setFactoryMethodName("instanceFactoryMethodBuildUser");
        beanDefinitionRegistry.registerBeanDefinition("useInstanceFactoryMethod", abstractBeanDefinition);
    }

    private User instanceFactoryMethodBuildUser() {
        System.out.println("execute instanceFactoryMethodBuildUser method!!!");
        User user = new User();
        user.setName("instanceFactoryMethodBuildUser");
        return user;
    }


    /**
     * {@link FactoryBean}:可以让我们自定义Bean的创建过程
     */
    @Component
    public static class UserFactoryBean implements FactoryBean<User> {

        @Override
        public User getObject() {
            //这里就可以控制Bean的创建过程,e.g: Mybatis SqlSessionFactoryBean
            return SINGLETON_USER;
        }

        @Override
        public Class<User> getObjectType() {
            return User.class;
        }

        @Override
        public boolean isSingleton() {
            return true;
        }
    }
}