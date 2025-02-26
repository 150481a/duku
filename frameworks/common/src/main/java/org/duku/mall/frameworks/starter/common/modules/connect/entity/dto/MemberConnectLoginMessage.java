package org.duku.mall.frameworks.starter.common.modules.connect.entity.dto;

import lombok.Data;

@Data
public class MemberConnectLoginMessage {

    private Member member;
    private ConnectAuthUser connectAuthUser;
}
