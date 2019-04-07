package fmdatabase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "fmdatabase.repository")
@EntityScan("fm.entity.*")
public class FmdatabaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(FmdatabaseApplication.class, args);
    }

}
