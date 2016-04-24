package com.ddd.assignment_6.FactoryTest;

import com.ddd.assignment_6.Domain.Cash;
import com.ddd.assignment_6.Factory.CashFactory;

import junit.framework.Assert;
/**
 * Created by student on 2016/04/07.
 */
import com.ddd.assignment_6.Domain.Cheque;
import com.ddd.assignment_6.Factory.ChequeFactory;
public class TestCheque {
    private ChequeFactory factory;

    public void setUp()
    {
        factory= ChequeFactory.getInstance();
    }


    public void TestCreation()
    {
        Cheque cheque=factory.getCheque("4151D", "Encore");

        Assert.assertEquals("4151D",cheque.getNumber());
        Assert.assertEquals("Encore",cheque.getName());

        Cheque update=new Cheque.Builder().copy(cheque).no("4151D").build();
        Assert.assertEquals(update.getNumber(),cheque.getNumber());
        Assert.assertEquals(update.getName(), cheque.getName());
    }
}
