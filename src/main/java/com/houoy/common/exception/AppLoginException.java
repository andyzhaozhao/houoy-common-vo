package com.houoy.common.exception;

import org.springframework.core.NestedRuntimeException;

/**
 * Created by andyzhao on 2017-03-04.
 */
public class AppLoginException extends NestedRuntimeException {

    private static final long serialVersionUID = 5498058653840752035L;

    public AppLoginException(String message) {
        super(message);
    }

    public AppLoginException(String message, Throwable cause) {
        super(message, cause);
    }

}
