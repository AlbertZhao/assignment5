package com.zhaoshijie.handler;

import com.zhaoshijie.domain.dtos.ErrorDetails;
import com.zhaoshijie.domain.dtos.RestErrorResponse;
import com.zhaoshijie.enums.ServiceErrorCodes;
import com.zhaoshijie.exceptions.BaseException;
import com.zhaoshijie.exceptions.UserRegistrationException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * RestExceptionHandler
 *
 * @author Zhao Shijie
 * @date 2019/08/12
 */
@RestControllerAdvice(basePackages = {"com.zhaoshijie"})
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<RestErrorResponse> handleParametersException(MethodArgumentNotValidException ex) {
        List<FieldError> errors = ex.getBindingResult().getFieldErrors();
        List<ErrorDetails> errorDetailsList = new ArrayList<>();
        for (FieldError error : errors) {
            ErrorDetails errorDetails = new ErrorDetails();
            errorDetails.setFieldName(error.getField());
            errorDetails.setMessage(error.getDefaultMessage());
            errorDetailsList.add(errorDetails);
        }

        RestErrorResponse response = new RestErrorResponse();
        response.setStatusCode(ServiceErrorCodes.INVALID_REQUEST_PARAMETERS.getErrorCode());
        response.setStatusDesc(ServiceErrorCodes.INVALID_REQUEST_PARAMETERS.getErrorInfo());
        response.setErrorInfo(errorDetailsList);

        return new ResponseEntity<>(response, ServiceErrorCodes.INVALID_REQUEST_PARAMETERS.getHttpStatusCode());
    }

    @ExceptionHandler({UserRegistrationException.class})
    public ResponseEntity<RestErrorResponse> handleException(BaseException ex) {
        RestErrorResponse response = new RestErrorResponse();
        response.setStatusCode(ex.getErrorCode().getErrorCode());
        response.setStatusDesc(ex.getErrorCode().getErrorInfo());

        return new ResponseEntity<>(response, ex.getErrorCode().getHttpStatusCode());
    }




}
