package org.duku.mall.framework.starter.convention.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.duku.mall.framework.starter.convention.errorcode.BaseErrorCode;
import org.duku.mall.framework.starter.convention.errorcode.IErrorCode;

/**
 * 如需异常重试，则抛出此异常
 *
 * @author paulG
 * @since 2022/4/26
 **/
@EqualsAndHashCode(callSuper = true)
public class RetryException extends AbstractException {

    private static final long serialVersionUID = 7886918292771470846L;

    public RetryException(IErrorCode errorCode) {
        this(null, null, errorCode);
    }

    public RetryException(String message) {
        this(message, null, BaseErrorCode.CLIENT_ERROR);
    }

    public RetryException(String message, IErrorCode errorCode) {
        this(message, null, errorCode);
    }


    public RetryException(String message, Throwable throwable, IErrorCode errorCode) {
        super(message, throwable, errorCode);
    }

    @Override
    public String toString() {
        return "RemoteException{" +
                "code='" + errorCode + "'," +
                "message='" + errorMessage + "'" +
                '}';
    }
}
