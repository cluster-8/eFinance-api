package com.cluster8.c8.tarifa.dto;

import java.io.Serializable;
import java.sql.Date;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TarifaComparadorInstituicoesAndTarifaDto implements Serializable {
  UUID instituicaoId;

  Float valorMaximo;
  String moeda;
  String unidade;
  Date dataVigencia;
}
