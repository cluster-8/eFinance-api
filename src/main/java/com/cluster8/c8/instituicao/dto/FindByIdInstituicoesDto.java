package com.cluster8.c8.instituicao.dto;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class FindByIdInstituicoesDto implements Serializable {
  UUID id;
  String nome;
  String cnpj;
  String cnpjFormatado;
  Timestamp createdAt;
}
