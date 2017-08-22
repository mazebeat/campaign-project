package com.mazecode.config;

import com.mazecode.config.interceptor.BaseInterceptor;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.resource.PathResourceResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;

@Configuration
@EnableWebMvc
@Import(HibernateConfig.class)
@ComponentScan(basePackages = "com.mazecode")
public class WebConfig extends WebMvcConfigurerAdapter {
	
	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename("/WEB-INF/i18/messages");
		messageSource.setDefaultEncoding("UTF-8");
		return messageSource;
	}
	
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
//	@Override
//	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
//		configurer.defaultContentType(MediaType.APPLICATION_JSON_UTF8);
//		configurer.parameterName("type")
//				.favorPathExtension(false)
//				.favorParameter(true)
//				.parameterName("mediaType")
//				.ignoreAcceptHeader(true)
//				.useJaf(false)
//				.mediaTypes(new HashMap<String, MediaType>() {{
//					put("html", MediaType.TEXT_HTML);
//					put("json", MediaType.APPLICATION_JSON_UTF8);
//					put("xml", MediaType.APPLICATION_XML);
//					put("js", MediaType.valueOf("text/javascript")); //text/javascript
//					put("css", MediaType.valueOf("text/css"));
//				}});
//	}
	
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

//	@Bean
//	public LocaleResolver localeResolver() {
//		CookieLocaleResolver resolver = new CookieLocaleResolver();
//		resolver.setDefaultLocale(new Locale("en"));
//		resolver.setCookieName("mazecode-cookie");
//		resolver.setCookieMaxAge(4800);
//		return resolver;
//	}
//	
//	@Override
//	public void addInterceptors(InterceptorRegistry registry) {
//		registry.addInterceptor(new BaseInterceptor());
//	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
//		registry.addResourceHandler("/css/**").addResourceLocations("/resources/css");
//		registry.addResourceHandler("/js/**").addResourceLocations("/resources/js");
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
		registry.addResourceHandler("/bower_components/**").addResourceLocations("/bower_components/");
//				.setCachePeriod(3600)
//				.resourceChain(true)
//				.addResolver(new PathResourceResolver());
	}

//	@Override
//	public Validator getValidator() {
//		LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();
//		validator.setValidationMessageSource(messageSource());
//		return validator;
//	}
	
//	@Override
//	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//		Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
//		builder.indentOutput(true);
//		converters.add(new MappingJackson2HttpMessageConverter(builder.build()));
//	}
}
