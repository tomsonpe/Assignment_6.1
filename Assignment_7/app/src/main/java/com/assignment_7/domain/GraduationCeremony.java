package com.assignment_7.domain;

/**
 * Created by 214162966 on 4/17/2016.
 */
public class GraduationCeremony implements Ceremonies {
    private Long id;
    private String event_no;
    private String event_name;
    public Long getId(){return id;}
    public String getNo(){
        return event_no;
    }

    public String getName(){
        return event_name;
    }

    public GraduationCeremony(Builder builder){
        this.id=builder.id;
        this.event_no=builder.event_no;
        this.event_name=builder.event_name;
    }

    public static class Builder{
        private Long id;
        private String event_no;
        private String event_name;

        public Builder id(Long id){
            this.id=id;
            return this;
        }

        public Builder no(String event_no) {
            this.event_no = event_no;
            return this;
        }

        public Builder name(String event_name){
            this.event_name=event_name;
            return this;
        }

        public Builder copy(GraduationCeremony grad){
            this.id=grad.getId();
            this.event_no=grad.getNo();
            this.event_name=grad.getName();
            return this;
        }

        public GraduationCeremony build(){
            return new GraduationCeremony(this);
        }
    }
    public String getTypeOfCeremony(){
        return "Graduation";
    }
    public String getEvent(){
        return getTypeOfCeremony();
    }
    public String getTypeOfClient(){
        return getEvent();
    }
}
