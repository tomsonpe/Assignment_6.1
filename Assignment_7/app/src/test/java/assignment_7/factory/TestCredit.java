package com.ddd.assignment_6.FactoryTest;

import com.ddd.assignment_6.Factory.CreditFactory;
import com.ddd.assignment_6.Domain.Credit;
import junit.framework.Assert;
import com.ddd.assignment_6.Factory.CashFactory;

/**
 * Created by student on 2016/04/07.
 */
public class TestCredit {
    private CreditFactory factory;

    public void setUp()
    {
        factory= CreditFactory.getInstance();
    }

    public void TestCreation()
    {
        Credit credit=factory.getCredit("4554555","Encore");

        Assert.assertEquals("4554555",credit.getNumber());
        Assert.assertEquals("Encore",credit.getName());

        Credit update=new Credit.Builder().copy(credit).no("4554555").build();
        Assert.assertEquals(update.getNumber(),credit.getNumber());
        Assert.assertEquals(update.getName(), credit.getName());
    }
}
