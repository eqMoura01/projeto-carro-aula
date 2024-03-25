package com.eqmoura.crud.repository;

import java.util.List;

import com.eqmoura.crud.models.Carro;

public interface CarroRepository<T> {

    void save(Carro object);

    List<Carro> findAll();

    void update(Long id, Carro carro);

    void deleteById(Long id);

    Carro findById(Long id);

}
