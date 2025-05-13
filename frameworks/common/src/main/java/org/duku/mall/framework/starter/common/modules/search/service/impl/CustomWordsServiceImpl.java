package org.duku.mall.framework.starter.common.modules.search.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.duku.mall.framework.starter.common.common.vo.PageVO;
import org.duku.mall.framework.starter.common.modules.search.entity.dos.CustomWords;
import org.duku.mall.framework.starter.common.modules.search.entity.vo.CustomWordsVO;
import org.duku.mall.framework.starter.common.modules.search.mapper.CustomWordsMapper;
import org.duku.mall.framework.starter.common.modules.search.service.CustomWordsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomWordsServiceImpl extends ServiceImpl <CustomWordsMapper, CustomWords> implements CustomWordsService {


    @Override
    public String deploy() {
        return "";
    }

    @Override
    public boolean existWords(String words) {
        return false;
    }

    @Override
    public boolean addCustomWords(CustomWordsVO customWordsVO) {
        return false;
    }

    @Override
    public boolean updateCustomWords(CustomWordsVO customWordsVO) {
        return false;
    }

    @Override
    public boolean deleteCustomWords(String id) {
        return false;
    }

    @Override
    public boolean deleteBathByName(List<String> names) {
        return false;
    }

    @Override
    public long insertBatchCustomWords(List<CustomWords> customWordsList) {
        return 0;
    }

    @Override
    public IPage<CustomWords> getCustomWordsByPage(String words, PageVO pageVo) {
        return null;
    }
}
