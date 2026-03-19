package com.exercicio.crud_08.services;

import com.exercicio.crud_08.models.DepartamentoModel;
import com.exercicio.crud_08.repositories.DepartamentoRepository;
import org.springframework.stereotype.Service;

@Service
public class DepartamentoService {

    private final DepartamentoRepository departamentoRepository;

    public DepartamentoService(DepartamentoRepository departamentoRepository) {
        this.departamentoRepository = departamentoRepository;
    }

    public DepartamentoModel save(DepartamentoModel departamentoModel){
        return departamentoRepository.save(departamentoModel);
    }

}
