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
import com.vaadin.flow.component.orderedlayout.Scroller;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.TabSheet;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;



@Route("Products")
public class ProductPage extends AppLayout{

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

        int i=1;
        tabs.add("Cambusa", new NumberFieldStepButtons(i));
        i=2;
        tabs.add("Bar Premium", new NumberFieldStepButtons(i));
        i=3;
        tabs.add("Bar Chiosco", new NumberFieldStepButtons(i));
        tabs.setHeight("720px");
        tabs.setWidth("1180px");

        return tabs;
    }

    public class NumberFieldStepButtons extends FormLayout  {
        public NumberFieldStepButtons(int i) {

            setResponsiveSteps(new ResponsiveStep("0", 1, ResponsiveStep.LabelsPosition.ASIDE));
            if (i == 2 || i == 3) {
                IntegerField vodkaField = new IntegerField();
                vodkaField.setValue(0);
                vodkaField.setStepButtonsVisible(true);
                vodkaField.setMin(0);
                vodkaField.setMax(999);
                addFormItem(vodkaField, "Vodka");

                IntegerField bombayField = new IntegerField();
                bombayField.setValue(0);
                bombayField.setStepButtonsVisible(true);
                bombayField.setMin(0);
                bombayField.setMax(999);
                addFormItem(bombayField, "Bombay 1L");

                IntegerField rhumBField = new IntegerField();
                rhumBField.setValue(0);
                rhumBField.setStepButtonsVisible(true);
                rhumBField.setMin(0);
                rhumBField.setMax(999);
                addFormItem(rhumBField, "Rhum bianco");

                IntegerField rhumSField = new IntegerField();
                rhumSField.setValue(0);
                rhumSField.setStepButtonsVisible(true);
                rhumSField.setMin(0);
                rhumSField.setMax(999);
                addFormItem(rhumSField, "Rhum scuro");

                IntegerField tripleField = new IntegerField();
                tripleField.setValue(0);
                tripleField.setStepButtonsVisible(true);
                tripleField.setMin(0);
                tripleField.setMax(999);
                addFormItem(tripleField, "Triple sec");

                IntegerField martiniRField = new IntegerField();
                martiniRField.setValue(0);
                martiniRField.setStepButtonsVisible(true);
                martiniRField.setMin(0);
                martiniRField.setMax(999);
                addFormItem(martiniRField, "Martini rosso");

                IntegerField martiniBField = new IntegerField();
                martiniBField.setValue(0);
                martiniBField.setStepButtonsVisible(true);
                martiniBField.setMin(0);
                martiniBField.setMax(999);
                addFormItem(martiniBField, "Martini bitter");

                IntegerField midoriField = new IntegerField();
                midoriField.setValue(0);
                midoriField.setStepButtonsVisible(true);
                midoriField.setMin(0);
                midoriField.setMax(999);
                addFormItem(midoriField, "Midori");

                IntegerField blucField = new IntegerField();
                blucField.setValue(0);
                blucField.setStepButtonsVisible(true);
                blucField.setMin(0);
                blucField.setMax(999);
                addFormItem(blucField, "Blu Curacao");

                IntegerField malibùField = new IntegerField();
                malibùField.setValue(0);
                malibùField.setStepButtonsVisible(true);
                malibùField.setMin(0);
                malibùField.setMax(999);
                addFormItem(malibùField, "Malibu");

                IntegerField monteField = new IntegerField();
                monteField.setValue(0);
                monteField.setStepButtonsVisible(true);
                monteField.setMin(0);
                monteField.setMax(999);
                addFormItem(monteField, "Montenegro");

                IntegerField jackFiled = new IntegerField();
                jackFiled.setValue(0);
                jackFiled.setStepButtonsVisible(true);
                jackFiled.setMin(0);
                jackFiled.setMax(999);
                addFormItem(jackFiled, "Jack Daniel's");

                IntegerField jegerField = new IntegerField();
                jegerField.setValue(0);
                jegerField.setStepButtonsVisible(true);
                jegerField.setMin(0);
                jegerField.setMax(999);
                addFormItem(jegerField, "Jegermaister");

                IntegerField tequilaField = new IntegerField();
                tequilaField.setValue(0);
                tequilaField.setStepButtonsVisible(true);
                tequilaField.setMin(0);
                tequilaField.setMax(999);
                addFormItem(tequilaField, "Tequila");

                IntegerField sambucaField = new IntegerField();
                sambucaField.setValue(0);
                sambucaField.setStepButtonsVisible(true);
                sambucaField.setMin(0);
                sambucaField.setMax(999);
                addFormItem(sambucaField, "Sambuca");

                IntegerField vodkaPField = new IntegerField();
                vodkaPField.setValue(0);
                vodkaPField.setStepButtonsVisible(true);
                vodkaPField.setMin(0);
                vodkaPField.setMax(999);
                addFormItem(vodkaPField, "Vodka pesca");

                IntegerField vodkaFField = new IntegerField();
                vodkaFField.setValue(0);
                vodkaFField.setStepButtonsVisible(true);
                vodkaFField.setMin(0);
                vodkaFField.setMax(999);
                addFormItem(vodkaFField, "Vodka fragola");

                IntegerField vodkaMField = new IntegerField();
                vodkaMField.setValue(0);
                vodkaMField.setStepButtonsVisible(true);
                vodkaMField.setMin(0);
                vodkaMField.setMax(999);
                addFormItem(vodkaMField, "Vodka menta");

                IntegerField maracujaField = new IntegerField();
                maracujaField.setValue(0);
                maracujaField.setStepButtonsVisible(true);
                maracujaField.setMin(0);
                maracujaField.setMax(999);
                addFormItem(maracujaField, "Sciroppo maracuja");

                IntegerField fragolaField = new IntegerField();
                fragolaField.setValue(0);
                fragolaField.setStepButtonsVisible(true);
                fragolaField.setMin(0);
                fragolaField.setMax(999);
                addFormItem(fragolaField, "Sciroppo fragola");

                IntegerField ananasField = new IntegerField();
                ananasField.setValue(0);
                ananasField.setStepButtonsVisible(true);
                ananasField.setMin(0);
                ananasField.setMax(999);
                addFormItem(ananasField, "Succo d'ananas");

                IntegerField aranciaField = new IntegerField();
                aranciaField.setValue(0);
                aranciaField.setStepButtonsVisible(true);
                aranciaField.setMin(0);
                aranciaField.setMax(999);
                addFormItem(aranciaField, "Succo d'arancia");
            }
            if (i == 1 || i == 2) {
                IntegerField malfiPField = new IntegerField();
                malfiPField.setValue(0);
                malfiPField.setStepButtonsVisible(true);
                malfiPField.setMin(0);
                malfiPField.setMax(999);
                addFormItem(malfiPField, "Malfi Pompelmo");

                IntegerField malfiLField = new IntegerField();
                malfiLField.setValue(0);
                malfiLField.setStepButtonsVisible(true);
                malfiLField.setMin(0);
                malfiLField.setMax(999);
                addFormItem(malfiLField, "Malfi Limone");

                IntegerField malfiAField = new IntegerField();
                malfiAField.setValue(0);
                malfiAField.setStepButtonsVisible(true);
                malfiAField.setMin(0);
                malfiAField.setMax(999);
                addFormItem(malfiAField, "Malfi Arancia");

                IntegerField belvedereField = new IntegerField();
                belvedereField.setValue(0);
                belvedereField.setStepButtonsVisible(true);
                belvedereField.setMin(0);
                belvedereField.setMax(999);
                addFormItem(belvedereField, "Belvedere");

                IntegerField tequilaPField = new IntegerField();
                tequilaPField.setValue(0);
                tequilaPField.setStepButtonsVisible(true);
                tequilaPField.setMin(0);
                tequilaPField.setMax(999);
                addFormItem(tequilaPField, "Tequila Premium");

                IntegerField rhumSPField = new IntegerField();
                rhumSPField.setValue(0);
                rhumSPField.setStepButtonsVisible(true);
                rhumSPField.setMin(0);
                rhumSPField.setMax(999);
                addFormItem(rhumSPField, "Rhum scuro Premium");
            }


            if (i == 1) {

                IntegerField belvedereMagnumField = new IntegerField();
                belvedereMagnumField.setValue(0);
                belvedereMagnumField.setStepButtonsVisible(true);
                belvedereMagnumField.setMin(0);
                belvedereMagnumField.setMax(999);
                addFormItem(belvedereMagnumField, "Belvedere Magnum");

                IntegerField belvedereJereboamField = new IntegerField();
                belvedereJereboamField.setValue(0);
                belvedereJereboamField.setStepButtonsVisible(true);
                belvedereJereboamField.setMin(0);
                belvedereJereboamField.setMax(999);
                addFormItem(belvedereJereboamField, "Belvedere Jereboam");

                IntegerField belvedereMathusalemField = new IntegerField();
                belvedereMathusalemField.setValue(0);
                belvedereMathusalemField.setStepButtonsVisible(true);
                belvedereMathusalemField.setMin(0);
                belvedereMathusalemField.setMax(999);
                addFormItem(belvedereMathusalemField, "Belvedere Mathusalem");

                IntegerField hendricksFiles = new IntegerField();
                hendricksFiles.setValue(0);
                hendricksFiles.setStepButtonsVisible(true);
                hendricksFiles.setMin(0);
                hendricksFiles.setMax(999);
                addFormItem(hendricksFiles, "Hendricks");

                IntegerField mareField = new IntegerField();
                mareField.setValue(0);
                mareField.setStepButtonsVisible(true);
                mareField.setMin(0);
                mareField.setMax(999);
                addFormItem(mareField, "Gin Mare");

                IntegerField bombayField = new IntegerField();
                bombayField.setValue(0);
                bombayField.setStepButtonsVisible(true);
                bombayField.setMin(0);
                bombayField.setMax(999);
                addFormItem(bombayField, "Bombay");

                IntegerField bombayMagnumField = new IntegerField();
                bombayMagnumField.setValue(0);
                bombayMagnumField.setStepButtonsVisible(true);
                bombayMagnumField.setMin(0);
                bombayMagnumField.setMax(999);
                addFormItem(bombayMagnumField, "Bombay Magnum");

                IntegerField belowField = new IntegerField();
                belowField.setValue(0);
                belowField.setStepButtonsVisible(true);
                belowField.setMin(0);
                belowField.setMax(999);
                addFormItem(belowField, "Below 42");

                IntegerField proseccoField = new IntegerField();
                proseccoField.setValue(0);
                proseccoField.setStepButtonsVisible(true);
                proseccoField.setMin(0);
                proseccoField.setMax(999);
                addFormItem(proseccoField, "Prosecco");

                IntegerField moetField = new IntegerField();
                moetField.setValue(0);
                moetField.setStepButtonsVisible(true);
                moetField.setMin(0);
                moetField.setMax(999);
                addFormItem(moetField, "Moet");

                IntegerField moeticeField = new IntegerField();
                moeticeField.setValue(0);
                moeticeField.setStepButtonsVisible(true);
                moeticeField.setMin(0);
                moeticeField.setMax(999);
                addFormItem(moeticeField, "Moet Ice");

                IntegerField moeticeRField = new IntegerField();
                moeticeRField.setValue(0);
                moeticeRField.setStepButtonsVisible(true);
                moeticeRField.setMin(0);
                moeticeRField.setMax(999);
                addFormItem(moeticeRField, "Moet Ice Rose");

                IntegerField domField = new IntegerField();
                domField.setValue(0);
                domField.setStepButtonsVisible(true);
                domField.setMin(0);
                domField.setMax(999);
                addFormItem(domField, "Dom Perignon");

                IntegerField domMagnumField =new IntegerField();
                domMagnumField.setValue(0);
                domMagnumField.setStepButtonsVisible(true);
                domMagnumField.setMin(0);
                domMagnumField.setMax(999);
                addFormItem(domMagnumField, "Dom Perignon Magnum");

            }
        }
    }

}
