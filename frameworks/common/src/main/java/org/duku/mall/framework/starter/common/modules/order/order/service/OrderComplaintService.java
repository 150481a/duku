package org.duku.mall.framework.starter.common.modules.order.order.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.duku.mall.framework.starter.common.common.vo.PageVO;
import org.duku.mall.framework.starter.common.modules.order.order.entity.dos.OrderComplaint;
import org.duku.mall.framework.starter.common.modules.order.order.entity.dto.OrderComplaintDTO;
import org.duku.mall.framework.starter.common.modules.order.order.entity.params.OrderComplaintOperationParams;
import org.duku.mall.framework.starter.common.modules.order.order.entity.params.OrderComplaintSearchParams;
import org.duku.mall.framework.starter.common.modules.order.order.entity.vo.OrderComplaintVO;
import org.duku.mall.framework.starter.common.modules.order.order.entity.vo.StoreAppealVO;

public interface OrderComplaintService extends IService<OrderComplaint> {

    /**
     * 分页获取交易投诉信息
     *
     * @param searchParams 查询参数
     * @param pageVO       分页参数
     * @return 交易投诉信息
     */
    IPage<OrderComplaint> getOrderComplainByPage(OrderComplaintSearchParams searchParams, PageVO pageVO);

    /**
     * 获取交易投诉详情
     *
     * @param id 交易投诉ID
     * @return 交易投诉详情
     */
    OrderComplaintVO getOrderComplainById(String id);

    /**
     * 获取交易投诉详情
     *
     * @param storeId 店铺id
     * @return 交易投诉详情
     */
    OrderComplaint getOrderComplainByStoreId(String storeId);

    /**
     * 添加交易投诉
     *
     * @param orderComplaintDTO 交易投诉信息
     * @return 添加结果
     */
    OrderComplaint addOrderComplain(OrderComplaintDTO orderComplaintDTO);

    /**
     * 更新交易投诉
     *
     * @param orderComplainVO 交易投诉信息
     * @return 更新结果
     */
    boolean updateOrderComplain(OrderComplaintVO orderComplainVO);

    /**
     * 修改交易投诉状态
     *
     * @param operationParam 操作参数
     * @return 修改的交易投诉
     */
    OrderComplaint updateOrderComplainByStatus(OrderComplaintOperationParams operationParam);

    /**
     * 待处理投诉数量
     *
     * @return 待处理投诉数量
     */
    long waitComplainNum();

    /**
     * 取消交易投诉
     *
     * @param id 交易投诉ID
     * @return 操作状态
     */
    boolean cancel(String id);

    /**
     * 店铺申诉
     *
     * @param storeAppealVO
     * @return 操作状态
     */
    boolean appeal(StoreAppealVO storeAppealVO);
}
