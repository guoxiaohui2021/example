package com.guoxiaohui.spring.framework.example.bean.lifecycle;

/**
 * 2⃣️
 * BeanDefinitionRegistry BeanDefinition注册阶段
 * {@link org.springframework.beans.factory.support.BeanDefinitionRegistry}
 * <p>
 * <p>
 * private final Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>(256);
 * //以注册顺序存储
 * private volatile List<String> beanDefinitionNames = new ArrayList<>(256);
 *
 * @author guoxiaohui
 */
public class BeanDefinitionRegistryExample {
}
