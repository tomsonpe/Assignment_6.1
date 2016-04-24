package com.assignment_7.factory;


import com.assignment_7.domain.GraduationCeremony;

/**
 * Created by 214162966 on 4/17/2016.
 */
public class GraduationCerFactory {
    public static GraduationCerFactory graduate=null;
    public GraduationCerFactory(){
    }
    public static GraduationCerFactory getInstance(){
        if(graduate==null){
            graduate=new GraduationCerFactory();
        }
        return graduate;
    }
    public static GraduationCeremony getCeremony(String event_id,String event_name){
        GraduationCeremony grad=new GraduationCeremony.Builder()
                .no(event_id)
                .name(event_name)
                .build();
        return grad;
    }
}