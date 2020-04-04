package club.sulinxx.spring.cloud.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * (Payment)实体类
 *
 * @author slc
 * @since 2020-04-04 20:33:13
 */
@Data
@TableName("payment")
public class PaymentEntity extends Model<PaymentEntity> implements Serializable {
    private static final long serialVersionUID = -72794343413478449L;
    /***
     *主键
     **/
    @TableId(type=IdType.UUID)
    private String id;
    /***
     *制服流水号
     **/
    private String serial;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}