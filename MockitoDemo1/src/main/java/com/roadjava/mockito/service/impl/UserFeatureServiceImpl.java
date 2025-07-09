package com.roadjava.mockito.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.roadjava.mockito.bean.entity.UserFeatureDo;
import com.roadjava.mockito.mapper.UserFeatureMapper;
import com.roadjava.mockito.service.UserFeatureService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@Slf4j
public class UserFeatureServiceImpl extends ServiceImpl<UserFeatureMapper, UserFeatureDo> implements UserFeatureService {

    @Override
    public List<UserFeatureDo> selectByUSerId(Long userId) {
        if (userId == null){
            return null;
        }
        LambdaQueryWrapper<UserFeatureDo> lqw = Wrappers.<UserFeatureDo>lambdaQuery().eq(UserFeatureDo::getUserId,userId);
        return list(lqw);
    }



}
