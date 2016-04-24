package com.ddd.assignment_6.FactoryTest;

import com.ddd.assignment_6.Domain.Cash;
import com.ddd.assignment_6.Domain.GraduationCeremony;
import com.ddd.assignment_6.Factory.CashFactory;
import com.ddd.assignment_6.Factory.GraduationCerFactory;


import junit.framework.Assert;
/**
 * Created by student on 2016/04/07.
 */
public class TestGraduation {
    private GraduationCerFactory factory;

    public void setUp()
    {
        factory= GraduationCerFactory.getInstance();
    }


    public void TestCreation()
    {
        GraduationCeremony grad=factory.getCeremony("1452","BDP");
        Assert.assertEquals("1452", grad.getNo());
        Assert.assertEquals("BDP", grad.getName());

        GraduationCeremony update=new GraduationCeremony.Builder().copy(grad).no("1452").build();
        Assert.assertEquals(update.getNo(), grad.getNo());
        Assert.assertEquals(update.getName(), grad.getName());
    }
}
