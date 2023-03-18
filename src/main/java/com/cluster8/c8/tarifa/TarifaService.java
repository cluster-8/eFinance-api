package com.cluster8.c8.tarifa;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.cluster8.c8.exceptions.NotFoundException;

@Service
public class TarifaService {

    @Autowired
    private TarifaRepository repo;

    // @Cacheable(cacheNames = "TarifaService", key = "#id")
    public List<TarifaEntity> tarifasFindAllByInstituicao(UUID id) throws Exception {
        List<TarifaEntity> tarifas = repo.findByInstituicaoId(id);

        if (tarifas.isEmpty()) {
            throw new NotFoundException("Tarifas não encontradas para instituição informada");
        }

        return tarifas;
    }
}
