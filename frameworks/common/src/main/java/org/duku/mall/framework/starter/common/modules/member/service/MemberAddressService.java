package org.duku.mall.framework.starter.common.modules.member.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.duku.mall.framework.starter.common.common.vo.PageVO;
import org.duku.mall.framework.starter.common.modules.member.entity.dos.MemberAddress;

public interface MemberAddressService extends IService<MemberAddress> {

    /**
     * 根据会员获取会员地址分页列表
     *
     * @param page     分页条件
     * @param memberId 会员ID
     * @return 会员地址分页列表
     */
    IPage<MemberAddress> getAddressByMember(PageVO page, String memberId);

    /**
     * 根据地址ID获取当前会员地址信息
     *
     * @param id 地址ID
     * @return 当前会员的地址信息
     */
    MemberAddress getMemberAddress(String id);

    /**
     * 根据地址ID获取当前会员地址信息
     *
     * @return 当前会员的地址信息
     */
    MemberAddress getDefaultMemberAddress();

    /**
     * 添加会员收货地址
     *
     * @param memberAddress 收货地址
     * @return 操作状态
     */
    MemberAddress saveMemberAddress(MemberAddress memberAddress);

    /**
     * 修改会员收货地址信息
     *
     * @param memberAddress 收货地址
     * @return 操作状态
     */
    MemberAddress updateMemberAddress(MemberAddress memberAddress);

    /**
     * 删除会员收货地址信息
     *
     * @param id 收货地址ID
     * @return 操作状态
     */
    boolean removeMemberAddress(String id);
}
