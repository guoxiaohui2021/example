package com.guoxiaohui.spring.framework.example.dependency.injection;

import com.guoxiaohui.spring.framework.example.dependency.domain.DependencyInjectionUser;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Map;

/**
 * 构造器注入    API/XML
 * <p>
 * 构造函数参数的解析匹配：通过 参数的类型进行构造；  有序&不能为空
 * <p>
 * XML  不演示
 * <constructor-arg ref=""/>
 * <constructor-arg type="" value=""/>
 * <constructor-arg index="0" value=""/>
 * <constructor-arg name="" value=""/>  may need @ConstructorProperties({"", ""})
 * <p>
 * Spring团队通常提倡构造函数注入，因为它允许您将应用程序组件实现为不可变对象，并确保所需的依赖项不是空的。
 * 此外，构造函数注入的组件总是以完全初始化的状态返回到客户端（调用）代码。
 * <p>
 * 同时大量构造函数参数是一种糟糕的代码，这意味着该类可能有太多的责任，应该重构，以更好地解决问题的正确分离问题。
 *
 * @author guoxiaohui
 */
public class ConstructorInjection {

    @Bean
    public Integer integer() {
        return 20;
    }

    private static BeanDefinition createBeanDefinition() {
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(DependencyInjectionUser.class);
        builder.addConstructorArgReference("integer");
        return builder.getBeanDefinition();
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(ConstructorInjection.class);
        //API 构造器注入
        applicationContext.registerBeanDefinition("apiConstructorInjection", createBeanDefinition());

        applicationContext.refresh();

        Map<String, DependencyInjectionUser> user = applicationContext.getBeansOfType(DependencyInjectionUser.class);
        System.out.println(user);

        applicationContext.close();
    }
}
