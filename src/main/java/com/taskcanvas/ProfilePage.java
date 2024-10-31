package com.taskcanvas;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;

public class ProfilePage extends  WebPage {
    public ProfilePage() {
        add(new Label("name", "山田太郎"));
        add(new Label("mailAddress", "test@test.com"));
        add(new Label("age", "25"));
        add(new Label("gender", "男"));
        add(new Label("address", "東京都港区"));
        add(new Label("hobby", "読書"));
        add(new Label("introduction", "こんにちは、山田太郎です。"));
    }
}
