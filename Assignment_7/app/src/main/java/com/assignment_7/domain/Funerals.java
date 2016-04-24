package com.assignment_7.domain;

/**
 * Created by 214162966 on 4/17/2016.
 */
public class Funerals implements Events {
    private Long id;
    private String eventNo;
    private String event_name;
    public Long getId(){return id;}

    public String getNo(){
        return eventNo;
    }

    public String getName(){
        return event_name;
    }

    public Funerals(Builder builder){
        this.id=builder.id;
        this.eventNo=builder.eventNo;
        this.event_name=builder.event_name;
    }

    public static class Builder{
        private Long id;
        private String eventNo;
        private String event_name;

        public Builder id(Long id){
            this.id=id;
            return this;
        }
        public Builder no(String event_id){
            this.eventNo=event_id;
            return this;
        }

        public Builder name(String event_name){
            this.event_name=event_name;
            return this;
        }

        public Builder copy(Funerals fun){
            this.id=fun.getId();
            this.eventNo=fun.getNo();
            this.event_name=fun.getName();
            return this;
        }

        public Funerals build(){
            return new Funerals(this);
        }
    }
    public String getEvent(){
        return "wedding";
    }
    public String getTypeOfClient(){
        return getEvent();
    }
}
