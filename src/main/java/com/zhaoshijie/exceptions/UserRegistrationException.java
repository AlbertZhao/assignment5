package com.zhaoshijie.exceptions;

import com.zhaoshijie.enums.ServiceErrorCodes;

/**
 * UserRegistrationException
 *
 * @author Zhao Shijie
 * @date 2019/08/12
 */
public class UserRegistrationException extends BaseException {

    private static final long serialVersionUID = -3185643600094988362L;

    public UserRegistrationException(ServiceErrorCodes errorCode) {
        super(errorCode);
    }

    public UserRegistrationException(Throwable cause, ServiceErrorCodes errorCode) {
        super(cause, errorCode);
    }

}
