package org.duku.mall.framework.starter.common.modules.im.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.duku.mall.framework.starter.common.common.vo.PageVO;
import org.duku.mall.framework.starter.common.modules.im.entity.dos.QA;
import org.duku.mall.framework.starter.common.modules.im.mapper.QAMapper;
import org.duku.mall.framework.starter.common.modules.im.service.QAService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class QAServiceImpl extends ServiceImpl <QAMapper, QA> implements QAService {
    @Override
    public IPage<QA> getStoreQA(String word, PageVO pageVO) {
        return null;
    }
}
