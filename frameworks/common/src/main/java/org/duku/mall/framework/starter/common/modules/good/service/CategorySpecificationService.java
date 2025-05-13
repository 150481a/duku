package org.duku.mall.framework.starter.common.modules.good.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.duku.mall.framework.starter.common.modules.good.entity.dos.CategorySpecification;
import org.duku.mall.framework.starter.common.modules.good.entity.dos.Specification;

import java.util.List;

public interface CategorySpecificationService extends IService<CategorySpecification> {

    /**
     * 根据分类id查询规格信息
     *
     * @param categoryId 分类id
     * @return 分类规格关联信息
     */
    List<Specification> getCategorySpecList(String categoryId);


    /**
     * 通过分类ID删除关联规格
     *
     * @param categoryId 分类ID
     */
    void deleteByCategoryId(String categoryId);
}
