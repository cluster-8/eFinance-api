package com.cluster8.c8.servico;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicoRepository extends JpaRepository<ServicoEntity, UUID> {

  Optional<ServicoEntity> findById(UUID id);

  List<ServicoEntity> findAll();
}
