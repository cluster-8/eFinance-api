package com.cluster8.c8.tarifa.dto;

import java.io.Serializable;
import java.sql.Date;
import java.util.UUID;

import com.cluster8.c8.instituicao.InstituicaoEntity;

import lombok.Getter;

@Getter
public class FindTarifasTop5ByServico implements Serializable {
  UUID id;
  String moeda;
  String unidade;
  String periodicidade;
  Float valorMaximo;
  Date dataVigencia;

  InstituicaoEntity instituicao;

  public FindTarifasTop5ByServico(UUID id, String moeda, String unidade, String periodicidade, Float valorMaximo,
      Date dataVigencia, UUID instId, String instNome, String instCnpj) {
    this.id = id;
    this.moeda = moeda;
    this.unidade = unidade;
    this.periodicidade = periodicidade;
    this.valorMaximo = valorMaximo;
    this.dataVigencia = dataVigencia;
    this.instituicao = new InstituicaoEntity(instId, instNome, instCnpj);
  }
}
