package org.duku.mall.framework.starter.common.modules.good.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.duku.mall.framework.starter.common.modules.good.entity.dos.Specification;
import org.duku.mall.framework.starter.common.modules.good.mapper.SpecificationMapper;
import org.duku.mall.framework.starter.common.modules.good.service.SpecificationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecificationServiceImpl extends ServiceImpl <SpecificationMapper, Specification> implements SpecificationService {
    @Override
    public boolean deleteSpecification(List<String> ids) {
        return false;
    }
}
