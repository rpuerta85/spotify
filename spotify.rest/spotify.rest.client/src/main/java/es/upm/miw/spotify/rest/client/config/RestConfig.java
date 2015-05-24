package es.upm.miw.spotify.rest.client.config;

import javax.annotation.PostConstruct;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@ComponentScan(basePackages = { "es.upm.miw.spotify.rest.*" })
@Configuration
@PropertySource(value="classpath:restClientConfig.properties", ignoreResourceNotFound=false)
public class RestConfig {
	
	@Value("${max.total.connections.default}")
	private String maxTotalConnectionsDefault;
	@Value("${max.connections.per.route.default}")
	private Integer maxConnectionsPerRouteDefault;
	
	@Bean
	public ClientHttpRequestFactory httpRequestFactory() {
		return new HttpComponentsClientHttpRequestFactory(httpClient());
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate(httpRequestFactory());
	}

	@Bean
	public HttpClient httpClient() {

		PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();
		CloseableHttpClient httpClient = HttpClients.custom()
				.setConnectionManager(connectionManager).build();
		connectionManager.setMaxTotal(Integer.valueOf(maxTotalConnectionsDefault));
		connectionManager.setDefaultMaxPerRoute(Integer.valueOf(maxConnectionsPerRouteDefault));
		return httpClient;
	}
	@PostConstruct
	public void init(){
		System.out.println("INI");
		System.out.println("INI2"+maxTotalConnectionsDefault); 
	}

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	
	
}
