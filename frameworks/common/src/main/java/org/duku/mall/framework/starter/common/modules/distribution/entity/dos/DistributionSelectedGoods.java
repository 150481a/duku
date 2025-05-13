package org.duku.mall.framework.starter.common.modules.distribution.entity.dos;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.duku.mall.framework.starter.common.mybatis.BaseIdEntity;

@Data
@ApiModel(value = "分销商已选择分销商品")
@TableName("li_distribution_selected_goods")
@NoArgsConstructor
public class DistributionSelectedGoods extends BaseIdEntity {

    @ApiModelProperty(value = "分销员ID")
    private String distributionId;

    @ApiModelProperty(value = "分销商品ID")
    private String distributionGoodsId;

    public DistributionSelectedGoods(String distributionId, String distributionGoodsId) {
        this.distributionId = distributionId;
        this.distributionGoodsId = distributionGoodsId;
    }
}
