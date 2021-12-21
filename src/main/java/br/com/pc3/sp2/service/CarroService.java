package br.com.pc3.sp2.service;

import br.com.pc3.sp2.domain.CarroEntity;
import br.com.pc3.sp2.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarroService {
    @Autowired
    private CarroRepository carroRepository;

    public CarroEntity save(CarroEntity carro) {
        return carroRepository.save(carro);
    }

    public List<CarroEntity> findAll() {
        return (List<CarroEntity>) carroRepository.findAll();
    }

    public Optional<CarroEntity> findById(String id) {
        return carroRepository.findById(id);
    }

    public CarroEntity update(CarroEntity carro) {
        return carroRepository.save(carro);
    }

    public void deleteById(String id) {
        carroRepository.deleteById(id);
    }
}
