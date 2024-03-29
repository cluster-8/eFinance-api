package com.cluster8.c8.tarifa;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.cluster8.c8.exceptions.NotFoundException;
import com.cluster8.c8.tarifa.dto.FindAllTarifasByInstituicaoDto;
import com.cluster8.c8.tarifa.dto.FindTarifasComparadorByServicoDto;
import com.cluster8.c8.tarifa.dto.FindTarifasTop5ByServico;
import com.cluster8.c8.tarifa.dto.TarifaComparadorInstituicoesAndTarifaDto;
import com.cluster8.c8.tarifa.dto.TarifasComparadorByServicoDto;

import jakarta.servlet.http.HttpServletResponse;

@Service
public class TarifaService {

    @Autowired
    private TarifaRepository repo;

    @Autowired
    private HttpServletResponse  response;


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

    public List<FindTarifasTop5ByServico> findTarifasTop5ByServico(UUID id, Date dataFim, String order, Integer limit,
            Integer page)
            throws Exception {

        Page<FindTarifasTop5ByServico> tarifas;

        PageRequest pageRequest = PageRequest.of(
                page,
                limit,
                order.equals("asc") ? Sort.Direction.ASC : Sort.Direction.DESC, "valorMaximo");

        tarifas = repo.findTarifasTop5ByServico(id, dataFim, pageRequest);

        if (tarifas.isEmpty()) {
            throw new NotFoundException("Tarifas não encontradas para serviço informado");
        }

        Long total = tarifas.getTotalElements();

        this.response.addHeader("total", total.toString()); 

        return tarifas.toList();
    }

    public List<TarifasComparadorByServicoDto> tarifasComparadorByServico(List<UUID> instituicoesIds,
            List<UUID> servicosIds) throws Exception {
        List<FindTarifasComparadorByServicoDto> tarifas = new ArrayList<>();

        instituicoesIds.forEach(instId -> {
            servicosIds.forEach(servicoId -> {
                Optional<FindTarifasComparadorByServicoDto> tarifa = repo.findTarifasComparadorByServico(instId,
                        servicoId);

                if (tarifa.isPresent()) {
                    tarifas.add(tarifa.get());
                }
            });
        });

        // if (tarifas.isEmpty()) {
        //     throw new NotFoundException("Tarifas não encontradas para serviço informado");
        // }

        List<TarifasComparadorByServicoDto> result = new ArrayList<>();

        servicosIds.forEach(servicoId -> {
            TarifasComparadorByServicoDto servicoDto = new TarifasComparadorByServicoDto();

            servicoDto.setServicoId(servicoId);

            result.add(servicoDto);
        });

        tarifas.forEach(tarifa -> {
            TarifasComparadorByServicoDto servico = result.stream()
                    .filter(v -> v.getServicoId().equals(tarifa.getServicoId())).findFirst().orElse(null);


            TarifaComparadorInstituicoesAndTarifaDto instituicao = new TarifaComparadorInstituicoesAndTarifaDto(
                    tarifa.getInstituicaoId(), tarifa.getValorMaximo(), tarifa.getMoeda(), tarifa.getUnidade(),
                    tarifa.getDataVigencia());

            servico.addInstituicao(instituicao);
        });

        return result;
    }
}
