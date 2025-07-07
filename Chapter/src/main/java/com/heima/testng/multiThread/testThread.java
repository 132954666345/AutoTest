package com.heima.testng.multiThread;

import org.testng.annotations.Test;

public class testThread {
    @Test
    public void  test(){
        System.out.printf("new Class:Thread Id : %s%n",Thread.currentThread().getId());

    }
}
