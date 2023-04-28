package com.cluster8.c8.score;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScoreRepository extends PagingAndSortingRepository<ScoreEntity, UUID> {

  // @Query("select distinct s.instituicao.id, s from ScoreEntity as s")
  @Query("select s from ScoreEntity as s")
  List<ScoreEntity> findAllWithPageAndSort(PageRequest pageRequest);
}
