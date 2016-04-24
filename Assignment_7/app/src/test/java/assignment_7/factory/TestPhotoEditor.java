package com.ddd.assignment_6.FactoryTest;

import com.ddd.assignment_6.Domain.Cash;
import com.ddd.assignment_6.Domain.PhotoEditor;
import com.ddd.assignment_6.Factory.CashFactory;
import com.ddd.assignment_6.Factory.PhotoEditorFactory;


import junit.framework.Assert;

/**
 * Created by student on 2016/04/07.
 */
public class TestPhotoEditor {
    private PhotoEditorFactory factory;

    public void setUp()
    {
        factory= PhotoEditorFactory.getInstance();
    }

    public void TestPhotoCreation()
    {
        PhotoEditor edit=factory.getEdit("Encore","Tomson");

        Assert.assertEquals("Encore",edit.getFirstName());
        Assert.assertEquals("Tomson",edit.getLastName());

        PhotoEditor updatePhoto=new PhotoEditor.Builder().copy(edit).first("Encore").build();

        Assert.assertEquals(updatePhoto.getFirstName(), edit.getFirstName());
        Assert.assertEquals(updatePhoto.getLastName(), edit.getLastName());
    }
}
