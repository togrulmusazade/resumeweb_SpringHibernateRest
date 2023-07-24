package com.company.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CustomCorsFilter {

    @Bean
    public WebMvcConfigurer getCorsConfiguration(){
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("http://localhost:8080") //yalniz bu urlye icaze var
                        .allowedOrigins("http://localhost:8079")
                        .allowCredentials(true) //username, passw, token etc. gondermeye icaze verir
                        .allowedMethods("GET", "DELETE", "PUT", "POST")
                        .allowedHeaders("*"); //Butun headerlara icaze var
            }
        };
    }

//    @Bean
//    public FilterRegistrationBean corsFilter() {
//        org.springframework.web.cors.UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        CorsConfiguration config = new CorsConfiguration();
//        config.setAllowCredentials(true);//
//        config.addAllowedOrigin("*");//
//        config.addAllowedHeader("*");
//        config.addAllowedMethod("*");
//        source.registerCorsConfiguration("/**", config);
//        FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
//        bean.setOrder(0);
//        return bean;
//    }
}