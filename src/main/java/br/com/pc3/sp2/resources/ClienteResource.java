package br.com.pc3.sp2.resources;

import br.com.pc3.sp2.domain.ClienteEntity;
import br.com.pc3.sp2.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;


@Resource
@RestController
@RequestMapping(path = "/api/v1/clientes")
public class ClienteResource {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ClienteEntity save(@RequestBody ClienteEntity cliente) {
        return clienteService.save(cliente);
    }

    @GetMapping
    public List<ClienteEntity> findAll() {
        return clienteService.findAll();
    }

    @GetMapping(path = {"/{cpf}"})
    public Optional<ClienteEntity> findById(@PathVariable("cpf") String cpf) {
        return clienteService.findById(cpf);
    }

    @PutMapping(value = "/{cpf}")
    public ClienteEntity update(@PathVariable("cpf") String cpf, @RequestBody ClienteEntity cliente) {
        Optional<ClienteEntity> optional = clienteService.findById(cpf);
        if (optional.isPresent()) {
            ClienteEntity c = optional.get();
            c.setNome(cliente.getNome());
            c.setDataNascimento(cliente.getDataNascimento());
            clienteService.update(c);
            return c;
        } else {
            throw new RuntimeException("Não foi possível alterar registro");
        }
    }

    @DeleteMapping(path = {"/{cpf}"})
    public void delete(@PathVariable("cpf") String cpf) {
        clienteService.deleteById(cpf);
    }
}
