package io.github.eutkin.crud.web.advice;

import io.github.eutkin.crud.service.exception.ServiceException;
import io.github.eutkin.crud.service.exception.UnexpectedServiceException;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Locale;
import java.util.Map;

import static java.util.stream.Collectors.toMap;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.ResponseEntity.status;

@ControllerAdvice
public class ExceptionHandlerAdvice implements MessageSourceAware {

    private MessageSource messageSource;


    @ExceptionHandler(ServiceException.class)
    public ResponseEntity<String> handle(ServiceException ex, Locale locale) {
        HttpStatus statusCode = ex instanceof UnexpectedServiceException ? INTERNAL_SERVER_ERROR : BAD_REQUEST;
        String message = messageSource.getMessage(ex.getMessageCode(), ex.getArgs(), locale);
        return status(statusCode).body(message);
    }

    @Override
    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Map<String, String> handle(ConstraintViolationException ex, Locale locale) {
        return ex.getConstraintViolations()
                .stream()
                .collect(toMap(v -> v.getPropertyPath().toString(), ConstraintViolation::getMessage));

    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Map<String, String> handle(MethodArgumentNotValidException e, Locale locale) {
        return e.getBindingResult()
                .getFieldErrors()
                .stream()
                .collect(toMap(FieldError::getField, fieldError -> messageSource.getMessage(fieldError, locale)));
    }

}
