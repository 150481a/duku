package org.duku.mall.framework.starter.common.modules.message.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.duku.mall.framework.starter.common.modules.message.entity.dos.ShortLink;

import java.util.List;

public interface ShortLinkService extends IService<ShortLink> {

    /**
     * 根据模型，查询返回的集合
     *
     * @param shortLink 短链接模型
     * @return 端链接集合
     */
    List<ShortLink> queryShortLinks(ShortLink shortLink);
}
