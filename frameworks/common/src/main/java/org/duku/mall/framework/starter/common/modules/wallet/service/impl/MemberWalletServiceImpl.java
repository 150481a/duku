package org.duku.mall.framework.starter.common.modules.wallet.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.duku.mall.framework.starter.common.modules.member.entity.dos.Member;
import org.duku.mall.framework.starter.common.modules.wallet.entity.dos.MemberWallet;
import org.duku.mall.framework.starter.common.modules.wallet.entity.dto.MemberWalletUpdateDTO;
import org.duku.mall.framework.starter.common.modules.wallet.entity.vo.MemberWalletVO;
import org.duku.mall.framework.starter.common.modules.wallet.mapper.MemberWalletMapper;
import org.duku.mall.framework.starter.common.modules.wallet.service.MemberWalletService;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MemberWalletServiceImpl extends ServiceImpl<MemberWalletMapper, MemberWallet> implements MemberWalletService {
    @Override
    public MemberWalletVO getMemberWallet(String memberId) {
        return null;
    }

    @Override
    public Boolean increase(MemberWalletUpdateDTO memberWalletUpdateDTO) {
        return null;
    }

    @Override
    public Boolean increaseWithdrawal(MemberWalletUpdateDTO memberWalletUpdateDTO) {
        return null;
    }

    @Override
    public Boolean reduce(MemberWalletUpdateDTO memberWalletUpdateDTO) {
        return null;
    }

    @Override
    public Boolean reduceWithdrawal(MemberWalletUpdateDTO memberWalletUpdateDTO) {
        return null;
    }

    @Override
    public Boolean reduceFrozen(MemberWalletUpdateDTO memberWalletUpdateDTO) {
        return null;
    }

    @Override
    public void setMemberWalletPassword(Member member, String password) {

    }

    @Override
    public Boolean checkPassword() {
        return null;
    }

    @Override
    public MemberWallet save(String memberId, String memberName) {
        return null;
    }

    @Override
    public Boolean applyWithdrawal(Double price, String realName, String connectNumber) {
        return null;
    }

    @Override
    public void withdrawal(String withdrawApplyId) {

    }
}
