package org.duku.mall.framework.starter.common.modules.im.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.duku.mall.framework.starter.common.modules.im.entity.dos.SeatSetting;

public interface SeatSettingService extends IService<SeatSetting> {


    /**
     * 根据店铺id获取坐席配置
     *
     * @param storeId
     * @return
     */
    SeatSetting getSetting(String storeId);

    /**
     * 根据店铺修改坐席设置
     *
     * @param seatSetting 坐席设置
     * @return
     */
    SeatSetting updateByStore(SeatSetting seatSetting);
}
