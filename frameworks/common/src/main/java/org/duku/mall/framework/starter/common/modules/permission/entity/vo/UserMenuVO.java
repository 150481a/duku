package org.duku.mall.framework.starter.common.modules.permission.entity.vo;

import lombok.Data;
import org.duku.mall.framework.starter.common.modules.permission.entity.dos.Menu;

@Data
public class UserMenuVO extends Menu {
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
