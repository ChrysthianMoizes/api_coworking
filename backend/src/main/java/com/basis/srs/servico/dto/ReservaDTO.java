package com.basis.srs.servico.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ReservaDTO {

    private Integer id;
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;
    private Double total;
    private Integer idSala;
    private Integer idCliente;


}
