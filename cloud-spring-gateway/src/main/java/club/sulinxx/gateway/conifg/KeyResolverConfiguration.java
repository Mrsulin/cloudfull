package club.sulinxx.gateway.conifg;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;

/**
 * Title: KeyResolverConfiguration
 */
@Configuration
public class KeyResolverConfiguration {

//    @Bean
    /***
      基于请求ip 
      * @return: org.springframework.cloud.gateway.filter.ratelimit.KeyResolver * desc  
     **/
    public KeyResolver pathKeyResolver(){
        return exchange -> Mono.just(exchange.getRequest().getPath().toString());
    }
    
    @Bean
    /***
      基于请求参数的限流
      * @return: org.springframework.cloud.gateway.filter.ratelimit.KeyResolver * desc  
     **/
    public KeyResolver userKeyResolver(){
        return exchange -> Mono.just(exchange.getRequest().getQueryParams().getFirst("userId"));
    }


    /**
     * 基于请求ip地址的限流
     */
//    @Bean
    public KeyResolver ipKeyResolver() {
        return exchange -> Mono.just(
                exchange.getRequest().getHeaders().getFirst("X-Forwarded-For")
        );
    }
}
