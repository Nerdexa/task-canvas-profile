package com.taskcanvas.port;

import com.taskcanvas.domain.User;

public interface UserPort {
    User getUserById(User.Id id) throws Exception;
}
