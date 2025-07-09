package com.roadjava.mockito;

import com.roadjava.mockito.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 *
 * 初始化mock/spy对象的方式有三种，第一种
 *
 *
 */
@ExtendWith(MockitoExtension.class)
public class InitMockOrSpyMethod1Test {

    @Mock
    private UserService mockUserService;
    @Spy
    private UserService spyUserService;

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
