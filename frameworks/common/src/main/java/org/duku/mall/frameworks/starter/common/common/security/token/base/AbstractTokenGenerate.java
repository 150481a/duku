package org.duku.mall.frameworks.starter.common.common.security.token.base;


import org.duku.mall.frameworks.starter.common.common.security.token.Token;
import org.duku.mall.frameworks.starter.user.core.enums.UserEnums;

public abstract class AbstractTokenGenerate<T> {

    /**
     * 生成token
     *
     * @param user 用户名
     * @param longTerm 是否长时间有效
     * @return TOKEN对象
     */
    public abstract Token createToken(T user, Boolean longTerm);

    /**
     * 刷新token
     *
     * @param refreshToken 刷新token
     * @return token
     */
    public abstract Token refreshToken(String refreshToken);

    /**
     * 默认role
     */
    public UserEnums role = UserEnums.MANAGER;
}
