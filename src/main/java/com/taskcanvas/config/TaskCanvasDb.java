package com.taskcanvas.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TaskCanvasDb {
    String url = "jdbc:postgresql://localhost:10080/task_canvas";
    String user = "developer";
    String password = "developer";

    public Connection connect() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
}
