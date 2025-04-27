package com.example.handler;

import com.example.exception.BaseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {BaseException.class})
    public ResponseEntity<ApiError> handlerBaseException(BaseException baseException, WebRequest webRequest) {
        return ResponseEntity.badRequest().body(createApiError(baseException.getMessage(), webRequest));
    }

    public <E> ApiError<E> createApiError(E message, WebRequest webRequest) {
        ApiError<E> apiError = new ApiError<>();
        apiError.setStatus(HttpStatus.BAD_REQUEST.value());

        Exception<E> exception = new Exception<>();
        exception.setCreateTime(new Date());
        exception.setHostName(getHostname());
        exception.setPath(webRequest.getDescription(false).substring(4));
        exception.setMessage(message);
        apiError.setException(exception);
        return null;
    }

    private String getHostname(){
        try {
            return InetAddress.getLocalHost().getHostName();
        }catch (UnknownHostException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
