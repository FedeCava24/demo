package com.example.demo;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.formlayout.FormLayout.ResponsiveStep;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.shared.Registration;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.*;


import java.time.LocalDate;
import java.util.Date;

@Route("registration")
public class RegistrationPage extends VerticalLayout {


    public RegistrationPage()  {
        TextField firstNameField = new TextField("First name", "", "");
        TextField lastNameField = new TextField("Last name", "", "");
        TextField username = new TextField("Username");
        EmailField emailField = new EmailField("E-mail");
        DatePicker dateBirth = new DatePicker("Data di nascita");
        PasswordField password = new PasswordField("Password");
        PasswordField confirmPassword = new PasswordField("Confirm password");
        ComboBox<String> task = new ComboBox<>("Inacarichi");

        task.setAllowCustomValue(true);
        //Aggiungere i vari tipi di incarichi
        task.setItems("PR", "Barista", "Cambusiere", "gestore","Sicurezza","Cassiera");
        task.setHelperText("Seleziona o scrivi l'incarico svolto");

        FormLayout formLayout = new FormLayout(firstNameField, lastNameField, username, emailField, dateBirth,
                password, confirmPassword, task);
        formLayout.setResponsiveSteps(new ResponsiveStep("0", 2));

        Button createAccount = new Button("Create account");
        createAccount.addClickListener(e -> User(
                firstNameField.getValue(),
                lastNameField.getValue(),
                username.getValue(),
                emailField.getValue(),
                String.valueOf(dateBirth.getValue()),
                password.getValue(),
                confirmPassword.getValue(),
                task.getValue())
        );

        createAccount.addClickListener(e-> new Userimporter());





        createAccount.addClickListener(e -> createAccount.getUI().ifPresent(ui ->
                ui.navigate("")));
        createAccount.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        Button cancel = new Button("Cancel");

        HorizontalLayout buttonLayout = new HorizontalLayout(createAccount,
                cancel);

        setPadding(false);
        add(formLayout, buttonLayout);
    }




    public void User (String  firstname, String lastname , String username, String email, String dateBirth, String password, String confirmPassword,
                           String task ) {
        if (username.trim().isEmpty()) {

            Notification.show("Enter a username");

        } else if (password.isEmpty()) {

            Notification.show("Enter a password");

        } else if (!password.equals(confirmPassword)) {

            Notification.show("Passwords don't match");

        }
        else if (firstname.trim().isEmpty()) {

            Notification.show("Enter a firstname");

        }
        else if(lastname.trim().isEmpty()) {

            Notification.show("Enter a lastname");

        }
        else if(task.isEmpty()){

            Notification.show("Select a incarico");

        }
        else if (email.isEmpty()) {
            Notification.show("Enter a E-mail");
        }
        else if (dateBirth.isEmpty()) {
            Notification.show("Enter the Birthday's date");
        }

    }
    public class Userimporter{
        public static void main(String[] args) throws IOException, SQLException{
            String jdbcURL = "jdbc:mysql://localhost:3306/mysql";
            String username = "Luca";
            String password = "!AcUl!eubagil!25";

            try (Connection connection = DriverManager.getConnection(jdbcURL, username, password)) {
            }


            String sql;
            sql = "INSERT INTO personale(password,username,dateBirth,email,firstname,task,lastname)";
        }
    }

}
