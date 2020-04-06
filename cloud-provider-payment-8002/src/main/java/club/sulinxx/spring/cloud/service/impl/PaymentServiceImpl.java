package club.sulinxx.spring.cloud.service.impl;

import club.sulinxx.spring.cloud.dao.PaymentDao;
import club.sulinxx.spring.cloud.entity.PaymentEntity;
import club.sulinxx.spring.cloud.service.PaymentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * (Payment)表服务实现类
 *
 * @author slc
 * @since 2020-04-04 20:33:15
 */
@Service("paymentService")
public class PaymentServiceImpl extends ServiceImpl<PaymentDao, PaymentEntity> implements PaymentService {
    @Autowired
    private PaymentDao paymentDao;


}