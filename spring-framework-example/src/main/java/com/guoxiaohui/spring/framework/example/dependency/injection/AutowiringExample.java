package com.guoxiaohui.spring.framework.example.dependency.injection;

/**
 * 自动绑定的弊端：
 * 1.自动绑定需要遵守规则，如果某个Bean发生变化，很容易影响到自动绑定
 * 2.自动绑定不能绑定一些简单的类型。e.g：String，原生类型，Class
 * 3.手动绑定会覆盖自动绑定
 * 4.自动绑定属于猜测性质的，但是精确才是最重要的
 * no/byName/byType/constructor:特殊的byType
 *
 * @author guoxiaohui
 * @see <a href="https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#beans -factory-autowire">Spring官方对自动绑定的介绍</a>
 */
public class AutowiringExample {
}
