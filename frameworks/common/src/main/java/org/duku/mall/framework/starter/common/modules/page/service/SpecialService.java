package org.duku.mall.framework.starter.common.modules.page.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.duku.mall.framework.starter.common.modules.page.entity.dos.Special;

public interface SpecialService extends IService<Special> {
    /**
     * 添加专题活动
     * @param special 专题活动
     * @return 专题活动
     */
    Special addSpecial(Special special);

    /**
     * 删除专题活动
     * @param id 活动ID
     * @return 操作状态
     */
    boolean removeSpecial(String id);
}
