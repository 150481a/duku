package org.duku.mall.framework.starter.common.modules.page.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.Data;
import org.duku.mall.framework.starter.common.common.vo.PageVO;
import org.duku.mall.framework.starter.common.modules.page.entity.dos.PageData;
import org.duku.mall.framework.starter.common.modules.page.entity.dto.PageDataDTO;
import org.duku.mall.framework.starter.common.modules.page.entity.vo.PageDataListVO;
import org.duku.mall.framework.starter.common.modules.page.entity.vo.PageDataVO;
import org.duku.mall.framework.starter.common.modules.page.mapper.PageDataMapper;
import org.duku.mall.framework.starter.common.modules.page.service.PageDataService;

@Data
public class PageDataServiceImpl extends ServiceImpl<PageDataMapper, PageData> implements PageDataService {
    @Override
    public void addStorePageData(String storeId) {

    }

    @Override
    public PageData addPageData(PageData pageData) {
        return null;
    }

    @Override
    public PageData updatePageData(PageData pageData) {
        return null;
    }

    @Override
    public PageData releasePageData(String id) {
        return null;
    }

    @Override
    public boolean removePageData(String id) {
        return false;
    }

    @Override
    public PageDataVO getPageData(PageDataDTO pageDataDTO) {
        return null;
    }

    @Override
    public IPage<PageDataListVO> getPageDataList(PageVO pageVO, PageDataDTO pageDataDTO) {
        return null;
    }

    @Override
    public PageData getSpecial(String id) {
        return null;
    }
}
