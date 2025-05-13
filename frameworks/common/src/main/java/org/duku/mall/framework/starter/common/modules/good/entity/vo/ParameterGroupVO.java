package org.duku.mall.framework.starter.common.modules.good.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.duku.mall.framework.starter.common.modules.good.entity.dos.Parameters;
import java.io.Serializable;
import java.util.List;

@Data
public class ParameterGroupVO  implements Serializable {
    private static final long serialVersionUID = 724427321881170297L;
    @ApiModelProperty("参数组关联的参数集合")
    private List<Parameters> params;
    @ApiModelProperty(value = "参数组名称")
    private String groupName;
    @ApiModelProperty(value = "参数组id")
    private String groupId;
}
