package org.duku.mall.framework.starter.common.modules.member.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.duku.mall.framework.starter.common.common.utils.BeanUtil;
import org.duku.mall.framework.starter.common.modules.member.entity.dos.StoreMenu;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Data
public class StoreMenuVO extends StoreMenu {

    @ApiModelProperty(value = "子菜单")
    private List<StoreMenuVO> children = new ArrayList<>();

    public StoreMenuVO() {

    }

    public StoreMenuVO(StoreMenu storeMenu) {
        BeanUtil.copyProperties(storeMenu, this);
    }

    public List<StoreMenuVO> getChildren() {
        if (children != null) {
            children.sort(new Comparator<StoreMenuVO>() {
                @Override
                public int compare(StoreMenuVO o1, StoreMenuVO o2) {
                    return o1.getSortOrder().compareTo(o2.getSortOrder());
                }
            });
            return children;
        }
        return null;
    }
}
