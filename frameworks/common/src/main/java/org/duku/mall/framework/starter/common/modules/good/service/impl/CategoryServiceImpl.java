package org.duku.mall.framework.starter.common.modules.good.service.impl;

import com.alipay.api.domain.CategoryVO;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.duku.mall.framework.starter.cache.SingletonCache;
import org.duku.mall.framework.starter.common.common.properties.RocketmqCustomProperties;
import org.duku.mall.framework.starter.common.modules.good.entity.dos.Category;
import org.duku.mall.framework.starter.common.modules.good.entity.params.CategorySearchParams;
import org.duku.mall.framework.starter.common.modules.good.mapper.CategoryMapper;
import org.duku.mall.framework.starter.common.modules.good.service.CategoryBrandService;
import org.duku.mall.framework.starter.common.modules.good.service.CategoryParameterGroupService;
import org.duku.mall.framework.starter.common.modules.good.service.CategoryService;
import org.duku.mall.framework.starter.common.modules.good.service.CategorySpecificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@CacheConfig(cacheNames = "{CATEGORY}")
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {
    private static final String DELETE_FLAG_COLUMN = "delete_flag";
    /**
     * 缓存
     */
    @Autowired
    private SingletonCache cache;

    @Autowired
    private CategoryBrandService categoryBrandService;

    @Autowired
    private CategoryParameterGroupService categoryParameterGroupService;

    @Autowired
    private CategorySpecificationService categorySpecificationService;

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    /**
     * rocketMq
     */
    @Autowired
    private RocketMQTemplate rocketMQTemplate;
    /**
     * rocketMq配置
     */
    @Autowired
    private RocketmqCustomProperties rocketmqCustomProperties;

    @Override
    public List<Category> dbList(String parentId) {
        return List.of();
    }

    @Override
    public Category getCategoryById(String id) {
        return null;
    }

    @Override
    public List<Category> listByIdsOrderByLevel(List<String> ids) {
        return List.of();
    }

    @Override
    public List<Map<String, Object>> listMapsByIdsOrderByLevel(List<String> ids, String columns) {
        return List.of();
    }

    @Override
    public List<CategoryVO> categoryTree() {
        return List.of();
    }

    @Override
    public List<CategoryVO> listAllChildren(String parentId) {
        return List.of();
    }

    @Override
    public List<CategoryVO> listAllChildren(CategorySearchParams categorySearchParams) {
        return List.of();
    }

    @Override
    public List<String> getCategoryNameByIds(List<String> ids) {
        return List.of();
    }

    @Override
    public List<Category> findByAllBySortOrder(Category category) {
        return List.of();
    }

    @Override
    public boolean saveCategory(Category category) {
        return false;
    }

    @Override
    public void updateCategory(Category category) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public void updateCategoryStatus(String categoryId, Boolean enableOperations) {

    }

    @Override
    public List<CategoryVO> getStoreCategory(String[] categories) {
        return List.of();
    }

    @Override
    public List<Category> firstCategory() {
        return List.of();
    }
}
