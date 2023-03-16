package com.cluster8.c8.tarifa;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.cluster8.c8.exceptions.NotFoundException;

@RestController
public class TarifaController {

  @Autowired
  private TarifaService service;

  @GetMapping("/instituicao/tarifas")
  public List<TarifaEntity> tarifasFindAllByInstituicao(@RequestParam UUID id) {
    try {
      return this.service.tarifasFindAllByInstituicao(id);
    } catch (NotFoundException e) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
    } catch (Exception e) {
      throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
    }
  }
}
