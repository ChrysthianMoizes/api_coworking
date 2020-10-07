package com.basis.srs.dominio;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Setter
@Embeddable
public class SalaEquipamentoPK implements Serializable {

    private Integer idSala;

    private Integer idEquipamento;

}
