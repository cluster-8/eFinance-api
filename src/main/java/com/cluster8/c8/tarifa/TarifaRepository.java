package com.cluster8.c8.tarifa;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cluster8.c8.tarifa.dto.FindAllTarifasByInstituicaoDto;

@Repository
public interface TarifaRepository extends JpaRepository<TarifaEntity, UUID> {
  Optional<TarifaEntity> findById(UUID id);

  @Query("select new com.cluster8.c8.tarifa.dto.FindAllTarifasByInstituicaoDto(t.id, t.moeda, t.unidade, t.periodicidade, t.valorMaximo, t.dataVigencia, s.id, s.nome) from TarifaEntity as t join ServicoEntity as s on s.id = t.servico where t.instituicao.id=:instituicaoId")
  List<FindAllTarifasByInstituicaoDto> findByInstituicaoId(UUID instituicaoId);

  @Query("select new com.cluster8.c8.tarifa.dto.FindAllTarifasByInstituicaoDto(t.id, t.moeda, t.unidade, t.periodicidade, t.valorMaximo, t.dataVigencia, s.id, s.nome) from TarifaEntity as t join ServicoEntity as s on s.id = t.servico where t.instituicao.id=:instituicaoId and s.tipo=:tipo")
  List<FindAllTarifasByInstituicaoDto> findByInstituicaoIdAndServicoTipo(UUID instituicaoId, String tipo);

}
