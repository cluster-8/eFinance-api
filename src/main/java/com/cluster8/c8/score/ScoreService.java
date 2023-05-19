package com.cluster8.c8.score;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpServletResponse;

@Service
public class ScoreService {

    @Autowired
    private ScoreRepository repo;

    @Autowired
    private HttpServletResponse  response;

    // @Cacheable(cacheNames = "ServicoService", key = "{ #root.method.name, #page, #limit, #order, #orderField }")
    public List<ScoreEntity> findAll(Integer page, Integer limit, String order, String orderField) {
        Sort sort = Sort.by(
                order.equals("asc") ? Sort.Order.asc(orderField) : Sort.Order.desc(orderField)
        // , Sort.Order.desc("createdAt")
        );

        PageRequest pageRequest = PageRequest.of(
                page,
                limit,
                sort);

        Page<ScoreEntity> tarifas =  repo.findAllWithPageAndSort(pageRequest);
        
        Long total = tarifas.getTotalElements();

        this.response.addHeader("total", total.toString()); 

        return tarifas.toList();
    }
}
