package br.edu.famper.projeto.controller;


import br.edu.famper.projeto.model.Projeto;
import br.edu.famper.projeto.service.ProjetoService;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/projetos")
public class ProjetoController {
    @Autowired
    private ProjetoService projetoService;

    @GetMapping
    public ResponseEntity<List<Projeto>> findAll(){
        return ResponseEntity.status(HttpStatus.OK)
                .body(projetoService.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Projeto>> findById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK)
                .body(projetoService.findById(id));
    }

    @PutMapping
    public ResponseEntity<Projeto> update(@RequestBody Projeto projeto){
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(projetoService.salvar(projeto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        projetoService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping
    public ResponseEntity<Projeto> save(@RequestBody Projeto projeto){
        return ResponseEntity.status(HttpStatus.CREATED).body(projetoService.salvar(projeto));
    }


}
