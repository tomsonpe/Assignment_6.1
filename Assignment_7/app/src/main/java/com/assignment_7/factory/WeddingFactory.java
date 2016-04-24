package com.assignment_7.factory;


import com.assignment_7.domain.Weddings;

/**
 * Created by 214162966 on 4/17/2016.
 */
public class WeddingFactory {
    public static WeddingFactory wedin=null;
    public WeddingFactory(){
    }
    public static WeddingFactory getInstance(){
        if(wedin==null){
            wedin=new WeddingFactory();
        }
        return wedin;
    }
    public static Weddings getWedding(String event_name,String eventAddress ){
        Weddings wed=new Weddings.Builder()
                .name(event_name)
                .address(eventAddress)
                .build();
        return wed;
    }
}

