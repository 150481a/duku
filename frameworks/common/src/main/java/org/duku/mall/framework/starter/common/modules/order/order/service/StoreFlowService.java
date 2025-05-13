package org.duku.mall.framework.starter.common.modules.order.order.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.duku.mall.framework.starter.common.common.vo.PageVO;
import org.duku.mall.framework.starter.common.modules.order.aftersale.entity.dos.AfterSale;
import org.duku.mall.framework.starter.common.modules.order.order.entity.dos.StoreFlow;
import org.duku.mall.framework.starter.common.modules.order.order.entity.dto.StoreFlowQueryDTO;
import org.duku.mall.framework.starter.common.modules.store.entity.dos.Bill;
import org.duku.mall.framework.starter.common.modules.store.entity.dto.StoreFlowPayDownloadVO;
import org.duku.mall.framework.starter.common.modules.store.entity.dto.StoreFlowRefundDownloadVO;
import org.duku.mall.framework.starter.common.modules.store.entity.params.BillSearchParams;

import java.util.List;

public interface StoreFlowService extends IService<StoreFlow> {

    /**
     * 支付订单
     *
     * @param orderSn 订单编号
     */
    void payOrder(String orderSn);

    /**
     * 订单取消
     * @param orderSn 订单
     */
    void orderCancel(String orderSn);

    /**
     * 订单退款
     *
     * @param afterSale 售后单
     */
    void refundOrder(AfterSale afterSale);

    /**
     * 获取商家流水
     *
     * @param storeFlowQueryDTO 查询参数
     * @return 返回分页
     */
    IPage<StoreFlow> getStoreFlow(StoreFlowQueryDTO storeFlowQueryDTO);

    /**
     * 根据参数查询一条数据
     *
     * @param storeFlowQueryDTO 查询参数
     * @return 返回分页
     */
    StoreFlow queryOne(StoreFlowQueryDTO storeFlowQueryDTO);

    /**
     * 获取结算单地入账流水
     *
     * @param storeFlowQueryDTO 查询条件
     * @return 入账流水
     */
    List<StoreFlowPayDownloadVO> getStoreFlowPayDownloadVO(StoreFlowQueryDTO storeFlowQueryDTO);

    /**
     * 获取结算单的退款流水
     *
     * @param storeFlowQueryDTO 查询条件
     * @return 退款流水
     */
    List<StoreFlowRefundDownloadVO> getStoreFlowRefundDownloadVO(StoreFlowQueryDTO storeFlowQueryDTO);


    /**
     * 根据结算单ID获取商家流水
     *
     * @param pageVO 分页
     * @param id     结算单ID
     * @param type   类型
     * @return 商家流水
     */
    IPage<StoreFlow> getStoreFlow(String id, String type, PageVO pageVO);

    /**
     * 根据结算单ID获取商家流水
     *
     * @param pageVO 分页
     * @param id     结算单ID
     * @return 商家流水
     */
    IPage<StoreFlow> getDistributionFlow(String id, PageVO pageVO);


    /**
     * 获取店铺流水
     *
     * @param storeFlowQueryDTO 店铺流水查询参数
     * @return 商家流水集合
     */
    List<StoreFlow> listStoreFlow(StoreFlowQueryDTO storeFlowQueryDTO);

    /**
     * 修改分账状态
     */
    void updateProfitSharingStatus();

    /**
     * 获取退款的流水
     *
     * @param searchParams
     * @return
     */
    Bill getRefundBill(BillSearchParams searchParams);
    /**
     * 获取订单的流水
     *
     * @param searchParams
     * @return
     */
    Bill getOrderBill(BillSearchParams searchParams);
}
