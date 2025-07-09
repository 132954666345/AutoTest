package com.heima.testng;

import org.testng.annotations.Test;

public class ExpectedException {

    /**
     * 异常测试
     * 期望异常测试
     *
     */
    //失败异常
    @Test(expectedExceptions = RuntimeException.class)
    public void runTimeExceptionFailed(){
        System.out.println("失败");
    }

    //成功异常
    @Test(expectedExceptions = RuntimeException.class)
    public void runTimeExceptionSuccess(){
        System.out.println("成功");
        throw new RuntimeException();
    }



}
