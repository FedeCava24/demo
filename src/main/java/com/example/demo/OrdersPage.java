package com.example.demo;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.TabSheet;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;

import javax.swing.*;


@Route("Orders")
public class OrdersPage extends AppLayout {

    public OrdersPage(){


        H1 title = new H1("Esseti's App");
        title.getStyle().set("font-size","var(--lumo-font-size-l)")
                .set("margin","0");

        Tabs views = getPrimaryNavigations();

        DrawerToggle toggle = new DrawerToggle();
        H2 viewTitle = new H2("Orders");
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

        dashboardButton.addClickListener(e -> {
            dashboardButton.getUI().ifPresent(ui ->
                    ui.navigate("Dashboard"));

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
        TabSheet tabs =new TabSheet();
        JPanel order =new JPanel()
        tabs.add("New order Saturday", new newOrderSaturday());
        tabs.add("New order Friday", new newOrderFriday());
        tabs.add("Open",new openOrder(order));
        tabs.add("Completed",new completedOrder(order));
        tabs.setHeight("720px");
        tabs.setWidth("1180px");
        return tabs;
    }

    public class newOrderSaturday extends FormLayout {

        public newOrderSaturday(){
            setResponsiveSteps(new FormLayout.ResponsiveStep("0", 2, FormLayout.ResponsiveStep.LabelsPosition.ASIDE));

                IntegerField proseccoField = new IntegerField();
                proseccoField.setValue(0);
                proseccoField.setStepButtonsVisible(true);
                proseccoField.setMin(0);
                proseccoField.setMax(999);
                addFormItem(proseccoField, "Prosecco");

                Label priceProsecco =new Label("50");
                addFormItem(priceProsecco,"PRICE");

                IntegerField bellavistaField=new IntegerField();
                bellavistaField.setValue(0);
                bellavistaField.setStepButtonsVisible(true);
                bellavistaField.setMin(0);
                bellavistaField.setMax(999);
                addFormItem(bellavistaField, "Bellavista");

                Label priceBellavista =new Label("120");
                addFormItem(priceBellavista,"PRICE");

                IntegerField moetField = new IntegerField();
                moetField.setValue(0);
                moetField.setStepButtonsVisible(true);
                moetField.setMin(0);
                moetField.setMax(999);
                addFormItem(moetField, "Moet");

                Label priceMoet =new Label("170");
                addFormItem(priceMoet,"PRICE");

                IntegerField moeticeField = new IntegerField();
                moeticeField.setValue(0);
                moeticeField.setStepButtonsVisible(true);
                moeticeField.setMin(0);
                moeticeField.setMax(999);
                addFormItem(moeticeField, "Moet Ice");

                Label priceMoetIce =new Label("220");
                addFormItem(priceMoetIce,"PRICE");


                IntegerField moeticeRField = new IntegerField();
                moeticeRField.setValue(0);
                moeticeRField.setStepButtonsVisible(true);
                moeticeRField.setMin(0);
                moeticeRField.setMax(999);
                addFormItem(moeticeRField, "Moet Ice Rose");

                Label priceMoetIceRose =new Label("250");
                addFormItem(priceMoetIceRose,"PRICE");

                IntegerField domField = new IntegerField();
                domField.setValue(0);
                domField.setStepButtonsVisible(true);
                domField.setMin(0);
                domField.setMax(999);
                addFormItem(domField, "Dom Perignon");

                Label priceDom =new Label("450");
                addFormItem(priceDom,"PRICE");

                IntegerField domroseField = new IntegerField();
                domroseField.setValue(0);
                domroseField.setStepButtonsVisible(true);
                domroseField.setMin(0);
                domroseField.setMax(999);
                addFormItem(domroseField, "Dom Perignon rose");

                Label priceDomRose=new Label("500");
                addFormItem(priceDomRose,"PRICE");

                IntegerField domluminouseField = new IntegerField();
                domluminouseField.setValue(0);
                domluminouseField.setStepButtonsVisible(true);
                domluminouseField.setMin(0);
                domluminouseField.setMax(999);
                addFormItem(domluminouseField, "Dom Perignon Luminous");

                Label priceDomLuminouse =new Label("600");
                addFormItem(priceDomLuminouse,"PRICE");

                IntegerField domMagnumField =new IntegerField();
                domMagnumField.setValue(0);
                domMagnumField.setStepButtonsVisible(true);
                domMagnumField.setMin(0);
                domMagnumField.setMax(999);
                addFormItem(domMagnumField, "Dom Perignon Magnum");

                Label priceDomMagnum =new Label("950");
                addFormItem(priceDomMagnum,"PRICE");

                IntegerField cristalField =new IntegerField();
                cristalField.setValue(0);
                cristalField.setStepButtonsVisible(true);
                cristalField.setMin(0);
                cristalField.setMax(999);
                addFormItem(cristalField, "Cristal");

                Label priceCristal =new Label("550");
                addFormItem(priceCristal,"PRICE");

                IntegerField krugField =new IntegerField();
                krugField.setValue(0);
                krugField.setStepButtonsVisible(true);
                krugField.setMin(0);
                krugField.setMax(999);
                addFormItem(krugField, "Krug");

                Label priceKrug =new Label("450");
                addFormItem(priceKrug,"PRICE");

                IntegerField armandField =new IntegerField();
                armandField.setValue(0);
                armandField.setStepButtonsVisible(true);
                armandField.setMin(0);
                armandField.setMax(999);
                addFormItem(armandField, "Armand de Briganc");

                Label priceArmand =new Label("600");
                addFormItem(priceArmand,"PRICE");

                IntegerField armandroseField =new IntegerField();
                armandroseField.setValue(0);
                armandroseField.setStepButtonsVisible(true);
                armandroseField.setMin(0);
                armandroseField.setMax(999);
                addFormItem(armandroseField, "Armand de Briganc rose");

                Label priceArmandRose =new Label("900");
                addFormItem(priceArmandRose,"PRICE");

                IntegerField armandverdeField =new IntegerField();
                armandverdeField.setValue(0);
                armandverdeField.setStepButtonsVisible(true);
                armandverdeField.setMin(0);
                armandverdeField.setMax(999);
                addFormItem(armandverdeField, "Armand de Briganc verde");

                Label priceArmandVerde =new Label("700");
                addFormItem(priceArmandVerde,"PRICE");

                IntegerField armandmagnumField =new IntegerField();
                armandmagnumField.setValue(0);
                armandmagnumField.setStepButtonsVisible(true);
                armandmagnumField.setMin(0);
                armandmagnumField.setMax(999);
                addFormItem(armandmagnumField, "Armand de Briganc Magnum");

                Label priceArmandMagnum =new Label("1300");
                addFormItem(priceArmandMagnum,"PRICE");

                IntegerField bombayField = new IntegerField();
                bombayField.setValue(0);
                bombayField.setStepButtonsVisible(true);
                bombayField.setMin(0);
                bombayField.setMax(999);
                addFormItem(bombayField, "Bombay");

                Label priceBombay =new Label("170");
                addFormItem(priceBombay,"PRICE");

                IntegerField bombaymagnumField = new IntegerField();
                bombaymagnumField.setValue(0);
                bombaymagnumField.setStepButtonsVisible(true);
                bombaymagnumField.setMin(0);
                bombaymagnumField.setMax(999);
                addFormItem(bombaymagnumField, "Bombay Magnum");

                Label priceBombayMagnum =new Label("400");
                addFormItem(priceBombayMagnum,"PRICE");

                IntegerField havanaField = new IntegerField();
                havanaField.setValue(0);
                havanaField.setStepButtonsVisible(true);
                havanaField.setMin(0);
                havanaField.setMax(999);
                addFormItem(havanaField, "Havana");

                Label priceHavana =new Label("170");
                addFormItem(priceHavana,"PRICE");

                IntegerField belowField = new IntegerField();
                belowField.setValue(0);
                belowField.setStepButtonsVisible(true);
                belowField.setMin(0);
                belowField.setMax(999);
                addFormItem(belowField, "Below 42");

                Label priceBelow42 =new Label("170");
                addFormItem(priceBelow42,"PRICE");

                IntegerField greyField = new IntegerField();
                greyField.setValue(0);
                greyField.setStepButtonsVisible(true);
                greyField.setMin(0);
                greyField.setMax(999);
                addFormItem(greyField, "GreyGoose");

                Label priceGrey =new Label("220");
                addFormItem(priceGrey,"PRICE");

                IntegerField greyMagnumField = new IntegerField();
                greyMagnumField.setValue(0);
                greyMagnumField.setStepButtonsVisible(true);
                greyMagnumField.setMin(0);
                greyMagnumField.setMax(999);
                addFormItem(greyMagnumField, "GreyGoose Magnum");

                Label priceGreyMagnum =new Label("450");
                addFormItem(priceGreyMagnum,"PRICE");

                IntegerField greyJereboamField = new IntegerField();
                greyJereboamField.setValue(0);
                greyJereboamField.setStepButtonsVisible(true);
                greyJereboamField.setMin(0);
                greyJereboamField.setMax(999);
                addFormItem(greyJereboamField, "GreyGoose Jereboam");

                Label priceGreyJereboam =new Label("950");
                addFormItem(priceGreyJereboam,"PRICE");

                IntegerField greyMathusalemField = new IntegerField();
                greyMathusalemField.setValue(0);
                greyMathusalemField.setStepButtonsVisible(true);
                greyMathusalemField.setMin(0);
                greyMathusalemField.setMax(999);
                addFormItem(greyMathusalemField, "Grey Goose Mathusalem");

                Label priceGreyMathusalem =new Label("1900");
                addFormItem(priceGreyMathusalem,"PRICE");

                IntegerField belvederemagnumField = new IntegerField();
                belvederemagnumField.setValue(0);
                belvederemagnumField.setStepButtonsVisible(true);
                belvederemagnumField.setMin(0);
                belvederemagnumField.setMax(999);
                addFormItem(belvederemagnumField, "Belvedere magnum Esseti");

                Label priceBelvedereMagnumEsseti =new Label("550");
                addFormItem(priceBelvedereMagnumEsseti,"PRICE");

                IntegerField hendricksFiles = new IntegerField();
                hendricksFiles.setValue(0);
                hendricksFiles.setStepButtonsVisible(true);
                hendricksFiles.setMin(0);
                hendricksFiles.setMax(999);
                addFormItem(hendricksFiles, "Hendricks");

                Label priceHndrick =new Label("220");
                addFormItem(priceHndrick,"PRICE");

                IntegerField mareField = new IntegerField();
                mareField.setValue(0);
                mareField.setStepButtonsVisible(true);
                mareField.setMin(0);
                mareField.setMax(999);
                addFormItem(mareField, "Gin Mare");

                Label priceMare =new Label("220");
                addFormItem(priceMare,"PRICE");

                IntegerField malfiPField = new IntegerField();
                malfiPField.setValue(0);
                malfiPField.setStepButtonsVisible(true);
                malfiPField.setMin(0);
                malfiPField.setMax(999);
                addFormItem(malfiPField, "Malfi Pompelmo");

                Label priceMalfiP =new Label("200");
                addFormItem(priceMalfiP,"PRICE");

                IntegerField malfiLField = new IntegerField();
                malfiLField.setValue(0);
                malfiLField.setStepButtonsVisible(true);
                malfiLField.setMin(0);
                malfiLField.setMax(999);
                addFormItem(malfiLField, "Malfi Limone");

                Label priceMalfiL =new Label("200");
                addFormItem(priceMalfiL,"PRICE");

                IntegerField malfiAField = new IntegerField();
                malfiAField.setValue(0);
                malfiAField.setStepButtonsVisible(true);
                malfiAField.setMin(0);
                malfiAField.setMax(999);
                addFormItem(malfiAField, "Malfi Arancia");

                Label priceMalfiA =new Label("200");
                addFormItem(priceMalfiA,"PRICE");

                Button sendOrderSaturday=new Button("Send Order");
                addFormItem(sendOrderSaturday,"");
        }


    }

    public class newOrderFriday extends FormLayout {

        public newOrderFriday(){
            setResponsiveSteps(new FormLayout.ResponsiveStep("0", 2, FormLayout.ResponsiveStep.LabelsPosition.ASIDE));

            IntegerField proseccoField = new IntegerField();
            proseccoField.setValue(0);
            proseccoField.setStepButtonsVisible(true);
            proseccoField.setMin(0);
            proseccoField.setMax(999);
            addFormItem(proseccoField, "Prosecco");

            Label priceProsecco =new Label("50");
            addFormItem(priceProsecco,"PRICE");

            IntegerField bellavistaField=new IntegerField();
            bellavistaField.setValue(0);
            bellavistaField.setStepButtonsVisible(true);
            bellavistaField.setMin(0);
            bellavistaField.setMax(999);
            addFormItem(bellavistaField, "Bellavista");

            Label priceBellavista =new Label("120");
            addFormItem(priceBellavista,"PRICE");

            IntegerField moetField = new IntegerField();
            moetField.setValue(0);
            moetField.setStepButtonsVisible(true);
            moetField.setMin(0);
            moetField.setMax(999);
            addFormItem(moetField, "Moet");

            Label priceMoet =new Label("170");
            addFormItem(priceMoet,"PRICE");

            IntegerField moeticeField = new IntegerField();
            moeticeField.setValue(0);
            moeticeField.setStepButtonsVisible(true);
            moeticeField.setMin(0);
            moeticeField.setMax(999);
            addFormItem(moeticeField, "Moet Ice");

            Label priceMoetIce =new Label("200");
            addFormItem(priceMoetIce,"PRICE");


            IntegerField moeticeRField = new IntegerField();
            moeticeRField.setValue(0);
            moeticeRField.setStepButtonsVisible(true);
            moeticeRField.setMin(0);
            moeticeRField.setMax(999);
            addFormItem(moeticeRField, "Moet Ice Rose");

            Label priceMoetIceRose =new Label("230");
            addFormItem(priceMoetIceRose,"PRICE");

            IntegerField domField = new IntegerField();
            domField.setValue(0);
            domField.setStepButtonsVisible(true);
            domField.setMin(0);
            domField.setMax(999);
            addFormItem(domField, "Dom Perignon");

            Label priceDom =new Label("450");
            addFormItem(priceDom,"PRICE");

            IntegerField domroseField = new IntegerField();
            domroseField.setValue(0);
            domroseField.setStepButtonsVisible(true);
            domroseField.setMin(0);
            domroseField.setMax(999);
            addFormItem(domroseField, "Dom Perignon rose");

            Label priceDomRose=new Label("500");
            addFormItem(priceDomRose,"PRICE");

            IntegerField domluminouseField = new IntegerField();
            domluminouseField.setValue(0);
            domluminouseField.setStepButtonsVisible(true);
            domluminouseField.setMin(0);
            domluminouseField.setMax(999);
            addFormItem(domluminouseField, "Dom Perignon Luminous");

            Label priceDomLuminouse =new Label("600");
            addFormItem(priceDomLuminouse,"PRICE");

            IntegerField domMagnumField =new IntegerField();
            domMagnumField.setValue(0);
            domMagnumField.setStepButtonsVisible(true);
            domMagnumField.setMin(0);
            domMagnumField.setMax(999);
            addFormItem(domMagnumField, "Dom Perignon Magnum");

            Label priceDomMagnum =new Label("950");
            addFormItem(priceDomMagnum,"PRICE");

            IntegerField cristalField =new IntegerField();
            cristalField.setValue(0);
            cristalField.setStepButtonsVisible(true);
            cristalField.setMin(0);
            cristalField.setMax(999);
            addFormItem(cristalField, "Cristal");

            Label priceCristal =new Label("550");
            addFormItem(priceCristal,"PRICE");

            IntegerField krugField =new IntegerField();
            krugField.setValue(0);
            krugField.setStepButtonsVisible(true);
            krugField.setMin(0);
            krugField.setMax(999);
            addFormItem(krugField, "Krug");

            Label priceKrug =new Label("450");
            addFormItem(priceKrug,"PRICE");

            IntegerField armandField =new IntegerField();
            armandField.setValue(0);
            armandField.setStepButtonsVisible(true);
            armandField.setMin(0);
            armandField.setMax(999);
            addFormItem(armandField, "Armand de Briganc");

            Label priceArmand =new Label("600");
            addFormItem(priceArmand,"PRICE");

            IntegerField armandroseField =new IntegerField();
            armandroseField.setValue(0);
            armandroseField.setStepButtonsVisible(true);
            armandroseField.setMin(0);
            armandroseField.setMax(999);
            addFormItem(armandroseField, "Armand de Briganc rose");

            Label priceArmandRose =new Label("900");
            addFormItem(priceArmandRose,"PRICE");

            IntegerField armandverdeField =new IntegerField();
            armandverdeField.setValue(0);
            armandverdeField.setStepButtonsVisible(true);
            armandverdeField.setMin(0);
            armandverdeField.setMax(999);
            addFormItem(armandverdeField, "Armand de Briganc verde");

            Label priceArmandVerde =new Label("700");
            addFormItem(priceArmandVerde,"PRICE");

            IntegerField armandmagnumField =new IntegerField();
            armandmagnumField.setValue(0);
            armandmagnumField.setStepButtonsVisible(true);
            armandmagnumField.setMin(0);
            armandmagnumField.setMax(999);
            addFormItem(armandmagnumField, "Armand de Briganc Magnum");

            Label priceArmandMagnum =new Label("1300");
            addFormItem(priceArmandMagnum,"PRICE");

            IntegerField bombayField = new IntegerField();
            bombayField.setValue(0);
            bombayField.setStepButtonsVisible(true);
            bombayField.setMin(0);
            bombayField.setMax(999);
            addFormItem(bombayField, "Bombay");

            Label priceBombay =new Label("170");
            addFormItem(priceBombay,"PRICE");

            IntegerField bombaymagnumField = new IntegerField();
            bombaymagnumField.setValue(0);
            bombaymagnumField.setStepButtonsVisible(true);
            bombaymagnumField.setMin(0);
            bombaymagnumField.setMax(999);
            addFormItem(bombaymagnumField, "Bombay Magnum");

            Label priceBombayMagnum =new Label("400");
            addFormItem(priceBombayMagnum,"PRICE");

            IntegerField havanaField = new IntegerField();
            havanaField.setValue(0);
            havanaField.setStepButtonsVisible(true);
            havanaField.setMin(0);
            havanaField.setMax(999);
            addFormItem(havanaField, "Havana");

            Label priceHavana =new Label("170");
            addFormItem(priceHavana,"PRICE");

            IntegerField belowField = new IntegerField();
            belowField.setValue(0);
            belowField.setStepButtonsVisible(true);
            belowField.setMin(0);
            belowField.setMax(999);
            addFormItem(belowField, "Below 42");

            Label priceBelow42 =new Label("170");
            addFormItem(priceBelow42,"PRICE");

            IntegerField greyField = new IntegerField();
            greyField.setValue(0);
            greyField.setStepButtonsVisible(true);
            greyField.setMin(0);
            greyField.setMax(999);
            addFormItem(greyField, "GreyGoose");

            Label priceGrey =new Label("220");
            addFormItem(priceGrey,"PRICE");

            IntegerField greyMagnumField = new IntegerField();
            greyMagnumField.setValue(0);
            greyMagnumField.setStepButtonsVisible(true);
            greyMagnumField.setMin(0);
            greyMagnumField.setMax(999);
            addFormItem(greyMagnumField, "GreyGoose Magnum");

            Label priceGreyMagnum =new Label("450");
            addFormItem(priceGreyMagnum,"PRICE");

            IntegerField greyJereboamField = new IntegerField();
            greyJereboamField.setValue(0);
            greyJereboamField.setStepButtonsVisible(true);
            greyJereboamField.setMin(0);
            greyJereboamField.setMax(999);
            addFormItem(greyJereboamField, "GreyGoose Jereboam");

            Label priceGreyJereboam =new Label("950");
            addFormItem(priceGreyJereboam,"PRICE");

            IntegerField greyMathusalemField = new IntegerField();
            greyMathusalemField.setValue(0);
            greyMathusalemField.setStepButtonsVisible(true);
            greyMathusalemField.setMin(0);
            greyMathusalemField.setMax(999);
            addFormItem(greyMathusalemField, "Grey Goose Mathusalem");

            Label priceGreyMathusalem =new Label("1900");
            addFormItem(priceGreyMathusalem,"PRICE");

            IntegerField belvederemagnumField = new IntegerField();
            belvederemagnumField.setValue(0);
            belvederemagnumField.setStepButtonsVisible(true);
            belvederemagnumField.setMin(0);
            belvederemagnumField.setMax(999);
            addFormItem(belvederemagnumField, "Belvedere magnum Esseti");

            Label priceBelvedereMagnumEsseti =new Label("550");
            addFormItem(priceBelvedereMagnumEsseti,"PRICE");

            IntegerField hendricksFiles = new IntegerField();
            hendricksFiles.setValue(0);
            hendricksFiles.setStepButtonsVisible(true);
            hendricksFiles.setMin(0);
            hendricksFiles.setMax(999);
            addFormItem(hendricksFiles, "Hendricks");

            Label priceHndrick =new Label("220");
            addFormItem(priceHndrick,"PRICE");

            IntegerField mareField = new IntegerField();
            mareField.setValue(0);
            mareField.setStepButtonsVisible(true);
            mareField.setMin(0);
            mareField.setMax(999);
            addFormItem(mareField, "Gin Mare");

            Label priceMare =new Label("220");
            addFormItem(priceMare,"PRICE");

            IntegerField malfiPField = new IntegerField();
            malfiPField.setValue(0);
            malfiPField.setStepButtonsVisible(true);
            malfiPField.setMin(0);
            malfiPField.setMax(999);
            addFormItem(malfiPField, "Malfi Pompelmo");

            Label priceMalfiP =new Label("200");
            addFormItem(priceMalfiP,"PRICE");

            IntegerField malfiLField = new IntegerField();
            malfiLField.setValue(0);
            malfiLField.setStepButtonsVisible(true);
            malfiLField.setMin(0);
            malfiLField.setMax(999);
            addFormItem(malfiLField, "Malfi Limone");

            Label priceMalfiL =new Label("200");
            addFormItem(priceMalfiL,"PRICE");

            IntegerField malfiAField = new IntegerField();
            malfiAField.setValue(0);
            malfiAField.setStepButtonsVisible(true);
            malfiAField.setMin(0);
            malfiAField.setMax(999);
            addFormItem(malfiAField, "Malfi Arancia");

            Label priceMalfiA =new Label("200");
            addFormItem(priceMalfiA,"PRICE");

            Button sendOrderFriday=new Button("Send Order");
            addFormItem(sendOrderFriday,"");

            sendOrderFriday.addClickListener(e-> new createOrder(proseccoField.getValue(),bellavistaField.getValue(),moetField.getValue(),moeticeField.getValue(),moeticeRField.getValue(),domField.getValue(),domroseField.getValue(),domluminouseField.getValue(),domMagnumField.getValue(),cristalField.getValue(),krugField.getValue(),armandField.getValue(),armandroseField.getValue(),armandverdeField.getValue(),armandmagnumField.getValue(),bombayField.getValue(),bombaymagnumField.getValue(),havanaField.getValue(),belowField.getValue(),greyField.getValue(),greyMagnumField.getValue(),greyJereboamField.getValue(),greyMathusalemField.getValue(),belvederemagnumField.getValue(),hendricksFiles.getValue(),mareField.getValue(),malfiPField.getValue(),malfiLField.getValue(),malfiAField.getValue()));


        }


    }

    public static class openOrder extends JFrame{
        public openOrder(JPanel order){
            add(order);

        }
    }

    public static class completedOrder extends JFrame{
        public completedOrder(JPanel completed){

            add(completed);

        }
    }
}
