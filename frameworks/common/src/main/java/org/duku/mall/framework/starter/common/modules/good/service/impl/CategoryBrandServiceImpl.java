package org.duku.mall.framework.starter.common.modules.good.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.duku.mall.framework.starter.common.modules.good.entity.dos.CategoryBrand;
import org.duku.mall.framework.starter.common.modules.good.entity.vo.CategoryBrandVO;
import org.duku.mall.framework.starter.common.modules.good.mapper.CategoryBrandMapper;
import org.duku.mall.framework.starter.common.modules.good.service.CategoryBrandService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryBrandServiceImpl extends ServiceImpl<CategoryBrandMapper, CategoryBrand> implements CategoryBrandService {
    @Override
    public List<CategoryBrandVO> getCategoryBrandList(String categoryId) {
        return List.of();
    }

    @Override
    public void deleteByCategoryId(String categoryId) {

    }

    @Override
    public List<CategoryBrand> getCategoryBrandListByBrandId(List<String> brandId) {
        return List.of();
    }

    @Override
    public void saveCategoryBrandList(String categoryId, List<String> brandIds) {

    }
}
