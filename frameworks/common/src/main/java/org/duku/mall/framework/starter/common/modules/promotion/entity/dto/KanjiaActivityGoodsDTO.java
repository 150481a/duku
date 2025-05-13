package org.duku.mall.framework.starter.common.modules.promotion.entity.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.duku.mall.framework.starter.common.modules.good.entity.dos.GoodsSku;
import org.duku.mall.framework.starter.common.modules.promotion.entity.dos.KanjiaActivityGoods;

import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Data
public class KanjiaActivityGoodsDTO  extends KanjiaActivityGoods implements Serializable {

    private static final long serialVersionUID = 1969340823809319805L;

    @ApiModelProperty(value = "商品规格详细信息")
    private GoodsSku goodsSku;

}
