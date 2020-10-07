package com.basis.srs.dominio;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "equipamento")
public class Equipamento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_equipamento")
    @SequenceGenerator(name = "sq_equipamento", allocationSize = 1, sequenceName = "sq_equipamento")
    @Column(name = "id")
    private Integer id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "preco_diario")
    private Double preco;

    @Column(name = "obrigatorio")
    private Integer obrigatorio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_equipamento")
    private TipoEquipamento tipoEquipamento;

}
