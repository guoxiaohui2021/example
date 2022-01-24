package com.guoxiaohui.spring.framework.example.dependency.injection;

import com.guoxiaohui.spring.framework.example.dependency.domain.MethodDependencyInjectionUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * 方法注入示例 {@link MethodDependencyInjectionUser} 查看类定义
 * {@link  Autowired} 标注某一方法，不需要标注在Setter方法
 * {@link Bean}注解标注的方法如果有参数，那么也是方法注入的一种
 *
 * @author guoxiaohui
 */
public class MethodInjection {

    @Bean
    private Integer integer() {
        return 22;
    }


    @Bean
    private String stringId() {
        return "22";
    }

    @Bean
    private String stringName() {
        return "guoxiaohui";
    }


    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(MethodInjection.class);
        applicationContext.register(MethodDependencyInjectionUser.class);

        applicationContext.refresh();

        System.out.println(applicationContext.getBeansOfType(MethodDependencyInjectionUser.class));

        applicationContext.close();
    }

}
