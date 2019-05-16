package com.iontrading.functional.oopspattern.builder;

public class SalaryCalculator {
    public double plusAllowance(double d) {
        return d*1.2;
    }
    public double plusBonus(double d) {
        return d*1.1;
    }
    public double plusTax(double d) {
        return d*0.1;
    }
    public double plusSurcharge(double d) {
        return d*0.1;
    }

    public double calculate(double basic, boolean... bs){
        double salary = basic;
        if(bs[0]) salary = plusAllowance(salary);
        if(bs[1]) salary = plusBonus(salary);
        if(bs[2]) salary = plusTax(salary);
        if(bs[3]) salary = plusSurcharge(salary);
        return salary;
    }
}

class SalaryCalculateBuilder extends SalaryCalculator{

    private boolean withAllowance;
    private boolean withBonus;
    private boolean withTax;
    private boolean withSurcharge;

    public SalaryCalculateBuilder withAllowance() {
        withAllowance = true;
        return this;
    }
    public SalaryCalculateBuilder withBonus() {
        withBonus = true;
        return this;
    }
    public SalaryCalculateBuilder withTax() {
        withTax = true;
        return this;
    }
    public SalaryCalculateBuilder withSurcharge() {
        withSurcharge = true;
        return this;
    }

    public double calculate(double basic) {
        return super.calculate(basic, withAllowance, withBonus, withTax, withSurcharge);
    }
}



class Main {
    public static void main(String[] args) {
        System.out.println(new SalaryCalculator().calculate(1000.0, true, true, false, false));
        //or
        System.out.println(new SalaryCalculateBuilder().withAllowance().withBonus().calculate(1000.0));
    }
}

