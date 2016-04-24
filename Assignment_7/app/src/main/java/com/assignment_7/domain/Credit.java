package com.assignment_7.domain;

/**
 * Created by 214162966 on 4/17/2016.
 */
public class Credit implements Payment {
    private Long id;
    private String credit_no;
    private String company_name;
    public Long getId(){return id;}
    public String getNumber(){
        return credit_no;
    }

    public String getName(){
        return company_name;

    }

    public Credit(Builder builder){
        this.id=builder.id;
        this.credit_no=builder.credit_no;
        this.company_name=builder.company_name;
    }
    public static class Builder{
        private Long id;
        private String credit_no;
        private String company_name;

        public Builder id(Long id){
            this.id=id;
            return this;
        }

        public Builder no(String credit_no){
            this.credit_no=credit_no;
            return this;
        }

        public Builder name(String company_name){
            this.company_name=company_name;
            return this;
        }

        public Builder copy(Credit credit){
            this.id=credit.getId();
            this.credit_no=credit.getNumber();
            this.company_name=credit.getName();

            return this;
        }
        public Credit build(){
            return new Credit(this);
        }
    }
    public String getTypeOfPayment(){
        return "Credit";
    }
}
