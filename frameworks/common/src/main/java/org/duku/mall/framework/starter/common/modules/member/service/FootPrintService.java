package org.duku.mall.framework.starter.common.modules.member.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.duku.mall.framework.starter.common.modules.member.entity.dos.FootPrint;
import org.duku.mall.framework.starter.common.modules.member.entity.params.FootPrintQueryParams;
import org.duku.mall.framework.starter.common.modules.search.entity.dos.EsGoodsIndex;

import java.util.List;

public interface FootPrintService extends IService<FootPrint> {

    /**
     * 保存浏览历史
     *
     * @param footPrint 用户足迹
     * @return 浏览历史
     */
    FootPrint saveFootprint(FootPrint footPrint);

    /**
     * 清空当前会员的足迹
     *
     * @return 处理结果
     */
    boolean clean();

    /**
     * 根据ID进行清除会员的历史足迹
     *
     * @param ids 商品ID列表
     * @return 处理结果
     */
    boolean deleteByIds(List<String> ids);

    /**
     * 获取会员浏览历史分页
     *
     * @param params 分页
     * @return 会员浏览历史列表
     */
    IPage<EsGoodsIndex> footPrintPage(FootPrintQueryParams params);

    /**
     * 获取当前会员的浏览记录数量
     *
     * @return 当前会员的浏览记录数量
     */
    long getFootprintNum();
}
