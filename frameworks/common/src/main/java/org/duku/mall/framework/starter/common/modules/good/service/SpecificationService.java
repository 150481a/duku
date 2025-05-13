package org.duku.mall.framework.starter.common.modules.good.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.duku.mall.framework.starter.common.modules.good.entity.dos.Specification;

import java.util.List;

public interface SpecificationService extends IService<Specification> {

    /**
     * 删除规格
     *
     * @param ids 规格ID
     * @return 是否删除成功
     */
    boolean deleteSpecification(List<String> ids);
}
