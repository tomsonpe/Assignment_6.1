package com.assignment_7.domain;

/**
 * Created by 214162966 on 4/17/2016.
 */
public class Videos {
    private Long id;
    private String cameramanFirstName;
    private String cameramanLastName;

    public Long getId(){return id;}

    public String getCameramanFirstName(){
        return cameramanFirstName;
    }

    public String getCameramanLastName(){
        return cameramanLastName;
    }

    public Videos(Builder build){
        cameramanFirstName=build.cameramanFirstName;
        cameramanLastName=build.cameramanLastName;
    }
    public static class Builder{
        private Long id;
        private String cameramanFirstName;
        private String cameramanLastName;

        public Builder id(Long id){
            this.id=id;
            return this;
        }

        public Builder first(String cameramanFirstName){
            this.cameramanFirstName =cameramanFirstName;
            return this;
        }

        public Builder last(String cameramanLastName){
            this.cameramanLastName=cameramanLastName;
            return this;
        }

        public Builder copy(Videos video){
            id=video.getId();
            cameramanFirstName=video.getCameramanFirstName();
            cameramanLastName=video.getCameramanLastName();
            return this;
        }
        public Videos build(){
            return new Videos(this);
        }
    }
    public String getPhotographer(){
        return "I'm focusing on videos";
    }
    public String getTypeOfEmployee(){
        return getPhotographer();
    }

}
