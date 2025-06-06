package org.duku.mall.framework.starter.convention.exception;

import lombok.Getter;
import org.duku.mall.framework.starter.convention.errorcode.IErrorCode;
import org.springframework.util.StringUtils;

import java.rmi.RemoteException;
import java.util.Optional;

/**
 * 抽象项目中三类异常体系，客户端异常、服务端异常以及远程服务调用异常
 * @author duku
 *@see ClientException
 *@see ServiceException
 *@see RemoteException
 */
@Getter
public abstract class AbstractException  extends RuntimeException{

    public final String errorCode;

    public final String errorMessage;

    public AbstractException(String message, Throwable throwable, IErrorCode errorCode) {
        super(message, throwable);
        this.errorCode = errorCode.code();
        this.errorMessage = Optional.ofNullable(StringUtils.hasLength(message) ? message : null).orElse(errorCode.message());
    }
}
