package br.com.contabilibili.infrastructure.persistence.impl;

import br.com.contabilibili.domain.model.Cartorio;
import br.com.contabilibili.domain.repository.CartorioRepository;
import br.com.contabilibili.infrastructure.persistence.jpa.CartorioJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CartorioRepositoryImpl implements CartorioRepository {

    private final CartorioJpaRepository jpaRepository;

    @Override
    public Cartorio save(Cartorio cartorio) {
        return jpaRepository.save(cartorio);
    }

    @Override
    public Optional<Cartorio> findById(Long id) {
        return jpaRepository.findById(id);
    }
}