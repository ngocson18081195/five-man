package fm.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication()
public class FmsecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(FmsecurityApplication.class, args);
    }

}

