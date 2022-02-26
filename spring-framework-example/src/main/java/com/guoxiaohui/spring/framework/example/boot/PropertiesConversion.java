package com.guoxiaohui.spring.framework.example.boot;

/**
 * 自定义类型转换，可以提供ConversionService bean（带有名为conversionService的bean）
 * 自定义属性编辑器（通过CustomEditorConfigurer bean）
 * 自定义转换器（bean定义注释为@ConfigurationPropertiesBinding）。
 *
 * 由于此bean是在应用程序生命周期的早期请求的，请确保限制ConversionService正在使用的依赖项。
 * 通常，需要的任何依赖项可能不会在创建时完全初始化
 * @author guoxiaohui
 */
public class PropertiesConversion {
}
