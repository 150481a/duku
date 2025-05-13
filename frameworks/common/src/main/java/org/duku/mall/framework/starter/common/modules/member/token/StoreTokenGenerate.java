package org.duku.mall.framework.starter.common.modules.member.token;

import org.duku.mall.framework.starter.convention.enums.ResultCode;
import org.duku.mall.framework.starter.convention.enums.UserEnums;
import org.duku.mall.framework.starter.convention.exception.ServiceException;
import org.duku.mall.framework.starter.cache.CachePrefix;
import org.duku.mall.framework.starter.cache.SingletonCache;
import org.duku.mall.framework.starter.common.common.security.token.Token;
import org.duku.mall.framework.starter.common.common.security.token.TokenUtil;
import org.duku.mall.framework.starter.common.common.security.token.base.AbstractTokenGenerate;
import org.duku.mall.framework.starter.common.modules.member.entity.dos.Member;
import org.duku.mall.framework.starter.common.modules.store.entity.dos.Store;
import org.duku.mall.framework.starter.common.modules.store.service.StoreService;
import org.duku.mall.framework.starter.user.core.UserInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StoreTokenGenerate extends AbstractTokenGenerate<Member> {
    @Autowired
    private StoreService storeService;
    @Autowired
    private TokenUtil tokenUtil;
    @Autowired
    private StoreMenuRoleService storeMenuRoleService;
    @Autowired
    private SingletonCache cache;
    @Autowired
    private ClerkService clerkService;

    @Override
    public Token createToken(Member member, Boolean longTerm) {
        if (Boolean.FALSE.equals(member.getHaveStore())) {
            throw new ServiceException(ResultCode.STORE_NOT_OPEN);
        }
        //根据会员id查询店员信息
        Clerk clerk = clerkService.getClerkByMemberId(member.getId());

        if (clerk == null) {
            throw new ServiceException(ResultCode.CLERK_NOT_FOUND_ERROR);
        }
        if (Boolean.FALSE.equals(clerk.getStatus())) {
            throw new ServiceException(ResultCode.CLERK_DISABLED_ERROR);
        }
        //获取当前用户权限
        List<StoreUserMenuVO> storeUserMenuVOS = storeMenuRoleService.findAllMenu(clerk.getId(), member.getId());
        //缓存权限列表
        cache.put(CachePrefix.PERMISSION_LIST.getPrefix(UserEnums.STORE) + member.getId(), this.permissionList(storeUserMenuVOS));
        //查询店铺信息
        Store store = storeService.getById(clerk.getStoreId());
        if (store == null) {
            throw new ServiceException(ResultCode.STORE_NOT_OPEN);
        }
        //构建对象
        UserInfoDTO authUser = UserInfoDTO.builder()
                .username(member.getUsername())
                .userId(member.getId())
                .role(UserEnums.STORE)
                .nickName(member.getNickName())
                .isSuper(clerk.getIsSuper())
                .clerkId(clerk.getId())
                .face(store.getStoreLogo())
                .storeId(store.getId())
                .storeName(store.getStoreName())
                .longTerm(longTerm)
                .build();
        return tokenUtil.createToken(authUser);
    }

    @Override
    public Token refreshToken(String refreshToken) {
        return null;
    }
}
