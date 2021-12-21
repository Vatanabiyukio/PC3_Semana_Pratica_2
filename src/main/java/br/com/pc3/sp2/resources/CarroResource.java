package br.com.pc3.sp2.resources;

import br.com.pc3.sp2.domain.CarroEntity;
import br.com.pc3.sp2.service.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;


@Resource
@RestController
@RequestMapping(path = "/api/v1/carros")
public class CarroResource {

    @Autowired
    private CarroService carroService;

    @PostMapping
    public CarroEntity save(@RequestBody CarroEntity carro) {
        return carroService.save(carro);
    }

    @GetMapping
    public List<CarroEntity> findAll() {
        return carroService.findAll();
    }

    @GetMapping(path = {"/{placa}"})
    public Optional<CarroEntity> findById(@PathVariable("placa") String placa) {
        return carroService.findById(placa);
    }

    @PutMapping(value = "/{placa}")
    public CarroEntity update(@PathVariable("placa") String placa, @RequestBody CarroEntity carro) {
        Optional<CarroEntity> optional = carroService.findById(placa);
        if (optional.isPresent()) {
            CarroEntity c = optional.get();
            c.setCor(carro.getCor());
            c.setAno(carro.getAno());
            c.setAnoModelo(carro.getAnoModelo());
            c.setMarca(carro.getMarca());
            c.setModelo(carro.getModelo());
            carroService.update(c);
            return c;
        } else {
            throw new RuntimeException("Não foi possível alterar os registro");
        }
    }

    @DeleteMapping(path = {"/{placa}"})
    public void delete(@PathVariable("placa") String placa) { carroService.deleteById(placa); }

}