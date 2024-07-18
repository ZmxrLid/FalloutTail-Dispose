package com.fallouttail.dispose.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Blob;
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
  @ApiModel(value = "Exhibition对象", description = "")
public class Exhibition implements Serializable {

    private static final long serialVersionUID = 1L;

      @ApiModelProperty("展会id")
      @TableId(value = "ex_id", type = IdType.AUTO)
      private Integer exId;

      @ApiModelProperty("展会名称")
      private String exName;

      @ApiModelProperty("展会介绍")
      private String exIntroduce;

      @ApiModelProperty("展会价钱")
      private BigDecimal exPrice;

      @ApiModelProperty("展会时间")
      private String exDate;

      @ApiModelProperty("展会地点")
      private String exPlace;

      @ApiModelProperty("展会宣传图")
      private String exImg;

      @ApiModelProperty("展会所在省")
      private String exPlaceSelect;

      @ApiModelProperty("参展人员")
      private String exPeople;

      @ApiModelProperty("展会详情图")
      private String exDetailImg;

}
