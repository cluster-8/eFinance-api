package com.cluster8.c8.instituicao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cluster8.c8.instituicao.dto.FindAllInstituicoesDto;

@Repository
public interface InstituicaoRepository extends JpaRepository<InstituicaoEntity, UUID> {
  @Query("select new com.cluster8.c8.instituicao.dto.FindByIdInstituicoesDto(i.id, i.nome, i.cnpj, i.cnpjFormatado, i.createdAt) from InstituicaoEntity i where id=:id")
  Optional<InstituicaoEntity> findById(UUID id);

  @Query("select new com.cluster8.c8.instituicao.dto.FindAllInstituicoesDto(i.id, i.nome, i.cnpjFormatado) from InstituicaoEntity as i")
  List<FindAllInstituicoesDto> findAllInstituicoes();
}
