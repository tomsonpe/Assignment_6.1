package com.ddd.assignment_6.FactoryTest;


import com.ddd.assignment_6.Domain.Weddings;
import com.ddd.assignment_6.Factory.WeddingFactory;
import junit.framework.Assert;

/**
 * Created by student on 2016/04/07.
 */
public class TestWedding {
    private WeddingFactory factory;

    public void setUp()
    {
        factory= WeddingFactory.getInstance();
    }


    public void TestCreation()
    {
        Weddings wed=factory.getWedding("PETomson", "24946 katali street 7100");

        Assert.assertEquals("PETomson",wed.getName());
        Assert.assertEquals("24946 katali street 7100",wed.getAddress());

        Weddings update=new Weddings.Builder().copy(wed).name("Encore").build();

        Assert.assertEquals(update.getName(), wed.getName());
        Assert.assertEquals(update.getAddress(), wed.getAddress());
    }
}
