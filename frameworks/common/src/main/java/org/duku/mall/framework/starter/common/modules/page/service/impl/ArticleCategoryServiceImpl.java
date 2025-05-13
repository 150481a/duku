package org.duku.mall.framework.starter.common.modules.page.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.duku.mall.framework.starter.common.modules.page.entity.dos.ArticleCategory;
import org.duku.mall.framework.starter.common.modules.page.entity.vo.ArticleCategoryVO;
import org.duku.mall.framework.starter.common.modules.page.mapper.ArticleCategoryMapper;
import org.duku.mall.framework.starter.common.modules.page.service.ArticleCategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleCategoryServiceImpl extends ServiceImpl<ArticleCategoryMapper, ArticleCategory> implements ArticleCategoryService {
    @Override
    public ArticleCategory saveArticleCategory(ArticleCategory articleCategory) {
        return null;
    }

    @Override
    public ArticleCategory updateArticleCategory(ArticleCategory articleCategory) {
        return null;
    }

    @Override
    public List<ArticleCategoryVO> allChildren() {
        return List.of();
    }

    @Override
    public boolean deleteById(String id) {
        return false;
    }
}
