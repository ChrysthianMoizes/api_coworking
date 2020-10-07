package com.basis.srs.servico;

import com.basis.srs.dominio.Equipamento;
import com.basis.srs.repositorio.EquipamentoRepositorio;
import com.basis.srs.servico.dto.EquipamentoDTO;
import com.basis.srs.servico.mapper.EquipamentoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
@Transactional
public class EquipamentoServico {

    private final EquipamentoRepositorio equipamentoRepositorio;
    private final EquipamentoMapper equipamentoMapper;

    public List<EquipamentoDTO> listar() {
        return equipamentoMapper.toDto(equipamentoRepositorio.findAll());
    }

    public EquipamentoDTO obterPorId(Integer id) {
        Equipamento equipamento = equipamentoRepositorio.findById(id).orElse(null);
        return equipamentoMapper.toDto(equipamento);
    }

    public EquipamentoDTO salvar(EquipamentoDTO equipamentoDTO) {
        Equipamento equipamento = equipamentoMapper.toEntity(equipamentoDTO);
        Equipamento equipamentoSalvo = equipamentoRepositorio.save(equipamento);
        return equipamentoMapper.toDto(equipamentoSalvo);
    }

    public void remover(Integer id) {
        equipamentoRepositorio.deleteById(id);
    }
}
