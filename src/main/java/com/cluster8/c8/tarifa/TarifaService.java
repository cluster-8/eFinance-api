package com.cluster8.c8.tarifa;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class TarifaService {

    @Autowired
    private TarifaRepository repo;

    public List<TarifaEntity> tarifasFindAllByInstituicao(UUID id) {
        List<TarifaEntity> tarifas = repo.findByInstituicaoId(id);

        if (tarifas.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Tarifas não encontradas para instituição informada");
        }

        return tarifas;
    }
}
