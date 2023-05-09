package com.example.demo;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.TabSheet;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;



@Route("Products")
public class ProductPage extends AppLayout {

    public ProductPage(){


        H1 title = new H1("Esseti's App");
        title.getStyle().set("font-size","var(--lumo-font-size-l)")
                .set("margin","0");

        Tabs views = getPrimaryNavigations();

        DrawerToggle toggle = new DrawerToggle();
        H2 viewTitle = new H2("Products");
        viewTitle.getStyle().set("font-size","var(--lumo-font-size-l)")
                .set("margin","0");
        TabSheet subViews =getSecondaryNavigation();
        HorizontalLayout wrapper = new HorizontalLayout(toggle,viewTitle);
        wrapper.setAlignItems(FlexComponent.Alignment.CENTER);
        wrapper.setSpacing(false);

        VerticalLayout viewHeader=new VerticalLayout(wrapper, subViews);
        viewHeader.setPadding(false);
        viewHeader.setSpacing(false);

        addToDrawer(title,views);
        addToNavbar(viewHeader);
        setPrimarySection(Section.DRAWER);



    }

    private Tabs getPrimaryNavigations() {
        Button dashboardButton = new Button("Dashboard");
        Button ordersButton = new Button("Orders");
        Button productButton = new Button("Products");
        Button employeeButton = new Button("Employees");
        Button availabilityButton = new Button("Availability");
        Button reservationButton = new Button("Reservations");
        Tabs tabs = new Tabs();
        tabs.add(createTab(VaadinIcon.DASHBOARD, dashboardButton),
                createTab(VaadinIcon.CART,ordersButton ),
                createTab(VaadinIcon.PACKAGE, productButton),
                createTab(VaadinIcon.USER_CHECK, employeeButton),
                createTab(VaadinIcon.CALENDAR_USER, availabilityButton),
                createTab(VaadinIcon.TABLE,reservationButton));

        tabs.setOrientation(Tabs.Orientation.VERTICAL);
        tabs.setSelectedIndex(1);

        ordersButton.addClickListener(e -> {
            ordersButton.getUI().ifPresent(ui ->
                    ui.navigate("Orders"));

        });
        dashboardButton.addClickListener(e -> {
            dashboardButton.getUI().ifPresent(ui ->
                    ui.navigate("Dashboard"));

        });
        employeeButton.addClickListener(e -> {
            employeeButton.getUI().ifPresent(ui ->
                    ui.navigate("Employees"));

        });
        availabilityButton.addClickListener(e -> {
            availabilityButton.getUI().ifPresent(ui ->
                    ui.navigate("Availability"));

        });
        reservationButton.addClickListener(e -> {
            reservationButton.getUI().ifPresent(ui ->
                    ui.navigate("Reservations"));

        });
        return tabs;
    }

    private Tab createTab(VaadinIcon viewIcon, Button viewName){
        Icon icon =viewIcon.create();
        icon.getStyle().set("box-sizing","border-box")
                .set("margin-inline-edn","var(--lumo-space-m)")
                .set("margin-inline-start","var(--lumo-space-xs)")
                .set("padding","var(--lumo-space-xs)");

        RouterLink link = new RouterLink();
        link.add(icon, new Span(viewName));
        link.setTabIndex(-1);

        return new Tab(link);
    }
    private TabSheet getSecondaryNavigation(){
        TabSheet tabs =new TabSheet();
        Button addVodkaButton=new Button("+");
        Button subVodkaButton=new Button("-");
        Button addBelvedereButton=new Button("+");
        Button subBelvedereButton=new Button("-");

        int BottlevodkaNumber=0;
        int BottleBelvedereNumber=0;
        /*tabs.add("Cambusa", new Div(BottleTable("vodka ",BottlevodkaNumber,addVodkaButton,subVodkaButton),
                BottleTable("Belvedere ",BottleBelvedereNumber,addBelvedereButton,subBelvedereButton)));
        tabs.add("Bar Premium", new Div(BottleTable("vodka ",BottlevodkaNumber,addVodkaButton,subVodkaButton),
                BottleTable("Belvedere ",BottleBelvedereNumber,addBelvedereButton,subBelvedereButton)));*/
        tabs.add("Cambusa", new NumberFieldStepButtons());
        tabs.add("Bar Premium", new NumberFieldStepButtons());



        return tabs;
    }

    /*private Tab BottleTable(String Name, int Number , Button Add, Button Sub){
        RouterLink link = new RouterLink();
        link.add(Name);
        link.add(String.valueOf(Number));
        link.add(Add);
        link.add(Sub);
        link.setTabIndex(-1);

        return new Tab(link);

    }*/
    public class NumberFieldStepButtons extends FormLayout {
        public NumberFieldStepButtons() {
            setResponsiveSteps(new ResponsiveStep("0", 1, ResponsiveStep.LabelsPosition.ASIDE));
            IntegerField vodkaField = new IntegerField();
            vodkaField.setValue(0);
            vodkaField.setStepButtonsVisible(true);
            vodkaField.setMin(0);
            vodkaField.setMax(999);
            addFormItem(vodkaField, "Vodka");

            IntegerField belvedereField = new IntegerField();
            belvedereField.setValue(0);
            belvedereField.setStepButtonsVisible(true);
            belvedereField.setMin(0);
            belvedereField.setMax(999);
            addFormItem(belvedereField, "Belvedere");
        }
    }

}
