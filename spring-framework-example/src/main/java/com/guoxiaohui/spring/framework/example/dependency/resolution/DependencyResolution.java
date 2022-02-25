package com.guoxiaohui.spring.framework.example.dependency.resolution;


import com.guoxiaohui.spring.framework.example.dependency.domain.DependencyInjectionUser;
import org.springframework.beans.TypeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.config.DependencyDescriptor;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Set;

/**
 * {@link DependencyDescriptorContext}
 * 依赖处理过程
 * <p>
 * 顶级接口： {@link AutowireCapableBeanFactory}
 * 入口： {@link org.springframework.beans.factory.support.DefaultListableBeanFactory#resolveDependency(DependencyDescriptor, String, Set, TypeConverter)}
 * 依赖描述符号：   {@link  org.springframework.beans.factory.config.DependencyDescriptor}
 * 自动绑定候选对象处理器： {@link org.springframework.beans.factory.support.AutowireCandidateResolver}
 *
 * @author guoxiaohui
 */
public class DependencyResolution {

    @Bean
    private Integer integer() {
        return 18;
    }

    @Bean
    private DependencyInjectionUser dependencyInjectionUser() {
        return new DependencyInjectionUser();
    }

    @Autowired
    //这里 DependencyDescriptor大概是 -》 实时+必须+类型（DependencyInjectionUser.class）依赖查找 + 字段名称（dependencyInjectionUser）
    private DependencyInjectionUser dependencyInjectionUser;

    /**
     * 1.查找与所需类型匹配的 bean 实例:{@link org.springframework.beans.factory.support.DefaultListableBeanFactory#findAutowireCandidates(String, Class, DependencyDescriptor)}
     * 参数： beanName - 即将连接的bean的名称 requiredType - 要查找的实际bean类型（可能是数组组件类型或集合元素类型）descriptor - 要解析的依赖项的描述符
     * 2.如果找到匹配的候选者，进行一次GetBean.此时，如果候选Bean未被实例化，进行createBean
     * <p>
     * <p>
     * 理解：
     * {@link DefaultListableBeanFactory#resolveDependency} 会处理「Optional.class」&「ObjectFactory.class」&「ObjectProvider.class」& 普通的依赖类型等等...
     * 判断依赖是否为集合类型，根据BeanDefinition判断是否为primary，lazy等等一系列的条件评估。具体完成了什么样的功能，应根据使用Spring的经验进行猜想然后验证。
     */
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(DependencyResolution.class);
        applicationContext.refresh();

        applicationContext.close();
    }
}
