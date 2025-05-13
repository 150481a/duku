package org.duku.mall.framework.starter.common.modules.wallet.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.duku.mall.framework.starter.common.common.vo.PageVO;
import org.duku.mall.framework.starter.common.modules.order.trade.entity.vo.RechargeQueryVO;
import org.duku.mall.framework.starter.common.modules.wallet.entity.dos.Recharge;
import org.duku.mall.framework.starter.common.modules.wallet.mapper.RechargeMapper;
import org.duku.mall.framework.starter.common.modules.wallet.service.RechargeService;
import org.springframework.stereotype.Service;

@Service
public class RechargeServiceImpl extends ServiceImpl <RechargeMapper, Recharge> implements RechargeService {
    @Override
    public Recharge recharge(Double price) {
        return null;
    }

    @Override
    public IPage<Recharge> rechargePage(PageVO page, RechargeQueryVO rechargeQueryVO) {
        return null;
    }

    @Override
    public void paySuccess(String sn, String receivableNo, String paymentMethod) {

    }

    @Override
    public Recharge getRecharge(String sn) {
        return null;
    }

    @Override
    public void rechargeOrderCancel(String sn) {

    }
}
