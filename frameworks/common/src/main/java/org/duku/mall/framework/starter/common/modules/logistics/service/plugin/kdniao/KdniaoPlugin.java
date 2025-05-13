package org.duku.mall.framework.starter.common.modules.logistics.service.plugin.kdniao;

import lombok.extern.slf4j.Slf4j;
import org.duku.mall.framework.starter.common.modules.logistics.entity.dto.LabelOrderDTO;
import org.duku.mall.framework.starter.common.modules.logistics.entity.enums.LogisticsEnum;
import org.duku.mall.framework.starter.common.modules.logistics.service.LogisticsPlugin;
import org.duku.mall.framework.starter.common.modules.order.order.entity.vo.OrderDetailVO;
import org.duku.mall.framework.starter.common.modules.system.entity.dos.Logistics;
import org.duku.mall.framework.starter.common.modules.system.entity.dos.LogisticsSetting;
import org.duku.mall.framework.starter.common.modules.system.entity.vo.Traces;

import java.util.Map;

@Slf4j
public class KdniaoPlugin implements LogisticsPlugin {

    private LogisticsSetting logisticsSetting;

    public KdniaoPlugin(LogisticsSetting logisticsSetting) {
        this.logisticsSetting = logisticsSetting;
    }

    @Override
    public LogisticsEnum pluginName() {
        return null;
    }

    @Override
    public Traces pollQuery(Logistics logistics, String expNo, String phone) {
        return null;
    }

    @Override
    public Traces pollMapTrack(Logistics logistics, String expNo, String phone, String from, String to) {
        return null;
    }

    @Override
    public Map labelOrder(LabelOrderDTO labelOrderDTO) {
        return Map.of();
    }

    @Override
    public String createOrder(OrderDetailVO orderDetailVO) {
        return "";
    }
}
