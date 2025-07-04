package com.heima.testng.groups;

import org.testng.annotations.Test;

@Test(groups = "stu")
public class GroupsOnClass2 {

    public void sut1(){
        System.out.println("GroupsOnClass2中的sut1");
    }

    public void sut2(){
        System.out.println("GroupsOnClass2中的sut2");
    }


}
