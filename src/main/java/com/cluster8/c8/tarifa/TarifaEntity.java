package com.cluster8.c8.tarifa;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.UUID;

import com.cluster8.c8.instituicao.InstituicaoEntity;
import com.cluster8.c8.servico.ServicoEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tarifas")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TarifaEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    UUID id;

    String moeda;
    String unidade;
    String periodicidade;
    Float valorMaximo;
    Date dataVigencia;
    Timestamp createdAt;

    @ManyToOne()
    @JoinColumn(name = "servico_id")
    @JsonBackReference
    ServicoEntity servico;

    @ManyToOne()
    @JoinColumn(name = "instituicao_id")
    @JsonBackReference
    InstituicaoEntity instituicao;

}
