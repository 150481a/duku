package org.duku.mall.framework.starter.common.modules.order.order.aop.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.duku.mall.framework.starter.common.common.utils.SpelUtil;
import org.duku.mall.framework.starter.common.modules.order.order.aop.annotation.OrderLogPoint;
import org.duku.mall.framework.starter.common.modules.order.trade.entity.dos.OrderLog;
import org.duku.mall.framework.starter.common.modules.order.trade.service.OrderLogService;
import org.duku.mall.framework.starter.common.threadpool.build.ThreadPoolBuilder;
import org.duku.mall.framework.starter.convention.enums.UserEnums;
import org.duku.mall.framework.starter.user.core.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Aspect
@Component
@Slf4j
public class OrderOperationLogAspect {

    @Autowired
    private OrderLogService orderLogService;

    @After("@annotation(org.duku.mall.framework.starter.common.modules.order.order.aop.annotation.OrderLogPoint)")
    public void doAfter(JoinPoint joinPoint) {
        try {

            //日志对象拼接
            //默认操作人员，系统操作
            String userName = "系统操作", id = "-1", role = UserEnums.SYSTEM.getRole();
            if (UserContext.getCurrentUser() != null) {
                //日志对象拼接
                userName = UserContext.getCurrentUser().getUsername();
                id = UserContext.getCurrentUser().getUserId();
                role = UserContext.getCurrentUser().getRole().getRole();
            }
            Map<String, String> orderLogPoints = spelFormat(joinPoint);
            OrderLog orderLog = new OrderLog(orderLogPoints.get("orderSn"), id, role, userName, orderLogPoints.get("description"));
            //调用线程保存
            ThreadPoolBuilder.builder().build().execute(new SaveOrderLogThread(orderLog, orderLogService));
        } catch (Exception e) {
            log.error("订单日志错误",e);
        }
    }

    /**
     * 获取注解中对方法的描述信息 用于Controller层注解
     *
     * @param joinPoint 切点
     * @return 方法描述
     * @throws Exception
     */
    private static Map<String, String> spelFormat(JoinPoint joinPoint) throws Exception {

        Map<String, String> result = new HashMap<>(2);
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        OrderLogPoint orderLogPoint = signature.getMethod().getAnnotation(OrderLogPoint.class);
        String description = SpelUtil.compileParams(joinPoint, orderLogPoint.description());
        String orderSn = SpelUtil.compileParams(joinPoint, orderLogPoint.orderSn());

        result.put("description", description);
        result.put("orderSn", orderSn);
        return result;
    }

    /**
     * 保存日志
     */
    private static class SaveOrderLogThread implements Runnable {

        private final OrderLog orderLog;
        private final OrderLogService orderLogService;

        public SaveOrderLogThread(OrderLog orderLog, OrderLogService orderLogService) {
            this.orderLog = orderLog;
            this.orderLogService = orderLogService;
        }

        @Override
        public void run() {
            orderLogService.save(orderLog);
        }
    }
}
