package club.sulinxx.spring.cloud.feign;

import club.sulinx.spring.cloud.utils.R;
import club.sulinx.spring.cloud.vo.InsertPaymentVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@FeignClient(value = "cloud-payment-service")
@RequestMapping("/payment")
public interface PaymentClient {

    @GetMapping("/{id}/get")
    public R getById(@PathVariable("id") String id);

    @PostMapping("/create")
    public R insert(@Valid @RequestBody InsertPaymentVo data);

    @GetMapping("/exceptionWrapperTest")
    public R insert();

    @GetMapping("/service/discovery")
    public R discovery();

}
