package org.duku.mall.framework.starter.common.modules.system.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Traces {

    /**
     * 物流公司
     */
    private String shipper;

    /**
     * 物流单号
     */
    private String logisticCode;

    /**
     * 物流详细信息
     */
    private List<Map> traces;
}
