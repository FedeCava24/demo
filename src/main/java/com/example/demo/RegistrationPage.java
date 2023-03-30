package com.example.demo;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.formlayout.FormLayout.ResponsiveStep;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route("registration")
public class RegistrationPage extends VerticalLayout {
    public RegistrationPage() {
        TextField firstNameField = new TextField("First name", "", "");
        TextField lastNameField = new TextField("Last name", "", "");
        TextField username = new TextField("Username");
        PasswordField password = new PasswordField("Password");
        PasswordField confirmPassword = new PasswordField("Confirm password");
        ComboBox<String> incarichi = new ComboBox<>("Inacarichi");

        incarichi.setAllowCustomValue(true);
        //Aggiungere i vari tipi di incarichi
        incarichi.setItems("Incarico1", "Incarico2", "Incarico3");
        incarichi.setHelperText("Seleziona o scrivi l'incarico svolto");

        FormLayout formLayout = new FormLayout(firstNameField, lastNameField, username,
                password, confirmPassword, incarichi);
        formLayout.setResponsiveSteps(new ResponsiveStep("0", 2));

        Button createAccount = new Button("Create account");
        createAccount.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        Button cancel = new Button("Cancel");

        HorizontalLayout buttonLayout = new HorizontalLayout(createAccount,
                cancel);

        setPadding(false);
        add(formLayout, buttonLayout);
    }

}
