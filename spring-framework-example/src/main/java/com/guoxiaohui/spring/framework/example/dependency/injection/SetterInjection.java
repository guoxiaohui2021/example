package com.guoxiaohui.spring.framework.example.dependency.injection;

/**
 * Set注入    不是必须注入，可以为空
 * <p>
 * 原理：由容器在调用无参构造函数或无参数静态工厂方法 实例化bean后！！！ 调用setter方法完成；
 * <p>
 * ApplicationContext支持其管理的bean基于构造函数和基于setter的DI。在通过构造函数方法注入一些依赖项后，它还支持基于setter的DI。
 * 以BeanDefinition的配置依赖项，该依赖项与PropertyEditor实例一起使用，将属性从一种格式转换为另一种格式。
 * <p>
 * Setter注入的一个好处是，setter方法使该类对象可以稍后重新配置或重新注入。
 */
public class SetterInjection {
}
