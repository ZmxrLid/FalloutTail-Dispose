package com.fallouttail.dispose.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.math.BigDecimal;
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
  @ApiModel(value = "Orders对象", description = "")
public class Orders implements Serializable {

    private static final long serialVersionUID = 1L;

      @ApiModelProperty("订单id")
        @TableId(value = "orders_id", type = IdType.AUTO)
      private Integer ordersId;

      @ApiModelProperty("订单所属用户id")
      private Integer ordersUserId;

      @ApiModelProperty("订单状态0未发货1发货中2已完成")
      private String ordersState;

      @ApiModelProperty("下单时间")
      private LocalDateTime ordersDate;

      @ApiModelProperty("商品id")
      private String ordersComId;

      @ApiModelProperty("收货地址")
      private String ordersPlace;

      @ApiModelProperty("商品数量")
      private Integer ordersNum;

      @ApiModelProperty("商品价钱")
      private BigDecimal ordersPrice;

}
