package org.duku.mall.framework.starter.common.modules.order.order.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.duku.mall.framework.starter.common.common.vo.PageVO;
import org.duku.mall.framework.starter.common.modules.order.order.entity.dos.OrderComplaintCommunication;
import org.duku.mall.framework.starter.common.modules.order.order.entity.params.OrderComplaintCommunicationSearchParams;
import org.duku.mall.framework.starter.common.modules.order.order.entity.vo.OrderComplaintCommunicationVO;

public interface OrderComplaintCommunicationService extends IService<OrderComplaintCommunication> {

    /**
     * 添加订单投诉通信
     *
     * @param communicationVO 投诉通信VO
     * @return 状态
     */
    boolean addCommunication(OrderComplaintCommunicationVO communicationVO);

    /**
     * 获取通信记录
     *
     * @param searchParams 参数
     * @param pageVO       分页
     * @return
     */
    IPage<OrderComplaintCommunication> getCommunication(OrderComplaintCommunicationSearchParams searchParams, PageVO pageVO);

}
