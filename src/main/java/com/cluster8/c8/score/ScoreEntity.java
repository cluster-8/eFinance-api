package com.cluster8.c8.score;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.UUID;

import com.cluster8.c8.instituicao.InstituicaoEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "scores")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@RequiredArgsConstructor
@Getter
@Setter
public class ScoreEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    UUID id;

    Float scorePf;
    Float scorePj;
    Float scoreTtl;
    Timestamp createdAt;

    @OneToOne()
    InstituicaoEntity instituicao;
}
