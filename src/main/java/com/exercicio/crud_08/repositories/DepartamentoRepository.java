package com.exercicio.crud_08.repositories;

import com.exercicio.crud_08.models.DepartamentoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartamentoRepository extends JpaRepository<DepartamentoModel, Long> {

}
