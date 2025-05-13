package org.duku.mall.framework.starter.common.modules.good.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.duku.mall.framework.starter.common.modules.good.entity.dos.Brand;
import org.duku.mall.framework.starter.common.modules.good.entity.dto.BrandPageDTO;
import org.duku.mall.framework.starter.common.modules.good.entity.vo.BrandVO;
import org.duku.mall.framework.starter.common.modules.good.mapper.BrandMapper;
import org.duku.mall.framework.starter.common.modules.good.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class BrandServiceImpl extends ServiceImpl<BrandMapper, Brand> implements BrandService {

    /**
     * 分类品牌绑定
     */
    @Autowired
    private CategoryBrandService categoryBrandService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private GoodsService goodsService;

    @Override
    public IPage<Brand> getBrandsByPage(BrandPageDTO page) {
        return null;
    }

    @Override
    public void deleteBrands(List<String> ids) {

    }

    @Override
    public List<Brand> getBrandsByCategory(String categoryId) {
        return List.of();
    }

    @Override
    public List<Map<String, Object>> getBrandsMapsByCategory(List<String> categoryIds, String columns) {
        return List.of();
    }

    @Override
    public boolean addBrand(BrandVO brandVO) {
        return false;
    }

    @Override
    public boolean updateBrand(BrandVO brandVO) {
        return false;
    }

    @Override
    public boolean brandDisable(String brandId, boolean disable) {
        return false;
    }
}
