package club.sulinxx.spring.cloud.vo;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * Title: InsertPaymentVo
 * @author slc
 */
@Data
public class InsertPaymentVo {
    /***
     *制服流水号
     **/
    @NotEmpty(message = "单号不能为空")
    private String serial;
}
