package com.javastroger.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.javastroger.demo.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 老K
 */
@Mapper
public interface PaymentMapper extends BaseMapper<Payment> {


    int batchPayments(@Param("payments")List<Payment> payments);

}
