package org.duku.mall.framework.starter.common.modules.good.entity.dos;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.duku.mall.framework.starter.common.mybatis.BaseEntity;
import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;

@Data
@TableName("li_store_goods_label")
@ApiModel(value = "店铺商品分类")
public class StoreGoodsLabel extends BaseEntity {

    private static final long serialVersionUID = -5292518678940634419L;

    @ApiModelProperty("店铺ID")
    private String storeId;

    @NotEmpty(message = "店铺商品分类名称不能为空")
    @Length(max = 20,message = "店铺商品分类名称太长")
    @ApiModelProperty("店铺商品分类名称")
    private String labelName;


    @NotNull(message = "店铺商品分类排序不能为空")
    @Max(value = 99999,message = "排序值太大")
    @ApiModelProperty("店铺商品分类排序")
    private BigDecimal sortOrder;

    @NotEmpty(message = "父节点不能为空，需设定根节点或者某节点的子节点")
    @ApiModelProperty(value = "父id, 根节点为0")
    private String parentId;

    @ApiModelProperty(value = "层级, 从0开始")
    private Integer level;
}
