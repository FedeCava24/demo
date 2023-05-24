package com.example.demo;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.Scroller;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.TabSheet;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.server.StreamResource;

import java.util.ArrayList;
import java.util.List;

@Route("Reservations")
public class ReservationPage extends AppLayout {


    public ReservationPage(){


        H1 title = new H1("Esseti's App");
        title.getStyle().set("font-size","var(--lumo-font-size-l)")
                .set("margin","0");

        Tabs views = getPrimaryNavigations();

        DrawerToggle toggle = new DrawerToggle();
        H2 viewTitle = new H2("Reservations");
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
        dashboardButton.addClickListener(e -> {
            dashboardButton.getUI().ifPresent(ui ->
                    ui.navigate("Dashboard"));

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

        tabs.add("Table's Map", new CaricatoreImmagine());
        tabs.add("Wednesday",new InsertTable());
        tabs.add("Friday",new InsertTable());
        tabs.add("Saturday",new InsertTable());


        return tabs;
    }

    public class CaricatoreImmagine extends Div {
        public CaricatoreImmagine(){

            Scroller scroller = new Scroller() ;
            scroller.setWidth("850px");
            scroller.setHeight("1050px");
            StreamResource imageResource = new StreamResource("piatina+.png",()->getClass().getResourceAsStream("/piantina.png"));
            Image img = new Image(imageResource,"Piantina tavoli");
            scroller.setContent(img);
            add(scroller);
        }
    }



      public class InsertTable extends Div{




            public InsertTable(){



                ComboBox<String> tableNumber = new ComboBox<>("Table Number");
                TextField tableName =new TextField("Table Name");
                TextField prName =new TextField("Pr's Name");
                ComboBox<String> personNumber = new ComboBox<>("Person Number");

                Button prenotaButton = new Button("Prenota Tavolo");

                personNumber.setAllowCustomValue(true);
                tableNumber.setAllowCustomValue(true);
                //Numeri dei tavoli
                tableNumber.setItems( "C1","C2","C3","C4","C5","C6","C7","C8","C9","P1","P2","P3","P4","P5","P6","P7","P8","P9","B1","B2","B3","B4","B5","B6","B7","B8","B9","B10","F1","F2","F3","F4","F5","F6","F7","F8","F9","F10","F11","F12","A1","A2","A3","A4","A5","A6","A7","A8","A9","G1","G2","G3","G4","G5");
                //Numeri di persone al tavolo
                personNumber.setItems("1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20");



                FormLayout formLayout=new FormLayout();
                formLayout.add(tableNumber, tableName, prName,personNumber,prenotaButton);
                formLayout.setResponsiveSteps(
                        new FormLayout.ResponsiveStep("500px",4));
                prenotaButton.addClickListener(e -> tableList(
                                tableNumber.getValue(),
                                tableName.getValue(),
                                prName.getValue(),
                               personNumber.getValue()
                        )
                );

                Grid<Table> grid=new Grid<>(Table.class,true);
                /*grid.addColumn(Table::getTableNumber).setHeader("Table's Number");
                grid.addColumn(Table::getTableName).setHeader("Table's Name");
                grid.addColumn(Table::getPrName).setHeader("Pr's Name");
                grid.addColumn(Table::getPersonNumber).setHeader("Number of Person");
                grid.setHeight("500px");
                grid.setWidth("1000px");*/





                FormLayout stampa=new FormLayout();
                List<Table> tables= new ArrayList<>();//Da capie come riempire la lista con i vettori della pagina Table
                grid.setItems(tables);
                stampa.add(grid);



                VerticalLayout verticalLayout =new VerticalLayout(formLayout,stampa);


                add(verticalLayout);



            }


          private void tableList(String tableNumber, String tableName, String prName, String personNumber) {
              if(tableNumber.isBlank()){
                  Notification.show("Insert the Table Number");
              } else if (tableName.isEmpty()) {
                  Notification.show("Insert the Table Name");
              } else if (prName.isEmpty()) {
                  Notification.show("Intert the Pr's Name");
              }else if (personNumber.isBlank()){
                  Notification.show("Insert the Number of people");
              } else{
                        Table table=  new Table(tableNumber,tableName,prName,personNumber);

              }
          }


            }




}
