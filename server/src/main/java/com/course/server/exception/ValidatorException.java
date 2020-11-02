package com.course.server.exception;

/**
 * @author 颜伟晗
 * @since 2020/11/2
 */
public class ValidatorException extends RuntimeException {

    public ValidatorException(String message) {
        super(message);
    }
}
