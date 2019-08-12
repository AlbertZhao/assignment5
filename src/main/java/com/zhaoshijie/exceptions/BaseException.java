package com.zhaoshijie.exceptions;

import com.zhaoshijie.enums.ServiceErrorCodes;

/**
 * Demo class
 *
 * @author 1547418
 * @date 2019/08/12
 */
public class BaseException extends RuntimeException {
    private ServiceErrorCodes errorCode;

    public BaseException(ServiceErrorCodes errorCode) {
        super(errorCode.getErrorInfo());
    }

    public BaseException(Throwable cause, ServiceErrorCodes errorCode) {
        super(errorCode.getErrorInfo(), cause);
    }

    public ServiceErrorCodes getErrorCode() {
        return errorCode;
    }

    @Override
    public String getMessage() {
        return errorCode.getErrorInfo();
    }
}
