package org.duku.mall.framework.starter.common.modules.good.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.duku.mall.framework.starter.common.modules.good.entity.dos.Wholesale;

import java.util.List;

public interface WholesaleService extends IService<Wholesale> {

    List<Wholesale> findByGoodsId(String goodsId);

    List<Wholesale> findByTemplateId(String templateId);

    Boolean removeByGoodsId(String goodsId);


    Boolean removeByTemplateId(String templateId);

    /**
     * 匹配批发规则
     *
     * @param goodsId 商品规则
     * @param num 数量
     * @return 批发规则
     */
    Wholesale match(String goodsId, Integer num);
}
