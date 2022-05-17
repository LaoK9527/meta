package com.javastroger.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.javastroger.demo.entity.Words;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 老K
 */
@Mapper
public interface WordsMapper extends BaseMapper<Words> {
}
