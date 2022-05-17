package com.javastroger.demo.entity;

import lombok.Data;

import java.util.Date;

@Data
public class PaymentDTO {
    private Long payId;
    private String paySerial;
    private String payStr;
    private Date registTime;
    private Date endTime;

    private User user;
}
