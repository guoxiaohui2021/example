package com.guoxiaohui.spring.framework.example.ioc;

import org.springframework.beans.factory.config.BeanDefinition;

/**
 * BeanFactory提供了基本功能
 * ApplicationContext增加了更多企业级的功能。（e.g:国际化，事件，AOP）
 * ApplicationContext是BeanFactory的完整超级集，
 * {@link org.springframework.context.ApplicationContext}   代表Spring IoC容器,并负责实例化、配置和组装bean。
 * 容器通过读取配置元数据来获取实例化、配置和组装
 * ApplicationContext实现还允许使用以下这两种方式注册容器外创建的现有对象
 * 通过 {@link org.springframework.beans.factory.config.SingletonBeanRegistry#registerSingleton(String, Object)}
 * 通过 {@link org.springframework.beans.factory.support.BeanDefinitionRegistry#registerBeanDefinition(String, BeanDefinition)}
 * <p>
 *
 * @author guoxiaohui
 */
public class IOC {
}
