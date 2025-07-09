package com.roadjava.mockito.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.roadjava.mockito.bean.entity.UserFeatureDo;

import java.util.List;

public interface UserFeatureService extends IService<UserFeatureDo> {
    List<UserFeatureDo> selectByUSerId(Long userId);
}
