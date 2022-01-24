package com.guoxiaohui.spring.framework.example.dependency.injection;

import com.guoxiaohui.spring.framework.example.dependency.domain.DependencyInjectionUser;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 延迟依赖注入
 *
 * @author guoxiaohui
 * @see org.springframework.beans.factory.ObjectFactory
 * @see org.springframework.beans.factory.ObjectProvider    推荐（安全）
 */
public class LazyInjection {

    @Autowired
    private ObjectProvider<DependencyInjectionUser> objectProvider;

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(QualifierInjection.class);
        applicationContext.register(LazyInjection.class);
        applicationContext.refresh();

        LazyInjection lazyInjection = applicationContext.getBean(LazyInjection.class);
        lazyInjection.objectProvider.forEach(System.out::println);

        applicationContext.close();
    }

}
