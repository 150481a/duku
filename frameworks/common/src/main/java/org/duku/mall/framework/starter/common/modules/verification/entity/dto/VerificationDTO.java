package org.duku.mall.framework.starter.common.modules.verification.entity.dto;

import lombok.Data;
import org.duku.mall.framework.starter.common.modules.verification.entity.dos.VerificationSource;

import java.io.Serializable;
import java.util.List;

@Data
public class VerificationDTO implements Serializable {
    /**
     * 缓存资源
     */
    List<VerificationSource> verificationResources;

    /**
     * 缓存滑块资源
     */
    List<VerificationSource> verificationSlider;
}
