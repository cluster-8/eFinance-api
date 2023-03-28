package com.cluster8.c8.instituicao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.cluster8.c8.exceptions.NotFoundException;
import com.cluster8.c8.instituicao.dto.FindAllInstituicoesDto;

@RestController
public class InstituicaoController {

  @Autowired
  private InstituicaoService service;

  @GetMapping("/instituicoes")
  public List<FindAllInstituicoesDto> instituicaoFindAll() {
    try {
      return this.service.instituicaoFindAll();
    } catch (Exception e) {
      throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
    }
  }

  @GetMapping("/instituicoes/{id}")
  public Optional<InstituicaoEntity> instituicaoFindById(@PathVariable UUID id) {
    try {
      return this.service.instituicaoFindById(id);
    } catch (NotFoundException e) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
    } catch (Exception e) {
      throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
    }
  }
}
