package org.duku.mall.framework.starter.common.modules.member.entity.vo;

import lombok.Data;
import org.duku.mall.framework.starter.common.common.security.token.Token;
import java.io.Serializable;

@Data
public class QRLoginResultVo implements Serializable {

    private Token token;

    private int status;

}
