package com.basis.srs.web.rest;

import com.basis.srs.servico.SalaServico;
import com.basis.srs.servico.dto.SalaDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api/salas")
@RequiredArgsConstructor
public class SalaRecurso {

    private final SalaServico salaServico;

    @GetMapping
    public ResponseEntity<List<SalaDTO>> listar() {
        return ResponseEntity.ok(salaServico.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SalaDTO> obterPorId(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(salaServico.obterPorId(id));
    }

    @PostMapping
    public ResponseEntity<SalaDTO> salvar(@RequestBody SalaDTO salaDTO) throws URISyntaxException {
        SalaDTO dto = salaServico.salvar(salaDTO);
        return ResponseEntity.created(new URI("/api/salas/")).body(dto);
    }

    @PutMapping
    public ResponseEntity<SalaDTO> editar(@RequestBody SalaDTO salaDTO) {
        SalaDTO dto = salaServico.salvar(salaDTO);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable("id") Integer id) {
        salaServico.remover(id);
        return ResponseEntity.ok().build();
    }
}
