package org.duku.mall.framework.starter.common.modules.logistics.service.plugin.shunfeng;

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
public class ShunfengPlugin implements LogisticsPlugin {

    /**
     * ExpressServiceCodeEnum 对应速运类-快递APIs
     * POSTServiceCodeEnum 对应速运类-驿站APIs
     * YJTServiceCodeEnum 对应解决方案-医寄通APIs
     * EPSServiceCodeEnum 对应解决方案-快递管家APIs
     * 详情见code目录下枚举类，客户可自行修改引用的该类
     * 如需使用该插件，请在系统管理-物流设置中配置相关参数，并将插件名称设置为：shunfeng
     **/
    private LogisticsSetting logisticsSetting;


    public ShunfengPlugin(LogisticsSetting logisticsSetting) {
        this.logisticsSetting = logisticsSetting;
    }

    public ShunfengPlugin(){}
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
