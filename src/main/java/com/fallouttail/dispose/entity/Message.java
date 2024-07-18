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
 * @since 2024-03-10
 */
@Getter
@Setter
  @ApiModel(value = "Message对象", description = "")
public class Message implements Serializable {

    private static final long serialVersionUID = 1L;

      @ApiModelProperty("留言id")
        @TableId(value = "mess_id", type = IdType.AUTO)
      private Integer messId;

      @ApiModelProperty("留言者id")
      private String messUserId;

      @ApiModelProperty("留言内容")
      private String messIntro;

      @ApiModelProperty("留言时间")
      private LocalDateTime messDate;


}
