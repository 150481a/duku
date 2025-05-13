package org.duku.mall.framework.starter.common.modules.good.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.duku.mall.framework.starter.common.modules.good.entity.dos.CategorySpecification;
import org.duku.mall.framework.starter.common.modules.good.entity.dos.Specification;
import org.duku.mall.framework.starter.common.modules.good.mapper.CategorySpecificationMapper;
import org.duku.mall.framework.starter.common.modules.good.service.CategorySpecificationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorySpecificationServiceImpl extends ServiceImpl<CategorySpecificationMapper, CategorySpecification> implements CategorySpecificationService {
    @Override
    public List<Specification> getCategorySpecList(String categoryId) {
        return List.of();
    }

    @Override
    public void deleteByCategoryId(String categoryId) {

    }
}
