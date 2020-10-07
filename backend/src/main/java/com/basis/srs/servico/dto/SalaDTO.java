package com.basis.srs.servico.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SalaDTO {

    private Integer id;
    private String descricao;
    private Double preco;
    private Integer capacidade;
    private Integer disponivel;
    private Integer idTipoSala;
    private List<SalaEquipamentoDTO> equipamentos;
}
