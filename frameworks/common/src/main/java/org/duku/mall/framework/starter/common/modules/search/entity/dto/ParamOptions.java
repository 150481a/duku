package org.duku.mall.framework.starter.common.modules.search.entity.dto;

import lombok.Data;

import java.util.List;

@Data
public class ParamOptions {
    private String key;

    private List<String> values;
}
