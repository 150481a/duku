package org.duku.mall.framework.starter.common.modules.good.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.duku.mall.framework.starter.common.modules.good.entity.dos.CategoryBrand;
import org.duku.mall.framework.starter.common.modules.good.entity.vo.CategoryBrandVO;

import java.util.List;

public interface CategoryBrandService extends IService<CategoryBrand> {

    /**
     * 根据分类id查询品牌信息
     *
     * @param categoryId 分类id
     * @return 分类品牌关联信息列表
     */
    List<CategoryBrandVO> getCategoryBrandList(String categoryId);

    /**
     * 通过分类ID删除关联品牌
     *
     * @param categoryId 品牌ID
     */
    void deleteByCategoryId(String categoryId);


    /**
     * 根据品牌ID获取分类品牌关联信息
     *
     * @param brandId 品牌ID
     * @return 分类品牌关联信息
     */
    List<CategoryBrand> getCategoryBrandListByBrandId(List<String> brandId);

    /**
     * 保存分类品牌关系
     *
     * @param categoryId 分类id
     * @param brandIds   品牌ids
     */
    void saveCategoryBrandList(String categoryId, List<String> brandIds);
}
