package com.taskcanvas.usecase;

import com.taskcanvas.port.UserPort;

public class getUserById {
    private final UserPort userPort;

    public getUserById(UserPort userPort) {
        this.userPort = userPort;
    }
}

