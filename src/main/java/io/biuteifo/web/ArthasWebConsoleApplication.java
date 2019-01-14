package io.biuteifo.web;

import java.util.Arrays;

import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * 启动服务
 * 
 * @author <a href="mailto:632635114@qq.com">luojun</a>
 * @date 2019年1月11日
 * @version 0.0.1
 */
@SpringBootApplication
public class ArthasWebConsoleApplication {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		SpringApplication.run(ArthasWebConsoleApplication.class, args);
		LoggerFactory.getLogger(ArthasWebConsoleApplication.class).info("[Arthas Web Console] start Application success! {}(ms)", (System.currentTimeMillis() - start));
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			for (String beanName : beanNames) {
				LoggerFactory.getLogger(getClass()).debug(beanName);
			}
		};
	}
}
