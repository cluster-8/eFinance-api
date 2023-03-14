package com.cluster8.c8.tarifa;

import java.sql.Date;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tarifas")
@Data
public class TarifaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    UUID id;

    UUID servicoId;
    UUID instituicaoId;
    String moeda;
    String unidade;
    String periodicidade;
    Float valorMaximo;
    Date dataVigencia;
    Date createdAt;
}
