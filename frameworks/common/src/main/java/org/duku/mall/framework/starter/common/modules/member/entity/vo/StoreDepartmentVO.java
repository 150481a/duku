package org.duku.mall.framework.starter.common.modules.member.entity.vo;

import lombok.Data;
import org.duku.mall.framework.starter.common.modules.member.entity.dos.StoreDepartment;
import org.duku.mall.framework.starter.common.common.utils.BeanUtil;
import java.util.ArrayList;
import java.util.List;
@Data
public class StoreDepartmentVO extends StoreDepartment {

    private List<StoreDepartmentVO> children = new ArrayList<>();

    public StoreDepartmentVO() {
    }

    public StoreDepartmentVO(StoreDepartment storeDepartment) {
        BeanUtil.copyProperties(storeDepartment, this);
    }
}
