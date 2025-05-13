package org.duku.mall.framework.starter.common.modules.order.order.entity.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.duku.mall.framework.starter.common.common.utils.BeanUtil;
import org.duku.mall.framework.starter.common.modules.order.order.entity.dos.OrderPackage;
import org.duku.mall.framework.starter.common.modules.order.order.entity.dos.OrderPackageItem;
import org.duku.mall.framework.starter.common.modules.system.entity.vo.Traces;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
public class OrderPackageVO implements Serializable {

    private static final long serialVersionUID = 1810890757303309436L;

    @ApiModelProperty(value = "包裹单号")
    private String packageNo;

    @ApiModelProperty(value = "订单编号")
    private String orderSn;

    @ApiModelProperty(value = "发货单号")
    private String logisticsNo;

    @ApiModelProperty(value = "物流公司CODE")
    private String logisticsCode;

    @ApiModelProperty(value = "物流公司名称")
    private String logisticsName;

    @ApiModelProperty(value = "收件人手机")
    private String consigneeMobile;

    @ApiModelProperty(value = "状态")
    private String status;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "子订单包裹详情列表")
    private List<OrderPackageItem> orderPackageItemList;

    @ApiModelProperty(value = "物流信息")
    private Traces traces;

    public OrderPackageVO(OrderPackage orderPackage) {
        BeanUtil.copyProperties(orderPackage, this);
    }
}
