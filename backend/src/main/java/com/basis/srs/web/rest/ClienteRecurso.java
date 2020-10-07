package com.basis.srs.web.rest;

import com.basis.srs.servico.ClienteServico;
import com.basis.srs.servico.dto.ClienteDTO;
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

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api/clientes")
@RequiredArgsConstructor
public class ClienteRecurso {

    private final ClienteServico clienteServico;

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> listar() {
        return ResponseEntity.ok(clienteServico.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> obterPorId(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(clienteServico.obterPorId(id));
    }

    @PostMapping
    public ResponseEntity<ClienteDTO> salvar(@Valid @RequestBody ClienteDTO clienteDTO) throws URISyntaxException {
        ClienteDTO dto = clienteServico.salvar(clienteDTO);
        return ResponseEntity.created(new URI("/api/clientes/")).body(dto);
    }

    @PutMapping
    public ResponseEntity<ClienteDTO> editar(@Valid @RequestBody ClienteDTO clienteDTO) {
        ClienteDTO dto = clienteServico.salvar(clienteDTO);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable("id") Integer id) {
        clienteServico.remover(id);
        return ResponseEntity.ok().build();
    }

}
