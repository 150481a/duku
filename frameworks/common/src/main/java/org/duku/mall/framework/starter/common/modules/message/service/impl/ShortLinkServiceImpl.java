package org.duku.mall.framework.starter.common.modules.message.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.duku.mall.framework.starter.common.modules.message.entity.dos.ShortLink;
import org.duku.mall.framework.starter.common.modules.message.mapper.ShortLinkMapper;
import org.duku.mall.framework.starter.common.modules.message.service.ShortLinkService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShortLinkServiceImpl extends ServiceImpl<ShortLinkMapper, ShortLink> implements ShortLinkService {
    @Override
    public List<ShortLink> queryShortLinks(ShortLink shortLink) {
        return List.of();
    }
}
