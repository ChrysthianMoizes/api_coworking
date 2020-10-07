package com.basis.srs.servico;

import com.basis.srs.dominio.Reserva;
import com.basis.srs.repositorio.ReservaRepositorio;
import com.basis.srs.servico.dto.ReservaDTO;
import com.basis.srs.servico.mapper.ReservaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ReservaServico {
    private final ReservaRepositorio reservaRepositorio;
    private final ReservaMapper reservaMapper;

    public List<ReservaDTO> listar() {
        return reservaMapper.toDto(reservaRepositorio.findAll());
    }

    public ReservaDTO obterPorId(Integer id) {
        Reserva reserva = reservaRepositorio.findById(id).orElse(null);
        return reservaMapper.toDto(reserva);
    }

    public ReservaDTO salvar(ReservaDTO reservaDTO) {
        Reserva reserva = reservaMapper.toEntity(reservaDTO);
        Reserva reservaSalvo = reservaRepositorio.save(reserva);
        return reservaMapper.toDto(reservaSalvo);
    }

    public void remover(Integer id) {
        reservaRepositorio.deleteById(id);
    }
}
