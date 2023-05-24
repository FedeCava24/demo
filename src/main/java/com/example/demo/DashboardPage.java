package com.example.demo;


import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.TabSheet;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.server.StreamResource;


@Route("Dashboard")
public class DashboardPage extends AppLayout {

    public DashboardPage(){


        H1 title = new H1("Esseti's App");
        title.getStyle().set("font-size","var(--lumo-font-size-l)")
                .set("margin","0");

        Tabs views = getPrimaryNavigations();

        DrawerToggle toggle = new DrawerToggle();
        H2 viewTitle = new H2("Dashboard");
        viewTitle.getStyle().set("font-size","var(--lumo-font-size-l)")
                .set("margin","0");

        TabSheet subViews = getSecondaryNavigation();

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
        productButton.addClickListener(e -> {
            productButton.getUI().ifPresent(ui ->
                    ui.navigate("Products"));

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
        TabSheet tabs = new TabSheet();
        tabs.add(("Next Event"),new nextEvent());
        tabs.setHeight("900px");
        tabs.setWidth("1200px");
        return tabs;
    }


    public class nextEvent extends Div {

        public nextEvent(){


            StreamResource imageResource1 = new StreamResource("Esseti_27maggio+.png",()->getClass().getResourceAsStream("/Esseti_27maggio.png"));
            Image img1 = new Image(imageResource1,"Serata 27 maggio");

            StreamResource imageResource2 = new StreamResource("Esseti_02giugno+.png",()->getClass().getResourceAsStream("/Esseti_02giugno.png"));
            Image img2 = new Image(imageResource2,"Serata 02 giugno");

            StreamResource imageResource3 = new StreamResource("Esseti_03giugno+.png",()->getClass().getResourceAsStream("/Esseti_03giugno.png"));
            Image img3 = new Image(imageResource3,"Serata 03 giugno");

            StreamResource imageResource4 = new StreamResource("Esseti_07giugno+.png",()->getClass().getResourceAsStream("/Esseti_07giugno.png"));
            Image img4 = new Image(imageResource4,"Serata 07 giugno");



            VerticalLayout verticalLayout=new VerticalLayout(img1,img2,img3,img4);

            verticalLayout.setPadding(true);
            verticalLayout.setSpacing(true);
            verticalLayout.setAlignItems(FlexComponent.Alignment.CENTER);
            add(verticalLayout);

        }


    }

}
