package com.cluster8.c8.instituicao;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.cluster8.c8.exceptions.NotFoundException;

@RestController
public class InstituicaoController {

  @Autowired
  private InstituicaoService service;

  @GetMapping("/instituicoes")
  public Optional<InstituicaoEntity> findTarifasByInstituicao(@RequestParam UUID id) {
    try {
      return this.service.instituicaoFindById(id);
    } catch (NotFoundException e) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
    } catch (Exception e) {
      throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
    }
  }
}
