package org.duku.mall.framework.starter.common.modules.order.order.entity.dos;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.duku.mall.framework.starter.convention.enums.PromotionTypeEnum;
import org.duku.mall.framework.starter.distributedid.toolkit.SnowflakeIdUtil;
import org.duku.mall.framework.starter.common.common.utils.BeanUtil;
import org.duku.mall.framework.starter.common.modules.order.cart.entity.dto.TradeDTO;
import org.duku.mall.framework.starter.common.modules.order.cart.entity.vo.CartSkuVO;
import org.duku.mall.framework.starter.common.modules.order.cart.entity.vo.CartVO;
import org.duku.mall.framework.starter.common.modules.order.order.entity.dto.PriceDetailDTO;
import org.duku.mall.framework.starter.common.modules.order.order.entity.enums.CommentStatusEnum;
import org.duku.mall.framework.starter.common.modules.order.order.entity.enums.OrderComplaintStatusEnum;
import org.duku.mall.framework.starter.common.modules.order.order.entity.enums.OrderItemAfterSaleStatusEnum;
import org.duku.mall.framework.starter.common.modules.order.order.entity.enums.RefundStatusEnum;
import org.duku.mall.framework.starter.common.modules.promotion.entity.vos.PromotionSkuVO;
import org.duku.mall.framework.starter.common.mybatis.BaseEntity;

import java.util.stream.Collectors;


@Data
@TableName("li_order_item")
@ApiModel(value = "子订单")
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem extends BaseEntity {
    private static final long serialVersionUID = 2108971190191410182L;

    @ApiModelProperty(value = "订单编号")
    private String orderSn;

    @ApiModelProperty(value = "子订单编号")
    private String sn;

    @ApiModelProperty(value = "单价")
    private Double unitPrice;

    @ApiModelProperty(value = "小记")
    private Double subTotal;

    @ApiModelProperty(value = "商品ID")
    private String goodsId;

    @ApiModelProperty(value = "货品ID")
    private String skuId;

    @ApiModelProperty(value = "销售量")
    private Integer num;

    @ApiModelProperty(value = "交易编号")
    private String tradeSn;

    @ApiModelProperty(value = "图片")
    private String image;

    @ApiModelProperty(value = "商品名称")
    private String goodsName;

    @ApiModelProperty(value = "分类ID")
    private String categoryId;

    @ApiModelProperty(value = "快照id")
    private String snapshotId;

    @ApiModelProperty(value = "规格json")
    private String specs;

    @ApiModelProperty(value = "促销类型")
    private String promotionType;

    @ApiModelProperty(value = "促销id")
    private String promotionId;

    @ApiModelProperty(value = "销售金额")
    private Double goodsPrice;

    @ApiModelProperty(value = "实际金额")
    private Double flowPrice;

    /**
     * @see CommentStatusEnum
     */
    @ApiModelProperty(value = "评论状态:未评论(UNFINISHED),待追评(WAIT_CHASE),评论完成(FINISHED)，")
    private String commentStatus;

    /**
     * @see OrderItemAfterSaleStatusEnum
     */
    @ApiModelProperty(value = "售后状态")
    private String afterSaleStatus;

    @ApiModelProperty(value = "价格详情")
    private String priceDetail;

    /**
     * @see OrderComplaintStatusEnum
     */
    @ApiModelProperty(value = "投诉状态")
    private String complainStatus;

    @ApiModelProperty(value = "交易投诉id")
    private String complainId;

    @ApiModelProperty(value = "退货商品数量")
    private Integer returnGoodsNumber;

    /**
     * @see RefundStatusEnum
     */
    @ApiModelProperty(value = "退款状态")
    private String isRefund;

    @ApiModelProperty(value = "退款金额")
    private Double refundPrice;

    @ApiModelProperty(value = "已发货数量")
    private Integer deliverNumber;

    public Integer getDeliverNumber() {
        if(deliverNumber == null){
            return 0;
        }
        return deliverNumber;
    }

    public OrderItem(CartSkuVO cartSkuVO, CartVO cartVO, TradeDTO tradeDTO) {
        String oldId = this.getId();
        BeanUtil.copyProperties(cartSkuVO.getGoodsSku(), this);
        BeanUtil.copyProperties(cartSkuVO.getPriceDetailDTO(), this);
        BeanUtil.copyProperties(cartSkuVO, this);
        this.setId(oldId);
        if (cartSkuVO.getPriceDetailDTO().getJoinPromotion() != null && !cartSkuVO.getPriceDetailDTO().getJoinPromotion().isEmpty()) {
            this.setPromotionType(CollUtil.join(cartSkuVO.getPriceDetailDTO().getJoinPromotion().stream().map(PromotionSkuVO::getPromotionType).collect(Collectors.toList()), ","));
            this.setPromotionId(CollUtil.join(cartSkuVO.getPriceDetailDTO().getJoinPromotion().stream().map(PromotionSkuVO::getActivityId).collect(Collectors.toList()), ","));
        }
        this.setAfterSaleStatus(OrderItemAfterSaleStatusEnum.NEW.name());
        this.setCommentStatus(CommentStatusEnum.NEW.name());
        this.setComplainStatus(OrderComplaintStatusEnum.NEW.name());
        this.setPriceDetailDTO(cartSkuVO.getPriceDetailDTO());
        this.setOrderSn(cartVO.getSn());
        this.setTradeSn(tradeDTO.getSn());
        this.setImage(cartSkuVO.getGoodsSku().getThumbnail());
        this.setGoodsName(cartSkuVO.getGoodsSku().getGoodsName());
        this.setSkuId(cartSkuVO.getGoodsSku().getId());
        this.setCategoryId(cartSkuVO.getGoodsSku().getCategoryPath().substring(
                cartSkuVO.getGoodsSku().getCategoryPath().lastIndexOf(",") + 1
        ));
        this.setGoodsPrice(cartSkuVO.getGoodsSku().getPrice());
        this.setUnitPrice(cartSkuVO.getPurchasePrice());
        this.setSubTotal(cartSkuVO.getSubTotal());
        this.setSn(SnowflakeIdUtil.createStr("OI"));


    }

    public String getIsRefund() {
        if (isRefund == null) {
            return RefundStatusEnum.NO_REFUND.name();
        }
        return isRefund;
    }

    public double getRefundPrice() {
        if (refundPrice == null) {
            return 0;
        }
        return refundPrice;
    }

    public PriceDetailDTO getPriceDetailDTO() {
        return JSONUtil.toBean(priceDetail, PriceDetailDTO.class);
    }

    public void setPriceDetailDTO(PriceDetailDTO priceDetail) {
        this.priceDetail = JSONUtil.toJsonStr(priceDetail);
    }

    public String getAfterSaleStatus() {
        if (!PromotionTypeEnum.isCanAfterSale(this.promotionType)) {
            return OrderItemAfterSaleStatusEnum.EXPIRED.name();
        }
        return afterSaleStatus;
    }
}
