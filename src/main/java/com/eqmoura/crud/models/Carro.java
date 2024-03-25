package com.eqmoura.crud.models;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class Carro {

    private Long id;
    private String modelo;
    private String fabricante;
    private String placa;
    private Timestamp dataEntrada;

    public Carro(String modelo, String fabricante, String placa, Timestamp dataEntrada) {
        this.modelo = modelo;
        this.fabricante = fabricante;
        this.placa = placa;
        this.dataEntrada = dataEntrada;
    }

}
