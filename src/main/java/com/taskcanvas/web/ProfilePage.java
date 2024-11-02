package com.taskcanvas.web;

import com.taskcanvas.config.TaskCanvasDb;
import com.taskcanvas.domain.User;
import com.taskcanvas.driver.TaskCanvasDriver;
import com.taskcanvas.gateway.UserGateway;
import com.taskcanvas.usecase.GetUserById;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import java.sql.Connection;
import java.util.UUID;

public class ProfilePage extends  WebPage {

    public ProfilePage(PageParameters parameters) {
        super(parameters);
        String idParam = parameters.get("userId").toString();
        Label errorLabel = new Label("error", "ユーザーが見つかりませんでした");
        add(errorLabel);

        try {
            Connection connection = new TaskCanvasDb().connect();
            TaskCanvasDriver taskCanvasDriver = new TaskCanvasDriver(connection);
            UserGateway userGateway = new UserGateway(taskCanvasDriver);

            User.Id userId = new User.Id(UUID.fromString(idParam));
            GetUserById getUserById = new GetUserById(userGateway);
            User user = getUserById.execute(userId);

            System.out.println(user);

            add(new Label("mailAddress", "test@test.com"));
            add(new Label("age", "25"));
            add(new Label("gender", "男"));
            add(new Label("address", "東京都港区"));
            add(new Label("hobby", "読書"));
            add(new Label("introduction", "こんにちは、山田太郎です。"));
        } catch (Exception e) {
            errorLabel.setVisible(true);
        }
    }
}
