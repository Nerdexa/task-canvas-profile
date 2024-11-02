package com.taskcanvas.gateway;

import com.taskcanvas.config.TaskCanvasDb;
import com.taskcanvas.domain.User;
import com.taskcanvas.driver.TaskCanvasDriver;
import com.taskcanvas.driver.entity.UserJson;
import com.taskcanvas.port.UserPort;

import java.util.UUID;

public class UserGateway implements UserPort {
    private final TaskCanvasDriver taskCanvasDriver;

    public UserGateway(TaskCanvasDriver taskCanvasDriver) {
        this.taskCanvasDriver = taskCanvasDriver;
    }

    public User getUserById(User.Id id) throws Exception {
        UUID userId = UUID.fromString(id.toString());
        UserJson userJson =  taskCanvasDriver.getUserById(userId);
        return new User(UUID.fromString(String.valueOf(userJson.getId())), userJson.getMailAddress());
    }

}