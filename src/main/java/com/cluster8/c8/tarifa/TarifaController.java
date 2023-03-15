package com.cluster8.c8.tarifa;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TarifaController {

  @Autowired
  private TarifaService service;

  @GetMapping("/instituicao/tarifas")
  public List<TarifaEntity> tarifasFindAllByInstituicao(@RequestParam UUID id) {
    return this.service.tarifasFindAllByInstituicao(id);
  }
}
