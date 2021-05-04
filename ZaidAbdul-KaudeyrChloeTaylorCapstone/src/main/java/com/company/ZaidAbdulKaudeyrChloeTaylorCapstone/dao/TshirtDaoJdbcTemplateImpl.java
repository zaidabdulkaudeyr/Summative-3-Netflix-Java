package com.company.ZaidAbdulKaudeyrChloeTaylorCapstone.dao;

import com.company.ZaidAbdulKaudeyrChloeTaylorCapstone.model.Tshirt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.nio.charset.StandardCharsets;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class TshirtDaoJdbcTemplateImpl implements TshirtDao{

    // prepared statements
    private static final String INSERT_TSHIRT_SQL =
            "insert into t_shirt (size, color, description, price, quantity) values (?, ?, ?, ?, ?)";

    private static final String SELECT_TSHIRT_SQL =
            "select * from t_shirt where t_shirt_id = ?";

    private static final String SELECT_ALL_TSHIRTS_SQL =
            "select * from t_shirt";

    private static final String SELECT_TSHIRTS_BY_COLOR_SQL =
            "select * from t_shirt where color = ?";;

    private static final String SELECT_TSHIRTS_BY_SIZE_SQL =
            "select * from t_shirt where size = ?";;

    private static final String DELETE_TSHIRT_SQL =
            "delete from t_shirt where t_shirt_id = ?";

    private static final String UPDATE_TSHIRT_SQL =
            "update t_shirt set size = ?, color = ?, description = ?, price = ?, quantity = ? where t_shirt_id = ?";

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public TshirtDaoJdbcTemplateImpl (JdbcTemplate jdbcTemplate)
    {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional
    public Tshirt addTshirt(Tshirt tshirt){

        jdbcTemplate.update(INSERT_TSHIRT_SQL,
                tshirt.getSize(),
                tshirt.getColor(),
                tshirt.getDescription(),
                tshirt.getPrice(),
                tshirt.getQuantity());

        int id = jdbcTemplate.queryForObject("select last_insert_id()", Integer.class);
        tshirt.setId(id);
        return tshirt;
    }

    @Override
    public Tshirt getTshirt(int id){
        try
        {
            return jdbcTemplate.queryForObject(SELECT_TSHIRT_SQL, this::mapRowToTshirt, id);
        } catch (EmptyResultDataAccessException e)
        {
            // if nothing is returned just catch the exception and return null
            return null;
        }
    }

    @Override
    public List<Tshirt> getAllTshirts(){
        return jdbcTemplate.query(SELECT_ALL_TSHIRTS_SQL, this::mapRowToTshirt);
    }

    @Override
    public List<Tshirt> getTshirtByColor(String color){
        return jdbcTemplate.query(SELECT_TSHIRTS_BY_COLOR_SQL, this::mapRowToTshirt, color);
    }

    @Override
    public List<Tshirt> getTshirtBySize(String size){
        return jdbcTemplate.query(SELECT_TSHIRTS_BY_SIZE_SQL, this::mapRowToTshirt, size);
    }

    @Override
    public void updateTshirt(Tshirt tshirt)
    {
        jdbcTemplate.update(
                UPDATE_TSHIRT_SQL,
                tshirt.getSize(),
                tshirt.getColor(),
                tshirt.getDescription(),
                tshirt.getPrice(),
                tshirt.getQuantity(),
                tshirt.getId());
    }

    @Override
    public void deleteTshirt(int id){
        jdbcTemplate.update(DELETE_TSHIRT_SQL, id);
    }

    //row mapper
    private Tshirt mapRowToTshirt(ResultSet rs, int rowNum) throws SQLException
    {
        Tshirt tshirt = new Tshirt();
        tshirt.setId(rs.getInt("t_shirt_id"));
        tshirt.setSize(rs.getString("size"));
        tshirt.setColor(rs.getString("color"));
        tshirt.setDescription(rs.getString("description"));
        tshirt.setPrice(rs.getBigDecimal("price"));
        tshirt.setQuantity(rs.getInt("quantity"));

        return tshirt;
    }
}
