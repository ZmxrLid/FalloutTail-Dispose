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
 * 
 * </p>
 *
 * @author 惜喃
 * @since 2024-03-10
 */
@Getter
@Setter
  @ApiModel(value = "Place对象", description = "")
public class Place implements Serializable {

    private static final long serialVersionUID = 1L;

      @ApiModelProperty("地址id")
        @TableId(value = "place_id", type = IdType.AUTO)
      private Integer placeId;

      @ApiModelProperty("地址")
      private String placeAdd;

      @ApiModelProperty("地址所属人")
      private Integer placeUserId;


}
