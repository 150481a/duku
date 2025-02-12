package org.duku.mall.framework.starter.convention.page;

import lombok.Data;

/**
 * 分页请求参数
 * 防腐层返回
 */
@Data
public class PageRequest {

    /**
     * 当前页
     */
    private Long current = 1L;

    /**
     * 每页显示条数
     */
    private Long size = 10L;
}
