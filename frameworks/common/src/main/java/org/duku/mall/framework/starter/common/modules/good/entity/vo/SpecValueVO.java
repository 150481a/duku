package org.duku.mall.framework.starter.common.modules.good.entity.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class SpecValueVO implements Serializable {

    private static final long serialVersionUID = -4433579132929428572L;

    @TableField(value = "spec_name")
    @ApiModelProperty(value = "规格项名字")
    private String specName;

    @TableField(value = "spec_value")
    @ApiModelProperty(value = "规格值")
    private String specValue;

    @ApiModelProperty(value = "该规格是否有图片，1 有 0 没有")
    private Integer specType;
    /**
     * 规格图片
     */
    @ApiModelProperty(value = "规格的图片")
    private List<String> specImage;
}
