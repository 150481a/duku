package org.duku.mall.framework.starter.common.modules.im.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.duku.mall.framework.starter.common.common.vo.PageVO;
import org.duku.mall.framework.starter.common.modules.im.entity.dos.QA;

public interface QAService extends IService<QA> {

    /**
     * 查询店铺问题
     * @param word
     * @param pageVO
     * @return
     */
    IPage<QA> getStoreQA(String word, PageVO pageVO);
}
