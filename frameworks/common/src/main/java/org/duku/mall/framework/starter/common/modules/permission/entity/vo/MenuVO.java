package org.duku.mall.framework.starter.common.modules.permission.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.duku.mall.framework.starter.common.common.utils.BeanUtil;
import org.duku.mall.framework.starter.common.modules.permission.entity.dos.Menu;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Data
public class MenuVO extends Menu {
    @ApiModelProperty(value = "子菜单")
    private List<MenuVO> children = new ArrayList<>();

    public MenuVO() {

    }

    public MenuVO(Menu menu) {
        BeanUtil.copyProperties(menu, this);
    }

    public List<MenuVO> getChildren() {
        if (children != null) {
            children.sort(new Comparator<MenuVO>() {
                @Override
                public int compare(MenuVO o1, MenuVO o2) {
                    return o1.getSortOrder().compareTo(o2.getSortOrder());
                }
            });
            return children;
        }
        return null;
    }
}
