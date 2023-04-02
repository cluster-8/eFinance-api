package com.cluster8.c8.instituicao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.cluster8.c8.exceptions.NotFoundException;
import com.cluster8.c8.instituicao.dto.FindAllInstituicoesDto;

@Service
public class InstituicaoService {

    @Autowired
    private InstituicaoRepository repo;

    @Cacheable(cacheNames = "InstituicaoService", key = "#id")
    public Optional<InstituicaoEntity> instituicaoFindById(UUID id) throws Exception {
        Optional<InstituicaoEntity> instituicao = repo.findById(id);

        if (instituicao.isEmpty()) {
            throw new NotFoundException("Instituição não encontrada");
        }

        return instituicao;
    }

    @Cacheable(cacheNames = "InstituicaoService", key = "#root.method.name")
    public List<FindAllInstituicoesDto> instituicaoFindAll() {
        return repo.findAllInstituicoes();
    }
}
