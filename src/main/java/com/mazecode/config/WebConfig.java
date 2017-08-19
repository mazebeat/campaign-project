package com.mazecode.config;

//@Configuration
//@EnableWebMvc
//@Import(HibernateConfig.class)
//@ComponentScan(basePackages = {"com.mazecode"})
public class WebConfig {
//public class WebConfig extends WebMvcConfigurerAdapter {
//
//	@Bean
//	public InternalResourceViewResolver viewResolver() {
//		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//		resolver.setPrefix("/WEB-INF/views/");
//		resolver.setSuffix(".jsp");
//		return resolver;
//	}
//
//	@Bean
//	public MessageSource messageSource() {
//		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
//		messageSource.setBasename("/WEB-INF/i18/messages");
//		messageSource.setDefaultEncoding("UTF-8");
//		return messageSource;
//	}
//
//	@Bean
//	public LocaleResolver localeResolver() {
//		CookieLocaleResolver resolver = new CookieLocaleResolver();
//		resolver.setDefaultLocale(new Locale("en"));
//		resolver.setCookieName("mazecode-cookie");
//		resolver.setCookieMaxAge(4800);
//		return resolver;
//	}
//
//		@Override
//	public void addInterceptors(InterceptorRegistry registry) {
//		registry.addInterceptor(new BaseInterceptor());
//	}
//
//	@Override
//	public void addResourceHandlers(ResourceHandlerRegistry registry) {
//		registry.addResourceHandler("/app-resources/**").addResourceLocations("/resources/");
//	}
//
//	@Override
//	public Validator getValidator() {
//		LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();
//		validator.setValidationMessageSource(messageSource());
//		return validator;
//	}
//
//	@Override
//	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//		Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
//		builder.indentOutput(true);
//		converters.add(new MappingJackson2HttpMessageConverter(builder.build()));
//	}
}
