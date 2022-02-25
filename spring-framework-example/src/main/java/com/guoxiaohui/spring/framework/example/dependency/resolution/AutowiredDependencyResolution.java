package com.guoxiaohui.spring.framework.example.dependency.resolution;

import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;
import org.springframework.beans.factory.config.SmartInstantiationAwareBeanPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.util.ReflectionUtils;

/**
 * {@link org.springframework.beans.factory.annotation.Autowired} 注入原理
 * 1.元信息解析  -> 依赖描述 {@link org.springframework.beans.factory.config.DependencyDescriptor}
 * 2.依赖查找（在这个过程中依赖从 Class -> Object ）
 * 3.依赖注入（反射调用字段，方法等...）
 * <p>
 * 入口 DefaultListableBeanFactory#resolveDependency 方法被 {@link AutowiredAnnotationBeanPostProcessor#postProcessProperties(PropertyValues, Object, String)} 调用
 * <p>
 * {@link AutowiredAnnotationBeanPostProcessor} 是BeanPostProcessor     Bean的后置处理器
 * AutowiredAnnotationBeanPostProcessor 实现了 MergedBeanDefinitionPostProcessor   BeanDefinition的Merge
 * {@link AutowiredAnnotationBeanPostProcessor#buildAutowiringMetadata(java.lang.Class)}方法会执行{@link ReflectionUtils#doWithLocalFields(Class, ReflectionUtils.FieldCallback)}{@link ReflectionUtils#doWithLocalMethods(Class, ReflectionUtils.MethodCallback)} }
 * 同时忽略了static字段和static方法，这个阶段进行元数据的查找
 * <p>
 * {@link AutowiredAnnotationBeanPostProcessor#postProcessMergedBeanDefinition(RootBeanDefinition, Class, String)} 优先与 {@link AutowiredAnnotationBeanPostProcessor#postProcessProperties(PropertyValues, Object, String)}
 * AutowiredAnnotationBeanPostProcessor  继承了{@link InstantiationAwareBeanPostProcessorAdapter} 它又实现了 {@link SmartInstantiationAwareBeanPostProcessor} 它又继承了 {@link InstantiationAwareBeanPostProcessor}
 * 实例化前的回调，和实例化后但在设置显式属性或发生自动装配之前的回调。
 * <p>
 * {@link AutowiredAnnotationBeanPostProcessor#postProcessProperties(PropertyValues, Object, String)} 优先于 Bean Setter方法
 * 这个阶段通过反射字段注入或者方法注入，在注入过程中又有可能触发依赖处理
 * <p>
 * createBean的过程中会触发依赖处理，依赖处理的过程又会触发createBean
 * <p>
 * Inject注解复用了 AutowiredAnnotationBeanPostProcessor 实现,同时AutowiredAnnotationBeanPostProcessor也可以处理 @Value 注解
 * <p>
 * 细节：org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor#findAutowiredAnnotation(java.lang.reflect.AccessibleObject) 找到既退出，
 * 并且autowiredAnnotationTypes = new LinkedHashSet<>(4)  有序的&不重复的
 *
 * @author guoxiaohui
 */
public class AutowiredDependencyResolution {

    public static void main(String[] args) {

    }

}
