package com.example.demo;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.Route;

@Route("")
public class MainPage extends Div {

    public MainPage() {

        Button loginButton = new Button("Login");
        Button registrationButton = new Button("Registration");
        Button enterButton = new Button("Accedi");
        loginButton.addClickListener(e -> {
            loginButton.getUI().ifPresent(ui ->
                    ui.navigate("login"));

        });

        registrationButton.addClickListener(e -> {
            registrationButton.getUI().ifPresent(ui ->
                    ui.navigate("registration"));
        });

        enterButton.addClickListener(e -> {
                    enterButton.getUI().ifPresent(ui ->
                            ui.navigate("Dashboard"));
        });

        HorizontalLayout horizontalLayout = new HorizontalLayout(loginButton, registrationButton, enterButton);
        horizontalLayout.setAlignItems(FlexComponent.Alignment.BASELINE);
        add(horizontalLayout);
    }


}
