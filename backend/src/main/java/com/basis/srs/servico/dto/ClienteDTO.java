package com.basis.srs.servico.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ClienteDTO {

    private Integer id;
    private String nome;
    private String cpf;
    private String rg;
    private String email;
    private String endereco;
    private LocalDate dataNascimento;
}
