package com.company.ZaidAbdulKaudeyrChloeTaylorCapstone.dao;

import com.company.ZaidAbdulKaudeyrChloeTaylorCapstone.model.Console;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class ConsoleDaoJdbcTemplateImpl implements ConsoleDao {

    private JdbcTemplate jdbcTemplate;

    //Prepared statements strings

    private static final String INSERT_CONSOLE_SQL =
            "insert into console (model, manufacturer, memory_amount) values ()";

    @Autowired
    public ConsoleDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {this.jdbcTemplate = jdbcTemplate;}

    @Override
    @Transactional
    public Console addConsole(Console console) {
        return console;
    }

    @Override
    public Console getConsole(int id) {
        return null;
    }

    @Override
    public List<Console> getAllConsoles() {
        return null;
    }

    @Override
    public List<Console> getConsolesByManufacturer(String manufacturer) {
        return null;
    }

    @Override
    public void updateConsole(Console console) {

    }

    @Override
    public void deleteConsole(int id){

    }


}
