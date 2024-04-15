package com.eqmoura.crud.repositoryJdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.eqmoura.crud.models.Carro;

public class CarroRowMapper implements RowMapper<Carro> {

    @Override
    public Carro mapRow(ResultSet rs, int rowNum) throws SQLException {
        Carro carro = new Carro(rs.getLong("id"), rs.getString("modelo"), rs.getString("fabricante"),
                rs.getString("placa"), null);

        return carro;
    }

}
