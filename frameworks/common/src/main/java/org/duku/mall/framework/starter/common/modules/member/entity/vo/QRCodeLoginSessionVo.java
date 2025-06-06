package org.duku.mall.framework.starter.common.modules.member.entity.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class QRCodeLoginSessionVo implements Serializable {

    private static final long serialVersionUID = 8793639296995408322L;

    private String token;

    private Integer status;

    private long duration;

    private long userId;
}
