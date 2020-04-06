package club.sulinxx.spring.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Title: ServerEurekaStartApplication9001
 */
@SpringBootApplication
@EnableEurekaServer
public class ServerEurekaStartApplication9001 {
    public static void main(String[] args) {
        SpringApplication.run(ServerEurekaStartApplication9001.class);
    }
}
