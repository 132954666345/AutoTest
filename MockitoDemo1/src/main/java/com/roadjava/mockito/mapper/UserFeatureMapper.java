package com.roadjava.mockito.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.roadjava.mockito.bean.entity.UserFeatureDo;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;

@Mapper
public interface UserFeatureMapper extends BaseMapper<UserFeatureDo> {
}
