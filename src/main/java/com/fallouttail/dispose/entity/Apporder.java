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
  @ApiModel(value = "Apporder对象", description = "")
public class Apporder implements Serializable {

    private static final long serialVersionUID = 1L;

      @ApiModelProperty("留言评价id")
        @TableId(value = "apporder_id", type = IdType.AUTO)
      private Integer apporderId;

    private String apporderUserId;

    private String apporderCon;

    private LocalDateTime apporderDate;

    private Integer apporderAppid;


}
