package com.ddd.assignment_6.FactoryTest;

import com.ddd.assignment_6.Domain.Videos;
import com.ddd.assignment_6.Factory.VideoFactory;
import junit.framework.Assert;

/**
 * Created by student on 2016/04/07.
 */
public class TestVideo {
    private VideoFactory factory;

    public void setUp()
    {
        factory= VideoFactory.getInstance();
    }


    public void TestVideoCreation()
    {
        Videos video=factory.getVideo("Encore", "Tomson");


        Assert.assertEquals("Encore",video.getCameramanFirstName());
        Assert.assertEquals("Tomson",video.getCameramanLastName());

        Videos updatePhoto=new Videos.Builder().copy(video).first("Encore").build();
        Assert.assertEquals(updatePhoto.getCameramanFirstName(), video.getCameramanFirstName());
        Assert.assertEquals(updatePhoto.getCameramanLastName(), video.getCameramanLastName());
    }
}
