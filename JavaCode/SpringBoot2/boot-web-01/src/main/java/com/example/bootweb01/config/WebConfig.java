package com.example.bootweb01.config;

import com.example.bootweb01.converter.MyMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.accept.ParameterContentNegotiationStrategy;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.UrlPathHelper;

import javax.print.attribute.standard.Media;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 小白学java
 * @version 3.0
 */
@Configuration(proxyBeanMethods = false)
public class WebConfig implements WebMvcConfigurer {

//    @Bean
    public HiddenHttpMethodFilter hiddenHttpMethodFilter() {
        HiddenHttpMethodFilter methodFilter = new HiddenHttpMethodFilter();
        methodFilter.setMethodParam("PD");
        return methodFilter;
    }

//    @Bean // WebMveConfigurer

    //设定分号后面的内容不移除
    public WebMvcConfigurer webMvcConfigurer() {
        return new WebMvcConfigurer() {

            @Override
            public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
                //自定义内容协商策略
                Map<String, MediaType> map = new HashMap<String, MediaType>();
                map.put("json", MediaType.APPLICATION_JSON);
                map.put("xml", MediaType.APPLICATION_XML);
                map.put("x", MediaType.parseMediaType("application/x-mine"));
                ParameterContentNegotiationStrategy parameterContentNegotiationStrategy = new ParameterContentNegotiationStrategy(map);
                configurer.strategies(Arrays.asList(parameterContentNegotiationStrategy));
            }

            @Override
            public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
                //添加新的messageConverter
                converters.add(new MyMessageConverter());
            }

            @Override
            public void configurePathMatch(PathMatchConfigurer configurer) {
                //设置分号可读取
                UrlPathHelper urlPathHelper = new UrlPathHelper();
                urlPathHelper.setRemoveSemicolonContent(false);
                configurer.setUrlPathHelper(urlPathHelper);
            }
        };
    }

    @Override
    public void configurePathMatch(PathMatchConfigurer pathMatchConfigurer) {
        UrlPathHelper urlPathHelper = new UrlPathHelper();
        urlPathHelper.setRemoveSemicolonContent(false);
        pathMatchConfigurer.setUrlPathHelper(urlPathHelper);
    }
}
