package com.basis.srs.dominio;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "sala_equipamento")
public class SalaEquipamento implements Serializable {

    @EmbeddedId
    private SalaEquipamentoPK id;

    @Column(name = "quantidade")
    private Integer quantidade;

    @MapsId("idSala")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_sala")
    private Sala sala;

    @MapsId("idEquipamento")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_equipamento", referencedColumnName = "id")
    private Equipamento equipamento;


}
