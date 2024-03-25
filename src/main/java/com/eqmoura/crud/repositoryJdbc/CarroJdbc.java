package com.eqmoura.crud.repositoryJdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.eqmoura.crud.models.Carro;
import com.eqmoura.crud.repository.CarroRepository;

@Repository
public class CarroJdbc implements CarroRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void save(Carro object) {
        String query = "INSERT INTO entrada (modelo, fabricante, placa) VALUES (?, ?, ?)";

        jdbcTemplate.update(query, object.getModelo(), object.getFabricante(), object.getPlaca());
    }

    @Override
    public List findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public void update(Long id, Carro carro) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void deleteById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }

    @Override
    public Carro findById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

}
