package com.eqmoura.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.eqmoura.crud.models.Carro;
import com.eqmoura.crud.repository.CarroRepository;

@Controller
public class CarroController {

    @Autowired
    private CarroRepository carroRepository;

    @PostMapping("/entrada")
    public String salvarCarro(@RequestParam("modelo") String modelo, @RequestParam("fabricante") String fabricante,
            @RequestParam("placa") String placa, Model m) {

        Carro carro = new Carro(modelo, fabricante, placa, null);

        carroRepository.save(carro);

        m.addAttribute("carro", carro);

        return "sucesso_carro";
    }

}
