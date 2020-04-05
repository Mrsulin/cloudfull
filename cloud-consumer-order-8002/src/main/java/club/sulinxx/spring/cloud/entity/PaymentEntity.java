package club.sulinxx.spring.cloud.entity;

import lombok.Data;

/**
 * (Payment)实体类
 *
 * @author slc
 * @since 2020-04-04 20:33:13
 */
@Data
public class PaymentEntity {
    /***
     *主键
     **/
    private String id;
    /***
     *制服流水号
     **/
    private String serial;


}