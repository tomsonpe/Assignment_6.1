package com.assignment_7.domain;

/**
 * Created by 214162966 on 4/17/2016.
 */
public class PhotoEditor implements Editor {
    private Long id;
    private String pEditorFirstName;
    private String pEditorLastName;
    public Long getId(){return id;}
    public String getFirstName(){
        return pEditorFirstName;
    }

    public String getLastName(){
        return pEditorLastName;
    }
    public PhotoEditor(Builder build){
        pEditorFirstName=build.pEditorFirstName;
        pEditorLastName=build.pEditorLastName;
    }
    public static class Builder{
        private Long id;
        private String pEditorFirstName;
        private String pEditorLastName;
        public Builder id(Long id){
            this.id=id;
            return this;
        }

        public Builder first(String pEditorFirstName){
            this.pEditorFirstName=pEditorFirstName;
            return this;
        }
        public Builder last(String pEditorLastName){
            this.pEditorLastName=pEditorLastName;
            return this;
        }
        public Builder copy(PhotoEditor edit){
            this.pEditorFirstName=edit.getFirstName();
            this.pEditorLastName=edit.getLastName();

            return this;
        }

        public PhotoEditor build(){
            return new PhotoEditor(this);
        }
    }

    public String getEditor()
    {
        return "Focus on editing photos";
    }

    public String getTypeOfEmployee(){
        return getEditor();
    }
}
