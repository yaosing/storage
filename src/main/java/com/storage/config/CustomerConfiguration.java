package com.storage.config;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.Filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.data.web.SortHandlerMethodArgumentResolver;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

@Configuration
public class CustomerConfiguration extends WebMvcConfigurerAdapter {

	/**
	 * For supporting UTF8.
	 * 
	 * @return character encoding filter.
	 */
	@Bean
	public Filter characterEncodingFilter() {
		CharacterEncodingFilter filter = new CharacterEncodingFilter();
		filter.setEncoding("UTF-8");
		filter.setForceEncoding(true);
		return filter;
	}

	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	//
	// add custom return value handler
	// add argument resolver
	// configuration customer return value handler order
	//
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	@Autowired
	private RequestMappingHandlerAdapter adapter;

	@PostConstruct
	public void changeReturnValueHandlerOrder() {
		List<HandlerMethodReturnValueHandler> defaultResolvers = new ArrayList<>(adapter.getReturnValueHandlers());
		List<HandlerMethodReturnValueHandler> customResolvers = adapter.getCustomReturnValueHandlers();
		defaultResolvers.removeAll(customResolvers);

		// add ReturnValue Resolver
		List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
		messageConverters.add(new MappingJackson2HttpMessageConverter());
		customResolvers.add(new ResultWrapperHandlerMethodReturnValueHandler(messageConverters));

		defaultResolvers.addAll(0, customResolvers);
		adapter.setReturnValueHandlers(defaultResolvers);

		// add argument resolver

		List<HandlerMethodArgumentResolver> argumentResolvers = new ArrayList<>(adapter.getArgumentResolvers());
		List<HandlerMethodArgumentResolver> argumentResolversSave = new ArrayList<>();

		argumentResolversSave.add(new SortHandlerMethodArgumentResolver());
		argumentResolversSave.add(new PageableHandlerMethodArgumentResolver());
		argumentResolversSave.addAll(argumentResolvers);
		adapter.setArgumentResolvers(argumentResolversSave);
	}
}
