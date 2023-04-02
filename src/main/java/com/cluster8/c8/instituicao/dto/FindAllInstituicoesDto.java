package com.cluster8.c8.instituicao.dto;

import java.io.Serializable;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class FindAllInstituicoesDto implements Serializable {
  UUID id;
  String nome;
  String cnpjFormatado;
}
