package org.duku.mall.framework.starter.common.modules.connect.entity.dto;

import lombok.Data;
import org.duku.mall.framework.starter.common.modules.member.entity.dos.Member;

@Data
public class MemberConnectLoginMessage {

    private Member member;
    private ConnectAuthUser connectAuthUser;
}
