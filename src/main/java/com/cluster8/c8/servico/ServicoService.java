package com.cluster8.c8.servico;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.cluster8.c8.exceptions.NotFoundException;

@Service
public class ServicoService {

    @Autowired
    private ServicoRepository repo;

    @Cacheable(cacheNames = "ServicoService", key = "#id")
    public Optional<ServicoEntity> findById(UUID id) throws Exception {
        Optional<ServicoEntity> servico = repo.findById(id);

        if (servico.isEmpty()) {
            throw new NotFoundException("Servico não encontrado");
        }

        return servico;
    }

    @Cacheable(cacheNames = "ServicoService", key = "#root.method.name")
    public List<ServicoEntity> findAll() {
        return repo.findAll();
    }
}
