package com.cluster8.c8.score;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class ScoreController {

  @Autowired
  private ScoreService service;

  @GetMapping("/scores")
  public List<ScoreEntity> findAll(@RequestParam(required = false, defaultValue = "20") Integer limit,
      @RequestParam(required = false, defaultValue = "1") Integer page,
      @RequestParam(required = false, defaultValue = "asc") String order,
      @RequestParam(required = false, defaultValue = "scoreTtl") String orderField) {
    try {
      return this.service.findAll(page, limit, order, orderField);
    } catch (Exception e) {
      throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
    }
  }

}
