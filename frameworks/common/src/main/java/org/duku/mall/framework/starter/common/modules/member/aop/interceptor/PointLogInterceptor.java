package org.duku.mall.framework.starter.common.modules.member.aop.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.duku.mall.framework.starter.common.modules.member.entity.dos.Member;
import org.duku.mall.framework.starter.common.modules.member.entity.dos.MemberPointsHistory;
import org.duku.mall.framework.starter.common.modules.member.entity.enums.PointTypeEnum;
import org.duku.mall.framework.starter.common.modules.member.service.MemberPointsHistoryService;
import org.duku.mall.framework.starter.common.modules.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class PointLogInterceptor {

    @Autowired
    private MemberPointsHistoryService memberPointsHistoryService;

    @Autowired
    private MemberService memberService;

    @After("@annotation(org.duku.mall.framework.starter.common.modules.member.aop.annotation.PointLogPoint)")
    public void doAfter(JoinPoint pjp) {
        //参数
        Object[] obj = pjp.getArgs();
        try {
            //变动积分
            Long point = 0L;
            if (obj[0] != null) {
                point = Long.valueOf(obj[0].toString());
            }
            //变动类型
            String type = PointTypeEnum.INCREASE.name();
            if (obj[1] != null) {
                type = obj[1].toString();
            }
            // 会员ID
            String memberId = "";
            if (obj[2] != null) {
                memberId = obj[2].toString();
            }
            // 变动积分为0，则直接返回
            if (point == 0) {
                return;
            }

            //根据会员id查询会员信息
            Member member = memberService.getById(memberId);
            if (member != null) {
                MemberPointsHistory memberPointsHistory = new MemberPointsHistory();
                memberPointsHistory.setMemberId(member.getId());
                memberPointsHistory.setMemberName(member.getUsername());
                memberPointsHistory.setPointType(type);

                memberPointsHistory.setVariablePoint(point);
                if (type.equals(PointTypeEnum.INCREASE.name())) {
                    memberPointsHistory.setBeforePoint(member.getPoint() - point);
                } else {
                    memberPointsHistory.setBeforePoint(member.getPoint() + point);
                }

                memberPointsHistory.setPoint(member.getPoint());
                memberPointsHistory.setContent(obj[3] == null ? "" : obj[3].toString());
                memberPointsHistory.setCreateBy("系统");
                memberPointsHistoryService.save(memberPointsHistory);
            }
        } catch (Exception e) {
            log.error("积分操作错误", e);
        }


    }
}
