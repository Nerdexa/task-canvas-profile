package com.taskcanvas.driver.entity;

import lombok.Data;

import java.util.UUID;

@Data
public class UserJson {
    private final UUID id;
    private final String mailAddress;

    public UserJson(UUID id, String mailAddress) {
        this.id = id;
        this.mailAddress = mailAddress;
    }
}
