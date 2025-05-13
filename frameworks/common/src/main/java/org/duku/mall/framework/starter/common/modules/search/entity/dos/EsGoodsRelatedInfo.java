package org.duku.mall.framework.starter.common.modules.search.entity.dos;

import lombok.Data;
import org.duku.mall.framework.starter.common.modules.search.entity.dto.ParamOptions;
import org.duku.mall.framework.starter.common.modules.search.entity.dto.SelectorOptions;

import java.util.List;

@Data
public class EsGoodsRelatedInfo {
    /**
     * 分类集合
     */
    List<SelectorOptions> categories;

    /**
     * 品牌集合
     */
    List<SelectorOptions> brands;

    /**
     * 参数集合
     */
    List<ParamOptions> paramOptions;
}
