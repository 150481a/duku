package org.duku.mall.framework.starter.common.modules.search.service.impl;

import org.duku.mall.framework.starter.common.modules.search.entity.dos.HotWordsHistory;
import org.duku.mall.framework.starter.common.modules.search.entity.dto.HotWordsDTO;
import org.duku.mall.framework.starter.common.modules.search.service.HotWordsService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class HotWordsServiceImpl implements HotWordsService {
    @Override
    public List<String> getHotWords(Integer count) {
        return List.of();
    }

    @Override
    public List<HotWordsHistory> getHotWordsVO(Integer count) {
        return List.of();
    }

    @Override
    public void setHotWords(HotWordsDTO hotWords) {

    }

    @Override
    public void deleteHotWords(String keywords) {

    }
}
