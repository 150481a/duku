package org.duku.mall.framework.starter.common.modules.search.entity.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.duku.mall.framework.starter.common.modules.search.entity.dos.CustomWords;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class CustomWordsVO extends CustomWords {
    private static final long serialVersionUID = 143299060233417009L;

    public CustomWordsVO(String name) {
        this.setName(name);
        this.setDisabled(1);
    }
}
