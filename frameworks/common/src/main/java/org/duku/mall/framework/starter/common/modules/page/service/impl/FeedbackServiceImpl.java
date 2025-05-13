package org.duku.mall.framework.starter.common.modules.page.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.duku.mall.framework.starter.common.modules.page.entity.dos.Feedback;
import org.duku.mall.framework.starter.common.modules.page.mapper.FeedbackMapper;
import org.duku.mall.framework.starter.common.modules.page.service.FeedbackService;
import org.springframework.stereotype.Service;

@Service
public class FeedbackServiceImpl extends ServiceImpl<FeedbackMapper, Feedback> implements FeedbackService {
}
