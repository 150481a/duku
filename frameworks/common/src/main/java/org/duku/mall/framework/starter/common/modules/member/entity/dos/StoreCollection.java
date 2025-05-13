package org.duku.mall.framework.starter.common.modules.member.entity.dos;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.duku.mall.framework.starter.common.mybatis.BaseEntity;

@Data
@TableName("li_store_collection")
@ApiModel(value = "会员收藏")
@NoArgsConstructor
@AllArgsConstructor
public class StoreCollection extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "会员id")
    private String memberId;

    @ApiModelProperty(value = "店铺id")
    private String storeId;
}
