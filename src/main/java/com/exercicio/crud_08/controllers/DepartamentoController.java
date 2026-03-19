package com.exercicio.crud_08.controllers;


import com.exercicio.crud_08.models.DepartamentoModel;
import com.exercicio.crud_08.services.DepartamentoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/departamentos")
public class DepartamentoController {

    private final DepartamentoService departamentoService;

    public DepartamentoController(DepartamentoService departamentoService) {
        this.departamentoService = departamentoService;
    }

    @PostMapping
    public ResponseEntity<DepartamentoModel> save(@RequestBody DepartamentoModel departamentoModel){
        DepartamentoModel departamento = departamentoService.save(departamentoModel);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(departamento.getId())
                .toUri();

        return ResponseEntity.ok().body(departamento);
    }

    @GetMapping
    public ResponseEntity<List<DepartamentoModel>> findAll(){
        List<DepartamentoModel> departamentos = departamentoService.findAll();

        return ResponseEntity.ok().body(departamentos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartamentoModel> findById(@PathVariable Long id){
        DepartamentoModel departamento = departamentoService.findById(id);

        return ResponseEntity.ok().body(departamento);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        departamentoService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
