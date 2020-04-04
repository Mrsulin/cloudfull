package club.sulinxx.spring.cloud.dao;

import club.sulinxx.spring.cloud.entity.PaymentEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * (Payment)表数据库访问层
 *
 * @author slc
 * @since 2020-04-04 20:33:15
 */
@Component
@Mapper
public interface PaymentDao extends BaseMapper<PaymentEntity>{



}