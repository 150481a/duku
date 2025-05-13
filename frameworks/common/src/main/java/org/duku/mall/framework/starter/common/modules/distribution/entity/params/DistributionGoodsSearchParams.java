package org.duku.mall.framework.starter.common.modules.distribution.entity.params;

import cn.hutool.core.text.CharSequenceUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.duku.mall.framework.starter.common.common.vo.PageVO;
import org.duku.mall.framework.starter.user.core.UserContext;

import java.util.Objects;

@EqualsAndHashCode(callSuper = true)
@Data
public class DistributionGoodsSearchParams extends PageVO {

    @ApiModelProperty(value = "商品ID")
    private String goodsId;

    @ApiModelProperty(value = "商品名称")
    private String goodsName;

    @ApiModelProperty(value = "是否已选择")
    private boolean isChecked;

    public <T> QueryWrapper<T> queryWrapper() {
        QueryWrapper<T> queryWrapper = this.distributionQueryWrapper();
        queryWrapper.eq(CharSequenceUtil.isNotEmpty(goodsId), "goods_id", goodsId);
        queryWrapper.eq(CharSequenceUtil.isNotEmpty(goodsName), "goods_name", goodsId);
        return queryWrapper;
    }

    public <T> QueryWrapper<T> storeQueryWrapper() {
        QueryWrapper<T> queryWrapper = this.distributionQueryWrapper();
        queryWrapper.eq("dg.store_id", Objects.requireNonNull(UserContext.getCurrentUser()).getStoreId());
        return queryWrapper;
    }

    public <T> QueryWrapper<T> distributionQueryWrapper() {
        QueryWrapper<T> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(CharSequenceUtil.isNotEmpty(goodsName), "dg.goods_name", goodsName);
        return queryWrapper;
    }
}
