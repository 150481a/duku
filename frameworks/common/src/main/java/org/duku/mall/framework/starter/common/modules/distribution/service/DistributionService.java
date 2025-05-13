package org.duku.mall.framework.starter.common.modules.distribution.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.duku.mall.framework.starter.common.common.vo.PageVO;
import org.duku.mall.framework.starter.common.modules.distribution.entity.dos.Distribution;
import org.duku.mall.framework.starter.common.modules.distribution.entity.dto.DistributionApplyDTO;
import org.duku.mall.framework.starter.common.modules.distribution.entity.params.DistributionSearchParams;

public interface DistributionService  extends IService<Distribution> {

    /**
     * 获取分销员分页列表
     *
     * @param distributionSearchParams 分销员
     * @param page                     分页
     * @return
     */
    IPage<Distribution> distributionPage(DistributionSearchParams distributionSearchParams, PageVO page);

    /**
     * 获取当前登录的会员的分销员信息
     *
     * @return
     */
    Distribution getDistribution();

    /**
     * 提交分销申请
     *
     * @param distributionApplyDTO 分销申请DTO
     * @return 分销员
     */
    Distribution applyDistribution(DistributionApplyDTO distributionApplyDTO);

    /**
     * 审核分销申请
     *
     * @param id     分销员ID
     * @param status 审核状态
     * @return 操作状态
     */
    boolean audit(String id, String status);

    /**
     * 清退分销员
     *
     * @param id 分销员ID
     * @return 操作状态
     */
    boolean retreat(String id);

    /**
     * 恢复分销员
     *
     * @param id 分销员ID
     * @return 操作状态
     */
    boolean resume(String id);

    /**
     * 绑定会员的分销员关系
     *
     * @param distributionId 分销员ID
     */
    void bindingDistribution(String distributionId);

    /**
     * 检查分销设置开关
     */
    void checkDistributionSetting();

    /**
     * 添加分销冻结金额
     * 创建分销订单时进行调用
     *
     * @param rebate         金额
     * @param distributionId 分销员ID
     * @param distributionOrderPrice 分销订单金额
     */
    void addRebate(Double rebate, String distributionId, Double distributionOrderPrice);

    /**
     * 扣减分销冻结金额
     * 订单取消/退款时进行调用
     *
     * @param rebate      佣金
     * @param distributionId 分销员ID
     */
    void subRebate(Double rebate, String distributionId, Double distributionOrderPrice);

    /**
     * 添加分销可提现金额
     * 订单完成时进行调用
     * @param rebate 佣金
     * @param distributionId 分销员ID
     */
    void addCanRebate(Double rebate, String distributionId);

    /**
     * 添加提现金额
     * @param rebate
     * @param distributionId
     */
    void addCashRebate(Double rebate, String distributionId);
    /**
     * 扣减提现金额
     * @param rebate
     * @param distributionId
     */
    void subCashRebate(Double rebate, String distributionId);
}
