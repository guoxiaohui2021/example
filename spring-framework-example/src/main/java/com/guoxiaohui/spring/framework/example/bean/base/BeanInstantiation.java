package com.guoxiaohui.spring.framework.example.bean.base;

import com.guoxiaohui.spring.framework.example.domain.User;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

public class BeanInstantiation {

    private static final User SINGLETON_USER = new User("singletonUser");

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        //为useInstanceFactoryMethod提供已创建好的Bean
        applicationContext.register(BeanInstantiation.class);

        //注册一个FactoryBean
        applicationContext.register(UserFactoryBean.class);

        useStaticFactory(applicationContext);

        useInstanceFactoryMethod(applicationContext);

        applicationContext.refresh();

        applicationContext.getBeansOfType(User.class).forEach((k, v) -> System.out.println(k + ":" + v));

        applicationContext.close();
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
