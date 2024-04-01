package com.eqmoura.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.eqmoura.crud.models.Carro;
import com.eqmoura.crud.repository.CarroRepository;
import com.eqmoura.crud.util.ValidaPlaca;

@Controller
public class CarroController {

    @Autowired
    private CarroRepository carroRepository;

    @PostMapping("/entrada")
    public String salvarCarro(@RequestParam("modelo") String modelo, @RequestParam("fabricante") String fabricante,
            @RequestParam("placa") String placa, Model m) {

        String resultado = "O cadastro do veiculo falhou!";

        Carro carro = new Carro(modelo, fabricante, placa, null);

        if (ValidaPlaca.validarPlaca(placa)) {

            carroRepository.save(carro);

            resultado = "Carro cadastrado com sucesso";

        } else {
            resultado = "Placa invalida!";
        }

        m.addAttribute("resultado", resultado);

        return "sucesso_carro";
    }

    @GetMapping("/listAll")
    public String listAll(Model m) {

        List<Carro> carros = carroRepository.findAll();
        m.addAttribute("carros", carros);

        return "listaCarros";
    }
}
