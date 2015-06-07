package es.upm.miw.spotify.rest.server.config;

import java.text.SimpleDateFormat;
import java.util.List;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;


@Configuration
@EnableWebMvc
//@Import({SpringModelConfiguration.class/*,SecurityConfig.class*/})
@ComponentScan("es.*")
public class SpringRestConfiguration extends WebMvcConfigurerAdapter {

	private static final String PATTERN_DATE = "dd/MM/yyyy HH:mm";

	@Override
	public void configureMessageConverters(
			List<HttpMessageConverter<?>> converters) {
		converters.add(customConverter());
	}

	@Bean
	public MappingJackson2HttpMessageConverter customConverter() {
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		converter.setObjectMapper(objectMapper());
		return converter;
	}
	 @Bean(name="beanObjectMapper")
	  public ObjectMapper objectMapper() {
	        ObjectMapper objectMapper = new ObjectMapper();
			objectMapper.setDateFormat(new SimpleDateFormat(PATTERN_DATE));
			objectMapper.enable(SerializationFeature. WRITE_ENUMS_USING_TO_STRING);
			objectMapper.enable(DeserializationFeature.READ_ENUMS_USING_TO_STRING);
	        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
			objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
	        return objectMapper;
	  }
		@Bean(name = "dataSource")
		public DriverManagerDataSource dataSource() {
		    DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		    driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
		    driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/test");
		    driverManagerDataSource.setUsername("rootSpotify");
		    driverManagerDataSource.setPassword("rootSpotify");
		    return driverManagerDataSource;
		}
		
}
