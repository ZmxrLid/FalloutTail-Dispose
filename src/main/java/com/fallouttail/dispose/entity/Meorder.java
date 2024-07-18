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
 * @since 2024-03-28
 */
@Getter
@Setter
  @ApiModel(value = "Meorder对象", description = "")
public class Meorder implements Serializable {

    private static final long serialVersionUID = 1L;

      @ApiModelProperty("留言评价id")
        @TableId(value = "meorder_id", type = IdType.AUTO)
      private Integer meorderId;

      @ApiModelProperty("留言评价用户")
      private String meorderUserId;

      @ApiModelProperty("留言评价内容")
      private String meorderCon;

      @ApiModelProperty("留言评价时间")
      private LocalDateTime meorderDate;

      @ApiModelProperty("留言评价所属留言")
      private Integer meorderMessid;


}
