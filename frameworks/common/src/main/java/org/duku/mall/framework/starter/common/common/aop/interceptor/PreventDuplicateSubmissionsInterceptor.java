package org.duku.mall.framework.starter.common.common.aop.interceptor;

import cn.hutool.json.JSONUtil;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.duku.mall.framework.starter.convention.exception.ServiceException;
import org.duku.mall.framework.starter.cache.SingletonCache;
import org.duku.mall.framework.starter.common.common.aop.annotation.PreventDuplicateSubmissions;
import org.duku.mall.framework.starter.user.core.UserContext;
import org.duku.mall.framework.starter.user.core.UserInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Component
@Aspect
@Slf4j
public class PreventDuplicateSubmissionsInterceptor {


    @Autowired
    private SingletonCache<String> cache;

    @Before("@annotation(preventDuplicateSubmissions)")
    public void interceptor(PreventDuplicateSubmissions preventDuplicateSubmissions) {

        try {
            String redisKey = getParams(preventDuplicateSubmissions.userIsolation());
            Long count = cache.incr(redisKey, preventDuplicateSubmissions.expire());
            log.debug("防重复提交：params-{},value-{}", redisKey, count);
            //如果超过0或者设置的参数，则表示重复提交了
            if (count.intValue() > 0) {
                throw new ServiceException(ResultCode.LIMIT_ERROR);
            }
        } //如果参数为空，则表示用户未登录，直接略过，不做处理
        catch (NullPointerException e) {
            return;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             
        } catch (ServiceException e) {
            throw e;
        } catch (Exception e) {
            log.error("防重复提交拦截器异常", e);
            throw new ServiceException(ResultCode.ERROR);
        }
    }

    private String getParams(boolean userIsolation) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        StringBuffer sb = new StringBuffer();

        //拼接请求地址
        sb.append(request.getRequestURI());

        //拼接请求参数
        if (!request.getParameterMap().isEmpty()) {
            sb.append(JSONUtil.toJsonStr(request.getParameterMap()));
        }
        //用户隔离设置为开启，则选择当前用回顾
        if (userIsolation) {
            UserInfoDTO currentUser = UserContext.getCurrentUser();
            //用户为空则发出警告，但不拼接，否则拼接用户id
            if (currentUser == null) {
                log.warn("user isolation settings are on,but current user is null");
            }
//           不为空则拼接用户id
            else {
                sb.append(currentUser.getUserId());
            }
        }
        //请求地址
        return sb.toString();


    }


}
