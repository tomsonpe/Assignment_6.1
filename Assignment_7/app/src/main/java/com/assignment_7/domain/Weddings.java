package com.assignment_7.domain;

/**
 * Created by 214162966 on 4/17/2016.
 */
public class Weddings implements Events {
    private Long id;
    private String event_name;
    private String eventAddress;

    public Long getId(){
        return id;
    }

    public String getName(){
        return event_name;
    }

    public String getAddress(){
        return eventAddress;
    }

    public Weddings(Builder builder){
        this.id=id;
        this.event_name=builder.event_name;
        this.eventAddress=builder.eventAddress;
    }

    public static class Builder{
        private Long id;
        private String event_name;
        private String eventAddress;

        public Builder id(Long id){
            this.id=id;
            return this;
        }

        public Builder name(String event_name){
            this.event_name=event_name;
            return this;
        }

        public Builder address(String eventAddress){
            this.eventAddress=eventAddress;
            return this;
        }

        public Builder copy(Weddings wed){
            this.id=wed.getId();
            this.event_name=wed.getName();
            this.eventAddress=wed.getAddress();
            return this;
        }

        public Weddings build(){
            return new Weddings(this);
        }
    }
    public String getEvent(){
        return "wedding";
    }
    public String getTypeOfClient(){
        return getEvent();
    }
}
