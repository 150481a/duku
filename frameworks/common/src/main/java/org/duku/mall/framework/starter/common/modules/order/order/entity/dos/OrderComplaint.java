package org.duku.mall.framework.starter.common.modules.order.order.entity.dos;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.duku.mall.framework.starter.common.common.security.sensitive.Sensitive;
import org.duku.mall.framework.starter.common.common.security.sensitive.enums.SensitiveStrategy;
import org.duku.mall.framework.starter.common.modules.order.order.entity.enums.OrderComplaintStatusEnum;
import org.duku.mall.framework.starter.common.mybatis.BaseEntity;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
@TableName("li_order_complaint")
@ApiModel(value = "订单交易投诉")
public class OrderComplaint extends BaseEntity {

    private static final long serialVersionUID = 7185050229757228184L;


    @ApiModelProperty(value = "投诉主题")
    private String complainTopic;

    @ApiModelProperty(value = "投诉内容")
    private String content;

    @ApiModelProperty(value = "投诉凭证图片")
    private String images;

    /**
     * @see OrderComplaintStatusEnum
     */
    @ApiModelProperty(value = "交易投诉状态")
    private String complainStatus;

    @ApiModelProperty(value = "申诉商家内容")
    private String appealContent;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "申诉商家时间")
    private Date appealTime;

    @ApiModelProperty(value = "申诉商家上传的图片")
    private String appealImages;

    @ApiModelProperty(value = "订单号")
    private String orderSn;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "下单时间")
    private Date orderTime;

    @ApiModelProperty(value = "商品名称")
    private String goodsName;

    @ApiModelProperty(value = "商品id")
    private String goodsId;

    @ApiModelProperty(value = "sku主键")
    private String skuId;

    @ApiModelProperty(value = "商品价格")
    private Double goodsPrice;

    @ApiModelProperty(value = "商品图片")
    private String goodsImage;

    @ApiModelProperty(value = "购买的商品数量")
    private Integer num;

    @ApiModelProperty(value = "运费")
    private Double freightPrice;

    @ApiModelProperty(value = "订单金额")
    private Double orderPrice;

    @ApiModelProperty(value = "物流单号")
    private String logisticsNo;

    @ApiModelProperty(value = "商家id")
    private String storeId;

    @ApiModelProperty(value = "商家名称")
    private String storeName;

    @ApiModelProperty(value = "会员id")
    private String memberId;

    @ApiModelProperty(value = "会员名称")
    @Sensitive(strategy = SensitiveStrategy.PHONE)
    private String memberName;

    @ApiModelProperty(value = "收货人")
    private String consigneeName;

    @ApiModelProperty(value = "收货地址")
    private String consigneeAddressPath;

    @ApiModelProperty(value = "收货人手机")
    private String consigneeMobile;

    @ApiModelProperty(value = "仲裁结果")
    private String arbitrationResult;
}
