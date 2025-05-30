package org.duku.mall.framework.starter.common.modules.good.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.duku.mall.framework.starter.common.common.vo.PageVO;
import org.duku.mall.framework.starter.common.modules.good.entity.dos.Commodity;
import org.duku.mall.framework.starter.common.modules.good.entity.vo.CommodityVO;

import java.util.List;

public interface CommodityService extends IService<Commodity> {

    /**
     * 添加直播商品
     * @param commodity 直播商品列表
     * @return 添加结果
     */
    boolean addCommodity(List<Commodity> commodity);

    /**
     * 删除直播商品
     * @param goodsId 直播商品ID
     * @return 删除结果
     */
    boolean deleteCommodity(String goodsId);

    /**
     * 查询微信小程序直播商品审核状态
     */
    void getGoodsWareHouse();

    /**
     * 查看直播商品分页
     * @param pageVO 分页
     * @param name 商品名称
     * @param auditStatus 审核状态
     * @return 直播商品分页
     */
    IPage<CommodityVO> commodityList(PageVO pageVO, String name, String auditStatus);

    List<Commodity> getCommodityByRoomId(Integer roomId);

    List<String> getSimpleCommodityByRoomId(Integer roomId);
}
