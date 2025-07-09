package com.roadjava.mockito.controller;

import com.roadjava.mockito.bean.req.UserAddReq;
import com.roadjava.mockito.bean.vo.UserVo;
import com.roadjava.mockito.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;

@Slf4j
@RestController
@Validated
public class UserController {
    @Resource
    private UserService userService;

    @GetMapping("/selectById")
    public UserVo selectById(@NotNull Long userId) {
        return userService.selectById(userId);
    }

    @PostMapping("/add")
    public String add(@RequestBody @Validated UserAddReq addReq ) {
        userService.add(addReq.getUsername(), addReq.getPhone(), addReq.getFeatures());
        return "ok";

    }
}
