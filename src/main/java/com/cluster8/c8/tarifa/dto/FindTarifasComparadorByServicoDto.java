package com.cluster8.c8.tarifa.dto;

import java.io.Serializable;
import java.sql.Date;
import java.util.UUID;

import lombok.Getter;

@Getter
public class FindTarifasComparadorByServicoDto implements Serializable {
  UUID id;
  String moeda;
  String unidade;
  String periodicidade;
  Float valorMaximo;
  Date dataVigencia;

  UUID servicoId;
  UUID instituicaoId;

  public FindTarifasComparadorByServicoDto(UUID id, String moeda, String unidade, String periodicidade,
      Float valorMaximo,
      Date dataVigencia, UUID instId, UUID servId) {
    this.id = id;
    this.moeda = moeda;
    this.unidade = unidade;
    this.periodicidade = periodicidade;
    this.valorMaximo = valorMaximo;
    this.dataVigencia = dataVigencia;
    this.servicoId = servId;
    this.instituicaoId = instId;
  }
}
