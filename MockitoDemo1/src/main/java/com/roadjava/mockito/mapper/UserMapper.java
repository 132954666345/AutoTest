package com.roadjava.mockito.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.roadjava.mockito.bean.entity.UserDo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<UserDo> {
}
