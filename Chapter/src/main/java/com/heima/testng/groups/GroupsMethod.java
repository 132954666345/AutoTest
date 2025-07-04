package com.heima.testng.groups;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class GroupsMethod {

    @Test(groups = "server")
    public void test1(){
        System.out.println("server-1");
    }
    @Test(groups = "server")
    public void test2(){
        System.out.println("server-2");
    }
    @Test(groups = "client")
    public void test3(){
        System.out.println("client-3");
    }
    @Test(groups = "client")
    public void test4(){
        System.out.println("client-4");
    }

    @BeforeGroups("server")
    public void beforeGroupsOnServer(){
        System.out.println("beforeGroupsOnServer");
    }
    @AfterGroups("server")
    public void afterGroupsOnServer(){
        System.out.println("afterGroupsOnServer");
    }

    @BeforeGroups("client")
    public void beforeGroupsOnClient(){
        System.out.println("beforeGroupsOnClient");
    }
    @AfterGroups("client")
    public void afterGroupsOnClient(){
        System.out.println("afterGroupsOnClient");
    }


}
