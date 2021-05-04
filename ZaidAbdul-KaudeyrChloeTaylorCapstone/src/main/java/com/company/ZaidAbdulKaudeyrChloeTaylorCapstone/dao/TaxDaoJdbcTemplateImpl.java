package com.company.ZaidAbdulKaudeyrChloeTaylorCapstone.dao;

import com.company.ZaidAbdulKaudeyrChloeTaylorCapstone.model.Tax;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class TaxDaoJdbcTemplateImpl implements  TaxDao{

    //Prepared statements
    private static final String SELECT_TAX_SQL =
            "select * from sales_tax_rate where state = ?";

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public TaxDaoJdbcTemplateImpl (JdbcTemplate jdbcTemplate)
    {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional
    public Tax getTaxByState(String state){
        return null;
    }

    //row mapper
    private Tax mapRowToTax(ResultSet rs, int rowNum) throws SQLException
    {
        Tax tax = new Tax();
        tax.setState(rs.getString("state"));
        tax.setRate(rs.getBigDecimal("rate"));

        return tax;
    }

}
