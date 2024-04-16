package com.eqmoura.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

        Carro carro = new Carro(null, modelo, fabricante, placa, null);

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

    @GetMapping("/carro/{id}")
    public String findById(@PathVariable Long id, Model m) {

        Carro carro = carroRepository.findById(id);

        m.addAttribute("carro", carro);

        return "CarroEditar";
    }

    @PostMapping("/carro_editar")
    public String update(@RequestParam Long id, @RequestParam("modelo") String modelo,
            @RequestParam("fabricante") String fabricante,
            @RequestParam("placa") String placa, Model m) {
        carroRepository.update(id, new Carro(id, modelo, fabricante, placa, null));

        return "redirect:/listAll";
    }

    @GetMapping("/carro/deletar/{id}")
    public String deleteById(@PathVariable Long id) {
        carroRepository.deleteById(id);
        return "redirect:/listAll";
    }
}
