package com.roadjava.mockito;

import com.roadjava.mockito.bean.entity.UserDo;
import com.roadjava.mockito.bean.entity.UserFeatureDo;
import com.roadjava.mockito.bean.vo.UserVo;
import com.roadjava.mockito.mapper.UserFeatureMapper;
import com.roadjava.mockito.mapper.UserMapper;
import com.roadjava.mockito.service.UserFeatureService;
import com.roadjava.mockito.service.UserService;
import com.roadjava.mockito.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

/**
 * 实战
 */
@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {
    @InjectMocks
    @Spy
    private UserServiceImpl userService;

    @Mock
    private UserFeatureService userFeatureService;
    @Mock
    private UserMapper  userMapper;

    @Test
    public void testSelectById1(){
        //配置
        Mockito.doReturn(userMapper).when(userService).getBaseMapper();
        UserVo userVo = userService.selectById(1L);
        Assertions.assertNull(userVo);
    }
    @Test
    public void testSelectById2(){
//        Mockito.doReturn(userMapper).when(userService).getBaseMapper();
        UserDo userDo = new UserDo();
        userDo.setId(1L);
        userDo.setUsername("zhangsan");
        userDo.setPhone("123");
        Mockito.doReturn(userDo).when(userService).getById(1L);
        UserVo userVo = userService.selectById(1L);
        Assertions.assertNotNull(userVo);

    }
    @Test
    public void testSelectById3(){
//        Mockito.doReturn(userMapper).when(userService).getBaseMapper();
        UserDo userDo = new UserDo();
        userDo.setId(1L);
        userDo.setUsername("zhangsan");
        userDo.setPhone("123");
        Mockito.doReturn(userDo).when(userService).getById(1L);
        //
        UserFeatureDo userFeatureDo = new UserFeatureDo();
        userFeatureDo.setId(111L);
        userFeatureDo.setFeatureValue("aaaaa");
        userFeatureDo.setUserId(1L);
        List<UserFeatureDo> userFeatureDos = new ArrayList<>();
        userFeatureDos.add(userFeatureDo);
        Mockito.doReturn(userFeatureDos).when(userFeatureService).selectByUSerId(1L);

        //执行测试
        UserVo userVo = userService.selectById(1L);
        Assertions.assertEquals(1,userVo.getFeatureValue().size());


    }
}
