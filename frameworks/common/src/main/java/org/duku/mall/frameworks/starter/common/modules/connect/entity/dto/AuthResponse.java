package org.duku.mall.frameworks.starter.common.modules.connect.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.duku.mall.frameworks.starter.common.modules.connect.entity.enums.AuthResponseStatus;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponse<T> implements Serializable {
    private static final long serialVersionUID = 7668539215757528636L;
    /**
     * 授权响应状态码
     */
    private String code;

    /**
     * 授权响应信息
     */
    private String msg;

    /**
     * 授权响应数据，当且仅当 code = 2000 时返回
     */
    private T data;

    /**
     * 是否请求成功
     *
     * @return true or false
     */
    public boolean ok() {
        return this.code .equals( AuthResponseStatus.SUCCESS.getCode());
    }
}
