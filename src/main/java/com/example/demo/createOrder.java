package com.example.demo;

import javax.swing.*;
import java.awt.*;

public class createOrder {
    public createOrder(Integer prosecco,Integer bellavista,Integer moet,Integer moetIce,Integer moetIceRose,Integer dom,Integer domRose,Integer domLumi,Integer domM, Integer cristal,Integer krug,Integer armand,Integer armandRose,Integer armandVerde ,Integer armandMagnum,Integer bombay,Integer bombayMagnum,Integer havana,Integer below,Integer grey,Integer greyMagnum,Integer greyJ,Integer greyMat,Integer belvedereM,Integer hendricks,Integer mare,Integer malfiP,Integer malfiL,Integer malfiA){
        JPanel newOrder= new JPanel();
        Integer totale=0;
        if(prosecco!=0){
            totale+=prosecco*50;
            JLabel proseccoLabel=new JLabel("prosecco");
            newOrder.add(proseccoLabel,prosecco);
        }
        if(bellavista!=0){
            totale+=bellavista*120;
            JLabel bellavistaLabel=new JLabel("Bellavista");
            newOrder.add(bellavistaLabel,bellavista);
        }
        if(moet!=0){
            totale+=moet*170;
            JLabel moetLabel=new JLabel("Moet");
            newOrder.add(moetLabel,moet);
        }
        if(moetIce!=0){
            totale+=moetIce*200;
            JLabel moetIceLabel=new JLabel("Moet Ice");
            newOrder.add(moetIceLabel,moetIce);
        }
        if(moetIceRose!=0){
            totale+=moetIceRose*230;
            JLabel moetIceRoseLabel=new JLabel("Moet Ice Rose");
            newOrder.add(moetIceRoseLabel,moetIceRose);
        }
        if(dom!=0){
            totale+=dom*450;
            JLabel domLabel=new JLabel("Dom Perignon");
            newOrder.add(domLabel,dom);
        }
        if(domRose!=0){
            totale+=domRose*500;
            JLabel domRoseLabel=new JLabel("Dom Perigno Rose");
            newOrder.add(domRoseLabel,domRose);
        }
        if(domLumi!=0){
            totale+=domLumi*600;
            JLabel domLumiLabel=new JLabel("Dom Perigon Luminouse");
            newOrder.add(domLumiLabel,domLumi);
        }
        if(domM!=0){
            totale+=domM*950;
            JLabel domMLabel=new JLabel("Dom Perignon Magnum");
            newOrder.add(domMLabel,domM);
        }
        if(cristal!=0){
            totale+=cristal*550;
            JLabel cristalLabel=new JLabel("Cristal");
            newOrder.add(cristalLabel,cristal);
        }
        if(krug!=0){
            totale+=krug*450;
            JLabel krugLabel=new JLabel("Krug");
            newOrder.add(krugLabel,krug);
        }
        if(armand!=0){
            totale+=armand*600;
            JLabel armandLabel=new JLabel("Armand de Brignac");
            newOrder.add(armandLabel,armand);
        }
        if(armandRose!=0){
            totale+=armandRose*900;
            JLabel armandRoseLabel=new JLabel("Armand de Brignac Rose");
            newOrder.add(armandRoseLabel,armandRose);
        }
        if(armandVerde!=0){
            totale+=armandVerde*700;
            JLabel armandVerdeLabel=new JLabel("Armand de Brignac Verde");
            newOrder.add(armandVerdeLabel,armandVerde);
        }
        if(armandMagnum!=0){
            totale+=armandMagnum*1300;
            JLabel armandMagnumLabel=new JLabel("Armand de Brgnac Magnum");
            newOrder.add(armandMagnumLabel,armandMagnum);
        }
        if(bombay!=0){
            totale+=bombay*170;
            JLabel bombayLabel=new JLabel("Bambay");
            newOrder.add(bombayLabel,bombay);
        }
        if(bombayMagnum!=0){
            totale+=bombayMagnum*400;
            JLabel bombayMagnumLabel=new JLabel("Bombay Magnum");
            newOrder.add(bombayMagnumLabel,bombayMagnum);
        }
        if(havana!=0){
            totale+=havana*170;
            JLabel havanaLabel=new JLabel("Havana");
            newOrder.add(havanaLabel,havana);
        }
        if(below!=0){
            totale+=havana*170;
            JLabel belowLabel=new JLabel("Below 42");
            newOrder.add(belowLabel,below);
        }
        if(grey!=0){
            totale+=grey*220;
            JLabel greyLabel=new JLabel("Grey Goose");
            newOrder.add(greyLabel,grey);
        }
        if(greyMagnum!=0){
            totale+=greyMagnum*450;
            JLabel greyMagnumLabel=new JLabel("Grey Goose Magnum");
            newOrder.add(greyMagnumLabel,greyMagnum);
        }
        if(greyJ!=0){
            totale+=greyJ*950;
            JLabel greyJLabel=new JLabel("Grey Goose Jereboam");
            newOrder.add(greyJLabel,greyJ);
        }
        if(greyMat!=0){
            totale+=greyMat*1900;
            JLabel greyMatLabel=new JLabel("Grey Goose Mathusalem");
            newOrder.add(greyMatLabel,greyMat);
        }
        if(belvedereM!=0){
            totale+=belvedereM*550;
            JLabel belvedereMLabel=new JLabel("Belvedere Magnum Esseti");
            newOrder.add(belvedereMLabel,belvedereM);
        }
        if(hendricks!=0){
            totale+=hendricks*220;
            JLabel hendricksLabel=new JLabel("Hendricks");
            newOrder.add(hendricksLabel,hendricks);
        }
        if(mare!=0){
            totale+=mare*220;
            JLabel mareLabel=new JLabel("Gin Mare");
            newOrder.add(mareLabel,mare);
        }
        if(malfiP!=0){
            totale+=malfiP*200;
            JLabel malfiPLabel=new JLabel("Malfi Pompelmo");
            newOrder.add(malfiPLabel,malfiP);
        }
        if(malfiL!=0){
            totale+=malfiL*200;
            JLabel malfiLLabel=new JLabel("MAlfi Limone");
            newOrder.add(malfiLLabel,malfiL);
        }
        if(malfiA!=0){
            totale+=malfiA*200;
            JLabel malfiALabel=new JLabel("Malfi Arancia");
            newOrder.add(malfiALabel,malfiA);
        }
        JLabel totaleLabel=new JLabel(String.valueOf(totale));
        newOrder.add("TOTALE ORDINE",totaleLabel);
        Button completed=new Button("In corso");
        completed.setBackground(Color.blue);
        newOrder.add(completed);
        newOrder.getAlignmentY();
        newOrder.setBackground(Color.yellow);
        completed.addActionListener(e->{
            completed.setBackground(Color.GREEN);
            completed.setName("Completato");
           new OrdersPage.completedOrder(newOrder);
        });
       new OrdersPage.openOrder(newOrder);

    }
}
