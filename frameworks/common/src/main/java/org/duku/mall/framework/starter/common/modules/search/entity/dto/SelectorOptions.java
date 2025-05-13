package org.duku.mall.framework.starter.common.modules.search.entity.dto;

import lombok.Data;

import java.util.List;

@Data
public class SelectorOptions {
    private String name;

    private String value;

    private String url;

    private List<SelectorOptions> otherOptions;
}
