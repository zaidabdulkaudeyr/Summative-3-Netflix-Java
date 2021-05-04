package com.company.ZaidAbdulKaudeyrChloeTaylorCapstone.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Tax
{
    //properties
    private String state;
    private BigDecimal rate;

    //getters and setters
    public String getState() {
        return state;
    }

    public void setState(String state) {
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
        return Objects.equals(getState(), tax.getState()) && Objects.equals(getRate(), tax.getRate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getState(), getRate());
    }
}
