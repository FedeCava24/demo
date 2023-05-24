package com.example.demo.Login;

import com.example.demo.Service.AuthService;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "login")
@PageTitle("Login")
public class LoginPage extends VerticalLayout {

    public LoginPage(AuthService authService) {

        var username = new TextField("Username");
        var password = new PasswordField("Password");
        add(
                new H1("Welcome"),
                username,
                password,
                new Button("Login", event -> {
                    try {
                        authService.authenticate(username.getValue(), password.getValue());
                        UI.getCurrent().navigate("");
                    } catch (AuthService.AuthException e) {
                        Notification.show("Wrong credentials.");
                    }
                })

        );
        Button registration = new Button("Register");
        add(registration);
        registration.addClickListener(e -> {
            registration.getUI().ifPresent(ui ->
                    ui.navigate("register"));

        });
    }

}

