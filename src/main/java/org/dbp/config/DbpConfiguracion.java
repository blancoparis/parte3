package org.dbp.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan({
	"org.dbp.controlador"
	,"org.dbp.componentes"
})
@PropertySource("classpath:dbp.properties")
@EnableWebMvc
public class DbpConfiguracion extends WebMvcConfigurerAdapter{

	/**
	 * 
	 * Configurar el view resolver: Las paginas se encontraran apartir del directorio,
	 * '/WEB-INF/paginas/'+paginas+'.jsp'
	 * 
	 * @return
	 */
    @Bean
    public InternalResourceViewResolver getInternalResourceViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/paginas/");
        resolver.setSuffix(".jsp");
        return resolver;
    }
    /**
     * Aqui configuramos donde estan los recursos web del proyecto.
     */
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/recursos/**").addResourceLocations("/recursos/");
		registry.addResourceHandler("/template/**").addResourceLocations("/template/");
	}
	
    @Bean    
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        
        messageSource.setBasenames("classpath:locale/mensajes","classpath:locale/bindeo");
        return messageSource;
    }
}
