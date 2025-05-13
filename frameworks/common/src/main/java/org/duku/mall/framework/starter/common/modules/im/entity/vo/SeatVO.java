package org.duku.mall.framework.starter.common.modules.im.entity.vo;

import lombok.Data;
import org.duku.mall.framework.starter.common.modules.im.entity.dos.Seat;

@Data
public class SeatVO extends Seat {

    /**
     * 在线状态
     */
    private String onlineStatus;
}
