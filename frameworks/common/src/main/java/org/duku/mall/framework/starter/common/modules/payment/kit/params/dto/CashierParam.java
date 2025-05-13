package org.duku.mall.framework.starter.common.modules.payment.kit.params.dto;

import cn.hutool.core.text.CharSequenceUtil;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;
import org.duku.mall.framework.starter.common.common.utils.StringUtils;

import java.util.Date;
import java.util.List;

@Data
@ToString
public class CashierParam {
    static final Long MAX_DETAIL_LENGTH = 30L;

    @ApiModelProperty(value = "价格")
    private Double price;

    @ApiModelProperty(value = "支付title")
    private String title;

    @ApiModelProperty(value = "支付详细描述")
    private String detail;

    @ApiModelProperty(value = "订单sn集合")
    private String orderSns;

    @ApiModelProperty(value = "支持支付方式")
    private List<String> support;


    @ApiModelProperty(value = "订单创建时间")
    private Date createTime;

    @ApiModelProperty(value = "支付自动结束时间")
    private Long autoCancel;

    @ApiModelProperty(value = "剩余余额")
    private Double walletValue;

    public String getDetail() {
        if (CharSequenceUtil.isEmpty(detail)) {
            return "清单详细";
        }
        return StringUtils.filterSpecialChart(StringUtils.sub(detail, 30));
    }
}
