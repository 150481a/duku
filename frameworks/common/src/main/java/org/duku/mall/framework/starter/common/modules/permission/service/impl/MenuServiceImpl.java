package org.duku.mall.framework.starter.common.modules.permission.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.duku.mall.framework.starter.common.modules.permission.entity.dos.Menu;
import org.duku.mall.framework.starter.common.modules.permission.entity.dto.MenuSearchParams;
import org.duku.mall.framework.starter.common.modules.permission.entity.vo.MenuVO;
import org.duku.mall.framework.starter.common.modules.permission.entity.vo.UserMenuVO;
import org.duku.mall.framework.starter.common.modules.permission.mapper.MenuMapper;
import org.duku.mall.framework.starter.common.modules.permission.service.MenuService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {
    @Override
    public List<MenuVO> findUserTree() {
        return List.of();
    }

    @Override
    public List<Menu> findUserList(String userId) {
        return List.of();
    }

    @Override
    public List<Menu> findByRoleIds(String roleIds) {
        return List.of();
    }

    @Override
    public List<MenuVO> tree() {
        return List.of();
    }

    @Override
    public List<Menu> searchList(MenuSearchParams menuSearchParams) {
        return List.of();
    }

    @Override
    public void deleteIds(List<String> ids) {

    }

    @Override
    public boolean saveOrUpdateMenu(Menu menu) {
        return false;
    }

    @Override
    public List<UserMenuVO> findAllMenu(String userId) {
        return List.of();
    }
}
