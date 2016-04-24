package com.ddd.assignment_6.FactoryTest;

import com.ddd.assignment_6.Domain.Cash;
import com.ddd.assignment_6.Factory.CashFactory;
import junit.framework.Assert;


/**
 * Created by student on 2016/04/07.
 */
public class TestCash {
    private CashFactory factory;

    public void setUp()
    {
        factory= CashFactory.getInstance();
    }


    public void TestCreation()
    {
        Cash cash=factory.getCash("Encore");
        Assert.assertEquals("Encore",cash.getName());

        Cash update=new Cash.Builder().copy(cash).name("Encore").build();
        Assert.assertEquals(update.getName(), cash.getName());
    }
}
