package com.guoxiaohui.spring.framework.example.dependency.injection;

import com.guoxiaohui.spring.framework.example.annotation.QualifierExpand;
import com.guoxiaohui.spring.framework.example.dependency.domain.DependencyInjectionUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import java.util.Map;

/**
 * 功能：通过名称限定注入的Bean
 * 功能：进行分组（集合类型注入进行细粒度分组）
 * 功能：基于Qualifier扩展限定方式 e.g：@LoadBalanced   通过LoadBalanced实现一个有负载均衡能力的RestTemplate，和一个没有负载均衡能力的RestTemplate
 * <p>
 * 此例子中还暴露了一个问题： Setter方法注入可以覆盖 @Bean 的定义
 *
 * @author guoxiaohui
 * DependencyInjectionUser的Setter注入方法： @Autowired public void setAge(Integer age) {
 * this.age = age;
 * }
 */
public class QualifierInjection {

    @Bean
    private Integer integer() {
        return 18;
    }

    @Bean
    @Primary
    private DependencyInjectionUser dependencyInjectionUser() {
        DependencyInjectionUser dependencyInjectionUser = new DependencyInjectionUser();
        dependencyInjectionUser.setId("23");
        dependencyInjectionUser.setName("guoxiaohui23");
        dependencyInjectionUser.setAge(23);
        return dependencyInjectionUser;
    }

    @Bean
    @Qualifier
    private DependencyInjectionUser qualifierUser() {
        DependencyInjectionUser dependencyInjectionUser = new DependencyInjectionUser();
        dependencyInjectionUser.setId("24");
        dependencyInjectionUser.setName("guoxiaohui24");
        dependencyInjectionUser.setAge(24);
        return dependencyInjectionUser;
    }

    @Bean
    @QualifierExpand
    private DependencyInjectionUser qualifierExpandUser1() {
        DependencyInjectionUser dependencyInjectionUser = new DependencyInjectionUser();
        dependencyInjectionUser.setId("25");
        dependencyInjectionUser.setName("guoxiaohui25");
        dependencyInjectionUser.setAge(25);
        return dependencyInjectionUser;
    }

    @Bean
    @QualifierExpand
    private DependencyInjectionUser qualifierExpandUser2() {
        DependencyInjectionUser dependencyInjectionUser = new DependencyInjectionUser();
        dependencyInjectionUser.setId("26");
        dependencyInjectionUser.setName("guoxiaohui26");
        dependencyInjectionUser.setAge(26);
        return dependencyInjectionUser;
    }


    @Autowired
    private DependencyInjectionUser dependencyInjectionUser;

    /**
     * 通过名称限定注入的Bean
     */
    @Autowired
    @Qualifier("qualifierUser")
    private DependencyInjectionUser qualifierUser;

    /**
     * 这个就是进行分组了,上下文中有两个Bean，当标注该@Qualifier注解的时候，另外一个Bean被过滤掉了。
     */
    @Autowired
    @Qualifier
    private Map<String, DependencyInjectionUser> dependencyInjectionUserMap;

    /**
     * 利用扩展的Qualifier注解进行分组
     */
    @Autowired
    @QualifierExpand
    private Map<String, DependencyInjectionUser> qualifierExpandDependencyInjectionUserMap;

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(QualifierInjection.class);

        applicationContext.refresh();

        System.out.println(applicationContext.getBeansOfType(DependencyInjectionUser.class));
        System.out.println(applicationContext.getBean(QualifierInjection.class).dependencyInjectionUserMap);
        System.out.println(applicationContext.getBean(QualifierInjection.class).qualifierExpandDependencyInjectionUserMap);
        applicationContext.close();

    }

}
