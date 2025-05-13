package org.duku.mall.framework.starter.common.modules.search.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.duku.mall.framework.starter.common.modules.search.entity.dos.HotWordsHistory;
import org.duku.mall.framework.starter.common.modules.search.mapper.HotWordsHistoryMapper;
import org.duku.mall.framework.starter.common.modules.search.service.HotWordsHistoryService;
import org.springframework.stereotype.Service;

@Service
public class HotWordsHistoryServiceImpl extends ServiceImpl<HotWordsHistoryMapper, HotWordsHistory> implements HotWordsHistoryService {
}
