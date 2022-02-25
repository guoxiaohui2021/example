package com.guoxiaohui.spring.framework.example.bean.lifecycle;


import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * 3⃣️
 * BeanDefinition的合并阶段  是很多工程中用到的继承配置思想
 * XML可以配置parent，注解是不行的，需要采用其它手段完成该工作
 * {@link org.springframework.beans.factory.config.ConfigurableListableBeanFactory#getMergedBeanDefinition(String)}
 * {@link org.springframework.beans.factory.support.AbstractBeanFactory#getMergedBeanDefinition(java.lang.String)}
 * <p>
 * 合并操作会使得 BeanDefinition 从{@link GenericBeanDefinition} -> {@link RootBeanDefinition}
 * 拿找到父 RootBeanDefinition 复制一个 新的 RootBeanDefinition，然后将新的RootBeanDefinition和当前的 GenericBeanDefinition 进行一次 {@link AbstractBeanDefinition#overrideFrom(BeanDefinition)}
 *
 * @author guoxiaohui
 */
public class BeanDefinitionMergeExample {

    public static void main(String[] args) {

    }
}
