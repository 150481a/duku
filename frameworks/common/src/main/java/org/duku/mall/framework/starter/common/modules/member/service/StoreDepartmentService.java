package org.duku.mall.framework.starter.common.modules.member.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import org.duku.mall.framework.starter.common.modules.member.entity.dos.StoreDepartment;
import org.duku.mall.framework.starter.common.modules.member.entity.vo.StoreDepartmentVO;

import java.util.List;

public interface StoreDepartmentService extends IService<StoreDepartment> {

    /**
     * 获取部门树
     *
     * @param initWrapper
     * @return
     */
    List<StoreDepartmentVO> tree(QueryWrapper<StoreDepartment> initWrapper);

    /**
     * 删除部门
     *
     * @param ids
     */
    void deleteByIds(List<String> ids);

    /**
     * 更新店铺部门
     *
     * @param storeDepartment 店铺部门
     * @return
     */
    Boolean update(StoreDepartment storeDepartment);
}
