package org.duku.mall.framework.starter.common.modules.good.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.duku.mall.framework.starter.common.modules.good.entity.dos.Commodity;
import org.duku.mall.framework.starter.common.modules.good.entity.dos.Studio;

import java.util.List;
@EqualsAndHashCode(callSuper = true)
@Data
public class StudioVO extends Studio {

    private static final long serialVersionUID = 3459644787796753594L;

    @ApiModelProperty(value = "直播间商品列表")
    private List<Commodity> commodityList;
}
