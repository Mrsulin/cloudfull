package club.sulinxx.spring.cloud.controller;

import club.sulinx.spring.cloud.utils.R;
import club.sulinx.spring.cloud.vo.InsertPaymentVo;
import club.sulinxx.spring.cloud.feign.PaymentClient;
import com.netflix.discovery.converters.Auto;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * Title: OrderController
 */
@RestController
@Slf4j
@Api(tags = "消费者订单微服务")
public class OrderController {

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
    @ApiOperation(value = "新增数据ribbon", notes = "新增数据ribbon")
//    @HystrixCommand(defaultFallback = "insertFailBack")
    public R insert(@Valid @RequestBody InsertPaymentVo data) {
        System.out.println("调用服务开始");
        return restTemplate.postForObject(BASE_URL+"/payment/create", data,R.class);
    }

    public R insertFailBack(InsertPaymentVo data){
        return R.error("触发保护方法!");
    }
        /***
         * @Param serial:单号
         * @return R
         **/
    @PostMapping(value = "/consumer/payment/feign/create", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "新增数据", notes = "新增数据")
    public R feignInsert(@Valid @RequestBody InsertPaymentVo data) {
        return paymentClient.insert(data);
    }
}
