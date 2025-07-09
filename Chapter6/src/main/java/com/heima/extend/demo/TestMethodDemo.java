package com.heima.extend.demo;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestMethodDemo {

    @Test
    public void test1(){
        Assert.assertEquals(1,2);

    }
    @Test
    public void test2(){
        Assert.assertEquals(1,1);
    }
    @Test
    public void test3(){
        Assert.assertEquals("aaaa","aaaa");
    }

    @Test
    public void logDemo(){
        Reporter.log("我们的日志");
        throw new RuntimeException("我们的异常");
    }

}
