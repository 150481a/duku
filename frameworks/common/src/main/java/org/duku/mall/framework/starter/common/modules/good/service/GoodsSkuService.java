package org.duku.mall.framework.starter.common.modules.good.service;

import com.alipay.api.domain.Goods;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import jakarta.servlet.http.HttpServletResponse;
import org.duku.mall.framework.starter.cache.CachePrefix;
import org.duku.mall.framework.starter.common.modules.good.entity.dos.GoodsSku;
import org.duku.mall.framework.starter.common.modules.good.entity.dto.GoodsOperationDTO;
import org.duku.mall.framework.starter.common.modules.good.entity.dto.GoodsSkuDTO;
import org.duku.mall.framework.starter.common.modules.good.entity.dto.GoodsSkuStockDTO;
import org.duku.mall.framework.starter.common.modules.good.entity.params.GoodsSearchParams;
import org.duku.mall.framework.starter.common.modules.good.entity.vo.GoodsSkuVO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

public interface GoodsSkuService extends IService<GoodsSku> {

    /**
     * 获取商品SKU缓存ID
     *
     * @param id SkuId
     * @return 商品SKU缓存ID
     */
    static String getCacheKeys(String id) {
        return CachePrefix.GOODS_SKU.getPrefix() + id;
    }

    /**
     * 获取商品SKU库存缓存ID
     *
     * @param id SkuId
     * @return 商品SKU缓存ID
     */
    static String getStockCacheKey(String id) {
        return CachePrefix.SKU_STOCK.getPrefix() + id;
    }

    /**
     * 添加商品sku
     *
     * @param goods             商品信息
     * @param goodsOperationDTO 商品操作信息
     */
    void add(Goods goods, GoodsOperationDTO goodsOperationDTO);

    /**
     * 更新商品sku
     *
     * @param goods             商品信息
     * @param goodsOperationDTO 商品操作信息
     */
    void update(Goods goods, GoodsOperationDTO goodsOperationDTO);

    /**
     * 更新商品sku
     *
     * @param goodsSku sku信息
     */
    void update(GoodsSku goodsSku);

    /**
     * 清除sku缓存
     *
     * @param skuId skuid
     */
    void clearCache(String skuId);

    /**
     * 从redis缓存中获取商品SKU信息
     *
     * @param id SkuId
     * @return 商品SKU信息
     */
    GoodsSku getGoodsSkuByIdFromCache(String id);

    /**
     * 从缓存中获取可参与促销商品
     *
     * @param skuId skuid
     * @return 商品详情
     */
    GoodsSku getCanPromotionGoodsSkuByIdFromCache(String skuId);

    /**
     * 获取商品sku详情
     *
     * @param goodsId 商品ID
     * @param skuId   skuID
     * @return 商品sku详情
     */
    Map<String, Object> getGoodsSkuDetail(String goodsId, String skuId);

    /**
     * 批量从redis中获取商品SKU信息
     *
     * @param ids SkuId集合
     * @return 商品SKU信息集合
     */
    List<GoodsSku> getGoodsSkuByIdFromCache(List<String> ids);

    /**
     * 获取goodsId下所有的goodsSku
     *
     * @param goodsId 商品id
     * @return goodsSku列表
     */
    List<GoodsSkuVO> getGoodsListByGoodsId(String goodsId);

    /**
     * 获取goodsId下所有的goodsSku
     *
     * @param goodsId 商品id
     * @return goodsSku列表
     */
    List<GoodsSku> getGoodsSkuListByGoodsId(String goodsId);

    /**
     * 根据goodsSku组装goodsSkuVO
     *
     * @param list 商品id
     * @return goodsSku列表
     */
    List<GoodsSkuVO> getGoodsSkuVOList(List<GoodsSku> list);

    /**
     * 根据goodsSku组装goodsSkuVO
     *
     * @param goodsSku 商品规格
     * @return goodsSku列表
     */
    GoodsSkuVO getGoodsSkuVO(GoodsSku goodsSku);

    /**
     * 分页查询商品sku信息
     *
     * @param searchParams 查询参数
     * @return 商品sku信息
     */
    IPage<GoodsSku> getGoodsSkuByPage(GoodsSearchParams searchParams);
    /**
     * 查询导出商品库存
     *
     * @param searchParams 查询参数
     * @return 导出商品库存
     */
    void queryExportStock(HttpServletResponse response, GoodsSearchParams searchParams);

