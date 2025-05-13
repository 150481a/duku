package org.duku.mall.framework.starter.common.modules.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.duku.mall.framework.starter.common.modules.system.entity.dos.ServiceNotice;
import org.duku.mall.framework.starter.common.modules.system.mapper.ServiceNoticeMapper;
import org.duku.mall.framework.starter.common.modules.system.service.ServiceNoticeService;
import org.springframework.stereotype.Service;

@Service
public class ServiceNoticeServiceImpl extends ServiceImpl<ServiceNoticeMapper, ServiceNotice> implements ServiceNoticeService {
}
