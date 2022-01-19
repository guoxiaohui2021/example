package com.guoxiaohui.spring.framework.example.dependency.lookup;

import org.springframework.beans.factory.ListableBeanFactory;

/**
 * {@link org.springframework.beans.factory.HierarchicalBeanFactory}
 * {@link org.springframework.beans.factory.HierarchicalBeanFactory#containsLocalBean(String)}  当前Bean Factory是否包含某个Bean，不会去查找Parent Bean Factory
 * {@link org.springframework.beans.factory.BeanFactoryUtils#beanOfType(ListableBeanFactory, Class)}
 * {@link org.springframework.beans.factory.BeanFactoryUtils#beansOfTypeIncludingAncestors(ListableBeanFactory, Class)}
 * {@link org.springframework.beans.factory.BeanFactoryUtils#beanNamesForTypeIncludingAncestors(ListableBeanFactory, Class)}
 *
 * @author guoxiaohui
 */
public class HierarchicalLookup {
}
