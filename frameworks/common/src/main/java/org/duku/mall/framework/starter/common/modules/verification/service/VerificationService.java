package org.duku.mall.framework.starter.common.modules.verification.service;

import org.duku.mall.framework.starter.common.modules.verification.entity.enums.VerificationEnums;

import java.io.IOException;
import java.util.Map;

public interface VerificationService {

    /**
     * 获取校验对象
     *
     * @param verificationEnums 校验枚举
     * @param uuid              uuid
     * @return 校验对象
     * @throws IOException 校验错误
     */
    Map<String, Object> createVerification(VerificationEnums verificationEnums, String uuid);

    /**
     * 预校验
     *
     * @param xPos              位移距离
     * @param uuid              用户唯一表示
     * @param verificationEnums 校验枚举
     * @return
     */
    boolean preCheck(Integer xPos, String uuid, VerificationEnums verificationEnums);

    /**
     * 验证码校验
     *
     * @param uuid              用户唯一表示
     * @param verificationEnums 校验枚举
     * @return 操作结果
     */
    boolean check(String uuid, VerificationEnums verificationEnums);


    /**
     * 检测是否可以生成验证码
     *
     * @param type    验证码类型
     * @param filePath 文件路径
     */
    Boolean checkCreateVerification(String type, String filePath);
}
