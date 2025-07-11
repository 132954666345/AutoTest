package com.roadjava.mockito;


import org.hamcrest.MatcherAssert;
import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.regex.Matcher;

@ExtendWith(MockitoExtension.class)
public class AssertTest {
    @Mock
    private List<String> mockedList;

    @Test
    public  void test1() {
        Mockito.when(mockedList.size()).thenReturn(999);
        //测试hamcrest的断言
        MatcherAssert.assertThat(mockedList.size(), IsEqual.equalTo(999));
        //测试assertJ assertThat：参数为实际的值
        org.assertj.core.api.Assertions.assertThat(mockedList.size()).isEqualTo(999);
        //junit5原生断言
        Assertions.assertEquals(999,mockedList.size());
        //junit4
        Assert.assertEquals(999,mockedList.size());

    }




}
