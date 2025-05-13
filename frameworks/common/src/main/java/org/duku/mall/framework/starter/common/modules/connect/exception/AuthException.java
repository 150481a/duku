package org.duku.mall.framework.starter.common.modules.connect.exception;

import org.duku.mall.framework.starter.convention.exception.ServiceException;
import org.duku.mall.framework.starter.common.modules.connect.config.ConnectAuth;
import org.duku.mall.framework.starter.common.modules.connect.entity.enums.AuthResponseStatus;

public class AuthException extends ServiceException {

    private String errorCode;
    private String errorMsg;

    public AuthException(Throwable cause) {
        this(AuthResponseStatus.FAILURE.getCode(), AuthResponseStatus.FAILURE.getMsg());
    }

    public AuthException(String errorMsg) {
        this(AuthResponseStatus.FAILURE.getCode(), errorMsg);
    }

    public AuthException(String errorMsg, ConnectAuth source) {
        this(AuthResponseStatus.FAILURE.getCode(), errorMsg, source);
    }

    public AuthException(String errorCode, String errorMsg) {
        super(errorMsg);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public AuthException(AuthResponseStatus status) {
        this(status.getCode(), status.getMsg());
    }

    public AuthException(String errorCode, String errorMsg, ConnectAuth source) {
        this(errorCode, String.format("%s [%s]", errorMsg, source.getName()));
    }

    public AuthException(AuthResponseStatus status, ConnectAuth source) {
        this(status.getCode(), status.getMsg(), source);
    }

    public AuthException(String message, Throwable cause) {
        super(message, cause);
    }


    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }
}
