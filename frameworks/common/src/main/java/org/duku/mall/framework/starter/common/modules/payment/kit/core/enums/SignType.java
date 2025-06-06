package org.duku.mall.framework.starter.common.modules.payment.kit.core.enums;

public enum SignType {

    /**
     * HMAC-SHA256 加密
     */
    HMACSHA256("HMAC-SHA256"),
    /**
     * MD5 加密
     */
    MD5("MD5"),
    /**
     * RSA
     */
    RSA("RSA");

    SignType(String type) {
        this.type = type;
    }

    private final String type;

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return type;
    }
}
