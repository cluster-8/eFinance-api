package com.cluster8.c8.instituicao;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstituicaoRepository extends JpaRepository<InstituicaoEntity, UUID> {
  Optional<InstituicaoEntity> findById(UUID id);
}
