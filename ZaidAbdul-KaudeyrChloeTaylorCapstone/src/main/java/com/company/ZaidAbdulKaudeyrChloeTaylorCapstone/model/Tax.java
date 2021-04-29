package com.company.ZaidAbdulKaudeyrChloeTaylorCapstone.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Tax
{
    //properties
    private char state;
    private BigDecimal rate;

    //getters and setters
    public char getState() {
        return state;
    }

    public void setState(char state) {
        this.state = state;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    //equals and hashcode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tax tax = (Tax) o;
        return state == tax.state && Objects.equals(rate, tax.rate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(state, rate);
    }
}
