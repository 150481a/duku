package org.duku.mall.framework.starter.common.modules.permission.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.duku.mall.framework.starter.common.common.security.token.Token;
import org.duku.mall.framework.starter.common.modules.permission.entity.dos.AdminUser;
import org.duku.mall.framework.starter.common.modules.permission.entity.dto.AdminUserDTO;
import org.duku.mall.framework.starter.common.modules.permission.entity.vo.AdminUserVO;
import org.duku.mall.framework.starter.common.modules.permission.mapper.AdminUserMapper;
import org.duku.mall.framework.starter.common.modules.permission.service.AdminUserService;
import org.duku.mall.framework.starter.convention.enums.UserEnums;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminUserServiceImpl extends ServiceImpl<AdminUserMapper, AdminUser> implements AdminUserService {
    @Override
    public IPage<AdminUserVO> adminUserPage(Page initPage, QueryWrapper<AdminUser> initWrapper) {
        return null;
    }

    @Override
    public AdminUser findByUsername(String username) {
        return null;
    }

    @Override
    public boolean updateAdminUser(AdminUser adminUser, List<String> roles) {
        return false;
    }

    @Override
    public void editPassword(String password, String newPassword) {

    }

    @Override
    public void resetPassword(List<String> ids) {

    }

    @Override
    public void saveAdminUser(AdminUserDTO adminUser, List<String> roles) {

    }

    @Override
    public void deleteCompletely(List<String> ids) {

    }

    @Override
    public Token login(String username, String password) {
        return null;
    }

    @Override
    public Token refreshToken(String refreshToken) {
        return null;
    }

    @Override
    public void logout(UserEnums userEnums) {

    }

    @Override
    public void logout(List<String> adminUserIds) {

    }
}
