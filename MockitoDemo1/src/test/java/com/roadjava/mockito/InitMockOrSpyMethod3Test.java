package com.roadjava.mockito;

import com.roadjava.mockito.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

/**
 *
 * 初始化mock/spy对象的方式有三种，第三种
 *
 *
 */
public class InitMockOrSpyMethod3Test {

    @Mock
    private UserService mockUserService;
    @Spy
    private UserService spyUserService;

    @BeforeEach
    public void init(){
        MockitoAnnotations.initMocks(this);
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
