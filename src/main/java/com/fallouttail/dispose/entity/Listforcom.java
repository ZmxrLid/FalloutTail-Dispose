package com.fallouttail.dispose.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.math.BigDecimal;

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
  @ApiModel(value = "Listforcom对象", description = "")
public class Listforcom implements Serializable {

    private static final long serialVersionUID = 1L;

      @ApiModelProperty("购物车id")
        @TableId(value = "list_id", type = IdType.AUTO)
      private Integer listId;

      @ApiModelProperty("购买人id")
      private Integer listUserId;

      @ApiModelProperty("商品id")
      private String listCommId;

      @ApiModelProperty("商品id")
      private Integer listNum;

      private BigDecimal listPrice;


}
