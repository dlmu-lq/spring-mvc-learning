package top.itlq.spring.mvc.learning.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author liqiang
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "top.itlq.spring.mvc.learning")
public class RootConfig implements WebMvcConfigurer {
    /**
     * 静态资源处理
     * @param configurer
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    /**
     *
     * @param registry
     */
    @Override
    public void addFormatters(FormatterRegistry registry) {

    }
}
