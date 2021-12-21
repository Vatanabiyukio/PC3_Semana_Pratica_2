package br.com.pc3.sp2.resources;

import br.com.pc3.sp2.domain.OficinaEntity;
import br.com.pc3.sp2.service.OficinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;


@Resource
@RestController
@RequestMapping(path = "/api/v1/oficinas")
public class OficinaResource {

    @Autowired
    private OficinaService oficinaService;

    @PostMapping
    public OficinaEntity save(@RequestBody OficinaEntity oficina) {
        return oficinaService.save(oficina);
    }

//    @GetMapping
//    public List<OficinaEntity> findAll() {
//        return oficinaService.findAll();
//    }

    @GetMapping
    public ResponseEntity<List<OficinaEntity>> findAll() {
        List<OficinaEntity> cursos = oficinaService.findAll();
        if (cursos == null || cursos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(cursos, HttpStatus.OK);
    }

    @GetMapping(path = {"/{codigo}"})
    public Optional<OficinaEntity> findById(@PathVariable("codigo") Integer codigo) {
        return oficinaService.findById(codigo);
    }

    @PutMapping(value = "/{codigo}")
    public OficinaEntity update(@PathVariable("codigo") Integer codigo, @RequestBody OficinaEntity oficina) {
        Optional<OficinaEntity> optional = oficinaService.findById(codigo);
        if (optional.isPresent()) {
            OficinaEntity c = optional.get();
            c.setNome(oficina.getNome());
            c.setEspecialidade(oficina.getEspecialidade());
            c.setEndereco(oficina.getEndereco());
            oficinaService.update(c);
            return c;
        } else {
            throw new RuntimeException("Não foi possível alterar registro");
        }
    }

    @DeleteMapping(path = {"/{codigo}"})
    public void delete(@PathVariable("codigo") Integer codigo) {
        oficinaService.deleteById(codigo);
    }
}