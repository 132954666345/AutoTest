package com.roadjava.mockito.bean.vo;


import lombok.Data;

import java.util.List;

@Data
public class UserVo {

    private Long id;

    private String username;

    private String phone;

    private List<String> featureValue;



}
