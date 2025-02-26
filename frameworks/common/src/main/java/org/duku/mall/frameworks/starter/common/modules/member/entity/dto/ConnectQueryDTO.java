package org.duku.mall.frameworks.starter.common.modules.member.entity.dto;

import lombok.Data;
import lombok.Builder;

@Data
@Builder
public class ConnectQueryDTO {

    /**
     * 用户id
     */
    private String userId;

    /**
     * 第三方id
     */
    private String unionId;

    /**
     * 联合登陆类型
     */
    private String unionType;
}
