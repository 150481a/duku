package org.duku.mall.framework.starter.common.modules.good.entity.dos;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.duku.mall.framework.starter.common.mybatis.BaseEntity;

@Data
@TableName("li_goods_unit")
@ApiModel(value = "商品计量单位")
public class GoodsUnit extends BaseEntity {

    @NotEmpty(message = "计量单位名称不能为空")
    @Size(max = 5, message = "计量单位长度最大为5")
    @ApiModelProperty(value = "计量单位名称")
    private String name;
}
