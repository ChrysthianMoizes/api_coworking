package com.basis.srs.servico;

import com.basis.srs.dominio.Cliente;
import com.basis.srs.repositorio.ClienteRepositorio;
import com.basis.srs.servico.dto.ClienteDTO;
import com.basis.srs.servico.mapper.ClienteMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ClienteServico {

    private final ClienteRepositorio clienteRepositorio;
    private final ClienteMapper clienteMapper;

    public List<ClienteDTO> listar() {
        return clienteMapper.toDto(clienteRepositorio.findAll());
    }

    public ClienteDTO obterPorId(Integer id) {
        Cliente cliente = clienteRepositorio.findById(id).orElse(null);
        return clienteMapper.toDto(cliente);
    }

    public ClienteDTO salvar(ClienteDTO clienteDTO) {
        Cliente cliente = clienteMapper.toEntity(clienteDTO);
        Cliente clienteSalvo = clienteRepositorio.save(cliente);
        return clienteMapper.toDto(clienteSalvo);
    }

    public void remover(Integer id) {
        clienteRepositorio.deleteById(id);
    }
}
