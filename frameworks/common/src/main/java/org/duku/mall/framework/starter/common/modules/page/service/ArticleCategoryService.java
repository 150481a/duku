package org.duku.mall.framework.starter.common.modules.page.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.duku.mall.framework.starter.common.modules.page.entity.dos.ArticleCategory;
import org.duku.mall.framework.starter.common.modules.page.entity.vo.ArticleCategoryVO;

import java.util.List;

public interface ArticleCategoryService extends IService<ArticleCategory> {

    /**
     * 添加文章分类
     *
     * @param articleCategory 文章分类
     * @return 文章分类
     */
    ArticleCategory saveArticleCategory(ArticleCategory articleCategory);

    /**
     * 修改文章分类
     *
     * @param articleCategory 文章分类
     * @return 文章分类
     */
    ArticleCategory updateArticleCategory(ArticleCategory articleCategory);

    /**
     * 查询所有的分类，父子关系
     *
     * @return 文章分类
     */
    List<ArticleCategoryVO> allChildren();

    /**
     * 删除文章分类
     *
     * @param id 文章分类id
     * @return 操作状态
     */
    boolean deleteById(String id);
}
