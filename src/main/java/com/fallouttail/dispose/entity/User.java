package com.fallouttail.dispose.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.time.LocalDateTime;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author 惜喃
 * @since 2024-03-09
 */
@Getter
@Setter
  @ApiModel(value = "User对象", description = "")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

      @ApiModelProperty("用户id")
        @TableId(value = "user_id", type = IdType.AUTO)
      private Integer userId;

      @ApiModelProperty("用户名")
      private String userName;

      @ApiModelProperty("用户年龄")
      private Integer userAge;

      @ApiModelProperty("用户性别1男2女3隐藏")
      private String userSex;

      @ApiModelProperty("用户电话")
      private String userTel;

      @ApiModelProperty("用户密码")
      private String userPassword;

      @ApiModelProperty("用户介绍")
      private String userIntroduce;

      @ApiModelProperty("公告时间")
      private LocalDateTime userDate;

}
