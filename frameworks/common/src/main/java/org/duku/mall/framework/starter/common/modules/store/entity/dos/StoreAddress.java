package org.duku.mall.framework.starter.common.modules.store.entity.dos;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.duku.mall.framework.starter.common.mybatis.BaseEntity;

@Data
@TableName("li_store_address")
@ApiModel(value = "店铺自提点")
public class StoreAddress extends BaseEntity {


    @ApiModelProperty(value = "店铺id", hidden = true)
    private String storeId;

    @NotEmpty
    @ApiModelProperty(value = "自提点名称")
    private String addressName;

    @ApiModelProperty(value = "经纬度")
    @NotEmpty
    private String center;

    @ApiModelProperty(value = "地址")
    private String address;

    @ApiModelProperty(value = "电话")
    private String mobile;
}
