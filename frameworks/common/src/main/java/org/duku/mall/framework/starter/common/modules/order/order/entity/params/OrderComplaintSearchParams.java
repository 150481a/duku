package org.duku.mall.framework.starter.common.modules.order.order.entity.params;

import cn.hutool.core.text.CharSequenceUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.duku.mall.framework.starter.common.modules.order.order.entity.dos.OrderComplaint;
import org.duku.mall.framework.starter.common.modules.order.order.entity.enums.OrderComplaintStatusEnum;
@Data
public class OrderComplaintSearchParams {
    /**
     * @see OrderComplaintStatusEnum
     */
    @ApiModelProperty(value = "交易投诉状态")
    private String status;

    @ApiModelProperty(value = "订单号")
    private String orderSn;

    @ApiModelProperty(value = "会员id")
    private String memberId;

    @ApiModelProperty(value = "会员名称")
    private String memberName;

    @ApiModelProperty(value = "商家id")
    private String storeId;

    @ApiModelProperty(value = "商家名称")
    private String storeName;

    public LambdaQueryWrapper<OrderComplaint> lambdaQueryWrapper() {
        LambdaQueryWrapper<OrderComplaint> queryWrapper = new LambdaQueryWrapper<>();
        if (CharSequenceUtil.isNotEmpty(status)) {
            queryWrapper.eq(OrderComplaint::getComplainStatus, status);
        }
        if (CharSequenceUtil.isNotEmpty(orderSn)) {
            queryWrapper.like(OrderComplaint::getOrderSn, orderSn);
        }
        if (CharSequenceUtil.isNotEmpty(storeName)) {
            queryWrapper.like(OrderComplaint::getStoreName, storeName);
        }
        if (CharSequenceUtil.isNotEmpty(storeId)) {
            queryWrapper.eq(OrderComplaint::getStoreId, storeId);
        }
        if (CharSequenceUtil.isNotEmpty(memberName)) {
            queryWrapper.like(OrderComplaint::getMemberName, memberName);
        }
        if (CharSequenceUtil.isNotEmpty(memberId)) {
            queryWrapper.eq(OrderComplaint::getMemberId, memberId);
        }
        queryWrapper.eq(OrderComplaint::getDeleteFlag, false);
        queryWrapper.orderByDesc(OrderComplaint::getCreateTime);
        return queryWrapper;
    }
}
