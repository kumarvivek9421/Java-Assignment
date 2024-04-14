package net.userregistration.user.payload;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class configs {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
