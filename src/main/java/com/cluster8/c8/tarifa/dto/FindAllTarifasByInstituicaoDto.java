package com.cluster8.c8.tarifa.dto;

import java.io.Serializable;
import java.sql.Date;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class FindAllTarifasByInstituicaoDto implements Serializable {
  UUID id;
  String moeda;
  String unidade;
  String periodicidade;
  Float valorMaximo;
  Date dataVigencia;

  FindAllTarifasByInstituicaoServicoNomeDto servico;

  public FindAllTarifasByInstituicaoDto(UUID id, String moeda, String unidade, String periodicidade, Float valorMaximo,
      Date dataVigencia, UUID servicoId, String servicoNome) {
    this.id = id;
    this.moeda = moeda;
    this.unidade = unidade;
    this.periodicidade = periodicidade;
    this.valorMaximo = valorMaximo;
    this.dataVigencia = dataVigencia;
    this.servico = new FindAllTarifasByInstituicaoServicoNomeDto(servicoId, servicoNome);
  }
}

@AllArgsConstructor
@Getter
class FindAllTarifasByInstituicaoServicoNomeDto implements Serializable {
  UUID id;
  String nome;
}
