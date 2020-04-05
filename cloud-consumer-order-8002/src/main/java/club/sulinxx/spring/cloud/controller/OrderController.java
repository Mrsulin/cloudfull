package club.sulinxx.spring.cloud.controller;

import club.sulinxx.spring.cloud.utils.R;
import club.sulinxx.spring.cloud.vo.InsertPaymentVo;
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

    private static final String BASE_URL="http://localhost:8001";

    /***
     * @Param serial:单号
     * @return R
     **/
    @PostMapping(value = "/consumer/payment/create", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "新增数据", notes = "新增数据")
    public R insert(@Valid @RequestBody InsertPaymentVo data, HttpServletRequest request) {
        System.out.println("调用服务开始");
        return restTemplate.postForObject(BASE_URL+"/payment/create", data,R.class);
    }
}
