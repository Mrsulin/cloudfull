package club.sulinxx.spring.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Title: ServerEurekaStartApplication
 */
@SpringBootApplication
@EnableEurekaServer
public class ServerEurekaStartApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServerEurekaStartApplication.class);
    }
}
