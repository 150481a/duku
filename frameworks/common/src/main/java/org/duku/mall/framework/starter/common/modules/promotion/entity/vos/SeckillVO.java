package org.duku.mall.framework.starter.common.modules.promotion.entity.vos;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.duku.mall.framework.starter.common.modules.promotion.entity.dos.Seckill;
import org.duku.mall.framework.starter.common.modules.promotion.entity.dos.SeckillApply;
import org.duku.mall.framework.starter.common.modules.promotion.entity.enums.SeckillApplyStatusEnum;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
public class SeckillVO extends Seckill {
    private static final long serialVersionUID = 2891461638257152270L;

    /**
     * @see SeckillApplyStatusEnum
     */
    @ApiModelProperty(value = "报名状态")
    private String seckillApplyStatus;

    /**
     * 当前秒杀活动下所有的秒杀申请信息
     */
    private List<SeckillApply> seckillApplyList;
}
