package top.itlq.spring.mvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.validation.Validator;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import top.itlq.spring.mvc.converters.MyConverter;

/**
 * @author liqiang
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "top.itlq.spring.mvc")
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
     * 转换器
     * @param registry
     */
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(myConverter());
        System.out.println(myConverter());
    }

    /**
     *
     * @return
     */
    @Override
    public Validator getValidator(){
        return null;
    }



    @Bean
    public MyConverter myConverter(){
        return new MyConverter();
    }
}
