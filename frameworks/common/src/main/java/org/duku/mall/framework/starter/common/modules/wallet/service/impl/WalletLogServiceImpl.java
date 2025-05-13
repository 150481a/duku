package org.duku.mall.framework.starter.common.modules.wallet.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.duku.mall.framework.starter.common.modules.wallet.entity.dos.WalletLog;
import org.duku.mall.framework.starter.common.modules.wallet.service.WalletLogService;
import org.springframework.stereotype.Service;

@Service
public class WalletLogServiceImpl extends ServiceImpl<WalletLogMapper, WalletLog>  implements WalletLogService {
}
