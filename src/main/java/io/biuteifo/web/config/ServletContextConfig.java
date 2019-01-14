package io.biuteifo.web.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import io.biuteifo.web.ArthasWebConsoleApplication;

/**
 * Servlet服务器配置
 * 
 * @author <a href="mailto:lj@dofun.cc">luojun</a>
 * @date 2019年1月12日
 * @version v2.0.1
 */
@Configuration
@ComponentScan(basePackageClasses = ArthasWebConsoleApplication.class, useDefaultFilters = true)
public class ServletContextConfig extends WebMvcConfigurationSupport {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 增加静态资源所在目录的配置
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		logger.info("ServletContextConfig.addResourceHandler");
		registry.addResourceHandler("/page/**").addResourceLocations("classpath:/page/");
		registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
	}

	/**
	 * 配置首页
	 */
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		logger.info("ServletContextConfig.addViewControllers");
		registry.addViewController("/").setViewName("forward:/page/login.html");
		registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
		super.addViewControllers(registry);
	}

	/**
	 * 配置servlet处理
	 */
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		logger.info("ServletContextConfig.configureDefaultServletHandling");
		configurer.enable();
	}

	/**
	 * 配置拦截器 {@link CommonInterceptor}
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		logger.info("ServletContextConfig.addInterceptors");
		registry.addInterceptor(new CommonInterceptor()).addPathPatterns("/**").excludePathPatterns("/static/**");
	}
}