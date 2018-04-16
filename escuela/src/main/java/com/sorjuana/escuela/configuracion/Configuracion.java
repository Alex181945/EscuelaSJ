package com.sorjuana.escuela.configuracion;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.sorjuana.escuela.componente.RequestInterceptor;

@Configuration
public class Configuracion extends WebMvcConfigurerAdapter {
	
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new RequestInterceptor());
	}

}
