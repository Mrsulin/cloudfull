package club.sulinxx.spring.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Title: OrderMain8002
 */
@SpringBootApplication
@EnableEurekaClient
//激活feign
@EnableFeignClients
//激活hystrix
@EnableCircuitBreaker
//激活hystrix的web监控平台  http://localhost:11111/hystrix
//  http://localhost:11111/actuator/hystrix.stream
@EnableHystrixDashboard
@EnableTurbine
public class OrderMain1111 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain1111.class);
    }
}
