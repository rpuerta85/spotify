//package es.upm.miw.spotify.models.properties.beans;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.MessageSource;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.context.annotation.PropertySources;
//import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
//import org.springframework.context.support.ResourceBundleMessageSource;
//import org.springframework.core.env.Environment;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//
///*Con estas notaciones estamos cargando los ficheros properties situados 
//en /spotify.springmvc/src/main/resources/es.  las properidades se cargan en la clase
//de Spring "Enviroment, por eso ponemos Autowired, ya que spring se encargara de rellenar sus
//atrubtuos con las propeidades que hemos definido en estos ficheros. Para acceder a una propiedad
//de fichero basta con poner env.getProperty("mi.propiedad")" */
//
//@Configuration
//@ComponentScan(basePackages = { "es.*" })
//@PropertySources({
//	@PropertySource(value="classpath:/es/findArtist.properties", ignoreResourceNotFound=false),
//	@PropertySource(value="classpath:/es/home.properties", ignoreResourceNotFound=false)
//})
//public class SpringMvcConfig extends WebMvcConfigurerAdapter {
//	
//	@Autowired
//	private Environment env;
//	
//	@Bean
//	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
//		return new PropertySourcesPlaceholderConfigurer();
//	}
//	
//	/*  @Bean
//	    public MessageSource messageSource() {
//	        ResourceBundleMessageSource result
//	            = new ResourceBundleMessageSource();
//	 
//	        String[] basenames = {
//	            "i18n.views.findArtistView.messages",
//	            "i18n.forms.messages"
//	        };
//	       
//	        result.setBasenames(basenames);
//	 
//	        return result;
//	 
//	    }*/
//	
//}
