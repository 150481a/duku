package org.duku.mall.framework.starter.common.modules.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.duku.mall.framework.starter.common.modules.system.entity.dos.AppVersion;
import org.duku.mall.framework.starter.common.modules.system.mapper.AppVersionMapper;
import org.duku.mall.framework.starter.common.modules.system.service.AppVersionService;
import org.springframework.stereotype.Service;

@Service
public class AppVersionServiceImpl extends ServiceImpl<AppVersionMapper, AppVersion> implements AppVersionService {
}
