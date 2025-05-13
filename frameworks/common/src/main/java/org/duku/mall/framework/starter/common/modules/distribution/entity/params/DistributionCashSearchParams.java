package org.duku.mall.framework.starter.common.modules.distribution.entity.params;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.duku.mall.framework.starter.common.common.vo.PageVO;
import org.duku.mall.framework.starter.common.common.utils.StringUtils;

@Data
public class DistributionCashSearchParams extends PageVO {


    /**
     * 编号
     */
    @ApiModelProperty(value = "编号")
    private String sn;
    /**
     * 会员名称
     */
    @ApiModelProperty(value = "会员名称")
    private String memberName;

    /**
     * 分销员提现状态
     */
    @ApiModelProperty(value = "分销员提现状态",allowableValues = "APPLY,PASS,REFUSE")
    private String distributionCashStatus;

    public <T> QueryWrapper<T> queryWrapper() {
        QueryWrapper<T> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotEmpty(memberName)) {
            queryWrapper.like("distribution_name", memberName);
        }
        if (StringUtils.isNotEmpty(sn)) {
            queryWrapper.like("sn", sn);
        }
        if (StringUtils.isNotEmpty(distributionCashStatus)) {
            queryWrapper.like("distribution_cash_status", distributionCashStatus);
        }
        return queryWrapper;
    }
}
