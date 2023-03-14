package com.cluster8.c8.tarifa;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarifaRepository extends JpaRepository<TarifaEntity, UUID> {
  List<TarifaEntity> findByInstituicaoId(UUID instituicaoId);

  List<TarifaEntity> findByServicoId(UUID servicoId);
}
