package com.guoxiaohui.spring.framework.example.dependency.injection;

import com.guoxiaohui.spring.framework.example.dependency.domain.FieldDependencyInjectionUser;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * 字段注入     应该只有注解注入
 * {@link FieldDependencyInjectionUser} 没有有参构造器，没有Setter方法
 * {@link org.springframework.beans.factory.annotation.Autowired}
 * {@link javax.annotation.Resource}
 * {@link @Inject注解需要引入依赖}
 * <p>
 * NOTE： 字段注入会忽略掉静态字段！！！
 *
 * @author guoxiaohui
 */
public class FieldInjection {

    @Bean
    private Integer integer() {
        return 21;
    }


    @Bean
    private String stringId() {
        return "21";
    }

    @Bean
    private String stringName() {
        return "guoxiaohui";
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(FieldInjection.class);
        applicationContext.register(FieldDependencyInjectionUser.class);

        applicationContext.refresh();

        System.out.println(applicationContext.getBeansOfType(FieldDependencyInjectionUser.class));

        applicationContext.close();
    }

}
