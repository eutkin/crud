package io.github.eutkin.crud.service.exception;

import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

public class ServiceException extends RuntimeException {

    private final String messageCode;
    private final Object[] arg;

    public ServiceException(String messageCode, Object... arg) {
        this.messageCode = messageCode;
        this.arg = arg;
    }

    @NonNull
    public String getMessageCode() {
        return messageCode;
    }

    @Nullable
    public Object[] getArgs() {
        return arg;
    }
}
