package com.assignment_7.factory;


import com.assignment_7.domain.Credit;

/**
 * Created by 214162966 on 4/17/2016.
 */
public class CreditFactory {
    public static CreditFactory credit = null;

    public CreditFactory() {
    }

    public static CreditFactory getInstance() {
        if (credit == null) {
            credit = new CreditFactory();
        }
        return credit;
    }

    public static Credit getCredit(String credit_no, String company_name) {
        Credit credit = new Credit.Builder()
                .no(credit_no)
                .name(company_name)
                .build();
        return credit;
    }
}
