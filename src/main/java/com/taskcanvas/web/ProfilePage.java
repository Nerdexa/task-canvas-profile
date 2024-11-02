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

public class ProfilePage extends WebPage {

    public ProfilePage(PageParameters parameters) {
        super(parameters);
        String idParam = parameters.get("userId").toString();
        Label errorLabel = new Label("error", "ユーザーが見つかりませんでした");
        errorLabel.setOutputMarkupId(true);
        add(errorLabel);

        add(new Label("mailAddress", ""));
        add(new Label("age", ""));
        add(new Label("gender", ""));
        add(new Label("address", ""));
        add(new Label("hobby", ""));
        add(new Label("introduction", ""));

        try {
            Connection connection = new TaskCanvasDb().connect();
            TaskCanvasDriver taskCanvasDriver = new TaskCanvasDriver(connection);
            UserGateway userGateway = new UserGateway(taskCanvasDriver);

            User.Id userId = new User.Id(UUID.fromString(idParam));
            GetUserById getUserById = new GetUserById(userGateway);
            User user = getUserById.execute(userId);

            ((Label) get("mailAddress")).setDefaultModelObject(user.getMailAddress());
            ((Label) get("age")).setDefaultModelObject("25");
            ((Label) get("gender")).setDefaultModelObject("男");
            ((Label) get("address")).setDefaultModelObject("東京都港区");
            ((Label) get("hobby")).setDefaultModelObject("読書");
            ((Label) get("introduction")).setDefaultModelObject("こんにちは、山田太郎です。");
        } catch (Exception e) {
            errorLabel.setVisible(true);
            System.out.println(e);
        }
    }
}
