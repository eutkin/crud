package io.github.eutkin.crud.service.exception;

public class UnexpectedServiceException extends ServiceException {

    public UnexpectedServiceException(String messageCode, Object... arg) {
        super(messageCode, arg);
    }
}
