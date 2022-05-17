package com.javastroger.demo.service.serviceimpl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.javastroger.demo.entity.Payment;
import com.javastroger.demo.mapper.PaymentMapper;
import com.javastroger.demo.service.PaymentService;
import com.javastroger.demo.vo.PaymentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 老K
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentMapper paymentMapper;


    @Override
    public Payment getPaymentById(Long payId) {
        return paymentMapper.selectById(payId);
    }

    @Override
    public int batchUpdatePayment(List<Payment> list) {
        return paymentMapper.batchPayments(list);
    }

    @Override
    public List<PaymentVO> getPayments() {
        return paymentMapper.selectList(Wrappers.<Payment>lambdaQuery()
                .between(Payment::getPayId, 26000L, 26300L))
                .stream().map(payment -> new PaymentVO(payment.getPayId(), payment.getPaySerial()))
                .collect(Collectors.toList());
    }
}
