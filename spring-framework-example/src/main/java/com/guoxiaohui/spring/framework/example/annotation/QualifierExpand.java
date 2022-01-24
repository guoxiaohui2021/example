package com.guoxiaohui.spring.framework.example.annotation;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.*;

/**
 * 扩展Qualifier，功能：对DependencyInjectionUser进行分组
 *
 * @author guoxiaohui
 */
@Qualifier
@Inherited
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE, ElementType.ANNOTATION_TYPE})
public @interface QualifierExpand {
}
