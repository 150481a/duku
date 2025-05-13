package org.duku.mall.framework.starter.common.modules.good.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.duku.mall.framework.starter.common.modules.good.entity.dos.GoodsWords;
import org.duku.mall.framework.starter.common.modules.good.mapper.GoodsWordsMapper;
import org.duku.mall.framework.starter.common.modules.good.service.GoodsWordsService;
import org.springframework.stereotype.Service;

@Service
public class GoodsWordsServiceImpl extends ServiceImpl <GoodsWordsMapper, GoodsWords> implements GoodsWordsService {
}
