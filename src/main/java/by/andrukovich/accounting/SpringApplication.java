package by.andrukovich.accounting;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//@SpringBootApplication(exclude =  {DataSourceAutoConfiguration.class })
//@EntityScan("by.andrukovich.accounting.entity")
//@EnableJpaRepositories("by.andrukovich.accounting.repository")
public class SpringApplication {

    public static void main(String[] args) {
//        org.springframework.boot.SpringApplication.run(SpringApplication.class, args);
        System.out.println();
    }
}
