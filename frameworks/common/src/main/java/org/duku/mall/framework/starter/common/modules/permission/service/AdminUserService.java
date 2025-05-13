package org.duku.mall.framework.starter.common.modules.permission.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.duku.mall.framework.starter.common.common.security.token.Token;
import org.duku.mall.framework.starter.common.modules.permission.entity.dos.AdminUser;
import org.duku.mall.framework.starter.common.modules.permission.entity.dto.AdminUserDTO;
import org.duku.mall.framework.starter.common.modules.permission.entity.vo.AdminUserVO;
import org.duku.mall.framework.starter.convention.enums.UserEnums;
import org.springframework.cache.annotation.CacheConfig;

import java.util.List;

@CacheConfig(cacheNames = "{adminuser}")
public interface AdminUserService extends IService<AdminUser> {


    /**
     * 获取管理员分页
     *
     * @param initPage
     * @param initWrapper
     * @return
     */
    IPage<AdminUserVO> adminUserPage(Page initPage, QueryWrapper<AdminUser> initWrapper);

    /**
     * 通过用户名获取用户
     *
     * @param username
     * @return
     */
    AdminUser findByUsername(String username);


    /**
     * 更新管理员
     *
     * @param adminUser
     * @param roles
     * @return
     */
    boolean updateAdminUser(AdminUser adminUser, List<String> roles);


    /**
     * 修改管理员密码
     *
     * @param password
     * @param newPassword
     */
    void editPassword(String password, String newPassword);

    /**
     * 重置密码
     *
     * @param ids id集合
     */
    void resetPassword(List<String> ids);

    /**
     * 新增管理员
     *
     * @param adminUser
     * @param roles
     */
    void saveAdminUser(AdminUserDTO adminUser, List<String> roles);

    /**
     * 彻底删除
     *
     * @param ids
     */
    void deleteCompletely(List<String> ids);


    /**
     * 用户登录
     *
     * @param username 用户名
     * @param password 密码
     * @return token
     */
    Token login(String username, String password);

    /**
     * 刷新token
     *
     * @param refreshToken
     * @return token
     */
    Token refreshToken(String refreshToken);

    /**
     * 登出
     *
     * @param userEnums token角色类型
     */
    void logout(UserEnums userEnums);

    /**
     * 登出
     *
     * @param adminUserIds 用户id
     */
    void logout(List<String> adminUserIds);
}
