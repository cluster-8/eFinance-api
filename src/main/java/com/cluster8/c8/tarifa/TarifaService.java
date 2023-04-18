package com.cluster8.c8.tarifa;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.cluster8.c8.exceptions.NotFoundException;
import com.cluster8.c8.tarifa.dto.FindAllTarifasByInstituicaoDto;
import com.cluster8.c8.tarifa.dto.FindTarifasTop5ByServico;

@Service
public class TarifaService {

    @Autowired
    private TarifaRepository repo;

    @Cacheable(cacheNames = "TarifaService-tarifasFindAllByInstituicaoAndServicoTipo", key = "{ #id, #tipo }")
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

    @Cacheable(cacheNames = "TarifaService-tarifasTop5ByServico", key = "{ #id, #dataFim, #order, #page, #limit }")
    public List<FindTarifasTop5ByServico> findTarifasTop5ByServico(UUID id, Date dataFim, String order, Integer limit,
            Integer page)
            throws Exception {

        List<FindTarifasTop5ByServico> tarifas;

        PageRequest pageRequest = PageRequest.of(
                page,
                limit,
                order.equals("asc") ? Sort.Direction.ASC : Sort.Direction.DESC, "valorMaximo");

        tarifas = repo.findTarifasTop5ByServico(id, dataFim, pageRequest);

        if (tarifas.isEmpty()) {
            throw new NotFoundException("Tarifas não encontradas para serviço informado");
        }

        return tarifas;
    }
}