    /**
     * 导入商品库存
     * @param storeId 店铺ID
     * @param files 文件
     */
    void importStock(String storeId, MultipartFile files);

    /**
     * 分页查询商品sku信息
     *
     * @param page         分页参数
     * @param queryWrapper 查询参数
     * @return 商品sku信息
     */
    IPage<GoodsSkuDTO> getGoodsSkuDTOByPage(Page<GoodsSkuDTO> page, Wrapper<GoodsSkuDTO> queryWrapper);

    /**
     * 列表查询商品sku信息
     *
     * @param searchParams 查询参数
     * @return 商品sku信息
     */
    List<GoodsSku> getGoodsSkuByList(GoodsSearchParams searchParams);

    /**
     * 更新商品sku状态
     *
     * @param goods 商品信息(Id,MarketEnable/AuthFlag)
     */
    void updateGoodsSkuStatus(Goods goods);

    /**
     * 更新商品sku状态根据店铺id
     *
     * @param storeId      店铺id
     * @param marketEnable 市场启用状态
     * @param authFlag     审核状态
     */
    void updateGoodsSkuStatusByStoreId(String storeId, String marketEnable, String authFlag);

    /**
     * 更新SKU库存
     *
     * @param goodsSkuStockDTOS sku库存修改实体
     */
    void updateStocks(List<GoodsSkuStockDTO> goodsSkuStockDTOS);
    void updateStocksByType(List<GoodsSkuStockDTO> goodsSkuStockDTOS);

    /**
     * 更新SKU预警库存
     * @param goodsSkuStockDTOS sku库存修改实体
     */
    void batchUpdateAlertQuantity(List<GoodsSkuStockDTO> goodsSkuStockDTOS);

    /**
     * 更新SKU预警库存
     * @param goodsSkuStockDTO sku库存修改实体
     */
    void updateAlertQuantity(GoodsSkuStockDTO goodsSkuStockDTO);

    /**
     * 更新SKU库存
     *
     * @param skuId    SKUId
     * @param quantity 设置的库存数量
     */
    void updateStock(String skuId, Integer quantity);
    void updateStock(String skuId, Integer quantity,String type);

    /**
     * 获取商品sku库存
     *
     * @param skuId 商品skuId
     * @return 库存数量
     */
    Integer getStock(String skuId);

    /**
     * 修改商品库存字段
     *
     * @param goodsSkus
     */
    void updateGoodsStock(List<GoodsSku> goodsSkus);

    /**
     * 根据商品id获取全部skuId的集合
     *
     * @param goodsId goodsId
     * @return 全部skuId的集合
     */
    List<String> getSkuIdsByGoodsId(String goodsId);

    /**
     * 删除并且新增sku，即覆盖之前信息
     *
     * @param goodsSkus 商品sku集合
     * @return
     */
    boolean deleteAndInsertGoodsSkus(List<GoodsSku> goodsSkus);

    /**
     * 统计sku总数
     *
     * @param storeId 店铺id
     * @return sku总数
     */
    Long countSkuNum(String storeId);

    /**
     * 批量渲染商品sku
     *
     * @param goodsSkuList SKU基础数据列表
     * @param goodsOperationDTO 商品操作信息
     */
    void renderGoodsSkuList(List<GoodsSku> goodsSkuList, GoodsOperationDTO goodsOperationDTO);

    /**
     * 更新商品sku购买数量
     *
     * @param skuId   skuId
     * @param buyCount 购买数量
     */
    void updateGoodsSkuBuyCount(String skuId, int buyCount);

    /**
     * 更新商品sku评分
     *
     * @param goodsId goodsId
     * @param grade   评分
     * @param commentNum 评论数量
     */
    void updateGoodsSkuGrade(String goodsId, double grade,int commentNum);

    /**
     * 获取最新商品库存
     *
     * @param goodsId 商品ID
     * @return 库存数量
     */
    Integer getGoodsStock(String goodsId);

    /**
     * 更新sku运费模版
     *
     * @param goodsId 商品id
     * @param templateId 运费模版id
     * @return 操作结果
     */
    Boolean freight(List<String> goodsId, String templateId);
}
