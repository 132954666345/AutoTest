package com.roadjava.mockito.service.impl;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.roadjava.mockito.bean.entity.UserDo;
import com.roadjava.mockito.bean.entity.UserFeatureDo;
import com.roadjava.mockito.bean.req.UserUpdateReq;
import com.roadjava.mockito.bean.vo.UserVo;
import com.roadjava.mockito.mapper.UserMapper;
import com.roadjava.mockito.service.UserFeatureService;
import com.roadjava.mockito.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, UserDo> implements UserService {

    @Autowired
    private UserService  userService;
    @Autowired
    private UserFeatureService userFeatureService;

    @Override
    public UserVo selectById(Long id) {
        UserDo userDo = userService.getById(id);
        if (userDo == null){
            return null;
        }
        UserVo userVo = new UserVo();
        BeanUtils.copyProperties(userDo,userVo);
        //通过用户id查询出对应的特征值列表
        List<UserFeatureDo> userFeatureDos = userFeatureService.selectByUSerId(userDo.getId());
        if (CollectionUtils.isEmpty(userFeatureDos)){
                return userVo;
        }
        //设置特征值列表
        List<String> featureValues = userFeatureDos.stream().map(UserFeatureDo::getFeatureValue).collect(Collectors.toList());
        userVo.setFeatureValue(featureValues);
        return userVo;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void add(String username, String phone, List<String> features){
        UserDo userDo = new UserDo();
        userDo.setUsername(username);
        userDo.setPhone(phone);
        userService.save(userDo);
        //保存特征
        List<UserFeatureDo>  userFeatureDos = features.stream().map(feature -> {
            UserFeatureDo  userFeatureDo = new UserFeatureDo();
            userFeatureDo.setFeatureValue(feature);
            userFeatureDo.setUserId(userDo.getId());
            return userFeatureDo;
        }).collect(Collectors.toList());
        userFeatureService.saveBatch(userFeatureDos);
    }
    @Override
    public int modifyById(UserUpdateReq userUpdateReq){

      return 0;
    }





}
