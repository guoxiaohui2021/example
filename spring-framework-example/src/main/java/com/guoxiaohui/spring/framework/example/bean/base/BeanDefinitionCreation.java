package com.guoxiaohui.spring.framework.example.bean.base;

import com.guoxiaohui.spring.framework.example.domain.User;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.GenericBeanDefinition;

import java.util.Map;

/**
 * 构建 BeanDefinition 示例
 *
 * @author guoxiaohui
 * @see org.springframework.beans.factory.config.BeanDefinition
 * @see org.springframework.beans.factory.support.BeanNameGenerator Bean名称生成器
 * @see org.springframework.beans.factory.support.DefaultBeanNameGenerator
 * @see org.springframework.context.annotation.AnnotationBeanNameGenerator
 * BeanDefinition 是Spring Framework 中定义Bean的配置元信息接口
 */
public class BeanDefinitionCreation {

    /**
     * @return 通过 {@link BeanDefinitionBuilder} 构建BeanDefinition
     */
    public static BeanDefinition buildBeanDefinition() {
        return BeanDefinitionBuilder.genericBeanDefinition(User.class)
                .addPropertyValue("id", "8")
                .addPropertyValue("name", "guoxiaohui")
                .addPropertyValue("age", "888")
                .getBeanDefinition();
    }

    /**
     * @return 通过 {@link AbstractBeanDefinition} 及其子类
     */
    public static BeanDefinition buildBeanDefinitionByAbstractBeanDefinition() {
        AbstractBeanDefinition abstractBeanDefinition = new GenericBeanDefinition();
        abstractBeanDefinition.setBeanClass(User.class);
        MutablePropertyValues mutablePropertyValues = new MutablePropertyValues();
        mutablePropertyValues.addPropertyValues(Map.of("id", "6", "name", "guoxiaohui", "age", "666"));
        abstractBeanDefinition.setPropertyValues(mutablePropertyValues);
        return abstractBeanDefinition;
    }

}
