package com.dev.ecommerce.ecommerce.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import com.dev.ecommerce.ecommerce.entity.Product;
import com.dev.ecommerce.ecommerce.entity.ProductCategory;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer{
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        RepositoryRestConfigurer.super.configureRepositoryRestConfiguration(config, cors);
        HttpMethod[] theUnsuporHttpMethods = {HttpMethod.PUT, HttpMethod.DELETE, HttpMethod.POST};
        config.getExposureConfiguration()
            .forDomainType(Product.class)
            .withItemExposure((metData, httpMethods) -> 
                                httpMethods.disable(theUnsuporHttpMethods))
            .withCollectionExposure((metData, httpMethods) -> 
                                httpMethods.disable(theUnsuporHttpMethods));
                                
        config.getExposureConfiguration()
            .forDomainType(ProductCategory.class)
            .withItemExposure((metData, httpMethods) -> 
                                httpMethods.disable(theUnsuporHttpMethods))
            .withCollectionExposure((metData, httpMethods) -> 
                                httpMethods.disable(theUnsuporHttpMethods));
    }

}
