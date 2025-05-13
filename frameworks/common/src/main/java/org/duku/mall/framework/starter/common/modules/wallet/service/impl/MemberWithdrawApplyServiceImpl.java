package org.duku.mall.framework.starter.common.modules.wallet.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.duku.mall.framework.starter.common.modules.wallet.entity.dos.MemberWithdrawApply;
import org.duku.mall.framework.starter.common.modules.wallet.mapper.MemberWithdrawApplyMapper;
import org.duku.mall.framework.starter.common.modules.wallet.service.MemberWithdrawApplyService;
import org.springframework.stereotype.Service;

@Service
public class MemberWithdrawApplyServiceImpl extends ServiceImpl<MemberWithdrawApplyMapper, MemberWithdrawApply> implements MemberWithdrawApplyService {
}
