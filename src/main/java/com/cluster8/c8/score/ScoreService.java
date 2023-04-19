package com.cluster8.c8.score;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ScoreService {

    @Autowired
    private ScoreRepository repo;

    @Cacheable(cacheNames = "ServicoService", key = "{ #root.method.name, #page, #limit, #order, #orderField }")
    public List<ScoreEntity> findAll(Integer page, Integer limit, String order, String orderField) {
        PageRequest pageRequest = PageRequest.of(
                page,
                limit,
                order.equals("asc") ? Sort.Direction.ASC : Sort.Direction.DESC, orderField);

        return repo.findAllWithPageAndSort(pageRequest);
    }
}
