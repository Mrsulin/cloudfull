package club.sulinxx.spring.cloud.controller;

import club.sulinx.spring.cloud.utils.R;
import club.sulinx.spring.cloud.vo.InsertPaymentVo;
import club.sulinxx.spring.cloud.feign.PaymentClient;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;

/**
 * Title: OrderController
 */
@RestController
@Slf4j
@Api(tags = "消费者订单微服务(默认熔断方法)")
@RequestMapping("default")
public class DefaultController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    PaymentClient paymentClient;

    private static final String BASE_URL="http://cloud-payment-service";

    /***
     * @Param serial:单号
     * @return R
     **/
    @PostMapping(value = "/consumer/payment/create", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "ribbon新增数据", notes = "ribbon新增数据")
    public R insert(@Valid @RequestBody InsertPaymentVo data) {
        System.out.println("调用服务开始");
        return restTemplate.postForObject(BASE_URL+"/payment/create", data,R.class);
    }

        /***
         * @Param serial:单号
         * @return R
         **/
    @PostMapping(value = "/consumer/payment/feign/create", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "feign新增数据", notes = "feign新增数据")
    public R feignInsert(@Valid @RequestBody InsertPaymentVo data) {
        return paymentClient.insert(data);
    }
}
