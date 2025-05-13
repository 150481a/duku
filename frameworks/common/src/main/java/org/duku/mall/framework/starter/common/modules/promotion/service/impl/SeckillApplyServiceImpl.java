package org.duku.mall.framework.starter.common.modules.promotion.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.duku.mall.framework.starter.common.common.vo.PageVO;
import org.duku.mall.framework.starter.common.modules.promotion.entity.dos.Seckill;
import org.duku.mall.framework.starter.common.modules.promotion.entity.dos.SeckillApply;
import org.duku.mall.framework.starter.common.modules.promotion.entity.dto.search.SeckillSearchParams;
import org.duku.mall.framework.starter.common.modules.promotion.entity.vos.SeckillApplyVO;
import org.duku.mall.framework.starter.common.modules.promotion.entity.vos.SeckillGoodsVO;
import org.duku.mall.framework.starter.common.modules.promotion.entity.vos.SeckillTimelineVO;
import org.duku.mall.framework.starter.common.modules.promotion.mapper.SeckillApplyMapper;
import org.duku.mall.framework.starter.common.modules.promotion.service.SeckillApplyService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeckillApplyServiceImpl extends ServiceImpl<SeckillApplyMapper, SeckillApply> implements SeckillApplyService {
    @Override
    public List<SeckillTimelineVO> getSeckillTimeline() {
        return List.of();
    }

    @Override
    public List<SeckillGoodsVO> getSeckillGoods(Integer timeline) {
        return List.of();
    }

    @Override
    public IPage<SeckillApply> getSeckillApplyPage(SeckillSearchParams queryParam, PageVO pageVo) {
        return null;
    }

    @Override
    public List<SeckillApply> getSeckillApplyList(SeckillSearchParams queryParam) {
        return List.of();
    }

    @Override
    public long getSeckillApplyCount(SeckillSearchParams queryParam) {
        return 0;
    }

    @Override
    public SeckillApply getSeckillApply(SeckillSearchParams queryParam) {
        return null;
    }

    @Override
    public void addSeckillApply(String seckillId, String storeId, List<SeckillApplyVO> seckillApplyList) {

    }

    @Override
    public void removeSeckillApply(String seckillId, String id) {

    }

    @Override
    public void updateSeckillApplySaleNum(String seckillId, String skuId, Integer saleNum) {

    }

    @Override
    public boolean updateSeckillApplyTime(Seckill seckill) {
        return false;
    }
}
