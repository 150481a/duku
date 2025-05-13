package org.duku.mall.framework.starter.common.modules.member.entity.dos;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.duku.mall.framework.starter.common.mybatis.BaseEntity;


@EqualsAndHashCode(callSuper = true)
@Data
@TableName("li_foot_print")
@ApiModel(value = "浏览历史")
@NoArgsConstructor
@AllArgsConstructor
public class FootPrint extends BaseEntity {

    private static final long serialVersionUID = 1L;


    @ApiModelProperty(value = "会员ID")
    private String memberId;

    @ApiModelProperty(value = "店铺Id")
    private String storeId;

    @ApiModelProperty(value = "商品ID")
    private String goodsId;

    @ApiModelProperty(value = "规格ID")
    private String skuId;
}
