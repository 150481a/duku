package org.duku.mall.framework.starter.common.modules.system.entity.dos;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.duku.mall.framework.starter.common.mybatis.BaseEntity;

@Data
@TableName("li_service_notice")
@ApiModel(value = "服务订阅消息")
public class ServiceNotice  extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "商家id，为-1时，代表是平台发布的消息")
    private String storeId;

    @ApiModelProperty(value = "banner图")
    private String bannerImage;

    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "副标题")
    private String subTitle;

    @ApiModelProperty(value = "点击跳转（此内容与站内信内容只能有一个生效）")
    private String toUrl;

    @ApiModelProperty(value = "站内信内容(富文本框编辑，可以上传图片的html)")
    private String content;
}
