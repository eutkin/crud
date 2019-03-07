package io.github.eutkin.crud.request;

import io.github.eutkin.crud.entity.User;
import org.springframework.lang.NonNull;

import javax.validation.constraints.NotNull;

public abstract class Request {

    @NotNull
    // поле protected, потому что мне было лень разбираться,
    // почему маппер не видит у наследников это поле (по сути не использует геттеры,
    // а пытается напрямую к полю обратиться)
    protected User owner;

    @NonNull
    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
