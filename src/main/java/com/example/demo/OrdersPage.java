package com.example.demo;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Label;
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
import java.awt.*;


@Route("Orders")
public class OrdersPage extends AppLayout {
    Integer []Prezzo={50,120,170,200,230,450,500,600,950,550,450,600,900,700,1300,170,400,170,170,220,450,950,1900,550,220,220,200,200,200};

    String []Nome= {"Prosecco","Bellavista","Moet","Moet Ice","Moet Ice Rose","Dom Perignon","Dom Perignon Rose", "Dom Perigno Luminous","Dom Perignon Magnum","Cristal","Krug","Armand de Brignac","Armand de Brignac Rose","Armand de Brignac verde","Armand de Brignac Magnum","Bombay","Bombay Magnum","Havana","Below42","Grey Goose","Grey Goose Magnum","Grey Goose Jereboam","Grey Goose Mathusalem","Belvedere Magnum Esseti","Hendricks","Gin Mare","Malfi Pompelmo","Malfi Limone","Malfi Arancia"};
    Integer[]Quantita={0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
    String NumTavolo ="null";
    VerticalLayout verticalLayoutpanel=new VerticalLayout();

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
        tabs.add("New order Friday", new newOrderFriday());
        tabs.add("Open",new openOrder(Nome, Quantita,Prezzo,NumTavolo));
       /* tabs.add("Completed",new completedOrder());*/
        tabs.setHeight("720px");
        tabs.setWidth("1180px");
        return tabs;
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

            ComboBox<String> tableNumber = new ComboBox<>("Table Number");
            tableNumber.setAllowCustomValue(true);
            //Numeri dei tavoli
            tableNumber.setItems( "C1","C2","C3","C4","C5","C6","C7","C8","C9","P1","P2","P3","P4","P5","P6","P7","P8","P9","B1","B2","B3","B4","B5","B6","B7","B8","B9","B10","F1","F2","F3","F4","F5","F6","F7","F8","F9","F10","F11","F12","A1","A2","A3","A4","A5","A6","A7","A8","A9","G1","G2","G3","G4","G5");
            addFormItem(tableNumber,"");

            Button sendOrderFriday=new Button("Send Order");
            addFormItem(sendOrderFriday,"");



            sendOrderFriday.addClickListener(e-> new createOrder(proseccoField.getValue(),bellavistaField.getValue(),moetField.getValue(),moeticeField.getValue(),moeticeRField.getValue(),domField.getValue(),domroseField.getValue(),domluminouseField.getValue(),domMagnumField.getValue(),cristalField.getValue(),krugField.getValue(),armandField.getValue(),armandroseField.getValue(),armandverdeField.getValue(),armandmagnumField.getValue(),bombayField.getValue(),bombaymagnumField.getValue(),havanaField.getValue(),belowField.getValue(),greyField.getValue(),greyMagnumField.getValue(),greyJereboamField.getValue(),greyMathusalemField.getValue(),belvederemagnumField.getValue(),hendricksFiles.getValue(),mareField.getValue(),malfiPField.getValue(),malfiLField.getValue(),malfiAField.getValue(),tableNumber.getValue()));


        }


    }

    public  class openOrder extends Div {
        VerticalLayout verticalLayoutpanel=new VerticalLayout();
        Integer[][] Prezzo=new Integer[150][28];

        String[][] Nome= new String[150][28];
        Integer[][] Quantita=new Integer[150][28];
        String[][] NumTavolo= new String[150][1];


        public openOrder(String[] newNome, Integer[]newQuantita,Integer[] newPrezzo,String newNumTavolo){
           for(int i=0;i<=150;i++){
               if(NumTavolo[i][0]==null){
                   NumTavolo[i][0]=new String(newNumTavolo);
                   for (int j=0;j<=28;j++){
                       Prezzo[i][j]=newPrezzo[j];
                       Quantita[i][j]=newQuantita[j];
                       Nome[i][j]= new String(newNome[j]);
                   }
                   JPanel newPanel=new JPanel();
                   Integer totale=0;
                   for(int j=0;j<=28;j++){
                       if(Quantita[i][j]!=0){
                           JLabel label=new JLabel(Nome[i][j]);
                           newPanel.add(label,Quantita[i][j]);
                           totale+=Quantita[i][j]*Prezzo[i][j];
                       }
                   }
                   JLabel totaleLabel=new JLabel(String.valueOf(totale));
                   newPanel.add("TOTALE ORDINE",totaleLabel);
                   Button completed=new Button("Completato");

                   newPanel.getAlignmentY();
                   newPanel.setBackground(Color.CYAN);
                   completed.addClickListener(e->{
                       completed.setVisible(false);
                   });

                   verticalLayoutpanel.add(newPanel);
                   break;


               }
           }
            add(verticalLayoutpanel);
        }
    }

    public  class completedOrder extends JFrame{
        public completedOrder(){



        }
    }
    public  class createOrder  {
        public createOrder(Integer prosecco,Integer bellavista,Integer moet,Integer moetIce,Integer moetIceRose,Integer dom,Integer domRose,Integer domLumi,Integer domM, Integer cristal,Integer krug,Integer armand,Integer armandRose,Integer armandVerde ,Integer armandMagnum,Integer bombay,Integer bombayMagnum,Integer havana,Integer below,Integer grey,Integer greyMagnum,Integer greyJ,Integer greyMat,Integer belvedereM,Integer hendricks,Integer mare,Integer malfiP,Integer malfiL,Integer malfiA, String numTavolo) {
            Quantita[0] = prosecco;
            Quantita[1] = bellavista;
            Quantita[2] = moet;
            Quantita[3] = moetIce;
            Quantita[4] = moetIceRose;
            Quantita[5] = dom;
            Quantita[6] = domRose;
            Quantita[7] = domLumi;
            Quantita[8] = domM;
            Quantita[9] = cristal;
            Quantita[10] = krug;
            Quantita[11] = armand;
            Quantita[12] = armandRose;
            Quantita[13] = armandVerde;
            Quantita[14] = armandMagnum;
            Quantita[15] = bombay;
            Quantita[16] = bombayMagnum;
            Quantita[17] = havana;
            Quantita[18] = below;
            Quantita[19] = grey;
            Quantita[20] = greyMagnum;
            Quantita[21] = greyJ;
            Quantita[22] = greyMat;
            Quantita[23] = belvedereM;
            Quantita[24] = hendricks;
            Quantita[25] = mare;
            Quantita[26] = malfiP;
            Quantita[27] = malfiL;
            Quantita[28] = malfiA;
            new openOrder(Nome,Quantita,Prezzo,numTavolo);
        }
    }




}
