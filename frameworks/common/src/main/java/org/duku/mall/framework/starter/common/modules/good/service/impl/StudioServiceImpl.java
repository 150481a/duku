package org.duku.mall.framework.starter.common.modules.good.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.duku.mall.framework.starter.common.common.properties.RocketmqCustomProperties;
import org.duku.mall.framework.starter.common.common.vo.PageVO;
import org.duku.mall.framework.starter.common.modules.good.entity.dos.Studio;
import org.duku.mall.framework.starter.common.modules.good.entity.vo.StudioVO;
import org.duku.mall.framework.starter.common.modules.good.mapper.StudioMapper;
import org.duku.mall.framework.starter.common.modules.good.service.CommodityService;
import org.duku.mall.framework.starter.common.modules.good.service.GoodsService;
import org.duku.mall.framework.starter.common.modules.good.service.StudioCommodityService;
import org.duku.mall.framework.starter.common.modules.good.service.StudioService;
import org.duku.mall.framework.starter.common.modules.good.util.WechatLivePlayerUtil;
import org.duku.mall.framework.starter.common.trigger.interfaces.TimeTrigger;
import org.duku.mall.framework.starter.common.trigger.messages.BroadcastMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudioServiceImpl extends ServiceImpl<StudioMapper, Studio> implements StudioService {

    @Autowired
    private WechatLivePlayerUtil wechatLivePlayerUtil;
    @Autowired
    private StudioCommodityService studioCommodityService;
    @Autowired
    private CommodityService commodityService;
    @Autowired
    private TimeTrigger timeTrigger;
    @Autowired
    private RocketmqCustomProperties rocketmqCustomProperties;
    @Autowired
    private GoodsService goodsService;

    @Override
    public Boolean create(Studio studio) {
        return null;
    }

    @Override
    public Boolean edit(Studio studio) {
        return null;
    }

    @Override
    public StudioVO getStudioVO(String id) {
        return null;
    }

    @Override
    public String getLiveInfo(Integer roomId) {
        return "";
    }

    @Override
    public Boolean push(Integer roomId, Integer liveGoodsId, String storeId, String goodsId) {
        return null;
    }

    @Override
    public Boolean goodsDeleteInRoom(Integer roomId, Integer goodsId, String storeId) {
        return null;
    }

    @Override
    public IPage<StudioVO> studioList(PageVO pageVO, Integer recommend, String status) {
        return null;
    }

    @Override
    public void updateStudioStatus(BroadcastMessage broadcastMessage) {

    }
}
