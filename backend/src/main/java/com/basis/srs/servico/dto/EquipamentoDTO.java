package com.basis.srs.servico.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EquipamentoDTO {

    private Integer id;
    private String nome;
    private Double preco;
    private Integer obrigatorio;
    private Integer idTipoEquipamento;

}
