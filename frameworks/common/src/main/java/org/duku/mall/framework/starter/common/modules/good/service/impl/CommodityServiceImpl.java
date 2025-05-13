package org.duku.mall.framework.starter.common.modules.good.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.duku.mall.framework.starter.common.common.vo.PageVO;
import org.duku.mall.framework.starter.common.modules.good.entity.dos.Commodity;
import org.duku.mall.framework.starter.common.modules.good.entity.vo.CommodityVO;
import org.duku.mall.framework.starter.common.modules.good.mapper.CommodityMapper;
import org.duku.mall.framework.starter.common.modules.good.service.CommodityService;
import org.duku.mall.framework.starter.common.modules.good.service.GoodsSkuService;
import org.duku.mall.framework.starter.common.modules.good.util.WechatLivePlayerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommodityServiceImpl extends ServiceImpl<CommodityMapper, Commodity> implements CommodityService {

    @Autowired
    private WechatLivePlayerUtil wechatLivePlayerUtil;
    @Autowired
    private GoodsSkuService goodsSkuService;

    @Override
    public boolean addCommodity(List<Commodity> commodity) {
        return false;
    }

    @Override
    public boolean deleteCommodity(String goodsId) {
        return false;
    }

    @Override
    public void getGoodsWareHouse() {

    }

    @Override
    public IPage<CommodityVO> commodityList(PageVO pageVO, String name, String auditStatus) {
        return null;
    }

    @Override
    public List<Commodity> getCommodityByRoomId(Integer roomId) {
        return List.of();
    }

    @Override
    public List<String> getSimpleCommodityByRoomId(Integer roomId) {
        return List.of();
    }
}
