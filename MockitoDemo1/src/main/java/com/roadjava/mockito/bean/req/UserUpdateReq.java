package com.roadjava.mockito.bean.req;


import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
public class UserUpdateReq {
    @NotBlank
    private Long id;
    @NotBlank
    private String phone;



}
