package com.cluster8.c8.tarifa;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.cluster8.c8.exceptions.NotFoundException;
import com.cluster8.c8.tarifa.dto.FindAllTarifasByInstituicaoDto;

@Service
public class TarifaService {

    @Autowired
    private TarifaRepository repo;

    @Cacheable(cacheNames = "TarifaService", key = "{ #id, #tipo }")
    public List<FindAllTarifasByInstituicaoDto> tarifasFindAllByInstituicaoAndServicoTipo(UUID id,
            String tipo)
            throws Exception {

        List<FindAllTarifasByInstituicaoDto> tarifas;

        if (tipo == null) {
            tarifas = repo.findByInstituicaoId(id);
        } else {
            tarifas = repo.findByInstituicaoIdAndServicoTipo(id, tipo);
        }

        if (tarifas.isEmpty()) {
            throw new NotFoundException("Tarifas não encontradas para instituição informada");
        }

        return tarifas;
    }
}
