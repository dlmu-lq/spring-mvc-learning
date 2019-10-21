package top.itlq.spring.mvc.config;

import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.validation.Validator;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import top.itlq.spring.mvc.config.jackson.InstantDeserializer;
import top.itlq.spring.mvc.config.jackson.InstantSerializer;
import top.itlq.spring.mvc.converters.MyConverter;

import java.time.Instant;
import java.util.List;

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
     * Validator
     * @return
     */
    @Override
    public Validator getValidator(){
        return null;
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters){
        converters.add(new MappingJackson2HttpMessageConverter(objectMapper()));
    }

    @Bean
    public MyConverter myConverter(){
        return new MyConverter();
    }

    // region Jackson objectMapper
    @Bean
    public ObjectMapper objectMapper(){
        return new Jackson2ObjectMapperBuilder()
                .createXmlMapper(false)
                .serializers(new InstantSerializer())
                .deserializers(new InstantDeserializer())
                .build();
    }
    //endregion
}
