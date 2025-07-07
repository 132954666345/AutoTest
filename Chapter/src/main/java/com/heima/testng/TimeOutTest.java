package com.heima.testng;

import org.testng.annotations.Test;

public class TimeOutTest {

    /**
     * 超时测试
     * @throws InterruptedException
     */

    @Test(timeOut = 3000)//3s
    public void testSuccess() throws InterruptedException {
        Thread.sleep(2000);
    }

    /**
     * 错误
     * @throws InterruptedException
     */

    /*@Test(timeOut = 2000)
    public void testFailed() throws InterruptedException {
        Thread.sleep(3000);
    }*/
}
