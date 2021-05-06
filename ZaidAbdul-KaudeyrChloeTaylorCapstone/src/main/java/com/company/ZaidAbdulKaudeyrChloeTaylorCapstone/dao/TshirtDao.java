package com.company.ZaidAbdulKaudeyrChloeTaylorCapstone.dao;

import com.company.ZaidAbdulKaudeyrChloeTaylorCapstone.model.Tshirt;

import java.util.List;

public interface TshirtDao {

    Tshirt addTshirt(Tshirt tshirt);

    Tshirt getTshirt(int id);

    List<Tshirt> getAllTshirts();

    List<Tshirt> getTshirtByColor(String color);

    List<Tshirt> getTshirtBySize(String size);

    void updateTshirt(Tshirt tshirt);

    void deleteTshirt(int id);
}
