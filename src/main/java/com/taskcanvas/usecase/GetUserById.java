package com.taskcanvas.usecase;

import com.taskcanvas.domain.User;
import com.taskcanvas.port.UserPort;

public class GetUserById {
    private final UserPort userPort;

    public GetUserById(UserPort userPort) {
        this.userPort = userPort;
    }

    public User execute(User.Id id) throws Exception {
        return userPort.getUserById(id);
    }
}

