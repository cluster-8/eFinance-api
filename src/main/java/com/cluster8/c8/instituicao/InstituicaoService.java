package com.cluster8.c8.instituicao;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cluster8.c8.exceptions.NotFoundException;

@Service
public class InstituicaoService {

    @Autowired
    private InstituicaoRepository repo;

    public Optional<InstituicaoEntity> instituicaoFindById(UUID id) throws Exception {
        Optional<InstituicaoEntity> instituicao = repo.findById(id);

        if (instituicao.isEmpty()) {
            throw new NotFoundException("Instituição não encontrada");
        }

        return instituicao;
    }
}
