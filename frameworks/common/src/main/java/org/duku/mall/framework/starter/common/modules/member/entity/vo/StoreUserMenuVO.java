package org.duku.mall.framework.starter.common.modules.member.entity.vo;

import lombok.Data;
import org.duku.mall.framework.starter.common.modules.member.entity.dos.StoreMenu;

@Data
public class StoreUserMenuVO extends StoreMenu {

    private static final long serialVersionUID = -7478870595109016162L;

    /**
     * 是否是超级管理员
     */
    private Boolean isSuper;

    public Boolean getSuper() {
        if (this.isSuper == null) {
            return false;
        }
        return isSuper;
    }
}
