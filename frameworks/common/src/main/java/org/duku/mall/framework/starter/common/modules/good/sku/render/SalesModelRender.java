package org.duku.mall.framework.starter.common.modules.good.sku.render;

import org.duku.mall.framework.starter.common.modules.good.entity.dos.GoodsSku;
import org.duku.mall.framework.starter.common.modules.good.entity.dto.GoodsOperationDTO;

import java.util.List;

public interface SalesModelRender {

    String getSalesMode();

    void renderSingle(GoodsSku goodsSku, GoodsOperationDTO goodsOperationDTO);

    void renderBatch(List<GoodsSku> goodsSkus, GoodsOperationDTO goodsOperationDTO);
}
