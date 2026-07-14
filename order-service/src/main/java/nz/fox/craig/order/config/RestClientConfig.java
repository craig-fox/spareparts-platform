package nz.fox.craig.order.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
@EnableConfigurationProperties(CustomerServiceProperties.class)
public class RestClientConfig {
    @Bean
    public RestClient restClient(RestClient.Builder builder, CustomerServiceProperties properties) {
        return builder
                .baseUrl(properties.baseUrl())
                .build();
    }
}
