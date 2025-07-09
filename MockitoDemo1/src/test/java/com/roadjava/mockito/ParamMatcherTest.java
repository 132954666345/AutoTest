package com.roadjava.mockito;


import com.roadjava.mockito.bean.req.UserUpdateReq;
import com.roadjava.mockito.bean.vo.UserVo;
import com.roadjava.mockito.controller.UserController;
import com.roadjava.mockito.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.anyString;

/**
 * 参数匹配：通过方法签名（参数）来指定哪些方法调用需要被处理(插桩、verify验证)
 */

@ExtendWith(MockitoExtension.class)
public class ParamMatcherTest {
    @Mock
    private UserService mockedUserService;

    @Test
    public void test1(){
        UserVo userVo = mockedUserService.selectById(1L);
        //null
        System.out.println("userVo = " + userVo);
        UserUpdateReq userUpdateReq = new UserUpdateReq();
        int i = mockedUserService.modifyById(userUpdateReq);
        System.out.println("i = " + i);
    }
    /**
     *拦截指定参数
     */
    @Test
    public void test2() {
        UserUpdateReq userUpdateReq1 = new UserUpdateReq();
        userUpdateReq1.setId(1L);
        userUpdateReq1.setPhone("1");

        //当参数为1L和”1“时返回99
        Mockito.doReturn(99).when(mockedUserService).modifyById(userUpdateReq1);

        int result1 = mockedUserService.modifyById(userUpdateReq1);
        System.out.println("result1 = " + result1);

        UserUpdateReq userUpdateReq2 = new UserUpdateReq();
        userUpdateReq2.setId(2L);
        userUpdateReq2.setPhone("2");
        int result2 = mockedUserService.modifyById(userUpdateReq2);
        System.out.println("result2 = " + result2);

    }
    /**
     * 拦截UserUpdateReq的任意对象
     * ArgumentMatchers.any(UserUpdateReq.class)--拦截UserUpdateReq类型的任意对象
     * 除了any，还有anyXxx（anyLong、anyString） 注意都不包括null
     */
    @Test
    public  void test3(){
        Mockito.doReturn(99).when(mockedUserService).modifyById(ArgumentMatchers.any(UserUpdateReq.class));
        UserUpdateReq  userUpdateReq1 = new UserUpdateReq();
        userUpdateReq1.setId(1L);
        userUpdateReq1.setPhone("1");
        int result1 = mockedUserService.modifyById(userUpdateReq1);
        System.out.println("result1 = " + result1);
        UserUpdateReq userUpdateReq2 = new UserUpdateReq();
        userUpdateReq2.setId(2L);
        userUpdateReq2.setPhone("2");
        int result2 = mockedUserService.modifyById(userUpdateReq2);
        System.out.println("result2 = " + result2);
    }
    @Test
    public void  test4(){

        List<String> features = new ArrayList<>();
        mockedUserService.add("张三","123",features);
        //校验参数为张三，123，features的add方法被调用1次
        Mockito.verify(mockedUserService,Mockito.times(1)).add("张三", "123", features);
        //参数用any，要用都用
        Mockito.verify(mockedUserService,Mockito.times(1)).add(anyString(),anyString(),anyList());


    }
    
    
    
    
    
    
}
