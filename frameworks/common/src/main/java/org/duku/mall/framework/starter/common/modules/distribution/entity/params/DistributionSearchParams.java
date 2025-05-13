package org.duku.mall.framework.starter.common.modules.distribution.entity.params;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.duku.mall.framework.starter.common.common.utils.StringUtils;

@Data
public class DistributionSearchParams  {

    @ApiModelProperty(value = "会员名称")
    private String memberName;

    @ApiModelProperty(value = "分销员状态", allowableValues = "APPLY,RETREAT,REFUSE,PASS")
    private String distributionStatus;

    public <T> QueryWrapper<T> queryWrapper() {
        QueryWrapper<T> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(StringUtils.isNotEmpty(memberName), "member_name", memberName);
        queryWrapper.eq(StringUtils.isNotEmpty(distributionStatus), "distribution_status", distributionStatus);
        return queryWrapper;
    }
}
