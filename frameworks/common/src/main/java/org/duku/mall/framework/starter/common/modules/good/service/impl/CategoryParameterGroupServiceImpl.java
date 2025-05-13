package org.duku.mall.framework.starter.common.modules.good.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.duku.mall.framework.starter.common.modules.good.entity.dos.CategoryParameterGroup;
import org.duku.mall.framework.starter.common.modules.good.entity.vo.ParameterGroupVO;
import org.duku.mall.framework.starter.common.modules.good.mapper.CategoryParameterGroupMapper;
import org.duku.mall.framework.starter.common.modules.good.service.CategoryParameterGroupService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryParameterGroupServiceImpl extends ServiceImpl <CategoryParameterGroupMapper, CategoryParameterGroup> implements CategoryParameterGroupService {
    @Override
    public List<ParameterGroupVO> getCategoryParams(String categoryId) {
        return List.of();
    }

    @Override
    public List<CategoryParameterGroup> getCategoryGroup(String categoryId) {
        return List.of();
    }

    @Override
    public boolean updateCategoryGroup(CategoryParameterGroup categoryParameterGroup) {
        return false;
    }

    @Override
    public void deleteByCategoryId(String categoryId) {

    }
}
