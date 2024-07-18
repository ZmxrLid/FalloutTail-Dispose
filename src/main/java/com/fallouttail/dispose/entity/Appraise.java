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
  @ApiModel(value = "Appraise对象", description = "")
public class Appraise implements Serializable {

    private static final long serialVersionUID = 1L;

      @ApiModelProperty("评价id")
        @TableId(value = "appraise_id", type = IdType.AUTO)
      private Integer appraiseId;

      @ApiModelProperty("评价内容")
      private String appraiseCon;

      @ApiModelProperty("评价订单id")
      private Integer appraiseOrdersId;

      @ApiModelProperty("评价时间")
      private LocalDateTime appraiseDate;


}
