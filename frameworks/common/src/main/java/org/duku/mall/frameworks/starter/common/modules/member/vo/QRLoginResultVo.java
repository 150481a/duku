package org.duku.mall.frameworks.starter.common.modules.member.vo;

import lombok.Data;
import org.duku.mall.frameworks.starter.common.common.security.token.Token;
import java.io.Serializable;

@Data
public class QRLoginResultVo implements Serializable {

    private Token token;

    private int status;

}
