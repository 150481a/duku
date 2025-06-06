package org.duku.mall.framework.starter.common.modules.member.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class MemberPointsHistoryVO {
    @ApiModelProperty(value = "当前会员积分")
    private Long point;

    @ApiModelProperty(value = "累计获得积分")
    private Long totalPoint;


    public MemberPointsHistoryVO(){
        this.point = 0L;
        this.totalPoint = 0L;
    }
}
