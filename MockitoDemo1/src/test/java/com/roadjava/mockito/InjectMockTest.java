package com.roadjava.mockito;

import com.roadjava.mockito.service.UserFeatureService;
import com.roadjava.mockito.service.UserService;
import com.roadjava.mockito.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class InjectMockTest {
    /**
     * 1.被@InjectMocks标注的属性必须是实现类，因为mockito会创建对应的实例对象
     * 默认创建的对象就是未经过mockito创建的普通对象，因此常配合@Spy注解使其变为默认调用真实方法的mock对象
     * 未经过mockito处理的普通对象，因此常配合@Spy注解使其变为默认调用真实方法的mock对象
     * 2.mockito使用spy或者mock对象注入到@InjectMocks对应的实例对象中
     */

    @InjectMocks
    @Spy
    private UserServiceImpl userServiceImpl;
    @Mock
    private UserFeatureService  userFeatureService;



    @Test
    public void test1(){
        int number = userServiceImpl.getNumber();
        Assertions.assertEquals(0,number);
    }


}
