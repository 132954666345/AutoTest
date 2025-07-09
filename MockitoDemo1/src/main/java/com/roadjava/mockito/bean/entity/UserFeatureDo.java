package com.roadjava.mockito.bean.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.List;

@Data
@TableName("user_feature")
public class UserFeatureDo {

    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 用户id：用户表的主键
     */
    private Long userId;

    /**
     * 用户的特征值
     */
    private String featureValue;


}
