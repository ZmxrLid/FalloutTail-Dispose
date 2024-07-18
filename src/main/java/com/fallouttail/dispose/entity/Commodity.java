package com.fallouttail.dispose.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Blob;
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
  @ApiModel(value = "Commodity对象", description = "")
public class Commodity implements Serializable {

    private static final long serialVersionUID = 1L;

      @ApiModelProperty("商品id")
        @TableId(value = "com_id", type = IdType.AUTO)
      private Integer comId;

      @ApiModelProperty("商品名称")
      private String comName;

      @ApiModelProperty("商品介绍")
      private String comIntroduce;

      @ApiModelProperty("商品库存")
      private Integer comInventory;

      @ApiModelProperty("商品价钱")
      private BigDecimal comPrice;

      @ApiModelProperty("商品宣传图")
      private String comImg;

      @ApiModelProperty("商品品牌")
      private String comBrand;

  @ApiModelProperty("展会详情图")
  private String comDetailImg;

  @ApiModelProperty("商品分类")
  private String comClassify;

}
