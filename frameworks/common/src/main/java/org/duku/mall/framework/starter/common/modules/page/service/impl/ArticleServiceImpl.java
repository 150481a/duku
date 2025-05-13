package org.duku.mall.framework.starter.common.modules.page.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.duku.mall.framework.starter.common.modules.page.entity.dos.Article;
import org.duku.mall.framework.starter.common.modules.page.entity.params.ArticleSearchParams;
import org.duku.mall.framework.starter.common.modules.page.entity.vo.ArticleVO;
import org.duku.mall.framework.starter.common.modules.page.mapper.ArticleMapper;
import org.duku.mall.framework.starter.common.modules.page.service.ArticleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {
    @Override
    public IPage<ArticleVO> managerArticlePage(ArticleSearchParams articleSearchParams) {
        return null;
    }

    @Override
    public IPage<ArticleVO> articlePage(ArticleSearchParams articleSearchParams) {
        return null;
    }

    @Override
    public List<Article> list(String categoryId) {
        return List.of();
    }

    @Override
    public Article updateArticle(Article article) {
        return null;
    }

    @Override
    public void customRemove(String id) {

    }

    @Override
    public Article customGet(String id) {
        return null;
    }

    @Override
    public Article customGetByType(String type) {
        return null;
    }

    @Override
    public Boolean updateArticleStatus(String id, boolean status) {
        return null;
    }

    @Override
    public Article updateArticleType(Article article) {
        return null;
    }
}
