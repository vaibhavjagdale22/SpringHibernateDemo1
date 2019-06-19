package com.prj.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.Locale;

/*
* @Configuration : If we don't want xml based(example like: applicationContext.xml) configuration and expect java based container configuration
* then we create a configuration class with annotation @Configuration so spring framework handle it as
* a configuration class.
*
* @ComponentScan: It is used for to find out classes from specified location and handover it to spring framework.
* @Bean:What have @Bean and @Component in common?
The essential thing both annotations help with is adding Spring Bean to the Spring Context. The result is the same, Bean is in context, yet, the how is different.

* @Bean: It works in conjunction with a configuration class (with @Configuration) and thus in the annotation based configuration.

It also is used on the methods inside of such a configuration class. Telling Spring to add whatever the method returns to the Spring Context. It’s done explicitly.

By default, it will use the name of the method as the bean id/name. An alternative, you can specify it in the @Bean annotation.

We explicitly declare the bean.

* @Component is used on our classes, so Spring knows that it should add it. However, it only works, if we enabled a component scan for our application and our class is included.

With a component scan, Spring will scan the entire classpath and will add all @Component annotated classes to the Spring Context (with adjustable Filtering).

We let Spring pick up the bean

The difference
The result for both annotations is the same. The bean is added to the Spring context. However, there are some issues to look out for.

Let’s say we got a module which is shared in multiple apps and it contains a few services. Not all are needed for each app.

If use @Component on those service classes and the component scan in the application, we might end up detecting more beans than necessary. In this case, you either had to adjust the filtering of the component scan or provide the configuration that even the unused beans can run. Otherwise, the application context won’t start.

In this case, it is better to work with @Bean annotation and only instantiate those beans, which are required individually in each app.

So, essentially, use @Bean for adding third-party classes to the context. And @Component if it is just inside your single application.
* */
@Configuration
@ComponentScan(basePackages = "com.prj")
public class ProjectConfiguration {
    @Bean
    public ViewResolver configureViewResolver() {
        InternalResourceViewResolver viewResolve = new InternalResourceViewResolver();
        viewResolve.setPrefix("/WEB-INF/jsp/");
        viewResolve.setSuffix(".jsp");
        return viewResolve;
    }
}
