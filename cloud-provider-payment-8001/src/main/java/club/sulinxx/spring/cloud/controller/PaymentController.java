package club.sulinxx.spring.cloud.controller;

import club.sulinxx.spring.cloud.entity.PaymentEntity;
import club.sulinxx.spring.cloud.exception.BaseException;
import club.sulinxx.spring.cloud.service.PaymentService;
import club.sulinxx.spring.cloud.utils.R;
import club.sulinxx.spring.cloud.vo.InsertPaymentVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * (Payment)表控制层
 *
 * @author slc
 * @since 2020-04-04 20:33:15
 */
@RestController
@RequestMapping(value = "payment", produces = {MediaType.APPLICATION_JSON_VALUE})
@Api(tags = "支付微服务接口管理")
public class PaymentController {
    /**
     * 服务对象
     */
    @Autowired
    private PaymentService paymentService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/{id}/get")
    @ApiOperation(value = "查询接口", notes = "测试测试")
    public R getById(@PathVariable String id) {
        PaymentEntity entity = this.paymentService.getById(id);

        return R.ok().put("data", entity);
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
        return R.ok();
    }
    /***
     * @Param serial:单号
     * @return R
     **/
    @GetMapping("/exceptionWrapperTest")
    @ApiOperation(value = "测试其他异常捕获，并包装", notes = "测试其他异常捕获，并包装")
    public R insert() {
        try {
            System.out.println(3/0);
        } catch (ArithmeticException e) {
            throw new BaseException("算数异常",e);
        }
        return R.ok();
    }

}