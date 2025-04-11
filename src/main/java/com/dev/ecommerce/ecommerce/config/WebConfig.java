/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.dev.ecommerce.ecommerce.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *
 * @author Gilberto Melo
 */
@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer{
    
    @Value("${ecommerce.rest.origins.allowed}")
    private String allowedOrigins;
    
    @Override
    public void addCorsMappings(CorsRegistry registry) {
       registry.addMapping("/api/**")
            .allowedOrigins(allowedOrigins)
            .allowedMethods("GET"); 
       
    }
}
