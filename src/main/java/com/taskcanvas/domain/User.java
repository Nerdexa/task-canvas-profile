package com.taskcanvas.domain;

import lombok.Data;

import java.util.UUID;

@Data
public class User {
    private final UUID id;
    private final String mailAddress;

    public User(UUID id, String mailAddress) {
        this.id = id;
        this.mailAddress = mailAddress;
    }

    public static class Id {
        private final UUID value;

        public Id(UUID value) {
            this.value = value;
        }

        public UUID getValue() {
            return value;
        }
    }
}
