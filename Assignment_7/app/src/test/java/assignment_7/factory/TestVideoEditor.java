package com.ddd.assignment_6.FactoryTest;


import com.ddd.assignment_6.Domain.VideoEditor;
import com.ddd.assignment_6.Factory.VideoEditorFactory;

import junit.framework.Assert;
/**
 * Created by student on 2016/04/07.
 */
public class TestVideoEditor {
    private VideoEditorFactory factory;

    public void setUp()
    {
        factory= VideoEditorFactory.getInstance();
    }


    public void Test()
    {
        VideoEditor edit=factory.getEdit("Encore","Tomson");

        Assert.assertEquals("Encore",edit.getFirstName());
        Assert.assertEquals("Tomson",edit.getLastName());

        VideoEditor update=new VideoEditor.Builder().copy(edit).first("Encore").build();
        Assert.assertEquals(update.getFirstName(), edit.getFirstName());
        Assert.assertEquals(update.getLastName(), edit.getLastName());
    }
}
