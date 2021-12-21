package br.com.pc3.sp2.service;

import br.com.pc3.sp2.domain.OficinaEntity;
import br.com.pc3.sp2.repository.OficinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class OficinaService {
    @Autowired
    private OficinaRepository oficinaRepository;

    public OficinaEntity save(OficinaEntity oficina) {
        return oficinaRepository.save(oficina);
    }

    public List<OficinaEntity> findAll() {
        return (List<OficinaEntity>) oficinaRepository.findAll();
    }

    public Optional<OficinaEntity> findById(Integer id) {
        return oficinaRepository.findById(id);
    }

    public OficinaEntity update(OficinaEntity oficina) {
        return oficinaRepository.save(oficina);
    }

    public void deleteById(Integer id) {
        oficinaRepository.deleteById(id);
    }
}
