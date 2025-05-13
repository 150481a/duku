package org.duku.mall.framework.starter.common.modules.good.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.duku.mall.framework.starter.common.common.properties.RocketmqCustomProperties;
import org.duku.mall.framework.starter.common.modules.good.entity.dos.Parameters;
import org.duku.mall.framework.starter.common.modules.good.mapper.ParametersMapper;
import org.duku.mall.framework.starter.common.modules.good.service.GoodsService;
import org.duku.mall.framework.starter.common.modules.good.service.ParametersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParametersServiceImpl extends ServiceImpl <ParametersMapper, Parameters> implements ParametersService {


    @Autowired
    private GoodsService goodsService;

    @Autowired
    private RocketmqCustomProperties rocketmqCustomProperties;

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

}
