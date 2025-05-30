package org.duku.mall.framework.starter.common.modules.search.service;

import org.duku.mall.framework.starter.common.modules.search.entity.dos.HotWordsHistory;
import org.duku.mall.framework.starter.common.modules.search.entity.dto.HotWordsDTO;

import java.util.List;

public interface HotWordsService {

    /**
     * 获取热门关键词
     *
     * @param count 热词数量
     * @return 热词集合
     */
    List<String> getHotWords(Integer count);

    /**
     * 获取热门关键词
     *
     * @param count 热词数量
     * @return 热词集合
     */
    List<HotWordsHistory> getHotWordsVO(Integer count);

    /**
     * 设置热门关键词
     *
     * @param hotWords 热词分数
     */
    void setHotWords(HotWordsDTO hotWords);

    /**
     * 删除热门关键词
     *
     * @param keywords 热词
     */
    void deleteHotWords(String keywords);

}
