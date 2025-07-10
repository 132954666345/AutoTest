package com.roadjava.mockito;

import com.roadjava.mockito.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class InjectMockTest {

    @Mock
    private UserService userService;

    @Test
    public void test1(){

    }


}
