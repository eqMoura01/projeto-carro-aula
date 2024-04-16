package com.eqmoura.crud.repositoryJdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.eqmoura.crud.models.Carro;
import com.eqmoura.crud.repository.CarroRepository;

@Repository
public class CarroJdbc implements CarroRepository<Carro> {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void save(Carro object) {
        String query = "INSERT INTO entrada (modelo, fabricante, placa) VALUES (?, ?, ?)";

        jdbcTemplate.update(query, object.getModelo(), object.getFabricante(), object.getPlaca());
    }

    @Override
    public List<Carro> findAll() {
        String query = "select * from entrada";

        return jdbcTemplate.query(query, (response, rowNum) -> {
            Carro carro = new Carro(response.getLong("id"), response.getString("modelo"),
                    response.getString("fabricante"),
                    response.getString("placa"), response.getTimestamp("dataEntrada"));

            return carro;
        });
    }

    @Override
    public void update(Long id, Carro carro) {
        String query = "update entrada set modelo = ?, fabricante = ?, placa = ? where id=?";
        jdbcTemplate.update(query, carro.getModelo(), carro.getFabricante(), carro.getPlaca(), id);
    }

    @Override
    public Carro findById(Long id) {
        String query = "SELECT * FROM entrada WHERE id = ?";

        @SuppressWarnings("deprecation")
        Carro carro = jdbcTemplate.queryForObject(query, new Object[] { id }, new CarroRowMapper());

        return carro;
    }

    @Override
    public void deleteById(Long id) {
        String query = "delete from entrada where id = ?";
        jdbcTemplate.update(query, id);
    }
}
