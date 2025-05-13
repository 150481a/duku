package org.duku.mall.framework.starter.common.modules.good.service.impl;

import jakarta.servlet.http.HttpServletResponse;
import org.duku.mall.framework.starter.common.modules.good.service.CategoryService;
import org.duku.mall.framework.starter.common.modules.good.service.GoodsImportService;
import org.duku.mall.framework.starter.common.modules.good.service.GoodsService;
import org.duku.mall.framework.starter.common.modules.good.service.GoodsUnitService;
import org.duku.mall.framework.starter.common.modules.store.service.FreightTemplateService;
import org.duku.mall.framework.starter.common.modules.store.service.StoreDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class GoodsImportServiceImpl implements GoodsImportService {

    @Autowired
    private FreightTemplateService freightTemplateService;
    @Autowired
    private StoreDetailService storeDetailService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private GoodsUnitService goodsUnitService;
    @Autowired
    private GoodsService goodsService;

    private  static final int COLUMS = 15;

    @Override
    public void download(HttpServletResponse response) {

    }

    @Override
    public void importExcel(MultipartFile files) throws Exception {

    }
}
