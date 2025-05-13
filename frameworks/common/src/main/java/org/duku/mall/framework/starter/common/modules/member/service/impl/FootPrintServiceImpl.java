package org.duku.mall.framework.starter.common.modules.member.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.duku.mall.framework.starter.common.modules.good.service.GoodsSkuService;
import org.duku.mall.framework.starter.common.modules.member.entity.dos.FootPrint;
import org.duku.mall.framework.starter.common.modules.member.entity.params.FootPrintQueryParams;
import org.duku.mall.framework.starter.common.modules.member.mapper.FootPrintMapper;
import org.duku.mall.framework.starter.common.modules.member.service.FootPrintService;
import org.duku.mall.framework.starter.common.modules.search.entity.dos.EsGoodsIndex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FootPrintServiceImpl extends ServiceImpl<FootPrintMapper, FootPrint>  implements FootPrintService {


    @Autowired
    private GoodsSkuService goodsSkuService;

    @Override
    public FootPrint saveFootprint(FootPrint footPrint) {
        return null;
    }

    @Override
    public boolean clean() {
        return false;
    }

    @Override
    public boolean deleteByIds(List<String> ids) {
        return false;
    }

    @Override
    public IPage<EsGoodsIndex> footPrintPage(FootPrintQueryParams params) {
        return null;
    }

    @Override
    public long getFootprintNum() {
        return 0;
    }
}
