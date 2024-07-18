package com.fallouttail.dispose.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 管理员表
 * </p>
 *
 * @author 惜喃
 * @since 2024-03-09
 */
@Getter
@Setter
  @ApiModel(value = "Admin对象", description = "管理员表")
public class Admin implements Serializable {

    private static final long serialVersionUID = 1L;

      @ApiModelProperty("管理员id")
        @TableId(value = "admin_id", type = IdType.AUTO)
      private Integer adminId;

      @ApiModelProperty("管理员名")
      private String adminName;

      @ApiModelProperty("管理员密码")
      private String adminPassword;


}
