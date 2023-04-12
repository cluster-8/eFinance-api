package com.cluster8.c8.servico;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

import com.cluster8.c8.tarifa.TarifaEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "servicos")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@RequiredArgsConstructor
@Getter
@Setter
public class ServicoEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    UUID id;

    String nome;
    String codigo;
    String tipo;
    Timestamp createdAt;

    @OneToMany(mappedBy = "servico")
    // @JsonManagedReference
    @JsonIgnore
    List<TarifaEntity> tarifas;
}
