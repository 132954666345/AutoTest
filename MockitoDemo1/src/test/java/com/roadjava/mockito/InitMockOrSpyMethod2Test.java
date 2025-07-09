package com.roadjava.mockito;

import com.roadjava.mockito.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

/**
 *
 * 初始化mock/spy对象的方式有三种，第二种
 *
 *
 */
public class InitMockOrSpyMethod2Test {

    private UserService mockUserService;
    private UserService spyUserService;

    @BeforeEach
    public void init(){
        mockUserService = Mockito.mock(UserService.class);
        spyUserService = Mockito.spy(UserService.class);
    }

    @Test
    public void test(){
        //判断mockUserService是否是mock对象   true
        System.out.println("Mockito.mockingDetails(mockUserService).isMock() = " + Mockito.mockingDetails(mockUserService).isMock());
        //判断mockUserService是否是spy对象   false
        System.out.println("Mockito.mockingDetails(mockUserService).isSpy() = " + Mockito.mockingDetails(mockUserService).isSpy());
        //判断spyUserService是否是mock对象   true
        System.out.println("Mockito.mockingDetails(spyUserService).isMock() = " + Mockito.mockingDetails(spyUserService).isMock());
        //判断spyUserService是否是spy对象   true
        System.out.println("Mockito.mockingDetails(spyUserService).isSpy() = " + Mockito.mockingDetails(spyUserService).isSpy());

    }


}
