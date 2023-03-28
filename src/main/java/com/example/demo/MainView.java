package com.example.demo;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

import java.awt.*;

@Route

public class MainView extends VerticalLayout {
    public MainView() {
        var button = new Button("Click me!");
        var textField = new TextField();

        add(textField, button);


    }


}
