package com.javastroger.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author 老K
 */
@Data
@TableName("basic_words")
public class Words {

    @TableId(type = IdType.AUTO)
    private Long id;

    private String word;

    private Integer wordType;

    private Boolean isDeleted;

    private Integer insertType;

}
