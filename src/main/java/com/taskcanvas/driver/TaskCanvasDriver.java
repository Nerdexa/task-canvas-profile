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
        String SQL = "SELECT * FROM users WHERE id = " + id.toString();
        ResultSet result = statement.executeQuery(SQL);

        if (result.next()) {
            return new UserJson(UUID.fromString(result.getString("id")), result.getString("mail_address"));
        } else {
            return null;
        }
    }
}
