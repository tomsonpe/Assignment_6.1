package com.assignment_7.domain;

/**
 * Created by 214162966 on 4/17/2016.
 */
public class Cheque implements Payment {
    private Long id;
    private String cheque_no;
    private String company_name;
    public Long getId(){return id;}
    public String getNumber(){
        return cheque_no;
    }

    public String getName(){
        return company_name=company_name;

    }

    public Cheque(Builder builder){
        this.id=builder.id;
        this.cheque_no=builder.cheque_no;
        this.company_name=builder.company_name;
    }
    public static class Builder{
        private Long id;
        private String cheque_no;
        private String company_name;
        public Builder id(Long id){
            this.id=id;
            return this;
        }
        public Builder no(String cheque_no){
            this.cheque_no=cheque_no;
            return this;
        }

        public Builder name(String company_name){
            this.company_name=company_name;
            return this;
        }

        public Builder copy(Cheque cheque){
            this.id=cheque.getId();
            this.cheque_no=cheque.getNumber();
            this.company_name=cheque.getName();

            return this;
        }
        public Cheque build(){
            return new Cheque(this);
        }
    }
    public String getTypeOfPayment(){
        return "deposit";
    }
}
