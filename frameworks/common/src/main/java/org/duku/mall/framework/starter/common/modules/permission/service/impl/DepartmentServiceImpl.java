package org.duku.mall.framework.starter.common.modules.permission.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.Data;
import org.duku.mall.framework.starter.common.modules.permission.entity.dos.Department;
import org.duku.mall.framework.starter.common.modules.permission.mapper.DepartmentMapper;
import org.duku.mall.framework.starter.common.modules.permission.service.DepartmentService;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements DepartmentService {
}
