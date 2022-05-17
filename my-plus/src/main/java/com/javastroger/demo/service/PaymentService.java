package com.javastroger.demo.service;

import com.javastroger.demo.entity.Payment;
import com.javastroger.demo.vo.PaymentVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 老K
 */
public interface PaymentService {

    /**
     *
     * @param payId
     * @return
     */
    Payment getPaymentById(Long payId);

    /**
     *
     * @param list
     * @return
     */
    int batchUpdatePayment(@Param("payments")List<Payment> list);

    /**
     *
     * @return
     */
    List<PaymentVO> getPayments();

}
