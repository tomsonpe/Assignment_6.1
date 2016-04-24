package com.assignment_7.factory;


import com.assignment_7.domain.Funerals;

/**
 * Created by 214162966 on 4/17/2016.
 */
public class FuneralFactory {
    public static FuneralFactory funeral=null;
    public FuneralFactory(){
    }
    public static FuneralFactory getInstance(){
        if(funeral==null){
            funeral=new FuneralFactory();
        }
        return funeral;
    }
    public static Funerals getFuneral(String event_id,String event_name){
        Funerals fun=new Funerals.Builder()
                .no(event_id)
                .name(event_name)
                .build();
        return fun;
    }
}
