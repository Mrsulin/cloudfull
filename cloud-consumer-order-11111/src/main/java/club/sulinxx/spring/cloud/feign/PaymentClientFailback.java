package club.sulinxx.spring.cloud.feign;

import club.sulinx.spring.cloud.utils.R;
import club.sulinx.spring.cloud.vo.InsertPaymentVo;
import org.springframework.stereotype.Component;

import javax.validation.Valid;

/**
 * Title: PaymentClientFailback
 */
@Component
public class PaymentClientFailback implements PaymentClient {

    @Override
    public R getById(String id) {
        return R.error("feign 熔断保护");
    }

    @Override
    public R insert(@Valid InsertPaymentVo data) {
         return R.error("feign 熔断保护");
    }

    @Override
    public R insert() {
        return R.error("feign 熔断保护");
    }

    @Override
    public R discovery() {
        return R.error("feign 熔断保护");
    }
}
