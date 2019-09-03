package com.poc.jbpmintegration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/static/**")
				.addResourceLocations("/WEB-INF/view/react_login/build/static/");
		registry.addResourceHandler("/*.js")
				.addResourceLocations("/WEB-INF/view/react_login/build/");
		registry.addResourceHandler("/*.json")
				.addResourceLocations("/WEB-INF/view/react_login/build/");
		registry.addResourceHandler("/*.ico")
				.addResourceLocations("/WEB-INF/view/react_login/build/");
		registry.addResourceHandler("/index.html")
				.addResourceLocations("/WEB-INF/view/react_login/build/index.html");
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
