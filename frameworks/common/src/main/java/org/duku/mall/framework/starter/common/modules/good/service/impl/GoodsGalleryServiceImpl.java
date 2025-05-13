package org.duku.mall.framework.starter.common.modules.good.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.duku.mall.framework.starter.common.modules.good.entity.dos.GoodsGallery;
import org.duku.mall.framework.starter.common.modules.good.mapper.GoodsGalleryMapper;
import org.duku.mall.framework.starter.common.modules.good.service.GoodsGalleryService;
import org.duku.mall.framework.starter.common.modules.system.service.SettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsGalleryServiceImpl extends ServiceImpl<GoodsGalleryMapper, GoodsGallery> implements GoodsGalleryService {

    /**
     * 设置
     */
    @Autowired
    private SettingService settingService;

    @Override
    public void add(List<String> goodsGalleryList, String goodsId) {

    }

    @Override
    public GoodsGallery getGoodsGallery(String origin) {
        return null;
    }

    @Override
    public List<GoodsGallery> goodsGalleryList(String goodsId) {
        return List.of();
    }

    @Override
    public void removeByGoodsId(String goodsId) {

    }
}
