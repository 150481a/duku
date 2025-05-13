package org.duku.mall.framework.starter.common.modules.good.entity.dos;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.duku.mall.framework.starter.common.mybatis.BaseIdEntity;

@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "直播间商品")
@TableName("li_studio_commodity")
@NoArgsConstructor
public class StudioCommodity extends BaseIdEntity {


    private static final long serialVersionUID = 8383627725577840261L;

    @ApiModelProperty(value = "房间ID")
    private Integer roomId;

    @ApiModelProperty(value = "商品ID")
    private Integer goodsId;

    public StudioCommodity(Integer roomId, Integer goodsId) {
        this.roomId = roomId;
        this.goodsId = goodsId;
    }
}
