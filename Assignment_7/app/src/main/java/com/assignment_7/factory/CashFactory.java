package com.assignment_7.factory;


import com.assignment_7.domain.Cash;

/**
 * Created by 214162966 on 4/17/2016.
 */
public class CashFactory {
    public static CashFactory cashy=null;
    public CashFactory(){
    }
    public static CashFactory getInstance(){
        if(cashy==null){
            cashy=new CashFactory();
        }
        return cashy;
    }
    public static Cash getCash(String company_name){
        Cash cash=new Cash.Builder()
                .name(company_name)
                .build();
        return cash;
    }
}

