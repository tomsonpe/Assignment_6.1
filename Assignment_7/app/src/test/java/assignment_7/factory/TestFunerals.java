package com.ddd.assignment_6.FactoryTest;

import com.ddd.assignment_6.Domain.Cash;
import com.ddd.assignment_6.Domain.Funerals;
import com.ddd.assignment_6.Factory.CashFactory;
import com.ddd.assignment_6.Factory.FuneralFactory;

import junit.framework.Assert;

/**
 * Created by student on 2016/04/07.
 */
public class TestFunerals {
    private FuneralFactory factory;

    public void setUp()
    {
        factory= FuneralFactory.getInstance();
    }

    public void TestCreation()
    {
        Funerals fun=factory.getFuneral("45455","Funeral");
        Assert.assertEquals("45455", fun.getNo());
        Assert.assertEquals("Funeral",fun.getName());

        Funerals update=new Funerals.Builder().copy(fun).no("45455").build();
        Assert.assertEquals(update.getNo(), fun.getNo());
        Assert.assertEquals(update.getName(), fun.getName());
    }
}
