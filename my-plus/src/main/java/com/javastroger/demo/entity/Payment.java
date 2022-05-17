package com.javastroger.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Locale;
import java.util.Optional;


/**
 * @author 老K
 */
@Data
public class Payment {

    @TableId(type = IdType.AUTO)
    private Long payId;
    private String paySerial;
    private String payStr;
    private Date registTime;
    private Date endTime;

    public void setPaySerial(String paySerial) {
        this.paySerial = Optional.ofNullable(paySerial.toLowerCase(Locale.ROOT)).orElse(null);
    }
}
