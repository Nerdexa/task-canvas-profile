package com.taskcanvas.driver;

import com.taskcanvas.driver.entity.UserJson;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.UUID;

public class TaskCanvasDriver {
    private final Connection connection;

    public TaskCanvasDriver(Connection connection) {
        this.connection = connection;
    }

    public UserJson getUserById(UUID id) throws Exception {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM task_canvas.user WHERE id = '" + id + "'");
        resultSet.next();
        return new UserJson(UUID.fromString(resultSet.getString("id")), resultSet.getString("email"));
    }
}
