package club.sulinxx.spring.cloud.controller;

import club.sulinx.spring.cloud.utils.R;
import club.sulinx.spring.cloud.vo.InsertPaymentVo;
import club.sulinxx.spring.cloud.entity.PaymentEntity;
import club.sulinxx.spring.cloud.exception.BaseException;
import club.sulinxx.spring.cloud.service.PaymentService;
import com.netflix.discovery.converters.Auto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * (Payment)表控制层
 *
 * @author slc
 * @since 2020-04-04 20:33:15
 */
@RestController
@RequestMapping(value = "payment", produces = {MediaType.APPLICATION_JSON_VALUE})
@Api(tags = "支付微服务接口管理")
@Slf4j
public class PaymentController {
    /**
     * 服务对象
     */
    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String port;

    @Autowired
    private DiscoveryClient discoveryClient;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/{id}/get")
    @ApiOperation(value = "查询接口", notes = "测试测试")
    public R getById(@PathVariable("id") String id) {
        PaymentEntity entity = this.paymentService.getById(id);

        return R.ok().put("data", entity).put("port",port);
    }

    /***
     * @Param serial:单号
     * @return R
     **/
    @PostMapping("/create")
    @ApiOperation(value = "新增数据", notes = "新增数据")
    public R insert(@Valid @RequestBody InsertPaymentVo data) {
        PaymentEntity entity = new PaymentEntity();
        entity.setSerial(data.getSerial());
        entity.insert();
        return R.ok().put("port",port);
    }

    /***
     * @Param serial:单号
     * @return R
     **/
    @GetMapping("/exceptionWrapperTest")
    @ApiOperation(value = "测试其他异常捕获，并包装", notes = "测试其他异常捕获，并包装")
    public R insert() {
        try {
            System.out.println(3 / 0);
        } catch (ArithmeticException e) {
            throw new BaseException("算数异常", e);
        }
        return R.ok().put("port",port);
    }

    /***
     * @Param serial:单号
     * @return R
     **/
    @GetMapping("/service/discovery")
    @ApiOperation(value = "服务发现", notes = "服务发现")
    public R discovery() {
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info(service);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        instances.stream().forEach(instance->{
            log.info(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getUri()+"\t");
        });
        return R.ok().put("discovery",discoveryClient);
    }



}