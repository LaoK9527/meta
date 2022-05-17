package com.javastroger.demo.controller;


import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.conditions.update.LambdaUpdateChainWrapper;
import com.javastroger.demo.entity.Payment;
import com.javastroger.demo.entity.PaymentDTO;
import com.javastroger.demo.mapper.PaymentMapper;
import com.javastroger.demo.service.PaymentService;
import com.javastroger.demo.vo.PaymentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;

/**
 * @author 老K
 */
@org.springframework.web.bind.annotation.RestController
@RequestMapping("/payments")
public class RestController {

    @Autowired
    private PaymentService paymentService;

    @Autowired
    PaymentMapper paymentMapper;

    @GetMapping("/payment/{payId}")
    public Payment getUser(@PathVariable("payId") Long payId) {
        return paymentService.getPaymentById(payId);
    }

    @PostMapping("/list")
    public int batchUpdatePayments(@RequestBody PaymentDTO payment){
        System.out.println("user" + payment.getUser());
        System.out.println("userName" + payment.getUser().getUserName());
        Payment newPayment = new Payment();
        BeanUtil.copyProperties(payment, newPayment);
        return paymentMapper.insert(newPayment);
    }

    @GetMapping("/payment2/{payId}")
    public Payment getPaymentById(@PathVariable("payId") String payId) {
        return paymentMapper.selectById(payId);
    }


    @GetMapping("/listVO")
    public List<PaymentVO> getPayments() {
        return paymentService.getPayments();
    }

    @GetMapping
    public Boolean postPayment() {
          return paymentMapper.update(null, new LambdaUpdateWrapper<Payment>().
                eq(Payment::getPaySerial, "1").set(Payment::getPayStr, 1)) == 1;
    }

}
