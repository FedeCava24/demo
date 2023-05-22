package com.example.demo;


public class Table {

    String[] TableNumber=new String[52];
    String[] TableName=new String[52];
    String[] PrName=new String[52];
    String[] PersonNumber=new String[52];

    Table(String tableNumber,String tableName,String prName,String personNumber){

       for (int i=0;i<=52;i++){
           if(TableNumber[i]==null){
               TableNumber[i]=tableNumber;
               TableName[i]=tableName;
               PrName[i]=prName;
               PersonNumber[i]=personNumber;
               break;
           }
       }

    }



    public String getTableNumber(){
        /*int i=0;
        for(int j=0;j<=52;j++){
            if(TableNumber[j]!=null){
                i++;
            }
        }

        String[] TableNumber2 = new String[i];
        i=0;
        for(int j=0;j<=52;j++){
            if(TableNumber[j]!=null){
                TableNumber2[i]=TableNumber[j];
               if(j!=52) {
                   i++;
               }
            }
        }
        return TableNumber2;*/
        return null;
    }
    public String getTableName(){
        /*int i=0;
        for(int j=0;j<=52;j++){
            if(TableNumber[j]!=null){
                i++;
            }
        }

        String[] TableName2 = new String[i];
        i=0;

        for(int j=0;j<=52;j++){
            if(TableName[j]!=null){
                TableName2[i]=TableName[j];
                if(j!=52) {
                    i++;
                }
            }
        }
        return TableName2;*/
        return null;
    }
    public String getPrName(){
        /*int i=0;
        for(int j=0;j<=52;j++){
            if(TableNumber[j]!=null){
                i++;
            }
        }

        String[] PrName2 = new String[i];
        i=0;
        for(int j=0;j<=52;j++){
            if(PrName[j]!=null){
                PrName2[i]=PrName[j];
                if(j!=52) {
                    i++;
                }
            }
        }
        return PrName2;*/
        return null;
    }
    public String getPersonNumber(){
       /* int i=0;
        for(int j=0;j<=52;j++){
            if(TableNumber[j]!=null){
                i++;
            }
        }

        String[] PersonNumber2 = new String[i];
        i=0;
        for(int j=0;j<=52;j++){
            if(PersonNumber[j]!=null){
                PersonNumber2[i]=PersonNumber[j];
                if(j!=52) {
                    i++;
                }
            }
        }
        return PersonNumber2;*/
        return null;
    }




}

