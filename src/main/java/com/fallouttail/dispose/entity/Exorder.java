package com.fallouttail.dispose.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
 * @since 2024-03-16
 */
@Getter
@Setter
  @ApiModel(value = "Exorder对象", description = "")
public class Exorder implements Serializable {

    private static final long serialVersionUID = 1L;

      @ApiModelProperty("展会订单")
      @TableId(value = "exorder_id", type = IdType.AUTO)
        private Integer exorderId;

    private LocalDateTime exorderDate;

    private Integer exorderUserId;

    private String exorderExId;

    @ApiModelProperty("展会价钱")
    private BigDecimal exorderPrice;

    private Integer exorderNum;

}
