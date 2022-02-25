package com.guoxiaohui.spring.framework.example.dependency.resolution;

import org.springframework.beans.factory.config.DependencyDescriptor;

/**
 * {@link org.springframework.beans.factory.config.DependencyDescriptor#declaringClass}
 * {@link DependencyDescriptor#methodName}  可为空 方法注入名称
 * {@link DependencyDescriptor#parameterTypes}  可为空 方法参数或者构造器参数类型
 * {@link DependencyDescriptor#parameterIndex}  方法参数索引
 * {@link DependencyDescriptor#fieldName}  字段注入名称
 * {@link DependencyDescriptor#required}  是否必须的
 * {@link DependencyDescriptor#eager}  是否饥饿的    Lazy==false
 * {@link DependencyDescriptor#methodParameter}
 * {@link DependencyDescriptor#field}
 * {@link DependencyDescriptor#fieldAnnotations}
 * <p>
 * DependencyDescriptor解释
 *
 * @author guoxiaohui
 */
public class DependencyDescriptorContext {
}
