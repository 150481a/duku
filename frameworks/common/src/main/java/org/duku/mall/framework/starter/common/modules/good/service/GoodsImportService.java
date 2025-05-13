package org.duku.mall.framework.starter.common.modules.good.service;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.multipart.MultipartFile;

public interface GoodsImportService {


    /**
     * 下载导入列表
     * @param response
     */
    void download(HttpServletResponse response);

    /**
     * 导入商品
     */
    void importExcel(MultipartFile files) throws Exception;
}
