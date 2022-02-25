package com.guoxiaohui.spring.framework.example.bean.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Bean实例化阶段
 * 前：{@link org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor#postProcessBeforeInstantiation(Class, String)}
 * 中：
 * 后：
 *
 * @author guoxiaohui
 */
public class BeanInstantiationExample {

    private static class MyInstantiationBeanPostProcessor implements InstantiationAwareBeanPostProcessor {

        /**
         * 在目标 bean 被实例化之前应用这个 BeanPostProcessor。
         * 返回的 bean 对象可能是要使用的代理而不是目标 bean，从而有效地抑制了目标 bean 的默认实例化。
         * 如果这个方法返回了一个非空的对象，那么bean的创建过程就会短路。
         * 唯一应用的进一步处理是来自配置的 BeanPostProcessors 的 postProcessAfterInitialization 回调。
         * 此回调将应用于 bean 定义及其 bean 类，以及工厂方法定义，在这种情况下，返回的 bean 类型将在此处传递。
         * 后处理器可以实现扩展的 SmartInstantiationAwareBeanPostProcessor 接口，以预测它们将在此处返回的 bean 对象的类型。默认实现返回 null。
         */
        @Override
        public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
            return null;
        }
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        applicationContext.refresh();

        applicationContext.close();
    }
}
