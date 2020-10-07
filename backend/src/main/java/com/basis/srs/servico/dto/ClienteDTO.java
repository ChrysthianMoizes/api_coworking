package com.basis.srs.servico.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Getter
@Setter
public class ClienteDTO {

    private Integer id;

    @NotNull
    @Size(max = 120)
    private String nome;

    @NotNull
    @Size(max = 11, min = 11)
    private String cpf;

    @NotNull
    @Size(min = 7, max = 7)
    private String rg;

    @Email
    @Size(max = 255)
    private String email;

    @NotNull
    private String endereco;

    @NotNull
    private LocalDate dataNascimento;
}
