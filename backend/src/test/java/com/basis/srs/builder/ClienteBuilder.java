package com.basis.srs.builder;

import com.basis.srs.dominio.Cliente;
import com.basis.srs.repositorio.ClienteRepositorio;
import com.basis.srs.servico.ClienteServico;
import com.basis.srs.servico.dto.ClienteDTO;
import com.basis.srs.servico.mapper.ClienteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Component
public class ClienteBuilder extends ConstrutorDeEntidade<Cliente>{

    @Autowired
    private ClienteServico clienteServico;

    @Autowired
    private ClienteRepositorio clienteRepositorio;

    @Autowired
    private ClienteMapper clienteMapper;

    @Override
    public Cliente construirEntidade() throws ParseException {
        Cliente cliente = new Cliente();
        cliente.setCpf("12345678901");
        cliente.setDataNascimento(LocalDate.now());
        cliente.setEmail("teste@gmail.com");
        cliente.setNome("Teste salvar");
        cliente.setEndereco("Rua 2");
        cliente.setRg("1234567");

        return cliente;
    }

    public ClienteDTO converterToDto(Cliente cliente) {
        return clienteMapper.toDto(cliente);
    }

    @Override
    protected Cliente persistir(Cliente entidade) {
        ClienteDTO dto = clienteServico.salvar(clienteMapper.toDto(entidade));
        return clienteMapper.toEntity(dto);
    }

    @Override
    protected Collection<Cliente> obterTodos() {
        return clienteRepositorio.findAll();
    }

    @Override
    protected Cliente obterPorId(Long id) {
        return null;
    }

    public void limparBanco() {
        clienteRepositorio.deleteAll();
    }
}
