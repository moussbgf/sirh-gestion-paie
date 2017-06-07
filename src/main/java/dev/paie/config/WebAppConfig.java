package dev.paie.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


@Configuration
@EnableWebMvc
@ComponentScan({"dev.paie.web.controller", "dev.paie.config.aspect"})
@Import({ServicesConfig.class, SecurityConfig.class })
@ImportResource({"classpath:grades.xml", "classpath:entreprises.xml", "classpath:cotisations-imposables.xml", "classpath:cotisations-non-imposables.xml", "classpath:profils-remuneration.xml"})
@EnableJpaRepositories("dev.paie.repository")
@EnableAspectJAutoProxy
public class WebAppConfig {

//	@Autowired
//	InitialiserDonneesService init;
	
	@Bean
	public ViewResolver viewResolver() {
		return new InternalResourceViewResolver("/WEB-INF/views/", ".jsp");
	}
	
//	@PostConstruct
//	public void initialisation() {
//		
//		init.initialiser();
//		
//	}
}
