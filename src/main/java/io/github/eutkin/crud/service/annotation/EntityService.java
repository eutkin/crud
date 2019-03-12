package io.github.eutkin.crud.service.annotation;

import io.github.eutkin.crud.request.Request;
import org.springframework.stereotype.Service;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Service
public @interface EntityService {

    Class<? extends Request> request();

    Class<?> entity();

    Class<?> view();
}
