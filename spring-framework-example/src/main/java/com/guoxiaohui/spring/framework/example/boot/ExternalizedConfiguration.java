package com.guoxiaohui.spring.framework.example.boot;

/**
 * 外部化配置
 * 可以使用properties文件、YAML文件、环境变量和命令行参数来外部化配置。
 * <p>
 * Spring Boot使用非常特殊的PropertySource顺序，该顺序旨在允许合理覆盖值。属性按以下顺序考虑：(不常用的已忽略，详情请去官方)
 * 1.Command line arguments
 * 2.ServletConfig init parameters
 * 3.ServletContext init parameters
 * 4.JNDI attributes from java:comp/env
 * 5.Java System properties (System.getProperties())
 * 6.OS environment variables.
 * 7.RandomValuePropertySource
 * 8.jar包外的application-{profile}.properties
 * 9.jar包内的application-{profile}.properties
 * 10.外application.properties
 * 11.内application.properties
 * 12.@PropertySource @Configuration 类上的注释。请注意，在刷新应用程序上下文之前，不会将此类属性源添加到环境中。
 * 现在配置某些属性为时已晚，如logging.*和spring.main.*，这些属性在刷新开始前读取。
 * 13.默认属性（通过设置SpringApplication.setDefaultProperties指定）。
 * <p>
 * <p>
 * Application文件的查询也是有顺序的
 * <p>
 * Spring Framework提供了两个方便的类，可用于加载YAML文档。
 * {@link org.springframework.beans.factory.config.YamlPropertiesFactoryBean} 将YAML加载为properties，
 * {@link org.springframework.beans.factory.config.YamlMapFactoryBean} 将YAML加载为Map。
 * {@link org.springframework.boot.env.YamlPropertySourceLoader} 可用于在Spring环境中将YAML公开为PropertySource。可以使用带有占位符语法的@Value注释来访问YAML属性。
 *
 *
 * Spring Profiles提供了一种隔离应用程序配置部分的方法，并使其仅在特定环境中可用。
 * 任何@Component或@Configuration都可以用@Profile标记
 * @author guoxiaohui
 */
public class ExternalizedConfiguration {
}
