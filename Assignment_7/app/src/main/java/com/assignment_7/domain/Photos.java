package com.assignment_7.domain;

/**
 * Created by 214162966 on 4/17/2016.
 */
public class Photos implements Photographer {
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

    public Photos(Builder builder){
        cameramanFirstName=builder.cameramanFirstName;
        cameramanLastName=builder.cameramanLastName;
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
            this.cameramanFirstName=cameramanFirstName;
            return this;
        }

        public Builder last(String cameramanLastName){
            this.cameramanLastName=cameramanLastName;
            return this;
        }

        public Builder copy(Photos photo){
            this.id=photo.getId();
            this.cameramanFirstName=photo.getCameramanFirstName();
            this.cameramanLastName=photo.getCameramanLastName();

            return this;
        }

        public Photos build(){
            return new Photos(this);
        }

    }

    public String getPhotographer(){
        return "I'm focusing on photos";
    }
    public String getTypeOfEmployee(){
        return getPhotographer();
    }
}

