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
  @ApiModel(value = "Anno对象", description = "")
public class Anno implements Serializable {

    private static final long serialVersionUID = 1L;

      @ApiModelProperty("公告id")
        @TableId(value = "anno_id", type = IdType.AUTO)
      private Integer annoId;

      @ApiModelProperty("公告内容")
      private String annoIntroduce;

      @ApiModelProperty("公告时间")
      private LocalDateTime annoDate;

      @ApiModelProperty("公告发起人")
      private Integer annoAdminId;

      @ApiModelProperty("公告标题")
      private String annoTitle;


}
