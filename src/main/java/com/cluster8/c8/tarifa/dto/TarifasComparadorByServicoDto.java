package com.cluster8.c8.tarifa.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TarifasComparadorByServicoDto implements Serializable {
  UUID servicoId;

  List<TarifaComparadorInstituicoesAndTarifaDto> instituicoes = new ArrayList<TarifaComparadorInstituicoesAndTarifaDto>();

  public void addInstituicao(TarifaComparadorInstituicoesAndTarifaDto instituicao) {
    instituicoes.add(instituicao);
  }
}
