package com.heima.testng;
import org.testng.annotations.*;

public class BasicAnnotation {

    @Test
    public void test() {
        System.out.println("Hello test!");
    }

    /**
     * 方法前执行
     */
    @BeforeMethod
    public void beforMethod() {
        System.out.println("beforMethod");
    }

    /**
     * 方法后执行
     */
    @AfterMethod
    public void afterMethod() {
        System.out.println("afterMethod");
    }

    /**
     * 类运行前执行
     */
    @BeforeClass
    public void beforeClass() {
        System.out.println("beforeClass");
    }
    /**
     * 类运行后执行
     */
    @AfterClass
    public void afterClass() {
        System.out.println("afterClass");
    }

    /**
     * 测试套件之前执行
     */
    @BeforeSuite
    public void beforeSuite() {
        System.out.println("beforeSuite");
    }

    /**
     * 测试套件之后执行
     */
    @AfterSuite
    public void afterSuite() {
        System.out.println("afterSuite");
    }



}
