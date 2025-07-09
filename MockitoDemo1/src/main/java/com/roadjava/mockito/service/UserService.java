package com.roadjava.mockito.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.roadjava.mockito.bean.entity.UserDo;
import com.roadjava.mockito.bean.req.UserUpdateReq;
import com.roadjava.mockito.bean.vo.UserVo;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService extends IService<UserDo> {
    UserVo selectById(Long id);

    void add(String username, String phone, List<String> featureList);

    int modifyById(UserUpdateReq userUpdateReq);
}
