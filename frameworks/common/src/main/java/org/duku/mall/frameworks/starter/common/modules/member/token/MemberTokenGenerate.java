package org.duku.mall.frameworks.starter.common.modules.member.token;

import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.duku.mall.framework.starter.convention.enums.ClientTypeEnum;
import org.duku.mall.framework.starter.convention.enums.UserEnums;
import org.duku.mall.frameworks.starter.common.common.context.ThreadContextHolder;
import org.duku.mall.frameworks.starter.common.common.properties.RocketmqCustomProperties;
import org.duku.mall.frameworks.starter.common.common.security.token.Token;
import org.duku.mall.frameworks.starter.common.common.security.token.TokenUtil;
import org.duku.mall.frameworks.starter.common.common.security.token.base.AbstractTokenGenerate;
import org.duku.mall.frameworks.starter.common.modules.member.entity.dos.Member;
import org.duku.mall.frameworks.starter.common.rocketmq.RocketmqSendCallbackBuilder;
import org.duku.mall.frameworks.starter.common.rocketmq.tags.MemberTagsEnum;
import org.duku.mall.frameworks.starter.user.core.UserInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class MemberTokenGenerate extends AbstractTokenGenerate<Member> {
    @Autowired
    private TokenUtil tokenUtil;
    @Autowired
    private RocketmqCustomProperties rocketmqCustomProperties;

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    @Override
    public Token createToken(Member member, Boolean longTerm) {
        ClientTypeEnum clientTypeEnum;
        try {
            //获取客户端类型
            String clientType = ThreadContextHolder.getHttpRequest().getHeader("clientType");
            //如果客户端为空，则缺省值为PC，pc第三方登录时不会传递此参数
            if (clientType == null) {
                clientTypeEnum = ClientTypeEnum.PC;
            } else {
                clientTypeEnum = ClientTypeEnum.valueOf(clientType);
            }
        } catch (Exception e) {
            clientTypeEnum = ClientTypeEnum.UNKNOWN;
        }
        //记录最后登录时间，客户端类型
        member.setLastLoginDate(new Date());
        member.setClientEnum(clientTypeEnum.name());
        String destination = rocketmqCustomProperties.getMemberTopic() + ":" + MemberTagsEnum.MEMBER_LOGIN.name();
        rocketMQTemplate.asyncSend(destination, member, RocketmqSendCallbackBuilder.commonCallback());

        UserInfoDTO authUser = UserInfoDTO.builder()
                .username(member.getUsername())
                .face(member.getFace())
                .userId(member.getId())
                .role(UserEnums.MEMBER)
                .nickName(member.getNickName())
                .longTerm(longTerm)
                .build();
        //登陆成功生成token
        return tokenUtil.createToken(authUser);
    }

    @Override
    public Token refreshToken(String refreshToken) {
        return tokenUtil.refreshToken(refreshToken);
    }
}
