package com.javastroger.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Locale;
import java.util.Optional;

/**
 * @author 老K
 */
@Data
@AllArgsConstructor
public class User {

    private BigDecimal id;
    private String userName;
    private String password;

    public void setUserName(String userName) {
        this.userName = Optional.ofNullable(userName.toLowerCase(Locale.ROOT)).orElse(null);
    }
}
