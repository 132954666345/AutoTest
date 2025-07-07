package com.heima.testng.parameter;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import javax.xml.crypto.Data;
import java.lang.reflect.Method;

public class DataProviderTest {


    /**
     * 批量测试
     * 多线程
     * @param name
     * @param age
     */

    @Test(dataProvider = "data")
    public void testDataProvider(String name, int age){
        System.out.println("name=" +name+ ",age=" +age);
    }

    @DataProvider(name = "data")
    public Object[][] providerData(){
        Object[][] o = new Object[][]{
                {"zhangsan",10},
                {"lisi",20}
        };
        return o;
    }
    @Test(dataProvider = "methodData")
    public void test1(String name, int age){
        System.out.println("test1方法：name=" +name+ ",age=" +age);
    }
    @Test(dataProvider = "methodData")
    public void test2(String name, int age){
        System.out.println("test2方法：name=" +name+ ",age=" +age);
    }
    @DataProvider(name = "methodData")
    public Object[][] methodData(Method method){
        Object[][] res = null;
        if (method.getName().equals("test1")){
            res = new Object[][]{
                    {"zhangsan",20},
                    {"lisi",30},
            };
        }else if (method.getName().equals("test2")){
            res = new Object[][]{
                    {"wangwu",50},
                    {"zhaoliu",60},
            };
        }
        return  res;
    }
    @Test(dataProvider = "reTest")
    public void reTest(int i){
        System.out.println(i);
    }
    @DataProvider(name = "reTest")
    public Object[] reTestData(){
       Object[] o = new Object[100];
        for (int i=0; i<o.length; i++){
            o[i] = i;
        }
        return o;
    }



}
