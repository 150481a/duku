package org.duku.mall.framework.starter.common.modules.im.token;

import org.duku.mall.framework.starter.convention.enums.UserEnums;
import org.duku.mall.framework.starter.common.common.security.token.Token;
import org.duku.mall.framework.starter.common.common.security.token.TokenUtil;
import org.duku.mall.framework.starter.common.common.security.token.base.AbstractTokenGenerate;
import org.duku.mall.framework.starter.common.modules.im.entity.dos.Seat;
import org.duku.mall.framework.starter.user.core.UserInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SeatTokenGenerate extends AbstractTokenGenerate<Seat> {

    @Autowired
    private TokenUtil tokenUtil;

    @Override
    public Token createToken(Seat seat, Boolean longTerm) {
        UserInfoDTO authUser = UserInfoDTO.builder()
                .username(seat.getUsername())
                .userId(seat.getId())
                .nickName(seat.getNickName())
                .face(seat.getFace())
                .role(UserEnums.SEAT)
                .longTerm(longTerm)
                .tenantId(seat.getTenantId())
                .build();

        //登陆成功生成token
        return tokenUtil.createToken(authUser);
    }

    @Override
    public Token refreshToken(String refreshToken) {
        return tokenUtil.refreshToken(refreshToken);
    }
}
