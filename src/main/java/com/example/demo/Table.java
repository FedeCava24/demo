package com.example.demo;

import org.hibernate.mapping.List;

public class Table {
    String tableNumber;
    String tableName;
    String prName;
    String personNumber;

    Table(String tableNumber,String tableName,String prName,String personNumber){
        this.tableNumber=tableNumber;
        this.tableName=tableName;
        this.prName=prName;
        this.personNumber=personNumber;
    }

    public String toString(){
        String Stringa=this.tableNumber+" "+this.tableName+" "+this.prName+" "+this.personNumber;
        return Stringa;
    }

    public String getTableNumber(){
        return this.tableNumber;
    }
    public String getTableName(){
        return this.tableName;
    }
    public String getPrName(){
        return this.prName;
    }
    public String getPersonNumber(){
        return this.personNumber;
    }
}
