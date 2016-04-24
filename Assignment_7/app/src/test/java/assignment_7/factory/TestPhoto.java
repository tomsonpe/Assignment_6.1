package com.ddd.assignment_6.FactoryTest;

import com.ddd.assignment_6.Domain.Cash;
import com.ddd.assignment_6.Domain.Photos;
import com.ddd.assignment_6.Factory.CashFactory;
import com.ddd.assignment_6.Factory.PhotoFactory;


import junit.framework.Assert;

/**
 * Created by student on 2016/04/07.
 */
public class TestPhoto {
    private PhotoFactory factory;

    public void setUp()
    {
        factory= PhotoFactory.getInstance();
    }


    public void TestPhotoCreation()
    {
        Photos photo=factory.getPhoto("Encore","Tomson");

        Assert.assertEquals("Encore",photo.getCameramanFirstName());
        Assert.assertEquals("Tomson",photo.getCameramanLastName());

        Photos updatePhoto=new Photos.Builder().copy(photo).first("Encore").build();

        Assert.assertEquals(updatePhoto.getCameramanFirstName(),photo.getCameramanFirstName());
        Assert.assertEquals(updatePhoto.getCameramanLastName(),photo.getCameramanLastName());
    }
}
