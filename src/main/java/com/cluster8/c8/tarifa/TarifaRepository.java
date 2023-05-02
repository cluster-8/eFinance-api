package com.cluster8.c8.tarifa;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.cluster8.c8.tarifa.dto.FindAllTarifasByInstituicaoDto;
import com.cluster8.c8.tarifa.dto.FindTarifasComparadorByServicoDto;
import com.cluster8.c8.tarifa.dto.FindTarifasTop5ByServico;
import com.cluster8.c8.tarifa.dto.TarifasComparadorByServicoDto;

@Repository
public interface TarifaRepository extends PagingAndSortingRepository<TarifaEntity, UUID> {
  Optional<TarifaEntity> findById(UUID id);

  @Query("select new com.cluster8.c8.tarifa.dto.FindAllTarifasByInstituicaoDto(t.id, t.moeda, t.unidade, t.periodicidade, t.valorMaximo, t.valorMinimo, t.dataVigencia, s.id, s.nome) from TarifaEntity as t join ServicoEntity as s on s.id = t.servico where t.instituicao.id=:instituicaoId")
  List<FindAllTarifasByInstituicaoDto> findByInstituicaoId(UUID instituicaoId);

  @Query("select new com.cluster8.c8.tarifa.dto.FindAllTarifasByInstituicaoDto(t.id, t.moeda, t.unidade, t.periodicidade, t.valorMaximo, t.valorMinimo, t.dataVigencia, s.id, s.nome) from TarifaEntity as t join ServicoEntity as s on s.id = t.servico where t.instituicao.id=:instituicaoId and s.tipo=:tipo")
  List<FindAllTarifasByInstituicaoDto> findByInstituicaoIdAndServicoTipo(UUID instituicaoId, String tipo);

  @Query("select new com.cluster8.c8.tarifa.dto.FindTarifasTop5ByServico(t.id, t.moeda, t.unidade, t.periodicidade, t.valorMaximo, t.dataVigencia, i.id, i.nome, i.cnpj) from TarifaEntity as t join InstituicaoEntity as i on i.id = t.instituicao.id where t.dataVigencia <= :dataFim and t.servico.id = :servicoId")
  List<FindTarifasTop5ByServico> findTarifasTop5ByServico(UUID servicoId, Date dataFim, PageRequest pageRequest);

  @Query("select new com.cluster8.c8.tarifa.dto.FindTarifasComparadorByServicoDto(t.id, t.moeda, t.unidade, t.periodicidade, t.valorMaximo, t.dataVigencia, t.instituicao.id, t.servico.id) from TarifaEntity as t where t.instituicao.id = :instId and t.servico.id = :servId order by t.dataVigencia desc limit 1")
  Optional<FindTarifasComparadorByServicoDto> findTarifasComparadorByServico(UUID instId, UUID servId);
}
