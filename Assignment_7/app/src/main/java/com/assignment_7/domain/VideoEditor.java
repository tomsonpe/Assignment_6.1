package com.assignment_7.domain;

/**
 * Created by 214162966 on 4/17/2016.
 */
public class VideoEditor implements Editor {
    private Long id;
    private String vEditorFirstName;
    private String vEditorLastName;

    public Long getId(){return id;}
    public String getFirstName(){
        return vEditorFirstName;
    }

    public String getLastName(){
        return vEditorLastName;
    }
    public VideoEditor(Builder build){
        vEditorFirstName=build.vEditorFirstName;
        vEditorLastName=build.vEditorLastName;
    }
    public static class Builder{
        private Long id;
        private String vEditorFirstName;
        private String vEditorLastName;

        public Builder id(Long id){
            this.id=id;
            return this;
        }

        public Builder first(String vEditorFirstName){
            this.vEditorFirstName=vEditorFirstName;
            return this;
        }
        public Builder last(String vEditorLastName){
            this.vEditorLastName=vEditorLastName;
            return this;
        }
        public Builder copy(VideoEditor edit){
            this.vEditorFirstName=edit.getFirstName();
            this.vEditorLastName=edit.getLastName();

            return this;
        }

        public VideoEditor build(){
            return new VideoEditor(this);
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

