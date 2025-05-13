package org.duku.mall.framework.starter.common.modules.member.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.duku.mall.framework.starter.common.common.vo.PageVO;
import org.duku.mall.framework.starter.common.modules.member.entity.dos.MemberPointsHistory;
import org.duku.mall.framework.starter.common.modules.member.entity.vo.MemberPointsHistoryVO;

public interface MemberPointsHistoryService extends IService<MemberPointsHistory> {


    /**
     * 获取会员积分VO
     *
     * @param memberId 会员ID
     * @return 会员积分VO
     */
    MemberPointsHistoryVO getMemberPointsHistoryVO(String memberId);

    /**
     * 会员积分历史
     *
     * @param page       分页
     * @param memberId   会员ID
     * @param memberName 会员名称
     * @return 积分历史分页
     */
    IPage<MemberPointsHistory> MemberPointsHistoryList(PageVO page, String memberId, String memberName);

}
