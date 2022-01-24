package com.guoxiaohui.spring.framework.example.dependency.injection;

/**
 * 手动模式：XML/Java 注解/API（配置元信息）
 * 自动模式：Autowiring  按照内建规则进行注入，ByType/ByName
 * 注入的类型：
 * 1.Setter方法   通过解读配置元信息（e.g：XML中的ref），然后使用反射调用setter方法
 * e.g：public void setUser(User user) {
 * this.user = user;
 * }
 * 2.构造器
 * e.g:public DependencyInjection(User user) {
 * this.user = user;
 * }
 * 3.字段 直接把依赖注入到字段  依赖与Spring框架，不怎么纯粹
 * e.g: @Autowired
 * private User user;
 * 4.方法
 * e.g:@Autowired
 * public void user(User user) {
 * }
 * 5.Aware
 * {@link org.springframework.beans.factory.BeanFactoryAware}
 * <p>
 * 依赖少的情况：构造器注入
 * 多的情况：Setter注入
 * 便利：字段注入
 * 声明：方法注入
 *
 * @author guoxiaohui
 */
public class DependencyInjection {


}
