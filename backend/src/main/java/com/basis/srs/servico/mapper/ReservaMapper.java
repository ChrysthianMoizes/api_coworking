package com.basis.srs.servico.mapper;

import com.basis.srs.dominio.Cliente;
import com.basis.srs.dominio.Reserva;
import com.basis.srs.dominio.Sala;
import com.basis.srs.servico.dto.ClienteDTO;
import com.basis.srs.servico.dto.ReservaDTO;
import com.basis.srs.servico.dto.SalaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {})
public interface ReservaMapper extends EntityMapper<ReservaDTO, Reserva>{

    @Override
    @Mapping(source = "idSala", target = "sala.id")
    @Mapping(source = "idCliente", target = "cliente.id")
    Reserva toEntity(ReservaDTO dto);

    @Override
    @Mapping(target = "idSala", source = "sala.id")
    @Mapping(target = "idCliente", source = "cliente.id")
    ReservaDTO toDto(Reserva Reserva);





}
