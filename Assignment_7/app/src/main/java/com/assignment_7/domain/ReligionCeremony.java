package com.assignment_7.domain;

/**
 * Created by 214162966 on 4/17/2016.
 */
public class ReligionCeremony implements Ceremonies {
    private Long id;
    private String event_name;
    private String eventAddress;

    public Long getId(){return id;}

    public String getName(){
        return event_name;
    }

    public String getAddress(){
        return eventAddress;
    }

    public ReligionCeremony(Builder builder){

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

        public Builder copy(ReligionCeremony rel){
            this.id=rel.getId();
            this.event_name=rel.getName();
            this.eventAddress=rel.getAddress();
            return this;
        }

        public ReligionCeremony build(){
            return new ReligionCeremony(this);
        }
    }
    public String getTypeOfCeremony(){
        return "Religion";
    }
    public String getEvent(){
        return getTypeOfCeremony();
    }
    public String getTypeOfClient(){
        return getEvent();
    }
}
