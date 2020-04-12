package club.sulinxx.spring.cloud.feign;

import club.sulinx.spring.cloud.utils.R;
import club.sulinx.spring.cloud.vo.InsertPaymentVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@FeignClient(value = "cloud-payment-service",fallback = PaymentClientFailback.class)
public interface PaymentClient {

    @GetMapping("/payment//{id}/get")
    public R getById(@PathVariable("id") String id);

    @PostMapping("/payment//create")
    public R insert(@Valid @RequestBody InsertPaymentVo data);

    @GetMapping("/payment//exceptionWrapperTest")
    public R insert();

    @GetMapping("/payment//service/discovery")
    public R discovery();

}
