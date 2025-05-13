package org.duku.mall.framework.starter.common.modules.good.entity.params;

import cn.hutool.core.text.CharSequenceUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.duku.mall.framework.starter.common.modules.good.entity.enums.DraftGoodsSaveTypeEnum;

@Data
public class DraftGoodsSearchParams extends GoodsSearchParams{

    private static final long serialVersionUID = -1057830772267228050L;

    /**
     * @see DraftGoodsSaveTypeEnum
     */
    @ApiModelProperty(value = "草稿商品保存类型")
    private String saveType;

    @Override
    public <T> QueryWrapper<T> queryWrapper() {
        QueryWrapper<T> queryWrapper = super.queryWrapper();
        if (CharSequenceUtil.isNotEmpty(saveType)) {
            queryWrapper.eq("save_type", saveType);
        }
        return queryWrapper;
    }
}
