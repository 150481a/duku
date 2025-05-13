package org.duku.mall.framework.starter.common.modules.good.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.duku.mall.framework.starter.common.modules.good.entity.dos.Parameters;

public interface ParametersService extends IService<Parameters> {


    /**
     * 更新参数组信息
     *
     * @param parameters 参数组信息
     * @return 是否更新成功
     */
    boolean updateParameter(Parameters parameters);
}
