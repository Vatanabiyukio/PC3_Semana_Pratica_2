package br.com.pc3.sp2.service;

import br.com.pc3.sp2.domain.ClienteEntity;
import br.com.pc3.sp2.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteEntity save(ClienteEntity cliente) {
        return clienteRepository.save(cliente);
    }

    public List<ClienteEntity> findAll() {
        return (List<ClienteEntity>) clienteRepository.findAll();
    }

    public Optional<ClienteEntity> findById(String id) {
        return clienteRepository.findById(id);
    }

    public ClienteEntity update(ClienteEntity cliente) {
        return clienteRepository.save(cliente);
    }

    public void deleteById(String id) {
        clienteRepository.deleteById(id);
    }
}
