package org.duku.mall.framework.starter.common.modules.member.entity.params;

import cn.hutool.core.text.CharSequenceUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.duku.mall.framework.starter.common.common.vo.PageVO;

@Data
@ApiModel(value = "足迹查询参数")
public class FootPrintQueryParams extends PageVO {
    @ApiModelProperty("用户Id")
    private String memberId;

    @ApiModelProperty("店铺Id")
    private String storeId;

    public <T> QueryWrapper<T> queryWrapper() {
        QueryWrapper<T> queryWrapper = new QueryWrapper<>();
        if (CharSequenceUtil.isNotEmpty(memberId)) {
            queryWrapper.eq("member_id", memberId);
        }
        if (CharSequenceUtil.isNotEmpty(storeId)) {
            queryWrapper.eq("store_id", storeId);
        }
        queryWrapper.eq("delete_flag",false);
        queryWrapper.orderByDesc("create_time");
        return queryWrapper;
    }
}
