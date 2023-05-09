package com.example.demo;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.Div;

import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;

import java.awt.*;

@Route("login")
public class LoginPage extends Div {

    public LoginPage() {

        getStyle().set("background-color", "var(--lumo-contrast-5pct)")
                .set("display", "flex").set("justify-content", "center")
                .set("padding", "var(--lumo-space-l)");

        LoginForm loginForm = new LoginForm();
        add(loginForm);

        loginForm.getElement().setAttribute("no-autofocus", "");

        loginForm.addLoginListener(event -> {
            if("admin".equals(event.getUsername()) && "admin".equals(event.getPassword())) {
                UI.getCurrent().navigate("Admin");
            }
            else {
                Notification.show("credenziali sbagliate");
            }
        });

        new RouterLink("registration", RegistrationPage.class);
    }

}

